package com.puzhibing.study_notes.mapper.sql;

import com.puzhibing.study_notes.pojo.Notes;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public class NotesSql {


    /**
     * 添加数据
     * @param notes
     * @return
     */
    public String insertNotes(Notes notes){
        return new SQL(){{
            INSERT_INTO("t_notes");
            INTO_COLUMNS("id , superId , title , content , insertDate , updataDate , del , sort");
            INTO_VALUES("#{id} , #{superId} , #{title} , #{content} , #{insertDate} , #{updataDate} , #{del} , #{sort}");
        }}.toString();
    }


    /**
     * 修改数据
     * @param notes
     * @return
     */
    public String updateNotes(Notes notes){
        return new SQL(){{
            UPDATE("t_notes");
            SET("title = #{title} , content = #{content} , updataDate = #{updataDate}");
            WHERE("id = #{id}");
        }}.toString();
    }


    /**
     * 删除数据
     * @param id
     * @return
     */
    public String deleteNotes(String id){
        return new SQL(){{
            UPDATE("t_notes");
            SET("del = '1'");
            WHERE("id = #{id}");
        }}.toString();
    }


    /**
     * 根据id查询自身数据
     * @param id
     * @return
     */
    public String selectNotesById(String id){
        return new SQL(){{
            SELECT("id , superId , title , content , insertDate , updataDate , del , sort");
            FROM("t_notes");
            WHERE("id = #{id} and del = '0'");
        }}.toString();
    }


    /**
     * 根据id查询直接子节点的数据
     * @param superId
     * @return
     */
    public String selectNotesBySuperId(String superId){
        return new SQL(){{
            SELECT("id , superId , title , content , insertDate , updataDate , del , sort");
            FROM("t_notes");
            WHERE("superId = #{superId} and del = '0'");
            ORDER_BY("sort");
        }}.toString();
    }


    /**
     * 获取系统中父类为superId的总数
     * @param superId
     * @return
     */
    public String selectCount(String superId){
        return new SQL(){{
            SELECT("COUNT(id)");
            FROM("t_notes");
            WHERE("superId = #{superId} and del = '0'");
        }}.toString();
    }

}
