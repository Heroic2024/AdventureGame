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
                askToContinue(player);
            } else {
                System.out.println("A dragon appears!");
                fightEnemy(player, new Dragon());
            }
        } else {
            System.out.println("You left the chest and exit the cave safely.");
            player.increaseScore(5);
            askToContinue(player);
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
                player.increaseScore(10);
                askToContinue(player);
            } else {
                System.out.println("A creature jumps at you!");
                fightEnemy(player, new Creature());
            }
        } else {
            System.out.println("You keep walking and find a peaceful meadow.");
            System.out.println("You take a rest and enjoy the scenery.");
            player.increaseScore(10);
            askToContinue(player);
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
                if (player.getHealth() <= 0) {
                    endGame(player);
                    return;
                }
            }
        } else {
            System.out.println("You escaped!");
            player.increaseScore(5);
        }

        askToContinue(player);
    }

    public static void endGame(Player player) {
        System.out.println("\n=== Game Over ===");
        System.out.println("Name: " + player.getName());
        System.out.println("Final Score: " + player.getScore());
        System.out.println("Final Health: " + player.getHealth());
        System.out.println("Inventory:");
        for (Item item : player.getInventory()) {
            System.out.println("- " + item.getName());
        }
        System.out.println("Thanks for playing!");
        System.exit(0);
    }

    public static void askToContinue(Player player) {
        System.out.println("\nDo you want to continue exploring? (y/n)");
        String response = scanner.next();
        if (response.equalsIgnoreCase("y")) {
            System.out.println("Where do you want to go next?");
            System.out.println("1. Explore Cave\n2. Enter Forest");

            int choice = scanner.nextInt();
            if (choice == 1) {
                exploreCave(player);
            } else if (choice == 2) {
                enterForest(player);
            } else {
                System.out.println("Invalid choice.");
                endGame(player);
            }
        } else {
            endGame(player);
        }
    }
}