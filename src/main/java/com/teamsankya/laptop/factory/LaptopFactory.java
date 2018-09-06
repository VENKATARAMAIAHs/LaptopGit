package com.teamsankya.laptop.factory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.Properties;

import com.teamsankya.laptop.dao.LaptopDAO;
import com.teamsankya.laptop.dao.LaptopDAOJdbcImpl;


public class LaptopFactory {
	 
	
	 private LaptopFactory() {
		}
	private static final LaptopFactory obj = new LaptopFactory();
	 
	 public static LaptopFactory getInstence() {
	 	return obj;
	 }
	

//	 public LaptopFactory() {
//		// TODO Auto-generated constructor stub
//	}

	public  LaptopDAO daoCreater()
	 {
		 
		 Properties properties = new Properties();
			String path = getClass().getResource("/config.properties").getPath();
			
			
			FileReader fileReader;
			try {
				fileReader = new FileReader(path);
				try {
					properties.load(fileReader);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LaptopDAO dao=null;
			try {
				dao =  (LaptopDAO) Class.forName(properties.getProperty("dao_class")).newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return dao;
	 }
	 
		 
	
}

