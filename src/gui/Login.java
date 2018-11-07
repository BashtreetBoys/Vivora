package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {

	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Demo application");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);
		

		frame.setVisible(true);
	}

	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		JButton loginButton = new JButton("login");
		loginButton.setBounds(10, 80, 80, 25);
		panel.add(loginButton);
		
		JButton registerButton = new JButton("register");
		registerButton.setBounds(180, 80, 80, 25);
		panel.add(registerButton);
		
		Ventana ventana = new Ventana();
		
		ActionListener listenerLoguearse = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();				
				if(userText.getText().equals("Cami")) {
					JOptionPane.showMessageDialog(source, "Hola me quiero loguear!");
					
				}
				else {
					JOptionPane.showMessageDialog(source, "No te conozco");
					ventana.setVisible(true);
				}
				
			}
		};
		
		ActionListener listenerRegistrarse = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				JOptionPane.showMessageDialog(source, "Hola me quiero registrar!");
				
			}
		};
		loginButton.addActionListener(listenerLoguearse);
		registerButton.addActionListener(listenerRegistrarse);
	}
	
	
}