/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adventuregame;

import java.util.Random;
import java.util.Scanner;

public class GameEngine {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void exploreCave(Player player) {
        System.out.println("You enter the cave and see a treasure chest...");
        System.out.println("1. Open the chest\n2. Leave it");

        int choice = scanner.nextInt();
        if (choice == 1) {
            if (random.nextBoolean()) {
                System.out.println("You found treasure!");
                player.increaseScore(20);
                player.addItem(new Item("Gold Coins"));
            } else {
                System.out.println("A dragon appears!");
                fightEnemy(player, new Dragon());
            }
        }
    }

    public static void enterForest(Player player) {
        System.out.println("You walk into the forest and hear rustling...");
        System.out.println("1. Investigate\n2. Keep walking");

        int choice = scanner.nextInt();
        if (choice == 1) {
            if (random.nextBoolean()) {
                System.out.println("You found a magic herb!");
                player.addItem(new Item("Magic Herb"));
            } else {
                System.out.println("A creature jumps at you!");
                fightEnemy(player, new Creature());
            }
        }
    }

    public static void fightEnemy(Player player, Enemy enemy) {
        System.out.println("You are fighting " + enemy.name + "!");
        System.out.println("1. Fight\n2. Run");

        int choice = scanner.nextInt();
        if (choice == 1) {
            if (random.nextBoolean()) {
                System.out.println("You defeated the " + enemy.name + "!");
                player.increaseScore(20);
            } else {
                enemy.attack(player);
            }
        } else {
            System.out.println("You escaped!");
        }
    }
}
