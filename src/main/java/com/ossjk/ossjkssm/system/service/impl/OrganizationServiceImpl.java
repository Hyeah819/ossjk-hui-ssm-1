package com.ossjk.ossjkssm.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ossjk.core.base.service.impl.BaseServiceImpl;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.system.entity.Dictionary;
import com.ossjk.ossjkssm.system.entity.Organization;
import com.ossjk.ossjkssm.system.mapper.OrganizationMapper;
import com.ossjk.ossjkssm.system.service.OrganizationService;

@Service
public class OrganizationServiceImpl extends BaseServiceImpl<OrganizationMapper, Organization>
		implements OrganizationService {

	// 查询所有组织(分页查询)
	@Override
	public Page<Organization> selectAll(Page page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		page.toPage(new PageInfo(baseMapper.selectAllOrganization()));
		return page;
	}

	// 查询所有组织
	@Override
	public List<Organization> selectAllOrganization() {
		return baseMapper.selectAllOrganization();
	}

	// 查询单个组织
	@Override
	public Organization selectOrganization(Integer id) {
		return baseMapper.selectOrganization(id);
	}

	// 通过名字查询组织
	@Override
	public Page<Organization> selectOrganizationByName(Page page,String name) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		page.toPage(new PageInfo(baseMapper. selectOrganizationByName(name)));
		return page;
	}

	// 批量删除组织
	@Override
	public int batchDelete(Integer[] ids) {
		return baseMapper.batchDelete(ids);
	}

	// 增加组织
	@Override
	public int insertOrganization(Organization organization) {
		return baseMapper.insertOrganization(organization);
	}

	// 修改组织
	@Override
	public int updateOrganization(Organization organization) {
		return baseMapper.updateOrganization(organization);
	}

	// 删除组织
	@Override
	public int deleteOrganization(Integer id) {
		return baseMapper.deleteOrganization(id);
	}
}
