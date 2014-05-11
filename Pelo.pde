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

	void draw(){

		image(pelo, x, y, pelosize, pelosize);
	}
}
