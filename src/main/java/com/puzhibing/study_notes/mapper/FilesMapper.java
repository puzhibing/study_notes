package com.puzhibing.study_notes.mapper;

import com.puzhibing.study_notes.mapper.sql.FilesSql;
import com.puzhibing.study_notes.pojo.Files;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FilesMapper {


    /**
     * 添加数据
     * @param files
     */
    @InsertProvider(type = FilesSql.class , method = "insertFiles")
    void insertFiles(Files files);


    /**
     * 根据父类id获取数据
     * @param superId
     * @return
     */
    @SelectProvider(type = FilesSql.class , method = "selectFilesBySuperId")
    List<Files> selectFilesBySuperId(String superId);


    /**
     * 根据id集合查询数据
     * @return
     */
//    @SelectProvider(type = FilesSql.class , method = "selectFilesById")
    @Select("<script>"
            + "select id , superId , file_name , type , del , sort from t_files where del = '0'"
            + "<if test = 'ids.size() == 0'>"
            +   "and id in('')"
            + "</if>"
            + "<if test = 'ids.size() != 0'>"
            +   "and id in"
            +   "<foreach item='id' index='index' collection='ids' open='(' separator=',' close=')'>"
            +       "#{id}"
            +   "</foreach>"
            +   "order by sort"
            + "</if>"
            + "</script>")
    List<Files> selectFilesById(@Param("ids") List<String> ids);


    /**
     *  根据父类id获取数据总条数
     * @param superId
     * @return
     */
    @SelectProvider(type = FilesSql.class , method = "selectCount")
    int selectCount(String superId);


    /**
     * 获取所有数据
     * @return
     */
    @SelectProvider(type = FilesSql.class , method = "selectAllFiles")
    List<Files> selectAllFiles();


    /**
     * 根据id删除数据
     * @param id
     */
    @UpdateProvider(type = FilesSql.class , method = "deleteFilesById")
    void deleteFilesById(String id);


    /**
     * 修改数据
     * @param files
     */
    @UpdateProvider(type = FilesSql.class , method = "updateFiles")
    void updateFiles(Files files);
}
