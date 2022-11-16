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

  public List<Collect> getAllCollectionMessageByUserId(Long userId) {
    return collectMapper.getAllCollectionMessageByUserId(userId);
  }

  //满足两个条件的查询，and
  public Integer findCount(Collect collect){
    QueryWrapper<Collect> query = new QueryWrapper<>();
    query.eq("user_id",collect.getUserId()).eq("message_id",collect.getMessageId());
    //直接通过以上的两句代码实现条件查询计数，之后调用集成好的selectCount就ok了。
    return collectMapper.selectCount(query);
  }

  //满足两个条件的才删除
  public void delete(Collect collect){
    QueryWrapper<Collect> query = new QueryWrapper<>();
    query.eq("user_id",collect.getUserId()).or().eq("message_id",collect.getMessageId());
    collectMapper.delete(query);
  }

  public void add(Collect collect){
    collectMapper.insert(collect);
  }
}
