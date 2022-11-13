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
@TableName("collect")
/*
  我的收藏：收藏id，用户id，消息id
 */
public class Collect {
  @TableId("collect_id")
  private Integer collectId;

  @TableField("user_id")
  private Integer userId;

  @TableField("message_id")
  private Integer messageId;
}
