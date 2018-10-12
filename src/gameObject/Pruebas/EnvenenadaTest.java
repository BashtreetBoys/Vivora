package gameObject.Pruebas;
import org.junit.Test;

import gameObject.Envenenada;
import gameObject.Vibora;

import org.junit.Assert;

import gameObject.Cuerpo;
public class EnvenenadaTest {
	
	@Test
	public void teSacoElCuerpo() {
		Cuerpo parte1 = new Cuerpo(1,1);
		Cuerpo parte2 = new Cuerpo(1,2);
		Vibora nueva =  new Vibora(1,0);
		
		new Envenenada().cambiarEstado(nueva);
		
		
		
	}

}
