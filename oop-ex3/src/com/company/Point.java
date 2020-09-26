package com.company;

public class Point {
    private  double x;
    private double y;
    // constructor
    public Point(double x, double y) {
        this.x=x;
        this.y=y;
    }

    // distance -- return the distance of this point to the other point
    public double distance(Point other) {
        double y1 = other.getY();
        double x1 = other.getX();
        return Math.sqrt((y - y1) * (y - y1) + (x - x1) * (x - x1));
    }

    // equals -- return true is the points are equal, false otherwise
    public boolean equals(Point other) {
        if(this.x == other.getX() && this.y== other.getY()){
            return true;
        }
        return false;
    }

    // Return the x and y values of this point
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
}
