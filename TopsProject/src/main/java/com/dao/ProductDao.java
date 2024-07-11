package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.Product;
import com.util.databaseutil;

public class ProductDao {

	public int InsertProduct(Product product) {
		int status = 0;
		try {
			Connection con = databaseutil.getConnection();
			String query = "INSERT INTO product(p_name, p_category,p_model,p_price,p_description) VALUES(?,?,?,?,?) ";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, product.getProductName());
			stmt.setString(2, product.getCategory());
			stmt.setString(3, product.getModel());
			stmt.setInt(4, product.getPrice());
			stmt.setString(5, product.getDescription());
			status = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return status;

	}

	public ArrayList<Product> productlist() {
		ArrayList<Product> productlist = new ArrayList<Product>();

		try {
			Connection con = databaseutil.getConnection();
			String sql = "SELECT * FROM product";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				Product pr = new Product();
				pr.setId(rs.getInt("p_id"));
				pr.setProductName(rs.getString("p_name"));
				pr.setCategory(rs.getString("p_category"));
				pr.setModel(rs.getString("p_model"));
				pr.setPrice(rs.getInt("p_price"));
				pr.setDescription(rs.getString("p_description"));

				productlist.add(pr);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return productlist;
	}

	public Product getproduct(int p_id) {
		Product product = null;
		try {
			Connection con = databaseutil.getConnection();
			String sql = "SELECT * FROM product WHERE p_id =?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, p_id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				product = new Product();
				product.setId(rs.getInt("p_id"));
				product.setProductName(rs.getString("p_name"));
				product.setCategory(rs.getString("p_category"));
				product.setModel(rs.getString("p_model"));
				product.setPrice(rs.getInt("p_price"));
				product.setDescription(rs.getString("p_description"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			product = null;
		}

		return product;

	}

	public static int update(Product product) {
	    int status = 0;

	    try {
	        Connection con = databaseutil.getConnection();
	        String sql = "UPDATE product SET p_name = ?, p_category = ?, p_model = ?, p_price = ?, p_description = ? WHERE p_id = ?";
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setString(1, product.getProductName());
	        stmt.setString(2, product.getCategory());
	        stmt.setString(3, product.getModel());
	        stmt.setInt(4, product.getPrice());
	        stmt.setString(5, product.getDescription());
	        stmt.setInt(6, product.getId());
	        status = stmt.executeUpdate();

	        System.out.println("Update status: " + status);
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error: " + e.getMessage());
	    }

	    return status;
	}

	public int delete(int p_id) {
		int status = 0;

		try {
			Connection con = databaseutil.getConnection();
			String sql = "DELETE FROM product WHERE p_id =?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, p_id);
			status = stmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return status;

	}

}
