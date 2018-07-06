package testJTable;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class demoJTable {
	
	public demoJTable() {
		// TODO Auto-generated constructor stub
		JFrame frame = new JFrame();
		String rows[][] =new String[][]{
				{"A", "First" , " One"},
				{"B",  "Second ", "Two"},
				{ "C", "Third", "Three"}
		};
		String colum[] = new String[] {"1", "2","3"}; 
		JTable table = new JTable(rows , colum);
		table.setBounds(50 , 50 , 100, 100);
		
		JPanel pane = new JPanel();
		  pane.add(table,BorderLayout.CENTER);
		
		frame.add(pane);
		frame.setTitle("DEMO JTABLE");
		frame.setLayout(new BorderLayout());
		frame.setSize(400, 400);
		frame.setLocation(500,50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
		
	}
	
	
}
 