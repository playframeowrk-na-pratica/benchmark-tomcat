package br.com.caelum.exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
//	private static ComboPooledDataSource pool;
	private static BoneCP pool;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			BoneCPConfig config = new BoneCPConfig();
			config.setJdbcUrl("jdbc:mysql://localhost/testehibernate"); // jdbc url specific to your database, eg jdbc:mysql://127.0.0.1/yourdb
			config.setUsername("root"); 
			config.setPassword("");
			config.setMinConnectionsPerPartition(5);
			config.setMaxConnectionsPerPartition(20);
			config.setAcquireIncrement(5);
			config.setPartitionCount(1);
			pool = new BoneCP(config); // setup the connection pool
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
//		static {
//			try {
//				Class.forName("com.mysql.jdbc.Driver");
//				pool = new ComboPooledDataSource();
//				pool.setDriverClass("com.mysql.jdbc.Driver"); // loads the jdbc
//				// driver
//				pool.setJdbcUrl("jdbc:mysql://localhost/testehibernate");
//				pool.setUser("root");
//				pool.setPassword("");
//				
//				// the settings below are optional -- c3p0 can work with defaults
//				pool.setMinPoolSize(5);
//				pool.setAcquireIncrement(5);
//				pool.setMaxPoolSize(20);
//			} catch (Exception e) {
//				throw new RuntimeException(e);
//			}
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/testehibernate", "root", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnectionFromPool() {
		try {
			return pool.getConnection();			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void close(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
