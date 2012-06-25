package nl.zuyd.marktplaats_revised.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.zuyd.marktplaats_revised.entities.User;
import nl.zuyd.marktplaats_revised.repositories.IUserRepository;



/**
 * Servlet implementation class RegistratieServlet
 */
@WebServlet("/signupServlet")
public class signupServlet extends HttpServlet {

	@EJB
	IUserRepository userRepo;
	
	private static final long serialVersionUID = 1L;
	
	
	public void RegistrateUser(HttpServletRequest request)
	{
		 User user = new User();
		 user.setEmail(request.getParameter("u_email"));
		 user.setPassword(request.getParameter("u_email"));
		 user.setUsername(request.getParameter("u_username"));
		 user.setWoonplaats(request.getParameter("u_home"));
		 userRepo.addUser(user);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegistrateUser(request);
		 this.getServletContext()
		 	.getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
