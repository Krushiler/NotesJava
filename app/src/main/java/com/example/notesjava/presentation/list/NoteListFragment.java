package com.example.notesjava.presentation.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.notesjava.MainActivity;
import com.example.notesjava.databinding.FragmentNoteListBinding;
import com.example.notesjava.domain.Note;
import com.example.notesjava.presentation._base.BaseFragment;
import com.example.notesjava.presentation.details.NoteDetailsFragment;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NoteListFragment extends BaseFragment<FragmentNoteListBinding> {

    private NoteListViewModel viewModel;

    public NoteListFragment() {
        super(FragmentNoteListBinding::inflate);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(NoteListViewModel.class);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ArrayList<Note> notes = new ArrayList<>();

        final NotesListAdapter notesListAdapter = new NotesListAdapter(notes);
        getViewBinding().list.setAdapter(notesListAdapter);

        viewModel.getNotesLiveData().observe(getViewLifecycleOwner(), observingNotes -> {
            notes.clear();
            notes.addAll(observingNotes);
            notesListAdapter.notifyDataSetChanged();
        });

        getViewBinding().createNoteButton.setOnClickListener(v -> {
            ((MainActivity) requireActivity()).navigate(new NoteDetailsFragment());
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.loadNotes();
    }
}
