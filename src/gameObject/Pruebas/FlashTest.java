package gameObject.Pruebas;
import org.junit.Test;

import gameObject.Flash;
import gameObject.Vibora;

import org.junit.Assert;

public class FlashTest {
	
	@Test
	public void subirVelocidad() {
		Vibora nueva = new Vibora(2,20);
		new Flash().cambiarEstado(nueva);
		Assert.assertEquals(4, nueva.getVelocidad());
		
	}

}
