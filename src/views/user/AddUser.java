package views.user;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import service.UserService;
import views.admin.AdminView;

// Window to create users
public class AddUser implements ActionListener {

	private JFrame frame;
	private JTextField txtName, txtPass;
	private JLabel lblName, lblPass, lblRole, lblState;
	private JComboBox<String> comboRole, comboState;
	private JButton create, clear, back;

	public AddUser() {

		frame = new JFrame();
		frame.setTitle("Ventana Agregar Usuarios");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Toolkit screen = Toolkit.getDefaultToolkit();
		Dimension dimension = screen.getScreenSize();

		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);

		Image icon = screen.getImage("src/views/java.png");
		frame.setIconImage(icon);

		// Base panel
		JPanel basePanel = new JPanel(new BorderLayout());

		// Specific panel for adding users
		JPanel addUserPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0; 
		lblName = new JLabel("Nombre:");
		addUserPanel.add(lblName, gbc);

		gbc.gridx = 1;
		txtName = new JTextField(20);
		addUserPanel.add(txtName, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		lblPass = new JLabel("Contraseña:");
		addUserPanel.add(lblPass, gbc);

		gbc.gridx = 1;
		txtPass = new JTextField(20);
		addUserPanel.add(txtPass, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		lblRole = new JLabel("Rol:");
		addUserPanel.add(lblRole, gbc);

		gbc.gridx = 1;
		String[] roles = { "User", "Admin" };
		comboRole = new JComboBox<>(roles);
		addUserPanel.add(comboRole, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		lblState = new JLabel("Estado:");
		addUserPanel.add(lblState, gbc);

		gbc.gridx = 1;
		String[] states = { "Activado", "Desactivado" };
		comboState = new JComboBox<>(states);
		addUserPanel.add(comboState, gbc);

		// Buttons panel
		JPanel buttonsPanel = new JPanel(new FlowLayout());
		create = new JButton("Crear");
		create.setFocusable(false);
		create.addActionListener(this);
		buttonsPanel.add(create);

		clear = new JButton("Limpiar");
		clear.setFocusable(false);
		clear.addActionListener(this);
		buttonsPanel.add(clear);

		back = new JButton("Atras");
		back.setFocusable(false);
		back.addActionListener(this);
		buttonsPanel.add(back);

		// Add specific panel and buttons panel to base panel
		basePanel.add(addUserPanel, BorderLayout.CENTER);
		basePanel.add(buttonsPanel, BorderLayout.SOUTH);

		// Add base panel to frame
		frame.add(basePanel);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == create) {
			String answer = UserService.createUser(txtName.getText(), txtPass.getText(),
					comboRole.getSelectedItem().toString());
			JOptionPane.showMessageDialog(null, answer);

		} else if (e.getSource() == clear) {
			clearText();
		} else if (e.getSource() == back) {
			frame.dispose();
			AdminView admin = new AdminView();
		}
	}

	public void clearText() {
		txtName.setText("");
		txtPass.setText("");
	}

}
