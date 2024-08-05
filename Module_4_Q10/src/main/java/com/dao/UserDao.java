package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.User;

import com.util.DatabaseUtil;

public class UserDao {

	public int insertRecord(User user) throws SQLException {

		int status = 0;

		try {
			Connection conn = DatabaseUtil.getConnection();

			String sql = "INSERT INTO Student (fname,lname, email,mobile,gender, password) VALUES (?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getFname());
			stmt.setString(2, user.getLname());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getMobile());
			stmt.setString(5, user.getGender());
			stmt.setString(6, user.getPassword());

			status = stmt.executeUpdate();

		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}

		return status;

	}

	public ArrayList<User> logindata() {

		ArrayList<User> userList = new ArrayList<User>();

		try {
			Connection conn = DatabaseUtil.getConnection();

			String sql = "SELECT email ,password FROM Student";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				User user = new User();

				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));

				userList.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;

	}

}
