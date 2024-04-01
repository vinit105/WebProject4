package Controller;

import java.sql.*;

import java.util.ArrayList;

public class DBHandler {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "mysql@123");
		return connection;

	}

	public static int insertQuery(int id, String name, int semester, String branch, float spi)
			throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement prestmt = conn.prepareStatement("insert into collegestudent values(?,?,?,?,?)");
		prestmt.setInt(1, id);
		prestmt.setString(2, name);
		prestmt.setInt(3, semester);
		prestmt.setString(4, branch);
		prestmt.setFloat(5, spi);
		int result = prestmt.executeUpdate();

		return result;
	}

	public static ArrayList<Student> list() throws ClassNotFoundException, SQLException {

		ArrayList<Student> listStudent = new ArrayList<>();

		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from collegestudent");

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int semester = rs.getInt("semester");
			String branch = rs.getString("branch");
			float spi = rs.getFloat("spi");
			listStudent.add(new Student(id, name, semester, branch, spi));
		}
		return listStudent;
	}

//	public static ResultSet list() throws ClassNotFoundException, SQLException
//	{
//		
//		Connection con = getConnection();
//		Statement stmt = con.createStatement();
//		
//		ResultSet result=stmt.executeQuery("select * from collegestudent");
//		   
//		      
//					
//		return result;
//	}
	public static int deleteQuery(int deleteId) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement prepstmt = con.prepareStatement("delete from collegestudent where id = ?");
		prepstmt.setInt(1, deleteId);
		int result = prepstmt.executeUpdate();
		return result;
	}

	public static ArrayList<Student> findStudent(int idStudent) throws ClassNotFoundException, SQLException {
		ArrayList<Student> listStudent = new ArrayList<>();

		Connection con = getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from collegestudent where id = '" + idStudent + "'");
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int semester = rs.getInt("semester");
			String branch = rs.getString("branch");
			float spi = rs.getFloat("spi");
			listStudent.add(new Student(id, name, semester, branch, spi));
		}
		return listStudent;
	}

	public static int updateQuery(int id, String name, int semester, String branch, float spi)
			throws SQLException, ClassNotFoundException {

		Connection con = getConnection();
		PreparedStatement prestmt = con.prepareStatement("update collegestudent set name=?, semester=?,branch=?, spi=? where id = '" + id + "' ");
		prestmt.setString(1, name);
		prestmt.setInt(2, semester);
		prestmt.setString(3, branch);
		prestmt.setFloat(4, spi);
		int result = prestmt.executeUpdate();

		return result;

	}

}