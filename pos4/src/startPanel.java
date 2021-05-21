import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class startPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public startPanel() {
		setBounds(0, 0, 640, 497);
		setLayout(null);
		setVisible(true);

		JLabel lblNewLabel = new JLabel("\uB109\uB109 POS PROGRAM");
		lblNewLabel.setBounds(130, 45, 400, 95);
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 41));

		JLabel label = new JLabel("");
		label.setBounds(412, 6, 229, 158);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(646, 6, 136, 158);

		JLabel lblWelcomeToknockknock = new JLabel("Welcome to \"KnockKnock\" Pos program");
		lblWelcomeToknockknock.setBounds(130, 138, 400, 26);
		lblWelcomeToknockknock.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToknockknock.setForeground(Color.LIGHT_GRAY);
		lblWelcomeToknockknock.setFont(new Font("Ink Free", Font.BOLD, 20));

		JLabel lblTip = new JLabel("\uD504\uB85C\uADF8\uB7A8 \uC0AC\uC6A9 TIP \r\n");
		lblTip.setBounds(253, 239, 136, 26);
		lblTip.setHorizontalAlignment(SwingConstants.CENTER);
		lblTip.setForeground(Color.DARK_GRAY);
		lblTip.setFont(new Font("한컴 고딕", Font.PLAIN, 16));

		JLabel lblTip_1 = new JLabel(
				"1. \uB300\uAE30\uBA85\uB2E8\uACFC \uD3EC\uC7A5\uC8FC\uBB38 \uAC04\uD3B8 \uD655\uC778 \uAC00\uB2A5");
		lblTip_1.setBounds(118, 290, 400, 36);
		lblTip_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTip_1.setForeground(Color.DARK_GRAY);
		lblTip_1.setFont(new Font("한컴 고딕", Font.PLAIN, 16));

		JLabel lblTip_2 = new JLabel("2. \uB9E4\uCD9C\uD604\uD669\uC744 \uD55C\uB208\uC5D0 \uD655\uC778 \uAC00\uB2A5");
		lblTip_2.setBounds(213, 334, 229, 36);
		lblTip_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTip_2.setForeground(Color.DARK_GRAY);
		lblTip_2.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
		setLayout(null);
		add(lblNewLabel);
		add(label);
		add(label_1);
		add(lblWelcomeToknockknock);
		add(lblTip);
		add(lblTip_1);
		add(lblTip_2);
	}

}
