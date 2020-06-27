package com.javarush.games.racer.road;

import com.javarush.engine.cell.Game;
import com.javarush.games.racer.GameObject;
import com.javarush.games.racer.PlayerCar;
import com.javarush.games.racer.RacerGame;

import java.util.ArrayList;
import java.util.List;

public class RoadManager {
    public static final int LEFT_BORDER = RacerGame.ROADSIDE_WIDTH;
    public static final int RIGHT_BORDER = RacerGame.WIDTH - LEFT_BORDER;
    private static final int FIRST_LANE_POSITION = 16;
    private static final int FOURTH_LANE_POSITION = 44;
    private List<RoadObject> items = new ArrayList<RoadObject>();

    private RoadObject createRoadObject(RoadObjectType type, int x, int y){
        RoadObject roadObject = null;
        if (type == RoadObjectType.THORN){
            roadObject = new Thorn(x, y);
        }
        return roadObject;
    }

    private void addRoadObject(RoadObjectType type, Game game){
        int x = game.getRandomNumber(FIRST_LANE_POSITION, FOURTH_LANE_POSITION);
        int y = -1 * RoadObject.getHeight(type);
        RoadObject roadObject;
        if((roadObject = createRoadObject(type, x, y)) != null){
            items.add(roadObject);
        }
    }

    public void draw(Game game){
        for (RoadObject roadObject: items){
            roadObject.draw(game);
        }
    }

    public void move(int boost){
        for (RoadObject roadObject : items){
            roadObject.move(roadObject.speed+boost);
        }
        deletePassedItems();
    }

    private boolean isThornExists(){
        for (RoadObject roadObject : items){
            if (roadObject.type == RoadObjectType.THORN){
                return true;
            }
        }
        return false;
    }

    private void generateThorn(Game game){
        int random = game.getRandomNumber(100);
        if(random < 10 && !isThornExists()){
            addRoadObject(RoadObjectType.THORN, game);
        }
    }

    public void generateNewRoadObjects(Game game){
        generateThorn(game);
    }

    private void deletePassedItems(){
        ArrayList<RoadObject> items_to_remove = new ArrayList<RoadObject>();
        for (RoadObject roadObject : items){
            if (roadObject.y >= RacerGame.HEIGHT){
                items_to_remove.add(roadObject);
            }
        }
        for (RoadObject roadObject : items_to_remove){
            items.remove(roadObject);
        }
    }

    public boolean checkCrush(PlayerCar playerCar){
        for (RoadObject roadObject : items){
            if (roadObject.isCollision(playerCar)) return true;
        }
        return false;
    }
}
