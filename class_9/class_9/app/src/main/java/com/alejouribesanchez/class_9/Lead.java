package com.alejouribesanchez.class_9;

import java.util.UUID;

/**
 * Created by alejo on 2/23/17.
 */

public class Lead {
    private String mId;
    private String mName;
    private String mTitle;
    private String mCompany;
    private int mImage;

    public Lead(String name, String title, String company, int image) {
        mId = UUID.randomUUID().toString();
        mName = name;
        mTitle = title;
        mCompany = company;
        mImage = image;
    }

    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getCompany() {
        return mCompany;
    }

    public void setCompany(String mCompany) {
        this.mCompany = mCompany;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int mImage) {
        this.mImage = mImage;
    }

    @Override
    public String toString() {
        return "Lead{" +
                "ID='" + mId + '\'' +
                ", Compañía='" + mCompany + '\'' +
                ", Nombre='" + mName + '\'' +
                ", Cargo='" + mTitle + '\'' +
                '}';
    }
}
