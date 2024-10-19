package views;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

public class LoginFrame extends JFrame {
	
	
	private JTextField user;
	private JTextField pass;
	
	
	public LoginFrame() {
		
		
		//setSize(500,300);
		//setLocation(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Trabajo Fotocopiadora");
		//setResizable(false);
		//setExtendedState(Frame.MAXIMIZED_BOTH);
		
		Toolkit screen = Toolkit.getDefaultToolkit();
		Dimension dimension= screen.getScreenSize();

		setSize(dimension.width/2,dimension.height/2);
		setLocation(dimension.width/4,dimension.height/4);
		
		Image icon=screen.getImage("src/views/java.png");
		setIconImage(icon);
		
		// Main panel
		
		JPanel panel=new JPanel();
		panel.setLayout(null);
		
		// Etiqueta para usuario
		
		JLabel lblUser=new JLabel("Usuario:");
		lblUser.setBounds(20,20,80,25);
		panel.add(lblUser);
		
		
		// Campo de texto para ingresar Usuario
        user = new JTextField(20);
        user.setBounds(100, 20, 160, 25);
        panel.add(user);

        // Etiqueta para Contraseña
        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(20, 50, 80, 25);
        panel.add(lblPass);

        // Campo de texto para ingresar Contraseña
        pass = new JPasswordField(20);
        pass.setBounds(100, 50, 160, 25);
        panel.add(pass);

        // Botón de Login
        JButton btnLogin = new JButton("Aceptar");
        btnLogin.setBounds(100, 85, 80, 25);
        panel.add(btnLogin);
		
        add(panel);
		
	}
		
	
		
	
}
