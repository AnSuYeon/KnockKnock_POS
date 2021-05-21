import javax.swing.JFrame;
import java.sql.*;

public class MainProcess {
	FrameLogin f_login;
	FrameMain f_main;
	FramePay f_pay;
	FrameSignUp f_sign;

	FramePack f_pack;
	Framewait f_wait;

	static MainProcess main;

	public static void main(String[] args) {
		// �������μ��� ����
		main = new MainProcess();

		main.f_login = new FrameLogin();
		main.f_login.setMain(main);

	}

	public void showFrameSignUp() {

		this.f_sign = new FrameSignUp();
	}

	public void showFrameMain() {
		f_login.dispose();
		this.f_main = new FrameMain();
		main.f_main.setMain(main);
	}

	public void showFramePayment() {
		f_main.dispose();
		this.f_pay = new FramePay();
		main.f_pay.setMain(main);
	}

	public void showFramePack() {
		this.f_pack = new FramePack();
	}

	public void showFramewait() {
		this.f_wait = new Framewait();
	}
}
