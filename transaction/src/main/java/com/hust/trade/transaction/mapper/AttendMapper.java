package com.hust.trade.transaction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hust.trade.transaction.model.Attend;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AttendMapper extends BaseMapper<Attend> {

  List<Attend> getAllAttendMessageByUserId(@Param("id") Long id);

}
