package com.ossjk.ossjkssm.system.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ossjk.core.base.controller.BaseController;
import com.ossjk.core.vo.AjaxReturn;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.common.Constant;
import com.ossjk.ossjkssm.system.entity.User;
import com.ossjk.ossjkssm.system.service.OrganizationService;
import com.ossjk.ossjkssm.system.service.RoleService;
import com.ossjk.ossjkssm.system.service.UserService;

@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private RoleService roleService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public String list(Page page,String name,String oname,String phone,String email,String method, ModelMap map) {
		map.put("name",name);
		map.put("oname",oname);
		map.put("phone",phone);
		map.put("email",email);
		if((name!=null&&!"".equals(name))||(oname!=null&&!"".equals(oname))||(phone!=null&&!"".equals(phone))||(email!=null&&!"".equals(email))) {
			map.put("page", userService.selectByLikeName(page,name,oname,phone,email));
		}
		else {
			map.put("page", userService.selectPage(page));
		}
		return "system/user/list";
	}

	/**
	 * 去增加
	 */
	@RequestMapping("/toInsert")
	public String toInsert(ModelMap map) {
		map.put("organizations", organizationService.selectAllOrganization());
		map.put("roles", roleService.selectAllRole());
		return "system/user/edit";
	}

	/**
	 * 去更新
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap map) {
		map.put("organizations", organizationService.selectAllOrganization());
		map.put("roles", roleService.selectAllRole());
		map.put("record", userService.selectByPrimaryKey(id));
		return "system/user/edit";
	}

	/**
	 * 增加
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(User user) {
		Date date=new Date();
		user.setCrtm(date);
		if (userService.insert(user) > 0) {
			return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
		} else {
			return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
		}
	}

	/**
	 * 更新
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Object update(User user) {
		Date date=new Date();
		user.setMdtm(date);
		if (userService.updateByPrimaryKey(user) > 0) {
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
		if (userService.deleteByPrimaryKey(id) > 0) {
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
		if (userService.batchDelete(ids) > 0) {
			return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
		} else {
			return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
		}
	}
	
}
