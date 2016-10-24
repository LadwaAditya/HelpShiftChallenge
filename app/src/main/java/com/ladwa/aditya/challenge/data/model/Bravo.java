
package com.ladwa.aditya.challenge.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bravo implements Parcelable {

    @SerializedName("match_1")
    @Expose
    private String match1;
    @SerializedName("match_2")
    @Expose
    private String match2;
    @SerializedName("match_3")
    @Expose
    private String match3;
    @SerializedName("match_4")
    @Expose
    private String match4;

    protected Bravo(Parcel in) {
        match1 = in.readString();
        match2 = in.readString();
        match3 = in.readString();
        match4 = in.readString();
    }

    public static final Creator<Bravo> CREATOR = new Creator<Bravo>() {
        @Override
        public Bravo createFromParcel(Parcel in) {
            return new Bravo(in);
        }

        @Override
        public Bravo[] newArray(int size) {
            return new Bravo[size];
        }
    };

    public String getMatch1() {
        return match1;
    }

    public void setMatch1(String match1) {
        this.match1 = match1;
    }

    public String getMatch2() {
        return match2;
    }

    public void setMatch2(String match2) {
        this.match2 = match2;
    }

    public String getMatch3() {
        return match3;
    }

    public void setMatch3(String match3) {
        this.match3 = match3;
    }

    public String getMatch4() {
        return match4;
    }

    public void setMatch4(String match4) {
        this.match4 = match4;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(match1);
        parcel.writeString(match2);
        parcel.writeString(match3);
        parcel.writeString(match4);
    }
}
