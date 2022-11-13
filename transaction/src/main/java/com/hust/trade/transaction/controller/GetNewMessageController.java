package com.hust.trade.transaction.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hust.trade.transaction.model.NewMessage;
import com.hust.trade.transaction.model.User;
import com.hust.trade.transaction.service.NewMessageService;
import com.hust.trade.transaction.service.UserService;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetNewMessageController {


  @Autowired
  private UserService userService;
  @Autowired
  private NewMessageService newMessageService;

  /**
   * 获取全部 “我的消息”
   * @param userId 用户唯一标识
   * @param pageNumber 页码
   * @return 查到的新消息
   */
  @PostMapping("/getMessage/getAllNewMessage/{userId}/{pageNumber}")
  public List<NewMessage> getAllNewMessage(@PathVariable Integer userId, @PathVariable Integer pageNumber) {
    User user = userService.getById(userId);
    if (user == null) {
      return null;
    }
    PageHelper.startPage(pageNumber, 10);
    PageInfo<NewMessage> pageInfo = new PageInfo<NewMessage>(newMessageService.getAllNewMessage(userId));

    if (pageInfo.getPageNum() < pageNumber) {
      List list1 = new LinkedList();
      list1.add(200);
      return list1;
    }
    List<NewMessage> list = pageInfo.getList();
    return list;
  }

  /**
   * 查找最后一条新消息 “我的消息”
   * @param userId 用户id
   * @return 最后一条新消息
   */
  @PostMapping("/getMessage/getLastNewMessage/{userId}")
  public NewMessage getLastNewMessage(@PathVariable Integer userId) {

    if (userId == -1) {
      return null;
    }

    return newMessageService.getLastNewMessage(userId);

  }


}
