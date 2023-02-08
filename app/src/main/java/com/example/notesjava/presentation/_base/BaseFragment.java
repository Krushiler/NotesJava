package com.example.notesjava.presentation._base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import com.example.notesjava.presentation._base.binding.ViewBindingCreator;
import com.example.notesjava.presentation._base.binding.ViewBindingStore;

abstract public class BaseFragment<VB extends ViewBinding> extends Fragment {
    private final ViewBindingCreator<VB> viewBindingCreator;
    private final ViewBindingStore<VB> viewBindingStore;

    public BaseFragment(ViewBindingCreator<VB> viewBindingCreator) {
        this.viewBindingCreator = viewBindingCreator;
        viewBindingStore = new ViewBindingStore<>(viewBindingCreator);
    }

    protected VB getViewBinding() {
        return viewBindingStore.getViewBinding();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return viewBindingStore.createViewBinding(inflater, container);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewBindingStore.destroyViewBinding();
    }
}
