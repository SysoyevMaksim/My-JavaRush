package com.javarush.games.racer;

import com.javarush.engine.cell.*;
import com.javarush.games.racer.road.RoadManager;

public class RacerGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH / 2;
    public static final int ROADSIDE_WIDTH = 14;
    private static final int RACE_GOAL_CARS_COUNT = 40;
    private RoadMarking roadMarking;
    private PlayerCar player;
    private RoadManager roadManager;
    private boolean isGameStopped;
    private FinishLine finishLine;
    private ProgressBar progressBar;
    private int score;

    @Override
    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        isGameStopped = false;
        roadMarking = new RoadMarking();
        player = new PlayerCar();
        roadManager = new RoadManager();
        finishLine = new FinishLine();
        progressBar = new ProgressBar(RACE_GOAL_CARS_COUNT);
        score = 3500;
        drawScene();
        setTurnTimer(40);
    }

    private void drawScene() {
        drawField();
        roadMarking.draw(this);
        player.draw(this);
        roadManager.draw(this);
        finishLine.draw(this);
        progressBar.draw(this);
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
        finishLine.move(player.speed);
        progressBar.move(roadManager.getPassedCarsCount());
    }

    @Override
    public void onTurn(int step) {
        score-= 5;
        setScore(score);
        if (roadManager.getPassedCarsCount() >= RACE_GOAL_CARS_COUNT){
            finishLine.show();
        }
        if (finishLine.isCrossed(player)){
            win();
        }
        else {
            if (roadManager.checkCrush(player)) {
                gameOver();
            } else {
                roadManager.generateNewRoadObjects(this);
                moveAll();
            }
        }
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (isGameStopped && key == Key.SPACE){
            createGame();
        }
        if (key == Key.LEFT){
            player.setDirection(Direction.LEFT);
        }
        if (key == Key.RIGHT){
            player.setDirection(Direction.RIGHT);
        }
        if (key == Key.UP){
            player.speed = 2;
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
        if (key == Key.UP){
            player.speed = 1;
        }
    }

    private void gameOver(){
        stopTurnTimer();
        player.stop();
        isGameStopped = true;
        showMessageDialog(Color.GREEN, "GAME OVER", Color.RED, 100);
    }

    private void win(){
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.BLUE, "YOU WIN!", Color.ORANGE, 100);
    }
}
