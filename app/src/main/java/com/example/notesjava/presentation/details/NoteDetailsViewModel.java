package com.example.notesjava.presentation.details;

import androidx.lifecycle.ViewModel;

import com.example.notesjava.data.repository.NotesRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class NoteDetailsViewModel extends ViewModel {

    private final NotesRepository repository;

    @Inject
    public NoteDetailsViewModel(NotesRepository repository) {
        this.repository = repository;
    }

    public void saveNote(String title, String content) {
        repository.addNote(
                title, content
        );
    }
}
