package com.hust.trade.transaction.controller;

import com.hust.trade.transaction.model.Category;
import com.hust.trade.transaction.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetCategoryMessageController {

  @Autowired
  private CategoryService categoryService;

  /**
   * 获取 "目录" 列表
   * @return 返回目录
   */
  @PostMapping("/getMessage/getAllCategoryMessage")
  public List<Category> getAllCategoryMessage() {
    return categoryService.findAll();
  }
}
