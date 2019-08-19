package com.ossjk.ossjkssm.system.service.impl;

import com.ossjk.core.base.service.BaseService;
import com.ossjk.core.base.service.impl.BaseServiceImpl;
import com.ossjk.ossjkssm.system.entity.FbDictionary;
import com.ossjk.ossjkssm.system.mapper.FbDictionaryMapper;
import com.ossjk.ossjkssm.system.service.FbDictionaryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FbDictionaryServiceImpl extends BaseServiceImpl<FbDictionaryMapper, FbDictionary> implements FbDictionaryService {
    @Override
    public List<FbDictionary> selectBs() {
        return baseMapper.selectBs();
    }

    @Override
    public List<FbDictionary> selectDs() {
        return baseMapper.selectDs();
    }
}
