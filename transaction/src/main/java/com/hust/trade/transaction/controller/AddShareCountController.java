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
   * 添加分享计数
   * @param messageId
   * @return 分享数
   */
  @PostMapping("/share/addShareCount/{messageId}")
  public Integer addShareCount(@PathVariable Integer messageId) {

    Message message1 = messageDetailService.getById(messageId);
    Message message2 = new Message();
    message2.setMessageId(messageId);
    message2.setMessageShare(message1.getMessageShare() + 1);
    messageDetailService.update(message2);

    return message1.getMessageShare();
  }

}
