/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adventuregame;

public abstract class Enemy {
    protected String name;
    protected int damage;

    public Enemy(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public abstract void attack(Player player);
}
