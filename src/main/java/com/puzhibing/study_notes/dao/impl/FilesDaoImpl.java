package com.puzhibing.study_notes.dao.impl;

import com.puzhibing.study_notes.dao.FilesDao;
import com.puzhibing.study_notes.mapper.FilesMapper;
import com.puzhibing.study_notes.pojo.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilesDaoImpl implements FilesDao {

    @Autowired
    private FilesMapper filesMapper;


    /**
     * 添加数据
     * @param files
     */
    @Override
    public void insertFiles(Files files) {
        filesMapper.insertFiles(files);
    }


    /**
     * 根据父类id获取数据
     * @param superId
     * @return
     */
    @Override
    public List<Files> selectFilesBySuperId(String superId) {
        return filesMapper.selectFilesBySuperId(superId);
    }


    /**
     * 根据id查询数据集合
     * @return
     */
    @Override
    public List<Files> selectFilesById(List<String> ids) {
        return filesMapper.selectFilesById(ids);
    }


    /**
     * 根据父类id获取数据总条数
     * @param superId
     * @return
     */
    @Override
    public int selectCount(String superId) {
        return filesMapper.selectCount(superId);
    }


    /**
     * 获取所有数据
     * @return
     */
    @Override
    public List<Files> selectAllFiles() {
        return filesMapper.selectAllFiles();
    }


    /**
     * 根据id删除数据
     * @param id
     */
    @Override
    public void deleteFilesById(String id) {
        filesMapper.deleteFilesById(id);
    }

    /**
     * 修改数据
     * @param files
     */
    @Override
    public void updateFiles(Files files) {
        filesMapper.updateFiles(files);
    }
}
