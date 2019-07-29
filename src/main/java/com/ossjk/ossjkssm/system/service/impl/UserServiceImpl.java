package com.ossjk.ossjkssm.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ossjk.core.base.service.impl.BaseServiceImpl;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.system.entity.User;
import com.ossjk.ossjkssm.system.mapper.UserMapper;
import com.ossjk.ossjkssm.system.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

	// 通过名字查询用户
	@Override
	public User selectByName(String name) {
		return baseMapper.selectByName(name);
	}

	// 查询所有用户
	@Override
	public List<User> selectAll() {
		return baseMapper.selectAll();
	}

	// 查询所有用户(分页)
	@Override
	public Page<User> selectPage(Page page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		page.toPage(new PageInfo(baseMapper.selectAll()));
		return page;
	}

	// 批量删除
	@Override
	public int batchDelete(Integer[] ids) {
		return baseMapper.batchDelete(ids);
	}

	// 通过名字模糊查询用户
	@Override
	public Page<User> selectByLikeName(Page page, String name,String oname,String phone,String email) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		page.toPage(new PageInfo(baseMapper.selectByLikeName(name,oname,phone,email)));
		return page;
	}

}
