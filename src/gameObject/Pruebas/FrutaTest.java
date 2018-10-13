package gameObject.Pruebas;
import org.junit.Test;
import org.junit.Assert;
import gameObject.Fruta;
public class FrutaTest {
	
	@Test
	public void AgregoFruta() {
		Fruta nueva = new Fruta("Tortuga",1,1,3);
		Assert.assertEquals("Tortuga",nueva.getPowerUp());
		Assert.assertEquals(1, nueva.getPosX());
		Assert.assertEquals(1, nueva.getPosY());
		Assert.assertEquals(3, nueva.getNumeroFruta());
	}

}
