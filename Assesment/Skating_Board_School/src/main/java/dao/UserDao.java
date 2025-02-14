package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DBConnection;
import model.User;

public class UserDao {

	public static void insertUser(User u) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "insert into users(first_name,last_name,email,mobile,address,gender,password) values(?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, u.getFirst_name());
			pst.setString(2, u.getLast_name());
			pst.setString(3, u.getEmail());
			pst.setString(4, u.getMobile());
			pst.setString(5, u.getAddress());
			pst.setString(6, u.getGender());
			pst.setString(7, u.getPassword());
			pst.executeUpdate();
			System.out.println("User data registered Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from users where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static User userLogin(User u) {
		User u1 = null;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from users where email=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				u1 = new User();
				u1.setId(rs.getInt("id"));
				u1.setFirst_name(rs.getString("first_name"));
				u1.setLast_name(rs.getString("last_name"));
				u1.setEmail(rs.getString("email"));
				u1.setMobile(rs.getString("mobile"));
				u1.setAddress(rs.getString("address"));
				u1.setGender(rs.getString("gender"));
				u1.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u1;
	}

	public static boolean checkOldPassword(int id, String op) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from users where id=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setString(2, op);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static void setNewPassword(int id, String np) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "update users set password=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setInt(2, id);
			pst.executeUpdate();
			System.out.println("New password updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setForgotNewPassword(String email,String np) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "update users set password=? where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setString(2, email);
			pst.executeUpdate();
			System.out.println("New password changed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
