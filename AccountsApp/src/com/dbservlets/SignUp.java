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
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.sendRedirect("jspfiles/login.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("enter the method");
		AccountInfo objInfo = new AccountInfo();
	
		Date date = new Date();
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	    String strDate = dateFormat.format(date);
		
		objInfo.setFname(request.getParameter("Fname"));
		objInfo.setLname(request.getParameter("Lname"));
		objInfo.setEmail(request.getParameter("Email"));
		objInfo.setPhone(request.getParameter("Phone"));
		objInfo.setBirthdate(request.getParameter("Birthday"));
		objInfo.setPassword(request.getParameter("Psw"));
		objInfo.setDepartment(request.getParameter("Department"));
		objInfo.setLastSeen(strDate);
		
		System.out.println(objInfo.getEmail());
		Connection connection = null;
		DbOperations objOp = new DbOperations();
		
		
		 
        try {
            connection=DbConnection.getConnection();
            boolean resultEmail =objOp.selectByEmail(connection,objInfo.getEmail());
            
            if(resultEmail){
            	int checkinsert=objOp .insertUser (connection,objInfo) ;
            	
            	HttpSession session = request.getSession(true);

            	//set a string session attribute
            	session.setAttribute("myemail",objInfo.getEmail());
            	request.setAttribute("email", objInfo.getEmail());
        		request.getRequestDispatcher("jspfiles/home.jsp").forward(request, response);
        		//response.sendRedirect("jspfiles/home.jsp");
            }
           
            } catch (SQLException e) {
			e.printStackTrace();
            }finally{
            	DbConnection.closeConnection(connection);
            }

		
	}

}
