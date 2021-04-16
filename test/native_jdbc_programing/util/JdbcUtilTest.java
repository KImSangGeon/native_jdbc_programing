package native_jdbc_programing.util;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class JdbcUtilTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {  //1
		System.out.printf("%s()%n ","setUpBeforeClass" );
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception { 
		System.out.printf("%s()%n ","tearDownAfterClass" );//5
	}

	@Before
	public void setUp() throws Exception { 
		System.out.printf("%s()%n ","setUp" );//2
	}

	@After
	public void tearDown() throws Exception {
		System.out.printf("%s()%n ","tearDown" );//4
	}

	@Test
	public void testGetConnection() {
		System.out.printf("%s()%n ","testGetConnection" );//3
		Connection con = JdbcConn.getConnection();
		System.out.println("con > " + con);
		Assert.assertNotNull(con);
	}

}
