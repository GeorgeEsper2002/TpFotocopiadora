package views.printjob;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import models.PrintJob;
import models.User;
import persistence.DataBaseLogic;
import persistence.DataPrintJobs;
import persistence.DataUser;
import service.PrintJobService;
import views.admin.AdminView;

// Hacer vista tipo tabla para listar trabajos
public class ListPrintJobsAdmin implements ActionListener {

	private JFrame frame;
	private JPanel buttons, editionPanel;
	private JButton deletePrintJob, back, filterByUser, changeState, filterByState, edit;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scroll;
	private JComboBox<String> comboState;
	private User currentUser;

	public ListPrintJobsAdmin(String userName) {

		currentUser = DataUser.getLoggedUser(userName);
		String[][] jobs = PrintJobService.listPrintJob();
		frame = new JFrame("Listar Trabajos-" + userName);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        frame.dispose();
		        new AdminView();
		    }
		});

		Toolkit screen = Toolkit.getDefaultToolkit();
		Dimension dimension = screen.getScreenSize();

		frame.setSize(800, 600);

		// Return to previous window
		back = new JButton("Atras");
		back.setFocusable(false);
		// Filter by user
		filterByUser = new JButton("Filtrar por Usuario");
		filterByUser.setFocusable(false);
		filterByUser.addActionListener(this);
		// Filter By state
		filterByState = new JButton("Filtrar por estado");
		filterByState.setFocusable(false);
		filterByState.addActionListener(this);
		// Change job state
		changeState = new JButton("Cambiar estado");
		changeState.setFocusable(false);
		changeState.addActionListener(this);
		// Delete PrintJob
		deletePrintJob = new JButton("Eliminar Trabajo");
		deletePrintJob.setFocusable(false);
		deletePrintJob.addActionListener(this);
		// edit printJob
		edit = new JButton("editar trabajo");
		edit.setFocusable(false);
		edit.addActionListener(this);

		buttons = new JPanel();
		buttons.add(changeState);
		buttons.add(filterByState);
		buttons.add(filterByUser);
		buttons.add(back);
		buttons.add(deletePrintJob);
		buttons.add(edit);
		scroll = new JScrollPane();

		back.addActionListener(this);

		String titles[] = { "Id", "Descripcion", "Copias", "Estado", "Calidad", "Fecha de entrada",
				"Fecha Finalizacion", "Fecha de entrega", "Usuario", "Encargado" };
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
			AdminView admin = new AdminView();
		}
		if (e.getSource() == changeState) {

			int selectedRow = table.getSelectedRow();

			if (selectedRow != -1) {
				String[] states = { "Pendiente", "Recibido", "Finalizado", "Entregado" };
				String currentState = (String) model.getValueAt(selectedRow, 3);
				String newState = (String) JOptionPane.showInputDialog(frame, "Seleccione el nuevo estado:",
						"Cambiar estado", JOptionPane.QUESTION_MESSAGE, null, states, currentState);
				if (newState != null && !newState.equals(currentState)) {
					Date fechaRecibo = new Date();
					SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", new Locale("es", "AR"));
					String fechaFormateada = formatoFecha.format(fechaRecibo);

					int printJobId = Integer.parseInt((String) model.getValueAt(selectedRow, 0));
					PrintJobService.updatePrintJobState(printJobId, newState);

					// Actualizar los valores de la fila en el modelo
					model.setValueAt(newState, selectedRow, 3); // Estado
					if (newState.equals("Finalizado")) {
						model.setValueAt(fechaFormateada, selectedRow, 6); // Fecha de finalización
					} else if (newState.equals("Entregado")) {
						model.setValueAt(fechaFormateada, selectedRow, 7); // Fecha de entrega
					}

					JOptionPane.showMessageDialog(frame, "Estado actualizado con éxito.");
				} else {
					JOptionPane.showMessageDialog(frame, "Seleccione un trabajo para cambiar el estado.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		}
		if (e.getSource() == filterByState) {
			// Logic needed
			System.out.println("Filtrar por estado");
			String[] states = { "Pendiente", "Recibido", "Finalizado", "Entregado" };
			String selectedState = (String) JOptionPane.showInputDialog(frame, "Seleccione el estado para filtrar:",
					"Filtrar por estado", JOptionPane.QUESTION_MESSAGE, null, states, states[0]);
			if (selectedState != null) {
				String[][] filteredJobs = PrintJobService.listPrintJobsByState(selectedState);
				model.setDataVector(filteredJobs, new String[] { "Id", "Descripcion", "Copias", "Estado", "Calidad",
						"Fecha de entrada", "Fecha Finalizacion", "Fecha de entrega", "Usuario", "Encargado" });
			}
		}
		if (e.getSource() == filterByUser) {
			// Falta hacer logica

			User[] userDB = DataUser.getInstance().getUserDB();
			String[] users = new String[userDB.length];
			int index = 0;
			for (int i = 0; i < userDB.length; i++) {
				if (!userDB[i].getRole().equals("0")) {
					users[index] = userDB[i].getName();
					index++;
				}
			}
			String selectedUser = (String) JOptionPane.showInputDialog(frame, "Seleccione el usuario para filtrar:",
					"Filtrar por usuario", JOptionPane.QUESTION_MESSAGE, null, users, users[0]);
			if (selectedUser != null) {
				String[][] filteredJobs = PrintJobService.listPrintJobsbyUser(selectedUser);
				model.setDataVector(filteredJobs, new String[] { "Id", "Descripcion", "Copias", "Estado", "Calidad",
						"Fecha de entrada", "Fecha Finalizacion", "Fecha de entrega", "Usuario", "Encargado" });
			}

		}
		if (e.getSource() == deletePrintJob) {
			int selectedRow = table.getSelectedRow();
			if (selectedRow != -1) {
				int printJobId = Integer.parseInt((String) model.getValueAt(selectedRow, 0));
				DataBaseLogic.deletePrintJob(printJobId);
				model.removeRow(selectedRow);
				JOptionPane.showMessageDialog(null, "Trabajo eliminado con exito");
			} else {
				JOptionPane.showMessageDialog(frame, "Seleccione un trabajo para eliminar.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		}
		if (e.getSource() == edit) {

			int selectedRow = table.getSelectedRow();
			if (selectedRow != -1) {
				// Verificar si se ha seleccionado una fila
				int printJobId = Integer.parseInt((String) model.getValueAt(selectedRow, 0));
				String currentDescription = (String) model.getValueAt(selectedRow, 1);
				String currentCopies = (String) model.getValueAt(selectedRow, 2);
				String currentQuality = (String) model.getValueAt(selectedRow, 4);
				PrintJob job = PrintJobService.getJobById(printJobId);

				// Crear un panel para la edición
				editionPanel = new JPanel();
				editionPanel.setLayout(new BoxLayout(editionPanel, BoxLayout.Y_AXIS));

				// Campo para la descripción
				JTextField descriptionField = new JTextField(currentDescription);
				editionPanel.add(new JLabel("Descripción:"));
				editionPanel.add(descriptionField);

				// Campo para el número de copias
				JTextField copiesField = new JTextField(currentCopies);
				editionPanel.add(new JLabel("Número de copias:"));
				editionPanel.add(copiesField);

				// ComboBox para la calidad
				String[] options = { "Blanco y Negro", "Color" };
				JComboBox<String> qualityComboBox = new JComboBox<>(options);
				qualityComboBox.setSelectedItem(currentQuality);
				editionPanel.add(new JLabel("Calidad:"));
				editionPanel.add(qualityComboBox);

				// Mostrar el panel en un JOptionPane
				int result = JOptionPane.showConfirmDialog(frame, editionPanel, "Editar Trabajo de Impresión",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

				if (result == JOptionPane.OK_OPTION) {
					String newDescription = descriptionField.getText().trim();
					String newCopies = copiesField.getText().trim();
					String newQuality = (String) qualityComboBox.getSelectedItem();

					// Validar que los campos no estén vacíos
					if (newDescription.isEmpty()) {
						JOptionPane.showMessageDialog(frame, "La descripción no puede estar vacía.", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (newCopies.isEmpty()) {
						JOptionPane.showMessageDialog(frame, "El número de copias no puede estar vacío.", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {
						Integer.parseInt(newCopies); // Intentar convertir el texto a un número
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(frame, "El número de copias debe ser un valor numérico.", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (newQuality == null) {
						JOptionPane.showMessageDialog(frame, "La calidad no puede estar vacía.", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Actualizar el trabajo de impresión solo si los valores han cambiado
					boolean updated = false;
					if (!newDescription.equals(currentDescription)) {
						job.setDescription(newDescription);
						model.setValueAt(newDescription, selectedRow, 1); // Actualizar Descripción
						updated = true;
					}
					if (!newCopies.equals(currentCopies)) {
						job.setCopies(newCopies);
						model.setValueAt(newCopies, selectedRow, 2); // Actualizar Copias
						updated = true;
					}
					if (!newQuality.equals(currentQuality)) {
						job.setQuality(newQuality);
						model.setValueAt(newQuality, selectedRow, 4); // Actualizar Calidad
						updated = true;
					}

					if (updated) {
						DataBaseLogic.editPrintJob(printJobId, newDescription, newCopies, newQuality);
						JOptionPane.showMessageDialog(frame, "Trabajo de impresión actualizado con éxito.");
					} else {
						JOptionPane.showMessageDialog(frame, "No se realizaron cambios.", "Información",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(frame, "Seleccione un trabajo para editar.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		}

	}
}
