package com.mygdx.game;

import com.badlogic.gdx.Screen;

/**
 * Created by Besten on 2015-11-01.
 */
public class GameScreen implements Screen{

    private GameRenderer renderer;

    public GameScreen(){
        renderer = new GameRenderer();
    }

    @Override
    public void render(float delta) {
        renderer.update(delta);
        renderer.render();
    }

    @Override
    public void show() {

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
