package com.ladwa.aditya.challenge.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Match implements Parcelable {

    @SerializedName("Alpha")
    @Expose
    private Alpha alpha;
    @SerializedName("Bravo")
    @Expose
    private Bravo bravo;
    @SerializedName("Charlie")
    @Expose
    private Charlie charlie;
    @SerializedName("Delta")
    @Expose
    private Delta delta;
    @SerializedName("Echo")
    @Expose
    private Echo echo;

    private int teamPoint;
    private int teamGoalDiff;

    protected Match(Parcel in) {
    }

    public static final Creator<Match> CREATOR = new Creator<Match>() {
        @Override
        public Match createFromParcel(Parcel in) {
            return new Match(in);
        }

        @Override
        public Match[] newArray(int size) {
            return new Match[size];
        }
    };


    public Alpha getAlpha() {
        return alpha;
    }

    public void setAlpha(Alpha alpha) {
        this.alpha = alpha;
    }

    public Bravo getBravo() {
        return bravo;
    }

    public void setBravo(Bravo bravo) {
        this.bravo = bravo;
    }

    public Charlie getCharlie() {
        return charlie;
    }

    public void setCharlie(Charlie charlie) {
        this.charlie = charlie;
    }

    public Delta getDelta() {
        return delta;
    }

    public void setDelta(Delta delta) {
        this.delta = delta;
    }

    public Echo getEcho() {
        return echo;
    }

    public void setEcho(Echo echo) {
        this.echo = echo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
