package com.hust.trade.transaction.controller;

import com.hust.trade.transaction.model.Notice;
import com.hust.trade.transaction.service.NoticeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetNoticeController {
  @Autowired
  private NoticeService noticeService;

  /**
   * 获取所有通知的消息
   * @return “通知”列表
   */
  @PostMapping("/getMessage/getAllNoticeMessage")
  public List<Notice> getAllNoticeMessage() {
    return noticeService.findAll();
  }

}
