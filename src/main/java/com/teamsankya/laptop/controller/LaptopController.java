package com.teamsankya.laptop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.teamsankya.laptop.dao.LaptopDAO;
import com.teamsankya.laptop.dao.LaptopDAOJdbcImpl;
import com.teamsankya.laptop.dto.LaptopDTO;
import com.teamsankya.laptop.factory.LaptopFactory;

@WebServlet("/LaptopController")
public class LaptopController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//getting data from form and setting in dto
		LaptopDTO lbean=new LaptopDTO();
		lbean.setLid(Integer.parseInt(req.getParameter("lid")));
		lbean.setLname(req.getParameter("lname"));
		lbean.setRam(Integer.parseInt(req.getParameter("ram")));
		lbean.setPrice(Integer.parseInt(req.getParameter("price")));
		 
		LaptopDAO dao	= (LaptopDAO) LaptopFactory.getInstence().daoCreater();
		
		
		/*LaptopFactory fact=new LaptopFactory();*/
		
		/*LaptopDAO dao=new LaptopDAOJdbcImpl();*/

		/*LaptopFactory fac=new LaptopFactory();

		LaptopDAO dao=(LaptopDAO) fac.daoCreater();*/
		dao.createLaptop(lbean);
		req.getRequestDispatcher("success.jsp")
					.forward(req, resp); 
		
	}
}
