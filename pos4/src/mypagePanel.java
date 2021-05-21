import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import database.User;
import database.mypageDAO;
import database.mypageDTO;
import database.signupDAO;

public class mypagePanel extends JPanel {

	private Image img_profile = new ImageIcon(FrameMain.class.getResource("reso/profile.png")).getImage()
			.getScaledInstance(112, 132, Image.SCALE_SMOOTH);

	public mypagePanel() {
		setBounds(0, 0, 640, 497);
		setLayout(null);

		JLabel idLabel = new JLabel("ID :");
		idLabel.setHorizontalAlignment(SwingConstants.LEFT);
		idLabel.setForeground(Color.BLACK);
		idLabel.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
		idLabel.setBounds(168, 25, 116, 25);
		add(idLabel);

		JLabel nameLabel = new JLabel("\uAC00\uAC8C \uC774\uB984:");
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
		nameLabel.setBounds(168, 65, 116, 25);
		add(nameLabel);

		JLabel infoLabel = new JLabel("가게 번호 :");
		infoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		infoLabel.setForeground(Color.BLACK);
		infoLabel.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
		infoLabel.setBounds(168, 105, 116, 25);
		add(infoLabel);

		JLabel profilLabel = new JLabel("");
		profilLabel.setForeground(new Color(0, 0, 0));
		profilLabel.setBounds(12, 24, 112, 132);
		profilLabel.setIcon(new ImageIcon(img_profile));
		add(profilLabel);

		JLabel lblPw_1_1 = new JLabel("\uB9E4\uCD9C\uD604\uD669");
		lblPw_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPw_1_1.setForeground(Color.BLACK);
		lblPw_1_1.setFont(new Font("        ", Font.PLAIN, 16));
		lblPw_1_1.setBounds(12, 205, 64, 22);
		add(lblPw_1_1);

		JPanel payPanel = new JPanel();
		payPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		payPanel.setBounds(12, 237, 616, 250);
		add(payPanel);

		JLabel inputIdLabel = new JLabel("" + User.getRes_id());
		inputIdLabel.setHorizontalAlignment(SwingConstants.LEFT);
		inputIdLabel.setForeground(Color.BLACK);
		inputIdLabel.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
		inputIdLabel.setBounds(296, 25, 294, 25);
		add(inputIdLabel);

		JLabel inputNameLabel = new JLabel("" + User.getRes_name());
		inputNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		inputNameLabel.setForeground(Color.BLACK);
		inputNameLabel.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
		inputNameLabel.setBounds(296, 65, 294, 25);
		add(inputNameLabel);

		JLabel inputNumLabel = new JLabel("" + User.getRes_num());
		inputNumLabel.setVerticalAlignment(SwingConstants.TOP);
		inputNumLabel.setHorizontalAlignment(SwingConstants.LEFT);
		inputNumLabel.setForeground(Color.BLACK);
		inputNumLabel.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
		inputNumLabel.setBounds(296, 105, 294, 25);
		add(inputNumLabel);

		JLabel infoLabel_1 = new JLabel("가게 위치 :");
		infoLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		infoLabel_1.setForeground(Color.BLACK);
		infoLabel_1.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
		infoLabel_1.setBounds(168, 145, 116, 25);
		add(infoLabel_1);

		JLabel inputInfoLabel = new JLabel("" + User.getRes_gps());
		inputInfoLabel.setVerticalAlignment(SwingConstants.TOP);
		inputInfoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		inputInfoLabel.setForeground(Color.BLACK);
		inputInfoLabel.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
		inputInfoLabel.setBounds(296, 145, 294, 22);
		add(inputInfoLabel);

		JLabel infoLabel_1_1 = new JLabel("영업 시간 :");
		infoLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		infoLabel_1_1.setForeground(Color.BLACK);
		infoLabel_1_1.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
		infoLabel_1_1.setBounds(168, 185, 116, 22);
		add(infoLabel_1_1);

		JLabel inputTimeLabel = new JLabel("" + User.getRes_time());
		inputTimeLabel.setVerticalAlignment(SwingConstants.TOP);
		inputTimeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		inputTimeLabel.setForeground(Color.BLACK);
		inputTimeLabel.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
		inputTimeLabel.setBounds(296, 185, 294, 22);
		add(inputTimeLabel);
	}

}