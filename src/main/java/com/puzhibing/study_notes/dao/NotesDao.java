package com.puzhibing.study_notes.dao;

import com.puzhibing.study_notes.pojo.Notes;

import java.util.List;
import java.util.Map;

public interface NotesDao {


    /**
     * 添加数据
     * @param notes
     */
    void insertNotes(Notes notes);


    /**
     * 修改数据
     * @param notes
     */
    void updateNotes(Notes notes);


    /**
     * 删除数据
     * @param id
     */
    void deleteNotes(String id);


    /**
     * 查询自身数据及对应的直接子数据
     * @param id
     * @return
     */
    Map<String , Object> selectNotesAndSonsById(String id);


    /**
     * 根据id集合查询数据
     * @param ids
     * @return
     */
    List<Notes> selectNotesInIds(List<String> ids);


    /**
     *
     * @param superId
     * @return
     */
    int selectCount(String superId);


    /**
     * 根据id查询自身
     * @param id
     * @return
     */
    Notes selectNotesById(String id);


}
