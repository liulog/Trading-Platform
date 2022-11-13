package com.hust.tradingplatform.model;

import javax.xml.crypto.Data;
import javax.persistence.Table;
import javax.persistence.Column;

/**
 * Created with IntelliJ IDEA.
 * User: liucongzheng
 * Date: 2022/11/5
 * Time: 下午 09:59
 * Description: No Description
 */

@Table(name="`trade_chat_content`")
public class ChatContent {

  @Column(name="`id`")
  private Integer id;

  @Column(name="`chat_id`")
  private Integer chat_id;

  @Column(name="`user_id`")
  private String user_id;

  @Column(name="`chatContent`")
  private String chatContent;

  @Column(name="`sendTime`")
  private Data sendTime;

  @Column(name="`messageType`")
  private String messageType;

  @Column(name="`is_last`")
  private Integer is_last;

  public void setSendTime(Data sendTime) {
    this.sendTime = sendTime;
  }

  public void setMessageType(String messageType) {
    this.messageType = messageType;
  }

  public void setIs_last(Integer is_last) {
    this.is_last = is_last;
  }

  public void setChatContent(String chatContent) {
    this.chatContent = chatContent;
  }

  public String getMessageType() {
    return messageType;
  }

  public String getChatContent() {
    return chatContent;
  }

  public Integer getIs_last() {
    return is_last;
  }

  public Data getSendTime() {
    return sendTime;
  }

  public void setChat_id(Integer chat_id) {
    this.chat_id = chat_id;
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

  public String getUser_id() {
    return user_id;
  }

  public Integer getChat_id() {
    return chat_id;
  }
}
