package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import gameObject.*;

public class ArenaJPanel extends JPanel {
	
	Arena arena;

	public ArenaJPanel(Arena arena) {
		setBackground(Color.BLACK);
		this.arena = arena;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(0, 0, 20, 20);
	}
	
	
	
}
