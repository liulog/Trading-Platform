package com.hust.trade.transaction.controller;

import com.hust.trade.transaction.model.Message;
import com.hust.trade.transaction.service.MessageDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetLostMessageController {
  @Autowired
  private MessageDetailService messageDetailService;

  /**
   * 获取 “失物招领” 信息
   * @return 返回失物招领的消息
   */
  @PostMapping("/getMessage/getLostMessage")
  public Message getLostMessage(){
    return messageDetailService.getLostMessage();
  }
}
