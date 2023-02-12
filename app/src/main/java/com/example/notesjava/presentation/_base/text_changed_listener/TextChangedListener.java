package com.example.notesjava.presentation._base.text_changed_listener;

import android.text.Editable;
import android.text.TextWatcher;

public class TextChangedListener implements TextWatcher {

    private OnTextChanged onTextChanged;

    public TextChangedListener(OnTextChanged onTextChanged) {
        this.onTextChanged = onTextChanged;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        onTextChanged.onTextChanged(s);
    }
}
