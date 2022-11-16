package com.hust.trade.transaction;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hust.trade.transaction.mapper.UserMapper;
import com.hust.trade.transaction.model.User;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransactionApplicationTests {
//
//  @Autowired
//  private UserMapper userMapper;
//
//  @Test
//  void testGetAll(){
//    LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper();
////    wrapper.lt("user_id",2);
////    wrapper.lambda().lt(User::getUserId,3);
//    wrapper.lt(User::getUserId,4);        // 推荐
//    wrapper.gt(User::getUserId,2);
//    List<User> userList = userMapper.selectList(wrapper);
//    System.out.println(userList);
//  }
//
//  @Test
//  void testSave(){
//    User user = new User();
//    user.setUserOpenid("3");
//    user.setUserNickname("jingyuyayaya");
//    user.setUserAvatar("bbb");
//    user.setUserGender(3);
//    int i = userMapper.insertUserMessage(user);
//    System.out.println(i);
//  }
//
//  @Test
//  void testDelete(){
//    userMapper.deleteById(3);
//  }
//
//  // 提供哪些字段就修改哪些字段
//  @Test
//  void testUpdate(){
//    User user = new User();
//    user.setUserOpenid("3");
//    user.setUserNickname("j777");
//    user.setUserAvatar("aaa");
//    user.setUserId(3L);
//    userMapper.updateById(user);
//  }

}
