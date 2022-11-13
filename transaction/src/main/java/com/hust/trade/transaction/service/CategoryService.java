package com.hust.trade.transaction.service;


import com.hust.trade.transaction.mapper.CategoryMapper;
import com.hust.trade.transaction.model.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService  {
  @Autowired
  CategoryMapper categoryMapper;
  public List<Category> findAll(){
    return categoryMapper.selectList(null);
  }

}
