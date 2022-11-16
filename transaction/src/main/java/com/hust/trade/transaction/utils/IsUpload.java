package com.hust.trade.transaction.utils;

import com.hust.trade.transaction.model.Message;
import com.hust.trade.transaction.model.MessageImages;
import com.hust.trade.transaction.model.User;
import com.hust.trade.transaction.service.MessageDetailService;
import com.hust.trade.transaction.service.MessageImagesService;
import com.hust.trade.transaction.service.UserService;
import java.util.List;
import lombok.Data;

@Data
public class IsUpload {

  /**
   * 500 服务器错误
   * 200 上传成功
   * 403 不允许发布,拉黑
   * 400 数据出现问题
   * 401  未登录
   * 1000 非法入侵
   */
  private Integer code;   //要返回的状态码

  /**
   * 发布消息
   * @param message 具体的消息
   * @param messageDetailService 消息内容
   * @param messageImagesService 消息图片
   * @param userService 用户
   * @return
   */
  public IsUpload isTrue(Message message, MessageDetailService messageDetailService, MessageImagesService messageImagesService, UserService userService) {
    IsUpload isUpload = new IsUpload();   //新建发布

    User user = userService.getById(message.getUserId()); //发布的用户id

    if (user == null) {                  //用户不存在
      isUpload.setCode(1000);
      return isUpload;
    }

    if(user.getUserAllow()!=1){         //用户被限制发布消息
      isUpload.setCode(301);
      return isUpload;
    }

    List<String> resultImage = message.getResultImage();  //获取图片url

    messageDetailService.insertMessageDetail(message);    //插入到数据库中

    for (int i = 0; i < resultImage.size(); i++) {        //添加图片
      MessageImages messageImages = new MessageImages();
      messageImages.setImageUrl(resultImage.get(i));
      messageImages.setMessageId(message.getMessageId());
      messageImagesService.add(messageImages);
    }

    isUpload.setCode(200);

    return isUpload;
  }
}
