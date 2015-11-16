package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

/**
 * Created by Besten on 2015-11-01.
 */
public class RedBalls {

    double x;
    double y;
    double vx = 4;
    double vy = 4;
    int radius = 10;

    RedBalls(int x0, int y0){
        x = x0;
        y = y0;
    }

    public void paintBalls(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle((int)x, (int)y, radius);
    }

    public void runBalls(Random random) {
        x += vx;
        y += vy;

        if(x > 1920 - radius || x < 0){
            vx = -vx/1.5;
        }
        if(y > 1080 - radius || y < 0){
            vy = -vy/1.5;
        }

        if(x > 1920 - radius){
            x = 1920 - radius;
        }
        if(x < 0){
            x = 0;
        }
        if(y > 1080 - radius){
            y = 1080 - radius;
        }
        if(y < 0){
            y = 0;
        }
    }
}
