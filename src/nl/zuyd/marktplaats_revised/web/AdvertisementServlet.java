package nl.zuyd.marktplaats_revised.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.zuyd.marktplaats_revised.entities.Advertisement;
import nl.zuyd.marktplaats_revised.repositories.IAdvertisementRepository;
import nl.zuyd.marktplaats_revised.repositories.IUserRepository;

/**
 * Servlet implementation class AdvertisementServlet
 */
@WebServlet("/advertisements")
public class AdvertisementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	IAdvertisementRepository advertRepo;
	@EJB
	IUserRepository userRepo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdvertisementServlet() {
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

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doResponse(request, response);
	}

	private void doResponse(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Advertisement> l = advertRepo.getAll();

		// check for query params
		String s;
		if ((s = request.getParameter("id")) != null) {
			Advertisement advert = this.advertRepo.getById(Integer.parseInt(s));
			request.setAttribute("Advertisement", advert);

			if (advert == null) {
				request.setAttribute("Advertisements", advertRepo.getAll());

				this.getServletContext()
						.getRequestDispatcher("/ListAdvertisements.jsp")
						.forward(request, response);
			} else {
				this.getServletContext()
						.getRequestDispatcher("/SingleAdvertisement.jsp")
						.forward(request, response);
			}
		} else {

			// else list all advertisements and forward to the
			// ListAdvertisements.jsp to display all advertisements
			request.setAttribute("Advertisements", l);
			this.getServletContext()
					.getRequestDispatcher("/ListAdvertisements.jsp")
					.forward(request, response);
		}
	}
}
