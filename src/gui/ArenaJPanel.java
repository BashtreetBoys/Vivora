package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;
import gameObject.*;

public class ArenaJPanel extends JPanel implements ActionListener {

	private Arena arena;
	private Timer t = new Timer(80, this);
	private Vibora vibora;
	private Vibora vibora2;
	private Fruta fruta;
	private Cuerpo cuerpo;
	int keyCodeRegistrado;
	private ArrayList<Obstaculo> obs;
	int lv = 1;

	public ArenaJPanel(Arena a) {
		setBackground(Color.BLACK);
		arena = a;
		cuerpo = new Cuerpo(0,0);
		vibora = new Vibora(0, 0);
		vibora2 = new Vibora(0, 0);
		arena.agregarVibora(this.vibora);
		arena.agregarVibora(this.vibora2);
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
	
	}

	private void pintarObstaculos(Graphics g) {
		g.setColor(Color.BLUE);
//		El problema por el cual no pintaba los obstaculos era porque 
//		los valores estaban mal definidos (Xini, Yini, Xfin, Yfin)
//		Arreglar mas tarde para pintarlos
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
		g.setColor(new Color(255, 0, 0));
		g.fillRect(v.getCabeza().getPosX(), v.getCabeza().getPosY(), Arena.TAM_GRAFICOS, Arena.TAM_GRAFICOS);

		g.setColor(new Color(255, 0, 0));
		for (Cuerpo pedacitoCuerpo : v.getCuerpito()) {
			g.fillRect(pedacitoCuerpo.getPosX(), pedacitoCuerpo.getPosY(), Arena.TAM_GRAFICOS, Arena.TAM_GRAFICOS);
		}
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
		if (!vibora.isViva()) {
=======
		if(!vibora.isViva()) {
	
>>>>>>> chocarVibora
			t.stop();
			System.out.println("Se te murio la vibora");
		}

		vibora.moverVibora(keyCodeRegistrado);

		Object obj = arena.verColision(vibora.getCabeza().getPosX(), vibora.getCabeza().getPosY());
<<<<<<< HEAD

		if (obj == fruta)
			arena.colisionarFruta(vibora);
		else if (obj != null)
			arena.colisionarConViboraOObstaculo(vibora);
		int cont = 0;
		if (lv < 3) {
			if (arena.getCantidadFrutas() > 3) {
						
				arena.setLv(++lv);
				arena.cambiarNivel();
			}
		}

=======
		
		if (obj == fruta) arena.colisionarFruta(vibora);
		else if (obj != null && obj.getClass() == vibora.getClass() ) {
			
			arena.colisionarConViboraOObstaculo(obj);
			arena.colisionarConViboraOObstaculo(vibora);
		}
		else if(obj != null && obj.getClass() == cuerpo.getClass()) {

			arena.colisionarConViboraOObstaculo(vibora);
		}
		else if(obj!=null)
			arena.colisionarConViboraOObstaculo(vibora);

			
		
>>>>>>> chocarVibora
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

	public void setKeyCodeRegistrado(KeyEvent e) {

	}
}
