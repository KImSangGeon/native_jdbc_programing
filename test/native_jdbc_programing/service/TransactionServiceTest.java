package native_jdbc_programing.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import native_jdbc_programing.dto.Department;
import native_jdbc_programing.dto.Title;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TransactionServiceTest {
	private static  TransactionService service;
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//TransactionServiceTest를 실행하기 전에 수행
		service = new TransactionService();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		service =null;
		
	}

	@Before
	public void setUp() throws Exception {
		//TransactionServiceTest를 실행하기 후에 수행
		
	}

	@After
	public void tearDown() throws Exception {
		//test 메서드 끝날때 마다 호출
		System.out.println();
	}

	@Test
	public void test01TransAddTitleAndDepartment_FailTitle() {
		System.out.printf("%s()%n", "testTransAddTitleAndDepartment_FailTitle");
		Title title = new Title(1, "인턴");
		Department dept = new Department(5, "비상계획부", 10);
		
	String res = service.transAddTitleAndDepartment(title, dept);
	Assert.assertEquals("rollback", res);
	}

	@Test
	public void test02TransAddTitleAndDepartment_FailDept() {
		System.out.printf("%s()%n", "testTransAddTitleAndDepartment_FailDept");
		Title title = new Title(6, "인턴");
		Department dept = new Department(1, "비상계획부", 10);
		
		String res = service.transAddTitleAndDepartment(title, dept);
		Assert.assertEquals("rollback", res);
	}

	@Test
	public void testTransAdd03TitleAndDepartment_FailBoth() {
		System.out.printf("%s()%n", "testTransAddTitleAndDepartment_FailBoth");
		Title title = new Title(1, "인턴");
		Department dept = new Department(1, "비상계획부", 10);
		
		String res = service.transAddTitleAndDepartment(title, dept);
		Assert.assertEquals("rollback", res);
	}

	@Test
	public void testTransAdd04TitleAndDepartment_success() {
		System.out.printf("%s()%n", "testTransAddTitleAndDepartment_success");
		Title title = new Title(6, "인턴");
		Department dept = new Department(5, "비상계획부", 10);
		
		String res = service.transAddTitleAndDepartment(title, dept);
		Assert.assertEquals("commit", res);
	}
	
	
////////////////////////////////////////////////
	

	@Test
	public void testTransRemove05TitleAndDepartment_FailTitle() {
		System.out.printf("%s()%n", "testTransRemoveTitleAndDepartment_FailTitle");
		Title title = new Title(0);
		Department dept = new Department(5);
		
		int res = service.transRemoveTitleAndDepartment(title, dept);
		Assert.assertEquals(1, res);
	}

	@Test
	public void testTransRemove06TitleAndDepartment_FailDept() {
		System.out.printf("%s()%n", "testTransRemove06TitleAndDepartment_FailDept");
		Title title = new Title(6);
		Department dept = new Department(0);
		
		int res = service.transRemoveTitleAndDepartment(title, dept);
		Assert.assertEquals(1, res);
	}
	@Test
	public void testTransRemove07TitleAndDepartment_FailBoth() {
		System.out.printf("%s()%n", "testTransRemove07TitleAndDepartment_FailBoth");
		Title title = new Title(0);
		Department dept = new Department(0);
		
		int res = service.transRemoveTitleAndDepartment(title, dept);
		Assert.assertEquals(0, res);
	}
	@Test
	public void testTransRemove08TitleAndDepartment_succees() {
		System.out.printf("%s()%n", "testTransRemove08TitleAndDepartment_succees");
		Title title = new Title(6);
		Department dept = new Department(5);
		
		int res = service.transRemoveTitleAndDepartment(title, dept);
		Assert.assertEquals(2, res);
	}



}
