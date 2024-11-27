package views.user;

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

import models.User;
import persistence.DataUser;
import views.printjob.PrintJobView;
import views.LoginView;
import views.printjob.ListPrintJobs;

/*
 * Botones de usuario
 * agregar trabajo
 * ver trabajos
 * cerrar sesion
 * 
 */

public class UserView implements ActionListener {

	private JButton addPrintJob, listPrintJobs, closeSession;

	private JFrame frame;
	private User currentUser;

	public UserView(String userName) {

		currentUser = DataUser.getLoggedUser(userName);
		frame = new JFrame("Ventana de usuario-" + currentUser.getName());

		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        frame.dispose();
		        new LoginView();
		    }
		});

		Toolkit screen = Toolkit.getDefaultToolkit();
		Dimension dimension = screen.getScreenSize();

		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);

		Image icon = screen.getImage("src/views/java.png");
		frame.setIconImage(icon);

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.anchor = GridBagConstraints.CENTER;

		// Add print Jobs
		gbc.gridx = 0;
		gbc.gridy = 0;
		addPrintJob = new JButton("Agregar Trabajos");
		addPrintJob.setFocusable(false);
		addPrintJob.addActionListener(this);
		panel.add(addPrintJob, gbc);

		// List Print Jobs
		gbc.gridx = 1;
		listPrintJobs = new JButton("Listar Trabajos");
		listPrintJobs.setFocusable(false);
		listPrintJobs.addActionListener(this);
		panel.add(listPrintJobs, gbc);

		// Close Session
		gbc.gridx = 2;
		closeSession = new JButton("Cerrar Sesion");
		closeSession.setFocusable(false);
		closeSession.addActionListener(this);
		panel.add(closeSession, gbc);

		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == addPrintJob) {
			frame.dispose();
			PrintJobView print = new PrintJobView(currentUser.getName());
			System.out.println("Agregar trabajos");
		} else if (e.getSource() == listPrintJobs) {
			frame.dispose();
			ListPrintJobs list=new ListPrintJobs(currentUser.getName());
			System.out.println("Listar Trabajos");
		} else if (e.getSource() == closeSession) {
			frame.dispose();
			LoginView login = new LoginView();
		}
	}

}
