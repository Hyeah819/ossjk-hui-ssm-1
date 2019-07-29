package com.ossjk.ossjkssm.system.mapper;

import java.util.List;

import com.ossjk.core.base.mapper.BaseMapper;
import com.ossjk.ossjkssm.system.entity.Organization;

public interface OrganizationMapper extends BaseMapper<Organization> {

	// 查询所有组织
	List<Organization> selectAllOrganization();

	// 查询单个组织
	Organization selectOrganization(Integer id);

	// 通过名字查询组织
	List<Organization> selectOrganizationByName(String name);

	// 批量删除组织
	int batchDelete(Integer[] ids);

	// 增加组织
	int insertOrganization(Organization organization);

	// 修改组织
	int updateOrganization(Organization organization);

	// 删除组织
	int deleteOrganization(Integer id);

}
