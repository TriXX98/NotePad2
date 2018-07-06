package Calculator;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D.Float;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.BorderUIResource;

public class SourceCal extends JFrame {
	JLabel lbScreen;
	JTextField tfScreen;
	String[] numberText = {"AC","+/-","%","+",
                           "1", "2", "3", "-",
                           "4", "5", "6", "*",
                           "7", "8", "9", "/",
                           "0", ".", "DEL", "="
};
	ArrayList<JButton> buttons = null;
	JPanel pnScreen , pnButton;
	Container container;
	String key1 ="" , key2="" , result ="";
	boolean test = true;
	StringBuffer buffer = new StringBuffer();
	
	
	public SourceCal() {
		// TODO Auto-generated constructor stub
		setTitle("Calculator");
		buttons = new ArrayList<JButton>();
		setResizable(false);
		setBounds(150,150,300,400);
		setLocationRelativeTo(null);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUI();
		setControls();
		setVisible(true);
	}

	private void setControls() {
		// TODO Auto-generated method stub
		for (JButton jButton : buttons) {
			jButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JButton btSource = (JButton) e.getSource();
					if (btSource.getText().equals("+/-") && buffer.toString().length() == 0) {
						buffer.append("-");
						lbScreen.setText(buffer.toString());
						
					}
					// matches trong java 
					//xác định có hay không chuỗi này so khớp (match) với regular expression đã cho
					// gía trị true hoặc false
					// [^0-9=.] là  được sử dụng để tìm bất kỳ ký tự nào KHÔNG phải là chữ số , " = và dấu .".
					if (btSource.getText().matches("[^0-9=.]")) {
						result = btSource.getText();
						key1 = lbScreen.getText();
						test = false;
						
						// So khớp với các chữ số. Tương đương với [0-9]. có trong ngoặc vuông
					}else if(btSource.getText().matches("[\\d.]")) {
						if (test) {
							display(btSource);
						}else {
							buffer.delete(0, toString().length());
							display(btSource);
							test = true;
						}
					}else if(btSource.getText().equals("AC")) {
						
						clear();
					}else if (btSource.getText().equals("=")) {
						if (result.equals(" ")) {
							return;
							
						}
						try {
							calculator();
						} catch (Exception ex) {
							// TODO: handle exception
							lbScreen.setText("Lỗi");
					//		JOptionPane.showMessageDialog(null, "Syntax Eror");
						}
						
						
					}else if (btSource.getText().equals("DEL")) {
						Del();
						
					} 
					
				}

				private void Del() {
					// TODO Auto-generated method stub
					String del = "0" ;
					if (lbScreen.getText().length() > 0) {
						buffer.deleteCharAt(lbScreen.getText().length()-1 );
						del = buffer.toString();
						lbScreen.setText(del);		
					
					}
					
				}

				private void calculator() {
					// TODO Auto-generated method stub
					key2= buffer.toString();
					float Operation =0;
					if (result.equals("+")) {
						Operation = java.lang.Float.parseFloat(key1) + java.lang.Float.parseFloat(key2);					
						
						
					}else if (result.equals("-")) {
						Operation = java.lang.Float.parseFloat(key1) - java.lang.Float.parseFloat(key2);
					}else if (result.equals("*")) {
						Operation = java.lang.Float.parseFloat(key1) * java.lang.Float.parseFloat(key2);
					}else if (result.equals("/")) {
						Operation = java.lang.Float.parseFloat(key1) / java.lang.Float.parseFloat(key2);
					}
					if (Operation == (int) Operation) {
						lbScreen.setText((int) Operation +"");
						
					}else {
						String str = Operation + "";
						char[] strAr = str.toCharArray();
						if (strAr.length >7) {
							lbScreen.setFont(new Font("Tahoma",Font.BOLD,45));
						}
						lbScreen.setText(str);
					}if (result.equals("%")) {
						int ret = Integer.parseInt(key1) % Integer.parseInt(key2);
						lbScreen.setText(ret +"");
					}
					buffer.delete(0, buffer.toString().length());
				}

				private void clear() {
					// TODO Auto-generated method stub
					buffer.delete(0, buffer.toString().length());
					lbScreen.setText("0");
					key1 = "";
					key2= "";
					result= "";
					
					
				}

				private void display(JButton btSource) {
					// TODO Auto-generated method stub
					String text = btSource.getText();
					if (lbScreen.getText().equals("0") && text.equals("0")) {
						return;
						
					}
					buffer.append(text);
					lbScreen.setText(buffer.toString());
				}
			});
		}
		
		
	}

	private void setUI() {
		// TODO Auto-generated method stub
		container = new Container();
		container.setLayout(new  BorderLayout());
		container = this.getContentPane();
		
		// tạo 1 danh sách để chứa Screen
		pnScreen = new JPanel();
		pnScreen.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnScreen.setBackground(Color.DARK_GRAY);
	
		
		// Đưa vào kích thước cho Screen
		// Phương thức này cho phép bạn đặt vào đó 1 kích thước
		// Dimension cho phép ta lấy ra chiều rộng và dài
		pnScreen.setPreferredSize(new Dimension(0,90));
		
		// Tạo 1 bảng dành cho buttons
		pnButton = new JPanel();
		
		// Gridlayout cho phép ta tạo 1 bảng gồm côt và dòng được đưa vào
		
				
		
		pnButton.setLayout(new GridLayout(5,5));
		
		for (String button : numberText) {
			JButton bt = new JButton(button);
			bt.setFont(new Font( "Tahoma",Font.PLAIN, 20));
			bt.setForeground(Color.WHITE);
			bt.setBackground(Color.black);
			// Các nút sẽ được thêm vào 1 mảng buttons
			buttons.add(bt);
			pnButton.add(bt);
		}
		
		lbScreen = new JLabel("0");
		lbScreen.setForeground(Color.WHITE);
	    lbScreen.setBounds(10, 11, 340, 32 );
	    lbScreen.setBackground(Color.CYAN);
		lbScreen.setFont(new Font("Tahoma", Font.BOLD, 45));
		pnScreen.add(lbScreen);
		
//		tfScreen = new JTextField("0",8);
//		tfScreen.setLayout(new  FlowLayout(FlowLayout.LEFT));
//		tfScreen.setFont(new Font("Tahoma", Font.BOLD, 45));
//		pnScreen.add(tfScreen);
		container.setBackground(Color.BLACK);
		container.add(pnScreen, BorderLayout.NORTH);
		container.add(pnButton,BorderLayout.SOUTH);
	}

}
