package native_jdbc_programing.dao2;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import native_jdbc_programing.dao.DepartmentDao;
import native_jdbc_programing.dto.Department;
import native_jdbc_programing.impl2.DepartmentDaoImpl2;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoTest2 {
	
	private static DepartmentDao dao = DepartmentDaoImpl2.getInstance();


	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test04SelectDepartmentByAll() {
		System.out.printf("%s()%n", "testSelectDepartmentByAll");
		List<Department> departmentList = dao.selectDepartmentByAll();
		Assert.assertNotNull(departmentList);
		for(Department d : departmentList) {
			System.out.println(d);
		}
	}

	@Test
	public void test05SelectDepartmentByNo() {
		System.out.printf("%s()%n", "testSelectDepartmentByNo");
		Department department = new Department(3);
		Department SelDept = dao.selectDepartmentByNo(department);
		Assert.assertNotNull(SelDept);
		System.out.println(SelDept);
	}

	@Test
	public void test01InsertDepartment() {
		System.out.printf("%s()%n", "testInsertDepartment");
		Department department = new Department(5, "연구", 6);
		int res = dao.insertDepartment(department);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectDepartmentByNo(department));
		
	}

	@Test
	public void test02UpdateDepartment() {
		System.out.printf("%s()%n ", "testUpdateDepartment");
		Department department = new Department(5, "오락", 9);
		int res = dao.updateDepartment(department);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectDepartmentByNo(department));
		
	}

	@Test
	public void test03DeleteDepartment() {
		System.out.printf("%s()%n ", "testDeleteDepartment");
		int res = dao.deleteDepartment(5);
		Assert.assertEquals(1, res);
		dao.selectDepartmentByAll().stream().forEach(System.out::println);
		
		
	}

}
