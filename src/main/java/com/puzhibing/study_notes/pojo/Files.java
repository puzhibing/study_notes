package com.puzhibing.study_notes.pojo;


/**
 * 定义文件实体类
 */
public class Files {

    private String id;

    private String superId;

    private String file_name;

    private String type;

    private String del;

    private String sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSuperId() {
        return superId;
    }

    public void setSuperId(String superId) {
        this.superId = superId;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    public String getSequence() {
        return sort;
    }

    public void setSequence(String sequence) {
        this.sort = sequence;
    }

    @Override
    public String toString() {
        return "Files{" +
                "id='" + id + '\'' +
                ", superId='" + superId + '\'' +
                ", file_name='" + file_name + '\'' +
                ", type='" + type + '\'' +
                ", del='" + del + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }
}
