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
import com.ossjk.ossjkssm.system.service.DictionaryService;

@Controller
@RequestMapping("/system/dictionary")
public class DictionaryController {

	@Autowired
	private DictionaryService dictionaryService;

	/**
	 * 字典列表
	 */
	@RequestMapping("/list")
	public String list(String dkey,Page page, ModelMap map) {
		map.put("dkey", dkey);
		if (dkey!=null&&!"".equals(dkey)) {
			//查询单个字典
			map.put("page", dictionaryService.selectDictionaryByDkey(page, dkey));
		} else {
			//查询所有字典
			map.put("page", dictionaryService.selectAll(page));
		}
		return "system/dictionary/list";
	}

	/**
	 * 增加界面
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "system/dictionary/edit";
	}

	/**
	 * 修改界面
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap map) {
		map.put("record", dictionaryService.selectDictionary(id));
		return "system/dictionary/edit";
	}

	/**
	 * 增加操作
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Dictionary dictionary) {
		Date date=new Date();
		dictionary.setCrtm(date);
		if (dictionaryService.insertDictionary(dictionary) > 0) {
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
	public Object update(Dictionary dictionary) {
		Date date=new Date();
		dictionary.setMdtm(date);
		if (dictionaryService.updateDictionary(dictionary) > 0) {
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
		if (dictionaryService.deleteDictionary(id) > 0) {
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
		if (dictionaryService.batchDelete(ids) > 0) {
			return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
		} else {
			return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
		}
	}
}
