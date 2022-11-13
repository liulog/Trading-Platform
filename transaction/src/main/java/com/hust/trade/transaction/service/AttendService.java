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

  public List<Attend> getAllAttendMessageByUserId(Integer id) {
    return attendMapper.getAllAttendMessageByUserId(id);
  }

  public Integer findCount(Attend attend){
    QueryWrapper<Attend> query = new QueryWrapper<>();
    query.eq("attend_id",attend.getAttendId());
    //直接通过以上的两句代码实现条件查询计数，之后调用集成好的selectCount就ok了。
    return attendMapper.selectCount(query);
  }

  public void add(Attend attend){
    attendMapper.insert(attend);
  }
  public void delete(Attend attend){
    attendMapper.deleteById(attend.getAttendId());
  }

}
