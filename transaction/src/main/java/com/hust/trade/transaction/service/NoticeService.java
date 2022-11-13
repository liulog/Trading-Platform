package com.hust.trade.transaction.service;

import com.hust.trade.transaction.mapper.NoticeMapper;
import com.hust.trade.transaction.model.Notice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
  @Autowired
  NoticeMapper noticeMapper;

  public List<Notice> findAll(){
    return noticeMapper.selectList(null);
  }
}
