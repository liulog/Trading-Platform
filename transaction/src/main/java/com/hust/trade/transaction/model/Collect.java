package com.hust.trade.transaction.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("collect")
/*
  我的收藏：收藏id，用户id，消息id
 */
public class Collect {
  @TableId(value = "collect_id",type = IdType.ASSIGN_ID)
  private Long collectId;

  @TableField("user_id")
  private Long userId;

  @TableField("message_id")
  private Long messageId;
}
