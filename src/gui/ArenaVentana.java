package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import gameObject.*;

public class ArenaVentana extends JFrame {
	
	private ArenaJPanel panelArena;
	private Arena arena;
	
	public ArenaVentana() {
		super("Arena");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension tamPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, tamPantalla.width, tamPantalla.height); 
		
		crearComponentes();
		setContentPane(panelArena);
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				panelArena.moverVibora(e.getKeyCode());
			}
		});
	}
	
	private void crearComponentes() {
		arena = new Arena();
		panelArena = new ArenaJPanel(arena);
		panelArena.setBackground(Color.BLACK);
		panelArena.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelArena.setBounds(0, 0, arena.getTamaño(), arena.getTamaño());
		panelArena.setLayout(new BorderLayout(0, 0));
	}
}
