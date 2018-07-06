package Demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.chrono.JapaneseChronology;
import java.util.Calendar;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import javax.tools.Tool;

public class SoureNote extends JFrame {

	JTextArea area;
	Container container;
	JMenuBar menuBar;
	JMenu file, edit, format, view, help;
	JMenuItem itemNew, itemOpen, itemSave, itemExit, itemUndo, itemCut, itemCopy, itemPaste, itemDelete, itemReplace,
			itemDatetime, itemSelectAll, itemWord, itemFont , itemStatus , itemView , itemHelp;
	JFileChooser chooser;

	public JTextArea getArea() {
		return area;
	}
	public void setArea(JTextArea area) {
		this.area = area;
	}
	
	public SoureNote() {
		// TODO Auto-generated constructor stub
		setTitle("Notepad");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setBackground(Color.WHITE);
		setUI();
		setControls();
		ControlsEdit();
		area.setFont(new Font("Consolas", Font.PLAIN, 15));
		setVisible(true);

	}
	
	private void ProcessBt( boolean b){
		this.itemCut.setEnabled(b);
		this.itemCopy.setEnabled(b);
		this.itemPaste.setEnabled(b);
		this.itemDelete.setEnabled(b);
		
	}

	private void ControlsEdit() {
		// TODO Auto-generated method stub
		// Thuộc tính UndoManager sẽ cung cấp  cho ta việc hoàn tác hay sử đổi 1 tài liệu sao cho thích hợp
		UndoManager editManager = new UndoManager();
		// thực hiện hỗ trợ chỉnh sở trên tài liệu
		// getDocument hỗ trợ việc lấy tài liệu
		area.getDocument().addUndoableEditListener(new UndoableEditListener() {

			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
				// TODO Auto-generated method stub
				// có thể sử dụng chỉnh sử như Undo hay Redo
				editManager.addEdit(e.getEdit());

			}
		});

