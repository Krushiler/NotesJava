package com.example.notesjava.presentation.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.notesjava.domain.model.Note;
import com.example.notesjava.domain.repository.NotesRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class NoteListViewModel extends ViewModel {
    private final NotesRepository repository;
    private final MutableLiveData<List<Note>> notes;

    @Inject
    public NoteListViewModel(NotesRepository repository) {
        this.repository = repository;
        notes = new MutableLiveData<>();
    }

    public void loadNotes() {
        notes.postValue(repository.getNotes());
    }

    public LiveData<List<Note>> getNotesLiveData() {
        return notes;
    }
}
