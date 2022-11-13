package com.hust.tradingplatform.model;


import javax.persistence.Table;
import javax.persistence.Column;

/**
 * Created with IntelliJ IDEA.
 * User: liucongzheng
 * Date: 2022/11/5
 * Time: 下午 09:54
 * Description: No Description
 */
@Table(name="`trade_chat_list`")
public class ChatList {

  @Column(name="`id`")
  private Integer id;

  @Column(name="`chat_id`")
  private Integer chat_id;

  @Column(name="`user_id`")
  private String user_id;

  @Column(name="`another_id`")
  private String another_id;

  @Column(name="`is_online`")
  private Integer is_online;

  @Column(name="`unreadNum`")
  private Integer unreadNum;

  @Column(name="`is_delete`")
  private Integer is_delete;

  public void setUnreadNum(Integer unreadNum) {
    this.unreadNum = unreadNum;
  }

  public void setIs_online(Integer is_online) {
    this.is_online = is_online;
  }

  public void setIs_delete(Integer is_delete) {
    this.is_delete = is_delete;
  }

  public void setChat_id(Integer chat_id) {
    this.chat_id = chat_id;
  }

  public Integer getUnreadNum() {
    return unreadNum;
  }

  public Integer getIs_online() {
    return is_online;
  }

  public Integer getIs_delete() {
    return is_delete;
  }

  public Integer getChat_id() {
    return chat_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setAnother_id(String another_id) {
    this.another_id = another_id;
  }

  public String getUser_id() {
    return user_id;
  }

  public String getAnother_id() {
    return another_id;
  }
}
