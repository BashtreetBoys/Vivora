package gui;
import gameObject.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
	
	private JPanel panelPrincipal;
	private JPanel panelMenu;
	private JButton singlePlayer;
	private SinglePlayerJPanel singlePlayerPanel;
	private JButton multiPlayer;
	private MultiPlayerJPanel multiPlayerPanel;
	private JLabel tituloJuego;
	private CardLayout cl; 
	private JButton atras;

	public Ventana() {
		super("Vivora chota");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		//setBounds(100, 100, 800, 500);
		setExtendedState(this.MAXIMIZED_BOTH);
				
		crearComponentes();
		crearLayout();
		
		setContentPane(panelPrincipal);
		
		panelMenu.add(Box.createRigidArea(new Dimension(0, 20)));
		panelMenu.add(tituloJuego);
		panelMenu.add(Box.createRigidArea(new Dimension(0, 50)));
		panelMenu.add(singlePlayer);
		panelMenu.add(Box.createRigidArea(new Dimension(0, 20)));
		panelMenu.add(multiPlayer);
		
		cl.show(panelPrincipal, "Menu");
}
	
	private void crearLayout() {
		cl = new CardLayout();
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelPrincipal.setLayout(cl);
		
		panelMenu = new JPanel();
		panelMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelMenu.setBackground(new Color(51));
		panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));
		
		singlePlayerPanel = new SinglePlayerJPanel();	//Ahora mismo no tiene nada
		singlePlayerPanel.add(atras);
		multiPlayerPanel = new MultiPlayerJPanel();	//Ahora mismo no tiene nada
		
		panelPrincipal.add(panelMenu, "Menu");
		panelPrincipal.add(singlePlayerPanel, "Singleplayer");
		panelPrincipal.add(multiPlayerPanel, "Multiplayer");
}
	
	private void crearComponentes() {
		tituloJuego = new JLabel();
		tituloJuego.setAlignmentX(Component.CENTER_ALIGNMENT);
		tituloJuego.setIcon(new ImageIcon("recursos\\Titulo.png"));
		
		Dimension maxSize = new Dimension(200, 50);
		singlePlayer = new JButton("Singleplayer");
		singlePlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
		singlePlayer.setMaximumSize(maxSize);
		singlePlayer.addActionListener(new BotonActionListener());
		
		multiPlayer = new JButton("Multiplayer");
		multiPlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
		multiPlayer.setMaximumSize(maxSize);
		multiPlayer.addActionListener(new BotonActionListener());
		
		atras = new JButton("Atras");
		atras.setAlignmentX(Component.CENTER_ALIGNMENT);
		atras.setMaximumSize(maxSize);
		atras.addActionListener(new BotonActionListener());
	}
	
	private void lanzarSinglePlayer() {
		cl.show(panelPrincipal, "Singleplayer");
		//System.out.println("Falta implementar el lanzador de singleplayer");
	}
	
	private void lanzarMultiPlayer() {
		cl.show(panelPrincipal, "Multiplayer");
		System.out.println("Falta implementar el lanzador de multiplayer");
	}
	
	private class BotonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() instanceof JButton) {
				JButton boton = (JButton) e.getSource();
				
				if(boton == singlePlayer)
					Ventana.this.lanzarSinglePlayer();
				else if(boton == multiPlayer)
					Ventana.this.lanzarMultiPlayer();
				else {
					cl.first(panelPrincipal);					
				}
					
			}
		}
	}

	public static void main(String[] args) {
		new Ventana().setVisible(true);
	}
}
