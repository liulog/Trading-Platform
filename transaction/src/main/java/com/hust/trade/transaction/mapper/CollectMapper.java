package com.hust.trade.transaction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hust.trade.transaction.model.Collect;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CollectMapper extends BaseMapper<Collect> {

  List<Collect> getAllCollectionMessageByUserId(@Param("id") Integer userId);

}
