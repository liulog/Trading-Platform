package com.hust.tradingplatform.model;

import javax.xml.crypto.Data;
import javax.persistence.Table;
import javax.persistence.Column;

/**
 * Created with IntelliJ IDEA.
 * User: liucongzheng
 * Date: 2022/11/5
 * Time: 下午 10:03
 * Description: No Description
 */
@Table(name="`inform`")
public class Notice {

  @Column(name="`user_id`")
  private String user_id;

  @Column(name="`message`")
  private String message;

  @Column(name="`sendTime`")
  private Data sendTime;

  public void setMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public void setSendTime(Data sendTime) {
    this.sendTime = sendTime;
  }

  public Data getSendTime() {
    return sendTime;
  }

  public String getUser_id() {
    return user_id;
  }
}
