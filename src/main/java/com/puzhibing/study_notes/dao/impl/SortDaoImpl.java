package com.puzhibing.study_notes.dao.impl;

import com.puzhibing.study_notes.dao.SortDao;
import com.puzhibing.study_notes.mapper.SortMapper;
import com.puzhibing.study_notes.pojo.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class SortDaoImpl implements SortDao {

    @Autowired
    private SortMapper sortMapper;


    /**
     * 添加数据
     * @param sort
     */
    @Override
    public void insertSort(Sort sort) {
        sortMapper.insertSort(sort);
    }


    /**
     * 查询所有数据
     * @return
     */
    @Override
    public List<Sort> selectAllSort() {
        return sortMapper.selectAllSort();
    }


    /**
     * 获取总有效条数
     * @return
     */
    @Override
    public int selectCount() {
        return sortMapper.selectCount();
    }


    /**
     * 修改数据
     * @param sort
     */
    @Override
    public void updateSort(Sort sort) {
        sortMapper.updateSort(sort);
    }


    /**
     * 删除数据
     * @param id
     */
    @Override
    public void deleteSort(String id) {
        sortMapper.deleteSort(id);
    }
}
