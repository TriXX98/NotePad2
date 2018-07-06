package Demo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class FontEdit extends JFrame implements ActionListener {
	JLabel lbFont ,lbStyle , lbSize;
	JPanel pList , pLabel, pButton;
	JButton btOK , btCancel;
	JList list1 , list2 , list3 ;
	String[] fontName = { "Arial","Calibri","Consolas","Times New Roman","Scanserif"};
	String[] fontStyle ={"Regular","Italic","Bold"};
	String[] fontSize ={"8","10","12","14","16","20"};
	ScrollPane sp1 , sp2 ,sp3 ;
	SoureNote note ;
	public FontEdit() {
		// TODO Auto-generated constructor stub
		setTitle("Font");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setUI();
		setControls();
		setVisible(true);
	}

	private void setControls() {
		// TODO Auto-generated method stub
		btOK.addActionListener(this);
		btCancel.addActionListener(this);
		
		
		
	}

	private void setUI() {
		// TODO Auto-generated method stub
		sp1 = new ScrollPane();
		sp2= new ScrollPane();
		sp3 = new ScrollPane();
		
		lbFont = new JLabel("Font:");
		lbStyle = new JLabel("Font Style:");
		lbSize = new JLabel("Size:");
		list1 = new JList<>(fontName);
		list1.setSelectedIndex(0);
		list2 = new JList<>(fontStyle);
		list2.setSelectedIndex(0);
		list3 = new JList<>(fontSize);
		list3.setSelectedIndex(0);
		
		
		btOK = new JButton("Ok");
		btCancel = new JButton("Cancel");
		
		pList= new JPanel();
		sp1.add(list1);
		sp2.add(list2);
		sp3.add(list3);
		pList.add(sp1);
		pList.add(sp2);
		pList.add(sp3);
		
		pLabel = new JPanel();
		pLabel.add(lbFont , BorderLayout.LINE_START);
		pLabel.add(lbStyle , BorderLayout.CENTER);
		pLabel.add(lbSize, BorderLayout.LINE_END);
		
		pButton= new JPanel();
		pButton.add(btOK);
		pButton.add(btCancel);
		
		add(pList , BorderLayout.CENTER);
		add(pLabel ,BorderLayout.NORTH);
		add(pButton,BorderLayout.SOUTH);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String line1 , line2 , line3;
	    int ret = 0;
	    
	    // Lấy các giá trị trong list
	    line1 = list1.getSelectedValue().toString();
	    line2 = list2.getSelectedValue().toString();
		line3 = list3.getSelectedValue().toString();
		
		// thực hiện chỉnh phông chữ
		if (line2 == "Regular") {
			ret = Font.PLAIN;
		}
		if (line2 == "Italic") {
			ret = Font.ITALIC;
		}
		if (line2 == "Bolb") {
			ret = Font.BOLD;
		}
		// Thực hiện chỉnh cỡ chữ
		int size = Integer.parseInt(line3);
		
		if (e.getSource() == btOK) {
			Font fnt = new Font(line1 ,ret ,size);
			note.getArea().setFont(fnt);
			setVisible(false);
		}
		if (e.getSource() == btCancel) {
			setVisible(false);
		}
	}

}









