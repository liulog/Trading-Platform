package com.hust.trade.transaction.controller;

import com.hust.trade.transaction.model.User;
import com.hust.trade.transaction.model.WXSessionModel;
import com.hust.trade.transaction.service.UserService;
import com.hust.trade.transaction.utils.HttpClientUtil;
import com.hust.trade.transaction.utils.IsLogin;
import com.hust.trade.transaction.utils.JsonUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
  @Autowired
  private UserService userService;

  /**
   * 前端 登录功能
   * @param code 获取登录的临时凭证
   * @param user 用户信息（json格式）
   * @return 发给前端IsLogin实体
   */
  @Transactional
  @PostMapping("/Login")
  public IsLogin Login(String code, @RequestBody User user) {
    String url = "https://api.weixin.qq.com/sns/jscode2session";
    Map<String, String> param = new HashMap<>();
    param.put("appid", "wx7998b30adc2c9ed5");
    param.put("secret", "b105656a75b9295216645fa594804343");
    param.put("js_code", code);
    param.put("grant_type", "authorization_code");

    String wxResult = HttpClientUtil.doGet(url, param); //从url处获取这些param
    WXSessionModel wxSessionModel = JsonUtils.jsonToPojo(wxResult, WXSessionModel.class);//将接收的wxResult转换成实体对象
    String openid = wxSessionModel.getOpenid(); //获取openid
    user.setUserOpenid(openid);                 //设置用户的openid
    return new IsLogin().isTrue(user, openid, userService); //返回用户的登录的状态
  }

  /**
   * 检查是否是管理员 根据userid查找
   * @param id 设置用户id
   * @return 用户列表
   */
  @PostMapping("/checkAdmin")
  public List<User> checkAdmin(Long id) {
    User user = new User();
    user.setUserId(id);
    return userService.getUserMessageByOtherMessage(user);
  }
}
