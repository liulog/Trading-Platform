package com.hust.trade.transaction.utils;

import com.hust.trade.transaction.model.Collect;
import com.hust.trade.transaction.model.User;
import com.hust.trade.transaction.service.CollectService;
import com.hust.trade.transaction.service.UserService;
import lombok.Data;

@Data
public class IsCollect {

  private Integer code; //返回的状态码


  public IsCollect isTrue(Long userId, Long messageId, CollectService collectService, UserService userService) {
    IsCollect isCollect = new IsCollect();
    isCollect.setCode(500);
    User user = userService.getById(userId);
    if (user == null) {
      isCollect.setCode(400);
      return isCollect;
    }

    Collect collect = new Collect();    //添加到我的收藏
    collect.setUserId(userId);
    collect.setMessageId(messageId);
    collectService.add(collect);

    isCollect.setCode(200);

    return isCollect;
  }
}
