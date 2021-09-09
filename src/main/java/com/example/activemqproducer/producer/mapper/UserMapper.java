package com.example.activemqproducer.producer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.activemqproducer.producer.Po.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
