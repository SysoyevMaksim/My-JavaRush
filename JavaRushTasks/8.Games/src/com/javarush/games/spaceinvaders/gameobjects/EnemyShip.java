package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;

public class EnemyShip extends Ship{
    public int score = 15;

    public EnemyShip(double x, double y) {
        super(x, y);
        setStaticView(ShapeMatrix.ENEMY);
    }

    public void move(Direction direction, double speed){
        if (direction == Direction.DOWN){
            this.y += 2;
        }

        if (direction == Direction.LEFT){
            this.x -= speed;
        }

        if (direction == Direction.RIGHT){
            this.x += speed;
        }
    }

    public Bullet fire(){
        return new Bullet(x + 1, y + height, Direction.DOWN);
    }

    @Override
    public void kill() {
        if (isAlive){
            isAlive = false;
            setAnimatedView(false,
                    ShapeMatrix.KILL_ENEMY_ANIMATION_FIRST,
                    ShapeMatrix.KILL_ENEMY_ANIMATION_SECOND,
                    ShapeMatrix.KILL_ENEMY_ANIMATION_THIRD);
        }
    }
}
