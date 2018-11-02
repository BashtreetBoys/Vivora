package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SinglePlayerJPanel extends JPanel {

	JButton botonComenzar;
	
	public SinglePlayerJPanel() {
		setBackground(Color.BLACK);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		crearComponentes();
		add(Box.createRigidArea(new Dimension(0, 100)));
		add(botonComenzar);
	}
	
	private void crearComponentes() {
		botonComenzar = new JButton("Comenzar partida");
		botonComenzar.setMaximumSize(new Dimension(200, 50));
		botonComenzar.setAlignmentX(Component.CENTER_ALIGNMENT);
		botonComenzar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comenzarJuego();
			}
		});
	}
	
	private void comenzarJuego() {
		new ArenaVentana().setVisible(true);
	}
}
