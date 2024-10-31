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
		
		
		// Poner botones
		
		
		
		
		
		frame.setVisible(true);
	}







	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
