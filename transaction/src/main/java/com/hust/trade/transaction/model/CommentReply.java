package com.hust.trade.transaction.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("comment_reply")
/*
  评论回复：评论回复id，评论id，评论用户id，回复用户id，回复用户name，接收用户id，接收用户name，回复具体信息，回复时间
 */
public class CommentReply {

  @TableId(value = "comment_reply_id",type = IdType.ASSIGN_ID)
  private Long commentReplyId;

  @TableField("comment_id")
  private Long commentId;

  @TableField("comment_user_id")
  private Long commentUserId;

  @TableField("reply_user_id")
  private Long replyUserId;

  @TableField("reply_user_name")
  private String replyUserName;

  @TableField("receive_user_id")
  private Long receiveUserId;

  @TableField("receive_user_name")
  private String receiveUserName;

  @TableField("reply_detail")
  private String replyDetail;

  @TableField("reply_time")
  private Date replyTime;
}
