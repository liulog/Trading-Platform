package com.hust.tradingplatform.model;

import javax.persistence.Table;
import javax.persistence.Column;

/**
 * Created with IntelliJ IDEA.
 * User: liucongzheng
 * Date: 2022/11/5
 * Time: 下午 09:48
 * Description: No Description
 */
@Table(name="`product_reviews`")
public class ProductReview {

  @Column(name="`concreteContent`")
  private String concreteContent;

  @Column(name="`appraiser`")
  private String appraiser;

  @Column(name="`tradeName`")
  private String tradeName;

  @Column(name="`sellerAccount`")
  private String sellerAccount;

  public void setConcreteContent(String concreteContent) {
    this.concreteContent = concreteContent;
  }

  public void setAppraiser(String appraiser) {
    this.appraiser = appraiser;
  }

  public String getConcreteContent() {
    return concreteContent;
  }

  public String getAppraiser() {
    return appraiser;
  }

  public void setTradeName(String tradeName) {
    this.tradeName = tradeName;
  }

  public void setSellerAccount(String sellerAccount) {
    this.sellerAccount = sellerAccount;
  }

  public String getTradeName() {
    return tradeName;
  }

  public String getSellerAccount() {
    return sellerAccount;
  }
}
