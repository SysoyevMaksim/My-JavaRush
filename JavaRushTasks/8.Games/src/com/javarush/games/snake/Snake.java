package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<GameObject> snakeParts = new ArrayList<GameObject>();
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN  = "\u26AB";
    public Snake(int x, int y){
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x + 1, y));
        snakeParts.add(new GameObject(x + 2, y));
    }
    public void draw(Game game){
        GameObject gameObject = snakeParts.get(0);
        game.setCellValue(gameObject.x, gameObject.y, HEAD_SIGN);
        for (int i = 1; i < snakeParts.size(); i++){
            gameObject = snakeParts.get(i);
            game.setCellValue(gameObject.x, gameObject.y, BODY_SIGN);
        }
    }
}
