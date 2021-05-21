package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import database.signupDAO;

public class mypageDAO extends signupDAO {
	// loginDTO �궗�슜
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://js06m13.cafe24.com/js06m13";
	private static final String USER = "js06m13";
	private static final String PASS = "mcjoojh0562!";
	ArrayList<mypageDTO> members = new ArrayList<mypageDTO>();
	String login_id = "";

	public mypageDAO(mypageDTO dto) {
		members.add(dto);
	}

//     
//     public void set_id() {
//    	 mypageDTO dto= new mypageDTO();
//    	 this.id = dto.getRes_id();
//    }
//     
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

}
