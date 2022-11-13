package com.hust.trade.transaction.utils;

import com.aliyun.oss.OSSClient;
import com.hust.trade.transaction.model.Attend;
import com.hust.trade.transaction.model.Collect;
import com.hust.trade.transaction.model.Message;
import com.hust.trade.transaction.model.MessageImages;
import com.hust.trade.transaction.model.NewMessage;
import com.hust.trade.transaction.model.User;
import com.hust.trade.transaction.service.AttendService;
import com.hust.trade.transaction.service.CollectService;
import com.hust.trade.transaction.service.MessageDetailService;
import com.hust.trade.transaction.service.MessageImagesService;
import com.hust.trade.transaction.service.NewMessageService;
import com.hust.trade.transaction.service.UserService;
import java.util.List;

public class IsDelete {

  /**
   * 500 服务器错误
   * 200 上传成功
   * 403 不允许发布,拉黑
   * 400 数据出现问题
   * 401  未登录
   * 1000 非法入侵
   */

  private Integer code;

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public IsDelete isDelete(Integer userId, Integer messageId, MessageImagesService messageImagesService, UserService userService, MessageDetailService messageDetailService, AttendService attendService, CollectService collectService, NewMessageService newMessageService) {
    IsDelete isDelete = new IsDelete();
    isDelete.setCode(500);

    User user = userService.getById(userId);

    if (user == null) {
      isDelete.setCode(1000);
      return isDelete;
    }

    Message message = messageDetailService.getById(messageId);

    if (user.getUserIsAdmin() == 2 || message.getUserId() == user.getUserId()) {

      /**
       * 删除对应评论
       */
      messageDetailService.deleteCommentAndReply(messageId);
      /**
       * 删除我的参与
       */
      Attend attend = new Attend();
      attend.setMessageId(messageId);
      attendService.delete(attend);
      /**
       * 删除收藏
       */
      Collect collect = new Collect();
      collect.setMessageId(messageId);
      collectService.delete(collect);

      /**
       * 删除消息
       */
      NewMessage newMessage = new NewMessage();
      newMessage.setMessageId(messageId);
      newMessageService.delete(newMessage);

      messageDetailService.deleteById(messageId);
      MessageImages messageImages = new MessageImages();
      messageImages.setMessageId(messageId);
      List<MessageImages> images = messageImagesService.findList(messageImages);
      messageImagesService.delete(messageImages);

      // Endpoint以杭州为例，其它Region请按实际情况填写。
      String endpoint = "你的阿里云实际位置地址";
      // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
      String accessKeyId = "你的阿里云id";
      String accessKeySecret = "你的阿里云密钥";
      String bucketName = "oss名称";

      // 创建OSSClient实例。
      OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
      DeleteAliyunFile deleteAliyunFile = new DeleteAliyunFile();

      for (int i = 0; i < images.size(); i++) {
        String objectName = images.get(i).getImageUrl();
        deleteAliyunFile.DeleteAliyunFile(objectName, ossClient, bucketName);
      }
      // 关闭OSSClient。
//            ossClient.shutdown();

      isDelete.setCode(200);
    }
    return isDelete;
  }
}
