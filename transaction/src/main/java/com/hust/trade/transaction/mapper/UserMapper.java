package com.hust.trade.transaction.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hust.trade.transaction.model.User;
import org.apache.ibatis.annotations.Mapper;


// TODO 添加@Mapper 把UserMapper交给spring来管理
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
