package com.javarush.games.spaceinvaders.gameobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.javarush.engine.cell.Game;

public class Ship extends GameObject{
    public boolean isAlive = true;
    private List<int[][]> frames;
    private int frameIndex;
    private boolean loopAnimation = false;

    public Ship(double x, double y) {
        super(x, y);
    }

    public void setStaticView(int[][] viewFrame){
        super.setMatrix(viewFrame);
        frames = new ArrayList<int[][]>();
        frames.add(viewFrame);
        frameIndex = 0;
    }

    public Bullet fire(){
        return null;
    }

    public void kill(){
        isAlive = false;
    }

    public void setAnimatedView(boolean isLoopAnimation, int[][]... viewFrames){
        loopAnimation = isLoopAnimation;
        setMatrix(viewFrames[0]);
        frames = Arrays.asList(viewFrames);
        frameIndex = 0;
    }

    public void nextFrame(){
        frameIndex++;
        if(frameIndex < frames.size() || loopAnimation){
            if (frameIndex >= frames.size()){
                frameIndex = 0;
            }
            matrix = frames.get(frameIndex);
        }
    }

    @Override
    public void draw(Game game) {
        nextFrame();
        super.draw(game);
    }

    public boolean isVisible(){
        return isAlive || frameIndex < frames.size();
    }
}
