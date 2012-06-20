package nl.zuyd.marktplaats_revised.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.zuyd.marktplaats_revised.User;
import nl.zuyd.marktplaats_revised.UserRepository;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/users")
public class UserServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@EJB
	UserRepository userRepo;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet()
	{
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		List<User> l = userRepo.getAll();
		
		// check for query params
		String s;
		if ((s = request.getParameter("id")) != null)
		{
			User u = null;
			for (User user : l)
			{
				if (user.getId() == Integer.parseInt(s))
					u = user;
			}
			
			request.setAttribute("User", u);
			this.getServletContext()
						.getRequestDispatcher("/EditUser.jsp")
						.forward(request, response);

		}
		else
		{
			
			// else list all advertisements and forward to the
			// ListAdvertisements.jsp to display all advertisements
			request.setAttribute("Users", l);
			this.getServletContext()
					.getRequestDispatcher("/ListUsers.jsp")
					.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{		
		String p;
		if ((p = request.getParameter("delete_id")) != null)
		{
			// del
			response.getWriter().write(p);
		}
		else if ((p = request.getParameter("sold_id")) != null)
		{
			response.getWriter().write(p);
		}
		else if ((p = request.getParameter("save_id")) != null)
		{
			response.getWriter().write(p);
		}
		else
		{
			super.doPost(request, response);
		}
	}
}
