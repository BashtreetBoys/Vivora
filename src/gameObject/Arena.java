package gameObject;

import java.util.ArrayList;
import java.util.Random;

public class Arena {
	// Esta variable define el tamaño de cada cuadrado que dibujamos en la arena
	// Puede cambiar a futuro, depende de nuestro gusto
	public static final int TAM_GRAFICOS = 20;

	private ArrayList<Vibora> viboras;
	private ArrayList<Obstaculo> obstaculos;
	private Fruta frutaActual;
	private int lv;
	private int cantidadFrutas;
	int cont;
	boolean chocó = false;
	int dirección = 0;

	public Arena() {
		super();
		this.viboras = new ArrayList<Vibora>();
		this.obstaculos = new ArrayList<Obstaculo>();
		this.lv = 1;
		this.frutaActual = new Fruta("Normal", 0, 0, 1);
		cont = 0;
	}

	public void agregarFruta(Fruta frutaNueva) {

		/** Random */
		int fil = (int) Math.round(880 / Arena.TAM_GRAFICOS), 
			col = (int) Math.round(640 / Arena.TAM_GRAFICOS), 
			x, y;

		do {
			x = new Random().nextInt(fil) * Arena.TAM_GRAFICOS;
			y = new Random().nextInt(col) * Arena.TAM_GRAFICOS;
		} while ((verColision(x, y) != null));

		frutaNueva.setPosX(x);
		frutaNueva.setPosY(y);
	}

	public Object verColision(int x, int y) {

		/* Verifica si hay una fruta en la posición */
		if (x == frutaActual.getPosX() && y == frutaActual.getPosY())
			return frutaActual;

		/* Verifica si hay un obstáculo en la posición */
		for (int i = 0; i < obstaculos.size(); i++) {
			int posXini = obstaculos.get(i).getPosXini();
			int posYini = obstaculos.get(i).getPosYini();
			int posXfin = obstaculos.get(i).getPosXfin();
			int posYfin = obstaculos.get(i).getPosYfin();

			/*
			 * if (posXini == posYini) { if (posXini == x) { if (y >= posYini &&
			 * y <= posYfin) return obstaculos.get(i); } }
			 * 
			 * if (posXfin == posYfin) { if (posYini == y) { if (x >= posXini &&
			 * x <= posXfin) return obstaculos.get(i); } }
			 */
			// Veo si el punto pasado por parametro esta entre los valores X e Y
			// del obstaculo
			if ((x >= posXini && x <= posXfin) && (y >= posYini && y <= posYfin)) {
				return obstaculos.get(i).getClass().getSimpleName();
			}

		}

		// Veo si la cabeza de alguna vibora choca con la cabeza de otra vibora
		int choco = 0, indice = 0;
		for (int i = 0; i < this.viboras.size(); i++) {
			// Veo si la cabeza de la vibora en la que estoy mirando choca con
			// la cabeza de alguna otra vibora
			if ((x == this.viboras.get(i).getCabeza().getPosX() && y == this.viboras.get(i).getCabeza().getPosY()))
				choco++;

			if (choco >= 1)
				indice = i;
		}

		if (choco == 2)
			return this.viboras.get(indice);

		// Veo si la cabeza de alguna vibora choca con algun cuerpito de otra
		// vibora
		for (int i = 0; i < this.viboras.size(); i++) {
			for (int j = 0; j < this.viboras.get(i).getCuerpito().size(); j++) {
				if ((x == this.viboras.get(i).getCuerpito().get(j).getPosX()
						&& y == this.viboras.get(i).getCuerpito().get(j).getPosY()))
					return 1;
			}
		}
		return null;
	}

	public void colisionarFruta(Vibora vibora) {

		vibora.crecer();
		this.agregarFruta(frutaActual);
		this.cantidadFrutas++;
	}

	public void colisionarConViboraOObstaculo(Vibora vibora) {
		vibora.setViva(false);
		vibora.morir();
	}

