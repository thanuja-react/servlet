<%@page import="Dto1.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>home</title>
</head>
<body>
<h1>welcome to buy_sell</h1>
<%
Customer customer=(Customer) session.getAttribute("customer");
if(customer==null){
%>
<a href="Loginn.html"><button>login</button></a><br><br>
<a href="Sign.html"><button>signup</button></a><br><br>
<% } %>
<a><button>buy</button></a><br><br>
<a><button>sell</button></a><br><br>

<%
Customer c=(Customer) session.getAttribute("customer");
if(customer!=null){
%>


<a href="Logout"><button>logout</button></a><br><br>
<%} %>
</body>
</html>





