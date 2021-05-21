package database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import com.mysql.jdbc.Statement;

public class waitDAO {

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

   // 인원수 로드, cli_id 로드
   public ArrayList<waitDTO> getPeople() {
      ArrayList<waitDTO> list = new ArrayList<waitDTO>();
      Connection con = null;
      ResultSet rs = null;
      PreparedStatement pstmt = null;

      try {
         con = getConn();
         String sql = "SELECT cli_id3 ,people FROM waiting WHERE res_code5 =? order by time";
         pstmt = con.prepareStatement(sql);
         String code = User.getRes_code();
         pstmt.setString(1, code);
         rs = pstmt.executeQuery();

         while (rs.next()) {
            waitDTO dto = new waitDTO();
            dto.setPeople(rs.getString("people"));
            dto.setCli_name(rs.getString("cli_id3"));
            list.add(dto);
         }

      } catch (Exception e) {
         System.out.println("\n"+e.getMessage());
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

   
   
   
   //db 튜플 삭제(호출시)
   public void call(String name) {
      Connection con = null;
      ResultSet rs = null;
      PreparedStatement pstmt = null;
      
      try {
         con = getConn();
         String sql = "delete from waiting where cli_id3 =?";
         
         pstmt = con.prepareStatement(sql);
         
         pstmt.setString(1, name);
         pstmt.executeUpdate();

         
         
      } catch (Exception e) {
         System.out.println(e.getMessage());
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
   
   
   //PHP 연동
   public void doPHP() {
	   	URL url = null;
	    HttpURLConnection conn = null;
	    String jsonData = "";
	    BufferedReader br = null;
	    StringBuffer sb = null;
	    String returnText = "";
	 
	    try {
	        url = new URL("https://js06m13.cafe24.com/.php");
	 
	        conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestProperty("Accept", "application/json");
	        conn.setRequestMethod("GET");
	        conn.connect();
	 
	        br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	 
	        sb = new StringBuffer();
	 
	        while ((jsonData = br.readLine()) != null) {
	            sb.append(jsonData);
	        }
	 
	        returnText = sb.toString();
	 
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (br != null) br.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	   
   }
   
   
   
}