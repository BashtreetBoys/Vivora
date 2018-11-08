package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import connection.ConexionHibernate;

public class Login extends JFrame {
	
	public static void main(String[] args) {
		new Login().setVisible(true);
	}

	public Login(){
		super("Login");
		setSize(400, 330);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		add(panel);
		placeComponents(panel);
	}
	
	private void placeComponents(JPanel panel){

		panel.setLayout(null);

		
		Dimension maxSizeSep = new Dimension(0,5);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(40, 20, 80, 25);
		panel.add(userLabel);

		panel.add(Box.createRigidArea(maxSizeSep));
		
		JTextField userText = new JTextField(20);
		userText.setBounds(40, 50, 200, 30);
		panel.add(userText);

		panel.add(Box.createRigidArea(maxSizeSep));
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(40, 90, 120, 25);
		panel.add(passwordLabel);
		
		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(40, 120, 200, 30);
		panel.add(passwordText);

		panel.add(Box.createRigidArea(maxSizeSep));
		
		JButton loginButton = new JButton("Loguearse");
		loginButton.setBounds(65, 180, 150, 40);
		panel.add(loginButton);
		
		panel.add(Box.createRigidArea(maxSizeSep));
		
		JButton registerButton = new JButton("Registrarse");
		registerButton.setBounds(65, 235, 150, 40);
		panel.add(registerButton);
		
		Ventana ventana = new Ventana();
		RegistrarUsuario regUser = new RegistrarUsuario();
		ConexionHibernate conexion = new ConexionHibernate();
		
		ActionListener listenerLoguearse = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();	
				String user = new String(userText.getText());
				String pass = new String(passwordText.getPassword());
				
				
				if(conexion.verSiExiste(user, pass)) {
					ventana.setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(source, "No existe ese usuario con esa contraseña");					
				}
				
			}
		};
		
		ActionListener listenerRegistrarse = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				regUser.setVisible(true);
			}
		};
		loginButton.addActionListener(listenerLoguearse);
		registerButton.addActionListener(listenerRegistrarse);
	}
	
	
}