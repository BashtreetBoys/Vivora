package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

import org.hibernate.mapping.Collection;

import gameObject.*;

public class ArenaJPanel extends JPanel implements ActionListener {

	private Arena arena;
	private Timer t = new Timer(80, this);
	private Vibora vibora;
	private Vibora vibora2,vibora3;
	private Fruta fruta;
	private Cuerpo cuerpo;
	int keyCodeRegistrado;
	private ArrayList<Obstaculo> obs;
	int lv = 1;
	ArrayList<Color> listaColores = new ArrayList<Color>(); 

	public ArenaJPanel(Arena a) {

		listaColores.add(new Color(204, 102, 255));
		listaColores.add(new Color(204, 51, 255));
		listaColores.add(new Color(255, 102, 102));
		listaColores.add(new Color(255, 77, 77));
		listaColores.add(new Color(77, 255, 136));
		listaColores.add(new Color(0, 179, 60));
		listaColores.add(new Color(51, 133, 255));
		listaColores.add(new Color(26, 117, 255));
		listaColores.add(new Color(230, 46, 0));
		listaColores.add(new Color(204, 41, 0));
		listaColores.add(new Color(255, 184, 77));
		listaColores.add(new Color(255, 153, 0));
		listaColores.add(new Color(0, 255, 255));
		listaColores.add(new Color(0, 179, 179));
//		Collections.shuffle(listaColores);
		
		setBackground(Color.BLACK);		
		arena = a;
		cuerpo = new Cuerpo(0,0);
		vibora = new Vibora(0, 0);
		vibora2 = new Vibora(0, 0);
		vibora3 = new Vibora(0, 0);
		vibora.setColorCabeza(listaColores.get(10));
		vibora.setColorCuerpo(listaColores.get(11));
		vibora2.setColorCabeza(listaColores.get(12));
		vibora2.setColorCuerpo(listaColores.get(13));
		vibora3.setColorCabeza(listaColores.get(0));
		vibora3.setColorCuerpo(listaColores.get(1));
		arena.agregarVibora(this.vibora);
		arena.agregarVibora(this.vibora2);
		arena.agregarVibora(this.vibora3);
		arena.cambiarNivel();
		fruta = arena.getFrutaActual();

		obs = arena.getObstaculos();

		this.keyCodeRegistrado = aKeyCode(vibora.getDireccion());

		t.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		/* Aca pinto los obstaculos */
		pintarObstaculos(g);

		/* Aca pinto la fruta */
		pintarFruta(g);

		/* A partir de aca pinto la serpiente */
		pintarVibora(g,this.vibora);
		pintarVibora(g,this.vibora2);
		pintarVibora(g,this.vibora3);
	}

	private void pintarObstaculos(Graphics g) {
		g.setColor(Color.BLUE);
		for (Obstaculo obstaculo : obs) {
			g.fillRect(obstaculo.getPosXini(), obstaculo.getPosYini(), obstaculo.getPosXfin() - obstaculo.getPosXini(),
					obstaculo.getPosYfin() - obstaculo.getPosYini());
		}
	}

	private void pintarFruta(Graphics g) {
		g.setColor(new Color(255, 235, 46));
		g.fillRect(fruta.getPosX(), fruta.getPosY(), Arena.TAM_GRAFICOS, Arena.TAM_GRAFICOS);
	}

	private void pintarVibora(Graphics g,Vibora v) {
		// g.setColor(new Color(255, 83, 76)); si no jode a los ojos dejar este color
		g.setColor(v.getColorCabeza());
		g.fillRect(v.getCabeza().getPosX(), v.getCabeza().getPosY(), Arena.TAM_GRAFICOS, Arena.TAM_GRAFICOS);

		g.setColor(v.getColorCuerpo());
		for (Cuerpo pedacitoCuerpo : v.getCuerpito()) {
			g.fillRect(pedacitoCuerpo.getPosX(), pedacitoCuerpo.getPosY(), Arena.TAM_GRAFICOS, Arena.TAM_GRAFICOS);
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		if (!vibora.isViva()) {

			t.stop();
//			System.out.println("Se te murio la vibora");
		}

		vibora.moverVibora(keyCodeRegistrado);
		
		Object obj = arena.verColision(vibora.getCabeza().getPosX(), vibora.getCabeza().getPosY(),vibora);
	/*	
		if (obj == fruta) //fruta
			arena.colisionarFruta(vibora);
		else if (obj != null && obj.getClass() == vibora.getClass() ) {//dos viboras distintas
			
			arena.colisionarConViboraOObstaculo(obj);
			arena.colisionarConViboraOObstaculo(vibora);
		}
		else if(obj != null && obj.getClass() == cuerpo.getClass()) {//vibora con cuerpo

			arena.colisionarConViboraOObstaculo(vibora);
		}
		else if(obj!=null) //obstaculo
			arena.colisionarConViboraOObstaculo(vibora);
		*/
		arena.inteligenciaArtificial(vibora2,arena.verColision(vibora2.getCabeza().getPosX(), vibora2.getCabeza().getPosY(),vibora2));
		arena.inteligenciaArtificialCuadrado(vibora3,arena.verColision(vibora3.getCabeza().getPosX(), vibora3.getCabeza().getPosY(),vibora3));	
		

		
		repaint();
	}

	public void moverVibora(int keyCode) {
		if (keyCode != aKeyCode(vibora.getDireccion()) && keyCode != aKeyCodeOpuesto(vibora.getDireccion()))
			this.keyCodeRegistrado = keyCode;
	}

	private int aKeyCode(int direccion) {

		if (direccion == 1)
			return KeyEvent.VK_UP;
		else if (direccion == 2)
			return KeyEvent.VK_RIGHT;
		else if (direccion == 3)
			return KeyEvent.VK_DOWN;
		else
			return KeyEvent.VK_LEFT;
	}

	private int aKeyCodeOpuesto(int direccion) {

		if (direccion == 3)
			return KeyEvent.VK_UP;
		else if (direccion == 4)
			return KeyEvent.VK_RIGHT;
		else if (direccion == 1)
			return KeyEvent.VK_DOWN;
		else
			return KeyEvent.VK_LEFT;
	}
}