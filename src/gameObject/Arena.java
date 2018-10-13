package gameObject;

import java.util.ArrayList;

public class Arena {
	private int tamaño = 100;
	private ArrayList<Vibora> viboras;
	private ArrayList<Obstaculo> obstaculos;
	private Fruta frutaActual;
	private int lv;
	private int cantidadFrutas;

	public void agregarFruta(Fruta frutaNueva) {

		/* Random */
		int x = (int) (Math.random() * tamaño) + 1;
		int y = (int) (Math.random() * tamaño) + 1;

		while (verColision(x, y) != null) {

			x = (int) (Math.random() * tamaño) + 1;
			y = (int) (Math.random() * tamaño) + 1;
		}
		frutaNueva.setPosX(x);
		frutaNueva.setPosY(y);
	}

	public Object verColision(int x,int y){
		
		/*Verifica si hay una fruta en la posición*/
		if(x==frutaActual.getPosX() && y==frutaActual.getPosY())//si es una fruta
			return (Object)frutaActual;
		
		/*Verifica si hay un obstáculo en la posición*/
	    for(int i=0;i<obstaculos.size();i++) {
	    	int posXini=obstaculos.get(i).getPosXini();
	    	int posYini=obstaculos.get(i).getPosYini();
	    	int posXfin=obstaculos.get(i).getPosXfin();
	    	int posYfin=obstaculos.get(i).getPosYfin();
	    	
	    	if(posXini==posXfin)//Si están en el mismo nivel
    		{
	    		if(obstaculos.get(i).getPosXini()==x && obstaculos.get(i).getPosYini()== y)
	    			return (Object)obstaculos.get(i);
	    		
	    		if(obstaculos.get(i).getPosXfin()==x && obstaculos.get(i).getPosYfin()== y)
	    			return (Object)obstaculos.get(i);
	    		
    		
    		}	  		
	    }
		
		//lista vivoras->cada cabeza y cada vivora y re visar x , y de todo
		
		return null;
	}

	void agregarVibora(Vibora v) {
		viboras.add(v);
		int n;
		n = viboras.indexOf(v);

		switch (n) {
		case 0:
			v.setVibora(5, 95, 2);
			break;
		case 1:
			v.setVibora(50, 95, 3);
			break;
		case 2:
			v.setVibora(95, 95, 4);
			break;
		case 3:
			v.setVibora(95, 50, 4);
			break;
		case 4:
			v.setVibora(95, 5, 4);
			break;
		case 5:
			v.setVibora(50, 5, 1);
			break;
		case 6:
			v.setVibora(5, 5, 2);
			break;
		case 7:
			v.setVibora(5, 50, 2);
			break;
		}

	}

	public void cambiarNivel() {

		// Agregar frutas
		this.cantidadFrutas = 0;
		// Aca habria que crea fruta fruta Alex tiene esta parte del codigo

		// METO LAS SERPIENTES QUE DEBEN EMPEZAR EN ESTE NIVEL
		ArrayList<Vibora> auxiliar = viboras;

		for (int i = 0; i < viboras.size(); i++) {
			if (viboras.get(i).isViva() == true)
				auxiliar.add(viboras.get(i));
		}

		for (int i = 0; i < auxiliar.size(); i++) {
			this.agregarVibora(auxiliar.get(i));
		}

		// AGREGO LOS OBSTACULOS DEL NIVEL ACTUAL
		switch (lv) {
		case 1:
			obstaculos.clear();
			obstaculos.add(new Obstaculo(1, 1, 100, 1));
			obstaculos.add(new Obstaculo(100, 2, 100, 100));
			obstaculos.add(new Obstaculo(99, 100, 1, 100));
			obstaculos.add(new Obstaculo(1, 99, 1, 2));
			break;
		case 2:
			obstaculos.clear();
			obstaculos.add(new Obstaculo(1, 1, 100, 1));
			obstaculos.add(new Obstaculo(100, 2, 100, 100));
			obstaculos.add(new Obstaculo(99, 100, 1, 100));
			obstaculos.add(new Obstaculo(1, 99, 1, 2));
			obstaculos.add(new Obstaculo(20, 50, 80, 50));
			break;
		case 3:
			obstaculos.clear();
			obstaculos.add(new Obstaculo(1, 1, 100, 1));
			obstaculos.add(new Obstaculo(100, 2, 100, 100));
			obstaculos.add(new Obstaculo(99, 100, 1, 100));
			obstaculos.add(new Obstaculo(1, 99, 1, 2));
			obstaculos.add(new Obstaculo(20, 20, 20, 80));
			obstaculos.add(new Obstaculo(80, 20, 80, 80));
			break;
		case 4:
			obstaculos.clear();
			obstaculos.add(new Obstaculo(1, 1, 100, 1));
			obstaculos.add(new Obstaculo(100, 2, 100, 100));
			obstaculos.add(new Obstaculo(99, 100, 1, 100));
			obstaculos.add(new Obstaculo(1, 99, 1, 2));
			break;
		case 5:
			obstaculos.clear();
			obstaculos.add(new Obstaculo(1, 1, 100, 1));
			obstaculos.add(new Obstaculo(100, 2, 100, 100));
			obstaculos.add(new Obstaculo(99, 100, 1, 100));
			obstaculos.add(new Obstaculo(1, 99, 1, 2));
			break;
		}
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}
}
