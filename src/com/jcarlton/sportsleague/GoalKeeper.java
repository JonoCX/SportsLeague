package com.jcarlton.sportsleague;

import java.util.Date;

/**
 * @author Jonathan Carlton
 */
public class GoalKeeper extends Player {

    private int cleanSheets;

    public GoalKeeper(String name, Date dob, double height) {
        super(name, dob, height);
    }

    public int getCleanSheets() {
        return cleanSheets;
    }

    public void increaseCleanSheets(int amount) {
        this.cleanSheets += amount;
    }
}
