package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    public boolean isAlive = true;
    private List<GameObject> snakeParts = new ArrayList<GameObject>();
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    private Direction direction = Direction.LEFT;

    public void setDirection(Direction direction) {
        if (!(this.direction == Direction.LEFT && snakeParts.get(0).x == snakeParts.get(1).x) &&
                !(this.direction == Direction.RIGHT && snakeParts.get(0).x == snakeParts.get(1).x) &&
                !(this.direction == Direction.UP && snakeParts.get(0).y == snakeParts.get(1).y) &&
                !(this.direction == Direction.DOWN && snakeParts.get(0).y == snakeParts.get(1).y)) {
            if ((direction == Direction.DOWN && this.direction != Direction.UP) ||
                    (direction == Direction.UP && this.direction != Direction.DOWN) ||
                    (direction == Direction.RIGHT && this.direction != Direction.LEFT) ||
                    (direction == Direction.LEFT && this.direction != Direction.RIGHT)) {
                this.direction = direction;
            }
        }
    }

    public Snake(int x, int y) {
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x + 1, y));
        snakeParts.add(new GameObject(x + 2, y));
    }

    public void draw(Game game) {
        Color color;
        if (isAlive) {
            color = Color.BLACK;
        } else {
            color = Color.RED;
        }
        GameObject gameObject = snakeParts.get(0);
        game.setCellValueEx(gameObject.x, gameObject.y, Color.NONE, HEAD_SIGN, color, 75);
        for (int i = 1; i < snakeParts.size(); i++) {
            gameObject = snakeParts.get(i);
            game.setCellValueEx(gameObject.x, gameObject.y, Color.NONE, BODY_SIGN, color, 75);
        }
    }

    public void move(Apple apple) {
        GameObject Head = createNewHead();
        if (Head.x < 0)  {
            Head.x = SnakeGame.WIDTH - 1;
        }
        if (Head.x >= SnakeGame.WIDTH) {
            Head.x = 0;
        }
        if (Head.y < 0) {
            Head.y = SnakeGame.HEIGHT - 1;
        }
        if (Head.y >= SnakeGame.HEIGHT){
            Head.y = 0;
        }
        if (checkCollision(Head)) {
            isAlive = false;
            return;
        }
        snakeParts.add(0, Head);
        if (Head.x == apple.x && Head.y == apple.y) {
            apple.isAlive = false;
        } else {
            removeTail();
        }
    }

    public GameObject createNewHead() {
        GameObject oldHead = snakeParts.get(0);
        int x = 0, y = 0;
        if (direction == Direction.DOWN) {
            x = oldHead.x;
            y = oldHead.y + 1;
        }
        if (direction == Direction.LEFT) {
            x = oldHead.x - 1;
            y = oldHead.y;
        }
        if (direction == Direction.RIGHT) {
            x = oldHead.x + 1;
            y = oldHead.y;
        }
        if (direction == Direction.UP) {
            x = oldHead.x;
            y = oldHead.y - 1;
        }
        return new GameObject(x, y);
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }

    public boolean checkCollision(GameObject gameObject) {
        for (GameObject gameObject1 : snakeParts) {
            if (gameObject.y == gameObject1.y && gameObject.x == gameObject1.x) {
                return true;
            }
        }
        return false;
    }

    public int getLength() {
        return snakeParts.size();
    }

}
