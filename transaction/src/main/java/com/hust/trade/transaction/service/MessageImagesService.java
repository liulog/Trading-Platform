package com.hust.trade.transaction.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hust.trade.transaction.mapper.MessageImagesMapper;
import com.hust.trade.transaction.model.MessageImages;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageImagesService {
  @Autowired
  MessageImagesMapper messageImagesMapper;
  public List<MessageImages> findList(MessageImages messageImages){
    QueryWrapper<MessageImages> query = new QueryWrapper<>();
    query.eq("message_id",messageImages.getMessageId());
    return messageImagesMapper.selectList(query);
  }
  public void delete(MessageImages messageImages){
    messageImagesMapper.deleteById(messageImages.getMessageId());
  }
  public void add(MessageImages messageImages){
    messageImagesMapper.insert(messageImages);
  }
}
