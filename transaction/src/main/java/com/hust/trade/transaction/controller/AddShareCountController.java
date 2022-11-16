package com.hust.trade.transaction.controller;

import com.hust.trade.transaction.model.Message;
import com.hust.trade.transaction.service.MessageDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddShareCountController {

  @Autowired
  private MessageDetailService messageDetailService;

  /**
   * 添加"分享"计数
   * @param messageId 消息id
   * @return 分享数
   */
  @PostMapping("/share/addShareCount/{messageId}")
  public Integer addShareCount(@PathVariable Long messageId) {
    Message message1 = messageDetailService.getById(messageId); //消息id
    Message message2 = new Message(); //更新的内容
    message2.setMessageId(messageId);
    message2.setMessageShare(message1.getMessageShare() + 1); //分享计数+1
    messageDetailService.update(message2);
    return message1.getMessageShare();  //返回分享计数
  }
}
