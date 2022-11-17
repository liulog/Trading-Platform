package com.hust.trade.transaction.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hust.trade.transaction.mapper.MessageMapper;
import com.hust.trade.transaction.model.Message;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageDetailService {

  @Autowired
  private MessageMapper messageMapper;

  public Message getLostMessage() {
    return messageMapper.getLostMessage();
  }

  public void insertMessageDetail(Message message) {
    messageMapper.insert(message);
  }

  public List<Message> getAllMessage() {
    return messageMapper.getAllMessage();
  }

  /**
   * 查询分类所有
   *
   * @param id
   * @return
   */
  public List<Message> getMessageByCategoryId(Integer id) {
    return messageMapper.getMessageByCategoryId(id);
  }

  /**
   * 在分类里查询信息
   */

  public List<Message> getMessageByCategoryAndKeyword(Long id, String keyword) {
    return messageMapper.getMessageByCategoryAndKeyword(id, keyword);
  }

  /**
   * 全局查询
   */
  public List<Message> getMessageByKeyword(String keyword){
    return messageMapper.getMessageByKeyword(keyword);
  }

  /**
   * 通过用户id查询
   */
  public List<Message> getMessageDetailByUserId(Long userId) {
    return messageMapper.getMessageDetailByUserId(userId);
  }

  /**
   * 删除对应信息下的所有评论以及回复
   */
  public void deleteCommentAndReply(Long messageId) {
    messageMapper.deleteCommentAndReply(messageId);
  }

  public Message getById(Long id){
    return messageMapper.selectById(id);
  }

  public void update(Message message){
    messageMapper.updateById(message);
  }

  public void deleteById(Long id){
    messageMapper.deleteById(id);
  }

  public Integer findCount(Message message){
    QueryWrapper<Message> query = new QueryWrapper<>();
    query.eq("message_id",message.getMessageId());
    //直接通过以上的两句代码实现条件查询计数，之后调用集成好的selectCount就ok了。
    return messageMapper.selectCount(query);
  }
}