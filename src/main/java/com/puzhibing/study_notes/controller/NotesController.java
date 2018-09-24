package com.puzhibing.study_notes.controller;


import com.puzhibing.study_notes.pojo.Notes;
import com.puzhibing.study_notes.service.NotesService;
import com.puzhibing.study_notes.utils.NotesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class NotesController {

    @Autowired
    private NotesService notesServiceImpl;


    /**
     * 添加数据
     * @param notes
     * @return
     */
    @RequestMapping(value = "/insertNotes")
    public NotesResponse<Object> insertNotes(Notes notes , String fileId){
        return notesServiceImpl.insertNotes(notes , fileId);
    }


    /**
     * 修改数据
     * @param notes
     * @return
     */
    @RequestMapping(value = "/updateNotes")
    public NotesResponse<Object> updateNotes(Notes notes){
        return notesServiceImpl.updateNotes(notes);
    }


    /**
     * 删除数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteNotes")
    public NotesResponse<Object> deleteNotes(String id){
        return notesServiceImpl.deleteNotes(id);
    }


    /**
     * 查询数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/selectNotesAndSonsById")
    public NotesResponse<Object> selectNotesAndSonsById(String id  , String fileId){
        return notesServiceImpl.selectNotesAndSonsById(id , fileId);
    }


    /**
     * 根据id查询自身
     * @param id
     * @return
     */
    @RequestMapping(value = "/selectNotesById")
    public NotesResponse<Notes> selectNotesById(String id){
        return notesServiceImpl.selectNotesById(id);
    }


}
