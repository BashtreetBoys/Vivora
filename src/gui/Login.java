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
		new Login(new CardLayout(), new JPanel()).setVisible(true);
	}

	private CardLayout clContenedora;
	private JPanel panelContenedor;
	private JPanel panelLogin;

	public Login(CardLayout clContenedora, JPanel panelContenedor) {
		super("Login");
		setSize(350, 275);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		this.clContenedora = clContenedora;
		this.panelContenedor = panelContenedor;

		placeComponents();
		setContentPane(panelLogin);
	}

	private void placeComponents() {

		panelLogin = new JPanel();
		panelLogin.setLayout(null);
//		panelLogin.setBorder(new EmptyBorder(0, 0, 0, 0));
//		panelLogin.setLayout(new BoxLayout(panelLogin, BoxLayout.Y_AXIS));

//		Dimension maxSizeLabel = new Dimension(100, 20);
//		Dimension maxSizeText = new Dimension(200, 30);
//		Dimension maxSizeButton = new Dimension(150, 40);

		JLabel userLabel = new JLabel("User");
//		userLabel.setMaximumSize(maxSizeLabel);
//		userLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		userLabel.setBounds(10, 0, 80, 25);

		panelLogin.add(userLabel);

		JTextField userText = new JTextField(20);
//		userText.setMaximumSize(maxSizeText);
//		userText.setAlignmentX(Component.CENTER_ALIGNMENT);
		userText.setBounds(10, 25, 200, 30);

		panelLogin.add(userText);

		JLabel passwordLabel = new JLabel("Password");
//		passwordLabel.setMaximumSize(maxSizeLabel);
//		passwordLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		passwordLabel.setBounds(10, 65, 120, 25);

		panelLogin.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
//		passwordText.setMaximumSize(maxSizeText);
//		passwordText.setAlignmentX(Component.CENTER_ALIGNMENT);
		passwordText.setBounds(10, 90, 200, 30);

		panelLogin.add(passwordText);

		JButton loginButton = new JButton("Loguearse");
//		loginButton.setMaximumSize(maxSizeButton);
//		loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		loginButton.setBounds(35, 135, 150, 40);

		panelLogin.add(loginButton);

		JButton registerButton = new JButton("Registrarse");
//		registerButton.setMaximumSize(maxSizeButton);
//		registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		registerButton.setBounds(35, 185, 150, 40);

		panelLogin.add(registerButton);

		//RegistrarUsuario regUser = new RegistrarUsuario();
		ConexionHibernate conexion = new ConexionHibernate();

		ActionListener listenerLoguearse = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				String user = new String(userText.getText());
				String pass = new String(passwordText.getPassword());

				if (conexion.verSiExiste(user, pass)) {
					JOptionPane.showMessageDialog(Login.this, "Bienvenido/a " + user, "Logeo exitoso",
							JOptionPane.PLAIN_MESSAGE);
					Login.this.dispose();
					clContenedora.show(panelContenedor, "Menu");
				} else
					JOptionPane.showMessageDialog(source, "No existe ese usuario con esa contraseña");
			}
		};

		ActionListener listenerRegistrarse = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// JButton source = (JButton) e.getSource();
				//regUser.setVisible(true);
			}
		};
		loginButton.addActionListener(listenerLoguearse);
		registerButton.addActionListener(listenerRegistrarse);
	}
}