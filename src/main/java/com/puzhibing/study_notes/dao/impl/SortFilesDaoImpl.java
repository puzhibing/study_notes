package com.puzhibing.study_notes.dao.impl;

import com.puzhibing.study_notes.dao.SortFilesDao;
import com.puzhibing.study_notes.mapper.SortFilesMapper;
import com.puzhibing.study_notes.pojo.SortFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class SortFilesDaoImpl implements SortFilesDao {

    @Autowired
    private SortFilesMapper sortFilesMapper;


    /**
     * 添加数据
     * @param sortFiles
     */
    @Override
    public void insertSortFiles(SortFiles sortFiles) {
        sortFilesMapper.insertSortFiles(sortFiles);
    }


    /**
     * 根据分类id获取数据
     * @param sort_id
     * @return
     */
    @Override
    public List<SortFiles> selectSortFilesBySortId(String sort_id) {
        return sortFilesMapper.selectSortFilesBySortId(sort_id);
    }


}
