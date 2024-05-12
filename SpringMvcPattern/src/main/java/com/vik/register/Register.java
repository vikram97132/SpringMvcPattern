package com.vik.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vik.dbconn.DbConnection;

@WebServlet("/regform")
public class Register extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		String myName = req.getParameter("name1");
		String myEmail = req.getParameter("email1");
		String myPassword = req.getParameter("pass1");
		String myCity = req.getParameter("city1");
		
		try {
			Connection con = DbConnection.getConnection();
			String insert_sql_query = "INSERT INTO REGISTER VALUE(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insert_sql_query);
			ps.setString(1, myName);
			ps.setString(2, myEmail);
			ps.setString(3, myPassword);
			ps.setString(4, myCity);
			int count = ps.executeUpdate();
			if(count>0) {
				out.println("Registered Succesfully");
				RequestDispatcher rd = req.getRequestDispatcher("/login.html");
				rd.include(req, resp);
			}else {
				out.println("User Not Register Due to Error");
				RequestDispatcher rd = req.getRequestDispatcher("/register.html");
				rd.include(req, resp);
			}
		}catch(Exception e) {
		e.printStackTrace();	
		}
		
	}

}
