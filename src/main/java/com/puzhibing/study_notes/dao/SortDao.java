package com.puzhibing.study_notes.dao;

import com.puzhibing.study_notes.pojo.Sort;

import java.util.List;

public interface SortDao {

    /**
     * 添加数据
     * @param sort
     */
    void insertSort(Sort sort);


    /**
     * 查询所有分类
     * @return
     */
    List<Sort> selectAllSort();


    /**
     * 获取总有效条数
     * @return
     */
    int selectCount();


    /**
     * 修改数据
     * @param sort
     */
    void updateSort(Sort sort);


    /**
     * 删除数据
     * @param id
     */
    void deleteSort(String id);
}
