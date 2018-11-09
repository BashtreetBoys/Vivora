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
	private JPanel panelLogin;
	
	private JButton atrasButton;
	private JButton loginButton;
	private JButton singlePlayerButton;
	private JButton multiPlayerButton;
	
	private SinglePlayerJPanel singlePlayerPanel;
	private MultiPlayerJPanel multiPlayerPanel;
	
	private JLabel tituloJuego;
	private JLabel tituloJuego2; //Tuve que hacer esto porque 
							     //solo aparecia en 1 solo panel
	
	private CardLayout cl; 

	public Ventana() {
		super("Vivora");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setBounds(300, 100, 800, 500);
		setResizable(false);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
				
		crearComponentes();
		crearLayout();
		
		setContentPane(panelPrincipal);
		
		//cl.show(panelPrincipal, "Menu");
}
	
	private void crearLayout() {
		cl = new CardLayout();
		
		panelPrincipal.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelPrincipal.setLayout(cl);
		
		panelLogin.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelLogin.setBackground(new Color(51));
		panelLogin.setLayout(new BoxLayout(panelLogin, BoxLayout.Y_AXIS));
		panelLogin.add(Box.createRigidArea(new Dimension(0, 20)));
		panelLogin.add(tituloJuego);
		panelLogin.add(Box.createRigidArea(new Dimension(0, 50)));
		panelLogin.add(loginButton);
		
		panelMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelMenu.setBackground(new Color(51));
		panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));
		panelMenu.add(Box.createRigidArea(new Dimension(0, 20)));
		panelMenu.add(tituloJuego2);
		panelMenu.add(Box.createRigidArea(new Dimension(0, 50)));
		panelMenu.add(singlePlayerButton);
		panelMenu.add(Box.createRigidArea(new Dimension(0, 20)));
		panelMenu.add(multiPlayerButton);
		
		singlePlayerPanel.add(atrasButton);
		
		panelPrincipal.add(panelLogin, "Login");
		panelPrincipal.add(panelMenu, "Menu");
		panelPrincipal.add(singlePlayerPanel, "Singleplayer");
		panelPrincipal.add(multiPlayerPanel, "Multiplayer");
}
	
	private void crearComponentes() {
		panelPrincipal = new JPanel();
		panelMenu = new JPanel();
		panelLogin = new JPanel();
		
		tituloJuego = new JLabel();
		tituloJuego.setAlignmentX(Component.CENTER_ALIGNMENT);
		tituloJuego.setIcon(new ImageIcon("recursos\\Titulo.png"));
		
		tituloJuego2 = new JLabel();
		tituloJuego2.setAlignmentX(Component.CENTER_ALIGNMENT);
		tituloJuego2.setIcon(new ImageIcon("recursos\\Titulo.png"));
		
		Dimension maxSize = new Dimension(200, 50);
		atrasButton = new JButton("Atras");
		atrasButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		atrasButton.setMaximumSize(maxSize);
		atrasButton.addActionListener(new BotonActionListener());
		
		loginButton = new JButton("Ingresar");
		loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		loginButton.setMaximumSize(maxSize);
		loginButton.addActionListener(new BotonActionListener());
		
		singlePlayerButton = new JButton("Singleplayer");
		singlePlayerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		singlePlayerButton.setMaximumSize(maxSize);
		singlePlayerButton.addActionListener(new BotonActionListener());
		
		multiPlayerButton = new JButton("Multiplayer");
		multiPlayerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		multiPlayerButton.setMaximumSize(maxSize);
		multiPlayerButton.addActionListener(new BotonActionListener());
		
		singlePlayerPanel = new SinglePlayerJPanel();
		
		multiPlayerPanel = new MultiPlayerJPanel();	//Ahora mismo no tiene nada
	}
	
	private void lanzarSinglePlayer() {
		cl.show(panelPrincipal, "Singleplayer");
	}
	
	private void lanzarMultiPlayer() {
		//cl.show(panelPrincipal, "Multiplayer");
		System.out.println("Falta implementar el lanzador de multiplayer");
	}
	
	private class BotonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() instanceof JButton) {
				JButton boton = (JButton) e.getSource();
				
				if(boton == loginButton) {
					new Login(cl, panelPrincipal).setVisible(true);
				}
				else if(boton == singlePlayerButton)
					Ventana.this.lanzarSinglePlayer();
				else if(boton == multiPlayerButton)
					Ventana.this.lanzarMultiPlayer();
				else
					cl.show(panelPrincipal, "Menu");					
			}
		}
	}

	public static void main(String[] args) {
		new Ventana().setVisible(true);
	}
}
