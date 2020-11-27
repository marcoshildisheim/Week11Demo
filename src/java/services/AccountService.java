package services;

import dataaccess.UserDB;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Role;
import models.User;

public class AccountService 
{
    
    public User login(String email, String password) 
    {
        UserDB userDB = new UserDB();
        
        try 
        {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) 
            {
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by: {0}", email);
                return user;
            }
        } 
        catch (Exception e) 
        {
            
        }
        return null;
    }
    
    public Role getRole(String email)
    {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        
        return user.getRole();
    }
}
