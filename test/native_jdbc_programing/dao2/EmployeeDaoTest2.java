package native_jdbc_programing.dao2;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import native_jdbc_programing.dao.EmployeeDao;
import native_jdbc_programing.dto.Department;
import native_jdbc_programing.dto.Employee;
import native_jdbc_programing.dto.Title;
import native_jdbc_programing.impl2.EmployeeDaoImpl2;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoTest2 {

	private static EmployeeDao dao = EmployeeDaoImpl2.getInstance();

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test04SelectEmployeeByAll() {
		System.out.printf("%s()%n", "testSelectEmployeeByAll");
		List<Employee> employeeList = dao.selectEmployeeByAll();
		Assert.assertNotNull(employeeList);
		for (Employee e : employeeList) {
			System.out.println(e);
		}
	}

	@Test
	public void test05SelectEmployeeByNo() {
		System.out.printf("%s()%n", "testSelectEmployeeByNo");
		Employee employee = new Employee(2106);
		Employee emp = dao.selectEmployeeByNo(employee);
		Assert.assertNotNull(emp);
		System.out.println(emp);
	}

	@Test
	public void test01InsertEmployee() {
		System.out.printf("%s()%n", "testInsertEmployee");
		Employee employee = new Employee(1004, "천사", new Title(5), new Employee(4377), 2000000, new Department(1));
		int res = dao.insertEmployee(employee);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectEmployeeByNo(employee));

	}

	@Test
	public void test02UpdateEmployee() {
		System.out.printf("%s()%n ", "testUpdateEmployee");
		Employee employee = new Employee(1004, "천사2", new Title(4), new Employee(1003), 2000000, new Department(2));
		int res = dao.updateEmployee(employee);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectEmployeeByNo(employee));
		

	}

	@Test
	public void test03DeleteEmployee() {
		System.out.printf(" %s()%n", "testDeleteEmployee");
		Employee employee = new Employee(1004);
		int res = dao.deleteEmployee(employee);	
		Assert.assertEquals(1, res);
		dao.selectEmployeeByAll().stream().forEach(System.out::println);

	}

}
