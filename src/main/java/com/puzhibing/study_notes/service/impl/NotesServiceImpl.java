package com.puzhibing.study_notes.service.impl;

import com.puzhibing.study_notes.dao.FilesNotesDao;
import com.puzhibing.study_notes.dao.NotesDao;
import com.puzhibing.study_notes.pojo.FilesNotes;
import com.puzhibing.study_notes.pojo.Notes;
import com.puzhibing.study_notes.service.NotesService;
import com.puzhibing.study_notes.utils.NotesResponse;
import com.puzhibing.study_notes.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesDao notesDaoImpl;

    @Autowired
    private FilesNotesDao filesNotesDaoImpl;

    @Autowired
    private UUIDUtil uuidUtil;


    /**
     * 添加数据
     * 判断superId参数，如果superId参数没有值则保存与文件与笔记关系数据
     * 如果superId有值则保存为子集数据
     * @param notes
     * @return
     */
    @Override
    public NotesResponse<Object> insertNotes(Notes notes , String fileId) {
        NotesResponse<Object> notesResponse = new NotesResponse<>();
        if(null != notes){

            String id = uuidUtil.getUUID();
            if(notes.getSuperId().equals("")){
                FilesNotes filesNotes = new FilesNotes();
                filesNotes.setId(uuidUtil.getUUID());
                filesNotes.setFilesId(fileId);
                filesNotes.setNotesId(id);
                try {
                    filesNotesDaoImpl.insertFilesNotes(filesNotes);
                    notesResponse.setB(true);
                    notesResponse.setResult(null);
                }catch (Exception e){
                    notesResponse.setB(false);
                    notesResponse.setResult(null);
                    e.printStackTrace();
                }
            }

            notes.setId(id);
            notes.setInsertDate(new Date());
            notes.setUpdataDate(new Date());
            notes.setDel("0");
            try {
                int count = notesDaoImpl.selectCount(notes.getSuperId());
                notes.setSort(String.valueOf(count + 1));
                notesDaoImpl.insertNotes(notes);
                notesResponse.setB(true);
                notesResponse.setResult(id);
            }catch (Exception e){
                notesResponse.setB(false);
                notesResponse.setResult(null);
                e.printStackTrace();
            }
        }
        return notesResponse;
    }


    /**
     * 修改数据
     * @param notes
     * @return
     */
    @Override
    public NotesResponse<Object> updateNotes(Notes notes) {
        NotesResponse<Object> notesResponse = new NotesResponse<>();
        if(null != notes){
            try{
                notes.setUpdataDate(new Date());
                notesDaoImpl.updateNotes(notes);
                notesResponse.setB(true);
                notesResponse.setResult(null);
            }catch (Exception e){
                notesResponse.setB(false);
                notesResponse.setResult(null);
                e.printStackTrace();
            }
        }
        return notesResponse;
    }


    /**
     * 删除数据
     * @param id
     * @return
     */
    @Override
    public NotesResponse<Object> deleteNotes(String id) {
        NotesResponse<Object> notesResponse = new NotesResponse<>();
        if(!StringUtils.isEmpty(id)){
            try{
                notesDaoImpl.deleteNotes(id);
                notesResponse.setB(true);
                notesResponse.setResult(null);
            }catch (Exception e){
                notesResponse.setB(false);
                notesResponse.setResult(null);
                e.printStackTrace();
            }
        }
        return notesResponse;
    }


    /**
     * 查询自身数据及对应的直接子数据
     * id值为空时，查询fileId对应的绑定数据
     * @param id
     * @return
     */
    @Override
    public NotesResponse<Object> selectNotesAndSonsById(String id , String fileId) {
        NotesResponse<Object> notesResponse = new NotesResponse<>();
        if(!StringUtils.isEmpty(id)){
            try{
                Map<String, Object> map = notesDaoImpl.selectNotesAndSonsById(id);
                notesResponse.setB(true);
                notesResponse.setResult(map);
            }catch (Exception e){
                notesResponse.setB(false);
                notesResponse.setResult(null);
                e.printStackTrace();
            }
        }else if(!StringUtils.isEmpty(fileId)){
            try{
                List<String> ids = new ArrayList<>();
                List<FilesNotes> list = filesNotesDaoImpl.selectFilesNotesByFilesId(fileId);
                for (FilesNotes filesNotes : list) {
                    ids.add(filesNotes.getNotesId());
                }
                List<Notes> notes = notesDaoImpl.selectNotesInIds(ids);
                notesResponse.setB(true);
                notesResponse.setResult(notes);
            }catch (Exception e){
                notesResponse.setB(false);
                notesResponse.setResult(null);
                e.printStackTrace();
            }
        }
        return notesResponse;
    }


    /**
     * 根据id查询自身
     * @param id
     * @return
     */
    @Override
    public NotesResponse<Notes> selectNotesById(String id) {
        NotesResponse<Notes> notesResponse = new NotesResponse<>();
        if(!StringUtils.isEmpty(id)){
            try{
                Notes notes = notesDaoImpl.selectNotesById(id);
                notesResponse.setB(true);
                notesResponse.setResult(notes);
            }catch (Exception e){
                notesResponse.setB(false);
                notesResponse.setResult(null);
                e.printStackTrace();
            }
        }
        return notesResponse;
    }


    /**
     * 上传文件
     * @param file
     * @return
     */
    @Override
    public NotesResponse<Object> uploadFile(MultipartFile file , HttpServletRequest request){
        NotesResponse<Object> notesResponse = new NotesResponse<>();
        if(null != file){
            String fileName = file.getOriginalFilename();
            String newFileName = new Date().getTime() + fileName.substring(fileName.indexOf(".") , fileName.length());
            String path = System.getProperty("catalina.home") + System.getProperty("file.separator") + "webapps" + System.getProperty("file.separator") + "studyNotesFile" + System.getProperty("file.separator") + "img";
            System.err.println();
            File file1 = new File(path);
            if(!file1.exists()){//如果文件夹不存在
                file1.mkdirs();//创建文件夹
            }
            try {
                file.transferTo(new File(file1 , newFileName));
                notesResponse.setB(true);
                notesResponse.setResult("/studyNotesFile/img/" + newFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return notesResponse;
    }

}
