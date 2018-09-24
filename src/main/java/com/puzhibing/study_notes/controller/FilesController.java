package com.puzhibing.study_notes.controller;


import com.puzhibing.study_notes.pojo.Files;
import com.puzhibing.study_notes.service.FilesService;
import com.puzhibing.study_notes.utils.NotesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilesController {

    @Autowired
    private FilesService filesServiceImpl;


    /**
     * 添加数据
     * @param files
     * @return
     */
    @RequestMapping(value = "/insertFiles")
    public NotesResponse<Object> insertFiles(Files files , String sortId){
        return filesServiceImpl.insertFiles(files , sortId);
    }


    /**
     * 根据分类id或者父类id获取数据
     * @param superId
     * @param sort_id
     * @return
     */
    @RequestMapping(value = "/selectFilesBySuperIdOrSortId")
    public NotesResponse<List<Files>> selectFilesBySuperIdOrSortId(String superId, String sort_id){
        return filesServiceImpl.selectFilesBySuperIdOrSortId(superId , sort_id);
    }


    /**
     * 根据id获取祖先数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/selectAncestor")
    public NotesResponse<List<Files>> selectAncestor(String id){
        return filesServiceImpl.selectAncestor(id);
    }


    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteFilesById")
    public NotesResponse<Object> deleteFilesById(String id){
        return filesServiceImpl.deleteFilesById(id);
    }


    /**
     * 修改数据
     * @param files
     * @return
     */
    @RequestMapping(value = "/updateFiles")
    public NotesResponse<Object> updateFiles(Files files){
        return filesServiceImpl.updateFiles(files);
    }
}
