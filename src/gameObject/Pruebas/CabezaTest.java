package gameObject.Pruebas;
import gameObject.Cabeza;
import org.junit.Test;
import org.junit.Assert;




public class CabezaTest {

	@Test
	public void probarMovimientos() {
		Cabeza jeds = new Cabeza();
		jeds.setPosX(2);
		jeds.setPosY(1);
		//1 mando arriba
		jeds.movCabeza(1);
		Assert.assertEquals(2, jeds.getPosY());
		//2 mando derecha
		jeds.movCabeza(2);
		Assert.assertEquals(3, jeds.getPosX());
		//3 mando abajo
		jeds.movCabeza(3);
		Assert.assertEquals(1, jeds.getPosY());
		//4 mando izquierda
		jeds.movCabeza(4);
		Assert.assertEquals(2, jeds.getPosX());
	}
}
