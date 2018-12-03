package com.example.javi.forniteuservice.ForniteStadistics.dto;

public class ForniteData {

    private ForniteDataDetails score;
    private ForniteDataDetails scorePerMatch;
    private ForniteDataDetails kills;

    public ForniteDataDetails getScore() {
        return score;
    }

    public void setScore(ForniteDataDetails score) {
        this.score = score;
    }

    public ForniteDataDetails getScorePerMatch() {
        return scorePerMatch;
    }

    public void setScorePerMatch(ForniteDataDetails scorePerMatch) {
        this.scorePerMatch = scorePerMatch;
    }

    public ForniteDataDetails getKills() {
        return kills;
    }

    public void setKills(ForniteDataDetails kills) {
        this.kills = kills;
    }
}
