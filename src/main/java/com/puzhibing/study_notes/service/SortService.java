package com.puzhibing.study_notes.service;


import com.puzhibing.study_notes.pojo.Sort;
import com.puzhibing.study_notes.utils.NotesResponse;

import java.util.List;

/**
 * 分类逻辑处理接口
 */
public interface SortService {


    /**
     * 添加数据
     * @param sort
     * @return
     */
    NotesResponse<Object> insertSort(Sort sort);


    /**
     * 查询所有分类
     * @return
     */
    NotesResponse<List<Sort>> selectAllSort();


    /**
     * 修改数据
     * @param sort
     * @return
     */
    NotesResponse<Object> updateSort(Sort sort);


    /**
     * 删除数据
     * @param id
     * @return
     */
    NotesResponse<Object> deleteSort(String id);
}
