package com.hust.trade.transaction.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hust.trade.transaction.mapper.AttendMapper;
import com.hust.trade.transaction.model.Attend;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendService {

  @Autowired
  private AttendMapper attendMapper;

  public List<Attend> getAllAttendMessageByUserId(Long id) {
    return attendMapper.getAllAttendMessageByUserId(id);
  }

  //根据两个条件查询
  public Integer findCount(Attend attend){
    QueryWrapper<Attend> query = new QueryWrapper<>();
    query.eq("user_id",attend.getUserId()).eq("message_id",attend.getMessageId());
    //直接通过以上的两句代码实现条件查询计数，之后调用集成好的selectCount就ok了。
    return attendMapper.selectCount(query);
  }

  public void add(Attend attend){
    attendMapper.insert(attend);
  }
  public void delete(Attend attend){
    QueryWrapper<Attend> query = new QueryWrapper<>();
    query.eq("message_id",attend.getMessageId());
    attendMapper.delete(query);
  }

}
