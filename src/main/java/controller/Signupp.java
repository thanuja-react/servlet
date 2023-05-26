package controller;


import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao1.CustomerDao;
import Dto1.Customer;



@WebServlet("/signupp")
public class Signupp extends HttpServlet {
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	String mobile=req.getParameter("mob");
	String password=req.getParameter("password");
	String gender=req.getParameter("gender");
	String dob=req.getParameter("dob");
	String address=req.getParameter("address");
	
	Date date=Date.valueOf(dob);
	int age=Period.between(date.toLocalDate(), LocalDate.now()).getYears();
	CustomerDao dao= new CustomerDao();
	if(age<18){
		resp.getWriter().print("<h1 style='color:red'> can not create an account age should be greater than 18</h1>");
		req.getRequestDispatcher("loginn.html").include(req, resp);
	}
	else{
		if(dao.findm(Long.parseLong(mobile)).isEmpty()&&dao.finde(email).isEmpty()){
		
	Customer c=new Customer();
	c.setName(name);
	c.setEmail(email);
	c.setMobile(Long.parseLong(mobile));
	c.setPassword(password);
	c.setGender(gender);
	c.setDob(date);
	c.setAddress(address);
	c.setAge(age);

	dao.save(c);
	
	Customer customer2=dao.finde(email).get(0);
	
	resp.getWriter().print("<h1 style='color:red'>account created succesfully</h1>");
	resp.getWriter().print("<h1 style='color:red'>Your customer id is "+customer2.getCustid() +"</h1>");
	req.getRequestDispatcher("Home1.jsp").include(req, resp);}
		else{
			resp.getWriter().print("<h1 style='color:green'>can not create account,mobile or email already exists. </h1>");
			req.getRequestDispatcher("Sign.html").include(req, resp);
		}
	}
}
}
