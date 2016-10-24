
package com.ladwa.aditya.challenge.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Echo implements Parcelable {

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

    private int teamPoint;
    private int teamGoalDiff;
    private int won = 0, loss = 0, draw = 0;

    protected Echo(Parcel in) {
        match1 = in.readString();
        match2 = in.readString();
        match3 = in.readString();
        match4 = in.readString();
    }

    public String getMatch(int i) {
        switch (i) {
            case 1:
                return match1;
            case 2:
                return match2;
            case 3:
                return match3;
            case 4:
                return match4;
        }
        return null;
    }


    public int getTeamPoint() {
        int ownScore = 0, otherScore = 0;
        for (int i = 1; i <= 4; i++) {
            ownScore = (int) this.getMatch(i).charAt(0);
            otherScore = (int) this.getMatch(i).charAt(2);
            if (ownScore > otherScore) {
                teamPoint += 3;
                won++;
            } else if (ownScore == otherScore) {
                teamPoint += 1;
                loss++;
            } else {
                draw++;
            }
            teamGoalDiff = ownScore - otherScore;
        }
        return teamPoint;
    }

    public int getTeamGoalDiff() {
        return teamGoalDiff;
    }

    public static final Creator<Echo> CREATOR = new Creator<Echo>() {
        @Override
        public Echo createFromParcel(Parcel in) {
            return new Echo(in);
        }

        @Override
        public Echo[] newArray(int size) {
            return new Echo[size];
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

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
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
