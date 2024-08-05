package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.Student;
import com.util.DatabaseUtil;

public class StudentDao {

	public void insert(Student student) {

		try {
			Connection conn = DatabaseUtil.getConnection();

			String sql = "INSERT INTO students (name, email, phone, dob, gender, course) VALUES (?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, student.getName());
			stmt.setString(2, student.getEmail());
			stmt.setString(3, student.getPhone());
			stmt.setString(4, student.getDob());
			stmt.setString(5, student.getGender());
			stmt.setString(6, student.getCourse());

			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void getAll() {

	}

	public void updateStudent() {

	}

	public void deleteStudent() {

	}

}
