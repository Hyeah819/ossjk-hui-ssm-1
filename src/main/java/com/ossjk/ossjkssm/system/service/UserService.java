package com.ossjk.ossjkssm.system.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ossjk.core.base.service.BaseService;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.system.entity.User;

public interface UserService extends BaseService<User> {

	// 通过名字查询用户
	User selectByName(String name);

	// 查询所有用户
	List<User> selectAll();

	// 查询所有用户(分页)
	Page<User> selectPage(Page page);

	// 批量删除
	int batchDelete(Integer[] ids);

	// 通过名字模糊查询用户
	Page<User> selectByLikeName(Page page, String name,String oname,String phone,String email);

}
