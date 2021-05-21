import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import database.signupDAO;
import database.signupDTO;
import database.menuDAO;
import database.menuDTO;

public class FrameSignUp extends JFrame {

	private JPanel contentPane;
	private JTextField IdtextField;
	private JTextField PwtextField;
	private JTextField nametextField;
	private JTextField addrtextField;
	private JTextField numtextField;
	private JTextField timetextField;
	private boolean check = false;

	signupDAO signupdao;
	signupDTO signupdto;
	menuDAO menudao;
	menuDTO menudto;
	String str;

	public FrameSignUp() {

		setUndecorated(true);
		setBounds(150, 200, 450, 592);
		signupdao = new signupDAO();
		signupdto = new signupDTO();

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel logolabel2 = new JLabel("KNOCK");
		logolabel2.setForeground(Color.RED);
		logolabel2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
		logolabel2.setAlignmentX(1.0f);
		logolabel2.setBounds(219, 37, 157, 34);
		contentPane.add(logolabel2);

		JLabel logolabel = new JLabel("KNOCK");
		logolabel.setForeground(new Color(255, 69, 0));
		logolabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
		logolabel.setAlignmentX(1.0f);
		logolabel.setBounds(150, 21, 110, 28);
		contentPane.add(logolabel);

		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "CLOSE?", "confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					FrameSignUp.this.dispose();
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblX.setForeground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				lblX.setForeground(Color.BLACK);
			}
		});
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(Color.BLACK);
		lblX.setFont(new Font("Arial", Font.BOLD, 20));
		lblX.setBounds(409, 0, 41, 40);
		contentPane.add(lblX);

		JLabel newLabel = new JLabel("\uAC00\uAC8C \uC774\uB984 :");
		newLabel.setHorizontalAlignment(SwingConstants.LEFT);
		newLabel.setForeground(Color.DARK_GRAY);
		newLabel.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
		newLabel.setBounds(65, 263, 84, 15);
		contentPane.add(newLabel);

		JLabel newLabel_1 = new JLabel("\uC804\uD654\uBC88\uD638 :");
		newLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		newLabel_1.setForeground(Color.DARK_GRAY);
		newLabel_1.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
		newLabel_1.setBounds(65, 398, 84, 15);
		contentPane.add(newLabel_1);

		JLabel newLabel_2 = new JLabel("\uAC00\uAC8C \uC704\uCE58 :");
		newLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		newLabel_2.setForeground(Color.DARK_GRAY);
		newLabel_2.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
		newLabel_2.setBounds(65, 327, 84, 15);
		contentPane.add(newLabel_2);

		JLabel newLabel_3 = new JLabel("\uC601\uC5C5 \uC2DC\uAC04 :");
		newLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		newLabel_3.setForeground(Color.DARK_GRAY);
		newLabel_3.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
		newLabel_3.setBounds(65, 468, 84, 15);
		contentPane.add(newLabel_3);

		JLabel lblId = new JLabel("ID :");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setForeground(Color.DARK_GRAY);
		lblId.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
		lblId.setBounds(65, 124, 84, 15);
		contentPane.add(lblId);

		JLabel lblPw = new JLabel("PW :");
		lblPw.setHorizontalAlignment(SwingConstants.LEFT);
		lblPw.setForeground(Color.DARK_GRAY);
		lblPw.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
		lblPw.setBounds(65, 173, 84, 15);
		contentPane.add(lblPw);

		// 회占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙

		System.out.print("signup Frame load success");

		JButton signupButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		signupButton.setFont(new Font("한컴 고딕", Font.PLAIN, 14));
		signupButton.setBounds(175, 530, 97, 23);
		signupButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (check == false) {
					JOptionPane.showMessageDialog(null, "아이디 중복체크를 해주세요");
				} else {
					contentSet();
					contentClear();
					FrameSignUp.this.dispose();
				}

			}

		});

		contentPane.add(signupButton);

		IdtextField = new JTextField();
		IdtextField.setBounds(161, 124, 110, 21);
		contentPane.add(IdtextField);
		IdtextField.setColumns(10);

		PwtextField = new JTextField();
		PwtextField.setColumns(10);
		PwtextField.setBounds(161, 174, 215, 21);
		contentPane.add(PwtextField);

		nametextField = new JTextField();
		nametextField.setColumns(10);
		nametextField.setBounds(161, 258, 215, 21);
		contentPane.add(nametextField);

		addrtextField = new JTextField();
		addrtextField.setColumns(10);
		addrtextField.setBounds(161, 322, 215, 21);
		contentPane.add(addrtextField);

		numtextField = new JTextField();
		numtextField.setColumns(10);
		numtextField.setBounds(161, 393, 215, 21);
		contentPane.add(numtextField);

		timetextField = new JTextField();
		timetextField.setColumns(10);
		timetextField.setBounds(161, 463, 215, 21);
		contentPane.add(timetextField);

		JButton checkButton = new JButton("중복체크");
		checkButton.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
		checkButton.setBounds(283, 122, 93, 23);
		checkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (signupdao.idCheck(IdtextField.getText())) {
					JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.");
					IdtextField.setText("");
				}

				else {
					JOptionPane.showMessageDialog(null, "사용가능한 아이디 입니다.");
					str = IdtextField.getText();
					check = true;
				}
			}

		});
		contentPane.add(checkButton);

		setVisible(true);
	}

	public void contentSet() {
		String res_name = null;
		String res_num = null;
		String res_gps = null;
		String res_time = null;
		String res_id = null;
		String res_pw = null;

		if (nametextField.getText().equals("") || numtextField.getText().equals("")
				|| addrtextField.getText().equals("") || timetextField.getText().equals("")
				|| IdtextField.getText().equals("") || PwtextField.getText().equals(""))
			JOptionPane.showMessageDialog(this, "공백 없이 입력해 주세요.");
		else {
			res_name = nametextField.getText();
			res_num = numtextField.getText();
			res_gps = addrtextField.getText();
			res_time = timetextField.getText();
			res_id = str;
			res_pw = PwtextField.getText();
		}

		signupdto.setRes_name(res_name);
		signupdto.setRes_num(res_num);
		signupdto.setRes_gps(res_gps);
		signupdto.setRes_time(res_time);
		signupdto.setRes_id(res_id);
		signupdto.setRes_pw(res_pw);

		signupdao.Signup(signupdto);
	}

	public void contentClear() {
		nametextField.setText("");
		numtextField.setText("");
		addrtextField.setText("");
		timetextField.setText("");
		IdtextField.setText("");
		PwtextField.setText("");
	}
}
