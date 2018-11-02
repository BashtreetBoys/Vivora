package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import gameObject.*;

public class ArenaJPanel extends JPanel implements ActionListener {
	
	Arena arena;
	Timer t = new Timer(50, this);
	Vibora vibora;
	int keyCodeRegistrado;
	ArrayList<Obstaculo> obs;

	public ArenaJPanel(Arena arena) {
		setBackground(Color.BLACK);
		this.arena = arena;
		this.vibora = new Vibora(0, 0);
		arena.agregarVibora(this.vibora);
		arena.cambiarNivel();
		
		obs = arena.getObstaculos();
		
		this.keyCodeRegistrado = vibora.getDireccion();
		
		t.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		/*Aca pinto los obstaculos*/
		g.setColor(Color.WHITE);
		for (Obstaculo obstaculo : obs) {
			
//			System.out.println("X ini: " + obstaculo.getPosXini() + "\tY ini: " + obstaculo.getPosYini());
//			System.out.println("X ancho: " + (obstaculo.getPosXfin() - obstaculo.getPosXini())
//					+ "\tY alto: " + (obstaculo.getPosYfin() - obstaculo.getPosYini()));
			
			g.fillRect(obstaculo.getPosXini(), obstaculo.getPosYini(),
						obstaculo.getPosXfin() - obstaculo.getPosXini(), 
						obstaculo.getPosYfin() - obstaculo.getPosYini());
		}
		
		/*A partir de aca pinto la serpiente*/
		
		g.setColor(new Color(255, 0, 0));
		g.fillRect(vibora.getCabeza().getPosX(), vibora.getCabeza().getPosY(), 20, 20);
		
		g.setColor(new Color(255, 0, 0));
		for (Cuerpo pedacitoCuerpo : vibora.getCuerpito()) {
			g.fillRect(pedacitoCuerpo.getPosX(), pedacitoCuerpo.getPosY(), 20, 20);
		}	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		moverVibora(keyCodeRegistrado);
		repaint();
	}

	public void moverVibora(int keyCode) {
		vibora.moverVibora(keyCode);
	}
}
