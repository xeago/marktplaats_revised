package nl.zuyd.marktplaats_revised.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.zuyd.marktplaats_revised.entities.User;
import nl.zuyd.marktplaats_revised.repositories.IAdvertisementRepository;
import nl.zuyd.marktplaats_revised.repositories.IUserRepository;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/users")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	IUserRepository userRepo;
	@EJB
	IAdvertisementRepository advertRepo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doResponse(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doResponse(request, response);
	}

	protected void doResponse(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<User> l = userRepo.getAll();

		// check for query params
		String s;
		if ((s = request.getParameter("id")) != null) {
			User u = null;
			for (User user : l) {
				if (user.getId() == Integer.parseInt(s))
					u = user;
			}

			request.setAttribute("User", u);
			request.setAttribute("Advertisements",
					advertRepo.getAdvertisementsByUser(u));
			this.getServletContext().getRequestDispatcher("/SingleUser.jsp")
					.forward(request, response);

		} else {
			request.setAttribute("Users", l);
			this.getServletContext().getRequestDispatcher("/ListUsers.jsp")
					.forward(request, response);
		}
	}
}
