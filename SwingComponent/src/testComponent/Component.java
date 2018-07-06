package testComponent;

import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Component extends JFrame {
	
	private JLabel j = new JLabel("Jlabel");

	public Component() {
		// TODO Auto-generated constructor stub
		super();
		setTitle("--COMPONENT--");
		setSize(300, 300);
		setLocation(ABORT, ABORT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(j);
	}

}
