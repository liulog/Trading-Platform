package com.hust.trade.transaction.controller;

import com.hust.trade.transaction.model.CommentReply;
import com.hust.trade.transaction.service.AttendService;
import com.hust.trade.transaction.service.CommentReplyService;
import com.hust.trade.transaction.service.NewMessageService;
import com.hust.trade.transaction.service.UserService;
import com.hust.trade.transaction.utils.IsCommentReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddCommentReplyController {
  @Autowired
  private UserService userService;
  @Autowired
  private CommentReplyService commentReplyService;
  @Autowired
  private NewMessageService newMessageService;
  @Autowired
  private AttendService attendService;

  /**
   * 增加用户评论回复
   * @param messageId
   * @param commentReply
   * @return
   */
  @Transactional
  @PostMapping("/addCommentReply/{messageId}")
  public IsCommentReply addCommentReply(@PathVariable Long messageId, @RequestBody CommentReply commentReply) {
    return new IsCommentReply().isTrue(messageId, commentReply, userService, commentReplyService, newMessageService, attendService);
  }


}
