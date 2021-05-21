package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class tableDAO {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://js06m13.cafe24.com/js06m13";
	private static final String USER = "js06m13";
	private static final String PASS = "mcjoojh0562!";
	ArrayList<tableDTO> members = new ArrayList<tableDTO>();

	public tableDAO() {
		this.getList();
	}

	public Connection getConn() {

		Connection con = null;

		try {
			Class.forName(DRIVER);

			con = DriverManager.getConnection(URL, USER, PASS);
			System.out.print("Table DB Connect Success\n");

		} catch (ClassNotFoundException e) {
			System.out.print("Table Driver load fail\n");
		} catch (SQLException e) {
			System.out.print("Table Connect fail\n");
			System.out.print(e);
		}
		return con;
	}

	// login시 table load
	public ArrayList<tableDTO> getLoad() {
		ArrayList<tableDTO> list = new ArrayList<tableDTO>();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {
			con = getConn();
			String sql = "SELECT alone, two, four, many  FROM rtable WHERE res_code7 = ?";
			pstmt = con.prepareStatement(sql);
			String code = User.getRes_code();
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				tableDTO dto = new tableDTO();
				dto.setalone(Integer.parseInt(rs.getString("alone")));
				dto.settwo(Integer.parseInt(rs.getString("two")));
				dto.setfour(Integer.parseInt(rs.getString("four")));
				dto.setmany(Integer.parseInt(rs.getString("many")));
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

	public void Table(tableDTO dto) {

		Connection con = null;
		String sql = "insert into rtable (res_code7, alone, two, four, many) values ((SELECT res_code FROM restaurant WHERE res_code = ?),?,?,?,?)";
		PreparedStatement ps = null;

		try {
			con = getConn();
			ps = con.prepareStatement(sql);

			ps.setInt(1, Integer.parseInt(User.getRes_code()));
			ps.setInt(2, dto.getalone());
			ps.setInt(3, dto.gettwo());
			ps.setInt(4, dto.getfour());
			ps.setInt(5, dto.getmany());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("tableDAO.table : " + e.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public ArrayList<tableDTO> getList() {
		Connection con = null;
		Statement ps = null;
		ResultSet rs = null;

		try {
			con = getConn();
			String sql = "select * from rtable";
			ps = con.createStatement();
			rs = ps.executeQuery(sql);

			while (rs.next()) {
				tableDTO dto = new tableDTO();
				dto.setcode7(rs.getInt("res_code7"));
				dto.setalone(rs.getInt("alone"));
				dto.settwo(rs.getInt("two"));
				dto.setfour(rs.getInt("four"));
				dto.setmany(rs.getInt("many"));
				members.add(dto);
			}
			return members;
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
		return null;
	}

	public boolean update(tableDTO dto) {
		Connection con = null;
		String sql = "UPDATE rtable SET alone=?, two=?, four=?, many=? WHERE res_code7 = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;

		boolean b = false;
		try {
			con = getConn();
			ps = con.prepareStatement(sql);

			ps.setInt(1, dto.getalone());
			ps.setInt(2, dto.gettwo());
			ps.setInt(3, dto.getfour());
			ps.setInt(4, dto.getmany());
			ps.setInt(5, Integer.parseInt(User.getRes_code()));

			if (ps.executeUpdate() > 0)
				b = true;

		} catch (Exception e) {
			System.out.println("modifyData err : " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return b;
	}
}
