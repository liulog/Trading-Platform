package com.hust.trade.transaction.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hust.trade.transaction.mapper.UserMapper;
import com.hust.trade.transaction.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserMapper userMapper;

  /**
   * 新用户插入
   *
   * @param user
   * @return
   */
  public Integer insertUserMessage(User user){
    return userMapper.insertUserMessage(user);
  }

  public void updateUserMessage(User user){
    userMapper.updateById(user);
  }

  /**
   * 通过id查找
   * @param id
   * @return
   */
  public User getById(Integer id){
    return userMapper.selectById(id);
  }

  /**
   * 更新用户信息
   *
   * @param user
   */
//  public void updateUserMessage(User user) {
//    userMapper.updateByPrimaryKey(user);
//  }

  /**
   * 返回符合条件的用户信息
   *
   * @param user 用户
   */
  public List<User> getUserMessageByOtherMessage(User user) {
    QueryWrapper<User> qw = new QueryWrapper<>();
    qw.eq("user_id",user.getUserId());
    return userMapper.selectList(qw);
  }

}
