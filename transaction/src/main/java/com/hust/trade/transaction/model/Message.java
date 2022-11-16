package com.hust.trade.transaction.model;

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
@TableName("message")
/*
  发布：发布id，发布是否匿名，用户id，目录id，用户phone，用户major，用户年级，发布具体内容，分享次数，评论次数，查看次数，创建时间，消息图片list，评论列表，用户信息，resultImage
 */
public class Message {

  @TableId("message_id")
  private Long messageId;

  @TableField("user_id_anonymity")
  private  Integer userIdAnonymity;

  @TableField("user_id")
  private Long userId;

  @TableField("category_id")
  private Long categoryId;

  @TableField("user_phone")
  private String userPhone;

  @TableField("user_major")
  private String userMajor;

  @TableField("user_level")
  private String userLevel;

  @TableField("message_detail")
  private String messageDetail;

  @TableField("message_share")
  private Integer messageShare;

  @TableField("message_comment")
  private Integer messageComment;

  @TableField("message_watch")
  private Integer messageWatch;

  @TableField("message_create_time")
  private Date messageCreateTime;

  private List<MessageImages> messageImages;

  private List<Comment> comments;

  private User User;

  private List<String> resultImage;
}
