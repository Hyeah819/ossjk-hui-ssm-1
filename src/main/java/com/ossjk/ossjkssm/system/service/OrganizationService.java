package com.ossjk.ossjkssm.system.service;

import java.util.List;

import com.ossjk.core.base.service.BaseService;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.system.entity.Dictionary;
import com.ossjk.ossjkssm.system.entity.Organization;

public interface OrganizationService extends BaseService<Organization> {

	// 查询所有组织(分页查询)
	Page<Organization> selectAll(Page page);

	// 查询所有组织
	List<Organization> selectAllOrganization();

	// 查询单个组织
	Organization selectOrganization(Integer id);

	// 通过名字查询组织
	Page<Organization> selectOrganizationByName(Page page,String name);

	// 批量删除组织
	int batchDelete(Integer[] ids);

	// 增加组织
	int insertOrganization(Organization organization);

	// 修改组织
	int updateOrganization(Organization organization);

	// 删除组织
	int deleteOrganization(Integer id);

}
