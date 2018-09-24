package com.puzhibing.study_notes.controller;


import com.puzhibing.study_notes.pojo.Sort;
import com.puzhibing.study_notes.service.SortService;
import com.puzhibing.study_notes.utils.NotesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 分类接口类
 */
@RestController
public class SortController {

    @Autowired
    private SortService sortServiceImpl;


    /**
     * 添加数据
     * @param sort
     * @return
     */
    @RequestMapping(value = "/insertSort")
    public NotesResponse<Object> insertSort(Sort sort){
        return sortServiceImpl.insertSort(sort);
    }


    /**
     * 查询所有数据
     * @return
     */
    @RequestMapping(value = "/selectAllSort")
    public NotesResponse<List<Sort>> selectAllSort(){
        return sortServiceImpl.selectAllSort();
    }


    /**
     * 修改数据
     * @param sort
     * @return
     */
    @RequestMapping(value = "/updateSort")
    public NotesResponse<Object> updateSort(Sort sort){
        return sortServiceImpl.updateSort(sort);
    }




    @RequestMapping(value = "/deleteSort")
    public NotesResponse<Object> deleteSort(String id){
        return sortServiceImpl.deleteSort(id);
    }
}
