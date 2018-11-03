package Hibernate;
import org.junit.*;

public class HibernateAppTest {

	@Test
	public void testAgregar() {
		HibernateApp ha = new HibernateApp();
		
		Usuario user = new Usuario("ElPipa","taloko");
		Usuario user2 = new Usuario("ElWancho","PalermoHijo");
		
		Assert.assertEquals(true,ha.registrarUsuario(user));
		
	}

}
