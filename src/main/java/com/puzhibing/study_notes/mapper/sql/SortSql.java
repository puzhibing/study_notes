package com.puzhibing.study_notes.mapper.sql;


import com.puzhibing.study_notes.pojo.Sort;
import org.apache.ibatis.jdbc.SQL;

/**
 * 定义分类sql类
 */
public class SortSql {


    /**
     * 添加数据
     * @param sort
     * @return
     */
    public String insertSort(Sort sort){
        return new SQL(){{
            INSERT_INTO("t_sort");
            INTO_COLUMNS("id , sort_name , del , sort");
            INTO_VALUES("#{id} , #{sort_name} , #{del} , #{sort}");
        }}.toString();
    }


    /**
     * 查询所有数据
     * @return
     */
    public String selectAllSort(){
        return new SQL(){{
            SELECT("id , sort_name , del , sort");
            FROM("t_sort");
            WHERE("del = '0'");
            ORDER_BY("sort");
        }}.toString();
    }


    /**
     * 获取有效数据总数
     * @return
     */
    public String selectCount(){
        return new SQL(){{
            SELECT("COUNT(id)");
            FROM("t_sort");
            WHERE("del = '0'");
        }}.toString();
    }


    /**
     * 修改数据
     * @param sort
     * @return
     */
    public String updateSort(Sort sort){
        return new SQL(){{
            UPDATE("t_sort");
            SET("sort_name = #{sort_name}");
            WHERE("id = #{id}");
        }}.toString();
    }


    /**
     * 删除数据
     * @param id
     * @return
     */
    public String deleteSort(String id){
        return new SQL(){{
            UPDATE("t_sort");
            SET("del = '1'");
            WHERE("id = #{id}");
        }}.toString();
    }
}
