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

public class lewitt01 extends PApplet {
  public void setup() {
int hueoffset = 50; //the offset of the hue from 0
int huerange = 120; // the range of the hue
int b = 60;// constant brightness
int satmin = 70; // saturation minimum
int satmax = 100; // saturation maximum
int stepmin = 30; // step minimum
int stepmax = 70; // step maximum
int step = stepmin; // the actual step

size(800,450); // size of the canvas
background(255); // bg color
int c; // will holf the color

colorMode(HSB,360,100,100); // use HSB mode for easier handling of harmonics
noStroke(); // dont ned a stroke

/**
 * Lets loop.
 * we will create some rectangles
 * with a random height between the step min/max
 * and the width of the canvas.
 * we increase the y value each iteration with a random value
 */
for(int y = 0; y < height; y += step){

  step = PApplet.parseInt(random(stepmin,stepmax)); // we cast to int just because we use int for step
  c = color(hueoffset + (y%huerange),random(satmin,satmax),b); // calculate the color
  fill(c);// set the color
  rect(0, y, width, step);// draw he rectangke

}// end of y loop
    noLoop();
  }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "lewitt01" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
