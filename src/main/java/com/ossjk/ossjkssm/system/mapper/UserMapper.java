package com.ossjk.ossjkssm.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ossjk.core.base.mapper.BaseMapper;
import com.ossjk.ossjkssm.system.entity.User;

public interface UserMapper extends BaseMapper<User> {

	// 通过名字查询用户
	User selectByName(String name);

	// 查询所有用户
	List<User> selectAll();

	// 批量删除用户
	int batchDelete(Integer[] ids);

	// 模糊查询用户
	List<User> selectByLikeName(@Param("name")String name,@Param("oname")String oname,@Param("phone")String phone,@Param("email")String email);

}