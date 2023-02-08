package com.example.notesjava.data.database;

public class NoteDto {
    private final int id;
    private final String title;
    private final String content;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public NoteDto(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
