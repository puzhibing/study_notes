package com.puzhibing.study_notes.service.impl;

import com.puzhibing.study_notes.dao.SortDao;
import com.puzhibing.study_notes.pojo.Sort;
import com.puzhibing.study_notes.service.SortService;
import com.puzhibing.study_notes.utils.NotesResponse;
import com.puzhibing.study_notes.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;


/**
 * 处理分类逻辑类
 */
@Service
public class SortServiceImpl implements SortService {

    @Autowired
    private SortDao sortDaoImpl;

    @Autowired
    private UUIDUtil uuidUtil;


    /**
     * 添加数据
     * @param sort
     * @return
     */
    @Override
    public NotesResponse<Object> insertSort(Sort sort) {
        NotesResponse<Object> notesResponse = new NotesResponse<>();
        if(null != sort){
            sort.setId(uuidUtil.getUUID());
            sort.setDel("0");
            try{
                int i = sortDaoImpl.selectCount();
                sort.setSort(String.valueOf(i + 1));
                sortDaoImpl.insertSort(sort);
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
     * 查询所有分类数据
     * @return
     */
    @Override
    public NotesResponse<List<Sort>> selectAllSort() {
        NotesResponse<List<Sort>> notesResponse = new NotesResponse<>();
        try {
            List<Sort> sorts = sortDaoImpl.selectAllSort();
            notesResponse.setB(true);
            notesResponse.setResult(sorts);
        }catch (Exception e){
            notesResponse.setB(false);
            notesResponse.setResult(null);
            e.printStackTrace();
        }
        return notesResponse;
    }


    /**
     * 修改数据
     * @param sort
     * @return
     */
    @Override
    public NotesResponse<Object> updateSort(Sort sort) {
        NotesResponse<Object> notesResponse = new NotesResponse<>();
        try{
            sortDaoImpl.updateSort(sort);
            notesResponse.setB(true);
            notesResponse.setResult(null);
        }catch (Exception e){
            notesResponse.setB(false);
            notesResponse.setResult(null);
            e.printStackTrace();
        }
        return notesResponse;
    }


    /**
     * 删除数据
     * @param id
     * @return
     */
    @Override
    public NotesResponse<Object> deleteSort(String id) {
        NotesResponse<Object> notesResponse = new NotesResponse<>();
        if(!StringUtils.isEmpty(id)){
            try{
                sortDaoImpl.deleteSort(id);
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
}
