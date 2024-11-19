package views.user;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.User;
import persistence.DataBaseLogic;
import service.UserService;
import views.admin.AdminView;

//Hacer tipo tabla la vista de listar usuarios
public class ListUsers implements ActionListener {

	private JFrame frame;
	private JPanel buttons;
	private JButton  back, edit;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scroll;

	public ListUsers() {
		String[][] users = UserService.listUsers();
		frame = new JFrame("Listar Usuarios");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		Toolkit screen = Toolkit.getDefaultToolkit();
		Dimension dimension = screen.getScreenSize();

		frame.setSize(800, 600);

		// Buttons
		back = new JButton("Atras");
		edit = new JButton("Editar");
		back.setFocusable(false);

		// events
		back.addActionListener(this);
		edit.addActionListener(this);

		// Panel to add buttons
		buttons = new JPanel();
		buttons.add(back);
		buttons.add(edit);

		scroll = new JScrollPane();

		String titles[] = { "Usuario", "Estado", "Rol" };
		model = new DefaultTableModel(users, titles);

		table = new JTable(model);
		table.setRowSelectionAllowed(true); // Allow row selection
		table.getTableHeader().setReorderingAllowed(false); // Disable column reordering

		scroll.setViewportView(table);

		frame.setLayout(new BorderLayout());
		frame.add(scroll, BorderLayout.CENTER);
		frame.add(buttons, BorderLayout.SOUTH);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == back) {
			frame.dispose();
			AdminView admin = new AdminView();
		} else if (e.getSource() == edit) {
			// Logic missing
			System.out.println("editar Usuario");
			int selectedRow = table.getSelectedRow();
			if (selectedRow != -1) {
				String userName = (String) model.getValueAt(selectedRow, 0); // Nombre de usuario
				String currentRole = (String) model.getValueAt(selectedRow, 2); // Rol
				String currentState = (String) model.getValueAt(selectedRow, 1); // Estado
				boolean newState;
				// Pedir los nuevos valores
				String newRole = (String) JOptionPane.showInputDialog(frame, "Ingrese el nuevo rol:", "Editar Rol",
						JOptionPane.QUESTION_MESSAGE, null, new String[] { "Admin", "User" }, currentRole);

				if (newRole == null) {
					return; // Si el usuario cancela, no hacer nada
				}

				String newStateString = (String) JOptionPane.showInputDialog(frame, "Ingrese el nuevo estado:",
						"Editar Estado", JOptionPane.QUESTION_MESSAGE, null, new String[] { "Activo", "Inactivo" },
						currentState);
				if (newStateString == null) {
					return; // Si el usuario cancela, no hacer nada
				}
				if (newStateString.equals("Activo")) {
					newState = true;

				} // Convertir el estado a booleano
				else {
					newState = false;
				}

				// Editar el usuario en la base de datos (usando el servicio correspondiente)
				User editedUser = DataBaseLogic.editUser(userName, newRole, newState);
				DataBaseLogic.saveUser(editedUser);
				// Actualizar la tabla
				model.setValueAt(newRole, selectedRow, 2); // Actualizar rol
				model.setValueAt(newState ? "Activo" : "Inactivo", selectedRow, 1); // Actualizar estado

				// Opcional: Mostrar mensaje de éxito
				JOptionPane.showMessageDialog(frame, "Usuario actualizado con éxito.");
			} else {
				JOptionPane.showMessageDialog(frame, "Seleccione un usuario para editar.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}

}
