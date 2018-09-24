package com.puzhibing.study_notes.service;

import com.puzhibing.study_notes.pojo.Files;
import com.puzhibing.study_notes.utils.NotesResponse;

import java.util.List;

public interface FilesService {


    /**
     * 添加数据
     * @param files
     * @param sortId
     * @return
     */
    NotesResponse<Object> insertFiles(Files files ,String sortId);


    /**
     * 根据分类id或上层父类id获取数据
     * @param superId
     * @param sort_id
     * @return
     */
    NotesResponse<List<Files>> selectFilesBySuperIdOrSortId(String superId , String sort_id);


    /**
     * 根据id获取祖先数据
     * @param id
     * @return
     */
    NotesResponse<List<Files>> selectAncestor(String id);


    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    NotesResponse<Object> deleteFilesById(String id);


    /**
     * 修改数据
     * @param files
     * @return
     */
    NotesResponse<Object> updateFiles(Files files);
}
