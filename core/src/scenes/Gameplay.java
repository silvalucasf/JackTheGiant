package scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.projects.jackthegiant.GameMain;

import background.ManagerBG;
import helpers.GameInfo;

public class Gameplay implements Screen {
    private GameMain game;
    private OrthographicCamera mainCamera;
    private Viewport gameViewport;
    private ManagerBG managerBG;

    public Gameplay (GameMain game){
        this.game = game;

        mainCamera = new OrthographicCamera(GameInfo.WIDTH, GameInfo.HEIGHT);
        mainCamera.position.set(GameInfo.WIDTH / 2f, GameInfo.HEIGHT / 2f, 0f);

        gameViewport = new StretchViewport(GameInfo.WIDTH, GameInfo.HEIGHT, mainCamera);

        managerBG = new ManagerBG();
    }

    void update (float dt){
        moveCamera();
        managerBG.update(mainCamera);
    }

    void moveCamera(){
        mainCamera.position.x += 1;
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(1,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        game.getBatch().begin();
        managerBG.draw(game.getBatch());
        game.getBatch().end();

        game.getBatch().setProjectionMatrix(mainCamera.combined);

        mainCamera.update();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
