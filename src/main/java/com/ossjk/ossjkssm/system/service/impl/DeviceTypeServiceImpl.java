package com.ossjk.ossjkssm.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ossjk.core.base.service.impl.BaseServiceImpl;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.system.entity.DeviceType;
import com.ossjk.ossjkssm.system.mapper.DeviceTypeMapper;
import com.ossjk.ossjkssm.system.service.DeviceTypeService;

@Service
public class DeviceTypeServiceImpl extends BaseServiceImpl<DeviceTypeMapper, DeviceType> implements DeviceTypeService {
	
	// 查询所有设备类型(分页)
	@Override
	public Page<DeviceType> selectAll(Page page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		page.toPage(new PageInfo(baseMapper.selectAllDeviceType()));
		return page;
	}

	// 查询所有设备类型
	@Override
	public List<DeviceType> selectAllDeviceType() {
		return baseMapper.selectAllDeviceType();
	}

	// 查询单个设备类型
	@Override
	public DeviceType selectDeviceType(Integer id) {
		return baseMapper.selectDeviceType(id);
	}

	// 通过键查询设备类型
	@Override
	public Page<DeviceType> selectDeviceTypeByDkey(Page page, String dkey) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		page.toPage(new PageInfo(baseMapper.selectDeviceTypeByDkey(dkey)));
		return page;
	}

	// 批量删除设备类型
	@Override
	public int batchDelete(Integer[] ids) {
		return baseMapper.batchDelete(ids);
	}

	// 增加设备类型
	@Override
	public int insertDeviceType(DeviceType DeviceType) {
		return baseMapper.insertDeviceType(DeviceType);
	}

	// 修改设备类型
	@Override
	public int updateDeviceType(DeviceType DeviceType) {
		return baseMapper.updateDeviceType(DeviceType);
	}

	// 删除设备类型
	@Override
	public int deleteDeviceType(Integer id) {
		return baseMapper.deleteDeviceType(id);
	}
}
