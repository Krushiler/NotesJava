package com.example.notesjava.presentation.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.notesjava.MainActivity;
import com.example.notesjava.databinding.FragmentNoteDetailsBinding;
import com.example.notesjava.presentation._base.BaseFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NoteDetailsFragment extends BaseFragment<FragmentNoteDetailsBinding> {
    public NoteDetailsFragment() {
        super(FragmentNoteDetailsBinding::inflate);
    }

    private NoteDetailsViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(NoteDetailsViewModel.class);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getViewBinding().toolbar.setNavigationOnClickListener(v -> {
            ((MainActivity) requireActivity()).back();
        });

        getViewBinding().saveNoteButton.setOnClickListener(v -> {
            viewModel.saveNote(getViewBinding().titleEditText.getText().toString(), getViewBinding().contentEditText.getText().toString());
            ((MainActivity) requireActivity()).back();
        });

        getViewBinding().deleteNoteButton.setOnClickListener(v -> {
            ((MainActivity) requireActivity()).back();
        });
    }
}
