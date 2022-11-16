//package com.hust.trade.transaction.service;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.hust.trade.transaction.mapper.ShopBusinessMapper;
//import com.hust.trade.transaction.mapper.ShopImagesMapper;
//import com.hust.trade.transaction.model.ShopBusiness;
//import com.hust.trade.transaction.model.ShopImages;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ShopBusinessService {
//  @Autowired
//  ShopBusinessMapper shopBusinessMapper;
//  public List<ShopBusiness> findList(ShopBusiness shopBusiness){
//    QueryWrapper<ShopBusiness> query = new QueryWrapper<>();
//    query.eq("shop_id",shopBusiness.getShopId());
//    return shopBusinessMapper.selectList(query);
//  }
//}
