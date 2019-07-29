package com.ossjk.ossjkssm.system.service;

import java.util.List;

import com.ossjk.core.base.service.BaseService;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.system.entity.Dictionary;

public interface DictionaryService extends BaseService<Dictionary> {

	// 查询所有字典(分页查询)
	Page<Dictionary> selectAll(Page page);
	
	// 查询所有字典
	List<Dictionary> selectAllDictionary();

	// 查询单个字典
	Dictionary selectDictionary(Integer id);

	// 通过键查询字典
	Page<Dictionary> selectDictionaryByDkey(Page page,String dkey);

	// 批量删除字典
	int batchDelete(Integer[] ids);

	// 增加字典
	int insertDictionary(Dictionary dictionary);

	// 修改字典
	int updateDictionary(Dictionary dictionary);

	// 删除字典
	int deleteDictionary(Integer id);

}
