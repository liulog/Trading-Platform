package com.hust.trade.transaction.controller;

import com.hust.trade.transaction.model.NewMessage;
import com.hust.trade.transaction.model.User;
import com.hust.trade.transaction.service.NewMessageService;
import com.hust.trade.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddAdminReplyController {
  @Autowired
  private UserService userService;

  @Autowired
  private NewMessageService newMessageService;

  /**
   * 通过管理员发布 message
   * @param adminId 管理员id
   * @param messageId 消息id
   * @param messageUserId 消息所属userid
   * @param newMessageString 消息的内容
   * @return 状态码
   */
  @Transactional
  @PostMapping("/addNewMessageByAdmin/{adminId}/{messageId}/{messageUserId}")
  public Integer addNewMessageByAdmin(@PathVariable Long adminId, @PathVariable Long messageId, @PathVariable Long messageUserId, @RequestBody String newMessageString) {
    User admin = userService.getById(adminId);    // @PathVariable 请求http中解析出来的参数  @RequestBody 前端发送的json格式的请求体
    if (admin.getUserIsAdmin() != 2) {            // 错误的请求，不是管理员，不能添加message
      return 400;
    }
    NewMessage newMessage = new NewMessage();         //要发布的新消息
    newMessage.setNewMessageDetail(newMessageString); //消息的内容
    newMessage.setMessageId(messageId);               //消息的id
    newMessage.setUserId(messageUserId);              //消息的用户id
    newMessage.setNewMessageType(3);                  //管理员发布的消息
    newMessageService.add(newMessage);
    return 200;
  }

}
