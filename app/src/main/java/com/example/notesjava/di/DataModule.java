package com.example.notesjava.di;

import com.example.notesjava.data.database.NotesDatabase;
import com.example.notesjava.data.repository.RealNotesRepository;
import com.example.notesjava.domain.repository.NotesRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DataModule {
    @Provides
    @Singleton
    NotesDatabase provideNoteDatabase() {
        return new NotesDatabase();
    }

    @Provides
    @Singleton
    NotesRepository provideNotesRepository(NotesDatabase notesDatabase) {
        return new RealNotesRepository(notesDatabase);
    }
}
