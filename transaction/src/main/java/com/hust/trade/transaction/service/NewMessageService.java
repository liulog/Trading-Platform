package com.hust.trade.transaction.service;

import com.hust.trade.transaction.mapper.NewMessageMapper;
import com.hust.trade.transaction.model.NewMessage;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewMessageService {


  @Autowired
  private NewMessageMapper newMessageMapper;

  public List<NewMessage> getAllNewMessage(Integer userId) {
    return newMessageMapper.getAllNewMessage(userId);
  }

  public NewMessage getLastNewMessage(Integer id) {
    return newMessageMapper.getLastNewMessage(id);
  }

  public void add(NewMessage newMessage) {
    newMessageMapper.insert(newMessage);
  }

  public void delete(NewMessage newMessage) {
    newMessageMapper.deleteById(newMessage.getMessageId());
  }
}
