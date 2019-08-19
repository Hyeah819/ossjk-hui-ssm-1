package com.ossjk.ossjkssm.system.controller;

import com.alibaba.fastjson.JSON;
import com.ossjk.core.vo.AjaxReturn;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.common.Constant;
import com.ossjk.ossjkssm.system.entity.FbDictionary;
import com.ossjk.ossjkssm.system.entity.FurnitureBook;
import com.ossjk.ossjkssm.system.entity.FurnitureBookManage;
import com.ossjk.ossjkssm.system.service.FbDictionaryService;
import com.ossjk.ossjkssm.system.service.FurnitureBookManageService;
import com.ossjk.ossjkssm.system.service.FurnitureBookService;
import com.ossjk.ossjkssm.system.service.RoleService;
import com.sun.deploy.ui.AppInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system/furnitureBookManage")
public class FurnitureBookManageController {
    private org.apache.log4j.Logger logger= Logger.getLogger(getClass());
    @Autowired
    private FurnitureBookManageService furnitureBookManageService;
    @Autowired
    private FbDictionaryService fbDictionaryService;
    @Autowired
    private RoleService roleService;

    //报废
    @RequestMapping("updateById.do")
    public String updateById(Integer id){
        furnitureBookManageService.updateById(id);
        return "redirect:list.do";
    }

    //维修
    @RequestMapping("updateMaintainName.do")
    public String updateMaintainName(Integer id){
        furnitureBookManageService.updateMaintainName(id);
        return "redirect:list.do";
    }


    //报修
    @RequestMapping("updateRepairName.do")
    public String updateRepairName(Integer id){
        furnitureBookManageService.updateRepairName(id);
        return "redirect:list.do";
    }

    /**
     * 领用和归还
     * @param fbid
     * @return
     */
    @RequestMapping(value="/{fbid}/{bname}/borrow",method= RequestMethod.PUT)
    @ResponseBody
    public synchronized Object borrow(@PathVariable Integer fbid,@PathVariable String bname){
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        Integer fbidInteger = 0;
        try{
            fbidInteger = fbid;
        }catch(Exception e){
            fbidInteger = 0;
        }
        resultMap.put("errorCode", "0");
        if(fbidInteger>0){
            try {
                FurnitureBookManage furnitureBookManage = furnitureBookManageService.selectByPrimaryKey(fbid);

                if(furnitureBookManage!=null){
                    System.out.println("他的状态值为："+furnitureBookManage.getBorrowStatus());
                    if (furnitureBookManage.getBorrowStatus()==1){
                        String thisCode = furnitureBookManageService.selectLastBm();
                        String id = null;
                        Date date = new Date();
                        SimpleDateFormat formatter = new SimpleDateFormat("yyMM");
                        System.out.println(formatter);
                        //查出的数据取年月部分
                        String thisData = thisCode.substring(3, 7);
                        //这个判断就是判断你数据取出来的最后一个业务单号是不是当月的
                        if (!formatter.format(date).equals(thisData)) {
                            System.out.println("新的一月");
                            thisData = formatter.format(date);
                            //如果是新的一月的就直接变成0001
                            id = "DJJ" + thisData + "01";
                            System.out.println(id);
                        } else {
                            System.out.println("当月");
                            DecimalFormat df = new DecimalFormat("00");

                            //不是新的一月就累加，Integer.parseInt(thisCode.substring(9, 13))转换为int类型再加一
                            id = "DJJ" + formatter.format(date)
                                    + df.format(1 + Integer.parseInt(thisCode.substring(7, 9)));
                            System.out.println("id:" + id);
                        }

                        furnitureBookManageService.updateBorrowStatus(fbid,2,id,bname);
                    }
                    if (furnitureBookManage.getBorrowStatus()==2){ furnitureBookManageService.updateBorrowStatus(fbid,1,null,null);}
                    resultMap.put("resultMsg", "success");
                }else{
                    resultMap.put("resultMsg", "error");
                }
            } catch (Exception e) {
                resultMap.put("errorCode", "exception000001");
            }
        }else{
            //errorCode:0为正常
            resultMap.put("errorCode", "param000001");
        }
        String json = JSON.toJSONString(resultMap);
        logger.debug(json);//{result:exist}   {result:notExist}
        return json;
       /* HashMap<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("errorCode", "0");
        resultMap.put("resultMsg","success");
        String json = JSON.toJSONString(resultMap);
        logger.debug(json);//{result:exist}   {result:notExist}
        return json;*/
    }

    @RequestMapping("/list")
    public String list(String fbName , Integer borrowStatus,Integer damageStatus, Page page, ModelMap map) {
        //测试类没错，却一直给我报空指针错误，后来发现好像是运行问题。
        map.put("BS", fbDictionaryService.selectBs());
        map.put("DS", fbDictionaryService.selectDs());
        map.put("fbName",fbName);
        map.put("borrowStatus",borrowStatus);
        map.put("damageStatus",damageStatus);
        Map mp = new HashMap();
        mp.put("fbName",fbName);
        mp.put("borrowStatus",borrowStatus);
        mp.put("damageStatus",damageStatus);
        map.put("page",furnitureBookManageService.selectPage(page,mp));
        return "system/furnitureBookManage/list";
    }

    /**
     * 去增加
     */
    @RequestMapping("/toInsert")
    public synchronized String toInsert(ModelMap map) {
        //关键字synchronized可以保证在同一时刻，只有一个线程可以执行某个方法或某个代码块，同时synchronized可以保证一个线程的变化可见（可见性），即可以代替volatile。
        //synchronized的作用是保证流水号唯一，冲突时等待
/*        synchronized ("toInsert") {*/
        String thisCode = furnitureBookManageService.selectLast();
        System.out.println(thisCode);
        String id = null;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMM");
        System.out.println(formatter);
        //查出的数据取年月部分
        String thisData = thisCode.substring(1, 5);
        System.out.println(thisData);
        //这个判断就是判断你数据取出来的最后一个业务单号是不是当月的
        if (!formatter.format(date).equals(thisData)) {
            System.out.println("新的一月");
            thisData = formatter.format(date);
            //如果是新的一月的就直接变成0001
            id = "J" + thisData + "01";
            System.out.println(id);
        } else {
            System.out.println("当月");
            DecimalFormat df = new DecimalFormat("00");

            //不是新的一月就累加，Integer.parseInt(thisCode.substring(9, 13))转换为int类型再加一
            id = "J" + formatter.format(date)
                    + df.format(1 + Integer.parseInt(thisCode.substring(5, 7)));
            System.out.println("id:" + id);

        }
             map.put("pipelineNumber", id);
            return "system/furnitureBookManage/edit";
       /* }*/
    }

    /**
     * 去更新
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id, ModelMap map) {
        map.put("record", furnitureBookManageService.selectByPrimaryKey(id));
        return "system/furnitureBookManage/edit";
    }


    /**
     * 增加
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Object insert(FurnitureBookManage furnitureBookManage) {
        if (furnitureBookManageService.insert(furnitureBookManage) > 0) {
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
    public Object update(FurnitureBookManage furnitureBookManage) {
        if (furnitureBookManageService.updateByPrimaryKey(furnitureBookManage) > 0) {
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
        if (furnitureBookManageService.deleteByPrimaryKey(id) > 0) {
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
        if (furnitureBookManageService.batchDelete(ids) > 0) {
            return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
        } else {
            return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
        }
    }

}
