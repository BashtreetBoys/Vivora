package gameObject;

public class Cabeza{
	
	private int posX;
	private int posY;
	
	
	public void movCabeza(int dir) {
		
		if(dir == 1)
			this.posY++;
		else if(dir == 2)
			this.posX++;
		else if(dir == 3)
			this.posY--;
		else if(dir == 4)
			this.posX--;
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