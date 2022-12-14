package com.hust.trade.transaction.controller;

import com.hust.trade.transaction.service.AttendService;
import com.hust.trade.transaction.service.CommentService;
import com.hust.trade.transaction.service.NewMessageService;
import com.hust.trade.transaction.service.UserService;
import com.hust.trade.transaction.utils.IsComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddCommentController {

  @Autowired
  private UserService userService;
  @Autowired
  private CommentService commentService;
  @Autowired
  private NewMessageService newMessageService;
  @Autowired
  private AttendService attendService;

  /**
   *  增加评论
   * @param userId 用户唯一标识
   * @param userComment 用户具体的评论
   * @param messageId 消息id
   * @param messageUserId 消息的发布者user_id
   * @return IsComment对象
   */
  @Transactional
  @PostMapping("/addComment/{userId}/{messageId}/{messageUserId}")
  public IsComment addComment(@PathVariable Long userId, @RequestBody String userComment, @PathVariable Long messageId, @PathVariable Long messageUserId) {
    return new IsComment().isTrue(userId, messageId, userComment, messageUserId, userService, commentService, newMessageService, attendService);
  }

}
