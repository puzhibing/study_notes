package com.puzhibing.study_notes.dao.impl;

import com.puzhibing.study_notes.dao.NotesDao;
import com.puzhibing.study_notes.mapper.NotesMapper;
import com.puzhibing.study_notes.pojo.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NotesDaoImpl implements NotesDao {

    @Autowired
    private NotesMapper notesMapper;

    /**
     * 添加数据
     * @param notes
     */
    @Override
    public void insertNotes(Notes notes) {
        notesMapper.insertNotes(notes);
    }


    /**
     * 修改数据
     * @param notes
     */
    @Override
    public void updateNotes(Notes notes) {
        notesMapper.updateNotes(notes);
    }


    /**
     * 删除数据
     * @param id
     */
    @Override
    public void deleteNotes(String id) {
        notesMapper.deleteNotes(id);
    }


    /**
     * 查询自身数据及对应的直接子数据
     * @param id
     * @return
     */
    @Override
    public Map<String , Object> selectNotesAndSonsById(String id) {
        Map<String , Object> map = new HashMap<>();
        Notes notes = notesMapper.selectNotesById(id);
        List<Notes> sonNotes = notesMapper.selectNotesBySuperId(id);
        map.put("notes" , notes);
        map.put("sonNotes" , sonNotes);

        return map;
    }



    /**
     * 根据id集合查询数据
     * @param ids
     * @return
     */
    @Override
    public List<Notes> selectNotesInIds(List<String> ids) {
        return notesMapper.selectNotesInIds(ids);
    }


    @Override
    public int selectCount(String superId) {
        return notesMapper.selectCount(superId);
    }

    @Override
    public Notes selectNotesById(String id) {
        return notesMapper.selectNotesById(id);
    }

}
