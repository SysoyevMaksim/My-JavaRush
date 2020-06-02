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
    private boolean isGameStopped;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
        isGameStopped = false;
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
        openTile(x, y);
    }

    @Override
    public void onMouseRightClick(int x, int y) { markTile(x, y); }

    private void openTile(int x, int y) {
        if (!gameField[y][x].isOpen && !isGameStopped) {
            gameField[y][x].isOpen = true;
            setCellColor(x, y, Color.GREEN);
            if (gameField[y][x].isMine) {
                setCellValueEx(x, y, Color.RED , MINE);
                gameOver();
            } else {
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
            }
        }
    }

    private void markTile(int x, int y) {
        if (!gameField[y][x].isOpen && !(!gameField[y][x].isFlag && countFlags == 0) && !isGameStopped) {
            if (gameField[x][y].isFlag) {
                countFlags++;
                gameField[y][x].isFlag = false;
                setCellValue(x, y, "");
                setCellColor(x, y, Color.ORANGE);
            } else {
                countFlags--;
                gameField[x][y].isFlag = true;
                setCellValue(x, y, FLAG);
                setCellColor(x, y, Color.YELLOW);
            }
        }
    }
    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.GREEN, "Game over", Color.RED, 100);
    }
}