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
	private JPanel panelContenedor;
	
	public ArenaVentana() {
		super("Arena");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0,1100,689);
		setResizable(false);
		//setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		crearComponentes();
		
		//En caso de no querer limitar el tamaño de la arena usar el siguiente 
		//codigo comentado y comentar todos los add que siguen 
		/*
		setContentPane(panelArena);
		 */
		
		setContentPane(panelArena);
		
//		panelContenedor.add(Box.createRigidArea(new Dimension(240, 0)));
//		panelContenedor.add(panelArena);
//		panelContenedor.add(Box.createRigidArea(new Dimension(240, 0)));
		
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
		panelArena.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelArena.setLayout(new BorderLayout(0, 0));
		panelArena.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		panelContenedor = new JPanel();
		panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.X_AXIS));
		panelContenedor.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelContenedor.setBackground(new Color(27, 27, 28));
	}
}
