package com.ladwa.aditya.challenge.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Match {

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
}
