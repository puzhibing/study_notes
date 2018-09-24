package com.puzhibing.study_notes.pojo;

/**
 * 定义分类实体类
 */
public class Sort {

    private String id;

    private String superId;

    private String sort_name;

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

    public String getSort_name() {
        return sort_name;
    }

    public void setSort_name(String sort_name) {
        this.sort_name = sort_name;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "id='" + id + '\'' +
                ", superId='" + superId + '\'' +
                ", sort_name='" + sort_name + '\'' +
                ", del='" + del + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }
}
