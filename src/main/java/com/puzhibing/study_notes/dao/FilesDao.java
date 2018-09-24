package com.puzhibing.study_notes.dao;


import com.puzhibing.study_notes.pojo.Files;

import java.io.File;
import java.util.List;

/**
 * 定义文件dao层接口
 */
public interface FilesDao {


    /**
     * 添加数据
     * @param files
     */
    void insertFiles(Files files);


    /**
     * 根据父类id获取数据
     * @param superId
     * @return
     */
    List<Files> selectFilesBySuperId(String superId);


    /**
     * 根据id集合查询数据
     * @return
     */
    List<Files> selectFilesById(List<String> ids);


    /**
     * 根据父类id获取总条数
     * @param superId
     * @return
     */
    int selectCount(String superId);


    /**
     * 查询所有数据
     * @return
     */
    List<Files> selectAllFiles();


    /**
     * 根据id删除数据
     * @param id
     */
    void deleteFilesById(String id);


    /**
     * 修改数据
     * @param files
     */
    void updateFiles(Files files);
}
