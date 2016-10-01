package com.jcarlton.sportsleague;

import java.util.Date;
import java.util.Map;

/**
 * Sports League Scenario as part of the introduction to
 * the Cloud Computing MSc.
 *
 * @author Jonathan Carlton
 */
public class Match {

    private Date time;
    private String place;

    private Club homeTeam;
    private Club awayTeam;
    private int homeGoals;
    private int awayGoals;

    // players that played mapped to the number of goals they scored
    private Map<Player, Integer> playersPlayed;

    public Match(Date time, String place, Club homeTeam, Club awayTeam, int homeGoals, int awayGoals, Map<Player, Integer> playersPlayed) {
        this.time = time;
        this.place = place;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.playersPlayed = playersPlayed;
    }

    public String getFinalScore() {
        return homeTeam.getName() + " " + homeGoals + "-" + awayGoals + " " + awayTeam.getName();
    }

    public String getFinalResult() {
        if (homeGoals > awayGoals) return homeTeam.getName() + " win";
        else if (homeGoals < awayGoals) return awayTeam.getName() + " win";
        else return "draw";
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Club getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Club homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Club getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Club awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Match match = (Match) o;

        if (homeGoals != match.homeGoals) return false;
        if (awayGoals != match.awayGoals) return false;
        if (!time.equals(match.time)) return false;
        if (!place.equals(match.place)) return false;
        if (!homeTeam.equals(match.homeTeam)) return false;
        if (!awayTeam.equals(match.awayTeam)) return false;
        return playersPlayed.equals(match.playersPlayed);

    }

    @Override
    public int hashCode() {
        int result = time.hashCode();
        result = 31 * result + place.hashCode();
        result = 31 * result + homeTeam.hashCode();
        result = 31 * result + awayTeam.hashCode();
        result = 31 * result + homeGoals;
        result = 31 * result + awayGoals;
        result = 31 * result + playersPlayed.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Match{" +
                "time=" + time +
                ", place='" + place + '\'' +
                ", homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                ", homeGoals=" + homeGoals +
                ", awayGoals=" + awayGoals +
                ", playersPlayed=" + playersPlayed +
                '}';
    }
}
