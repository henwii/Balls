package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Besten on 2015-11-01.
 */
public class GameRenderer {

    ArrayList<RedBalls> list = new ArrayList<RedBalls>();
    ArrayList<GreenBalls> list2 = new ArrayList<GreenBalls>();
    ArrayList<BlueBalls> list3 = new ArrayList<BlueBalls>();
    ArrayList<YellowBalls> list4 = new ArrayList<YellowBalls>();

    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    private int x = 940;
    private int y = 100;
    private int radius = 50;
    private double vx = 0;
    private double vy = 2;

    private int red = 255;
    private int green = 255;
    private int blue = 255;

    private int m = 50;

    private boolean Increasing = true;

    Random random = new Random();


    public GameRenderer(){
        cam = new OrthographicCamera();
        cam.setToOrtho(true,1920,1080);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        for (int i = 10; i < 500; i+= m){
            for(int j = 10; j < 500; j += m){
                list.add(new RedBalls(i,j));
            }
        }
        for (int i = 1400; i < 1900; i+= m){
            for(int j = 10; j < 500; j += m){
                list2.add(new GreenBalls(i,j));
            }
        }
        for (int i = 10; i < 500; i+= m){
            for(int j = 560; j < 1050; j += m){
                list3.add(new BlueBalls(i,j));
            }
        }
        for (int i = 1400; i < 1900; i+= m){
            for(int j = 560; j < 1050; j += m){
                list4.add(new YellowBalls(i,j));
            }
        }
    }

    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(red, green, blue, red);
        shapeRenderer.circle(x, y, radius);
        for(RedBalls ball:list){
            ball.paintBalls(shapeRenderer);
        }
        for(GreenBalls ball:list2){
            ball.paintBalls(shapeRenderer);
        }
        for(BlueBalls ball:list3){
            ball.paintBalls(shapeRenderer);
        }
        for(YellowBalls ball:list4){
            ball.paintBalls(shapeRenderer);
        }
        shapeRenderer.end();
    }

    public void update(float delta) {

        x += vx;
        y += vy;

        for(RedBalls ball:list){
            ball.runBalls(random);
        }
        for(GreenBalls ball:list2){
            ball.runBalls(random);
        }
        for(BlueBalls ball:list3){
            ball.runBalls(random);
        }
        for(YellowBalls ball:list4){
            ball.runBalls(random);
        }

        if(x > 1920 - radius || x < 0 + radius){
            vx = -vx;
            Increasing = true;
            //radius = 20+random.nextInt(100);
        }
        if(y > 1080 - radius || y < 0 + radius){
            vy = -vy;
            Increasing = false;
            //radius = 20 + random.nextInt(100);
        }

        if(x > 1920 - radius){
            x = 1920 - radius;
        }
        if(x < 0 + radius){
            x = 0 + radius;
        }
        if(y > 1080 - radius){
            y = 1080 - radius;
        }
        if(y < 0 + radius){
            y = 0 + radius;
        }
        if(Increasing == true){
            radius ++;
        }else{
            radius --;
        }
        if(radius < 1){
            Increasing = true;
        }
        if(radius > 200){
            radius--;
            Increasing = false;
        }
    }
}