	public void colisionarConViboraOObstaculo(Object vibora) {
		((Vibora) vibora).setViva(false);
		((Vibora) vibora).morir();
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
					&& vibora.getCuerpito().get(i).getPosX() == cabezaEnY) {

				viboraColisionaCon.setViva(false); // muere
				return true;
			}
		}
		return false;
	}

	public void agregarVibora(Vibora v, int x, int y, int dir) {
		v.setVibora(x, y, dir);
	}

	public void agregarVibora(Vibora v) {
		viboras.add(v);
		int n;
		n = viboras.indexOf(v);

		switch (n) {
		case 0:
			v.setVibora(4, 4, 2);
			break;
		case 1:
			v.setVibora(10, 10, 2);
			break;
		case 2:
			v.setVibora(20, 20, 2);
			break;
		case 3:
			v.setVibora(95, 50, 3);
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

		// METO LAS SERPIENTES QUE DEBEN EMPEZAR EN ESTE NIVEL
		ArrayList<Vibora> auxiliar = new ArrayList<Vibora>();

		for (int i = 0; i < viboras.size(); i++) {
			viboras.get(i).resetearCuerpo();
			if (viboras.get(i).isViva() == true)
				auxiliar.add(viboras.get(i));
		}
		viboras.clear();
		for (int i = 0; i < auxiliar.size(); i++) {
			this.agregarVibora(auxiliar.get(i));
		}

		// AGREGO LOS OBSTACULOS DEL NIVEL ACTUAL
		switch (lv) {
		case 1:
			obstaculos.clear();
			obstaculos.add(new Obstaculo(0, 0, 19, 640));
			obstaculos.add(new Obstaculo(19, 0, 880, 19));
			obstaculos.add(new Obstaculo(860, 19, 880, 640));
			obstaculos.add(new Obstaculo(0, 640, 880, 660));
			break;
		case 2:
			obstaculos.clear();
			obstaculos.add(new Obstaculo(0, 0, 19, 640));
			obstaculos.add(new Obstaculo(19, 0, 880, 19));
			obstaculos.add(new Obstaculo(860, 19, 880, 640));
			obstaculos.add(new Obstaculo(0, 640, 880, 660));
			obstaculos.add(new Obstaculo(220, 320, 659, 339));
			break;
		case 3:
			obstaculos.clear();
			obstaculos.add(new Obstaculo(0, 0, 19, 640));
			obstaculos.add(new Obstaculo(19, 0, 880, 19));
			obstaculos.add(new Obstaculo(860, 19, 880, 640));
			obstaculos.add(new Obstaculo(0, 640, 880, 660));
			obstaculos.add(new Obstaculo(560, 180, 880, 199));
			obstaculos.add(new Obstaculo(0, 380, 319, 399));
			obstaculos.add(new Obstaculo(320, 0, 339, 259));
			obstaculos.add(new Obstaculo(560, 400, 579, 660));
			break;
		case 4:
			obstaculos.clear();
			obstaculos.add(new Obstaculo(0, 0, 19, 640));
			obstaculos.add(new Obstaculo(19, 0, 880, 19));
			obstaculos.add(new Obstaculo(860, 19, 880, 640));
			obstaculos.add(new Obstaculo(0, 640, 880, 660));
			break;
		case 5:
			obstaculos.clear();
			obstaculos.add(new Obstaculo(0, 0, 19, 640));
			obstaculos.add(new Obstaculo(19, 0, 880, 19));
			obstaculos.add(new Obstaculo(860, 19, 880, 640));
			obstaculos.add(new Obstaculo(0, 640, 880, 660));
			break;
		}

		// Agregar frutas
		this.cantidadFrutas = 0;
		this.agregarFruta(frutaActual);
	}

	public ArrayList<Vibora> getViboras() {
		return viboras;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public Fruta getFrutaActual() {
		return frutaActual;
	}

	public void setFrutaActual(Fruta frutaActual) {
		this.frutaActual = frutaActual;
	}

	public int getCantidadFrutas() {
		return cantidadFrutas;
	}

	public void setCantidadFrutas(int cantidadFrutas) {
		this.cantidadFrutas = cantidadFrutas;
	}

	public ArrayList<Obstaculo> getObstaculos() {
		return obstaculos;
	}

	// public enum direccion
	// {
	// ARRIBA, DERECHA, ABAJO, IZQUIERDA
	// }

	public void inteligenciaArtificial(Vibora v, Object obj2) {

		if (v.getCabeza().getPosX() < frutaActual.getPosX()) {
			if (v.getCabeza().getPosY() > frutaActual.getPosY())
				v.setDireccion(1);
			else if (v.getCabeza().getPosY() < frutaActual.getPosY())
				v.setDireccion(3);
			else if (v.getDireccion() == 4) {
				v.setDireccion(1);
			} else {
				v.setDireccion(2);
			}
		} else if (v.getCabeza().getPosX() > frutaActual.getPosX()) {
			if (v.getCabeza().getPosY() > frutaActual.getPosY())
				v.setDireccion(1);
			else if (v.getCabeza().getPosY() < frutaActual.getPosY())
				v.setDireccion(3);
			else if (v.getDireccion() == 2) {
				v.setDireccion(3);
			} else {
				v.setDireccion(4);
			}
		}

		// if((verColision(v.getCabeza().getPosX()+TAM_GRAFICOS,
		// v.getCabeza().getPosY()+TAM_GRAFICOS)) != null && v.getDireccion() !=
		// 1)
		// v.setDireccion(1);

		v.moverVibora(v.getDireccion());

		if (obj2 == getFrutaActual())
			colisionarFruta(v);
		
		 else if (obj2 != null && obj2.getClass() == v.getClass()) {
			 colisionarConViboraOObstaculo(obj2);
			 colisionarConViboraOObstaculo(v);
		 } else if (obj2 != null && obj2.getClass() == v.getClass()) {
			 colisionarConViboraOObstaculo(v);
		 } else if (obj2 != null)
			 colisionarConViboraOObstaculo(v);
	}

	public void inteligenciaArtificialCuadrado(Vibora vibora2, Object obj2) {

		if (cont <= 2)
			vibora2.setDireccion(2);
		else if (cont >= 3 && cont <= 5)
			vibora2.setDireccion(3);
		else if (cont > 5 && cont <= 8)
			vibora2.setDireccion(4);
		else if (cont > 8 && cont <= 11)
			vibora2.setDireccion(1);
		else {
			cont = 0;
			vibora2.setDireccion(2);
		}

		vibora2.moverVibora(vibora2.getDireccion());

		cont++;

		if (obj2 == getFrutaActual())
			colisionarFruta(vibora2);
		else if (obj2 != null && obj2.getClass() == vibora2.getClass()) {

			colisionarConViboraOObstaculo(obj2);
			colisionarConViboraOObstaculo(vibora2);
		} else if (obj2 != null && obj2.getClass() == vibora2.getClass()) {

			colisionarConViboraOObstaculo(vibora2);
		} else if (obj2 != null)
			colisionarConViboraOObstaculo(vibora2);
	}
}
