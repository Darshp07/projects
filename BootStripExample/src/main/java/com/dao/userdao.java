package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.user;
import com.util.databaseutil;

public class userdao {

	public int insertdata(user user) throws SQLException {
		int status = 0;

		try {
			Connection con = databaseutil.getConnection();
			String sql = "INSERT INTO userdata (name, email, password) VALUES (?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());

			status = stmt.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}

		return status;

	}

	public ArrayList<user> getUserList() {

		ArrayList<user> userList = new ArrayList<user>();

		try {
			Connection conn = databaseutil.getConnection();

			String sql = "SELECT * FROM userdata";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				user user = new user();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));

				userList.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;

	}

	public static int delete(int id) {
		int status = 0;

		try {
			Connection con = databaseutil.getConnection();
			String sql = "DELETE FROM userdata where id =?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			status = stmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return status;

	}

	public int update(user user) {
		int status = 0;

		try {
			
			Connection conn = databaseutil.getConnection();
			
			String sql = "UPDATE userdata SET name = ?, email = ? , password = ? WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			stmt.setInt(4, user.getId());

			status = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}

	public user getuserdata(int id) {
		user user = null;

		try {
			Connection conn = databaseutil.getConnection();

			String sql = "SELECT * FROM userdata WHERE id=?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				user = new user();

				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));

			

			}
		} catch (SQLException e) {
			e.printStackTrace();
			user = null;
		}

		return user;
	}
}