package gameObject.Pruebas;

import gameObject.Vibora;
import gameObject.Cuerpo;
import gameObject.Cabeza;
import org.junit.Test;

import java.util.ArrayList;

import org.junit.Assert;

public class VivoraTest {
	@Test
	public void crearViboras(){
		Vibora vib = new Vibora(1,1);
		
		Cabeza cabecita = new Cabeza(20);
		cabecita.setPosX(1);
		cabecita.setPosY(1);
		
		ArrayList<Cuerpo> cuerpito = new ArrayList<Cuerpo>();
		cuerpito.add(new Cuerpo(cabecita.getPosX(),cabecita.getPosY()-1));
		cuerpito.add(new Cuerpo(cabecita.getPosX(),cabecita.getPosY()-2));
		
		vib.setVibora(1, 1, 1);
		//Ver si puso bien la velocidad inicial de la vibora
		Assert.assertEquals(2, vib.getVelocidad());
		
		//Ver si creo a la vibora viva
		Assert.assertEquals(true, vib.isViva());
		
		//Ver si instancio bien la cabeza de la vibora
		Assert.assertEquals(cabecita.getPosX(), vib.getCabeza().getPosX(),0.0);
		Assert.assertEquals(cabecita.getPosY(), vib.getCabeza().getPosY(),0.0);
		
		//Ver si puso bien los cuerpitos iniciales segun la direccion de la vibora
		Assert.assertEquals(cuerpito.get(0).getPosX(), vib.getCuerpito().get(0).getPosX());
		Assert.assertEquals(cuerpito.get(1).getPosX(), vib.getCuerpito().get(1).getPosX());
		Assert.assertEquals(cuerpito.get(0).getPosY(), vib.getCuerpito().get(0).getPosY());
		Assert.assertEquals(cuerpito.get(1).getPosY(), vib.getCuerpito().get(1).getPosY());
	}
	
	@Test
	
	public void achicarVibora(){
		Vibora vib = new Vibora(1,1);
		
		Cabeza cabecita = new Cabeza(20);
		cabecita.setPosX(1);
		cabecita.setPosY(1);
		
		ArrayList<Cuerpo> cuerpito = new ArrayList<Cuerpo>();
		cuerpito.add(new Cuerpo(cabecita.getPosX(),cabecita.getPosY()-1));
		cuerpito.add(new Cuerpo(cabecita.getPosX(),cabecita.getPosY()-2));
		
		vib.setVibora(1, 1, 1);
				
		//Ver tamaño inicial de la vibora
		Assert.assertEquals(2, vib.getCuerpito().size());
		//Agrando a la vibora en un cuerpito
		vib.crecer();
		Assert.assertEquals(3, vib.getCuerpito().size());
	}
	
@Test
	
	public void resetarVibora(){
		Vibora vib = new Vibora(1,1);
		
		Cabeza cabecita = new Cabeza(20);
		cabecita.setPosX(1);
		cabecita.setPosY(1);
		
		ArrayList<Cuerpo> cuerpito = new ArrayList<Cuerpo>();
		cuerpito.add(new Cuerpo(cabecita.getPosX(),cabecita.getPosY()-1));
		cuerpito.add(new Cuerpo(cabecita.getPosX(),cabecita.getPosY()-2));
		
		vib.setVibora(1, 1, 1);
		vib.crecer();
		vib.crecer();		
		//Ver tamaño inicial de la vibora
		Assert.assertEquals(4, vib.getCuerpito().size());
				
		//Ver tamaño luego de resetear vibora
		vib.resetearCuerpo();
		Assert.assertEquals(2, vib.getCuerpito().size());		
	}

@Test

	public void matarVibora(){
	Vibora vib = new Vibora(1,1);
	
	Cabeza cabecita = new Cabeza(20);
	cabecita.setPosX(1);
	cabecita.setPosY(1);
	
	ArrayList<Cuerpo> cuerpito = new ArrayList<Cuerpo>();
	cuerpito.add(new Cuerpo(cabecita.getPosX(),cabecita.getPosY()-1));
	cuerpito.add(new Cuerpo(cabecita.getPosX(),cabecita.getPosY()-2));
	
	vib.setVibora(1, 1, 1);
	vib.crecer();
	vib.crecer();	
	
	//Ver si esta la vibora viva
	Assert.assertEquals(true, vib.isViva());
	vib.morir();
	//Ver si murio la vibora
	Assert.assertEquals(false, vib.isViva());
	}

}
