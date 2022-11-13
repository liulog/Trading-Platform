package com.hust.trade.transaction.controller;

import com.hust.trade.transaction.model.Shop;
import com.hust.trade.transaction.model.ShopBusiness;
import com.hust.trade.transaction.model.ShopImages;
import com.hust.trade.transaction.service.ShopBusinessService;
import com.hust.trade.transaction.service.ShopImagesService;
import com.hust.trade.transaction.service.ShopService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetShopMessageController {
  @Autowired
  private ShopService shopService;

  @Autowired
  private ShopImagesService shopImagesService;
  @Autowired
  private ShopBusinessService shopBusinessService;

  /**
   * 获取所有商店
   * @return 返回所有的商店
   */
  @PostMapping("/getMessage/getAllShop")
  public List<Shop> getAllShopMessage() {
    return shopService.findAll();
  }

  /**
   * 获取商店信息
   * @param id 商店id
   * @return 查询到的商店
   */
  @PostMapping("/getMessage/getShopMessage/{id}")
  public Shop getShopMessageById(@PathVariable Integer id) {
    Shop shop = shopService.getById(id);
    ShopImages shopImages = new ShopImages();
    shopImages.setShopId(id);
    shop.setShopImages(shopImagesService.findList(shopImages));
    ShopBusiness shopBusiness = new ShopBusiness();
    shopBusiness.setShopId(id);
    shop.setShopBusinesses(shopBusinessService.findList(shopBusiness));
    return shop;
  }

}
