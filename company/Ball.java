package com.company;

import biuoop.DrawSurface;

import java.awt.*;

public class Ball {
    private int radius;
    private Color color;
    private Point center;
    private Velocity velocity;
    // constractor to ball class.
    public Ball(Point center, int r, java.awt.Color color){
        this.center = center;
        this.radius =r;
        this.color =color;
    }
    public Ball(int x , int y, int r, java.awt.Color color){
        this.center = new Point(x,y);
        this.radius =r;
        this.color =color;
    }

    // accessors
    public int getX(){
        return (int)center.getX();
    }
    public int getY(){
        return (int)center.getY();
    }
    public int getSize(){
        return  radius;
    }
    public java.awt.Color getColor(){
        return color;
    }

    // draw the ball on the given DrawSurface
    public void drawOn(DrawSurface surface){
        surface.setColor(color);
        surface.fillCircle((int)center.getX(),(int)center.getY(),radius);
    }

    public void setVelocity(Velocity v){
        this.velocity =v;
    }
    public void setVelocity(double dx, double dy){
        this.velocity = new Velocity(dx, dy);
    }
    public Velocity getVelocity(){
        return this.velocity;
    }

    public void moveOneStep(DrawSurface surface) {
        int height = surface.getHeight();
        int width = surface.getWidth();
        int zeroX = (int) 0;
        int zeroY = (int) 0;

        //checking if we hit the side walls.
        if (center.getX() + radius >= width || center.getX() - radius <= zeroX) {
            setVelocity(-1 * velocity.getDx(), velocity.getDy());
        }

        //checking if we hit the horizontal walls.
        if (center.getY() + radius >= height || center.getY() - radius <= zeroY) {
            setVelocity(velocity.getDx(), -1 * velocity.getDy());
        }
        //appling the velocity.
        this.center = this.getVelocity().applyToPoint1(this.center, width, height, radius);
    }

}
