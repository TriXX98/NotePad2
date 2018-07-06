package textFiled;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class testTextFiled extends JFrame {
	private JTextField field;
	public testTextFiled() {
		// TODO Auto-generated constructor stub
		field = new JTextField(10);
		field.setBackground(Color.WHITE);
		field.setLocation(10,10);
		field.setSize(30, 5);
		field.setForeground(Color.black);
		this.setTitle("Test TextFieled");
		this.setSize(300, 300);
		this.setLocation(300, 300);
		this.setLayout(new FlowLayout());		
		this.add(field);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
