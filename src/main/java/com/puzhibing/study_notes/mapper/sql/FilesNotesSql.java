package com.puzhibing.study_notes.mapper.sql;


import com.puzhibing.study_notes.pojo.FilesNotes;
import org.apache.ibatis.jdbc.SQL;

/**
 * 定义关系数据sql类
 */
public class FilesNotesSql {


    /**
     * 添加数据
     * @param filesNotes
     * @return
     */
    public String insertFilesNotes(FilesNotes filesNotes){
        return new SQL(){{
            INSERT_INTO("t_files_notes");
            INTO_COLUMNS("id , filesId , notesId");
            INTO_VALUES("#{id} , #{filesId} , #{notesId}");
        }}.toString();
    }


    /**
     * 根据文件id获取关系数据
     * @param filesId
     * @return
     */
    public String selectFilesNotesByFilesId(String filesId){
        return new SQL(){{
            SELECT("id , filesId , notesId");
            FROM("t_files_notes");
            WHERE("filesId = #{filesId}");
        }}.toString();
    }
}
