package nl.zuyd.marktplaats_revised.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.research.ws.wadl.Request;

import nl.zuyd.marktplaats_revised.entities.User;
import nl.zuyd.marktplaats_revised.repositories.IUserRepository;

/**
 * Servlet implementation class AdminUserServlet
 */
@WebServlet("/adminUser")
public class AdminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	@EJB
	IUserRepository userRepo;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
    	User byUsername = userRepo.getByUsername(request.getParameter("id"));
		// TODO handle byUsername==null and auth
    	request.setAttribute("User", byUsername);
    	this.getServletContext().getRequestDispatcher("/EditUser.jsp").forward(request, response);
	}
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String p;
		if ((p = request.getParameter("delete_username")) != null)
		{
			User u = userRepo.getById(p);
			// TODO handle u==null and auth
			userRepo.deleteUser(u);
			this.getServletContext().getRequestDispatcher("/users").forward(request, response);
		}
		else if ((p = request.getParameter("save_username")) != null)
		{
			User u = userRepo.getById(p);
			// TODO handle u==null and auth
			u.setEmail(request.getParameter("Email"));
			u.setWoonplaats(request.getParameter("Woonplaats"));
			u.setPassword(request.getParameter("Password"));
			userRepo.saveUser(null);
		}
		else
		{
			super.doPost(request, response);
		}
	}
}