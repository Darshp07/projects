package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.bean.Student;

import com.util.databaseutil;

public class Studentdao {

	public int InsertStudent(Student std) {
		int status = 0;
		try {
			Connection con = databaseutil.getConnection();
			String query = "INSERT INTO Student(fname,lname,email,mobile,gender,password) VALUES(?,?,?,?,?,?) ";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, std.getFname());
			stmt.setString(2, std.getLname());
			stmt.setString(3, std.getEmail());
			stmt.setString(4, std.getMobile());
			stmt.setString(5, std.getGender());
			stmt.setString(6, std.getPassword());
			status = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return status;

	}

	public ArrayList<Student> Studentlist() {
		ArrayList<Student> studentlist = new ArrayList<Student>();
		try {
			Connection con = databaseutil.getConnection();
			String sql = "SELECT * FROM Student";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				Student std = new Student();
				std.setId(rs.getInt("id"));
				std.setFname(rs.getString("fname"));
				std.setLname(rs.getString("lname"));
				std.setEmail(rs.getString("email"));
				std.setMobile(rs.getString("mobile"));
				std.setGender(rs.getString("gender"));
				std.setPassword(rs.getString("password"));

				studentlist.add(std);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return studentlist;
	}

	public Student getStudentdata(int id) {
		Student std = null;
		try {
			Connection conn = databaseutil.getConnection();

			String sql = "SELECT * FROM Student WHERE id=?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				std = new Student();

				std.setId(rs.getInt("id"));
				std.setFname(rs.getString("fname"));
				std.setLname(rs.getString("lname"));
				std.setEmail(rs.getString("email"));
				std.setMobile(rs.getString("mobile"));
				std.setGender(rs.getString("gender"));
				std.setPassword(rs.getString("password"));

			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return std;
	}

	public int update(Student std) {

		int status = 0;

		try {

			Connection conn = databaseutil.getConnection();

			String sql = "UPDATE Student SET fname = ?,lname=?, email = ? , mobile=?,gender=?, password = ? WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, std.getFname());
			stmt.setString(2, std.getLname());
			stmt.setString(3, std.getEmail());
			stmt.setString(4, std.getMobile());
			stmt.setString(5, std.getGender());
			stmt.setString(6, std.getPassword());
			stmt.setInt(7, std.getId());

			status = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}

	public int delete(int id) {
		int status = 0;
		try {
			Connection conn = databaseutil.getConnection();
			String sql = "DELETE FROM Student WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			status = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return status;
	}

}
