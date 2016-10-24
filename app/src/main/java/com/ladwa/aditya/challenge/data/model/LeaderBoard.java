package com.ladwa.aditya.challenge.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Aditya on 24-Oct-16.
 */

public class LeaderBoard implements Parcelable {
    private String teamName;
    private Integer played = 4;
    private Integer points;
    private Integer won;
    private Integer lost;
    private Integer drawn;
    private Integer goalDifference;

    public LeaderBoard() {
    }


    protected LeaderBoard(Parcel in) {
        teamName = in.readString();
        points = in.readInt();
        won = in.readInt();
        lost = in.readInt();
        drawn = in.readInt();
        goalDifference = in.readInt();
    }

    public static final Creator<LeaderBoard> CREATOR = new Creator<LeaderBoard>() {
        @Override
        public LeaderBoard createFromParcel(Parcel in) {
            return new LeaderBoard(in);
        }

        @Override
        public LeaderBoard[] newArray(int size) {
            return new LeaderBoard[size];
        }
    };

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getPlayed() {
        return played;
    }

    public void setPlayed(Integer played) {
        this.played = played;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getWon() {
        return won;
    }

    public void setWon(Integer won) {
        this.won = won;
    }

    public Integer getLost() {
        return lost;
    }

    public void setLost(Integer lost) {
        this.lost = lost;
    }

    public Integer getDrawn() {
        return drawn;
    }

    public void setDrawn(Integer drawn) {
        this.drawn = drawn;
    }

    public Integer getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(Integer goalDifference) {
        this.goalDifference = goalDifference;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(teamName);
        parcel.writeInt(points);
        parcel.writeInt(won);
        parcel.writeInt(lost);
        parcel.writeInt(drawn);
        parcel.writeInt(goalDifference);

    }
}
