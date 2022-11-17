package com.hust.trade.transaction.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("comment")
/*
  评论 ： 评论id，用户id，消息id，评论内容，评论创建时间，用户信息，评论回复列表
 */
public class Comment {

  @TableId(value = "comment_id",type = IdType.ASSIGN_ID)
  private Long commentId;

  @TableField("user_id")
  private Long userId;

  @TableField("message_id")
  private Long messageId;

  @TableField("comment_detail")
  private String commentDetail;

  @TableField("comment_create_time")
  private Date commentCreateTime;

  @TableField(exist = false)
  private User User;

  @TableField(exist = false)
  private List<CommentReply> commentReplies;
}
