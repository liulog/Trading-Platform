package com.hust.trade.transaction.controller;

import com.hust.trade.transaction.model.Comment;
import com.hust.trade.transaction.model.CommentReply;
import com.hust.trade.transaction.model.User;
import com.hust.trade.transaction.service.CommentReplyService;
import com.hust.trade.transaction.service.CommentService;
import com.hust.trade.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteCommentByIdController {

  @Autowired
  private CommentService commentService;
  @Autowired
  private UserService userService;
  @Autowired
  private CommentReplyService commentReplyService;

  /**
   * 根据用户id和commentid来删除评论
   * @param userId 用户id
   * @param messageId 消息id
   * @return 返回状态码
   */
  @Transactional
  @PostMapping("/deleteCommentByCommentId/{userId}/{commentId}")
  public Integer deleteCommentByCommentId(@PathVariable Long userId, @PathVariable Long commentId) {
    User user = userService.getById(userId);  //获取用户
    if (user == null) {
      return 400;
    }
    Comment comment = new Comment();
    if (user.getUserIsAdmin() == 2) {   //如果是管理员
      comment.setCommentId(commentId);
    } else {                            //非管理员
      comment.setCommentId(commentId);
      comment.setUserId(userId);
    }

    commentService.delete(comment);     //删除评论
    CommentReply commentReply = new CommentReply();
    commentReply.setCommentId(commentId);
    commentReplyService.delete(commentReply);//删除评论回复相关的内容
    return 200;
  }

  /**
   * 删除评论回复
   * @param userId 用户id
   * @param commentReplyId 评论回复id
   * @return
   */
  @Transactional
  @PostMapping("/deleteCommentReplyByCommentId/{userId}/{commentReplyId}")
  public Integer deleteCommentReplyByCommentId(@PathVariable Long userId, @PathVariable Long commentReplyId) {
    User user = userService.getById(userId);
    if (user == null) {
      return 400;
    }
    CommentReply commentReply = new CommentReply();

    if (user.getUserIsAdmin() == 2) {
      commentReply.setCommentReplyId(commentReplyId);
    } else {
      commentReply.setCommentReplyId(commentReplyId);
      commentReply.setReplyUserId(userId);
    }

    commentReplyService.delete(commentReply); //删除评论回复

    return 200;
  }

}