package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private Snake snake;
    private int turnDelay;
    private Apple apple;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame(){
        snake = new Snake(WIDTH/2, HEIGHT/2);
        createNewApple();
        drawScene();
        turnDelay = 300;
        setTurnTimer(turnDelay);
    }

    private void drawScene(){
        for (int i = 0; i < WIDTH; i++){
            for (int j = 0; j < HEIGHT; j++){
                setCellValueEx(i, j, Color.DARKSEAGREEN, "");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    @Override
    public void onTurn(int step) {
        snake.move(apple);
        if (!apple.isAlive){
            createNewApple();
        }
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.DOWN){
            snake.setDirection(Direction.DOWN);
        }
        if (key == Key.LEFT){
            snake.setDirection(Direction.LEFT);
        }
        if (key == Key.RIGHT){
            snake.setDirection(Direction.RIGHT);
        }
        if (key == Key.UP){
            snake.setDirection(Direction.UP);
        }
    }

    private void createNewApple(){
        int x = getRandomNumber(WIDTH);
        int y = getRandomNumber(HEIGHT);
        apple = new Apple(x, y);
    }
}
