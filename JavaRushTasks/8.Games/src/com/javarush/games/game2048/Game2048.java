package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

import java.util.Arrays;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                setCellColoredNumber(x, y, gameField[y][x]);
            }
        }
    }

    private void createNewNumber() {
        if (getMaxTileValue() == 2048){
            win();
        }
        int x = getRandomNumber(SIDE);
        int y = getRandomNumber(SIDE);
        while (gameField[y][x] != 0) {
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        }
        if (getRandomNumber(10) == 9) {
            gameField[y][x] = 4;
        } else {
            gameField[y][x] = 2;
        }
    }

    private Color getColorByValue(int value) {
        if (value == 0) {
            return Color.WHITE;
        }
        if (value == 2) {
            return Color.LIGHTPINK;
        }
        if (value == 4) {
            return Color.PURPLE;
        }
        if (value == 8) {
            return Color.BLUE;
        }
        if (value == 16) {
            return Color.CYAN;
        }
        if (value == 32) {
            return Color.GREEN;
        }
        if (value == 64) {
            return Color.LIGHTGREEN;
        }
        if (value == 128) {
            return Color.ORANGE;
        }
        if (value == 256) {
            return Color.RED;
        }
        if (value == 512) {
            return Color.DARKORANGE;
        }
        if (value == 1024) {
            return Color.MAGENTA;
        }
        return Color.DARKMAGENTA;
    }

    private void setCellColoredNumber(int x, int y, int value) {
        Color color = getColorByValue(value);
        String s = "";
        if (value != 0) {
            s += value;
        }
        setCellValueEx(x, y, color, s);
    }

    private boolean compressRow(int[] row) {
        boolean a = false;
        boolean b = true;
        while (b) {
            b = false;
            for (int i = 0; i < row.length - 1; i++) {
                if (row[i] == 0 && row[i + 1] != 0) {
                    row[i] = row[i + 1];
                    row[i + 1] = 0;
                    a = true;
                    b = true;
                }
            }
        }
        return a;
    }

    private boolean mergeRow(int[] row) {
        boolean a = false;
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] == row[i + 1] && row[i] != 0) {
                row[i] = row[i + 1] * 2;
                row[i + 1] = 0;
                a = true;
            }
        }
        return a;
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.DOWN) {
            moveDown();
            drawScene();
        }
        if (key == Key.LEFT) {
            moveLeft();
            drawScene();
        }
        if (key == Key.RIGHT) {
            moveRight();
            drawScene();
        }
        if (key == Key.UP) {
            moveUp();
            drawScene();
        }
    }

    private void moveLeft() {
        boolean d = false;
        for (int x = 0; x < SIDE; x++) {
            boolean a = compressRow(gameField[x]);
            boolean b = mergeRow(gameField[x]);
            boolean c = compressRow(gameField[x]);
            if (a || b || c){
                d = true;
            }
        }
        if (d){
            createNewNumber();
        }
    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void rotateClockwise(){
        int[][] gameFieldCopy = new int[SIDE][SIDE];
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                gameFieldCopy[x][y] = gameField[x][y];
            }
        }
        for (int x = 0; x < SIDE; x++){
            for (int y = 0; y < SIDE; y++){
                gameField[y] [SIDE - x - 1] = gameFieldCopy[x][y];
            }
        }
    }

    private int getMaxTileValue(){
        int max = 0;
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                if (gameField[x][y] > max){
                    max = gameField[x][y];
                }
            }
        }
        return max;
    }

    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.BLUE,"YOU WIN!", Color.ORANGE, 100);
    }
}
