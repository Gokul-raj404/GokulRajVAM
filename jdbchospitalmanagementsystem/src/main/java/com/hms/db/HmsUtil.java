package com.hms.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class HmsUtil {
	public static Connection con = null;
	public static Connection getConnection() {
	try {
		File f = new File(
				"D:\\jdbchospitalmanagementsystem\\src\\main\\resources\\hms.properties");
		FileInputStream fis = new FileInputStream(f);
		Properties p = new Properties();
		p.load(fis);
		con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("pwd"));
	} catch (IOException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;

}
}
