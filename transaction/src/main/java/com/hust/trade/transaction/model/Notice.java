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
@TableName("notice")
/*
  通知：通知id，通知具体内容
 */
public class Notice {

  @TableId("notice_id")
  private Long noticeId;

  @TableField("notice_detail")
  private String noticeDetail;
}
