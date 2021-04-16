package native_jdbc_programing.ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import native_jdbc_programing.dto.Department;
import native_jdbc_programing.util.JdbcConn;

public class JdbcConEx4 {

	/**
	 * JDBC 프로그래밍의 전형적인 실행 순서 2021.02.15
	 * 
	 */
	public static void main(String[] args) {
		
		ArrayList<Department> list = null;
		
		String sql = "select deptno, deptname, floor from department";
		
		try(Connection con = JdbcConn.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
				) 
		{
			// 1. JDBC 드라이버 로딩
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
