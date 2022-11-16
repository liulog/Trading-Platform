//package com.hust.trade.transaction.service;
//
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.hust.trade.transaction.mapper.ShopImagesMapper;
//import com.hust.trade.transaction.model.ShopImages;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ShopImagesService  {
//  @Autowired
//  ShopImagesMapper shopImagesMapper;
//  public List<ShopImages> findList(ShopImages shopImages){
//    QueryWrapper<ShopImages> query = new QueryWrapper<>();
//    query.eq("shop_id",shopImages.getShopId());
//    return shopImagesMapper.selectList(query);
//  }
//}
