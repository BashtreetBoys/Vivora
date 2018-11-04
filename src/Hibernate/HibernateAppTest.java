package Hibernate;
import org.junit.*;

public class HibernateAppTest {

	@Test
	public void testAgregar() throws Exception {
		HibernateApp ha = new HibernateApp();
		
		ContactoDao user = new ContactoDao("ElPipa","taloko");
		ContactoDao user2 = new ContactoDao("ElWancho","PalermoHijo");
		Assert.assertEquals(true,ha.consultarUsuario(user));
		
	}

}
