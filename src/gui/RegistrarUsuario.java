package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import connection.ConexionHibernate;

public class RegistrarUsuario extends JFrame {
	
	public static void main(String[] args) {
		new RegistrarUsuario().setVisible(true);;
	}
	
	public RegistrarUsuario() {
		super("Registrar");
		setSize(225, 370);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		add(panel);
		placeComponents(panel);		
	}

	private void placeComponents(JPanel panel) {

		panel.setLayout(null);
		//Dimensiones de los componentes
		
		Dimension maxSizeSep = new Dimension(0,5);
		
		//Usuario label+text
		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel);

		panel.add(Box.createRigidArea(maxSizeSep));
		
		JTextField userText = new JTextField(20);
		userText.setBounds(10, 50, 200, 30);
		panel.add(userText);
		
		//Fin usuario
		
		panel.add(Box.createRigidArea(maxSizeSep));
		
		//Contrase�a label+text
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 80, 80, 25);
		panel.add(passwordLabel);
		
		panel.add(Box.createRigidArea(maxSizeSep));
		
		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(10, 110, 200, 30);
		panel.add(passwordText);
		
		//Fin contrase�a
		panel.add(Box.createRigidArea(maxSizeSep));
		
		//ConfirmarContrase�a label+text
		
		JLabel confirmPasswdLabel = new JLabel("Confirmar Password");
		confirmPasswdLabel.setBounds(10, 150, 120, 25);
		panel.add(confirmPasswdLabel);
		
		panel.add(Box.createRigidArea(maxSizeSep));
		
		JPasswordField confirmPasswdText = new JPasswordField(20);
		confirmPasswdText.setBounds(10, 180, 200, 30);
		panel.add(confirmPasswdText);
		
		//Fin confirmar contrase�a
		
		//Boton registrarse
		JButton registerButton = new JButton("Registrarse");
		registerButton.setBounds(35, 230, 150, 40);
		panel.add(registerButton);
		
		//Fin boton registrarse
		panel.add(Box.createRigidArea(maxSizeSep));
		
		//Boton loguearse
		JButton loginButton = new JButton("Volver al login");
		loginButton.setBounds(35, 280, 150, 40);
		panel.add(loginButton);
		
		//Fin boton loguearse
		
		
		ConexionHibernate conexion = new ConexionHibernate();
		
		ActionListener listenerLoguearse = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				setVisible(false);
			
			}
		};
		
		ActionListener listenerRegistrarse = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				String user = new String(userText.getText());
				String pass = new String(passwordText.getPassword());
				String confPass = new String(confirmPasswdText.getPassword());
				if(!(pass.equals(confPass))){
					JOptionPane.showMessageDialog(source, "Las contrase�as no coinciden");
				}else{
					boolean band = conexion.registrarUsuario(user, pass);
					if(band){
						JOptionPane.showMessageDialog(source, "Se ha registrado su usuario!");
					}
					else{
						JOptionPane.showMessageDialog(source, "Algo sali� mal en el registro de su usuario");
					}
				}
				
			}
		};
		loginButton.addActionListener(listenerLoguearse);
		registerButton.addActionListener(listenerRegistrarse);
		}			
	}

