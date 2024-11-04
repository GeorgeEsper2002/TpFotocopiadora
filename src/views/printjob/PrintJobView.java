package views.printjob;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.JPanel;
import javax.swing.JTextField;

import views.user.UserView;

// Vista para agregar Trabajos
public class PrintJobView implements ActionListener {

	private JButton create,clean,back;
	private JFrame frame;
	private JComboBox comboQuality;
	private JTextField txtId,txtDescription,txtCopies;
	private JLabel lblDesc,lblCopies,lblQuality; 
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
		
		 // Base panel
        JPanel basePanel = new JPanel(new BorderLayout());

        // Specific panel for adding printJobs
        JPanel addPrintJobPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
		
		
        lblDesc= new JLabel("Titulo del trabajo: ");
        addPrintJobPanel.add(lblDesc, gbc);

        gbc.gridx = 1;
        txtDescription = new JTextField(20);
        addPrintJobPanel.add(txtDescription, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        lblCopies = new JLabel("Cantidad de copias:");
        addPrintJobPanel.add(lblCopies, gbc);

        gbc.gridx = 1;
        txtCopies = new JTextField(20);
        addPrintJobPanel.add(txtCopies, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        lblQuality = new JLabel("Calidad:");
        addPrintJobPanel.add(lblQuality, gbc);

        gbc.gridx = 1;
        String[] quality = {"Color", "Blanco y Negro"};
        comboQuality = new JComboBox<>(quality);
        addPrintJobPanel.add(comboQuality, gbc);

        // Button to create Jobs
        gbc.gridy = 3;
        gbc.gridx=0;
        create = new JButton("Crear");
        create.setFocusable(false);
        create.addActionListener(this);
        addPrintJobPanel.add(create, gbc);

        // Button to clear textfields
        gbc.gridy = 3;
        gbc.gridx=1;
        clean = new JButton("Limpiar");
        clean.setFocusable(false);
        clean.addActionListener(this);
        addPrintJobPanel.add(clean, gbc);

        // Button to go back
        gbc.gridy = 3;
        gbc.gridx=2;
        back = new JButton("Atras");
        back.setFocusable(false);
        back.addActionListener(this);
        addPrintJobPanel.add(back, gbc);
        
        
		
		
		
		
		
		
		frame.add(addPrintJobPanel);
		frame.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==create) {
			System.out.println("Crear Trabajos");
			
		}
		else if(e.getSource()==clean){
			
			txtCopies.setText("");
			txtDescription.setText("");
			
		}
		else if(e.getSource()==back) {
			frame.dispose();
			UserView user=new UserView();
		}
	}
	
	
}
