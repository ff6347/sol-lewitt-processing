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

public class lewitt630 extends PApplet {
  public void setup() {
size(450, 450);
background(255);
noStroke();
fill(0xff000000);

pushMatrix();
translate(width/2, height/2);
rotate(PI/3);
for (int x = 0; x < width;x = x + 90) {
  rect(x, 0, 45, height);
}
popMatrix();

    noLoop();
  }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "lewitt630" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
