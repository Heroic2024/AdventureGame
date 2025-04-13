/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adventuregame;


import java.util.ArrayList;
import java.util.List;

public class Player {
    private int health = 100;
    private int score = 0;
    private List<Item> inventory = new ArrayList<>();
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void increaseScore(int points) {
        score += points;
        System.out.println("Score: " + score);
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println("You took " + damage + " damage. Health: " + health);
        if (health <= 0) {
            System.out.println("you died!");
        }
    }

    public void addItem(Item item) {
        inventory.add(item);
        System.out.println("Added " + item.getName() + " to inventory.");
    }
   
    
    

    public int getHealth() { return health; }
    public int getScore() { return score; }
    
    public void useItem(String itemName) {
    for (Item item : inventory) {
        if (item.getName().equalsIgnoreCase(itemName) && item.isConsumable()) {
            System.out.println("Using " + item.getName() + "...");
            health += 30;
            System.out.println("Health restored to: " + health);
            inventory.remove(item);
            return;
        }
    }
    System.out.println("No usable item named '" + itemName + "' found.");
}

    public List<Item> getInventory() {
        return inventory;
    }
}

