package com.ossjk.ossjkssm.system.service;

import com.ossjk.core.base.service.BaseService;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.system.entity.FurnitureBook;

import java.util.List;
import java.util.Map;

public interface FurnitureBookService extends BaseService<FurnitureBook> {

    // 查询所有用户(分页)
    Page<FurnitureBook> selectPage(Page page, Map map);
/*    Page<FurnitureBook> selectPage(Page page);*/

    int batchDelete(Integer[] ids);
}
