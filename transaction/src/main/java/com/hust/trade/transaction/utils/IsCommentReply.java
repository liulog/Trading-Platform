package com.hust.trade.transaction.utils;

import com.hust.trade.transaction.model.Attend;
import com.hust.trade.transaction.model.CommentReply;
import com.hust.trade.transaction.model.NewMessage;
import com.hust.trade.transaction.model.User;
import com.hust.trade.transaction.service.AttendService;
import com.hust.trade.transaction.service.CommentReplyService;
import com.hust.trade.transaction.service.NewMessageService;
import com.hust.trade.transaction.service.UserService;
import lombok.Data;

@Data
public class IsCommentReply {
  private Integer code;

  public IsCommentReply isTrue(Long messageId, CommentReply commentReply, UserService userService, CommentReplyService commentReplyService, NewMessageService newMessageService, AttendService attendService) {
    IsCommentReply isCommentReply = new IsCommentReply(); //新建评论回复
    isCommentReply.setCode(500);
    User user = userService.getById(commentReply.getReplyUserId()); //查找用户
    if (user == null) {               //没找到这个用户
      isCommentReply.setCode(400);
      return isCommentReply;
    }

    if(user.getUserAllow()!=1){       //不允许该用户操作
      isCommentReply.setCode(301);
      return isCommentReply;
    }

    commentReplyService.add(commentReply);  //新增该条评论

    if (commentReply.getReceiveUserId() == commentReply.getReplyUserId()) { //接受用户id等于回复用户id
      isCommentReply.setCode(200);
      return isCommentReply;
    }

    if(commentReply.getReplyUserId() != commentReply.getReceiveUserId()) {  //接受用户和回复用户id不一致
      NewMessage newMessage = new NewMessage();           //新建新消息
      newMessage.setUserId(commentReply.getReceiveUserId());
      newMessage.setNewMessageType(2);                    //评论回复
      newMessage.setMessageId(messageId);                 //消息id
      newMessage.setNewMessageDetail(commentReply.getReplyDetail());
      newMessageService.add(newMessage);
    }

    Attend attend = new Attend();               //添加到我的参与中
    attend.setMessageId(messageId);
    attend.setUserId(commentReply.getReplyUserId());

    if (attendService.findCount(attend) != 0) {   //已经在我的参与中
      isCommentReply.setCode(200);
      return isCommentReply;
    }

    attendService.add(attend);                //添加到我的参与中

    isCommentReply.setCode(200);
    return isCommentReply;
  }
}
