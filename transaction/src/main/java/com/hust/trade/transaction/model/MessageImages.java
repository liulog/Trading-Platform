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
@TableName("message_images")
/*
  发布图片，图片id，发布id，图片url
 */
public class MessageImages {

  @TableId("image_id")
  private Integer imageId;

  @TableField("message_id")
  private Integer messageId;

  @TableField("image_url")
  private String imageUrl;

}
