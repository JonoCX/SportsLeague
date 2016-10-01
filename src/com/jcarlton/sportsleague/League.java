package com.jcarlton.sportsleague;

import java.util.List;

/**
 * Sports League Scenario as part of the introduction to
 * the Cloud Computing MSc.
 *
 * @author Jonathan Carlton
 */
public class League {

    private String name;
    private List<Club> clubs;
    private List<Match> fixtures;

    public League(String name) {
        this.name = name;
    }

    public League(String name, List<Club> clubs) {
        this.name = name;
        this.clubs = clubs;
    }

    public League(String name, List<Club> clubs, List<Match> fixtures) {
        this.name = name;
        this.clubs = clubs;
        this.fixtures = fixtures;
    }

    public boolean addClubToLeague(Club club) {
        if (club == null || clubs.contains(club)) return false;

        clubs.add(club);
        return true;

    }

    public boolean addMatchToFixtures(Match match) {
        if (match == null || fixtures.contains(match)) return false;

        fixtures.add(match);
        return true;
    }


    public boolean recordResult(Match updatedMatch) {
        if (updatedMatch == null) return false;

        for (Match m : fixtures) {
            if ((m.getTime().equals(updatedMatch.getTime()) &&
                    (m.getPlace().equals(updatedMatch.getPlace())) &&
                    (m.getHomeTeam().equals(updatedMatch.getHomeTeam())) &&
                    (m.getAwayTeam().equals(updatedMatch.getAwayTeam()))))
            {
                m = updatedMatch;
            }
        }

        return true;
    }

    public Club findTopTeam() {
        int highestPoints = 0;
        Club topTeam = null;

        for (Club c : clubs) {
            if (c.getPoints() > highestPoints) {
                topTeam = c;
                highestPoints = c.getPoints();
            }
        }

        return topTeam;
    }

    public void printLeague() {
        // would need to order the clubs by the number of points first.
    }

    public Player topScorer() {
        int mostGoals = 0;
        Player topScorer = null;

        for (Club c : clubs) {
            for (Player p : c.getPlayers()) {
                if (p.getGoalTally() > mostGoals) {
                    topScorer = p;
                    mostGoals = p.getGoalTally();
                }
            }
        }

        return topScorer;
    }


}
