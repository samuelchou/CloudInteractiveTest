package com.cloudinteractive.samuelchou.viewmodel;

import android.content.Context;

import androidx.databinding.ObservableField;

import com.cloudinteractive.samuelchou.data.Gallery;

public class SingleImageViewModel {

    private Gallery gallery;

    public final ObservableField<String> title = new ObservableField<>();

    public SingleImageViewModel(Context context) {
        gallery = new Gallery(context);
    }
}
