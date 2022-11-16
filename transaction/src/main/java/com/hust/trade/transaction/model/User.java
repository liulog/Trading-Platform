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
@TableName("user")

public class User {

  @TableId("user_id")
  private Long userId;

  @TableField("user_openid")
  private String userOpenid;

  @TableField("user_gender")
  private Integer userGender;

  @TableField("user_avatar")
  private String userAvatar;

  @TableField("user_nickname")
  private String userNickname;

  @TableField("user_is_admin")
  private Integer userIsAdmin;

  @TableField("user_allow")
  private Integer userAllow;

  @TableField("user_create_time")
  private Date userCreateTime;

}
