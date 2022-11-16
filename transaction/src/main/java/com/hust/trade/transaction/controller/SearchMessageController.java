package com.hust.trade.transaction.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hust.trade.transaction.model.Message;
import com.hust.trade.transaction.service.MessageDetailService;
import com.hust.trade.transaction.service.MessageImagesService;
import com.hust.trade.transaction.service.UserService;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchMessageController {

  @Autowired
  private MessageDetailService messageDetailService;
  @Autowired
  private UserService userService;
  @Autowired
  private MessageImagesService messageImagesService;

  /**
   * 根据类别和关键字查找
   * @param categoryId 类别id
   * @param keyword 关键字
   * @return 返回符合的消息列表ß
   */
  @PostMapping("/search/{categoryId}/{keyword}")
  public List<Message> getMessageByCategoryAndKeyword(@PathVariable Long categoryId, @PathVariable String keyword) {
    List<Message> allMessage = messageDetailService.getMessageByCategoryAndKeyword(categoryId, keyword);
    return new GetMessageDetailController().getImage(allMessage, userService, messageImagesService);
  }

  /**
   * 根据关键字查找信息
   * @param keyword 关键字
   * @param pageNumber 页码
   * @return 查找到的消息
   */
  @PostMapping("/searchByKeyword/{keyword}/{pageNumber}")
  public List<Message> getMessageByCategoryAndKeyword(@PathVariable String keyword, @PathVariable Integer pageNumber) {

    PageHelper.startPage(pageNumber, 3);

    PageInfo<Message> pageInfo = new PageInfo<>(messageDetailService.getMessageByKeyword(keyword));

    if (pageInfo.getPageNum() < pageNumber) {
      List list1 = new LinkedList();
      list1.add(200);
      return list1;
    }

    List<Message> allMessage = pageInfo.getList();

    return new GetMessageDetailController().getImage(allMessage, userService, messageImagesService);

  }

}

