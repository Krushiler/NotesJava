package com.example.notesjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.notesjava.databinding.ActivityMainBinding;
import com.example.notesjava.presentation.list.NoteListFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(
                            viewBinding.container.getId(),
                            new NoteListFragment()
                    )
                    .commit();
        }
    }

    public void navigate(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(
                        viewBinding.container.getId(),
                        fragment
                )
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }

    public void back() {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}