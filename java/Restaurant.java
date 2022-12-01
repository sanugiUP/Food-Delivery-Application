package com.example.mad_assignment;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Restaurant implements Parcelable {
    private final String img_link;
    private String label;
    private String location;

    public Restaurant(String img_link, String label, String location)
    {
        this.img_link = img_link;
        this.label = label;
        this.location = location;
    }

    protected Restaurant(Parcel in) {
        img_link = in.readString();
        label = in.readString();
        location = in.readString();
    }

    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };

    public String getLocation(){return location;}

    public String getImageLink()
    {
        return img_link;
    }

    public String getLabel()
    {
        return label;
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(img_link);
        parcel.writeString(label);
        parcel.writeString(location);
    }
}
