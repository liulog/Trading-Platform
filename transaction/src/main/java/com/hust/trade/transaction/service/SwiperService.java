package com.hust.trade.transaction.service;

import com.hust.trade.transaction.mapper.SwiperMapper;
import com.hust.trade.transaction.model.Swiper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwiperService{
  @Autowired
  SwiperMapper swiperMapper;
  public List<Swiper> findAll(){
    return swiperMapper.selectList(null);
  }

}
