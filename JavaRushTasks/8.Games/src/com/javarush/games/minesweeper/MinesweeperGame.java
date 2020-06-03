package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countFlags;
    private boolean isGameStopped = true;
    private int countClosedTiles = SIDE * SIDE;
    private int score = 0;
    private int xl = 0 , yl = 0, xr = 0, yr = 0;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                setCellValue(x, y, "");
                setCellColor(x, y, Color.ORANGE);
            }
        }
    }

    private void createGame(int x1, int y1) {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                if (x1 == x && y1 == y) {
                    gameField[y][x] = new GameObject(x, y, false);
                } else {
                    boolean isMine = getRandomNumber(10) < 1;
                    if (isMine) {
                        countMinesOnField++;
                    }
                    gameField[y][x] = new GameObject(x, y, isMine);
                }
                gameField[y][x].isFlag = false;
                gameField[y][x].isOpen = false;
                setCellValue(x, y, "");
                setCellColor(x, y, Color.ORANGE);
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void countMineNeighbors() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                if (!gameField[x][y].isMine) {
                    List<GameObject> result = getNeighbors(gameField[x][y]);
                    for (GameObject gameObject : result) {
                        if (gameObject.isMine) {
                            gameField[x][y].countMineNeighbors++;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped) {
            restart(x, y);
        }
        openTile(x, y);
        xl = x;
        yl = y;
        setTurnTimer(1);
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
        xr = x;
        yr = y;
        setTurnTimer(1);
    }

    private void openTile(int x, int y) {
        if (!gameField[y][x].isOpen && !isGameStopped && !gameField[y][x].isFlag) {
            gameField[y][x].isOpen = true;
            setCellColor(x, y, Color.GREEN);
            countClosedTiles--;
            if (gameField[y][x].isMine) {
                setCellValueEx(x, y, Color.RED, MINE);
                gameOver();
            } else {
                score += 5;
                setScore(score);
                if (gameField[y][x].countMineNeighbors != 0) {
                    setCellNumber(x, y, gameField[y][x].countMineNeighbors);
                    gameField[y][x].isOpen = true;
                    setCellColor(x, y, Color.GREEN);
                } else {
                    setCellValue(x, y, "");
                    List<GameObject> result = getNeighbors(gameField[y][x]);
                    for (GameObject gameObject : result) {
                        openTile(gameObject.x, gameObject.y);
                    }
                }
                if (countClosedTiles == countMinesOnField) {
                    win();
                }
            }
        }
    }

    private void markTile(int x, int y) {
        if (!gameField[y][x].isOpen && !(!gameField[y][x].isFlag && countFlags == 0) && !isGameStopped) {
            if (gameField[y][x].isFlag) {
                countFlags++;
                gameField[y][x].isFlag = false;
                setCellValue(x, y, "");
                setCellColor(x, y, Color.ORANGE);
                List<GameObject> result = getNeighbors(gameField[y][x]);
                for (GameObject gameObject : result) {
                    gameObject.countFlagNeighbors--;
                }
            } else {
                countFlags--;
                gameField[y][x].isFlag = true;
                setCellValue(x, y, FLAG);
                setCellColor(x, y, Color.YELLOW);
                List<GameObject> result = getNeighbors(gameField[y][x]);
                for (GameObject gameObject : result) {
                    gameObject.countFlagNeighbors++;
                }
            }
        }
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.GREEN, "Game over", Color.RED, 100);
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.BLUE, "You win!", Color.ORANGE, 100);
    }

    private void restart(int x, int y) {
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        countMinesOnField = 0;
        score = 0;
        setScore(0);
        createGame(x, y);
    }

    @Override
    public void onTurn(int step) {
        if(step == 600) {
            yl = 0;
            yr = 0;
            xl = 0;
            xr = 0;
            stopTurnTimer();
        }
        if (yl == yr && yr != 0 && xl == xr && xr != 0) {
            SuperMine(xl, yl);
            yl = 0;
            yr = 0;
            xl = 0;
            xr = 0;

        }
    }

    public void SuperMine(int x, int y){
        //System.out.println(gameField[y][x].countFlagNeighbors + " " + gameField[y][x].countMineNeighbors);
        if (gameField[y][x].countFlagNeighbors == gameField[y][x].countMineNeighbors){
            List<GameObject> result = getNeighbors(gameField[x][y]);
            for (GameObject gameObject : result) {
                openTile(gameObject.y, gameObject.x);
            }
        }
    }
}