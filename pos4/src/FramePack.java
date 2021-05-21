import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class FramePack extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public FramePack() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 500, 33);
		contentPane.add(panel);

		JLabel lblKnockKnockPackage = new JLabel("Knock Knock Package");
		lblKnockKnockPackage.setForeground(Color.WHITE);
		lblKnockKnockPackage.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		lblKnockKnockPackage.setBounds(12, 0, 218, 31);
		panel.add(lblKnockKnockPackage);

		JLabel closeLabel = new JLabel("X");
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				FramePack.this.dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				closeLabel.setForeground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				closeLabel.setForeground(Color.black);
			}
		});
		closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		closeLabel.setForeground(Color.BLACK);
		closeLabel.setFont(new Font("한컴 고딕", Font.BOLD, 24));
		closeLabel.setBounds(484, -3, 16, 33);
		panel.add(closeLabel);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { "\uC190\uB2D8\uBA85", "\uBA54\uB274\uBA85" }, { null, null }, { null, null }, },
				new String[] { "\uC190\uB2D8\uBA85", "\uBA54\uB274\uBA85" }));
		table.setBounds(10, 43, 476, 571);
		contentPane.add(table);

		JButton finButton = new JButton("\uD3EC\uC7A5 \uC644\uB8CC");
		finButton.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		finButton.setBounds(34, 636, 426, 41);
		contentPane.add(finButton);

		setVisible(true);
	}
}
