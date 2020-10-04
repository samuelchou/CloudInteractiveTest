package com.cloudinteractive.samuelchou.data;

import android.content.Context;
import android.graphics.Bitmap;

import androidx.annotation.NonNull;

import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

public class ImageGallery {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/photos";
    private static final String BASE_REQUEST_TAG = "BaseRequestQueue";

    private InternetSourceAgent internetSourceAgent;

    public ImageGallery(Context context) {
        internetSourceAgent = new InternetSourceAgent(context.getApplicationContext(), BASE_REQUEST_TAG);
    }

    public void RequestSingleImage(int id, @NonNull final OnResponseListener responseListener) {
        internetSourceAgent.GetSingleData(BASE_URL + "/" + id, new InternetSourceAgent.ResponseListener<JSONObject>() {
            @Override
            public void OnResponseSuccess(JSONObject object) {
                SingleImage singleImage;
                try {
                    singleImage = new SingleImage(object);
                } catch (JSONException e) {
                    e.printStackTrace();
                    responseListener.onFail();
                    return;
                }
                responseListener.onResponse(singleImage);
            }

            @Override
            public void OnResponseError(VolleyError error) {
                responseListener.onFail();
            }
        });
    }

    private static final String[] DUMMY_PIC_URL = new String[]{
            "https://post.medicalnewstoday.com/wp-content/uploads/sites/3/2020/02/322868_1100-800x825.jpg"
    };

    public static String GetRandomDummyPicUrl() {
        return DUMMY_PIC_URL[0];
//        return DUMMY_PIC_URL[new Random().nextInt(DUMMY_PIC_URL.length)];
    }

    public void RequestBitmap(String url, final OnBitmapResponseListener listener) {
        internetSourceAgent.RequestImage(url, new InternetSourceAgent.ResponseListener<Bitmap>() {
            @Override
            public void OnResponseSuccess(Bitmap object) {
                listener.onResponse(object);
            }

            @Override
            public void OnResponseError(VolleyError error) {
                listener.onFail();
            }
        });
    }

    public interface OnResponseListener {
        void onResponse(SingleImage image);

        void onFail();
    }

    public interface OnBitmapResponseListener {
        void onResponse(Bitmap bitmap);

        void onFail();
    }

    public static class SingleImage {
        private static final String ARG_ID = "id";
        private static final String ARG_TITLE = "title";
        private static final String ARG_THUMB_URL = "thumbnailUrl";
        private static final String ARG_URL = "url";

        private int id;
        private String title;
        private String thumbnailUrl;
        private String url;

        public SingleImage() {
        }

        public SingleImage(int id) {
            this.id = id;
        }

        public SingleImage(JSONObject jsonObject) throws JSONException {
            id = jsonObject.getInt(ARG_ID);
            title = jsonObject.getString(ARG_TITLE);
            thumbnailUrl = jsonObject.getString(ARG_THUMB_URL);
            url = jsonObject.getString(ARG_URL);
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getThumbnailUrl() {
            return thumbnailUrl;
        }

        public String getUrl() {
            return url;
        }
    }
}
