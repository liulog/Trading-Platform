package com.hust.trade.transaction.utils;


import com.hust.trade.transaction.model.Attend;
import com.hust.trade.transaction.model.Comment;
import com.hust.trade.transaction.model.NewMessage;
import com.hust.trade.transaction.model.User;
import com.hust.trade.transaction.service.AttendService;
import com.hust.trade.transaction.service.CommentService;
import com.hust.trade.transaction.service.NewMessageService;
import com.hust.trade.transaction.service.UserService;

/**
 * IsComment 评论
 */
public class IsComment {

  private Integer code;

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  /**
   * 是一条评论
   * @param userId 用户id
   * @param messageId 消息id
   * @param userComment 用户评论
   * @param messageUserId 消息
   * @param userService 用户服务
   * @param commentService 评论服务
   * @param newMessageService 新消息服务
   * @param attendService 登录服务
   * @return IsComment对象（包含状态码）
   */
  public IsComment isTrue(Integer userId, Integer messageId, String userComment, Integer messageUserId, UserService userService, CommentService commentService, NewMessageService newMessageService, AttendService attendService) {
    IsComment isComment = new IsComment();
    isComment.setCode(500);
    User user = userService.getById(userId);  //获取当前用户
    if (user == null) {                       //没有对应用户就返回400
      isComment.setCode(400);
      return isComment;
    }

    if (user.getUserAllow() != 1) {           //不允许
      isComment.setCode(301);
      return isComment;
    }

    Comment comment = new Comment();
    comment.setMessageId(messageId);
    comment.setUserId(userId);
    comment.setCommentDetail(userComment);
    commentService.add(comment);

    if (userId != messageUserId) {
      NewMessage newMessage = new NewMessage();
      newMessage.setUserId(messageUserId);
      newMessage.setNewMessageType(1);
      newMessage.setNewMessageDetail(userComment);
      newMessage.setMessageId(messageId);
      newMessageService.add(newMessage);
    }
      Attend attend = new Attend();
      attend.setMessageId(messageId);
      attend.setUserId(userId);

      if (attendService.findCount(attend) != 0) {
        isComment.setCode(200);
        return isComment;
      }

      attendService.add(attend);

      isComment.setCode(200);
      return isComment;
    }
}