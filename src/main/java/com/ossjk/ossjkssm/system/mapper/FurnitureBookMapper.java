package com.ossjk.ossjkssm.system.mapper;

import com.ossjk.core.base.mapper.BaseMapper;
import com.ossjk.ossjkssm.system.entity.FurnitureBook;

import java.util.List;
import java.util.Map;

public interface FurnitureBookMapper extends BaseMapper<FurnitureBook> {
    /**
     * 根据条件查询所有
     * @param map
     * @return
     */
    List<FurnitureBook> selectAll(Map map);
/*    List<FurnitureBook> selectAll();*/
    /**
     * 根据id，批量删除数据
     * @param ids
     * @return
     */
    int batchDelete(Integer[] ids);
}
