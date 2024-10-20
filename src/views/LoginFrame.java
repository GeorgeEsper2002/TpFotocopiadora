package views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginFrame extends JFrame implements ActionListener {
	
	
	private JTextField user;
	private JTextField pass;
	public JButton btnLogin,prueba;
	
	
	

	
	  public LoginFrame() { 

	  	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	setTitle("Trabajo Fotocopiadora");
	  
		  Toolkit screen = Toolkit.getDefaultToolkit(); 
		  Dimension dimension =screen.getScreenSize();
		  
		  setSize(dimension.width / 2, dimension.height / 2);
		  setLocation(dimension.width / 4, dimension.height / 4);
		  
		  Image icon = screen.getImage("src/views/java.png"); setIconImage(icon);
		  
		  // Main panel 
		  JPanel panel = new JPanel(new GridBagLayout());
		  GridBagConstraints gbc = new GridBagConstraints(); 
		  gbc.insets = new Insets(10, 10, 10, 10); 
		  gbc.anchor = GridBagConstraints.CENTER;
		  
		  // Etiqueta para usuario 
		  JLabel lblUser = new JLabel("Usuario:"); 
		  gbc.gridx =0; 
		  gbc.gridy = 0; 
		  panel.add(lblUser, gbc);
		  
		  // Campo de texto para ingresar 
		  JTextField user = new JTextField(20); 
		  gbc.gridx= 1; 
		  gbc.gridy = 0; 
		  panel.add(user, gbc);
		  
		  // Etiqueta para Contraseña 
		  JLabel lblPass = new JLabel("Contraseña:");
		  gbc.gridx = 0; 
		  gbc.gridy = 1; 
		  panel.add(lblPass, gbc);
		  
		  // Campo de texto para ingresar Contraseña 
		  pass = new JPasswordField(20);
		  gbc.gridx = 1; 
		  gbc.gridy = 1; 
		  panel.add(pass, gbc);
		  
		  // Botón de Login 
		  JButton btnLogin = new JButton("Login"); 
		  gbc.gridx = 1;
		  gbc.gridy = 2; 
		  panel.add(btnLogin, gbc);
		  
		  prueba=new JButton("Prueba");
		  panel.add(prueba);
		  prueba.addActionListener(this);
		  btnLogin.addActionListener(this);
		  add(panel); 
		  setVisible(true); 
		  }
		  
	  
	      @Override
		  public void actionPerformed(ActionEvent event) {
			  
			  
	    	  if(event.getSource()==btnLogin) {
	    		  JOptionPane.showMessageDialog(null, "ssssssss");
	    	  }
	    	  if(event.getSource()==prueba) {
	    		  
	    		  JOptionPane.showMessageDialog(null, "Has presionado en prueba");
	    	  }
			  
		  }

		public JTextField getUser() {
			return user;
		}

		public void setUser(JTextField user) {
			this.user = user;
		}


		  
		  
	
		
	
}




