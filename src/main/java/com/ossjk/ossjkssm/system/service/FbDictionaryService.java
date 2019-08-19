package com.ossjk.ossjkssm.system.service;

import com.ossjk.core.base.service.BaseService;
import com.ossjk.ossjkssm.system.entity.FbDictionary;

import java.util.List;

public interface FbDictionaryService extends BaseService<FbDictionary> {
    List<FbDictionary> selectBs();
    List<FbDictionary> selectDs();
}
