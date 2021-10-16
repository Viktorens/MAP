package com.company;

public class TeamSport implements Sport {
    public double calculateTime(double totalTime, int breaks) {
        double breakTime = 15;
        return totalTime - breaks * breakTime;
    }
}
