package views;

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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import models.User;
import persistence.DataUser;
import views.admin.AdminView;
import views.user.UserView;

public class LoginView {

	private JFrame frame;
	private JTextField txtUser;
	private JTextField txtPassword;
	public JButton btnLogin;

	public LoginView() {

		frame = new JFrame();
		frame.setTitle("Login");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Toolkit screen = Toolkit.getDefaultToolkit();
		Dimension dimension = screen.getScreenSize();

		frame.setSize(dimension.width / 2, dimension.height / 2);
		frame.setLocation(dimension.width / 4, dimension.height / 4);

		Image icon = screen.getImage("src/views/java.png");
		frame.setIconImage(icon);

		// Main panel
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.anchor = GridBagConstraints.CENTER;

		// Etiqueta para usuario
		JLabel lblUser = new JLabel("Usuario:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(lblUser, gbc);

		// Campo de texto para ingresar
		txtUser = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(txtUser, gbc);

		// Etiqueta para Contraseña
		JLabel lblPass = new JLabel("Contraseña:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(lblPass, gbc);

		// Campo de texto para ingresar Contraseña
		txtPassword = new JPasswordField(20);
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(txtPassword, gbc);

		// Botón de Login
		btnLogin = new JButton("Login");
		btnLogin.setFocusable(false);
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(btnLogin, gbc);

		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				DataUser users = DataUser.getInstance();
				User[] users2 = users.getUserDB();
				
				boolean flag=false;
				
				for(User user:users2) {
					if(user!=null) {
						// Es admin
						if(txtUser.getText().equals(user.getName()) && txtPassword.getText().equals(user.getPassword())){
							if(user.getRole()==0) {
								flag=true;
								frame.dispose();
								AdminView admin=new AdminView();
							}
							else {
								flag=true;
								frame.dispose();
								UserView userView=new UserView();
							}
							
						}
					}
					
				}
				if(!flag) {
					JOptionPane.showMessageDialog(frame, "Contraseña o usuario incorrectos", "ATENCION",JOptionPane.ERROR_MESSAGE);
					clearText();
				}
				
			}

		});

		frame.add(panel);
		frame.setVisible(true);

	}

	// Function to clear the text fields
	private void clearText() {

		txtUser.setText("");
		txtPassword.setText("");

	}
}
