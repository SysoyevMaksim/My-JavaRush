package com.javarush.games.racer;

import com.javarush.engine.cell.*;
import com.javarush.games.racer.road.RoadManager;

public class RacerGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH / 2;
    public static final int ROADSIDE_WIDTH = 14;
    private RoadMarking roadMarking;
    private PlayerCar player;
    private RoadManager roadManager;

    @Override
    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        roadMarking = new RoadMarking();
        player = new PlayerCar();
        roadManager = new RoadManager();
        drawScene();
        setTurnTimer(40);
    }

    private void drawScene() {
        drawField();
        roadMarking.draw(this);
        player.draw(this);
        roadManager.draw(this);
    }

    private void drawField() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < ROADSIDE_WIDTH; x++) {
                setCellColor(x, y, Color.GREEN);
            }
            for (int x = WIDTH - ROADSIDE_WIDTH; x < WIDTH; x++) {
                setCellColor(x, y, Color.GREEN);
            }
            for (int x = ROADSIDE_WIDTH; x < WIDTH - ROADSIDE_WIDTH; x++) {
                setCellColor(x, y, Color.GRAY);
            }
            setCellColor(CENTER_X, y, Color.WHITE);
        }
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) {
            super.setCellColor(x, y, color);
        }
    }

    private void moveAll(){
        roadMarking.move(player.speed);
        player.move();
        roadManager.move(player.speed);
    }

    @Override
    public void onTurn(int step) {
        roadManager.generateNewRoadObjects(this);
        moveAll();
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.LEFT){
            player.setDirection(Direction.LEFT);
        }
        if (key == Key.RIGHT){
            player.setDirection(Direction.RIGHT);
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.LEFT && player.getDirection() == Direction.LEFT){
            player.setDirection(Direction.NONE);
        }
        if (key == Key.RIGHT && player.getDirection() == Direction.RIGHT){
            player.setDirection(Direction.NONE);
        }
    }
}
