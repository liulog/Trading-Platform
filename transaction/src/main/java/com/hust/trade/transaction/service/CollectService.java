package com.hust.trade.transaction.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hust.trade.transaction.mapper.CollectMapper;
import com.hust.trade.transaction.model.Collect;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectService{

  @Autowired
  private CollectMapper collectMapper;

  public List<Collect> getAllCollectionMessageByUserId(Integer userId) {
    return collectMapper.getAllCollectionMessageByUserId(userId);
  }

  public Integer findCount(Collect collect){
    QueryWrapper<Collect> query = new QueryWrapper<>();
    query.eq("collect_id",collect.getCollectId());
    //直接通过以上的两句代码实现条件查询计数，之后调用集成好的selectCount就ok了。
    return collectMapper.selectCount(query);
  }

  public void delete(Collect collect){
    collectMapper.deleteById(collect.getCollectId());
  }

  public void add(Collect collect){
    collectMapper.insert(collect);
  }
}
