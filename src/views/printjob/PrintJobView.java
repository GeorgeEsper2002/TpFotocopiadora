package views.printjob;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Vista para agregar Trabajos
public class PrintJobView {

	private JButton create,clean,goBack;
	private JFrame frame;
	private JPanel panel1;
	private JComboBox comboQuality;
	private JTextField txtId,txtDescription,txtCopies;
	private JLabel lblConfirm,lblId,lblDesc,lblCopies; 
	public PrintJobView() {
		
		frame=new JFrame("Ventana de Usuario-User");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel titleBar = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Agregar Trabajo", JLabel.CENTER);
        titleBar.add(titleLabel, BorderLayout.CENTER);

		Toolkit screen = Toolkit.getDefaultToolkit();
		Dimension dimension = screen.getScreenSize();

		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);

		Image icon = screen.getImage("src/views/java.png");
		frame.setIconImage(icon);
		frame.add(titleBar, BorderLayout.NORTH);
		frame.setVisible(true);
		
		
	}
	
	
}
