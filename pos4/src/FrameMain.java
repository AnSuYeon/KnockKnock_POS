import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class FrameMain extends JFrame {
	private MainProcess mainprocess;
	private FramePay fp;

	private JPanel contentPane;
	private Image img_logo = new ImageIcon(FrameMain.class.getResource("reso/logo.png")).getImage()
			.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	private Image img_mypage = new ImageIcon(FrameMain.class.getResource("reso/mypage.png")).getImage()
			.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	private Image img_setting = new ImageIcon(FrameMain.class.getResource("reso/setting.png")).getImage()
			.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	private Image img_main = new ImageIcon(FrameMain.class.getResource("reso/main.png")).getImage()
			.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	private Image img_menu = new ImageIcon(FrameMain.class.getResource("reso/icon.png")).getImage()
			.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

	private startPanel startP;
	private mypagePanel mypageP;
	private settingPanel settingP;
	private mainPanel mainP;
	private menuPanel menuP;

	/**
	 * Create the frame.
	 */
	public FrameMain() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 810, 517);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		startP = new startPanel();
		mypageP = new mypagePanel();
		settingP = new settingPanel();
		mainP = new mainPanel();
		menuP = new menuPanel();

		// 占쎈쐻占쎈솭占쎈솇占쎌굲
		JPanel menu_Panel = new JPanel();
		menu_Panel.setBackground(Color.ORANGE);
		menu_Panel.setBounds(0, 0, 134, 517);
		contentPane.add(menu_Panel);
		menu_Panel.setLayout(null);

		// Mypage Button
		JPanel myPage_Panel = new JPanel();
		myPage_Panel.addMouseListener(new PanelButtonMouseAdapter(myPage_Panel) {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				menuCliked(mypageP);
			}
		});
		myPage_Panel.setBackground(Color.ORANGE);
		myPage_Panel.setBounds(0, 80, 137, 100);
		menu_Panel.add(myPage_Panel);
		myPage_Panel.setLayout(null);

		JLabel mypageLabel = new JLabel("My Page");
		mypageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mypageLabel.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		mypageLabel.setForeground(SystemColor.text);
		mypageLabel.setBounds(32, 62, 75, 28);
		myPage_Panel.add(mypageLabel);

		JLabel mypageIconLabel = new JLabel("");
		mypageIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mypageIconLabel.setBounds(45, 10, 50, 50);
		myPage_Panel.add(mypageIconLabel);
		mypageIconLabel.setIcon(new ImageIcon(img_mypage));

		// Setting Button
		JPanel setting_Panel = new JPanel();
		setting_Panel.addMouseListener(new PanelButtonMouseAdapter(setting_Panel) {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				menuCliked(settingP);
			}
		});
		setting_Panel.setBackground(Color.ORANGE);
		setting_Panel.setBounds(0, 180, 137, 100);
		menu_Panel.add(setting_Panel);
		setting_Panel.setLayout(null);

		JLabel settingLabel = new JLabel("Setting");
		settingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		settingLabel.setForeground(Color.WHITE);
		settingLabel.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		settingLabel.setBounds(32, 62, 75, 28);
		setting_Panel.add(settingLabel);

		JLabel settingIconLabel = new JLabel("");
		settingIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		settingIconLabel.setBounds(45, 10, 50, 50);
		setting_Panel.add(settingIconLabel);
		settingIconLabel.setIcon(new ImageIcon(img_setting));

		// main button
		JPanel main_Panel = new JPanel();
		main_Panel.addMouseListener(new PanelButtonMouseAdapter(main_Panel) {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				mainprocess.showFramePayment();
			}
		});
		main_Panel.setBackground(Color.ORANGE);
		main_Panel.setBounds(0, 377, 137, 100);
		menu_Panel.add(main_Panel);
		main_Panel.setLayout(null);

		JLabel mainLabel = new JLabel("Main");
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setForeground(Color.WHITE);
		mainLabel.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		mainLabel.setBounds(32, 62, 75, 28);
		main_Panel.add(mainLabel);

		JLabel mainIconLabel = new JLabel("");
		mainIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainIconLabel.setBounds(45, 10, 50, 50);
		main_Panel.add(mainIconLabel);
		mainIconLabel.setIcon(new ImageIcon(img_main));

		// Home Panel
		JPanel startLogoPanel = new JPanel();
		startLogoPanel.setLayout(null);
		startLogoPanel.addMouseListener(new PanelButtonMouseAdapter(startLogoPanel) {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				menuCliked(startP);
			}
		});
		startLogoPanel.setBackground(Color.ORANGE);
		startLogoPanel.setBounds(0, 0, 137, 80);
		menu_Panel.add(startLogoPanel);

		JLabel titleLabel = new JLabel("KNOCK");
		titleLabel.setBounds(9, 21, 69, 30);
		startLogoPanel.add(titleLabel);
		titleLabel.setForeground(new Color(255, 127, 80));
		titleLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel titleLabel_1 = new JLabel("KNOCK");
		titleLabel_1.setBounds(61, 34, 69, 30);
		startLogoPanel.add(titleLabel_1);
		titleLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel_1.setForeground(new Color(255, 99, 71));
		titleLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));

		// menu Button
		JPanel mnPane = new JPanel();
		mnPane.setLayout(null);
		mnPane.addMouseListener(new PanelButtonMouseAdapter(mnPane) {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				menuCliked(menuP);
			}
		});
		mnPane.setBackground(Color.ORANGE);
		mnPane.setBounds(0, 277, 137, 100);
		menu_Panel.add(mnPane);

		JLabel mnLabel_1 = new JLabel("Menu");
		mnLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		mnLabel_1.setForeground(Color.WHITE);
		mnLabel_1.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		mnLabel_1.setBounds(32, 62, 75, 28);
		mnPane.add(mnLabel_1);

		JLabel mnIconLabel = new JLabel("");
		mnIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mnIconLabel.setBounds(45, 10, 50, 50);
		mnIconLabel.setIcon(new ImageIcon(img_menu));
		mnPane.add(mnIconLabel);

		// close button
		JLabel closeLabel = new JLabel("X");
		closeLabel.setBounds(790, 0, 16, 33);
		contentPane.add(closeLabel);
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?",
						"Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					FrameMain.this.dispose();
				}
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

		JPanel mainContentPanel = new JPanel();
		mainContentPanel.setBounds(149, 10, 640, 497);
		contentPane.add(mainContentPanel);
		mainContentPanel.setLayout(null);

		mainContentPanel.add(startP);
		mainContentPanel.add(mypageP);
		mainContentPanel.add(settingP);
		mainContentPanel.add(mainP);
		mainContentPanel.add(menuP);

		menuCliked(startP);
		setVisible(true);
	}

	public void menuCliked(JPanel setpanel) {
		startP.setVisible(false);
		mypageP.setVisible(false);
		settingP.setVisible(false);
		mainP.setVisible(false);
		menuP.setVisible(false);

		setpanel.setVisible(true);
	}

	public void setMain(MainProcess mainprocess) {
		this.mainprocess = mainprocess;
	}

	private class PanelButtonMouseAdapter extends MouseAdapter {

		JPanel panel;

		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(218, 165, 32));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(Color.ORANGE);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(218, 165, 32));
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(218, 165, 32));
		}

	}
}
