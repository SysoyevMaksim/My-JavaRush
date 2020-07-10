package com.javarush.games.spaceinvaders.gameobjects;

public class EnemyFleet2 extends EnemyFleet{
    @Override
    protected double getSpeed() {
        return Math.min(2.0, (3.0 / ships.size()));
    }
}
