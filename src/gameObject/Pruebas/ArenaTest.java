package gameObject.Pruebas;
import org.junit.Test;

import java.util.ArrayList;

import org.junit.Assert;
import gameObject.Arena;
import gameObject.Vibora;
import gameObject.Obstaculo;
public class ArenaTest {
	
	
	
	@Test
	public void AgregoVibora() {
	Vibora nueva = new Vibora (3,3);
	Vibora nueva2 = new Vibora(4,9);
	Vibora nueva3 = new Vibora(10,11);
	
	Arena bg = new Arena ();
	bg.setLv(1);

	bg.agregarVibora(nueva);
	Assert.assertEquals(1, bg.getViboras().size());
	bg.agregarVibora(nueva2);
	bg.agregarVibora(nueva3);
	Assert.assertEquals(3, bg.getViboras().size());
	
	}
	
	@Test
	public void cambioDeNivel() {
		Arena arenita = new Arena();
		ArrayList<Obstaculo> obs = new ArrayList<Obstaculo>();
		
		obs.clear();
		obs.add(new Obstaculo(1, 1, 100, 1));
		obs.add(new Obstaculo(100, 2, 100, 100));
		obs.add(new Obstaculo(99, 100, 1, 100));
		obs.add(new Obstaculo(1, 99, 1, 2));
		
		arenita.setLv(1);
		arenita.cambiarNivel();
		
		
		Assert.assertEquals(1, arenita.getLv());
		
		int i = 0;
		for(Obstaculo ob : obs) {
			Assert.assertEquals(ob.getPosXfin(),arenita.getObstaculos().get(i).getPosXfin(),0.0);
			Assert.assertEquals(ob.getPosYfin(),arenita.getObstaculos().get(i).getPosYfin(),0.0);
			Assert.assertEquals(ob.getPosXini(),arenita.getObstaculos().get(i).getPosXini(),0.0);
			Assert.assertEquals(ob.getPosYini(),arenita.getObstaculos().get(i).getPosYini(),0.0);
			i++;
		
		}

		arenita.setLv(2);
		arenita.cambiarNivel();
		obs.clear();
		obs.add(new Obstaculo(1, 1, 100, 1));
		obs.add(new Obstaculo(100, 2, 100, 100));
		obs.add(new Obstaculo(99, 100, 1, 100));
		obs.add(new Obstaculo(1, 99, 1, 2));
		obs.add(new Obstaculo(20, 50, 80, 50));
		Assert.assertEquals(2, arenita.getLv());
		i = 0;
		for(Obstaculo ob : obs) {
			Assert.assertEquals(ob.getPosXfin(),arenita.getObstaculos().get(i).getPosXfin(),0.0);
			Assert.assertEquals(ob.getPosYfin(),arenita.getObstaculos().get(i).getPosYfin(),0.0);
			Assert.assertEquals(ob.getPosXini(),arenita.getObstaculos().get(i).getPosXini(),0.0);
			Assert.assertEquals(ob.getPosYini(),arenita.getObstaculos().get(i).getPosYini(),0.0);
			i++;
		
		}
		
	}
	
}