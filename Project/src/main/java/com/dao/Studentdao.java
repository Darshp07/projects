package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.student;
import com.util.studentutil;

public class Studentdao {

	public void insert(student std) {
		try {
			Connection con = studentutil.getConnection();
			String query = "INSERT INTO studentdata (Fname , Lname ,Email,mobile_no,DOB,Addrese,gender ,hobbies,Education) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, std.getFname());
			stmt.setString(2, std.getLname());
			stmt.setString(3, std.getEmail());
			stmt.setString(4, std.getMobile_no());
			stmt.setString(5, std.getDOB());
			stmt.setString(6, std.getAddrese());
			stmt.setString(7, std.getGender());
			stmt.setString(8, std.getHobbies());
			stmt.setString(9, std.getEduction());
			stmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static List<student> show() {

		List<student> list = new ArrayList<student>();

		try {
			Connection con = studentutil.getConnection();
			String sql = "select * from studentdata";
			Statement stm = con.prepareStatement(sql);
			ResultSet re = stm.executeQuery(sql);
			while (re.next()) {
				student st = new student();
				st.setId(re.getInt(1));
				st.setFname(re.getString(2));
				st.setLname(re.getString(3));
				st.setEmail(re.getString(4));
				st.setMobile_no(re.getString(5));
				st.setDOB(re.getString(6));
				st.setAddrese(re.getString(7));
				st.setGender(re.getString(8));
				st.sethobbies(re.getString(9));
				st.setEduction(re.getString(10));
				list.add(st);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} 
		return list;

	}
	
	public static int update(student std) {
		int status = 0;
		try {
			Connection con = studentutil.getConnection();
			String query = "UPDATE studentdata SET fname=? , Lname=?,Email=?,Mobile_no=?,DOB=?,Addrese=?,gender=? , hobbies=?,Education=? where Sno=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, std.getFname());
			stmt.setString(2, std.getLname());
			stmt.setString(3, std.getEmail());
			stmt.setString(4, std.getMobile_no());
			stmt.setString(5, std.getDOB());
			stmt.setString(6, std.getAddrese());
			stmt.setString(7, std.getGender());
			stmt.setString(8, std.getHobbies());
			stmt.setString(9, std.getEduction());
			stmt.setInt(10, std.getId());
			status = stmt.executeUpdate();
			System.out.println("done");

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return status;

	}

	public static student GetAllStudent(int id) {
		student st = new student();

		try {
			Connection con = studentutil.getConnection(); 
			String query = "select * from studentdata where Sno=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet re = stmt.executeQuery();
			while (re.next()) {
				st.setId(re.getInt("Sno"));
				st.setFname(re.getString(2));
				st.setLname(re.getString(3));
				st.setEmail(re.getString(4));
				st.setMobile_no(re.getString(5));
				st.setDOB(re.getString(6));
				st.setAddrese(re.getString(7));
				st.setGender(re.getString(8));
				st.sethobbies(re.getString(9));
				st.setEduction(re.getString(10));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return st;

	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = studentutil.getConnection();
			String sql = "delete from studentdata where Sno=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);

			status = stmt.executeUpdate();
			System.out.println(status);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return status;
	}

}
