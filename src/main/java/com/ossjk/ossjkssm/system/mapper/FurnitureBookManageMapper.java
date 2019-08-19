package com.ossjk.ossjkssm.system.mapper;

import com.ossjk.core.base.mapper.BaseMapper;
import com.ossjk.ossjkssm.system.entity.FurnitureBook;
import com.ossjk.ossjkssm.system.entity.FurnitureBookManage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FurnitureBookManageMapper extends BaseMapper<FurnitureBookManage> {
    /**
     * 根据条件查询所有
     * @param map
     * @return
     */
    List<FurnitureBookManage> selectAll(Map map);
    /*    List<FurnitureBook> selectAll();*/
    /**
     * 根据id，批量删除数据
     * @param ids
     * @return
     */
    int batchDelete(Integer[] ids);
    String selectLast();
    String selectLastBm();
    int updateBorrowStatus(@Param("id") Integer id, @Param("borrowStatus") Integer borrowStatus,@Param("borrowNumber") String borrowNumber,@Param("name") String name);

    void updateRepairName(Integer id);

    void updateMaintainName(Integer id);

    void updateById(Integer id);
}
