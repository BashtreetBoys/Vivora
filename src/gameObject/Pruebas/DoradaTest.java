package gameObject.Pruebas;
import org.junit.Test;

import gameObject.Dorada;
import gameObject.Vibora;

import org.junit.Assert;
public class DoradaTest {

	@Test
	public void CambiaRatioCrecimiento() {
		Vibora nueva = new Vibora(2,3);
		new Dorada().cambiarEstado(nueva);
		int rat = nueva.getRatioCrecimiento();
		Assert.assertTrue(rat >=1);
	}
	
}
