package com.ossjk.ossjkssm.system.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ossjk.core.vo.AjaxReturn;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.common.Constant;
import com.ossjk.ossjkssm.system.entity.DeviceType;
import com.ossjk.ossjkssm.system.service.DeviceTypeService;

@Controller
@RequestMapping("/system/devicetype")
public class DeviceTypeController {

	@Autowired
	private DeviceTypeService deviceTypeService;

	/**
	 * 设备类型列表
	 */
	@RequestMapping("/list")
	public String list(String name,Page page, ModelMap map) {
		map.put("name", name);
		if (name!=null&&!"".equals(name)) {
			//查询单个设备类型
			map.put("page", deviceTypeService.selectDeviceTypeByDkey(page, name));
		} else {
			//查询所有设备类型
			map.put("page", deviceTypeService.selectAll(page));
		}
		return "system/devicetype/list";
	}

	/**
	 * 增加界面
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "system/devicetype/edit";
	}

	/**
	 * 修改界面
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap map) {
		map.put("record", deviceTypeService.selectDeviceType(id));
		return "system/devicetype/edit";
	}

	/**
	 * 增加操作
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(DeviceType deviceType) {
		Date date=new Date();
		deviceType.setCrtm(date);
		if (deviceTypeService.insertDeviceType(deviceType) > 0) {
			return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
		} else {
			return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
		}
	}

	/**
	 * 修改操作
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Object update(DeviceType deviceType) {
		Date date=new Date();
		deviceType.setMdtm(date);
		if (deviceTypeService.updateDeviceType(deviceType) > 0) {
			return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
		} else {
			return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
		}
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(Integer id) {
		if (deviceTypeService.deleteDeviceType(id) > 0) {
			return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
		} else {
			return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
		}
	}

	/**
	 * 批量删除
	 */
	@RequestMapping("/batchDelete")
	@ResponseBody
	public Object batchDelete(Integer[] ids) {
		if (deviceTypeService.batchDelete(ids) > 0) {
			return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
		} else {
			return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
		}
	}
}
