package com.hust.trade.transaction.controller;

import com.hust.trade.transaction.service.AttendService;
import com.hust.trade.transaction.service.CollectService;
import com.hust.trade.transaction.service.MessageDetailService;
import com.hust.trade.transaction.service.MessageImagesService;
import com.hust.trade.transaction.service.NewMessageService;
import com.hust.trade.transaction.service.UserService;
import com.hust.trade.transaction.utils.IsDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteByUserIdController {
  @Autowired
  private MessageDetailService messageDetailService;
  @Autowired
  private MessageImagesService messageImagesService;
  @Autowired
  private AttendService attendService;
  @Autowired
  private UserService userService;
  @Autowired
  private CollectService collectService;
  @Autowired
  private NewMessageService newMessageService;

  /**
   * 根据用户id和messageid删除message
   * @param userId
   * @param messageId
   * @return IsDelete实体
   */
  @Transactional
  @PostMapping("/deleteMessageById/{userId}/{messageId}")
  public IsDelete deleteByUserId(@PathVariable Long userId, @PathVariable Long messageId) {
    return new IsDelete().isDelete(userId, messageId, messageImagesService, userService, messageDetailService,attendService,collectService,newMessageService);
  }
}