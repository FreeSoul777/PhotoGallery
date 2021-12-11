package com.example.photogallery;

import android.net.Uri;

public class GalleryItem {

    private String mCaption;
    private String mId;
    private String mUrl;
    private String mOwner;

    @Override
    public String toString() {
        return mCaption;
    }

    public String getmCaption() {
        return mCaption;
    }

    public String getmId() {
        return mId;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmCaption(String mCaption) {
        this.mCaption = mCaption;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public void setmOwner(String mOwner) {
        this.mOwner = mOwner;
    }

    public String getmOwner() {
        return mOwner;
    }

    public Uri getPhotoPageUri() {
        return Uri.parse("https://www.flickr.com/photos/")
                .buildUpon()
                .appendPath(mOwner)
                .appendPath(mId)
                .build();
    }
}
