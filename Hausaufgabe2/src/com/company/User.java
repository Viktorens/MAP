package com.company;

import java.util.List;

public class User {
    private String _name;
    private String _surname;
    private List<Sport> _sports;

    public User(String name, String surname, List<Sport> sports) {
        _name = name;
        _surname = surname;
        _sports = sports;
    }

    // Getters and Setters
    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_surname() {
        return _surname;
    }

    public void set_surname(String _surname) {
        this._surname = _surname;
    }

    public List<Sport> get_sports() {
        return _sports;
    }

    public void set_sports(List<Sport> _sports) {
        this._sports = _sports;
    }

    // Methode for calculating time
    public double calculateTime() {
        double time = 0;
        for (Sport sports : _sports) {
            time = time + sports.calculateTime();
        }
        return time;
    }

    // Methode for calculating time for specific sport
    public double calculateTime(Sport sports) {
        return sports.calculateTime();
    }

    // Methode for calculating average time
    public double calculateAverage() {
        return calculateTime()/_sports.size();
    }

}
