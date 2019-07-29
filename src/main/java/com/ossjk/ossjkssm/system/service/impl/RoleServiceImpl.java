package com.ossjk.ossjkssm.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ossjk.core.base.service.impl.BaseServiceImpl;
import com.ossjk.ossjkssm.system.entity.Role;
import com.ossjk.ossjkssm.system.mapper.RoleMapper;
import com.ossjk.ossjkssm.system.service.RoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper, Role> implements RoleService {

	// 查询所有角色
	@Override
	public List<Role> selectAllRole() {
		return baseMapper.selectAllRole();
	}
}
