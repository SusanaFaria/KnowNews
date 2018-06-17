package com.example.android.knownews;

public class News {

    private String mThumbnail;
    private String mNewsTitle;
    private String mAuthor;
    private String mDateAndTime;
    private String mUrl;
    private String mSection;

    public News(String thumbnail, String newsTitle, String author, String dateNtime, String url, String section) {

        mThumbnail = thumbnail;
        mNewsTitle = newsTitle;
        mAuthor = author;
        mDateAndTime = dateNtime;
        mUrl = url;
        mSection = section;
    }

    public String getThumbnail() {
        return mThumbnail;
    }

    public String getNewsTitle() {
        return mNewsTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }


    public String getDateNtime() {
        return mDateAndTime;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getSection() {
        return mSection;
    }
}




