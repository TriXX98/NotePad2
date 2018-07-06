package Demo;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Replace extends JFrame implements ActionListener {

	JLabel lbFind, lbReplace;
	JTextField tfFind, tfReplace;
	JButton btFind, btReplace, btReplaceAll, btCancel;
	JPanel pane1, pane2;
	Container container;
	int pos = 0;
	SoureNote note;

	public Replace() {
		// TODO Auto-generated constructor stub

		setTitle("Replace");
		setResizable(false);
		setLocationRelativeTo(null);
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUI();
		setVisible(true);
	}

	private void setControls() {
		// TODO Auto-generated method stub
		btCancel.addActionListener(this);
		btFind.addActionListener(this);
		btReplace.addActionListener(this);
		btReplaceAll.addActionListener(this);

	}

	private void setUI() {
		// TODO Auto-generated method stub
		lbFind = new JLabel("Find with: ", JLabel.RIGHT);
		tfFind = new JTextField(10);
		lbReplace = new JLabel("Replace with: ", JLabel.RIGHT);
		tfReplace = new JTextField(10);
		pane1 = new JPanel();

		pane1.setLayout(new GridLayout(3, 0));
		pane1.add(lbFind);
		pane1.add(tfFind);
		pane1.add(lbReplace);
		pane1.add(tfReplace);

		btFind = new JButton("Find Next");
		btReplace = new JButton("Replace");
		btReplaceAll = new JButton("Replace All");
		btCancel = new JButton("Cancel");

		pane2 = new JPanel();
		pane2.setLayout(new GridLayout(4, 0));
		pane2.add(btFind);
		pane2.add(btReplace);
		pane2.add(btReplaceAll);
		pane2.add(btCancel);

		add(pane1, BorderLayout.WEST);
		add(pane2, BorderLayout.EAST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btCancel) {
			int check = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát ? ", "Hộp thoại hỏi thoát ???",
					JOptionPane.YES_NO_OPTION);
			if (check == JOptionPane.YES_OPTION) {
				setVisible(false);
			} else {
				return;
			}
		}
		if (e.getSource() == btFind) {
			find();
		}
		if (e.getSource() == btReplace) {
			replace();
		}
		if (e.getSource() == btReplaceAll) {
			replaceAll();
		}
	}

	private void replaceAll() {
		// TODO Auto-generated method stub
		note.getArea().select(0, 0);
		while (pos >= 0)
			replace();
	}

	private void replace() {
		// TODO Auto-generated method stub
		int start = note.getArea().getSelectionStart();
		int end = note.getArea().getSelectionEnd();
		if (end > start) {
			note.getArea().replaceSelection(tfReplace.getText());
			System.out.println(start + (tfReplace.getText().length()));
			note.getArea().select(start, start + tfReplace.getText().length());

			find();
		} else {
			System.out.println("this is inside the else loop");
			System.out.println(start + tfReplace.getText().length());
		}

	}

	private void find() {
		// TODO Auto-generated method stub
		String str, txt;
		txt = note.getArea().getText();
		str = tfFind.getText();
		pos = txt.indexOf(str, note.getArea().getSelectionEnd());
		if (pos >= 0){
			note.getArea().select(pos, (pos + str.length()));
		}
	}

}
