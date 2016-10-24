package com.ladwa.aditya.challenge.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Comparator;

/**
 *
 * Created by Aditya on 24-Oct-16.
 */

public class LeaderBoard implements Parcelable {
    private String teamName;
    private Integer played = 4;
    private Integer points;
    private Integer won, lost, drawn, goalDifference;

    protected LeaderBoard(Parcel in) {
        teamName = in.readString();
    }

    public LeaderBoard() {
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
    }
}
