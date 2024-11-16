package views.user;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import persistence.DataUser;
import service.UserService;
import views.admin.AdminView;

//Hacer tipo tabla la vista de listar usuarios
public class ListUsers implements ActionListener {

	private JFrame frame;
	private JPanel buttons;
	private JButton activate, deactivate, makeAdmin, makeUser, back,edit;
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
		activate = new JButton("Activar");
		deactivate = new JButton("Desactivar");
		makeAdmin = new JButton("Hacer Administrador");
		makeUser = new JButton("Hacer Usuario");
		back = new JButton("Atras");
		edit=new JButton("Editar");
		back.setFocusable(false);
		activate.setFocusable(false);
		makeAdmin.setFocusable(false);
		makeUser.setFocusable(false);

		// events
		back.addActionListener(this);
		activate.addActionListener(this);
		deactivate.addActionListener(this);
		makeAdmin.addActionListener(this);
		makeUser.addActionListener(this);
		edit.addActionListener(this);

		// Panel to add buttons
		buttons = new JPanel();
		buttons.add(activate);
		buttons.add(deactivate);
		buttons.add(makeAdmin);
		buttons.add(makeUser);
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
		}
		else if(e.getSource()==makeAdmin) {
			System.out.println("Hacer Admin");
		}
		else if(e.getSource()==makeUser) {
			System.out.println("Hacer Usuario");
		}
		else if(e.getSource()==activate) {
			System.out.println("Activar Usuario");
		}
		else if(e.getSource()==deactivate) {
			System.out.println("Desactivar Usuario");
		}
		else if(e.getSource()==edit) {
			System.out.println("editar Usuario");
		}
	}

}
