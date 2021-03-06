package native_jdbc_programing.ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import native_jdbc_programing.dto.Department;

public class JdbcConEx3 {

	/**
	 * JDBC 프로그래밍의 전형적인 실행 순서 2021.02.15
	 * 
	 */
	public static void main(String[] args) {
		
		ArrayList<Department> list = null;
		
		String url = "jdbc:mysql://localhost:3306/mysql_study?useSSL=false";
		String user = "user_mysql_study";
		String password = "rootroot";
		
		String sql = "select deptno, deptname, floor from department";
		
		try(Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
				) 
		{
			// 1. JDBC 드라이버 ㄹ딩
			Class.forName("com.mysql.jdbc.Driver");
			list = new ArrayList<>();
			while(rs.next()){
				list.add(getDepartment(rs));			
			}
			
		} catch (ClassNotFoundException e) {			
			System.err.println("JDBC Driver Not Foutd ");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		System.out.println("Department Query 결과는 ");
		for(Department d : list) {
			System.out.println(d);
		}

	}

	private static Department getDepartment(ResultSet rs) throws SQLException{
		int deptNo = rs.getInt("deptno");
		String deptName = rs.getString("deptname");
		int floor = rs.getInt("floor");
		
		
		return new Department(deptNo, deptName, floor);
	}

}
