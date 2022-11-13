package com.hust.trade.transaction.utils;


import com.hust.trade.transaction.model.User;
import com.hust.trade.transaction.service.UserService;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class IsLogin {

  private Integer code;

  private Integer userId;

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  /**
   * 用户登录判断
   *
   * @param user 用户
   * @param openid 用户账号
   * @param userService 用户服务
   * @return IsLogin对象
   */
  public IsLogin isTrue(User user, String openid, UserService userService) {
    User user1 = new User();
    user1.setUserOpenid(openid);

    IsLogin isLogin = new IsLogin();
    isLogin.setCode(500);
    List<User> userMessageByOtherMessage = userService.getUserMessageByOtherMessage(user1);

    try {
      if (userMessageByOtherMessage.size() == 1) {
        userService.updateUserMessage(user);
        isLogin.setCode(200);//老用户
        isLogin.setUserId(userMessageByOtherMessage.get(0).getUserId());
      } else {
        userService.insertUserMessage(user);
        isLogin.setUserId(user.getUserId());
        isLogin.setCode(300);//新用户
      }
    } catch (Exception e) {
      e.printStackTrace();
      isLogin.setCode(500);//出现错误
    }
    return isLogin;
  }


}
