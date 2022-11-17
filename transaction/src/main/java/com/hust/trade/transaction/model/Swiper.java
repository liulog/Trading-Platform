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
@TableName("swiper")
public class Swiper {

  @TableId("swiper_id")
  private Long swiperId;

  @TableField("swiper_image_url")
  private String swiperImageUrl;

}
