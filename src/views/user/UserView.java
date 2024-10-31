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

/*
 * Botones de usuario
 * agregar trabajo
 * ver trabajos
 * cerrar sesion
 * 
 */

public class UserView implements ActionListener{

	private JButton addPrintJob,listPrintJobs,closeSession;
	
	private JFrame frame;
	private JPanel panel;
	
	
	
	
	
	
	
	public UserView() {
		
		frame=new JFrame("Ventana de usuario");
		
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
		gbc.anchor = GridBagConstraints.CENTER;
		
		
		
		// Add print Jobs
		addPrintJob=new JButton("Agregar Trabajos");
		addPrintJob.setFocusable(false);
		addPrintJob.addActionListener(this);
		panel.add(addPrintJob);
		
		// List Print Jobs
		listPrintJobs=new JButton("Listar Trabajos");
		listPrintJobs.setFocusable(false);
		listPrintJobs.addActionListener(this);
		panel.add(listPrintJobs);
		
		// Close Session
		closeSession=new JButton("Cerrar Sesion");
		closeSession.setFocusable(false);
		closeSession.addActionListener(this);
		panel.add(closeSession);
		
		frame.add(panel);
		frame.setVisible(true);
	}







	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==addPrintJob) {
			System.out.println("Agregar trabajos");
		}
		else if(e.getSource()==listPrintJobs) {
			System.out.println("Listar Trabajos");
		}
		else if(e.getSource()==closeSession) {
			System.out.println("Cerrar sesion");
		}
	}

	
	
}
