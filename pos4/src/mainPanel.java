import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class mainPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public mainPanel() {
		setBounds(0, 0, 640, 497);
		setLayout(null);

		JLabel payLabel = new JLabel("\uACB0\uC81C\uCC3D");
		payLabel.setBounds(278, 209, 60, 27);
		payLabel.setHorizontalAlignment(SwingConstants.CENTER);
		payLabel.setForeground(Color.ORANGE);
		payLabel.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		add(payLabel);
	}

}
