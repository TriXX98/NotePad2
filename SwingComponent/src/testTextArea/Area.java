package testTextArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Area extends JFrame {
	JLabel jLabel = new JLabel("Details");
	JTextArea area = new JTextArea(300, 300);
	
public Area() {
	// TODO Auto-generated constructor stub
	this.setTitle("Test TextArea");
	this.setSize(400, 400);
	this.setLocation(100,100);
	this.setVisible(true);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	area.setBackground(Color.BLACK);
	area.setForeground(Color.WHITE);
	area.setBounds(10, 10,100, 100);
	this.setLayout(new BorderLayout());
	this.add(area,BorderLayout.LINE_START);
	
}
}
