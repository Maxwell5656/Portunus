/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

/**
 *
 * @author sgoug
 */
public class UserLogin {
    //TODO: Make UserLogin Class
    private String username;
    private String password;

    public UserLogin()
    {
        
    }
    public void setLoginInfo(String username, String password)
    {
        this.username =  username;
        this.password = password;
    }
    public boolean verifyCredentials(String username, String password)
    {
        return (this.username == null ? username == null : this.username.equals(username))&&(this.password == null ? password == null : this.password.equals(password));
    }
}
