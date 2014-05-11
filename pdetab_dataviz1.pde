// samuel hackwill 2014
// WIP programme pour datavisualiser le rapport entre le nombre d'inscrits 
// au concours d'entrée de l'ESADSE puis la taille des classes dans les différentes 
// options à l'ESADSE au fil des années.



int inscrits = 100; // nombre d'étudiants inscrits au concours d'entrée de l'ESADSE
int pelosize =100; // taille de chaque photo du "trombinoscope"
int cols;
int rows;


Pelo[][] pelos;

String[] admission = { 
	"a", "b", "c", 
	// a = gris (pas selectionné pas viré)
	// b = vert (content, selectionné)
	// c = rouge (vénère, viré)
}; 

void setup(){
	size(displayWidth,displayHeight);
	background(255);

	int cols = displayWidth/pelosize; 
	int rows = displayHeight/pelosize;

	/* calcul du nombre de colones & lignes en fonction de la taille de l'écran et de la taille de chaque vignette.
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


void draw(){

	int cols = displayWidth/pelosize;
	int rows = displayHeight/pelosize;

	for(int i=0; i<cols; i++){
		for(int j=0; j<rows; j++){
			pelos[i][j].draw();
		}
	}
}

