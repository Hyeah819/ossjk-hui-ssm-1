package com.ossjk.ossjkssm.system.mapper;

import com.ossjk.core.base.mapper.BaseMapper;
import com.ossjk.ossjkssm.system.entity.FbDictionary;

import java.util.List;

public interface FbDictionaryMapper extends BaseMapper<FbDictionary> {
    List<FbDictionary> selectBs();
    List<FbDictionary> selectDs();
}
