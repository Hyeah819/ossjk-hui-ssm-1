package com.ossjk.ossjkssm.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ossjk.core.base.service.impl.BaseServiceImpl;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.system.entity.FurnitureBookManage;
import com.ossjk.ossjkssm.system.mapper.FurnitureBookManageMapper;
import com.ossjk.ossjkssm.system.mapper.FurnitureBookMapper;
import com.ossjk.ossjkssm.system.service.FurnitureBookManageService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FurnitureBookManageServiceImpl extends BaseServiceImpl<FurnitureBookManageMapper, FurnitureBookManage> implements FurnitureBookManageService {
    @Override
    public Page<FurnitureBookManage> selectPage(Page page, Map map) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        page.toPage(new PageInfo(baseMapper.selectAll(map)));
        return page;
    }

    @Override
    public int batchDelete(Integer[] ids) {
        return baseMapper.batchDelete(ids);
    }

    @Override
    public String selectLast() {
        return baseMapper.selectLast();
    }

    @Override
    public String selectLastBm() {
        return baseMapper.selectLastBm();
    }

    @Override
    public int updateBorrowStatus(Integer id, Integer borrowStatus,String borrowNumber,String name) {
        return baseMapper.updateBorrowStatus(id,borrowStatus,borrowNumber,name);
    }

    @Override
    public void updateRepairName(Integer id) {
        baseMapper.updateRepairName(id);
    }

    @Override
    public void updateMaintainName(Integer id) {
        baseMapper.updateMaintainName(id);
    }

    @Override
    public void updateById(Integer id) {
        baseMapper.updateById(id);
    }
}
