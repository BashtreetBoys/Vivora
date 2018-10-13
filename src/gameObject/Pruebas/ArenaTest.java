package gameObject.Pruebas;
import org.junit.Test;

import java.util.ArrayList;

import org.junit.Assert;
import gameObject.Arena;
import gameObject.Vibora;
import gameObject.Obstaculo;
public class ArenaTest {
	
	
	
	@Test
	public void AgregoElementos() {
	Vibora nueva = new Vibora (3,3);
	Vibora nueva2 = new Vibora(4,9);
	
	Arena bg = new Arena ();
	
	bg.setLv(1);

	
	bg.cambiarNivel();
	bg.agregarVibora(nueva);
	Assert.assertEquals(1, bg.getViboras().size());
	
	Assert.assertEquals(4, bg.getObstaculos().size());
	/**
	 * Corregir que pasa cuando agrego viboras antes de cambiar de nivel, parece que no le esta gustando la recorrida 
	 * que hacen con la copia, entra en un loop infinito
	 */
	
	
	}
	
	@Test
	public void cambioDeNivelObstaculos() {
		Arena arenita = new Arena();
		ArrayList<Obstaculo> obs = new ArrayList<Obstaculo>();
		
		obs.clear();
		obs.add(new Obstaculo(1,1,100,1));
		obs.add(new Obstaculo(100,2,100,100));
		obs.add(new Obstaculo(99,100,1,100));
		obs.add(new Obstaculo(1,99,1,2));
		arenita.setObstaculos(obs);
		
		Assert.assertEquals(1, arenita.getLv());
		int i = 0;
		for(Obstaculo ob : obs) {
			Assert.assertEquals(obs.get(i).getPosXfin(),arenita.getObstaculos().get(i).getPosXfin(),0.0);
			Assert.assertEquals(obs.get(i).getPosYfin(),arenita.getObstaculos().get(i).getPosYfin(),0.0);
			Assert.assertEquals(obs.get(i).getPosXini(),arenita.getObstaculos().get(i).getPosXini(),0.0);
			Assert.assertEquals(obs.get(i).getPosYini(),arenita.getObstaculos().get(i).getPosYini(),0.0);
			i++;
		
		}

		arenita.setLv(2);
		obs.clear();
		obs.add(new Obstaculo(1,2,3,4));
		obs.add(new Obstaculo(100,2,100,100));
		obs.add(new Obstaculo(99,100,1,100));
		obs.add(new Obstaculo(1,99,1,2));
		arenita.setObstaculos(obs);
		Assert.assertEquals(2, arenita.getLv());
		i = 0;
		for(Obstaculo ob : obs) {
			Assert.assertEquals(obs.get(i).getPosXfin(),arenita.getObstaculos().get(i).getPosXfin(),0.0);
			Assert.assertEquals(obs.get(i).getPosYfin(),arenita.getObstaculos().get(i).getPosYfin(),0.0);
			Assert.assertEquals(obs.get(i).getPosXini(),arenita.getObstaculos().get(i).getPosXini(),0.0);
			Assert.assertEquals(obs.get(i).getPosYini(),arenita.getObstaculos().get(i).getPosYini(),0.0);
			i++;
		
		}
	}
	
}
