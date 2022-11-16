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
import java.util.Objects;
import lombok.Data;

@Data
public class IsDelete {

  /**
   * 500 服务器错误
   * 200 上传成功
   * 403 不允许发布,拉黑
   * 400 数据出现问题
   * 401  未登录
   * 1000 非法入侵
   */

  private Integer code; //返回的状态码

  public IsDelete isDelete(Long userId, Long messageId, MessageImagesService messageImagesService, UserService userService, MessageDetailService messageDetailService, AttendService attendService, CollectService collectService, NewMessageService newMessageService) {
    IsDelete isDelete = new IsDelete(); //新建删除
    isDelete.setCode(500);

    User user = userService.getById(userId);  //获取用户

    if (user == null) {
      isDelete.setCode(1000);
      return isDelete;
    }

    Message message = messageDetailService.getById(messageId);  //根据messageId删除消息

    if (user.getUserIsAdmin() == 2 || Objects.equals(message.getUserId(), user.getUserId())) {  //管理员删除或者用户自己删除

      /**
       * 删除对应评论
       */
      messageDetailService.deleteCommentAndReply(messageId);
      /**
       * 删除我的参与
       */
      Attend attend = new Attend();
      attend.setMessageId(messageId);
      attendService.delete(attend); //根据messageid删除attend
      /**
       * 删除"我的收藏"
       */
      Collect collect = new Collect();
      collect.setMessageId(messageId);
      collectService.delete(collect); //根据messageid删除collect

      /**
       * 删除消息
       */
      NewMessage newMessage = new NewMessage();
      newMessage.setMessageId(messageId);
      newMessageService.delete(newMessage); //根据messageid删除new message

      messageDetailService.deleteById(messageId);     //删除新消息
      MessageImages messageImages = new MessageImages();
      messageImages.setMessageId(messageId);
      List<MessageImages> images = messageImagesService.findList(messageImages);
      messageImagesService.delete(messageImages);

      // Endpoint:杭州
      String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
      // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高
      String accessKeyId = "LTAI5tPzQFLdVPKQjkJeg2Zx";
      String accessKeySecret = "vkIfo2dX8WjrVttFv6Px6Ck9b7pFkK";
      String bucketName = "tradeplatform1";

      // 创建OSSClient实例，删除oss
      OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
      DeleteAliyunFile deleteAliyunFile = new DeleteAliyunFile();

      for (int i = 0; i < images.size(); i++) {
        String objectName = images.get(i).getImageUrl();
        deleteAliyunFile.DeleteAliyunFile(objectName, ossClient, bucketName);
      }
      // 关闭OSSClient。
      ossClient.shutdown();

      isDelete.setCode(200);
    }
    return isDelete;
  }
}
