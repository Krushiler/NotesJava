package com.example.notesjava.presentation._base.binding;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;

public interface ViewBindingCreator<VB extends ViewBinding> {
    VB create(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean attachToRoot);
}
