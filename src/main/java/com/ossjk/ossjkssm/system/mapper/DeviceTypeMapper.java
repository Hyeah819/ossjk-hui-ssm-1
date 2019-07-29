package com.ossjk.ossjkssm.system.mapper;

import java.util.List;

import com.ossjk.core.base.mapper.BaseMapper;
import com.ossjk.ossjkssm.system.entity.DeviceType;

public interface DeviceTypeMapper extends BaseMapper<DeviceType> {

	// 查询所有设备类型
	List<DeviceType> selectAllDeviceType();

	// 查询单个设备类型
	DeviceType selectDeviceType(Integer id);

	// 通过键查询设备类型
	List<DeviceType> selectDeviceTypeByDkey(String dkey);

	// 批量删除设备类型
	int batchDelete(Integer[] ids);

	// 增加设备类型
	int insertDeviceType(DeviceType DeviceType);

	// 修改设备类型
	int updateDeviceType(DeviceType DeviceType);

	// 删除设备类型
	int deleteDeviceType(Integer id);

}
