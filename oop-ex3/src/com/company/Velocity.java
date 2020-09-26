package com.company;

public class Velocity {
    private double dx;
    private double dy;
    // constructor
    public Velocity(double dx, double dy){
        this.dx = dx;
        this.dy = dy;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    // Take a point with position (x,y) and return a new point
    // with position (x+dx, y+dy)
    public Point applyToPoint(Point p){
        double newx = p.getX() +dx;
        double newy = p.getY() +dy;
        return new Point(newx,newy);
    }
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = 1 * speed * Math.cos(Math.toRadians(angle));
        double dy = -1 * speed * Math.sin(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }
    public Point applyToPoint1(Point p, int width, int height, int radius) {
        double newx, newy, dradius = (double) radius;
        //checking if we pass the vertical walls.
        if (dx < 0 && p.getX() + dx - dradius < 0.0) {
            newx = 0.0 + dradius;
        } else if (p.getX() + dx + dradius > width) {
            newx = width - dradius;
        } else {
            newx = p.getX() + dx;
        }
        //checking if we pass the horizontal walls.
        if (dy < 0 && p.getY() + dy - dradius < 0.0) {
            newy = 0.0 + dradius;
        } else if (p.getY() + dy + dradius > height) {
            newy = height - dradius;
        } else {
            newy = p.getY() + dy;
        }
        return new Point(newx, newy);
    }

}

