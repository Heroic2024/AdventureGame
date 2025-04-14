/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adventuregame;

public class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public boolean isConsumable() {
        return name.equalsIgnoreCase("Health Potion")||name.equalsIgnoreCase("Magic Herb");
    }
}