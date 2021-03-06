package br.nauber.iadapter.function;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import com.mysql.management.MysqldResource;
import com.mysql.management.MysqldResourceI;
import com.mysql.management.util.QueryUtil;

public class MySQLServer extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {

			File ourAppDir = new File(System.getProperty(JAVA_IO_TMPDIR));
			File databaseDir = new File(ourAppDir, "mysql-mxj");
			int portNumber = Integer.parseInt(System.getProperty(
					"c-mxj_test_port", "3336"));
			String userName = "olyanren";
			String password = "1987";
			MysqldResource mysqldResource = startDatabase(databaseDir,
					portNumber, userName, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static MysqldResource startDatabase(File databaseDir, int port,
			String userName, String password) {
		MysqldResource mysqldResource = new MysqldResource(databaseDir);
		Map database_options = new HashMap();
		database_options.put(MysqldResourceI.PORT, Integer.toString(port));
		database_options.put(MysqldResourceI.INITIALIZE_USER, "true");
		database_options.put(MysqldResourceI.INITIALIZE_USER_NAME, userName);
		database_options.put(MysqldResourceI.INITIALIZE_PASSWORD, password);
		mysqldResource.start("test-mysqld-thread", database_options);
		if (!mysqldResource.isRunning()) {
			throw new RuntimeException("MySQL did not start.");
		}
		System.out.println("MySQL is running.");
		return mysqldResource;
	}

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String JAVA_IO_TMPDIR = "java.io.tmpdir";

	public MySQLServer() {

	}
}
