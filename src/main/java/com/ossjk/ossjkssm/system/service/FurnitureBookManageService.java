package com.ossjk.ossjkssm.system.service;

import com.ossjk.core.base.service.BaseService;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.system.entity.FurnitureBook;
import com.ossjk.ossjkssm.system.entity.FurnitureBookManage;

import java.util.Map;

public interface FurnitureBookManageService extends BaseService<FurnitureBookManage> {
    // 查询所有用户(分页)
    Page<FurnitureBookManage> selectPage(Page page, Map map);
    /*    Page<FurnitureBook> selectPage(Page page);*/

    int batchDelete(Integer[] ids);
    //流水号
    String selectLast();
    //单据号
    String selectLastBm();
    //领用归还
    int updateBorrowStatus(Integer id,Integer borrowStatus,String borrowNumber,String name);

    void updateRepairName(Integer id);

    void updateMaintainName(Integer id);

    void updateById(Integer id);
}
