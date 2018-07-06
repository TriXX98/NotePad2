package TestButton;

import java.awt.Button;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DemoButton extends JFrame {
	public DemoButton() {
		// TODO Auto-generated constructor stub
		Button button = new Button("Choice");
		button.setBounds(10, 10, 10, 4);
		button.setSize(5, 5);
		
		this.add(button);
		this.setTitle("Demo Button");
		this.setSize(300, 400);
		this.setLocation(200, 200);
		this.setVisible(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
				
	}

}
