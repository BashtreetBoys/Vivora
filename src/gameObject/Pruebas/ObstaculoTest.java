package gameObject.Pruebas;

import org.junit.Test;
import org.junit.Assert;
import gameObject.Obstaculo;
public class ObstaculoTest {
	
	@Test
	public void crearObstaculo() {
		Obstaculo nuevo = new Obstaculo(1,1,2,2);
		Assert.assertEquals(1,nuevo.getPosXini());
		Assert.assertEquals(1,nuevo.getPosYini());
		Assert.assertEquals(2,nuevo.getPosXfin());
		Assert.assertEquals(2,nuevo.getPosXfin());
	}

}
