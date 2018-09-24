package com.puzhibing.study_notes.pojo;

public class FilesNotes {

    private String id;

    private String filesId;

    private String notesId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilesId() {
        return filesId;
    }

    public void setFilesId(String filesId) {
        this.filesId = filesId;
    }

    public String getNotesId() {
        return notesId;
    }

    public void setNotesId(String notesId) {
        this.notesId = notesId;
    }

    @Override
    public String toString() {
        return "FilesNotes{" +
                "id='" + id + '\'' +
                ", filesId='" + filesId + '\'' +
                ", notesId='" + notesId + '\'' +
                '}';
    }
}
