package com.ossjk.ossjkssm.system.mapper;

import java.util.List;

import com.ossjk.core.base.mapper.BaseMapper;
import com.ossjk.ossjkssm.system.entity.Role;

public interface RoleMapper extends BaseMapper<Role>{

	// 查询所有角色
	List<Role> selectAllRole();

}
