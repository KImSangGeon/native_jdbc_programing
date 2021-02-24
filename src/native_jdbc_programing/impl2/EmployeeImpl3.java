package native_jdbc_programing.impl2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import native_jdbc_programing.dao.EmployeeDao;
import native_jdbc_programing.dto.Department;
import native_jdbc_programing.dto.Employee;
import native_jdbc_programing.dto.Title;
import native_jdbc_programing.util.JdbcUtil;

public class EmployeeImpl3 implements EmployeeDao {
	
	
	private static final EmployeeImpl3 instance = new EmployeeImpl3();
	
	public static EmployeeImpl3 getInstance() {
		return instance;
	}
	public EmployeeImpl3() {}

	@Override
	public List<Employee> selectEmployeeByAll() {
		String sql = "select * from vw_employee";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Employee> list = new ArrayList<>();
				do {
					list.add(getEmployee(rs));
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Employee getEmployee(ResultSet rs) throws SQLException {
		int empno = rs.getInt("empno");
		String empname = rs.getString("empname");
		Title title = new Title(rs.getInt("manager"));
		Employee manager = new Employee(rs.getInt("manager"));
		int salary = rs.getInt("salary");
		Department dept = new Department(rs.getInt("dept"));
		return new Employee(empno, empname, title, manager, salary, dept);
		
	}
	@Override
	public Employee selectEmployeeByNo(Employee employee) {
		String sql = "select empno,empname,title,manager,salary,dept from employee where empno = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, employee.getEmpNo());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getEmployee(rs);					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int insertEmployee(Employee employee) {
		String sql = "insert into employee values(?, ?, ?, ?, ?, ?)";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1,	employee.getEmpNo());
			pstmt.setString(2, employee.getEmpName());
			pstmt.setInt(3, employee.getTitle().gettNo());
			pstmt.setInt(4, employee.getManager().getEmpNo());
			pstmt.setInt(5, employee.getSalary());
			pstmt.setInt(6, employee.getDept().getDeptNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateEmployee(Employee employee) {
		String sql = "update employee set empname = ? where empno = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, employee.getEmpName());
			pstmt.setInt(2, employee.getEmpNo());
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteEmployee(int empNo) {
		String sql = "delete from employee where empno = ?";
		try(Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, empNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return 0;
	}
	@Override
	public int deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
