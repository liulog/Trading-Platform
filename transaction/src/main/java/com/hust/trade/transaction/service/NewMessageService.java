package com.hust.trade.transaction.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hust.trade.transaction.mapper.NewMessageMapper;
import com.hust.trade.transaction.model.Attend;
import com.hust.trade.transaction.model.NewMessage;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewMessageService {


  @Autowired
  private NewMessageMapper newMessageMapper;

  public List<NewMessage> getAllNewMessage(Long userId) {
    return newMessageMapper.getAllNewMessage(userId);
  }

  public NewMessage getLastNewMessage(Long id) {
    return newMessageMapper.getLastNewMessage(id);
  }

  public void add(NewMessage newMessage) {
    newMessageMapper.insert(newMessage);
  }

  public void delete(NewMessage newMessage) {
    QueryWrapper<NewMessage> query = new QueryWrapper<>();
    query.eq("message_id",newMessage.getMessageId());
    newMessageMapper.delete(query);
  }
}
