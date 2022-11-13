package com.hust.tradingplatform.model;

import javax.xml.crypto.Data;
import javax.persistence.Table;
import javax.persistence.Column;

/**
 * Created with IntelliJ IDEA.
 * User: liucongzheng
 * Date: 2022/11/5
 * Time: 下午 09:39
 * Description: No Description
 */
@Table(name = "`product_information`")
public class ProductInfo {
  @Column(name="`tradeName`")
  private String tradeName;

  @Column(name="`state`")
  private String state;

  @Column(name="`sort`")
  private String sort;

  @Column(name="`sellerAccount`")
  private String sellerAccount;

  @Column(name="`concreteState`")
  private String concreteState;

  @Column(name="`price`")
  private Integer price;

  @Column(name="`buyerAccount`")
  private String buyerAccount;

  @Column(name="`introduction`")
  private String introduction;

  @Column(name="`searchNum`")
  private String searchNum;

  @Column(name="`publishTime`")
  private Data publishTime;

  @Column(name="`picturePath`")
  private String picturePath;

  public void setTradeName(String tradeName) {
    this.tradeName = tradeName;
  }

  public void setState(String state) {
    this.state = state;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public void setSellerAccount(String sellerAccount) {
    this.sellerAccount = sellerAccount;
  }

  public void setSearchNum(String searchNum) {
    this.searchNum = searchNum;
  }

  public void setPublishTime(Data publishTime) {
    this.publishTime = publishTime;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public void setPicturePath(String picturePath) {
    this.picturePath = picturePath;
  }

  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }

  public void setConcreteState(String concreteState) {
    this.concreteState = concreteState;
  }

  public void setBuyerAccount(String buyerAccount) {
    this.buyerAccount = buyerAccount;
  }

  public String getTradeName() {
    return tradeName;
  }

  public String getState() {
    return state;
  }

  public String getSort() {
    return sort;
  }

  public String getSellerAccount() {
    return sellerAccount;
  }

  public String getSearchNum() {
    return searchNum;
  }

  public String getPicturePath() {
    return picturePath;
  }

  public String getIntroduction() {
    return introduction;
  }

  public String getConcreteState() {
    return concreteState;
  }

  public String getBuyerAccount() {
    return buyerAccount;
  }

  public Integer getPrice() {
    return price;
  }

  public Data getPublishTime() {
    return publishTime;
  }
}
