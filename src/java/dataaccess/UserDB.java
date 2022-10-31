/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Role;
import models.User;


/**
 *
 * @author Allan T
 */
public class UserDB {
     public List<User> getAll() throws Exception {
        List<User> users = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet result = null;
        String sql = "SELECT email, first_name, last_name, password, role_id, role_name FROM User, Role  WHERE  role = role_id; ";

try {
            ps = con.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                String email = result.getString(1);
                String firstName = result.getString(2);
                String lastName = result.getString(3);
                String password = result.getString(4);
                int role_id = result.getInt(5);   
                String role_name = result.getString(6); 
                Role role = new Role(role_id, role_name);
                User user = new User(email, firstName, lastName, password, role_id);
                users.add(user);
            }
        } finally {
            DBUtil.closeResultSet(result);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }  
        return users;
    }
     public User getUser(String email) throws Exception {
         User user = null ; 
         ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet result = null;
        String sql = "SELECT email, first_name, last_name, password, role_id, role_name FROM User, Role  WHERE  role = role_id AND email =?; ";
        try {
             ps = con.prepareStatement(sql);
             ps.setString(1, email);
            result = ps.executeQuery();
            if (result.next()) {
                String firstName = result.getString(2);
                String lastName = result.getString(3);
                String password = result.getString(4);
                int role_id = result.getInt(5);   
                String role_name = result.getString(6); 
                Role role = new Role(role_id, role_name);
                 user = new User(email, firstName, lastName, password, role_id);
                
        }
     } 
        finally {
            DBUtil.closeResultSet(result);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        } 
        return user; 
}
  public void insert(User user) throws Exception{
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "Insert into user (email, first_name, last_name, password, role) values (?, ?, ?, ?)";
        try{
            ps = con.prepareStatement(sql); 
            ps.setString(1,user.getEmail());
            ps.setString(2,user.getFirstName());
            ps.setString(3,user.getLastName()); 
            ps.setString(4,user.getPassword()); 
            ps.setInt(5,user.getRole()); 
            ps.executeUpdate(); 
        }finally {
             DBUtil.closePreparedStatement(ps);
             cp.freeConnection(con);
        }
        
  } 
public void update(User user) throws Exception{
     ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        
        String sql = "update user set first_name =? , last_name = ? , role =? where email = ?";
         try{
            ps = con.prepareStatement(sql);
             
            ps.setString(1,user.getFirstName());
            ps.setString(2,user.getLastName());
            ps.setInt(3, user.getRole());
            ps.setString(4,user.getEmail());            
            ps.executeUpdate(); 
} finally {
             DBUtil.closePreparedStatement(ps);
             cp.freeConnection(con);
        }
}
public void delete(User user) throws Exception {
      ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "Delete from user where email = ?";
         try{
            ps = con.prepareStatement(sql);
        ps.setString(1,user.getEmail()); 
            ps.executeUpdate(); 
}
 finally {
             DBUtil.closePreparedStatement(ps);
             cp.freeConnection(con);
        }
}
}
