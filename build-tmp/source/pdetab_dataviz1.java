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

public class pdetab_dataviz1 extends PApplet {

// samuel hackwill 2014
// WIP programme pour datavisualiser le rapport entre le nombre d'inscrits 
// au concours d'entr\u00e9e de l'ESADSE puis la taille des classes dans les diff\u00e9rentes 
// options \u00e0 l'ESADSE au fil des ann\u00e9es.



int inscrits = 100; // nombre d'\u00e9tudiants inscrits au concours d'entr\u00e9e de l'ESADSE
int pelosize =100; // taille de chaque photo du "trombinoscope"
int cols;
int rows;


Pelo[][] pelos;

String[] admission = { 
	"a", "b", "c", 
	// a = gris (pas selectionn\u00e9 pas vir\u00e9)
	// b = vert (content, selectionn\u00e9)
	// c = rouge (v\u00e9n\u00e8re, vir\u00e9)
}; 

public void setup(){
	size(displayWidth,displayHeight);
	background(255);

	int cols = displayWidth/pelosize; 
	int rows = displayHeight/pelosize;

	/* calcul du nombre de colones & lignes en fonction de la taille de l'\u00e9cran et de la taille de chaque vignette.
	ce qui n'est pas bon. Ce qu'il faudrait, c'est qu'en fonction de INSCRITS et DISPLAYWIDTH et DISPLAYHEIGHT il calcule
	1. la taille de PELOSIZE
	2. le nombre de colones et lignes maximum
	*/

	pelos= new Pelo[cols][rows];

	for(int i=0; i<cols; i++){
		for(int j=0; j<rows; j++){
			pelos[i][j] =new Pelo(i*(pelosize-20), j*(pelosize-20), (int)random(1,12), admission[0]);
		}
	}
}


public void draw(){

	int cols = displayWidth/pelosize;
	int rows = displayHeight/pelosize;

	for(int i=0; i<cols; i++){
		for(int j=0; j<rows; j++){
			pelos[i][j].draw();
		}
	}
}

class Pelo {



	PImage pelo = new PImage();

	int x;
	int y;

	int type;
	String admission;

	Pelo(int _x, int _y, int _type, String _admission){
		this.x=_x;
		this.y=_y;
		this.type=_type;
		this.admission=_admission;

		this.pelo=loadImage("pelos"+this.type+this.admission+".gif");

	}

	public void draw(){

		image(pelo, x, y, pelosize, pelosize);
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "pdetab_dataviz1" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
