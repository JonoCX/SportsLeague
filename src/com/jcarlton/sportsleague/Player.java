package com.jcarlton.sportsleague;

import java.util.Calendar;
import java.util.Date;

 /**
 * Sports League Scenario as part of the introduction to
 * the Cloud Computing MSc.
 *
 * @author Jonathan Carlton
 */
public class Player {

    private String name;
    private Date dob;
    private double height;

    private int goalTally;

    private int age;

    public Player(String name, Date dob, double height) {
        this.name = name;
        this.dob = dob;
        setAge();
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
        setAge();
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void increaseTally(int amount) {
        this.goalTally += amount;
    }

    public int getGoalTally() {
        return goalTally;
    }

    private void setAge() {
        Calendar present = Calendar.getInstance();
        Calendar past = Calendar.getInstance();
        past.setTime(dob);

        int years = 0;

        while (past.before(present)) {
            past.add(Calendar.YEAR, 1);
            if (past.before(present)) {
                years++;
            }
        }

        this.age = years;
    }

    public int getAge() {
        return age;
    }

     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;

         Player player = (Player) o;

         if (Double.compare(player.getHeight(), getHeight()) != 0) return false;
         if (getGoalTally() != player.getGoalTally()) return false;
         if (!getName().equals(player.getName())) return false;
         return getDob().equals(player.getDob());

     }

     @Override
     public int hashCode() {
         int result;
         long temp;
         result = getName().hashCode();
         result = 31 * result + getDob().hashCode();
         temp = Double.doubleToLongBits(getHeight());
         result = 31 * result + (int) (temp ^ (temp >>> 32));
         result = 31 * result + getGoalTally();
         return result;
     }

     @Override
     public String toString() {
         return "Player{" +
                 "name='" + name + '\'' +
                 ", dob=" + dob +
                 ", height=" + height +
                 ", goalTally=" + goalTally +
                 '}';
     }
 }
