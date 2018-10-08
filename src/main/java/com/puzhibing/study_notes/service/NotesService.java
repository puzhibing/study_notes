package com.puzhibing.study_notes.service;

import com.puzhibing.study_notes.pojo.Notes;
import com.puzhibing.study_notes.utils.NotesResponse;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

public interface NotesService {

    /**
     * 添加数据
     * @param notes
     * @return
     */
    NotesResponse<Object> insertNotes(Notes notes , String fileId);


    /**
     * 修改数据
     * @param notes
     * @return
     */
    NotesResponse<Object> updateNotes(Notes notes);


    /**
     * 删除数据
     * @param id
     * @return
     */
    NotesResponse<Object> deleteNotes(String id);


    /**
     * 查询自身数据及对应的直接子数据
     * @param id
     * @param fileId
     * @return
     */
    NotesResponse<Object> selectNotesAndSonsById(String id , String fileId);


    /**
     * 根据id查询自身
     * @param id
     * @return
     */
    NotesResponse<Notes> selectNotesById(String id);



    /**
     * 上传文件
     * @param file
     * @return
     */
    NotesResponse<Object> uploadFile(MultipartFile file , HttpServletRequest request);
}
