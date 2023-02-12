package com.example.notesjava.domain.repository;

import com.example.notesjava.domain.model.Note;

import java.util.List;

public interface NotesRepository {
    List<Note> getNotes();

    Note getNote(int id);

    void addNote(String title, String content);

    void editNote(int id, String title, String content);

    void deleteNote(int id);
}
