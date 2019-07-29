package com.ossjk.ossjkssm.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ossjk.core.base.service.impl.BaseServiceImpl;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.system.entity.Dictionary;
import com.ossjk.ossjkssm.system.mapper.DictionaryMapper;
import com.ossjk.ossjkssm.system.service.DictionaryService;

@Service
public class DictionaryServiceImpl extends BaseServiceImpl<DictionaryMapper, Dictionary> implements DictionaryService {
	
	// 查询所有字典(分页)
	@Override
	public Page<Dictionary> selectAll(Page page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		page.toPage(new PageInfo(baseMapper.selectAllDictionary()));
		return page;
	}

	// 查询所有字典
	@Override
	public List<Dictionary> selectAllDictionary() {
		return baseMapper.selectAllDictionary();
	}

	// 查询单个字典
	@Override
	public Dictionary selectDictionary(Integer id) {
		return baseMapper.selectDictionary(id);
	}

	// 通过键查询字典
	@Override
	public Page<Dictionary> selectDictionaryByDkey(Page page, String dkey) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		page.toPage(new PageInfo(baseMapper.selectDictionaryByDkey(dkey)));
		return page;
	}

	// 批量删除字典
	@Override
	public int batchDelete(Integer[] ids) {
		return baseMapper.batchDelete(ids);
	}

	// 增加字典
	@Override
	public int insertDictionary(Dictionary dictionary) {
		return baseMapper.insertDictionary(dictionary);
	}

	// 修改字典
	@Override
	public int updateDictionary(Dictionary dictionary) {
		return baseMapper.updateDictionary(dictionary);
	}

	// 删除字典
	@Override
	public int deleteDictionary(Integer id) {
		return baseMapper.deleteDictionary(id);
	}
}
