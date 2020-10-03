package com.cloudinteractive.samuelchou.viewmodel;

import android.content.Context;

import androidx.databinding.ObservableField;

import com.cloudinteractive.samuelchou.data.ImageGallery;

public class SingleImageViewModel {

    private ImageGallery gallery;

    public final ObservableField<String> title = new ObservableField<>();

    public SingleImageViewModel(Context context) {
        gallery = new ImageGallery(activity);
    }
}
