package gameObject.Pruebas;
import org.junit.Test;
import org.junit.Assert;
import gameObject.Arena;
import gameObject.Vibora;
import gameObject.Obstaculo;
public class ArenaTest {
	
	
	
	@Test
	public void AgregoElementos() {
	Vibora nueva = new Vibora (3,3);
	Vibora nueva2 = new Vibora(4,9);
	
	Arena bg = new Arena ();
	
	bg.setLv(1);

	
	bg.cambiarNivel();
	bg.agregarVibora(nueva);
	Assert.assertEquals(1, bg.getViboras().size());
	
	Assert.assertEquals(4, bg.getObstaculos().size());
	/**
	 * Corregir que pasa cuando agrego viboras antes de cambiar de nivel, parece que no le esta gustando la recorrida 
	 * que hacen con la copia, entra en un loop infinito
	 */
	
	
	}

}
