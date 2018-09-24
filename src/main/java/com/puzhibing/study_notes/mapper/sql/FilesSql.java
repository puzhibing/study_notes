package com.puzhibing.study_notes.mapper.sql;


import com.puzhibing.study_notes.pojo.Files;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;


/**
 * 定义文件SQL语句类
 */
public class FilesSql {


    /**
     * 添加数据
     *
     * @param files
     * @return
     */
    public String insertFiles(Files files) {
        return new SQL() {{
            INSERT_INTO("t_files");
            INTO_COLUMNS("id , superId , file_name , type , del , sort");
            INTO_VALUES("#{id} , #{superId} , #{file_name} , #{type} , #{del} , #{sort}");
        }}.toString();
    }


    /**
     * 根据父类id获取数据
     *
     * @param superId
     * @return
     */
    public String selectFilesBySuperId(String superId) {
        return new SQL() {{
            SELECT("id , superId , file_name , type , del , sort");
            FROM("t_files");
            WHERE("superId = #{superId} and del = '0'");
            ORDER_BY("sort");
        }}.toString();
    }


    /**
     * 根据id集合查询数据集合
     *
     * @return
     */
    public String selectFilesById(Map<String, Object> params) {
        List<String> ids = (List<String>) params.get("ids");
        SQL sql = new SQL();
        sql.SELECT("id , superId , file_name , type , del , sort");
        sql.FROM("t_files");
        StringBuffer stringBuffer = new StringBuffer();
        if (ids.size() == 0) {
            stringBuffer.append("''");
        } else {
            for (int i = 0; i < ids.size(); i++) {
                if (i == ids.size() - 1) {
                    stringBuffer.append("'" + ids.get(i) + "'");
                } else {
                    stringBuffer.append("'" + ids.get(i) + "',");
                }
            }
        }
        sql.WHERE("del = '0' and id in (" + stringBuffer.toString() + ")");
        sql.ORDER_BY("sort");
        return sql.toString();
    }


    /**
     * 根据父类id获取总条数
     *
     * @param superId
     * @return
     */
    public String selectCount(String superId) {
        return new SQL() {{
            SELECT("COUNT(id)");
            FROM("t_files");
            WHERE("superId = #{superId} and del = '0'");
            ORDER_BY("sort");
        }}.toString();
    }


    /**
     * 查询所有数据
     * @return
     */
    public String selectAllFiles(){
        return new SQL(){{
            SELECT("id , superId , file_name , type , del , sort");
            FROM("t_files");
            WHERE("del = '0'");
        }}.toString();
    }


    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    public String deleteFilesById(String id){
        return new SQL(){{
            UPDATE("t_files");
            SET("del = '1'");
            WHERE("id = #{id}");
        }}.toString();
    }


    /**
     * 修改数据
     * @param files
     * @return
     */
    public String updateFiles(Files files){
        return new SQL(){{
            UPDATE("t_files");
            SET("file_name = #{file_name}");
            WHERE("id = #{id}");
        }}.toString();
    }

}
