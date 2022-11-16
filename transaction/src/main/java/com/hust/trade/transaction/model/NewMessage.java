package com.hust.trade.transaction.model;

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
@TableName("new_message")
/*
  我的消息：new消息id，用户id，消息type，消息id，newMessage信息，newMessage的时间
 */
public class NewMessage {
  @TableId("new_message_id")
  private Long newMessageId;

  @TableField("user_id")
  private Long userId;

  @TableField("new_message_type")
  private Integer newMessageType;

  @TableField("message_id")
  private Long messageId;

  @TableField("new_message_detail")
  private String newMessageDetail;

  @TableField("new_message_time")
  private Date newMessageTime;
}
