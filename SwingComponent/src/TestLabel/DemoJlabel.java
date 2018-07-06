package TestLabel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DemoJlabel {
	private JFrame frame;
	private JLabel jLabel1;
	private JLabel jLabel2;
	
	private JPanel jPanel;

	public DemoJlabel() {
		// TODO Auto-generated constructor stub
		CreateComponent();
	}

	private void CreateComponent() {
		// TODO Auto-generated method stub
		frame = new JFrame("Demo Label");
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setLayout(new FlowLayout());
		
		// Thuc hien thao tac voi cua so
		// Dong cua so 
		frame.addWindowListener(new WindowAdapter() {
			public void WindowClosing(WindowEvent windowEvent) {
				// TODO Auto-generated method stub
				System.exit(0);

			}
		});
		jLabel1 = new JLabel("" ,JLabel.CENTER );
		jLabel2 = new JLabel("", JLabel.CENTER);
		
		jLabel2.setSize(250,50);
		jPanel = new  JPanel();
		jPanel.setLayout(new FlowLayout());
		
		frame.add(jLabel1);
		frame.add(jPanel);
		frame.add(jLabel2);
		
	}
	public void showLabelDemo(){
		
		jLabel1.setText("Control in action: Jlabel");
		
		JLabel jLabel = new JLabel("", JLabel.CENTER);
		jLabel.setText("Thu nghiem Label trong Java");
		jLabel.setOpaque(true);
		jLabel.setBackground(Color.BLUE);
		jLabel.setForeground(Color.WHITE);
		jPanel.add(jLabel);
		
		frame.setVisible(true);
		
		
				
	}

}
