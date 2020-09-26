package com.company;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.awt.*;
import java.util.Random;

//multiple bouncing balls animation class.
public class MultipleBouncingBallsAnimation {

    //this function is going to sort our array of balls by the radius size.
    public static void sort(Ball[] balls){
        for(int i=0;i< balls.length;i++){
            for(int j=0;j< balls.length;j++){
                if(i!=j){
                    Ball b1 = balls[i];
                    Ball b2 = balls[j];
                    Ball temp;
                    //swap
                    if(b1.getSize()> b2.getSize()){
                        temp = balls[i];
                        balls[i] = balls[j];
                        balls[j]= temp;
                    }
                }
            }
        }

    }

    public static void main(String [] args){
        Random rand = new Random();
        Sleeper sleeper = new Sleeper();
        GUI gui = new GUI("Random Circles Example", 400, 300);
        DrawSurface d = gui.getDrawSurface();
        Ball[] balls = new Ball[args.length];
        for(int i=0;i< args.length;i++){
            int x = rand.nextInt(d.getWidth()) + 1; // get integer in range 1-400
            int y = rand.nextInt(d.getHeight()) + 1; // get integer in range 1-300
            balls[i] = new Ball(x,y,Integer.parseInt(args[i]), Color.RED);
            Velocity v = Velocity.fromAngleAndSpeed(30, 4);
            balls[i].setVelocity(v);
        }
        sort(balls);
        for(int i= balls.length-1;i>=0;i--){
            Velocity v = Velocity.fromAngleAndSpeed(30, i+2);
            balls[i].setVelocity(v);
        }

        while (true) {
            d = gui.getDrawSurface();
            for(int i=0;i< balls.length;i++){
                balls[i].moveOneStep(d);
                balls[i].drawOn(d);
            }

            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}
