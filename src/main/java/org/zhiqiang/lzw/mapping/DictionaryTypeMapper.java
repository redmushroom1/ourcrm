package org.zhiqiang.lzw.mapping;

import java.util.List;
import java.util.Map;

import org.zhiqiang.lzw.entity.DictionaryType;

public interface DictionaryTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictionaryType record);

    int insertSelective(DictionaryType record);

    DictionaryType selectByPrimaryKey(Integer id);
    
    List<DictionaryType> selectDictionaryTypesByCode(String code);

    int updateByPrimaryKeySelective(DictionaryType record);

    int updateByPrimaryKeyWithBLOBs(DictionaryType record);

    int updateByPrimaryKey(DictionaryType record);
}