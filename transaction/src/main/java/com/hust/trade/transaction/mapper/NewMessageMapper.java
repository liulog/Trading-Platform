package com.hust.trade.transaction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hust.trade.transaction.model.NewMessage;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface NewMessageMapper extends BaseMapper<NewMessage> {
  List<NewMessage> getAllNewMessage(@Param("id") Integer userId);
  NewMessage getLastNewMessage(@Param("id") Integer id);
}
