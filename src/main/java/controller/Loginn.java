package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao1.CustomerDao;
import Dto1.Customer;
@WebServlet("/Loginn")
public class Loginn extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int custid=Integer.parseInt(req.getParameter("cid"));
	String password = req.getParameter("password");
	
	CustomerDao c= new CustomerDao();
	Customer customer=c.findc(custid);
	
	if(customer==null){
		resp.getWriter().print("<h1 style='color:red'>incorrect customer id</h1>");
		req.getRequestDispatcher("Loginn.html").include(req, resp);
	}
	else
	{
		if(customer.getPassword().equals(password)){
			req.getSession().setAttribute("Customer",customer);
			resp.getWriter().print("<h1 style='color:green'>login success</h1>");
			req.getRequestDispatcher("Home1.jsp").include(req, resp);
		}
		else{
			resp.getWriter().print("<h1 style='color:red'>incorrect password</h1>");
			req.getRequestDispatcher("Loginn.html").include(req, resp);
		}
	}
}
}
