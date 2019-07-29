package com.ossjk.ossjkssm.system.service;

import java.util.List;

import com.ossjk.core.base.service.BaseService;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.system.entity.DeviceType;

public interface DeviceTypeService extends BaseService<DeviceType> {

	// 查询所有设备类型(分页查询)
	Page<DeviceType> selectAll(Page page);
	
	// 查询所有设备类型
	List<DeviceType> selectAllDeviceType();

	// 查询单个设备类型
	DeviceType selectDeviceType(Integer id);

	// 通过键查询设备类型
	Page<DeviceType> selectDeviceTypeByDkey(Page page,String dkey);

	// 批量删除设备类型
	int batchDelete(Integer[] ids);

	// 增加设备类型
	int insertDeviceType(DeviceType DeviceType);

	// 修改设备类型
	int updateDeviceType(DeviceType DeviceType);

	// 删除设备类型
	int deleteDeviceType(Integer id);

}
