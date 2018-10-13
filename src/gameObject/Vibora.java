package gameObject;

import java.util.ArrayList;

public class Vibora {
	
	private int velocidad;
	private Cabeza cabeza;
	private ArrayList<Cuerpo> cuerpito;
	private int direccion;
	private ArrayList posiciones;
	private int ratioCrecimiento;
	private boolean viva;
	
	
	public Vibora(int xIni,int yIni) {
		this.velocidad = 1 ;
		this.cabeza = new Cabeza();
		this.cuerpito = new ArrayList<Cuerpo>();
		//this.posiciones = new ArrayList<>();
		this.ratioCrecimiento=1;
		this.viva = true;
	}
	
	public void setVibora(int xIni, int yIni,int direccion) {
		this.direccion = direccion;
		cabeza.setPosX(xIni);
		cabeza.setPosY(yIni);
		//this.posiciones.add(cabeza.getPosX());
		//this.posiciones.add(cabeza.getPosY());
		if(this.direccion == 1) {
			
			cuerpito.add(new Cuerpo(cabeza.getPosX(),cabeza.getPosY()-1));
			//this.posiciones.add(cabeza.getPosX());
			//this.posiciones.add(cabeza.getPosY()-1);
			cuerpito.add(new Cuerpo(cabeza.getPosX(),cabeza.getPosY()-2));
			//this.posiciones.add(cabeza.getPosX());
			//this.posiciones.add(cabeza.getPosY()-2);
		}
		else if(this.direccion == 2) {
			
			cuerpito.add(new Cuerpo(cabeza.getPosX()-1,cabeza.getPosY()));
			//this.posiciones.add(cabeza.getPosX()-1);
			//this.posiciones.add(cabeza.getPosY());
			cuerpito.add(new Cuerpo(cabeza.getPosX()-2,cabeza.getPosY()));
			//this.posiciones.add(cabeza.getPosX()-2);
			//this.posiciones.add(cabeza.getPosY());
			
		}
		else if(this.direccion == 3) {
			
			cuerpito.add(new Cuerpo(cabeza.getPosX(),cabeza.getPosY() + 1));
			//this.posiciones.add(cabeza.getPosX());
			//this.posiciones.add(cabeza.getPosY() + 1);
			cuerpito.add(new Cuerpo(cabeza.getPosX(),cabeza.getPosY() + 2));
			//this.posiciones.add(cabeza.getPosX());
			//this.posiciones.add(cabeza.getPosY() + 2);
		}
		else if(this.direccion == 4) {
			
			cuerpito.add(new Cuerpo(cabeza.getPosX() + 1,cabeza.getPosY()));
			//this.posiciones.add(cabeza.getPosX() +1);
			//this.posiciones.add(cabeza.getPosY());
			cuerpito.add(new Cuerpo(cabeza.getPosX() + 2,cabeza.getPosY()));
			//this.posiciones.add(cabeza.getPosX() + 2);
			//this.posiciones.add(cabeza.getPosY());
		}
			
	}
	
	public void moverVibora(int direccion) {
	
	this.direccion=direccion; 

	int xCuerpo = cuerpito.get(0).getPosX(); 
	int yCuerpo= cuerpito.get(0).getPosY();
	cuerpito.get(0).movCuerpo(this.cabeza.getPosX(), this.cabeza.getPosY());
	
	this.cabeza.movCabeza(this.direccion);
	int i = 1;

	while(i<cuerpito.size()) {
			
	Cuerpo c1 = new Cuerpo(xCuerpo,yCuerpo);
	xCuerpo=cuerpito.get(i).getPosX();
	yCuerpo=cuerpito.get(i).getPosY();
	cuerpito.get(i).movCuerpo(c1.getPosX(),c1.getPosY());
	
	i++;
	
	}
		
}
	
	public void crecer(int dir) {
		
		for(int i=0;i<this.ratioCrecimiento;i++) {
		
			Cuerpo anteultimo = this.cuerpito.get(this.cuerpito.size()-2);
			Cuerpo ultimo = this.cuerpito.get(this.cuerpito.size()-1);
		
			if(((this.cuerpito.get(this.cuerpito.size()-2).getPosY()==this.cuerpito.get(this.cuerpito.size()-1).getPosY())) && this.cuerpito.get(this.cuerpito.size()-2).getPosX()>this.cuerpito.get(this.cuerpito.size()-1).getPosX()) {
				this.cuerpito.add(new Cuerpo(ultimo.getPosX()-1, ultimo.getPosY()));
			}
		
			else if((anteultimo.getPosY()==ultimo.getPosY()) && anteultimo.getPosX()<ultimo.getPosX()) {
				this.cuerpito.add(new Cuerpo(ultimo.getPosX()+1, ultimo.getPosY()));
			}
		
			else if((anteultimo.getPosX()==ultimo.getPosX()) && anteultimo.getPosY()<ultimo.getPosY()) {
				this.cuerpito.add(new Cuerpo(ultimo.getPosX(), ultimo.getPosY()+1));
			}
		
			else if((anteultimo.getPosX()==ultimo.getPosX()) && anteultimo.getPosY()>ultimo.getPosY()) {
				this.cuerpito.add(new Cuerpo(ultimo.getPosX(), ultimo.getPosY()-1));
			}
		}
	}
	
	public void removerCuerpo() {
		
		this.cuerpito.remove(this.cuerpito.size()-1);
		
	}
	
	void setRatioCrecimiento(int rand){
		this.ratioCrecimiento = rand;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public boolean isViva() {
		return this.viva;
	}
}
