package com.example.notesjava.data.repository;

import com.example.notesjava.data.database.NoteDto;
import com.example.notesjava.data.database.NotesDatabase;
import com.example.notesjava.domain.model.Note;
import com.example.notesjava.domain.repository.NotesRepository;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class RealNotesRepository implements NotesRepository {
    private final NotesDatabase database;

    @Inject
    public RealNotesRepository(NotesDatabase database) {
        this.database = database;
    }

    @Override
    public List<Note> getNotes() {
        return database.getNotes().stream().map(RealNotesRepository::mapNoteDtoToNote).collect(Collectors.toList());
    }

    @Nullable
    @Override
    public Note getNote(int id) {
        NoteDto noteDto = database.getNote(id);
        if (noteDto == null) {
            return null;
        }
        return mapNoteDtoToNote(noteDto);
    }

    @Override
    public void addNote(String title, String content) {
        database.addNote(title, content);
    }

    @Override
    public void editNote(int id, String title, String content) {
        database.editNote(id, title, content);
    }

    @Override
    public void deleteNote(int id) {
        database.deleteNode(id);
    }

    private static Note mapNoteDtoToNote(NoteDto note) {
        return new Note(note.getId(), note.getTitle(), note.getContent());
    }
}
