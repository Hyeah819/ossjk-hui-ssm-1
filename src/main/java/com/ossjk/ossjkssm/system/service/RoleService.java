package com.ossjk.ossjkssm.system.service;

import java.util.List;

import com.ossjk.core.base.service.BaseService;
import com.ossjk.ossjkssm.system.entity.Role;

public interface RoleService extends BaseService<Role>{

	// 查询所有角色
	List<Role> selectAllRole();

}
