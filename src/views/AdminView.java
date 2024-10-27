package views;


import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
 *	Programar botones de:
 *	
 *	// Referido a usuarios
 *	- Agregar Usuarios
 *	- Eliminar Usuarios
 *
 *	// Referido a los trabajos
 *	- Listar todos los trabajos que hay
 *	- Manipular los trabajos,con su estado
 *	- Ver trabajos que hay POR USUARIO
 * 
 * */
import models.User;

public class AdminView {
	
	private JFrame frame;
	public JButton jobsButton,addUser,deleteUser,listJobs,listJobsByUser;
	
	public AdminView() {
		
		frame= new JFrame();
		frame.setTitle("Admin");
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit screen = Toolkit.getDefaultToolkit(); 
		Dimension dimension =screen.getScreenSize();
		
		frame.setSize(dimension.width / 2, dimension.height / 2);
		frame.setLocation(dimension.width / 4, dimension.height / 4);
		
		Image icon = screen.getImage("src/views/java.png"); 
		frame.setIconImage(icon);
	}
	

	

}
