package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Sport football = new Football();
        Sport basketball = new Basketball();
        Sport jumping = new Jumping();
        Sport running = new Running();

        User user1 = new User("Victor", "Greavu", Arrays.asList(football, jumping));
        User user2 = new User("Ion", "Ionescu", Arrays.asList(basketball, running));

        System.out.println("User1: " + user1.calculateTime() + " " + user1.calculateTime(football) + " " + user1.calculateTime(jumping) + " " + user1.calculateAverage());
        System.out.println("User2: " + user2.calculateTime() + " " + user2.calculateTime(basketball) + " " + user2.calculateTime(running) + " " + user2.calculateAverage());
    }
}
