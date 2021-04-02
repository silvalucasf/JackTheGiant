package background;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import helpers.GameInfo;

public class ManagerBG {
    private Sprite[] bgs;
    private final String[] names;
    private float nextPositionX;
    private int countBG = 2;

    public ManagerBG (){
        names = new String[4];
        names [0] = "Static_Grassland.png";
        names [1] = "Static_Tropics.png";
        names [2] = "Static_AutumnForest.png";
        names [3] = "Static_WinterWorld.png";

        bgs = new Sprite[4];

        for (int i = 0; i < bgs.length; i++){
            bgs[i] = new Sprite(new Texture("BG/" + names[2]));
            bgs[i].setPosition(bgs[i].getWidth() * i, 0);
            countBG += 1;
            addCountBG();
            nextPositionX = bgs[i].getX() + bgs[i].getWidth();
        }
    }

    public void update(OrthographicCamera camera){
        if(isOutOffCam(camera, bgs[countBG])){
            bgs[countBG].setPosition(nextPositionX, 0f);
            nextPositionX = bgs[countBG].getX() + bgs[countBG].getWidth();
            addCountBG();
        }
    }

    public boolean isOutOffCam(OrthographicCamera camera, Sprite sprite){
       if ((sprite.getX() + sprite.getWidth() + (GameInfo.WIDTH / 2f)) < camera.position.x){
           return true;
       }
        return false;
    }

    public void addCountBG(){
        countBG += 1;
        if (countBG >= 3){
            countBG = 0;
        }
    }

    public void draw (SpriteBatch batch){
        for (Sprite bg : bgs) {
            batch.draw(bg, bg.getX(), bg.getY());
        }
    }
}
