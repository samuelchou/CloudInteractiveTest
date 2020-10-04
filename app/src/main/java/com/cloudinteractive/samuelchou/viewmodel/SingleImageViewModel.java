package com.cloudinteractive.samuelchou.viewmodel;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
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
    public final ObservableField<Bitmap> thumb = new ObservableField<>();

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
                SetSingleImage(image);
            }

            @Override
            public void onFail() {
                Log.e(tag, "onResponse: System response failed.");
                isLoading.set(false);
            }
        });
    }

    public void SetSingleImage(ImageGallery.SingleImage image) {
        title.set(image.getTitle());
        RequestIntoDrawable(image);
    }

    private void RequestIntoDrawable(ImageGallery.SingleImage image) {
        ImageGallery.OnBitmapResponseListener listener = new ImageGallery.OnBitmapResponseListener() {
            @Override
            public void onResponse(Bitmap bitmap) {
                thumb.set(bitmap);
            }

            @Override
            public void onFail() {
            }
        };
//        gallery.RequestBitmap(image.getThumbnailUrl(), listener);
        // TODO: 2020/10/4 暫時寫為這行，因為JSON Placeholder的圖片有問題......
        gallery.RequestBitmap(ImageGallery.GetRandomDummyPicUrl(), listener);
    }

    @BindingAdapter("android:src")
    public static void loadBitmapInto(ImageView imageView, Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }

    public void FinishActivity() {
        activity.finish();
    }
}
