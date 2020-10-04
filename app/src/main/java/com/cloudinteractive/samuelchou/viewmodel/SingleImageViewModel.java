package com.cloudinteractive.samuelchou.viewmodel;

import android.app.Activity;
import android.util.Log;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.cloudinteractive.samuelchou.data.ImageGallery;

public class SingleImageViewModel {

    private ImageGallery gallery;
    private String tag;
    private Activity activity;

    public final ObservableInt id = new ObservableInt(-1);
    public final ObservableField<String> title = new ObservableField<>();
    public final ObservableBoolean isLoading = new ObservableBoolean(false);

    public SingleImageViewModel(Activity activity) {
        gallery = new ImageGallery(activity);
        this.activity = activity;
        tag = activity.getLocalClassName();
    }

    public void RequestSingleImage(int id) {
        this.id.set(id);
        isLoading.set(true);
        gallery.RequestSingleImage(id, new ImageGallery.OnResponseListener() {
            @Override
            public void onResponse(ImageGallery.SingleImage image) {
                Log.i(tag, "onResponse: System response with " + image.getTitle());
                isLoading.set(false);
                title.set(image.getTitle());
            }

            @Override
            public void onFail() {
                Log.e(tag, "onResponse: System response failed.");
                isLoading.set(false);
            }
        });
    }

    public void FinishActivity() {
        activity.finish();
    }
}
