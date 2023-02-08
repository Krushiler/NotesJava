package com.example.notesjava.data.repository;

import com.example.notesjava.data.database.NoteDto;
import com.example.notesjava.data.database.NotesDatabase;
import com.example.notesjava.domain.Note;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class NotesRepository {
    private final NotesDatabase database;

    @Inject
    public NotesRepository(NotesDatabase database) {
        this.database = database;
    }

    public List<Note> getNotes() {
        return database.getNotes().stream().map(NotesRepository::mapNoteDtoToNote).collect(Collectors.toList());
    }

    @Nullable
    public Note getNote(int id) {
        NoteDto noteDto = database.getNote(id);
        if (noteDto == null) {
            return null;
        }
        return mapNoteDtoToNote(noteDto);
    }

    public void addNote(String title, String content) {
        database.addNote(title, content);
    }

    public void deleteNote(int id) {
        database.deleteNode(id);
    }

    private static Note mapNoteDtoToNote(NoteDto note) {
        return new Note(note.getId(), note.getTitle(), note.getContent());
    }
}
