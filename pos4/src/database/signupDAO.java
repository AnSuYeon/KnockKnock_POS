package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class signupDAO {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://js06m13.cafe24.com/js06m13";
	private static final String USER = "js06m13";
	private static final String PASS = "mcjoojh0562!";
	ArrayList<signupDTO> members = new ArrayList<signupDTO>();

	public String setid;

	// DB 肉겼칰 簾ル뗄�꺖 諭�
	public signupDAO() {

	}

	public Connection getConn() {

		Connection con = null;

		try {
			Class.forName(DRIVER);

			con = DriverManager.getConnection(URL, USER, PASS);
			System.out.print("DB Connect Success");

		} catch (ClassNotFoundException e) {
			System.out.print("Driver load fail");
		} catch (SQLException e) {
			System.out.print("Connect fail");
			System.out.print(e);
		}
		return con;
	}

	public void Signup(signupDTO dto) {

		Connection con = null;
		String sql = "insert into restaurant (res_name, res_num, res_gps, res_time, res_id, res_pw) values (?,?,?,?,?,?)";
		PreparedStatement ps = null;

		try {
			con = getConn();
			ps = con.prepareStatement(sql);

			ps.setString(1, dto.getRes_name());
			ps.setString(2, dto.getRes_num());
			ps.setString(3, dto.getRes_gps());
			ps.setString(4, dto.getRes_time());
			ps.setString(5, dto.getRes_id());
			ps.setString(6, dto.getRes_pw());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("signupDAO.Signup : " + e.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void getList() {
		Connection con = null;
		Statement ps = null;
		ResultSet rs = null;

		try {
			con = getConn();
			String sql = "select * from restaurant";
			ps = con.createStatement();
			rs = ps.executeQuery(sql);

			while (rs.next()) {
				signupDTO dto = new signupDTO();
				dto.setRes_name(rs.getString("res_name"));
				dto.setRes_num(rs.getString("res_num"));
				dto.setRes_gps(rs.getString("res_gps"));
				dto.setRes_time(rs.getString("res_time"));
				dto.setRes_id(rs.getString("res_id"));
				dto.setRes_pw(rs.getString("res_pw"));
				members.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public boolean idCheck(String id) {
		boolean check = true;
		signupDTO id_check = FindById(id);
		if (id_check == null)
			check = false;
		return check;
	}

	private signupDTO FindById(String id) {
		this.getList();
		for (signupDTO signupdto : members) {
			if (signupdto.getRes_id().equals(id)) {
				return signupdto;
			}
		}
		return null;
	}

	public boolean Login(signupDTO dto) {
		Connection con = null;
		String sql = "select * from restaurant";
		Statement ps = null;
		ResultSet rs = null;

		try {
			con = getConn();
			ps = con.createStatement();
			rs = ps.executeQuery(sql);

			String id = dto.getRes_id();
			String pw = dto.getRes_pw();

			signupDTO member = FindById(id);

			if (member == null) {
				JOptionPane.showMessageDialog(null, "id나 password가 틀렸습니다.");
				return false;
			} else if (member.getRes_pw().equals(pw)) {
				JOptionPane.showMessageDialog(null, "[" + member.getRes_id() + "]님이 로그인하셨습니다.");
				getMember(id);

				return true;
			} else {
				JOptionPane.showMessageDialog(null, "회원정보가 없습니다");
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("signupDAO.Signup : " + e.getMessage());

		} finally {
			try {
				if (rs != null)
					ps.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// 로그인한 회원의 정보 저장(완료)
	public void getMember(String no) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {

			con = getConn();
			String sql = "SELECT res_code, res_name, res_num, res_gps, res_time  FROM restaurant WHERE res_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String res_code = rs.getString(("res_code"));
				String res_id = no;
				String res_name = rs.getString("res_name");
				String res_num = rs.getString("res_num");
				String res_gps = rs.getString("res_gps");
				String res_time = rs.getString("res_time");
				User.setRes_code(res_code);
				User.setRes_id(res_id);
				User.setRes_name(res_name);
				User.setRes_num(res_num);
				User.setRes_gps(res_gps);
				User.setRes_time(res_time);
			}

		} catch (Exception e) {
			System.out.println("예외발생:deleteMember()=> " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
