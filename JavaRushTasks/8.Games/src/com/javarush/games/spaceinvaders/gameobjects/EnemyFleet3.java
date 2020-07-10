package com.javarush.games.spaceinvaders.gameobjects;

public class EnemyFleet3 extends EnemyFleet{
    @Override
    protected double getSpeed() {
        return Math.min(2.5, (4.0 / ships.size()));
    }
}
