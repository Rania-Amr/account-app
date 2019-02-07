package com.dbservlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbrecords.AccountInfo;
import com.dbrecords.DbConnection;
import com.dbrecords.DbOperations;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		System.out.println("Login == GET");
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		AccountInfo objInfo = new AccountInfo();

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		System.out.println("i am from login servelt");

		objInfo.setEmail(request.getParameter("email"));
		System.out.println(request.getParameter("email"));
		objInfo.setPassword(request.getParameter("psw"));
   
		objInfo.setLastSeen(strDate);
		
		 Connection connection = null;
		 DbOperations objOp = new
		  DbOperations();
		 
		 
		 
		 try {
			 
			 connection=DbConnection.getConnection(); 
			 System.out.println("line 77");
			 boolean resultEmail=false;
			 System.out.println("line 79");
		  resultEmail=objOp.login( connection, objInfo);
		  System.out.println("line 81");
		 if(resultEmail){
			 
		  objOp.updateLastSeen(connection, objInfo); 
		  System.out.println("correct");
			HttpSession session = request.getSession(true);

        	//set a string session attribute
			System.out.println("login "+objInfo.getEmail());
        	session.setAttribute("myemail",objInfo.getEmail());
		  request.setAttribute("email", objInfo.getEmail());
			request.getRequestDispatcher("jspfiles/home.jsp").forward(request, response);
		 }else{
		  System.out.println("login faild"); 
		response.sendRedirect("jspfiles/login.jsp");
		  }
		 
		 } catch (SQLException e) { e.printStackTrace(); }finally{
		  DbConnection.closeConnection(connection); 
		  }
//		 
//		request.setAttribute("email", objInfo.getEmail());
//		request.getRequestDispatcher("jspfiles/home.jsp").forward(request, response);
//		//response.sendRedirect("jspfiles/home.jsp");
	}

}
