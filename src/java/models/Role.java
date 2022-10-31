/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Allan T
 */
public class Role {
      private int roleId; 
    private String roleName ; 

    public Role() {
    }

    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
        
      
    }

    public int getId() {
        return roleId;
    }

    public String getName() {
        return roleName;
    }

    public void setId(int roleId) {
        this.roleId = roleId;
    }

    public void setName(String roleName) {
        this.roleName = roleName;
    }
}
