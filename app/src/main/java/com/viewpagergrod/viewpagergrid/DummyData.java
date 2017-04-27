package com.viewpagergrod.viewpagergrid;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ramesh on 27/04/17.
 */

public class DummyData implements Parcelable {
    String title;

    DummyData(String title) {
        this.title = title;
    }

    protected DummyData(Parcel in) {
        title = in.readString();
    }

    public static final Creator<DummyData> CREATOR = new Creator<DummyData>() {
        @Override
        public DummyData createFromParcel(Parcel in) {
            return new DummyData(in);
        }

        @Override
        public DummyData[] newArray(int size) {
            return new DummyData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
    }
}
