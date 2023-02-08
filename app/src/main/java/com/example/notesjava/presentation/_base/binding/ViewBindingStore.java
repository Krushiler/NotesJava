package com.example.notesjava.presentation._base.binding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;

public class ViewBindingStore<VB extends ViewBinding> {

    private final ViewBindingCreator<VB> viewBindingCreator;

    public ViewBindingStore(ViewBindingCreator<VB> viewBindingCreator) {
        this.viewBindingCreator = viewBindingCreator;
    }

    public VB getViewBinding() {
        return viewBinding;
    }

    private VB viewBinding;

    public View createViewBinding(LayoutInflater layoutInflater, ViewGroup container) {
        viewBinding = viewBindingCreator.create(layoutInflater, container, false);
        return viewBinding.getRoot();
    }

    public void destroyViewBinding() {
        viewBinding = null;
    }
}
