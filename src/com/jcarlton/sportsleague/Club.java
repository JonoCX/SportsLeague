package com.jcarlton.sportsleague;

import java.util.List;

/**
 * Sports League Scenario as part of the introduction to
 * the Cloud Computing MSc.
 *
 * @author Jonathan Carlton
 */
public class Club {

    private String name;
    private int goalsScored;
    private int goalsConceded;
    private int points; // points in the league
    private List<Player> players;

    public Club(String name, List<Player> players) {
        this.name = name;
        this.players = players;
    }

    public Club(String name, int goalsScored, int goalsConceded, int points, List<Player> players) {
        this.name = name;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
        this.points = points;
        this.players = players;
    }

    public void increaseGoalsScored(int amount) {
        this.goalsScored += amount;
    }

    public void increaseGoalsConceded(int amount) {
        this.goalsConceded += amount;
    }

    public int goalDifference() {
        return Math.abs(goalsScored - goalsConceded);
    }

    public void addPoints(int amount) {
        this.points += amount;
    }

    public boolean addPlayer(Player player) {
        if (player == null || players.contains(player)) return false;
        else {
            players.add(player);
            return true;
        }
    }

    public boolean inSquad(Player player) {
        return players.contains(player);
    }

    public double averageAge() {
        if (players.isEmpty()) return 0.0;

        int addedTogether = 0;
        for (Player p : players) addedTogether += p.getAge();

        int amount = players.size();
        return (double) (addedTogether / amount);
    }

    public double averageHeight() {
        if (players.isEmpty()) return 0.0;

        double addedTogether = 0.0;
        for (Player p : players) addedTogether += p.getHeight();

        int amount = players.size();
        return addedTogether / amount;
    }

    /*
        Getters/Setters/Equals/Hash/toString
     */

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Club club = (Club) o;

        if (goalsScored != club.goalsScored) return false;
        if (goalsConceded != club.goalsConceded) return false;
        if (getPoints() != club.getPoints()) return false;
        if (!getName().equals(club.getName())) return false;
        return players.equals(club.players);

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + goalsScored;
        result = 31 * result + goalsConceded;
        result = 31 * result + getPoints();
        result = 31 * result + players.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Club{" +
                "name='" + name + '\'' +
                ", goalsScored=" + goalsScored +
                ", goalsConceded=" + goalsConceded +
                ", points=" + points +
                ", players=" + players +
                '}';
    }
}
