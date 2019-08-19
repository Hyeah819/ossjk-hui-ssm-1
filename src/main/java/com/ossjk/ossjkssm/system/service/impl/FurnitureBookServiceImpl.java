package com.ossjk.ossjkssm.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ossjk.core.base.service.impl.BaseServiceImpl;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.system.entity.FurnitureBook;
import com.ossjk.ossjkssm.system.mapper.FurnitureBookMapper;
import com.ossjk.ossjkssm.system.service.FurnitureBookService;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class FurnitureBookServiceImpl extends BaseServiceImpl<FurnitureBookMapper, FurnitureBook> implements FurnitureBookService {

    @Override
    public Page<FurnitureBook> selectPage(Page page, Map map) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        page.toPage(new PageInfo(baseMapper.selectAll(map)));
        return page;
    }

    @Override
    public int batchDelete(Integer[] ids) {
        return baseMapper.batchDelete(ids);
    }

/*    @Override
    public Page<FurnitureBook> selectPage(Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        page.toPage(new PageInfo(baseMapper.selectAll()));
        return page;
    }*/
}
