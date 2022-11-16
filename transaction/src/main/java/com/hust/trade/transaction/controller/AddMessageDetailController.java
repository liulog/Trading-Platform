package com.hust.trade.transaction.controller;

import com.hust.trade.transaction.model.Message;
import com.hust.trade.transaction.service.MessageDetailService;
import com.hust.trade.transaction.service.MessageImagesService;
import com.hust.trade.transaction.service.UserService;
import com.hust.trade.transaction.utils.IsUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddMessageDetailController {
  @Autowired
  private MessageImagesService messageImagesService;
  @Autowired
  private MessageDetailService messageDetailService;
  @Autowired
  private UserService userService;

  /**
   * 发布message信息
   * @param userId 用户唯一标识
   * @param message "发布" 上传的信息（图片url等）
   * @return
   */
  @Transactional
  @PostMapping("/addMessage/{userId}")
  public IsUpload addMessage(@PathVariable Long userId, @RequestBody Message message) {
    return new IsUpload().isTrue(message, messageDetailService, messageImagesService, userService);
  }
}
