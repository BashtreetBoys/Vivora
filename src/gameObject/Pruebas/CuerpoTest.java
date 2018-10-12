package gameObject.Pruebas;
import gameObject.Cuerpo;
import org.junit.Test;
import org.junit.Assert;

public class CuerpoTest {
	@Test
	public void muevo()
	{
		Cuerpo body = new Cuerpo (2,2);
		body.movCuerpo(7, 7);
		Assert.assertEquals(7,body.getPosY());
		Assert.assertEquals(7,body.getPosX() );
	}
	

}
