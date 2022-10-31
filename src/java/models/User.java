/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author Allan T
 */
public class User implements Serializable {
    private String email; 
    private String firstName; 
    private String lastName; 
    private String password; 
    private int role; 

    public User() {
    }

    public User(String email, String firstName,String lastName,  String password, int role) {
        this.email = email;
        this.firstName = firstName;
        this.lastName= lastName;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setEmail(String email) {
     this.email = email; 
    }
   
    
    
            
           
}
