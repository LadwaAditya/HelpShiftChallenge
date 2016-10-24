
package com.ladwa.aditya.challenge.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Echo {

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
}
