package com.hust.trade.transaction.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hust.trade.transaction.model.Attend;
import com.hust.trade.transaction.model.Message;
import com.hust.trade.transaction.service.AttendService;
import com.hust.trade.transaction.service.MessageDetailService;
import com.hust.trade.transaction.service.MessageImagesService;
import com.hust.trade.transaction.service.UserService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAttendMessageController {

  @Autowired
  private UserService userService;
  @Autowired
  private MessageDetailService messageDetailService;
  @Autowired
  private MessageImagesService messageImagesService;
  @Autowired
  private AttendService attendService;


  /**
   * 获取 “我的发布” 列表
   * @param userId 用户id
   * @param pageNumber 页数
   * @return 我的发布列表
   */
  @PostMapping("/getMessage/getAttendMessageByUserId/{userId}/{pageNumber}")
  public List<Message> getAttendMessageByUserId(@PathVariable Integer userId, @PathVariable Integer pageNumber) {
    PageHelper.startPage(pageNumber, 5);
    PageInfo<Attend> pageInfo = new PageInfo<Attend>(attendService.getAllAttendMessageByUserId(userId));

    if (pageInfo.getPageNum() < pageNumber) {
      List list1 = new LinkedList();
      list1.add(200);
      return list1;
    }
    List<Attend> list = pageInfo.getList();


    List<Message> list1 = new ArrayList<Message>();
    for (Attend attend : list) {
      Integer messageId = attend.getMessageId();
      Message message = messageDetailService.getById(messageId);
      list1.add(message);
    }
    return new GetMessageDetailController().getImage(list1, userService, messageImagesService);
  }
}
