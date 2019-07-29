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
import com.ossjk.ossjkssm.system.entity.Dictionary;
import com.ossjk.ossjkssm.system.entity.Organization;
import com.ossjk.ossjkssm.system.service.DictionaryService;
import com.ossjk.ossjkssm.system.service.OrganizationService;

@Controller
@RequestMapping("/system/organization")
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService;

	/**
	 * 组织列表
	 */
	@RequestMapping("/list")
	public String list(Page page,String name, ModelMap map) {
		map.put("name", name);
		if (name!=null&&!"".equals(name)) {
			//查询单个组织
			map.put("page", organizationService.selectOrganizationByName(page, name));
		} else {
			//查询所有组织
			map.put("page", organizationService.selectAll(page));
		}
		return "system/organization/list";
	}

	/**
	 * 增加界面
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "system/organization/edit";
	}

	/**
	 * 修改界面
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap map) {
		map.put("record", organizationService.selectOrganization(id));
		return "system/organization/edit";
	}

	/**
	 * 增加操作
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Organization organization) {
		Date date=new Date();
		organization.setCrtm(date);
		if (organizationService.insertOrganization(organization) > 0) {
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
	public Object update(Organization organization) {
		Date date=new Date();
		organization.setMdtm(date);
		if (organizationService.updateOrganization(organization) > 0) {
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
		if (organizationService.deleteOrganization(id) > 0) {
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
		if (organizationService.batchDelete(ids) > 0) {
			return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
		} else {
			return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
		}
	}
	
}
