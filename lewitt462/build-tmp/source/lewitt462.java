import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class lewitt462 extends PApplet {
  public void setup() {
/**
 * @author: @fabiantheblind
 * @license: MIT
 *
 * written for "Eingabe, Ausgabe. Grundlagen der prozessorientierten Gestaltung"
 * @FHP WS 2013/2014 by Moika Hoinkis
 *
 * create works of Sol LeWitt in Processing
 * http://www.massmoca.org/lewitt/grid.php
 */
size(800,450); // canvas size

int x = PApplet.parseInt(random(width));
int y = PApplet.parseInt(random(height));

Boolean black = true;
int numberOfCircles = 30;
float radius = 2*width;
float decr = radius / numberOfCircles;

noStroke();
for(int i = 0; i < numberOfCircles;i++){
  if(black == true){
  fill(0);
  }else{
  fill(255);
  }
  ellipse(x,y,radius,radius);
  radius = radius - decr;
  println(radius + " " + black);
  if(i%2 == 0){
  black = false;
  }else{
  black = true;
  } 
}
    noLoop();
  }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "lewitt462" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
