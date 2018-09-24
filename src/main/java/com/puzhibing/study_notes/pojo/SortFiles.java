package com.puzhibing.study_notes.pojo;


/**
 * 定义分类与文件关系实体类
 */
public class SortFiles {

    private String id;

    private String sort_id;

    private String files_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSort_id() {
        return sort_id;
    }

    public void setSort_id(String sort_id) {
        this.sort_id = sort_id;
    }

    public String getFiles_id() {
        return files_id;
    }

    public void setFiles_id(String files_id) {
        this.files_id = files_id;
    }

    @Override
    public String toString() {
        return "SortFiles{" +
                "id='" + id + '\'' +
                ", sort_id='" + sort_id + '\'' +
                ", files_id='" + files_id + '\'' +
                '}';
    }
}
