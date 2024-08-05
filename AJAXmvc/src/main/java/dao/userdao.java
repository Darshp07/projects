package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.user;
import util.databaseutil;

public class userdao {

	public int insertUser(user user) throws SQLException {
		int status = 0;

		try {
			Connection con = databaseutil.getConnection();
			String sql = "INSERT INTO user (name, email, password) VALUES (?,?,?)";
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

	public ArrayList<user> userlist() {
		ArrayList<user> userlist = new ArrayList<user>();

		try {
			Connection con = databaseutil.getConnection();
			String sql = "select * from user";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				user us = new user();
				us.setId(rs.getInt("id"));
				us.setName(rs.getString("name"));
				us.setEmail(rs.getString("email"));
				us.setPassword(rs.getString("password"));
				userlist.add(us);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return userlist;
	}

	public int delete(int id) {
		int status = 0;
		try {
			Connection con = databaseutil.getConnection();
			String sql = "delete from user where id =?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			status = stmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return status;
	}

	public user edit(int id) {
		user user = null;

		try {
			Connection conn = databaseutil.getConnection();

			String sql = "SELECT * FROM user WHERE id=?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				user = new user();

				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				System.out.println("name" + rs.getString("name"));
				System.out.println("passweod" + rs.getString("password"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			user = null;
		}

		return user;
	}

	public int update(user user) {
	    int status = 0;

	    try {
	        Connection con = databaseutil.getConnection();
	        String sql = "UPDATE user SET name = ?, email = ?, password = ? WHERE id = ?";
	        PreparedStatement stmt = con.prepareStatement(sql);
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

	public List<user> search(String value) {
	    List<user> users = new ArrayList<>();

	    try {
	        Connection conn = databaseutil.getConnection();

	        String sql = "SELECT * FROM user WHERE name LIKE ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, value + "%");
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            user user = new user();
	            user.setId(rs.getInt("id"));
	            user.setName(rs.getString("name"));
	            user.setEmail(rs.getString("email"));
	            user.setPassword(rs.getString("password"));
	            users.add(user);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        users = null;
	    }

	    return users;
	}



}
