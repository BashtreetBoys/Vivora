package gameObject;

public class Cabeza {
	
	private int posX;
	private int posY;
	private float velocidad;
	
	public Cabeza(float velocidad) {
		this.velocidad = velocidad;
	}

	public void movCabeza(int dir) {
		
		if(dir == 1)
			this.posY -= 20*velocidad;
		else if(dir == 2)
			this.posX += 20*velocidad;
		else if(dir == 3)
			this.posY += 20*velocidad;
		else if(dir == 4)
			this.posX -= 20*velocidad;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}	
}
