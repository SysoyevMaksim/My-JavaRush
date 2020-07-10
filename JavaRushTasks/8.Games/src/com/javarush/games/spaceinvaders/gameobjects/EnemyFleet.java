package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.List;

public class EnemyFleet {
    protected static final int ROWS_COUNT = 3;
    protected static final int COLUMNS_COUNT = 10;
    protected static final int STEP = ShapeMatrix.ENEMY.length + 1;
    protected List<EnemyShip> ships;
    protected Direction direction = Direction.RIGHT;

    public EnemyFleet() {
        createShips();
    }

    protected void createShips() {
        ships = new ArrayList<EnemyShip>();
        for (int x = 0; x < COLUMNS_COUNT; x++) {
            for (int y = 0; y < ROWS_COUNT; y++) {
                ships.add(new EnemyShip(x * STEP, y * STEP + 12));
            }
        }
        ships.add(new Boss(STEP * COLUMNS_COUNT / 2 - ShapeMatrix.BOSS_ANIMATION_FIRST.length / 2 - 1, 5));
    }

    public void draw(Game game) {
        for (EnemyShip enemyShip : ships) {
            enemyShip.draw(game);
        }
    }

    protected double getLeftBorder() {
        double min = -1;
        for (EnemyShip enemyShip : ships) {
            if (enemyShip.x < min || min == -1) {
                min = enemyShip.x;
            }
        }
        return min;
    }

    protected double getRightBorder() {
        double max = 0;
        for (EnemyShip enemyShip : ships) {
            if (enemyShip.x + enemyShip.width > max) {
                max = enemyShip.x + enemyShip.width;
            }
        }
        return max;
    }

    protected double getSpeed() {
        return Math.min(1.5, (2.0 / ships.size()));
    }

    public void move() {
        if (ships.size() > 0) {
            if (direction == Direction.LEFT && getLeftBorder() < 0) {
                direction = Direction.RIGHT;
                for (EnemyShip enemyShip : ships) {
                    enemyShip.move(Direction.DOWN, getSpeed());
                }
            } else if (direction == Direction.RIGHT && getRightBorder() > SpaceInvadersGame.WIDTH) {
                direction = Direction.LEFT;
                for (EnemyShip enemyShip : ships) {
                    enemyShip.move(Direction.DOWN, getSpeed());
                }
            } else {
                for (EnemyShip enemyShip : ships) {
                    enemyShip.move(direction, getSpeed());
                }
            }
        }
    }

    public Bullet fire(Game game) {
        if (ships.size() == 0) {
            return null;
        }
        if (game.getRandomNumber(100 / SpaceInvadersGame.COMPLEXITY) > 0) {
            return null;
        }
        return ships.get(game.getRandomNumber(ships.size())).fire();
    }

    public int verifyHit(List<Bullet> bullets) {
        if (bullets.isEmpty()) return 0;
        else {
            int score = 0;
            for (EnemyShip enemyShip : ships) {
                for (Bullet bullet : bullets) {
                    if (enemyShip.isCollision(bullet)) {
                        if (bullet.isAlive && enemyShip.isAlive) {
                            score += enemyShip.score;
                            bullet.kill();
                            enemyShip.kill();
                        }
                    }
                }
            }
            return score;
        }
    }

    public void deleteHiddenShips() {
        ArrayList<EnemyShip> wrong = new ArrayList<EnemyShip>();
        for (EnemyShip enemyShip : ships) {
            if (!enemyShip.isVisible()) {
                wrong.add(enemyShip);
            }
        }
        for (EnemyShip enemyShip : wrong) {
            ships.remove(enemyShip);
        }
    }

    public double getBottomBorder() {
        double max = 0;
        for (EnemyShip ship : ships) {
            if (ship.y + ship.height > max) {
                max = ship.y + ship.height;
            }
        }
        return max;
    }

    public int getShipsCount() {
        return ships.size();
    }
}
