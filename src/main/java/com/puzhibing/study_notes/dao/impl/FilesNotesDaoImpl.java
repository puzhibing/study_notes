package com.puzhibing.study_notes.dao.impl;

import com.puzhibing.study_notes.dao.FilesNotesDao;
import com.puzhibing.study_notes.mapper.FilesNotesMapper;
import com.puzhibing.study_notes.pojo.FilesNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilesNotesDaoImpl implements FilesNotesDao {

    @Autowired
    private FilesNotesMapper filesNotesMapper;


    /**
     * 添加数据
     * @param filesNotes
     */
    @Override
    public void insertFilesNotes(FilesNotes filesNotes) {
        filesNotesMapper.insertFilesNotes(filesNotes);
    }


    /**
     * 根据文件id查询关系数据
     * @param filesId
     * @return
     */
    @Override
    public List<FilesNotes> selectFilesNotesByFilesId(String filesId) {
        return filesNotesMapper.selectFilesNotesByFilesId(filesId);
    }
}
