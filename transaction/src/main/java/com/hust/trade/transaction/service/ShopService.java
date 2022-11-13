package com.hust.trade.transaction.service;


import com.hust.trade.transaction.mapper.ShopMapper;
import com.hust.trade.transaction.model.Shop;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService  {
  @Autowired
  ShopMapper shopMapper;
  public List<Shop> findAll(){
    return shopMapper.selectList(null);
  }
  public Shop getById(Integer id){
    return shopMapper.selectById(id);
  }
}
