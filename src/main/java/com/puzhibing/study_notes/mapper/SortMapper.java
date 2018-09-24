package com.puzhibing.study_notes.mapper;


import com.puzhibing.study_notes.mapper.sql.SortSql;
import com.puzhibing.study_notes.pojo.Sort;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * 定义分类mapper接口
 */
public interface SortMapper {


    /**
     * 定义添加数据
     * @param sort
     */
    @InsertProvider(type = SortSql.class , method = "insertSort")
    void insertSort(Sort sort);


    /**
     * 查询所有数据
     * @return
     */
    @SelectProvider(type = SortSql.class , method = "selectAllSort")
    List<Sort> selectAllSort();


    /**
     * 查询总的有效数据条数
     * @return
     */
    @SelectProvider(type = SortSql.class , method = "selectCount")
    int selectCount();


    /**
     * 修改数据
     * @param sort
     */
    @UpdateProvider(type = SortSql.class , method = "updateSort")
    void updateSort(Sort sort);


    /**
     * 删除数据
     * @param id
     */
    @UpdateProvider(type = SortSql.class , method = "deleteSort")
    void deleteSort(String id);
}
