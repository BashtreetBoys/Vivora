package gameObject;

import java.util.ArrayList;
import java.util.Random;

public class Arena {
	// Esta variable define el tamaño de cada cuadrado que dibujamos en la arena
	// Puede cambiar a futuro, depende de nuestro gusto
	public static final int TAM_GRAFICOS = 20;
	
	private int tamaño;
	private ArrayList<Vibora> viboras;
	private ArrayList<Obstaculo> obstaculos;
	private Fruta frutaActual;
	private int lv;
	private int cantidadFrutas;

	public Arena() {
		super();
		this.tamaño = 100;
		this.viboras = new ArrayList<Vibora>();
		this.obstaculos = new ArrayList<Obstaculo>();
		this.lv = 1;
		this.frutaActual = new Fruta("Normal", 0, 0, 1);
	}
	
	public void agregarFruta(Fruta frutaNueva) {

		
//		x = (int) (Math.random() * tamaño) + 1; // Esto esta mal pensado, no concuerda con lo que hacemos
//		y = (int) (Math.random() * tamaño) + 1;	// Nosotros estamos trabajando en una grilla con celdas de tamaño
												// Arena.TAM_GRAFICOS
		/* Random */		
		int fil = (int) Math.round(600 / Arena.TAM_GRAFICOS);
		int col = (int) Math.round(820/ Arena.TAM_GRAFICOS);
		
		int x = new Random().nextInt(col) * Arena.TAM_GRAFICOS; // Nos da una fila random entre las que tenemos
		int y = new Random().nextInt(fil) * Arena.TAM_GRAFICOS; // Nos da una columna random entre las que tenemos

		System.out.println(x + ", " + y);
		/*
		 * En estos momentos como no puedo setear el tamaño de la arena como quiero a veces la fruta sale 
		 * de la arena, preguntar como solucionar ese asunto del redimensionado del ArenaJPanel y asi poder
		 * trabajar con la cantidad correcta de filas y columnas
		 *
		 */
		
		while (verColision(x, y) != null) {
			x = new Random().nextInt(fil) * Arena.TAM_GRAFICOS;
			y = new Random().nextInt(col) * Arena.TAM_GRAFICOS;
		}
		frutaNueva.setPosX(x);
		frutaNueva.setPosY(y);
	}

	public Object verColision(int x, int y) {

		/* Verifica si hay una fruta en la posición */
		if (x == frutaActual.getPosX() && y == frutaActual.getPosY())// si es una fruta // fruta
			return frutaActual;

		/* Verifica si hay un obstáculo en la posición */
		for (int i = 0; i < obstaculos.size(); i++) {
			int posXini = obstaculos.get(i).getPosXini();
			int posYini = obstaculos.get(i).getPosYini();
			int posXfin = obstaculos.get(i).getPosXfin();
			int posYfin = obstaculos.get(i).getPosYfin();

			/*if (posXini == posYini) {
				if (posXini == x) {
					if (y >= posYini && y <= posYfin)
						return obstaculos.get(i);
				}
			}

			if (posXfin == posYfin) {
				if (posYini == y) {
					if (x >= posXini && x <= posXfin)
						return obstaculos.get(i);
				}
			}*/
			//Veo si el punto pasado por parametro esta entre los valores X e Y del obstaculo
			if( (x >= posXini && x <= posXfin) && ( y >= posYini && y <= posYfin ) ) {
				return obstaculos.get(i).getClass().getSimpleName();
			}

		}
		//Veo si la cabeza de alguna vibora choca con la cabeza de otra vibora
		for(int i=0;i<this.viboras.size();i++) {
			for(int j=i+1;j<this.viboras.size();j++) {
				//Veo si la cabeza de la vibora en la que estoy mirando choca con la cabeza de alguna otra vibora
				if( ( this.viboras.get(i).getCabeza().getPosX() == this.viboras.get(j).getCabeza().getPosX() ) && ( this.viboras.get(i).getCabeza().getPosY() == this.viboras.get(j).getCabeza().getPosY() ) ) {
					return this.viboras.get(j).getClass().getSimpleName();
				}
			}
		}
		
		//Veo si la cabeza de alguna vibora choca con algun cuerpito de otra vibora
		/* Prototipo, hay que corregirlo
		for(int i=0;i<this.viboras.size();i++) {
			for(int j=i+1;j<this.viboras.size();j++) {
				for(int k=0;k<=this.viboras.get(j).getCuerpito().size();k++) {
					if( ( this.viboras.get(i).getCabeza().getPosX() == this.viboras.get(j).getCuerpito().get(k).getPosX() ) && ( this.viboras.get(i).getCabeza().getPosY() ==  this.viboras.get(j).getCuerpito().get(k).getPosY() ) ) {
						return this.viboras.get(j).getClass().getSimpleName();
					}
				}
				
			}
		}*/
		
		
		
//		for (int i = 0; i < viboras.size(); i++) {
//			if (viboras.get(i).getCabeza().getPosX() == x && viboras.get(i).getCabeza().getPosY() == y)
//				return viboras.get(i);
//			for (int j = 0; j < viboras.get(i).getCuerpito().size(); j++)
//				if (viboras.get(i).getCuerpito().get(i).getPosX() == x
//						&& viboras.get(i).getCuerpito().get(i).getPosY() == y)
//					return viboras.get(i);
//		}
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

	public void agregarVibora(Vibora v, int x, int y, int dir)	{
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

	public int getTamaño() {
		return tamaño;
	}

	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
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
}
