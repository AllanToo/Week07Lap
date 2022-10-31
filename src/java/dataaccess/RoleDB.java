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
/**
 *
 * @author Allan T
 */
public class RoleDB {
     public List<Role> getAll() throws Exception {
        List<Role> roles = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet result = null;
        String sql = "SELECT * from role ";
        try {
            ps = con.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                int role_id = result.getInt(1); 
                String role_name = result.getString(2);  
                Role role = new Role(role_id, role_name);
                roles.add(role);
            }
             } finally {
            DBUtil.closeResultSet(result);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }  
        return roles;
    }
      public Role getRole(int role_id) throws Exception {
         Role role = null ; 
         ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet result = null;
        String sql = "SELECT * FROM Role  WHERE  role_id = ?; ";
         try {
             ps = con.prepareStatement(sql);
             ps.setInt(1, role_id);
            result = ps.executeQuery();
            if (result.next()) {
                String role_name = result.getString(2);
                role = new Role(role_id, role_name);
} 
         }finally {
            DBUtil.closeResultSet(result);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        } 
        return role; 
}
}
