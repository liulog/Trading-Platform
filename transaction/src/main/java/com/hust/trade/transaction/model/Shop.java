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
@TableName("shop")
public class Shop {

  @TableId("shop_id")
  private Integer shopId;

  @TableField("shop_name")
  private String shopName;

  @TableField("shop_intro")
  private String shopIntro;

  @TableField("shop_phone")
  private String shopPhone;

  @TableField("shop_avatar")  //头像
  private String shopAvatar;

  @TableField("shop_latitude")
  private String shopLatitude;

  @TableField("shop_longitude")
  private String shopLongitude;

  @TableField("shop_create_time")
  private Date shopCreateTime;

  private List<ShopImages> shopImages;

  private List<ShopBusiness> shopBusinesses;

}
