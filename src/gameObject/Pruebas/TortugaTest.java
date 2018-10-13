package gameObject.Pruebas;
import org.junit.Test;

import gameObject.Tortuga;
import gameObject.Vibora;

import org.junit.Assert;

public class TortugaTest {

	@Test
	public void bajarVelocidad() {
		Vibora nueva = new Vibora(2,2);
		new Tortuga().cambiarEstado(nueva);
		Assert.assertEquals(1, nueva.getVelocidad());
		
		
	}
}
