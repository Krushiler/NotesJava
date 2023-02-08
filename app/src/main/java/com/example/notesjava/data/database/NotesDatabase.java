package com.example.notesjava.data.database;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class NotesDatabase {
    private final ArrayList<NoteDto> notes;
    private AtomicInteger lastId;

    @Inject
    public NotesDatabase() {
        notes = new ArrayList<>();
        lastId = new AtomicInteger(0);
    }

    public ArrayList<NoteDto> getNotes() {
        return notes;
    }

    @Nullable
    public NoteDto getNote(int id) {
        for (NoteDto note : notes) {
            if (note.getId() == id) return note;
        }
        return null;
    }

    public void addNote(String title, String content) {
        notes.add(new NoteDto(
                lastId.get(),
                title,
                content
        ));
    }

    public void deleteNode(int id) {
        notes.removeIf(
                noteDto -> noteDto.getId() == id
        );
    }
}
