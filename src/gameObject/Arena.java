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

	public Object verColision(int x, int y) {

		/* Verifica si hay una fruta en la posición */
		if (x == frutaActual.getPosX() && y == frutaActual.getPosY())// si es una fruta // fruta
			return frutaActual.getClass();

		/* Verifica si hay un obstáculo en la posición */
		for (int i = 0; i < obstaculos.size(); i++) {
			int posXini = obstaculos.get(i).getPosXini();
			int posYini = obstaculos.get(i).getPosYini();
			int posXfin = obstaculos.get(i).getPosXfin();
			int posYfin = obstaculos.get(i).getPosYfin();
			
			if(posXini == posXfin) {
				if(posXini == x) {
					if(y>=posYini && y<=posYfin)
						return obstaculos.get(i).getClass();
				}
			}
			
			if(posYini == posYfin) {
				if(posYini == y) {
					if(x>=posXini && x<=posXfin)
						return obstaculos.get(i).getClass();
				}
			}
			
		}


		for (int i = 0; i < viboras.size(); i++) {
			if (viboras.get(i).getCabeza().getPosX() == x && viboras.get(i).getCabeza().getPosY() == y)
				return viboras.get(i).getClass();
			for (int j = 0; j < viboras.get(i).getCuerpito().size(); j++)
				if (viboras.get(i).getCuerpito().get(i).getPosX() == x
						&& viboras.get(i).getCuerpito().get(i).getPosY() == y)
					return viboras.get(i).getClass();
		}
		return null;
	}

	boolean colisionarFruta(Vibora vibora, Fruta fruta) {

		if (vibora.getCabeza().getPosX() == fruta.getPosX() && vibora.getCabeza().getPosY() == fruta.getPosY()) {
				//vibora.crecer();
//			if(vibora.getEstado){
//			
//			}
			return true;
		}
		return false;
	}

	boolean colisionarObstaculo(Vibora vibora, Obstaculo obsta) {

		return false;
	}

	boolean colisionarVibora(Vibora viboraColisionaCon, Vibora vibora) {

		int cabezaEnX = viboraColisionaCon.getCabeza().getPosX();
		int cabezaEnY = viboraColisionaCon.getCabeza().getPosY();

		if (cabezaEnX == vibora.getCabeza().getPosX() && cabezaEnY == vibora.getCabeza().getPosY()) {

			viboraColisionaCon.setViva(false); // muere
			return true;
		}

		for (int i = 0; i < vibora.getCuerpito().size(); i++) {
			if (vibora.getCuerpito().get(i).getPosX() == cabezaEnX
					&& vibora.getCuerpito().get(i).getPosX() == cabezaEnY)
			viboraColisionaCon.setViva(false); // muere
			return true;
		}
		return false;
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
		this.agregarFruta(frutaActual);

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
