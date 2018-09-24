package com.puzhibing.study_notes.mapper.sql;

import com.puzhibing.study_notes.pojo.SortFiles;
import org.apache.ibatis.jdbc.SQL;

public class SortFilesSql {


    /**
     * 添加数据
     * @param sortFiles
     * @return
     */
    public String insertSortFiles(SortFiles sortFiles){
        return new SQL(){{
            INSERT_INTO("t_sort_files");
            INTO_COLUMNS("id , sort_id , files_id");
            INTO_VALUES("#{id} , #{sort_id} , #{files_id}");
        }}.toString();
    }


    /**
     * 根据分类id获取数据
     * @param sort_id
     * @return
     */
    public String selectSortFilesBySortId(String sort_id){
        return new SQL(){{
            SELECT("id , sort_id , files_id");
            FROM("t_sort_files");
            WHERE("sort_id = #{sort_id}");
        }}.toString();
    }

}
