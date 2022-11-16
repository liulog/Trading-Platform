package com.hust.trade.transaction.utils;


import com.hust.trade.transaction.model.User;
import com.hust.trade.transaction.service.UserService;
import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class IsLogin {

  private Integer code; //返回状态码

  private Long userId;  //登录-用户id

  /**
   * 用户登录判断
   * @param user 用户
   * @param openid 用户openid
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
      if (userMessageByOtherMessage.size() == 1) {  //根据openid查到了对应的用户
        userService.updateUserMessage(user);
        isLogin.setCode(200);//老用户
        isLogin.setUserId(userMessageByOtherMessage.get(0).getUserId());  //用户id
      } else {
        userService.insertUserMessage(user);      //没有查到对应的用户
        isLogin.setUserId(user.getUserId());
        isLogin.setCode(300);//新用户
      }
    } catch (Exception e) {                       //出现了错误
      e.printStackTrace();
      isLogin.setCode(500);//出现错误
    }
    return isLogin;
  }


}
