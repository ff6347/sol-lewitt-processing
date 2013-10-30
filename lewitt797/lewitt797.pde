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
void setup() {
  sys = new LewittCurveSystem(); // a new curve system
  sys.init(); // initalize
  size(800, 450); // the canvas
  smooth(); // so ot looks smoother
  sys.draw(); // draw it
}

/**
 * This would be executed every frame
 */
void draw() {
  // nothing happens here
}

/**
 * The whole curve system class
 */
class LewittCurveSystem {
  float weight = 3; // initial stroke weight
  float detail = 0.01; // this is the curve detail
  float num = 1000; // the number of curves to draw
  ArrayList <LewittCurve> curves; // this will hold all curves
  // constructor
  LewittCurveSystem() {
    curves = new ArrayList<LewittCurve>();// initalize the list
  }

  /**
   * init function could go into the constructor
   * creates num of lines with random colors
   */
  void init() {
    float pos = 0;

    for (int i = 0; i < num;i++) {
      curves.add(new LewittCurve(pos, detail, color(random(255), random(255), random(255))));
      pos = pos+weight;
    }// end of i loop
  } // end of init

    // the draw function calls display on every curve in the list
  void draw() {
    noFill();// dont want a fill
    strokeWeight(weight);// define the weight
    // loop the curves list create in the init()
    for (int i =0; i < curves.size(); i++) {
      curves.get(i).display();
    }// end loop i
  }// end draw system
} // end of class LewittCurveSystem()

/**
 * Now the curve class
 */
class LewittCurve {
  float yoff = 0.0; // offset
  float detail; // the noise detail
  color c; // the curves color
  float range = 100;// the range a cuve can curve :)
  float ystart  =  -range; // the y starting point offset by the range
  /**
   * The constructor
   */
  LewittCurve(float _ystart, float _detail, color _c) {
    // asign incoming to local variables
    ystart = _ystart- range;
    detail = _detail;
    c = _c;
  }

  /**
   * This draws a curve
   */
  void display() {
    stroke(c);// set the color
    beginShape(); // start the curve
    /**
     * loop over the width of the canvas
     */
    for (int x = 0; x < width;x+=3) {
      yoff = yoff + detail; // cacl new y offset
      float y = (  noise(yoff) * range); // calc y
      curveVertex(x, ystart + y); // draw curve
    } // end of loop
    endShape();// finish cuve
  }// end of display()
} // end of class LewittCurve()

