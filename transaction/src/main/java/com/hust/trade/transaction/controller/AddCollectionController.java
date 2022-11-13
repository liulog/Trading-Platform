package com.hust.trade.transaction.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hust.trade.transaction.model.Collect;
import com.hust.trade.transaction.model.Message;
import com.hust.trade.transaction.service.CollectService;
import com.hust.trade.transaction.service.MessageDetailService;
import com.hust.trade.transaction.service.MessageImagesService;
import com.hust.trade.transaction.service.UserService;
import com.hust.trade.transaction.utils.IsCollect;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddCollectionController {
  @Autowired
  private CollectService collectService;
  @Autowired
  private UserService userService;
  @Autowired
  private MessageImagesService messageImagesService;
  @Autowired
  private MessageDetailService messageDetailService;

  /**
   * 获取我的收藏
   * @param userId 用户id
   * @param pageNumber 页码
   * @return 消息的列表
   */
  @PostMapping("/getMessage/getAllCollectionMessageByUserId/{userId}/{pageNumber}")
  public List<Message> getAllCollectionMessageByUserId(@PathVariable Integer userId, @PathVariable Integer pageNumber) {
    PageHelper.startPage(pageNumber, 5);
    PageInfo<Collect> pageInfo = new PageInfo<>(collectService.getAllCollectionMessageByUserId(userId));

    if (pageInfo.getPageNum() < pageNumber) { //活到页面顶端后，返回200状态码
      List list1 = new LinkedList();
      list1.add(200);
      return list1;
    }

    List<Collect> list = pageInfo.getList();


    List<Message> list1 = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      Integer messageId = list.get(i).getMessageId();
      Message message = messageDetailService.getById(messageId);
      list1.add(message);
    }
    return new GetMessageDetailController().getImage(list1, userService, messageImagesService);
  }

  /**
   * 添加我的收藏
   * @param userId
   * @param messageId
   * @return
   */
  @Transactional
  @PostMapping("/addCollection/{userId}/{messageId}")
  public IsCollect addCollection(@PathVariable Integer userId, @PathVariable Integer messageId) {
    return new IsCollect().isTrue(userId, messageId, collectService, userService);
  }

  /**
   * 检查是否已被收藏
   * @param userId
   * @param messageId
   * @return
   */
  @PostMapping("/addCollection/checkIsCollection/{userId}/{messageId}")
  public Integer checkIsCollection(@PathVariable Integer userId, @PathVariable Integer messageId) {
    Collect collect = new Collect();
    collect.setUserId(userId);
    collect.setMessageId(messageId);
    return collectService.findCount(collect);
  }

  /**
   * 删除收藏的信息
   * @param userId
   * @param messageId
   * @return
   */
  @Transactional
  @PostMapping("/deleteCollection/{userId}/{messageId}")
  public Integer deleteCollection(@PathVariable Integer userId, @PathVariable Integer messageId) {
    Collect collect = new Collect();
    collect.setUserId(userId);
    collect.setMessageId(messageId);
    collectService.delete(collect);
    return 200;
  }
}