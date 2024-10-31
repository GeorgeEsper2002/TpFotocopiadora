package views.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 *	Programar botones de:
 *	
 *	// Referido a usuarios
 *	- Agregar Usuarios
 *
 *	// Referido a los trabajos
 *	- Listar todos los trabajos que hay
 *	- Manipular los trabajos,con su estado
 *	- Ver trabajos que hay POR USUARIO
 * 
 * */
import models.User;
import views.LoginView;

public class AdminView implements ActionListener {

	private JFrame frame;
	public JButton addUsers, listJobs, listUsers, returnToLogin;

	public AdminView() {

		frame = new JFrame();
		frame.setTitle("Admin");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Toolkit screen = Toolkit.getDefaultToolkit();
		Dimension dimension = screen.getScreenSize();

		frame.setSize(dimension.width / 2, dimension.height / 2);
		frame.setLocation(dimension.width / 4, dimension.height / 4);

		Image icon = screen.getImage("src/views/java.png");
		frame.setIconImage(icon);
		
		
		
		JPanel panel = new JPanel(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.insets = new Insets(10, 10, 10, 10);
	    gbc.gridx = 0;
	    gbc.gridy = 0;

	    // Add users
	    addUsers = new JButton("Agregar Usuarios ");
	    addUsers.addActionListener(this);
	    addUsers.setFocusable(false);
	    panel.add(addUsers, gbc);

	    // List Jobs
	    gbc.gridx++;
	    listJobs = new JButton("Listar Trabajos");
	    listJobs.addActionListener(this);
	    listJobs.setFocusable(false);
	    panel.add(listJobs, gbc);

	    // List Users
	    gbc.gridx++;
	    listUsers = new JButton("Listar Usuarios");
	    listUsers.addActionListener(this);
	    listUsers.setFocusable(false);
	    panel.add(listUsers, gbc);

	    // return to login
	    gbc.gridx++;
	    returnToLogin = new JButton("Volver al inicio de sesion");
	    returnToLogin.addActionListener(this);
	    returnToLogin.setFocusable(false);
	    panel.add(returnToLogin, gbc);

		/*
		 * JPanel panel = new JPanel();
		 * 
		 * // Add users addUsers = new JButton("Agregar Usuarios ");
		 * addUsers.addActionListener(this); addUsers.setFocusable(false);
		 * panel.add(addUsers);
		 * 
		 * // List Jobs listJobs = new JButton("Listar Trabajos");
		 * listJobs.addActionListener(this); listJobs.setFocusable(false);
		 * panel.add(listJobs);
		 * 
		 * // List Users listUsers = new JButton("Listar Usuarios");
		 * listUsers.addActionListener(this); listUsers.setFocusable(false);
		 * panel.add(listUsers);
		 * 
		 * // return to login
		 * 
		 * returnToLogin = new JButton("Volver al inicio de sesion");
		 * returnToLogin.addActionListener(this); returnToLogin.setFocusable(false);
		 * panel.add(returnToLogin);
		 */

		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == addUsers) {

			System.out.println("agregar usuarios");
		} else if (e.getSource() == listJobs) {
			System.out.println("Listar trabajos");
		} else if (e.getSource() == listUsers) {
			System.out.println("Listar usuarios");

		} else if (e.getSource() == returnToLogin) {

			System.out.println("volver");
			frame.dispose();
			LoginView login = new LoginView();
		}

	}

}