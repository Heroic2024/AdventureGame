/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adventuregame;

public class Creature extends Enemy {
    public Creature() {
        super("Forest Creature", 50);
    }

    @Override
    public void attack(Player player) {
        System.out.println(name + " claws you!");
        player.takeDamage(damage);
    }
}
