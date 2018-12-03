package com.example.javi.forniteuservice.ForniteStadistics.dto;

public class ForniteUser {

    private ForniteStats stats;

    public ForniteStats getStats() {
        return stats;
    }

    public void setStats(ForniteStats stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "ForniteObject{" +
                ", stats=" + stats +
                '}';
    }
}