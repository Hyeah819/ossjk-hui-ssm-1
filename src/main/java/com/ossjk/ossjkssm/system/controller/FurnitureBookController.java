package com.ossjk.ossjkssm.system.controller;


import com.ossjk.core.vo.AjaxReturn;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.common.Constant;
import com.ossjk.ossjkssm.system.entity.FurnitureBook;
import com.ossjk.ossjkssm.system.entity.Organization;
import com.ossjk.ossjkssm.system.service.FurnitureBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("/system/furnitureBook")
public class FurnitureBookController {
    @Autowired
    private FurnitureBookService furnitureBookService;

    /**
     * 分页显示数据
     * @param
     * @param ogid
     * @param page
     * @param map
     * @return
     */
    @RequestMapping("/list")
    public String list(String fbName , String fbBrand, Page page, ModelMap map) {
        map.put("fbName",fbName);
        map.put("fbBrand",fbBrand);
        Map mp = new HashMap();
        mp.put("fbName",fbName);
        mp.put("fbBrand",fbBrand);
        map.put("page",furnitureBookService.selectPage(page,mp));
        return "system/furnitureBook/list";
    }

    /**
     * 去增加
     */
    @RequestMapping("/toInsert")
    public String toInsert() {
        return "system/furnitureBook/edit";
    }

    /**
     * 去更新
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id, ModelMap map) {
        map.put("record", furnitureBookService.selectByPrimaryKey(id));
        return "system/furnitureBook/edit";
    }


    /**
     * 增加
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Object insert(FurnitureBook furnitureBook) {
        if (furnitureBookService.insert(furnitureBook) > 0) {
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
    public Object update(FurnitureBook furnitureBook) {
        if (furnitureBookService.updateByPrimaryKey(furnitureBook) > 0) {
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
        if (furnitureBookService.deleteByPrimaryKey(id) > 0) {
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
        if (furnitureBookService.batchDelete(ids) > 0) {
            return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
        } else {
            return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
        }
    }



}
