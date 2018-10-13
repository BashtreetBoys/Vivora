package gameObject;

import java.util.ArrayList;

public class Arena {
	private int tamaño = 100;
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
		this.frutaActual = new Fruta();
		this.lv = 1;
		this.cantidadFrutas = 0;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public void agregarVibora(Vibora v) {
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
		
		//Agregat frutas
		this.cantidadFrutas = 0;
		//Aca habria que crear una fruta Alex tiene esta parte del codigo
		
		//METO LAS SERPIENTES QUE DEBEN EMPEZAR EN ESTE NIVEL
		ArrayList<Vibora> auxiliar = viboras;
		
		for(int i=0; i < viboras.size(); i++) {
			if(viboras.get(i).isViva() == true)
				auxiliar.add(viboras.get(i));
		}
		
		for(int i=0; i < auxiliar.size(); i++) {
			this.agregarVibora(auxiliar.get(i));
		}
		
		//AGREGO LOS OBSTACULOS DEL NIVEL ACTUAL
		switch (lv) {
		case 1:
			obstaculos.clear();
			obstaculos.add(new Obstaculo(1,1,100,1));
			obstaculos.add(new Obstaculo(100,2,100,100));
			obstaculos.add(new Obstaculo(99,100,1,100));
			obstaculos.add(new Obstaculo(1,99,1,2));
			break;
		case 2:
			obstaculos.clear();
			obstaculos.add(new Obstaculo(1,1,100,1));
			obstaculos.add(new Obstaculo(100,2,100,100));
			obstaculos.add(new Obstaculo(99,100,1,100));
			obstaculos.add(new Obstaculo(1,99,1,2));
			break;
		case 3:
			obstaculos.clear();
			obstaculos.add(new Obstaculo(1,1,100,1));
			obstaculos.add(new Obstaculo(100,2,100,100));
			obstaculos.add(new Obstaculo(99,100,1,100));
			obstaculos.add(new Obstaculo(1,99,1,2));
			break;
		case 4:
			obstaculos.clear();
			obstaculos.add(new Obstaculo(1,1,100,1));
			obstaculos.add(new Obstaculo(100,2,100,100));
			obstaculos.add(new Obstaculo(99,100,1,100));
			obstaculos.add(new Obstaculo(1,99,1,2));
			break;
		case 5:
			obstaculos.clear();
			obstaculos.add(new Obstaculo(1,1,100,1));
			obstaculos.add(new Obstaculo(100,2,100,100));
			obstaculos.add(new Obstaculo(99,100,1,100));
			obstaculos.add(new Obstaculo(1,99,1,2));
			break;
		}
	}
	
	//getters para las pruebas, no sirven para mucho pero bueno
	public ArrayList<Vibora> getViboras() {
		return viboras;
	}

	public void setViboras(ArrayList<Vibora> viboras) {
		this.viboras = viboras;
	}

	public ArrayList<Obstaculo> getObstaculos() {
		return obstaculos;
	}

	public void setObstaculos(ArrayList<Obstaculo> obstaculos) {
		this.obstaculos = obstaculos;
	}
	

	
}
