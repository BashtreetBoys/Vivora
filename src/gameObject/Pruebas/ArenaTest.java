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
	//bg.agregarVibora(nueva);
	//bg.agregarVibora(nueva2);
	bg.cambiarNivel();
	int vib = bg.getViboras().size();
	//System.out.println(vib);
	//System.out.println(bg.getObstaculos().size());
	/*Assert.assertEquals(2, bg.getViboras().size());
	Assert.assertEquals(4, bg.getObstaculos().size());
	*/
	}

}
