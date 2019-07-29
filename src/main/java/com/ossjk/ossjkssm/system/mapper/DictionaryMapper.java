package com.ossjk.ossjkssm.system.mapper;

import java.util.List;

import com.ossjk.core.base.mapper.BaseMapper;
import com.ossjk.ossjkssm.system.entity.Dictionary;

public interface DictionaryMapper extends BaseMapper<Dictionary>{
	
	//查询所有字典
	List<Dictionary> selectAllDictionary();
	
	//查询单个字典
	Dictionary selectDictionary(Integer id);
	
	//通过键查询字典
	List<Dictionary> selectDictionaryByDkey(String dkey);
	
	//批量删除字典
	int batchDelete(Integer[] ids);
	
	//增加字典
	int insertDictionary(Dictionary dictionary);

	//修改字典
	int updateDictionary(Dictionary dictionary);

	//删除字典
	int deleteDictionary(Integer id);
	
}
