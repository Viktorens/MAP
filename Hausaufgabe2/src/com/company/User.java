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
}
