package com.puzhibing.study_notes.dao;

import com.puzhibing.study_notes.pojo.SortFiles;

import java.util.List;

public interface SortFilesDao {


    /**
     * 添加数据
     * @param sortFiles
     */
    void insertSortFiles(SortFiles sortFiles);


    /**
     * 根据分类id获取数据
     * @param sort_id
     * @return
     */
    List<SortFiles> selectSortFilesBySortId(String sort_id);


}
