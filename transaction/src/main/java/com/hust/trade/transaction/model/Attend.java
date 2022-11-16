package com.hust.trade.transaction.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("attend")
/*
  我的参与： 发布id，用户id，消息id
 */
public class Attend {
  @TableId("attend_id")
  private Long attendId;

  @TableField("user_id")
  private Long userId;

  @TableField("message_id")
  private Long messageId;

}
