package com.puzhibing.study_notes.pojo;

import java.util.Date;

/**
 * 定义笔记实体类
 */
public class Notes {

    private String id;

    private String superId;

    private String title;

    private String content;

    private Date insertDate;

    private Date updataDate;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Date getUpdataDate() {
        return updataDate;
    }

    public void setUpdataDate(Date updataDate) {
        this.updataDate = updataDate;
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
        return "Notes{" +
                "id='" + id + '\'' +
                ", superId=" + superId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", insertDate=" + insertDate +
                ", updataDate=" + updataDate +
                ", del='" + del + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }
}
