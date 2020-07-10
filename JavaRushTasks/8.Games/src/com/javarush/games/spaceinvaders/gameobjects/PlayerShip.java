package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.List;

public class PlayerShip extends Ship {
    private Direction direction = Direction.UP;

    public PlayerShip() {
        super(SpaceInvadersGame.WIDTH / 2.0, SpaceInvadersGame.HEIGHT - ShapeMatrix.PLAYER.length - 1);
        setStaticView(ShapeMatrix.PLAYER);
    }

    public void verifyHit(List<Bullet> bullets) {
        if (!bullets.isEmpty()) {
            if (this.isAlive) {
                for (Bullet bullet : bullets) {
                    if (bullet.isAlive) {
                        if (this.isCollision(bullet)) {
                            this.kill();
                            bullet.kill();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void kill() {
        if(this.isAlive) {
            isAlive = false;
            this.setAnimatedView(false,
                    ShapeMatrix.KILL_PLAYER_ANIMATION_FIRST,
                    ShapeMatrix.KILL_PLAYER_ANIMATION_SECOND,
                    ShapeMatrix.KILL_PLAYER_ANIMATION_THIRD,
                    ShapeMatrix.DEAD_PLAYER);
        }
    }

    public void setDirection(Direction newDirection) {
        if (newDirection != Direction.DOWN) {
            this.direction = newDirection;
        }
    }

    public void move(){
        if (isAlive){
            if (direction == Direction.LEFT){
                x--;
            }
            if (direction == Direction.RIGHT){
                x++;
            }
            if (x < 0){
                x = 0;
            }
            if (x + width > SpaceInvadersGame.WIDTH){
                x = SpaceInvadersGame.WIDTH - width;
            }
        }
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public Bullet fire() {
        if (isAlive){
            return new Bullet(x + 2, y - ShapeMatrix.BULLET.length, Direction.UP);
        } else {
            return null;
        }
    }

    public void win(){
        setStaticView(ShapeMatrix.WIN_PLAYER);
    }
}
