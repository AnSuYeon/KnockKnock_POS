package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import database.User;

import javax.swing.table.DefaultTableModel;

public class menuDAO {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://js06m13.cafe24.com/js06m13";
	private static final String USER = "js06m13";
	private static final String PASS = "mcjoojh0562!";

	// DB 뿰寃 硫붿냼 뱶
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

	// 로그인시 저장된 메뉴 로드
	public ArrayList<menuDTO> loadMenu() {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<menuDTO> list = new ArrayList<menuDTO>();
		try {
			con = getConn();
			String sql = "SELECT menuname, menuprice  FROM menu WHERE res_code2 = ? ORDER BY menuname ASC";
			pstmt = con.prepareStatement(sql);
			String code = User.getRes_code();
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				menuDTO dto = new menuDTO();
				dto.setManuname(rs.getString("menuname"));
				dto.setMenuprice(rs.getString("menuprice"));
				list.add(dto);
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
		return list;
	}

	// 메뉴 삽입
	public void insertMenu(menuDTO dto) {

		Connection con = null;
		String sql = "insert into menu (res_code2, menuname,menuprice) values (?,?,?)";
		PreparedStatement ps = null;

		int res_code2 = Integer.parseInt(User.getRes_code());
		try {
			con = getConn();
			ps = con.prepareStatement(sql);

			ps.setString(1, Integer.toString(res_code2));
			ps.setString(2, dto.getManuname());
			ps.setString(3, dto.getMenuprice());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("menuDAO.insetMenu : " + e.getMessage());
		}

		finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void deleteMenu(String menuname) {
		// boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConn();
			String sql = "delete from menu where menuname=? and res_code2=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, menuname);
			ps.setString(2, User.getRes_code());
			int r = ps.executeUpdate(); // 실행 -> 삭제

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		// return ok;
	}

	public Vector<menuDTO> Getsellcount() { // 오늘 판매된 메뉴
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select menuname from menu group by menuname";
		Vector<menuDTO> lists = new Vector<menuDTO>();

		try {
			con = getConn();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				menuDTO dto = new menuDTO();
				dto.setManuname(rs.getString("menuname"));
				dto.setMenuprice(rs.getString("menuprice"));
				lists.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return lists;
	}

	public Object[][] makeArr(Vector<menuDTO> lists) {
		Object[][] menuArr = new Object[lists.size()][2];

		for (int i = 0; i < lists.size(); i++) {
			menuArr[i][0] = lists.get(i).getManuname();
			menuArr[i][1] = lists.get(i).getMenuprice();
		}
		return menuArr;
	}

}