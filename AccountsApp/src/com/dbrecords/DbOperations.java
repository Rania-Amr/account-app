package com.dbrecords;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbOperations {

	private static final String SELECT_Account = "SELECT * FROM accountinfo WHERE email = ? ";
	private static final String SELECT_BY_EMAIL = "SELECT email FROM accountinfo ";
	private static final String INSERT_USER = "INSERT INTO accountinfo VALUES ( ? , ? , ? , ? , ? , ? , ? , ? )";
	private static final String TIME_BY_LOGIN = "UPDATE accountinfo SET lastSeen = ? WHERE email = ? ";


	public boolean selectByEmail(Connection connection, String email) throws SQLException {
		boolean flag = true;
		PreparedStatement prepStatement = connection.prepareStatement(SELECT_BY_EMAIL);

		ResultSet rs = prepStatement.executeQuery();

		while (rs.next()) {

			if (rs.getString("email").equals(email)) {
				flag = false;
				break;
			}

		}
		rs.close();
		prepStatement.close();

		return flag;
	}

	
	public boolean login(Connection connection, AccountInfo objInfo) throws SQLException {
	//	System.out.println("start of login validation method");
		boolean flag = false;
		PreparedStatement prepStatement = connection.prepareStatement(SELECT_Account);
	//	System.out.println("line 41");
		prepStatement.setString(1, objInfo.getEmail());
		//System.out.println("line 43");
		ResultSet rs = prepStatement.executeQuery();
  //   System.out.println("r is"+rs);
		while (rs.next()) {
			if (rs.getString("password").equals(objInfo.getPassword())) {
				flag = true;
				objInfo.setFname(rs.getString("fname"));
				objInfo.setLname(rs.getString("lname"));
				objInfo.setPhone(rs.getString("phone"));
				objInfo.setBirthdate(rs.getString("birthdate"));
				objInfo.setDepartment(rs.getString("department"));
				break;
			}
		}
		rs.close();
		prepStatement.close();
		System.out.println("before return flag");
		return flag;
	}

	public int insertUser(Connection connection, AccountInfo objInfo) throws SQLException {
		PreparedStatement prepStatement = connection.prepareStatement(INSERT_USER);
		prepStatement.setString(1, objInfo.getEmail());
		prepStatement.setString(2, objInfo.getFname());
		prepStatement.setString(3, objInfo.getLname());
		prepStatement.setString(4, objInfo.getPhone());
		prepStatement.setString(5, objInfo.getBirthdate());
		prepStatement.setString(6, objInfo.getPassword());

		prepStatement.setString(7, objInfo.getLastSeen());
		prepStatement.setString(8, objInfo.getDepartment());

		int numRowsInserted = prepStatement.executeUpdate();
		prepStatement.close();
		return numRowsInserted;
	}

	
public void updateLastSeen(Connection connection,  AccountInfo objInfo) throws SQLException {
    PreparedStatement prepStatement = connection.prepareStatement(TIME_BY_LOGIN);
    prepStatement.setString(1, objInfo.getLastSeen());
    prepStatement.setString(2, objInfo.getEmail());
 
    prepStatement.close();

}}
