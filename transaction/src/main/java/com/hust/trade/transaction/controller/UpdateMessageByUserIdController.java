package com.hust.trade.transaction.controller;

import com.hust.trade.transaction.service.MessageDetailService;
import com.hust.trade.transaction.service.UserService;
import com.hust.trade.transaction.utils.IsUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateMessageByUserIdController {

  @Autowired
  private MessageDetailService messageDetailService;
  @Autowired
  private UserService userService;

  /**
   * 根据用户id更新信息
   * @param id 用户id
   * @param messageId 消息id
   * @param message 具体消息
   * @return 返回IsUpdate
   */
  @Transactional
  @PostMapping("/updateMessageById/{id}/{messageId}")
  public IsUpdate updateMessageById(@PathVariable Integer id,@PathVariable Integer messageId,@RequestBody String message){
    return new IsUpdate().isTrue(id,messageId,message,messageDetailService,userService);
  }
}

