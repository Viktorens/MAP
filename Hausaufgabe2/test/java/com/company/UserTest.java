package com.company;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @org.junit.jupiter.api.Test
    void calculateTime() {
        Sport football = new Football();
        Sport basketball = new Basketball();
        Sport jumping = new Jumping();
        Sport running = new Running();

        User user = new User("Victor", "Greavu", Arrays.asList(basketball, football, jumping, running));

        assertEquals(user.calculateTime(), user.calculateTime(basketball) + user.calculateTime(football) + user.calculateTime(jumping) + user.calculateTime(running));
    }

    @org.junit.jupiter.api.Test
    void testCalculateTime() {
        Sport football = new Football();
        Sport basketball = new Basketball();
        Sport jumping = new Jumping();
        Sport running = new Running();

        User user = new User("Victor", "Greavu", Arrays.asList(basketball, football, jumping, running));

        assertEquals(user.calculateTime(basketball), 55);
        assertEquals(user.calculateTime(football), 65);
        assertEquals(user.calculateTime(jumping), 20);
        assertEquals(user.calculateTime(running), 30);

    }

    @org.junit.jupiter.api.Test
    void calculateAverage() {
        Sport football = new Football();
        Sport basketball = new Basketball();
        Sport jumping = new Jumping();
        Sport running = new Running();

        User user = new User("Victor", "Greavu", Arrays.asList(basketball, football, jumping, running));
        assertEquals(user.calculateAverage(), user.calculateTime()/4);
    }
}