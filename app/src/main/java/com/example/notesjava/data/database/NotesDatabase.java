package com.example.notesjava.data.database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class NotesDatabase {
    private final ArrayList<NoteDto> notes;
    private final AtomicInteger lastId;

    @Inject
    public NotesDatabase() {
        notes = new ArrayList<>();
        lastId = new AtomicInteger(0);
    }

    public List<NoteDto> getNotes() {
        List<NoteDto> notesToReturn = (List<NoteDto>) notes.clone();
        Collections.reverse(notesToReturn);
        return notesToReturn;
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
                lastId.getAndIncrement(),
                title,
                content
        ));
    }

    public void editNote(int id, String title, String content) {
        deleteNode(id);
        notes.add(new NoteDto(
                id, title, content
        ));
    }

    public void deleteNode(int id) {
        notes.removeIf(
                noteDto -> noteDto.getId() == id
        );
    }
}
