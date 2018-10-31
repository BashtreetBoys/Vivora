package gameObject;

public interface Estado {
	/**
	 * Seg�n el estado de la vibora, el m�todo aplicar� el Power Up correspondiente.
	 * @param vibora Vibora a la cual se le aplicar� el Power Up.
	 */
	public void cambiarEstado(Vibora vibora);
}
