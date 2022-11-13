package com.hust.tradingplatform.model;

import javax.persistence.Table;
import javax.persistence.Column;

/**
 * Created with IntelliJ IDEA.
 * User: liucongzheng
 * Date: 2022/11/5
 * Time: 下午 09:52
 * Description: No Description
 */
@Table(name="`trade_chat_main`")
public class ChatMain {

  @Column(name="`id`")
  private Integer id;

  @Column(name="`user_id`")
  private String user_id;

  @Column(name="`another_id`")
  private String another_id;

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public void setAnother_id(String another_id) {
    this.another_id = another_id;
  }

  public String getUser_id() {
    return user_id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAnother_id() {
    return another_id;
  }

  public Integer getId() {
    return id;
  }
}
