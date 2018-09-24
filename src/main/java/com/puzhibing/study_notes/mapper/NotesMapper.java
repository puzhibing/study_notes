package com.puzhibing.study_notes.mapper;

import org.apache.ibatis.annotations.*;

import com.puzhibing.study_notes.mapper.sql.NotesSql;
import com.puzhibing.study_notes.pojo.Notes;

import java.util.List;


public interface NotesMapper {


    /**
     * 添加数据
     * @param notes
     */
    @InsertProvider(type = NotesSql.class , method = "insertNotes")
    void insertNotes(Notes notes);


    /**
     * 修改数据
     * @param notes
     */
    @UpdateProvider(type = NotesSql.class , method = "updateNotes")
    void updateNotes(Notes notes);


    /**
     * 删除数据
     * @param id
     */
    @DeleteProvider(type = NotesSql.class , method = "deleteNotes")
    void deleteNotes(String id);


    /**
     * 查询自身数据及对应的直接子数据
     * @param id
     * @return
     */
    @SelectProvider(type = NotesSql.class , method = "selectNotesById")
    Notes selectNotesById(String id);


    /**
     * 根据父层id查询数据
     * @param superId
     * @return
     */
    @SelectProvider(type = NotesSql.class , method = "selectNotesBySuperId")
    List<Notes> selectNotesBySuperId(String superId);


    /**
     * 根据id集合查询数据
     * @param ids
     * @return
     */
    @Select("<script>"
            + "select id , superId , title , content , insertDate , updataDate , del from t_notes where del = '0'"
            + "<if test = 'ids.size() == 0'>"
            +   "and id in('')"
            + "</if>"
            + "<if test = 'ids.size() != 0'>"
            +   "and id in"
            +   "<foreach item='id' index='index' collection='ids' open='(' separator=',' close=')'>"
            +       "#{id}"
            +   "</foreach>"
            + "</if>"
            + "order by sort"
            + "</script>")
    List<Notes> selectNotesInIds(@Param("ids") List<String> ids);


    /**
     * 获取系统中父类为superId的总数
     * @param superId
     * @return
     */
    @SelectProvider(type = NotesSql.class , method = "selectCount")
    int selectCount(String superId);


}
