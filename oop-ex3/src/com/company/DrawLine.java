package com.company;
import biuoop.DrawSurface;
import biuoop.GUI;
import java.awt.*;
import java.util.Random;



public class DrawLine {

    public void drawRandomliness() {
        GUI gui = new GUI("Random Circles Example", 400, 300);
        DrawSurface d = gui.getDrawSurface();
        Line[] lines = new Line[10];
        for (int i = 0; i < 10; ++i) {
            lines[i]=generateRandomLine();
            drawLine(lines[i],d);
        }
        drawintersection(lines,d);
        gui.show(d);
    }

   public Line generateRandomLine(){
       Random rand = new Random();
       int x1 = rand.nextInt(400) + 1; // get integer in range 1-400
       int y1 = rand.nextInt(300) + 1; // get integer in range 1-300
       int x2 = rand.nextInt(400) + 1; // get integer in range 1-400
       int y2 = rand.nextInt(300) + 1; // get integer in range 1-300
       return new Line(x1,y1,x2,y2);
   }
    public void drawLine(Line l, DrawSurface d){
        d.setColor(Color.BLACK);
        d.drawLine((int)l.start().getX(),(int)l.start().getY(),(int)l.end().getX(),(int)l.end().getY());
        d.setColor(Color.BLUE);
        Point p =l.middle();
        d.fillRectangle((int)p.getX()-2,(int)p.getY(),5,5);
    }

    public void drawintersection(Line[] lines,DrawSurface d){
        d.setColor(Color.RED);
        for(int i=0;i< lines.length;i++){
            for(int j=0;j< lines.length;j++){
                if(i!=j){
                    if(lines[i].isIntersecting(lines[j])){
                        Point p = lines[i].intersectionWith(lines[j]);
                        d.fillRectangle((int)p.getX(),(int)p.getY(),5,5);
                    }
                }
            }
        }
    }




}
