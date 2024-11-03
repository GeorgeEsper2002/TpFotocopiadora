package views.user;

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

//Hacer tipo tabla la vista de listar usuarios
public class ListUsers implements ActionListener {

	private JFrame frame;
	private JPanel panelTable,buttons;
	private JButton activate,deactivate,makeAdmin,makeUser,back;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scroll;
	
	public ListUsers() {
		
		frame=new JFrame("Listar Usuarios");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Toolkit screen = Toolkit.getDefaultToolkit();
		Dimension dimension = screen.getScreenSize();

		frame.setSize(800, 600);
		
		activate=new JButton();
		deactivate=new JButton();
		makeAdmin=new JButton();
		makeUser=new JButton();
		back=new JButton();
		model=new DefaultTableModel();
		scroll=new JScrollPane();
		
		
		String titles[] = {"Usuario","Estado","Rol"};
		model.setColumnIdentifiers(titles);
		
		
		table=new JTable(model);
		
		table.setBounds(10, 50, 480, 250);
		scroll.setBounds(10, 50, 480, 250);
		
		scroll.setViewportView(table);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		frame.add(scroll);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
