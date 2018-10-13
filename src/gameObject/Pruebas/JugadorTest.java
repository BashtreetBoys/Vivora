package gameObject.Pruebas;
import org.junit.Test;
import org.junit.Assert;
import gameObject.Vibora;
import gameObject.Jugador;

public class JugadorTest {

	@Test
	public void creoJugador() {
		Vibora mySnake = new Vibora(1,1);
		Jugador newPlayer = new Jugador("TheBo55","Listo",mySnake,"TheBo55esPass");
		Assert.assertEquals(0, newPlayer.getPuntaje());
	}
}
