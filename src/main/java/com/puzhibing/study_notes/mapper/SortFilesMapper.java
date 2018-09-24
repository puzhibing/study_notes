package com.puzhibing.study_notes.mapper;

import com.puzhibing.study_notes.mapper.sql.SortFilesSql;
import com.puzhibing.study_notes.pojo.SortFiles;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface SortFilesMapper {


    /**
     * 添加数据
     * @param sortFiles
     */
    @InsertProvider(type = SortFilesSql.class , method = "insertSortFiles")
    void insertSortFiles(SortFiles sortFiles);


    /**
     * 根据分类id获取数据
     * @param sort_id
     * @return
     */
    @SelectProvider(type = SortFilesSql.class , method = "selectSortFilesBySortId")
    List<SortFiles> selectSortFilesBySortId(String sort_id);


}
