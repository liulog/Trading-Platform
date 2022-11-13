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
@TableName("category")
/*
  目录：类别id，类别name，类别image
 */
public class Category {
  @TableId("category_id")
  private Integer categoryId;

  @TableField("category_name")
  private String categoryName;

  @TableField("category_image")
  private String categoryImage;

}
