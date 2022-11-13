package com.hust.tradingplatform.model;

import javax.persistence.Table;
import javax.persistence.Column;

/**
 * Created with IntelliJ IDEA.
 * User: liucongzheng
 * Date: 2022/11/5
 * Time: 下午 09:21
 * Description: No Description
 */

@Table(name="`personal_information`")
public class User {

  @Column(name="`account`")
  private String account;

  @Column(name="`password`")
  private String password;

  @Column(name="`username`")
  private String username;

  @Column(name="`concernNum`")
  private Integer concernNum;

  @Column(name="`fansNum`")
  private Integer fansNum;

  @Column(name="`buyNum`")
  private Integer buyNum;

  @Column(name="praiseNum")
  private Integer praiseNum;

  @Column(name="`earn`")
  private Integer earn;

  @Column(name="`reputationPoints`")
  private Integer reputationPoints;

  public void setUsername(String username) {
    this.username = username;
  }

  public void setReputationPoints(Integer reputationPoints) {
    this.reputationPoints = reputationPoints;
  }

  public void setPraiseNum(Integer praiseNum) {
    this.praiseNum = praiseNum;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setFansNum(Integer fansNum) {
    this.fansNum = fansNum;
  }

  public void setEarn(Integer earn) {
    this.earn = earn;
  }

  public void setConcernNum(Integer concernNum) {
    this.concernNum = concernNum;
  }

  public void setBuyNum(Integer buyNum) {
    this.buyNum = buyNum;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getAccount() {
    return account;
  }

  public Integer getReputationPoints() {
    return reputationPoints;
  }

  public Integer getBuyNum() {
    return buyNum;
  }

  public Integer getPraiseNum() {
    return praiseNum;
  }

  public Integer getFansNum() {
    return fansNum;
  }

  public Integer getEarn() {
    return earn;
  }

  public Integer getConcernNum() {
    return concernNum;
  }
}
