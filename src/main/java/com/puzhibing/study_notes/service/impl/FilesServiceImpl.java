package com.puzhibing.study_notes.service.impl;

import com.puzhibing.study_notes.dao.FilesDao;
import com.puzhibing.study_notes.dao.SortFilesDao;
import com.puzhibing.study_notes.pojo.Files;
import com.puzhibing.study_notes.pojo.SortFiles;
import com.puzhibing.study_notes.service.FilesService;
import com.puzhibing.study_notes.utils.NotesResponse;
import com.puzhibing.study_notes.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


@Service
public class FilesServiceImpl implements FilesService {

    @Autowired
    private FilesDao filesDaoImpl;

    @Autowired
    private SortFilesDao sortFilesDaoImpl;

    @Autowired
    private UUIDUtil uuidUtil;


    /**
     * 添加数据
     * @param files
     * @param sortId
     * @return
     */
    @Override
    @Transactional//添加事务
    public NotesResponse<Object> insertFiles(Files files , String sortId) {
        NotesResponse<Object> notesResponse = new NotesResponse<>();
        if(null != files){
            String id = uuidUtil.getUUID();
            files.setId(id);
            files.setDel("0");
            if(files.getSuperId() == null || files.getSuperId().equals("")){//添加分类下的第一层文件数据
                files.setSuperId("");
                SortFiles sortFiles = new SortFiles();
                sortFiles.setId(uuidUtil.getUUID());
                sortFiles.setSort_id(sortId);
                sortFiles.setFiles_id(id);
                try {
                    sortFilesDaoImpl.insertSortFiles(sortFiles);

                    List<SortFiles> sortFiles1 = sortFilesDaoImpl.selectSortFilesBySortId(sortId);
                    List<String> ids = new ArrayList<>();
                    for (SortFiles sortFiles2 : sortFiles1){
                        ids.add(sortFiles2.getFiles_id());
                    }
                    List<Files> files1 = filesDaoImpl.selectFilesById(ids);
                    files.setSequence(String.valueOf(files1.size()));
                }catch (Exception e){
                    e.printStackTrace();
                }

            }else{
                try{
                    int i = filesDaoImpl.selectCount(files.getSuperId());
                    files.setSequence(String.valueOf(i + 1));
                }catch (Exception e){

                }
            }

            try {
                filesDaoImpl.insertFiles(files);
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
     * 根据上层父类id或分类id获取数据
     * 如果上层父类id不为空，则先根据父类id获取数据
     * @param superId
     * @param sort_id
     * @return
     */
    @Override
    public NotesResponse<List<Files>> selectFilesBySuperIdOrSortId(String superId, String sort_id) {
        NotesResponse<List<Files>> notesResponse = new NotesResponse<>();
        if(!StringUtils.isEmpty(superId)){//根据父类id获取数据
            List<Files> files = filesDaoImpl.selectFilesBySuperId(superId);
            notesResponse.setB(true);
            notesResponse.setResult(files);
        }else if (!StringUtils.isEmpty(sort_id)){//根据分类id获取数据
            List<SortFiles> sortFiles = sortFilesDaoImpl.selectSortFilesBySortId(sort_id);
            List<String> ids = new ArrayList<>();
            for (SortFiles sortFiles1 : sortFiles){
                ids.add(sortFiles1.getFiles_id());
            }
            List<Files> files = filesDaoImpl.selectFilesById(ids);
            notesResponse.setB(true);
            notesResponse.setResult(files);

        }
        return notesResponse;
    }


    /**
     * 根据id获取所有祖先数据
     * @param id
     * @return
     */
    @Override
    public NotesResponse<List<Files>> selectAncestor(String id) {
        NotesResponse<List<Files>> notesResponse = new NotesResponse<>();
        if(!StringUtils.isEmpty(id)){
            try{
                List<String> list = new ArrayList<>();
                list.add(id);
                List<Files> files1 = filesDaoImpl.selectFilesById(list);
                List<Files> files = filesDaoImpl.selectAllFiles();
                List<Files> files2 = findFiles(files, files1.get(0).getSuperId(), new ArrayList<>());
                files2.add(files1.get(0));
                notesResponse.setB(true);
                notesResponse.setResult(files2);
            }catch (Exception e){
                notesResponse.setB(false);
                notesResponse.setResult(null);
                e.printStackTrace();
            }
        }
        return notesResponse;
    }


    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    @Override
    public NotesResponse<Object> deleteFilesById(String id) {
        NotesResponse<Object> notesResponse = new NotesResponse<>();
        if(!StringUtils.isEmpty(id)){
            try{
                filesDaoImpl.deleteFilesById(id);
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
     * 修改数据
     * @param files
     * @return
     */
    @Override
    public NotesResponse<Object> updateFiles(Files files) {
        NotesResponse<Object> notesResponse = new NotesResponse<>();
        if(null != files){
            try{
                filesDaoImpl.updateFiles(files);
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
     * 递归查找出给定id的所有祖先数据
     * @param files
     * @param superId
     * @return
     */
    public List<Files> findFiles(List<Files> files , String superId , List<Files> list){
        if(!superId.equals("")){
            List<Files> list1 = new ArrayList<>();
            String id = null;
            int i = 0;
            for (Files f: files) {
                if(f.getId().equals(superId)){
                    list.add(0 ,f);
                    id = f.getSuperId();
                    i++;
                }else{
                    list1.add(f);
                }
            }
            if(id != null){
                findFiles(list1 , id , list);
            }
        }
        return list;
    }
}
