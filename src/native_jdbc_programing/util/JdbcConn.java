package native_jdbc_programing.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConn {
	

	public static Connection getConnection() {
		
		String propertiesPath = "db.properties"; // 리소스 밑에 파일명과 일치해야됨
		Connection con = null;

		try (InputStream in = ClassLoader.getSystemResourceAsStream(propertiesPath)) {
			Properties prop = new Properties(); // key = value
			prop.load(in);

			try {
				con = DriverManager.getConnection(prop.getProperty("url"), prop);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * System.out.println("prop > " + prop);
		 * 
		 * System.out.println();
		 * 
		 * for(Entry<Object, Object> e : prop.entrySet()) { //entry의 묶음은 셋이다
		 * System.out.printf("%s -> %s%n ", e.getKey(), e.getValue());
		 * 
		 * } System.out.println(); for(Object key : prop.keySet()) {
		 * System.out.print(key + " -> "); System.out.println(prop.get(key));
		 * //hashtable 특징 키값을 주면 벨류값줌 }
		 * 
		 */

		return con;
	}

}
