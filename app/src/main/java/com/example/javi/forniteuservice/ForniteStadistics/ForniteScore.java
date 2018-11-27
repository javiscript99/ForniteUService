package com.example.javi.forniteuservice.ForniteStadistics;

public class ForniteScore {

    private ForniteRank score;
    private ForniteRank scorePerMatch;
    private ForniteRank matches;
    private ForniteRank kills;

    public ForniteRank getScore() {
        return score;
    }

    public void setScore(ForniteRank score) {
        this.score = score;
    }

    public ForniteRank getScorePerMatch() {
        return scorePerMatch;
    }

    public void setScorePerMatch(ForniteRank scorePerMatch) {
        this.scorePerMatch = scorePerMatch;
    }

    public ForniteRank getMatches() {
        return matches;
    }

    public void setMatches(ForniteRank matches) {
        this.matches = matches;
    }

    public ForniteRank getKills() {
        return kills;
    }

    public void setKills(ForniteRank kills) {
        this.kills = kills;
    }
}
