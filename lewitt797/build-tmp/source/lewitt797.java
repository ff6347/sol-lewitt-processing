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

public class lewitt797 extends PApplet {

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

LewittCurveSystem sys; // will be our curve system

/**
 * The setup of the sketch
 * this will be executed once
 */
public void setup(){
sys = new LewittCurveSystem(); // a new curve system
sys.init(); // initalize
  size(800,450); // the canvas
  smooth(); // so ot looks smoother
  sys.draw(); // draw it
}

/**
 * This would be executed every frame
 */
public void draw(){
// nothing happens here
}

/**
 * The whole curve system class
 */
class LewittCurveSystem{
 float weight = 3; // initial stroke weight
 float detail = 0.01f; // this is the curve detail
 float num = 1000; // the number of curves to draw
 ArrayList <LewittCurve> curves; // this will hold all curves
 // constructor
  LewittCurveSystem(){
  curves = new ArrayList<LewittCurve>();// initalize the list
  }

  /**
   * init function could go into the constructor
   * creates num of lines with random colors
   */
  public void init(){
    float pos = 0;

  for(int i = 0; i < num;i++){
    curves.add(new LewittCurve(pos, detail,color(random(255),random(255),random(255))));
    pos = pos+weight;
  }// end of i loop
  } // end of init

  // the draw function calls display on every curve in the list
  public void draw(){
    noFill();// dont want a fill
    strokeWeight(weight);// define the weight
    // loop the curves list create in the init()
    for(int i =0; i < curves.size(); i++){
      curves.get(i).display();
    }// end loop i
  }// end draw system
} // end of class LewittCurveSystem()

class LewittCurve{
  float yoff = 0.0f;
  
  float detail;
  int c;
  float range = 100;
  float ystart  =  -range;
  LewittCurve(float _ystart, float _detail,int _c){

  ystart = _ystart- range;
  detail = _detail;
  c = _c;
  }
  
  public void display(){
    stroke(c);
    beginShape();
  for(int x = 0; x < width;x+=3){
      yoff = yoff + detail;
      float y = (  noise(yoff) * range);
       curveVertex(x, ystart + y);
  }
  endShape();
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "lewitt797" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
