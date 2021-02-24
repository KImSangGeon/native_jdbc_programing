package native_jdbc_programing.dao2;

import static org.junit.Assert.*;

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
import native_jdbc_programing.impl2.EmployeeImpl2;
import native_jdbc_programing.impl2.EmployeeImpl3;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoTest3 {

	private static EmployeeDao dao = EmployeeImpl3.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
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
		Employee searchEmployee = dao.selectEmployeeByNo(employee);
		Assert.assertNotNull(searchEmployee);
		System.out.println(searchEmployee);
	}

	@Test
	public void test01InsertEmployee() {
		System.out.printf("%s()%n", "testInsertEmployee");
		Employee newEMP = new Employee(2000, "김상건", new Title(3), new Employee(4377), 3000000, new Department(2));
		int res = dao.insertEmployee(newEMP);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectEmployeeByNo(newEMP));

	}

	@Test
	public void test02UpdateEmployee() {
		System.out.printf("%s()%n", "testInsertEmployee");
		Employee newEMP = new Employee(2000, "김민희", new Title(3), new Employee(4377), 3000000, new Department(2));
		int res = dao.updateEmployee(newEMP);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectEmployeeByNo(newEMP));
	}

	@Test
	public void test03DeleteEmployee() {
		System.out.printf(" %s()%n", "testDeleteEmployee");
		int res = dao.deleteEmployee(2000);
		Assert.assertEquals(1, res);
		dao.selectEmployeeByAll().stream().forEach(System.out::println);
				
	}

}
