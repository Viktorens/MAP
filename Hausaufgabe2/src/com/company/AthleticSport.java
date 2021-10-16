package com.company;

public class AthleticSport implements Sport {
    public double calculateTime(double totalTime, int breaks) {
        double breakTime = 5;
        return totalTime - breaks * breakTime;
    }
}
