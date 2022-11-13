package com.hust.trade.transaction.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hust.trade.transaction.model.Comment;
import com.hust.trade.transaction.model.CommentReply;
import com.hust.trade.transaction.model.Message;
import com.hust.trade.transaction.model.MessageImages;
import com.hust.trade.transaction.model.User;
import com.hust.trade.transaction.service.CommentReplyService;
import com.hust.trade.transaction.service.CommentService;
import com.hust.trade.transaction.service.MessageDetailService;
import com.hust.trade.transaction.service.MessageImagesService;
import com.hust.trade.transaction.service.UserService;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetMessageDetailController {

  @Autowired
  private MessageDetailService messageDetailService;
  @Autowired
  private MessageImagesService messageImagesService;
  @Autowired
  private CommentService commentService;
  @Autowired
  private CommentReplyService commentReplyService;
  @Autowired
  private UserService userService;

  /**
   * 获取某一页所有消息
   * @param pageNumber 当前的页数
   * @return 返回当前页的所有消息
   */
  @PostMapping("/getMessage/getAllMessageDetail/{pageNumber}")
  public List<Message> getAllMessageDetail(@PathVariable Integer pageNumber) {

    PageHelper.startPage(pageNumber, 8);

    PageInfo<Message> pageInfo = new PageInfo<Message>(messageDetailService.getAllMessage());

    if (pageInfo.getPageNum() < pageNumber) {
      List list1 = new LinkedList();
      list1.add(200);
      return list1;
    }
    List<Message> allMessage = pageInfo.getList();

    return getImage(allMessage, userService, messageImagesService);
  }

  /**
   * 获取不同 类别的一页的消息
   * @param categoryId 类别id
   * @param pageNumber 页码
   * @return 返回该页的所有消息
   */
  @PostMapping("/getMessage/getAllMessageDetail/{categoryId}/{pageNumber}")
  public List<Message> getMessageByCategoryId(@PathVariable Integer categoryId, @PathVariable Integer pageNumber) {
    PageHelper.startPage(pageNumber, 8);

    PageInfo<Message> pageInfo = new PageInfo<>(messageDetailService.getMessageByCategoryId(categoryId));

    if (pageInfo.getPageNum() < pageNumber) {
      List list1 = new LinkedList();
      list1.add(200);
      return list1;
    }
    List<Message> allMessage = pageInfo.getList();
    return getImage(allMessage, userService, messageImagesService);
  }

  /**
   * 获取 消息的图片
   * @param allMessage 所有的消息
   * @param userService user服务
   * @param messageImagesService messageImage服务
   * @return 得到图片后的消息列表
   */
  public List<Message> getImage(List<Message> allMessage, UserService userService, MessageImagesService messageImagesService) {
    for (int i = 0; i < allMessage.size(); i++) {
      allMessage.get(i).setUser(userService.getById(allMessage.get(i).getUserId()));
      MessageImages messageImages = new MessageImages();
      messageImages.setMessageId(allMessage.get(i).getMessageId());
      allMessage.get(i).setMessageImages(messageImagesService.findList(messageImages));
    }
    return allMessage;
  }

  /**
   * 获取某一消息的具体信息
   * @param id messageid
   * @return 查询到的消息
   */
  @PostMapping("/getMessageDetailById/{id}")
  public Message getMessageDetailById(@PathVariable Integer id) {
    Message message = messageDetailService.getById(id);

    if (message == null) {
      return null;
    }

    Comment comment = new Comment();
    comment.setMessageId(id);
    List<Comment> comments = commentService.findList(comment);
    message.setComments(comments);
    User user = userService.getById(message.getUserId());
    message.setUser(user);


    MessageImages messageImages = new MessageImages();
    messageImages.setMessageId(id);
    message.setMessageImages(messageImagesService.findList(messageImages));

    Integer messageWatch = message.getMessageWatch();

    Message message1 = new Message();
    message1.setMessageId(id);
    message1.setMessageWatch(messageWatch + 1);
    message1.setMessageComment(comments.size());
    messageDetailService.update(message1);

    if (comments.size() == 0) {
      return message;
    }


    for (int i = 0; i < comments.size(); i++) {
      CommentReply commentReply = new CommentReply();
      commentReply.setCommentId(comments.get(i).getCommentId());
      comments.get(i).setCommentReplies(commentReplyService.findList(commentReply));
      comments.get(i).setUser(userService.getById(comments.get(i).getUserId()));
    }
    message.setComments(comments);
    return message;
  }

  /**
   * 根据用户id获取消息
   * @param userId 用户id
   * @param pageNumber 页数
   * @return 得到的消息
   */
  @PostMapping("/getMessage/getMessageDetailByUserId/{userId}/{pageNumber}")
  public List<Message> getMessageDetailByUserId(@PathVariable Integer userId, @PathVariable Integer pageNumber) {

    User user = userService.getById(userId);

    if (user.getUserIsAdmin() == 2) {
      PageHelper.startPage(pageNumber, 5);
      PageInfo<Message> pageInfo = new PageInfo<Message>(messageDetailService.getAllMessage());
      List<Message> list = pageInfo.getList();
      getImage(list, userService, messageImagesService);
      if (pageInfo.getPageNum() < pageNumber) {
        List list1 = new LinkedList();
        list1.add(200);
        return list1;
      }
      return list;
    } else {
      PageHelper.startPage(pageNumber, 3);
      PageInfo<Message> pageInfo = new PageInfo<Message>(messageDetailService.getMessageDetailByUserId(userId));
      List<Message> list = pageInfo.getList();
      getImage(list, userService, messageImagesService);
      if (pageInfo.getPageNum() < pageNumber) {
        List list1 = new LinkedList();
        list1.add(200);
        return list1;
      }
      return list;

    }


  }

}