		// Xử lí sự kiện cho Undo
		itemUndo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Undo();
			}

			private void Undo() {
				// TODO Auto-generated method stub
				if (editManager.canUndo()) {
					editManager.undo();
				}
			}
		});

		// Xử lí sự kiện cho Cut
		itemCut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Cut();
			}

			private void Cut() {
				// TODO Auto-generated method stub
				// Sử công cụ Toolkit để thực thi với Clipboard
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				// Trả lại những dòng text đã đc chọn (bôi đen)
				String string = area.getSelectedText();
				// thực hiện việc lựa chọn chuỗi
				StringSelection selection = new StringSelection(string);
				// Đặt lại nội dung cho chuỗi
				clipboard.setContents(selection, selection);
				// repalceRange thay thế văn bản từ vị trí bắt đầu đến vị trí kết thúc bằng 1 chuỗi đã đc chỉ định
				area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());

			}
		});
		// Xử lí sự kiện cho phần Copy
		itemCopy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Copy();
			}

			private void Copy() {
				// TODO Auto-generated method stub
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				String str = area.getSelectedText();
				StringSelection selection = new StringSelection(str);
				clipboard.setContents(selection,selection);
				area.replaceRange(str, area.getSelectionStart(), area.getSelectionEnd());
				
			}
		});
		
		// Xử lí sự kiện cho Paste
		itemPaste.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Paste();
			}

			private void Paste() {
				// TODO Auto-generated method stub
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				// Transferable là 1 loại giao diện dùng để cung cấp dữ liệu cho 1 thao tác
				Transferable transferable = clipboard.getContents(clipboard);
				// DataFlavor thực hiện việc truy cấp dữ liệu trên bộ nhớ hoặc quá trình kéo thả
				// Nếu việc truy cập trên bộ nhớ là đúng ....
				if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
					try {
					//Trả lại một mảng các đối tượng DataFlavor mà dữ liệu có thể được cung cấp.
						String str = (String) (transferable.getTransferData(DataFlavor.stringFlavor));
						// Thực hiện việc trao đổi các chuỗi đã đc lựa chọns
						area.replaceSelection(str);
					} catch (UnsupportedFlavorException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			
			}
		});
		
		// Xử lí Delete 
		itemDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Delete();
			}

			private void Delete() {
				// TODO Auto-generated method stub
				/*Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				String str = area.getSelectedText();
				StringSelection selection = new StringSelection(str);*/
			    area.setText("");
			
			}
		});
		
		itemReplace.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Replace();
			}

		});
		
		itemSelectAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				area.selectAll();
				
			}
		});
		
		itemDatetime.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				time();
			}

			private void time() {
				// TODO Auto-generated method stub
				Calendar time = Calendar.getInstance();
				int hour = time.get(Calendar.HOUR_OF_DAY);
				int minute = time.get(Calendar.MINUTE);
				int day = time.get(Calendar.DATE);
				int month = time.get(Calendar.MONTH);
				int year = time.get(Calendar.YEAR);
				area.setFont(new Font("Consolas",Font.PLAIN , 15));
				area.setText(hour + ":"+minute +"  "+day+ "/"+month+"/"+year);
				
			}
		});
	}

	private void setControls() {
		// TODO Auto-generated method stub
		itemNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				New();

			}

			private void New() {
				// TODO Auto-generated method stub
				// Thực hiện đưa ra thông báo của JOptionPane với
				// showConfirmDialog
				int check = JOptionPane.showConfirmDialog(null, "Bạn muốn tạo mới ?", "Hộp thoại đang hỏi ???",
						JOptionPane.YES_NO_OPTION);
				if (check == JOptionPane.YES_OPTION) {
					area.setText("");
				} else {
					saveFile();
				}
			}
		});

		itemOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					openFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			private void openFile() throws IOException {
				chooser = new JFileChooser();
				// TODO Auto-generated method stub
				int restrival = JOptionPane.showConfirmDialog(null, "Bạn muốn mở file ?",
						"Hộp thoại hỏi bạn mở file ???", JOptionPane.YES_NO_OPTION);
				// cho phép hộp thoại mở file
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					if (restrival == JOptionPane.YES_OPTION) {
						try {
							// Đọc file bằng BufferedReader
							BufferedReader reader = new BufferedReader(
									new InputStreamReader(new FileInputStream(chooser.getSelectedFile()), "UTF8"));
							String line = reader.readLine();
							// Sử dụng StringBuider + vòng lặp để đọc hết toàn
							// bộ file
							StringBuilder builder = new StringBuilder();
							while (line != null) {
								// append để nối các xâu với nhau
								builder.append(line + "\n");
								line = reader.readLine();
							}
							// cuối cùng đưa toàn bộ ra TextArea
							area.setText(builder.toString());
							reader.close();

						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					} else {
						return;

					}
				}

			}
		});

		itemExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				exit();
			}

			private void exit() {
				// TODO Auto-generated method stub
				int check = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát ? ", "Hộp thoại hỏi thoát ???",
						JOptionPane.YES_NO_OPTION);
				if (check == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					return;
				}
			}
		});

		itemSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saveFile();
			}
		});
		
		itemFont.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FontEdit();
				
			}
		});

	}

	// Xử lí việc lưu file
	protected void saveFile() {
		// TODO Auto-generated method stub

		String str = area.getText();
		chooser = new JFileChooser();

		// Cho phép mở hộp thoại để lưu các tệp
		// Nếu nó trống thì ta trả lại giá trị tùy chọn
		if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			// Thực hiện đưa ra 1 lời xác nhận của JOptionPane với
			// showConfirmDialog
			int restrival = JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu file", "Hộp thoại hỏi lưu file ???",
					JOptionPane.YES_NO_OPTION);
			if (restrival == JOptionPane.YES_OPTION) {
				try {
					/*
					 * // Sử dụng ghi file để lưu file dưới dạng txt FileWriter
					 * fileWriter = new
					 * FileWriter(chooser.getSelectedFile()+".txt");
					 * 
					 * // Đưa toàn bộ các chữ trên TextArea vào file rồi lưu
					 * fileWriter.write(str.toString()); fileWriter.close(); //
					 * Đưa ra 1 lời thông báo
					 * 
					 */ // Thực hiện việc lưu file tiếng việt
					Writer writer = new BufferedWriter(
							new OutputStreamWriter(new FileOutputStream(chooser.getSelectedFile() + ".txt"), "UTF8"));
					writer.write(str.toString());
					writer.flush();
					writer.close();

					JOptionPane.showMessageDialog(null, "Lưu file thành công");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				return;

			}
		}
	}

	private void setUI() {
		// TODO Auto-generated method stub
		// tạo 1 thùng chứa (container)
		container = new Container();
		area = new JTextArea();
		// Tạo thanh cuộn cho Frame
		JScrollPane pane = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		container.setLayout(new BorderLayout());
		container.add(pane, BorderLayout.CENTER);
		this.add(container);

		menuBar = new JMenuBar();
		container.add(menuBar, BorderLayout.NORTH);

		file = new JMenu("File");
		itemNew = new JMenuItem("New");
		itemOpen = new JMenuItem("Open");
		itemSave = new JMenuItem("Save");
		itemExit = new JMenuItem("Exit");
		// Tạo dòng kẻ ngăn cách giữa các ItemFile
		file.add(itemNew);
		file.addSeparator();
		file.add(itemOpen);
		file.addSeparator();
		file.add(itemSave);
		file.addSeparator();
		file.add(itemExit);

		edit = new JMenu("Edit");
		itemUndo = new JMenuItem("Undo");
		itemCut = new JMenuItem("Cut");
		itemCopy = new JMenuItem("Copy");
		itemPaste = new JMenuItem("Paste");
		itemDelete = new JMenuItem("Delete");
		itemReplace = new JMenuItem("Replace ...");
		itemSelectAll = new JMenuItem("Select All");
		itemDatetime = new JMenuItem("Time/Date");
		edit.add(itemUndo);
		edit.addSeparator();
		edit.add(itemCut);
		edit.addSeparator();
		edit.add(itemCopy);
		edit.addSeparator();
		edit.add(itemPaste);
		edit.addSeparator();
		edit.add(itemDelete);
		edit.addSeparator();
		edit.add(itemReplace);
		edit.addSeparator();
		edit.add(itemSelectAll);
		edit.addSeparator();
		edit.add(itemDatetime);

		format = new JMenu("Format");
		itemWord = new JMenuItem("Word Wrap");
		itemFont = new JMenuItem("Font");
		format.add(itemWord);
		format.addSeparator();
		format.add(itemFont);

		view = new JMenu("View");
		itemStatus = new JMenuItem("Status Bar");
		itemStatus.setEnabled(false);
		view.add(itemStatus);
		
		help = new JMenu("Help");
		itemView = new JMenuItem("View Help");
		itemHelp = new JMenuItem("About Notepad");

		help.add(itemView);
		help.addSeparator();
		help.add(itemHelp);
		
		// thêm các tính năng vào thanh bar (thanh công cụ)
        menuBar.setFont(new Font("Callibri", Font.PLAIN, 15));
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(format);
		menuBar.add(view);
		menuBar.add(help);
		
	

		// thiết lập phím tắt cho các Item
		itemNew.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		itemOpen.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		itemSave.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		itemExit.setAccelerator(KeyStroke.getKeyStroke('E', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		itemUndo.setAccelerator(KeyStroke.getKeyStroke('U', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		itemCut.setAccelerator(KeyStroke.getKeyStroke('X', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		itemCopy.setAccelerator(KeyStroke.getKeyStroke('C', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		;
		itemDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		itemPaste.setAccelerator(KeyStroke.getKeyStroke('V', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		itemReplace.setAccelerator(KeyStroke.getKeyStroke('H', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		itemSelectAll.setAccelerator(KeyStroke.getKeyStroke('A', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		itemDatetime.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5,0));

	}
	
	
}


