package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.*;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int COMPLEXITY = 5;
    private List<Star> stars;
    private EnemyFleet enemyFleet;
    private List<Bullet> enemyBullets;
    private PlayerShip playerShip;
    private boolean isGameStopped;
    private int animationsCount;
    private List<Bullet> playerBullets;
    private static int PLAYER_BULLETS_MAX;
    private int score;
    private int levelCount;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        isGameStopped = false;
        animationsCount = 0;
        enemyFleet = new EnemyFleet();
        enemyBullets = new ArrayList<Bullet>();
        playerBullets = new ArrayList<Bullet>();
        playerShip = new PlayerShip();
        PLAYER_BULLETS_MAX = 3;
        createStars();
        drawScene();
        setTurnTimer(40);
        score = 0;
        levelCount = 1;
    }

    private void createGame2() {
        isGameStopped = false;
        animationsCount = 0;
        enemyFleet = new EnemyFleet2();
        enemyBullets = new ArrayList<Bullet>();
        playerBullets = new ArrayList<Bullet>();
        playerShip = new PlayerShip();
        PLAYER_BULLETS_MAX = 2;
        createStars();
        drawScene();
        setTurnTimer(40);
        levelCount = 2;
    }

    private void createGame3() {
        isGameStopped = false;
        animationsCount = 0;
        enemyFleet = new EnemyFleet3();
        enemyBullets = new ArrayList<Bullet>();
        playerBullets = new ArrayList<Bullet>();
        playerShip = new PlayerShip();
        PLAYER_BULLETS_MAX = 1;
        createStars();
        drawScene();
        setTurnTimer(40);
        levelCount++;
    }

    private void drawScene() {
        drawField();
        enemyFleet.draw(this);
        for (Bullet bullet : enemyBullets) {
            bullet.draw(this);
        }
        for (Bullet bullet : playerBullets) {
            bullet.draw(this);
        }
        playerShip.draw(this);
    }

    private void drawField() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x, y, Color.BLACK, "");
            }
        }
        for (Star star : stars) {
            star.draw(this);
        }
    }

    private void createStars() {
        stars = new ArrayList<Star>();
        stars.add(new Star(1, 1));
        stars.add(new Star(32, 32));
        stars.add(new Star(7, 56));
        stars.add(new Star(46, 46));
        stars.add(new Star(25, 36));
        stars.add(new Star(54, 8));
        stars.add(new Star(9, 46));
        stars.add(new Star(23, 23));
    }

    @Override
    public void onTurn(int step) {
        moveSpaceObjects();
        Bullet bullet = enemyFleet.fire(this);
        if (bullet != null) {
            enemyBullets.add(bullet);
        }
        check();
        setScore(score);
        drawScene();
    }

    private void moveSpaceObjects() {
        enemyFleet.move();
        for (Bullet bullet : enemyBullets) {
            bullet.move();
        }
        for (Bullet bullet : playerBullets) {
            bullet.move();
        }
        playerShip.move();
    }

    private void removeDeadBullets() {
        ArrayList<Bullet> wrong = new ArrayList<Bullet>();
        for (Bullet bullet : enemyBullets) {
            if (bullet.y >= HEIGHT - 1 || !bullet.isAlive) {
                wrong.add(bullet);
            }
        }
        for (Bullet bullet : wrong) {
            enemyBullets.remove(bullet);
        }
        ArrayList<Bullet> wrong2 = new ArrayList<Bullet>();
        for (Bullet bullet : playerBullets) {
            if (bullet.y + bullet.height < 0|| !bullet.isAlive) {
                wrong2.add(bullet);
            }
        }
        for (Bullet bullet : wrong2) {
            playerBullets.remove(bullet);
        }
    }

    private void check() {
        playerShip.verifyHit(enemyBullets);
        score += enemyFleet.verifyHit(playerBullets);
        enemyFleet.deleteHiddenShips();
        if (enemyFleet.getBottomBorder() >= playerShip.y){
            playerShip.kill();
        }
        if (enemyFleet.getShipsCount() == 0){
            playerShip.win();
            stopGameWithDelay();
        }
        if (!playerShip.isAlive){
            stopGameWithDelay();
        }
        removeDeadBullets();
    }

    private void stopGame(boolean isWin){
        isGameStopped = true;
        stopTurnTimer();
        if (isWin){
            //showMessageDialog(Color.WHITE, "YOU WIN", Color.GREEN, 100);
            if (levelCount == 1){
                createGame2();
            } else {
                createGame3();
            }
        } else {
            showMessageDialog(Color.WHITE, "GAME OVER. YOU PASS " + (levelCount - 1) + " LEVELS" , Color.RED, 45);
        }
    }

    private void stopGameWithDelay(){
        animationsCount++;
        if (animationsCount >= 10){
            stopGame(playerShip.isAlive);
        }
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.SPACE && isGameStopped){
            createGame();
        } else {
            if (key == Key.SPACE){
                Bullet bullet = playerShip.fire();
                if (bullet != null && playerBullets.size() < PLAYER_BULLETS_MAX){
                    playerBullets.add(bullet);
                }
            }
            if (key == Key.LEFT){
                playerShip.setDirection(Direction.LEFT);
            }
            if (key == Key.RIGHT){
                playerShip.setDirection(Direction.RIGHT);
            }
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.LEFT && playerShip.getDirection() == Direction.LEFT){
            playerShip.setDirection(Direction.UP);
        }
        if (key == Key.RIGHT && playerShip.getDirection() == Direction.RIGHT){
            playerShip.setDirection(Direction.UP);
        }
    }

    @Override
    public void setCellValueEx(int x, int y, Color cellColor, String value) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT){
            super.setCellValueEx(x, y, cellColor, value);
        }
    }
}
