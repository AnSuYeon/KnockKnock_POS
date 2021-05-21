package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import com.mysql.jdbc.Statement;

public class payDAO {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://js06m13.cafe24.com/js06m13";
	private static final String USER = "js06m13";
	private static final String PASS = "mcjoojh0562!";
	int count=1;
	int res_code2 = Integer.parseInt(User.getRes_code());
	// DB 연결
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
	
	

	// 저장된 메뉴 로드
	public ArrayList<payDTO> getMenu() {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<payDTO> list = new ArrayList<payDTO>();
		try {
			con = getConn();
			String sql = "SELECT menuname, menuprice  FROM menu WHERE res_code2 = ? ORDER BY menuname ASC";
			pstmt = con.prepareStatement(sql);
			String code = User.getRes_code();
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				payDTO dto = new payDTO();
				dto.setMenuname(rs.getString("menuname"));
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

	
	//table 로드
	public ArrayList<payDTO> getTable() {
		ArrayList<payDTO> list = new ArrayList<payDTO>();
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
				payDTO dto = new payDTO();
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

	// table별 메뉴 삽입
	public void insertMenu(payDTO dto) {
		Connection con = null;
		String sql = "INSERT INTO tablemenu (tablenum,menucount,menu_code2,res_code8,headcount) VALUES (?,?,(SELECT menu_code FROM menu WHERE menuname = ? and res_code2 =?),?,?)";
		PreparedStatement ps = null;

		

		try {
			con = getConn();
			ps = con.prepareStatement(sql);

			ps.setInt(1, dto.getTablenum());
			ps.setInt(2,dto.getMenucount());
			ps.setString(3, dto.getMenuname());
			ps.setInt(4, res_code2);
			ps.setInt(5, res_code2);
			ps.setInt(6,dto.getHeadcount());
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
	
	//table별 저장된 메뉴 로드
	public ArrayList<payDTO> load_tableMenu(payDTO d) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<payDTO> list = new ArrayList<payDTO>();
		
		try {
			con = getConn();
			String sql = "SELECT menuprice, menuname FROM menu WHERE menu_code IN (select menu_code2 from tablemenu where tablenum=? and res_code8 =?)";
			pstmt = con.prepareStatement(sql);
			String str = Integer.toString(d.getTablenum());
			pstmt.setString(1,str);
			pstmt.setInt(2,res_code2);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				payDTO dto = new payDTO();
				dto.setMenuname(rs.getString("menuname"));
				dto.setMenuprice(rs.getString("menuprice"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("예외발생:loadMenu()=> " + e.getMessage());
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
	
/*
	//menu 수량 확인
	public int countMenu(payDTO d) {
		int count =1;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<payDTO> list = new ArrayList<payDTO>();
		
		try {
			con = getConn();
			String sql = "select count(*) from tablemenu where tablenum =? and  menu_code2 = (select menu_code from menu where menuname =? and res_code2 =?)  ";
			pstmt = con.prepareStatement(sql);
			
			String str = Integer.toString(d.getTablenum());
			pstmt.setString(1,str);
			pstmt.setString(2,d.getMenuname());
			pstmt.setString(3, Integer.toString(res_code2));
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("예외발생:countMenu()=> " + e.getMessage());
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
		return count;
	}
	
	*/
	
	//DB 내용 삭제(종료시)
	public void exit() {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConn();
			String sql = "delete from tablemenu where res_code8 =?";
			int res_code2 = Integer.parseInt(User.getRes_code());
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, res_code2);
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("예외발생:menu_count()=> " + e.getMessage());
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
	
	//db 튜플 삭제(결제시)
	public void complatePayment(String tablenum) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConn();
			String sql = "delete from tablemenu where tablenum =?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, tablenum);
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("예외발생:menu_count()=> " + e.getMessage());
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
	
	public int totalPrice(payDTO d) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<payDTO> list = new ArrayList<payDTO>();
		int total=0;
		int price=0;
		try {
			con = getConn();
			String sql = "SELECT menuprice, menuname FROM menu WHERE menu_code IN (select menu_code2 from tablemenu where tablenum=? and res_code8 =?)";
			pstmt = con.prepareStatement(sql);
			String str = Integer.toString(d.getTablenum());
			pstmt.setString(1,str);
			pstmt.setInt(2, res_code2);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				price = Integer.parseInt(rs.getString("menuprice"));
				total += price;
			}
		} catch (Exception e) {
			System.out.println("예외발생:loadMenu()=> " + e.getMessage());
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
 		return total;
	}
}