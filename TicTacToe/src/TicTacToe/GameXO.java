package TicTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameXO extends JFrame {

	private JPanel contentPane;
	private JLabel lbTitle;
	private JButton bt10;
	private JButton bt8;
	private JButton bt9;
	private JButton bt7;
	private JButton bt3;
	private JButton bt2;
	private JLabel lb1;
	private JLabel lb3;
	private JLabel lb4;
	private JButton bt1;
	private JLabel lb2;
	private JButton bt4;
	private JButton bt5;
	private JButton bt6;
	private JButton bt11;

	JLabel lbl1, lbl2, lbl3;

	private String startGame = "X";
	private int xChoice = 0, oChoice = 0;

	public GameXO() {
		setTitle("Tic-Tac-Toe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 465);
		setUI();
		winGame();
		setVisible(true);

	}

	private void xuliGame() {
		lb2.setText(String.valueOf(xChoice));
		lb4.setText(String.valueOf(oChoice));
	}

	private void playGame() {

		// equalsIgnoreCase so sánh String này với String khác, bỏ qua sự khác
		// biệt về kiểu chữ

		if (startGame.equalsIgnoreCase("X")) {
			startGame = "O";
		} else {
			startGame = "X";
		}

	}

	private void winGame() {
		String b1 = bt1.getText();
		String b2 = bt2.getText();
		String b3 = bt3.getText();
		String b4 = bt4.getText();
		String b5 = bt5.getText();
		String b6 = bt6.getText();
		String b7 = bt7.getText();
		String b8 = bt8.getText();
		String b9 = bt9.getText();

		if (b1 == "X" && b2 == "X" && b3 == "X") {
			JOptionPane.showMessageDialog(null, "Player X wins", "Tic-Toc-Toe Game", JOptionPane.INFORMATION_MESSAGE);
			xChoice++;
			xuliGame();
		}else if (b1 == "X" && b5 == "X" && b9 == "X") {
			JOptionPane.showMessageDialog(null, "Player X wins", "Tic-Toc-Toe Game", JOptionPane.INFORMATION_MESSAGE);
			xChoice++;
			xuliGame();
		}else if (b1 == "X" && b4 == "X" && b7 == "X") {
			JOptionPane.showMessageDialog(null, "Player X wins", "Tic-Toc-Toe Game", JOptionPane.INFORMATION_MESSAGE);
			xChoice++;
			xuliGame();
		}else if (b2 == "X" && b5 == "X" && b8 == "X") {
			JOptionPane.showMessageDialog(null, "Player X wins", "Tic-Toc-Toe Game", JOptionPane.INFORMATION_MESSAGE);
			xChoice++;
			xuliGame();
		}else if (b3 == "X" && b6 == "X" && b9 == "X") {
			JOptionPane.showMessageDialog(null, "Player X wins", "Tic-Toc-Toe Game", JOptionPane.INFORMATION_MESSAGE);
			xChoice++;
			xuliGame();
		}else if (b3 == "X" && b5 == "X" && b7 == "X") {
			JOptionPane.showMessageDialog(null, "Player X wins", "Tic-Toc-Toe Game", JOptionPane.INFORMATION_MESSAGE);
			xChoice++;
			xuliGame();
		}else if (b4 == "X" && b5 == "X" && b6 == "X") {
			JOptionPane.showMessageDialog(null, "Player X wins", "Tic-Toc-Toe Game", JOptionPane.INFORMATION_MESSAGE);
			xChoice++;
			xuliGame();
		}else if (b7 == "X" && b8 == "X" && b9 == "X") {
			JOptionPane.showMessageDialog(null, "Player X wins", "Tic-Toc-Toe Game", JOptionPane.INFORMATION_MESSAGE);
			xChoice++;
			xuliGame();
		}
		
		///////////////////////////
		
		if (b1 == "O" && b2 == "O" && b3 == "O") {
			JOptionPane.showMessageDialog(null, "Player O wins", "Tic-Toc-Toe Game", JOptionPane.INFORMATION_MESSAGE);
			oChoice++;
			xuliGame();
		}else if (b1 == "O" && b5 == "O" && b9 == "O") {
			JOptionPane.showMessageDialog(null, "Player O wins", "Tic-Toc-Toe Game", JOptionPane.INFORMATION_MESSAGE);
			oChoice++;
			xuliGame();
		}else if (b1 == "O" && b4 == "O" && b7 == "O") {
			JOptionPane.showMessageDialog(null, "Player O wins", "Tic-Toc-Toe Game", JOptionPane.INFORMATION_MESSAGE);
			oChoice++;
			xuliGame();
		}else if (b2 == "O" && b5 == "O" && b8 == "O") {
			JOptionPane.showMessageDialog(null, "Player O wins", "Tic-Toc-Toe Game", JOptionPane.INFORMATION_MESSAGE);
			oChoice++;
			xuliGame();
		}else if (b3 == "O" && b6 == "O" && b9 == "O") {
			JOptionPane.showMessageDialog(null, "Player O wins", "Tic-Toc-Toe Game", JOptionPane.INFORMATION_MESSAGE);
			oChoice++;
			xuliGame();
		}else if (b3 == "O" && b5 == "O" && b7 == "O") {
			JOptionPane.showMessageDialog(null, "Player O wins", "Tic-Toc-Toe Game", JOptionPane.INFORMATION_MESSAGE);
			oChoice++;
			xuliGame();
		}else if (b4 == "O" && b5 == "O" && b6 == "O") {
			JOptionPane.showMessageDialog(null, "Player O wins", "Tic-Toc-Toe Game", JOptionPane.INFORMATION_MESSAGE);
			oChoice++;
			xuliGame();
		}else if (b7 == "O" && b8 == "O" && b9 == "O") {
			JOptionPane.showMessageDialog(null, "Player O wins", "Tic-Toc-Toe Game", JOptionPane.INFORMATION_MESSAGE);
			oChoice++;
			xuliGame();
		}




	}

	private void setUI() {
		// TODO Auto-generated method stub
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		lbTitle = new JLabel("Tic Tac Toe");
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbTitle, BorderLayout.NORTH);

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new GridLayout(3, 5));
		panel.add(pnCenter, BorderLayout.CENTER);

		bt1 = new JButton("");
		bt1.setFont(new Font("Tahoma", Font.BOLD, 60));
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt1.setText(startGame);
				if (startGame.equalsIgnoreCase("X")) {
					bt1.setForeground(Color.BLUE);
				} else {
					bt1.setForeground(Color.RED);

				}
				playGame();
				winGame();
			}
		});
		pnCenter.add(bt1);

		bt2 = new JButton("");
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt2.setText(startGame);
				if (startGame.equalsIgnoreCase("X")) {
					bt2.setForeground(Color.BLUE);
				} else {
					bt2.setForeground(Color.RED);

				}
				playGame();
				winGame();
			}
		});
		bt2.setFont(new Font("Tahoma", Font.BOLD, 60));
		pnCenter.add(bt2);

		bt3 = new JButton("");
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt3.setText(startGame);
				if (startGame.equalsIgnoreCase("X")) {
					bt3.setForeground(Color.BLUE);
				} else {
					bt3.setForeground(Color.RED);

				}
				playGame();
				winGame();
			}
		});
		bt3.setFont(new Font("Tahoma", Font.BOLD, 60));
		pnCenter.add(bt3);

		lb1 = new JLabel("Player X:");
		lb1.setFont(new Font("Tahoma", Font.BOLD, 17));
		pnCenter.add(lb1);

		lb2 = new JLabel("0");
		lb2.setHorizontalAlignment(SwingConstants.CENTER);
		lb2.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnCenter.add(lb2);

		bt4 = new JButton("");
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt4.setText(startGame);
				if (startGame.equalsIgnoreCase("X")) {
					bt4.setForeground(Color.BLUE);
				} else {
					bt4.setForeground(Color.RED);

				}
				playGame();
				winGame();
			}
		});
		bt4.setFont(new Font("Tahoma", Font.BOLD, 60));
		pnCenter.add(bt4);

		bt5 = new JButton("");
		bt5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt5.setText(startGame);
				if (startGame.equalsIgnoreCase("X")) {
					bt5.setForeground(Color.BLUE);
				} else {
					bt5.setForeground(Color.RED);

				}
				playGame();
				winGame();
			}
		});
		bt5.setFont(new Font("Tahoma", Font.BOLD, 60));
		pnCenter.add(bt5);

		bt6 = new JButton("");
		bt6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt6.setText(startGame);
				if (startGame.equalsIgnoreCase("X")) {
					bt6.setForeground(Color.BLUE);
				} else {
					bt6.setForeground(Color.RED);

				}
				playGame();
				winGame();
			}
		});
		bt6.setFont(new Font("Tahoma", Font.BOLD, 60));
		pnCenter.add(bt6);

		lb3 = new JLabel("Player O:");
		lb3.setFont(new Font("Tahoma", Font.BOLD, 17));
		pnCenter.add(lb3);

		lb4 = new JLabel("0");
		lb4.setHorizontalAlignment(SwingConstants.CENTER);
		lb4.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnCenter.add(lb4);

		bt7 = new JButton("");
		bt7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt7.setText(startGame);
				if (startGame.equalsIgnoreCase("X")) {
					bt7.setForeground(Color.BLUE);
				} else {
					bt7.setForeground(Color.RED);

				}
				playGame();
				winGame();
			}
		});
		bt7.setFont(new Font("Tahoma", Font.BOLD, 60));
		pnCenter.add(bt7);

		bt8 = new JButton("");
		bt8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt8.setText(startGame);
				if (startGame.equalsIgnoreCase("X")) {
					bt8.setForeground(Color.BLUE);
				} else {
					bt8.setForeground(Color.RED);

				}
				playGame();
				winGame();
			}
		});
		bt8.setFont(new Font("Tahoma", Font.BOLD, 60));
		pnCenter.add(bt8);

		bt9 = new JButton("");
		bt9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt9.setText(startGame);
				if (startGame.equalsIgnoreCase("X")) {
					bt9.setForeground(Color.BLUE);
				} else {
					bt9.setForeground(Color.RED);

				}
				playGame();
				winGame();
			}
		});
		bt9.setFont(new Font("Tahoma", Font.BOLD, 60));
		pnCenter.add(bt9);

		bt10 = new JButton("Game Reset");
		bt10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reset();
			}

			private void Reset() {
				// TODO Auto-generated method stub
				bt1.setText(null);
				bt2.setText(null);
				bt3.setText(null);
				bt4.setText(null);
				bt5.setText(null);
				bt6.setText(null);
				bt7.setText(null);
				bt8.setText(null);
				bt9.setText(null);
			}
		});
		bt10.setFont(new Font("Times New Roman", Font.BOLD, 15));
		pnCenter.add(bt10);

		bt11 = new JButton("Game Exit");
		bt11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exit();
			}

			private void Exit() {
				// TODO Auto-generated method stub
				int ret = JOptionPane.showConfirmDialog(null, "Bạn muốn thoát khỏi trò chơi ???",
						"Hộp thoại hỏi bạn thoát !!!", JOptionPane.YES_NO_OPTION);
				if (ret == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					return;
				}

			}
		});
		bt11.setFont(new Font("Times New Roman", Font.BOLD, 15));
		pnCenter.add(bt11);

	}

}
