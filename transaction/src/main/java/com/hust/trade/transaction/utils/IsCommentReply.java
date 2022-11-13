package com.hust.trade.transaction.utils;

import com.hust.trade.transaction.model.Attend;
import com.hust.trade.transaction.model.CommentReply;
import com.hust.trade.transaction.model.NewMessage;
import com.hust.trade.transaction.model.User;
import com.hust.trade.transaction.service.AttendService;
import com.hust.trade.transaction.service.CommentReplyService;
import com.hust.trade.transaction.service.NewMessageService;
import com.hust.trade.transaction.service.UserService;

public class IsCommentReply {
  private Integer code;

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public IsCommentReply isTrue(Integer messageId, CommentReply commentReply, UserService mangoUserService, CommentReplyService commentReplyService, NewMessageService newMessageService, AttendService attendService) {
    IsCommentReply isCommentReply = new IsCommentReply();
    isCommentReply.setCode(500);
    User user = mangoUserService.getById(commentReply.getReplyUserId());
    if (user == null) {
      isCommentReply.setCode(400);
      return isCommentReply;
    }

    if(user.getUserAllow()!=1){
      isCommentReply.setCode(301);
      return isCommentReply;
    }

    commentReplyService.add(commentReply);


    if (commentReply.getReceiveUserId() == commentReply.getReplyUserId()) {
      isCommentReply.setCode(200);
      return isCommentReply;
    }

    if(commentReply.getReplyUserId()!=commentReply.getReceiveUserId()) {
      NewMessage newMessage = new NewMessage();
      newMessage.setUserId(commentReply.getReceiveUserId());
      newMessage.setNewMessageType(2);
      newMessage.setMessageId(messageId);
      newMessage.setNewMessageDetail(commentReply.getReplyDetail());
      newMessageService.add(newMessage);
    }

    Attend attend = new Attend();
    attend.setMessageId(messageId);
    attend.setUserId(commentReply.getReplyUserId());

    if (attendService.findCount(attend) != 0) {
      isCommentReply.setCode(200);
      return isCommentReply;
    }

    attendService.add(attend);


    isCommentReply.setCode(200);
    return isCommentReply;
  }
}
