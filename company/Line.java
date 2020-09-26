package com.company;
// line class
public class Line {
    private Point start;
    private Point end;
    private double m;
    private double b;
    public Line(Point start, Point end) {
        this.start = start;
        this.end= end;
        this.m = (end.getY() - start.getY())/(end.getX() -start.getX());
        this.b = start.getY() - this.m * start.getX();
    }
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1,y1);
        this.end = new Point(x2,y2);
        this.m = (y2-y1)/(x2-x1);
        this.b = y1 -this.m*x1;
    }

    // Return the length of the line
    public double length() {
        return start.distance(end);
    }

    // Returns the middle point of the line
    public Point middle() {
        double newx = (this.start.getX() + this.end.getX())/2;
        double newy = (this.start.getY() + this.end.getY())/2;
        return new Point(newx,newy);
    }

    // Returns the start point of the line
    public Point start() {
        return  this.start;
    }

    // Returns the end point of the line
    public Point end() {
        return this.end;
    }

    // Returns true if the lines intersect, false otherwise
    public boolean isIntersecting(Line other) {
         Point p= this.intersectionWith(other);
         if(p == null){
             return false;
         }
         return true;
    }

    // Returns the intersection point if the lines intersect,
    // and null otherwise.
    public Point intersectionWith(Line other) {
        double d = this.m - other.m;
        if(d ==0){
            return null;
        }
        double e = other.b - this.b;
        double newx = e/d;
        double newy = this.m *newx +this.b;
        Point output = new Point(newx,newy);
        if(!this.pointFindOnLine(output)||!other.pointFindOnLine(output)){
            return null;
        }
        return output;
    }

    // equals -- return true is the lines are equal, false otherwise
    public boolean equals(Line other) {
        if(this.start.equals(other.start) && this.end.equals(other.end)){
            return true;
        }
        return false;
    }

    public boolean pointFindOnLine(Point check) {
        if ((this.start.getX() <= check.getX() && check.getX() <= this.end.getX())
                || (this.start.getX() >= check.getX() && check.getX() >= this.end.getX())) {
            if (((this.start.getY() <= check.getY() && check.getY() <= this.end.getY())
                    || (this.start.getY() >= check.getY() && check.getY() >= this.end.getY()))) {
                return true;
            }
        }
        return false;
    }

}
