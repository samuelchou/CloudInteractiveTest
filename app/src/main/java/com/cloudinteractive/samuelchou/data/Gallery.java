package com.cloudinteractive.samuelchou.data;

public class Gallery {


    public static class SingleImage {
        private int id;
        private String title;
        private String thumbnailUrl;

        public SingleImage() {
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
    }
}
