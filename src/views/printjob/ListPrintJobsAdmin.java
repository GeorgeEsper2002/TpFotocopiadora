package views.printjob;

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

import models.User;
import persistence.DataUser;
import service.PrintJobService;
import service.UserService;
import views.user.UserView;

// Hacer vista tipo tabla para listar trabajos
public class ListPrintJobsAdmin implements ActionListener {

	private JFrame frame;
	private JPanel buttons;
	private JButton deletePrintJob, back;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scroll;
	private User currentUser;

	public ListPrintJobsAdmin(String userName) {

		currentUser = DataUser.getLoggedUser(userName);
		String[][] jobs = PrintJobService.listPrintJob();
		frame = new JFrame("Listar Trabajos-");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		Toolkit screen = Toolkit.getDefaultToolkit();
		Dimension dimension = screen.getScreenSize();

		frame.setSize(800, 600);
		back = new JButton("Atras");
		deletePrintJob = new JButton("Eliminar trabajo seleccionado");
		back.setFocusable(false);
		deletePrintJob.setFocusable(false);
		buttons = new JPanel();
		buttons.add(back);
		buttons.add(deletePrintJob);

		scroll = new JScrollPane();

		deletePrintJob.addActionListener(this);
		back.addActionListener(this);

		String titles[] = { "Id", "Descripcion", "Estado", "Calidad", "Fecha de entrada", "Fecha Finalizacion",
				"Fecha de entrega", "Usuario", "Encargado" };
		model = new DefaultTableModel(jobs, titles);

		table = new JTable(model);

		table.setBounds(10, 50, 480, 250);
		table.setRowSelectionAllowed(true); // Allow row selection
		table.getTableHeader().setReorderingAllowed(false); // Disable column reordering

		scroll.setBounds(10, 50, 480, 250);

		scroll.setViewportView(table);


		frame.setLayout(new BorderLayout());
		frame.add(scroll, BorderLayout.CENTER);
		frame.add(buttons, BorderLayout.SOUTH);

		frame.add(scroll);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == back) {
			frame.dispose();
			UserView user = new UserView(currentUser.getName());

		}
	}

}
