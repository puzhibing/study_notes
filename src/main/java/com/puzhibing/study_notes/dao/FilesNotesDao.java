package com.puzhibing.study_notes.dao;


import com.puzhibing.study_notes.pojo.FilesNotes;

import java.util.List;

/**
 * 关系数据
 */
public interface FilesNotesDao {


    /**
     * 添加数据
     * @param filesNotes
     */
    void insertFilesNotes(FilesNotes filesNotes);


    /**
     * 根据文件id查询关系数据
     * @param filesId
     * @return
     */
    List<FilesNotes> selectFilesNotesByFilesId(String filesId);
}
