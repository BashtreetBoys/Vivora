package gameObject.Pruebas;
import org.junit.Test;
import org.junit.Assert;
import gameObject.Vibora;
import gameObject.Jugador;
import gameObject.Arena;

public class JugadorTest {

	@Test
	public void creoJugador() {
		Vibora mySnake = new Vibora(1,1);
		Jugador newPlayer = new Jugador("TheBo55","Listo",mySnake,"TheBo55esPass");
		Assert.assertEquals(0, newPlayer.getPuntaje());
		Assert.assertEquals(newPlayer.getNombre(),"TheBo55");
	}
	
	public void prueboViboritaJugador() {
		Vibora mySnake = new Vibora(1,1);
		Jugador newPlayer = new Jugador("TheBo55","Listo",mySnake,"TheBo55esPass");
		Arena a = new Arena();
		
		newPlayer.salirDeArena(a);
		
		Vibora theBo55Snake = newPlayer.getVivorita();
		
/**
 * Verifico que la vibora dentro del jugador funcione correctamente y pueda acceder a los metodos
 */
		Assert.assertEquals(2, theBo55Snake.getVelocidad());
		theBo55Snake.moverVibora(2);
		
		
	}
}
