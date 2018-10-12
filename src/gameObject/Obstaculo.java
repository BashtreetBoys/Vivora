package gameObject;

public class Obstaculo {
	private int posXini;
	private int posXfin;
	private int posYini;
	private int posYfin;
	
	public Obstaculo(int posXini, int posYini, int posXfin, int posYfin) {
		this.posXini = posXini;
		this.posXfin = posXfin;
		this.posYini = posYini;
		this.posYfin = posYfin;
	}

	public int getPosXini() {
		return posXini;
	}

	public void setPosXini(int posXini) {
		this.posXini = posXini;
	}

	public int getPosXfin() {
		return posXfin;
	}

	public void setPosXfin(int posXfin) {
		this.posXfin = posXfin;
	}

	public int getPosYini() {
		return posYini;
	}

	public void setPosYini(int posYini) {
		this.posYini = posYini;
	}

	public int getPosYfin() {
		return posYfin;
	}

	public void setPosYfin(int posYfin) {
		this.posYfin = posYfin;
	}	
	
	
}
