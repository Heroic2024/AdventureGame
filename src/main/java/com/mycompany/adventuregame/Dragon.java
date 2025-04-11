/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adventuregame;

public class Dragon extends Enemy {
    public Dragon() {
        super("Dragon", 100);
    }

    @Override
    public void attack(Player player) {
        System.out.println(name + " breathes fire!");
        player.takeDamage(damage);
    }
}
