package com.example.myapplication;

public class UserItem {
    private int mImageResource;
    private String mUserName;

    public UserItem(int imageResource, String userName) {
        mImageResource = imageResource;
        mUserName = userName;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public String getUserName() {
        return mUserName;
    }
}
