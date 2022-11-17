package com.hust.trade.transaction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hust.trade.transaction.model.Message;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MessageMapper extends BaseMapper<Message> {

  /**
   * 获取失物招领的信息
   * @return 失物招领的第一条信息
   */
  Message getLostMessage();

  /**
   * 插入具体的信息
   * @param message
   * @return
   */
  List<Message> getAllMessage();
  List<Message> getMessageByCategoryId(@Param("id") Integer id);
  List<Message> getMessageByCategoryAndKeyword(@Param("id") Long id,@Param("keyword") String keyword);
  List<Message> getMessageByKeyword(@Param("keyword") String keyword);
  List<Message> getMessageDetailByUserId(@Param("id") Long userId);
  void deleteCommentAndReply(@Param("id") Long messageId);
}
