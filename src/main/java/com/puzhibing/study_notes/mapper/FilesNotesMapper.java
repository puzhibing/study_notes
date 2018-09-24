package com.puzhibing.study_notes.mapper;


import com.puzhibing.study_notes.mapper.sql.FilesNotesSql;
import com.puzhibing.study_notes.pojo.FilesNotes;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 定义mapper接口
 */
public interface FilesNotesMapper {


    /**
     * 添加数据
     * @param filesNotes
     */
    @InsertProvider(type = FilesNotesSql.class , method = "insertFilesNotes" )
    void insertFilesNotes(FilesNotes filesNotes);


    /**
     * 根据文件id查询关系数据
     * @param filesId
     * @return
     */
    @SelectProvider(type = FilesNotesSql.class , method = "selectFilesNotesByFilesId" )
    List< FilesNotes> selectFilesNotesByFilesId(String filesId);
}
