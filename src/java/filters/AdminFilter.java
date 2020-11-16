package filters;

import dataaccess.UserDB;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Role;
import models.User;
import services.AccountService;
/**
 *
 * @author 820203
 */
public class AdminFilter implements Filter
{
    public AdminFilter()
    {
        
    }
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
            
        HttpSession session = httpRequest.getSession();
            
        String email = (String) session.getAttribute("email");
        AccountService as = new AccountService();
        Role userRole = as.getRole(email);
            
        if(userRole.getRoleId() != 1)
        {
            httpResponse.sendRedirect("notes");
            return;
        }  
        chain.doFilter(request, response);
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        
    }
    
    @Override
    public void destroy()
    {
        
    }
}
