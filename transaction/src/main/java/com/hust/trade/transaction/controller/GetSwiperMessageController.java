package com.hust.trade.transaction.controller;

import com.hust.trade.transaction.model.Swiper;
import com.hust.trade.transaction.service.SwiperService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetSwiperMessageController {
  @Autowired
  private SwiperService swiperService;

  /**
   * 获取所有Swiper信息
   * @return
   */
  @PostMapping("/getMessage/getAllSwiperMessage")
  public List<Swiper> getAllSwiperMessage() {
    return swiperService.findAll();
  }
}

