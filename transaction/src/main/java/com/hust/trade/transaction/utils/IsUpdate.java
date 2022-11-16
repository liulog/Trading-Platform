package com.hust.trade.transaction.utils;

import com.hust.trade.transaction.model.Message;
import com.hust.trade.transaction.model.User;
import com.hust.trade.transaction.service.MessageDetailService;
import com.hust.trade.transaction.service.UserService;
import lombok.Data;

@Data
public class IsUpdate {

  private Integer code; //状态码ß

  public IsUpdate isTrue(Long id, Long messageId, String messageString, MessageDetailService messageDetailService, UserService userService) {

    IsUpdate isUpdate = new IsUpdate();
    isUpdate.setCode(500);
    User user = userService.getById(id);  //获取用户

    if (user == null) {                   //用户不存在ß
      isUpdate.setCode(400);
      return isUpdate;
    }
    Message message = new Message();

    if (user.getUserIsAdmin() == 2) {
      message.setMessageId(messageId);
    } else {
      message.setMessageId(messageId);
      message.setUserId(id);

      Integer count = messageDetailService.findCount(message);

      if (count == 0) {
        isUpdate.setCode(400);
        return isUpdate;
      }
    }
    message.setMessageDetail(messageString);
    messageDetailService.update(message);
    isUpdate.setCode(200);
    return isUpdate;
  }
}
