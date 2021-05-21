import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import database.menuDAO;
import database.menuDTO;

public class menuPanel extends JPanel {
	public JTextField nameText;
	public JTextField costText;
	public JTable menuTable;
	public int rownum;

	JScrollPane sc;
	ArrayList<menuDTO> list = new ArrayList<menuDTO>();
	static ArrayList<menuDTO> arr = new ArrayList<menuDTO>();

	Vector<String> userColumn;
	DefaultTableModel model;
	Object recode[] = new Object[2];
	menuDAO menudao;
	menuDTO menudto;

	public menuPanel() {

		setBounds(0, 0, 640, 497);
		setLayout(null);
		menudao = new menuDAO();
		menudto = new menuDTO();

		JLabel lblNewLabel = new JLabel("\uC774\uB984 :");
		lblNewLabel.setFont(new Font("한컴 고딕 ", Font.PLAIN, 16));
		lblNewLabel.setBounds(388, 58, 57, 15);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uAC00\uACA9 :");
		lblNewLabel_1.setFont(new Font("한컴 고딕 ", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(388, 115, 57, 15);
		add(lblNewLabel_1);

		nameText = new JTextField();
		nameText.setBounds(441, 58, 172, 21);
		add(nameText);
		nameText.setColumns(10);

		costText = new JTextField();
		costText.setColumns(10);
		costText.setBounds(441, 115, 172, 21);
		add(costText);

		// Jtable 추가
		userColumn = new Vector<String>();
		userColumn.addElement("name");
		userColumn.addElement("price");
		model = new DefaultTableModel(userColumn, 0);
		this.loadTabel();

		menuTable = new JTable(model);
		menuTable.setToolTipText("");
		menuTable.setFont(new Font("한컴 고딕 ", Font.PLAIN, 16));
		menuTable.setBounds(12, 22, 355, 465);
		add(menuTable);

		JButton addButton = new JButton("\uCD94\uAC00");
		addButton.setFont(new Font("한컴 고딕 ", Font.PLAIN, 20));
		addButton.setBounds(443, 283, 125, 67);
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				addTable(nameText.getText(), costText.getText());
				contentSet();
				contentClear();
				// 저장된 메뉴 다시 load
//            arr.clear();
//            arr = menudao.loadMenu();
			}
		});
		add(addButton);

		// 占쏙옙占쏙옙 占쏙옙튼
		JButton deleteButton = new JButton("\uC0AD\uC81C");
		deleteButton.setFont(new Font("한컴고딕", Font.PLAIN, 20));
		deleteButton.setBounds(443, 369, 125, 68);
		deleteButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				model = (DefaultTableModel) menuTable.getModel();
				int row = menuTable.getSelectedRow();
				if (row < 0)
					return;
				contentSet2(row);
				model.removeRow(row);
			}
		});
		add(deleteButton);

	}

	// Table 占쏙옙 占쌩곤옙
	public void loadTabel() {
		list = menudao.loadMenu();
		for (rownum = 0; rownum < list.size(); rownum++) {
			recode[0] = list.get(rownum).getManuname();
			recode[1] = list.get(rownum).getMenuprice();
			model.addRow(recode);
		}
		list.clear();
	}

	public void addTable(String name, String price) {
		Object[] user = new Object[2];
		user[0] = name;
		user[1] = price;
		model.addRow(user);
	}

	public void contentSet() {
		String menuname = null;
		String menuprice = null;

		if (nameText.getText().equals("") || costText.getText().equals(""))
			JOptionPane.showMessageDialog(this, "빈칸이 없이 입력해주세요");
		else {
			menuname = nameText.getText();
			menuprice = costText.getText();
		}
		menudto.setManuname(menuname);
		menudto.setMenuprice(menuprice);

		menudao.insertMenu(menudto);
	}

	public void contentSet2(int row) {
		String menuname = null;

		menuname = (String) model.getValueAt(row, 0);
		menudao.deleteMenu(menuname);
	}

	public void contentClear() {
		nameText.setText("");
		costText.setText("");
	}
}
