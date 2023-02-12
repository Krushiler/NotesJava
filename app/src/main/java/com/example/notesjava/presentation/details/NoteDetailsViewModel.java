package com.example.notesjava.presentation.details;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.notesjava.domain.model.Note;
import com.example.notesjava.domain.repository.NotesRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class NoteDetailsViewModel extends ViewModel {
    private final NotesRepository repository;

    @Inject
    public NoteDetailsViewModel(NotesRepository repository) {
        this.repository = repository;
    }

    private Integer noteId;
    private final MutableLiveData<Note> noteLiveData = new MutableLiveData<>();

    void init(Integer noteId) {
        this.noteId = noteId;
        if (noteId != null) {
            Note note = repository.getNote(noteId);
            noteLiveData.postValue(
                    note
            );
        }
    }

    public void deleteNote() {
        if (noteId != null) {
            repository.deleteNote(noteId);
        }
    }

    public void saveNote(String title, String content) {
        if (noteId == null) {
            repository.addNote(
                    title, content
            );
        } else {
            repository.editNote(
                    noteId, title, content)
            ;
        }
    }

    public LiveData<Note> getNoteLiveData() {
        return noteLiveData;
    }
}
