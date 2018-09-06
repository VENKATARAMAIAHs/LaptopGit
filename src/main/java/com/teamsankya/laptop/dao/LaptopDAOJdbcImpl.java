package com.teamsankya.laptop.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import com.teamsankya.laptop.dto.LaptopDTO;
import com.teamsankya.laptop.factory.LaptopFactory;

public class LaptopDAOJdbcImpl implements LaptopDAO {

	public void createLaptop(LaptopDTO bean) {
		try {
			/*Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/laptop", "root", "root");
*/
			
			Properties properties = new Properties();
			String path = getClass().getResource("/config.properties").getPath();
			
			try {
				FileReader fileReader = new FileReader(path);
				properties.load(fileReader);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			
			Class.forName(properties.getProperty("jdbc_driver")).newInstance();
			Connection con = DriverManager.getConnection(properties.getProperty("db_url"));

			
			
			PreparedStatement pst = con.prepareStatement("insert into laptop values(?,?,?,?)");
			pst.setInt(1, bean.getLid());
			pst.setString(2, bean.getLname());
			pst.setInt(3, bean.getRam());
			pst.setInt(4, bean.getPrice());
			
			

			int i=0;
			i=pst.executeUpdate();
			System.out.println(i + " records inserted");
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
