package nl.zuyd.marktplaats_revised.web;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.zuyd.marktplaats_revised.entities.Advertisement;
import nl.zuyd.marktplaats_revised.entities.User;
import nl.zuyd.marktplaats_revised.repositories.IAdvertisementRepository;
import nl.zuyd.marktplaats_revised.repositories.IUserRepository;

/**
 * Servlet implementation class AdminAdvertisementServlet
 */
@WebServlet("/adminAdvertisement")
public class AdminAdvertisementServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@EJB
	IAdvertisementRepository advertRepo;
	@EJB
	IUserRepository userRepo;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminAdvertisementServlet()
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
		
		String s;
		if ((s = request.getParameter("id")) != null)
		{
			Advertisement advert = this.advertRepo.getById(Integer.parseInt(s));
			request.setAttribute("Advertisement", advert);
			
			// or just check if the owner == the current user
			if (advert != null
					&& advert.getAdvertiser().getId() == userRepo.getById(
							request.getUserPrincipal().getName()).getId())
			{
				this.getServletContext()
						.getRequestDispatcher("/EditAdvertisement.jsp")
						.forward(request, response);
				return;
			}
			
		}
		else if (request.getUserPrincipal() != null)
		{
			User user = userRepo.getByUsername(request.getUserPrincipal()
					.getName());
			List<Advertisement> advertisementsByUser = advertRepo
					.getAdvertisementsByUser(user);
			request.setAttribute("Advertisements", advertisementsByUser);
			this.getServletContext()
					.getRequestDispatcher("/ListAdvertisements.jsp")
					.forward(request, response);
		}
		else
		{
			this.getServletContext().getRequestDispatcher("/advertisements")
					.forward(request, response);
			return;
		}
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		// List<Advertisement> l = advertRepo.getAll();
		String p;
		if ((p = request.getParameter("delete_id")) != null)
		{
			// del
			Advertisement advertToDelete = this.advertRepo.getById(Integer
					.parseInt(p));
			
			if (advertToDelete.getAdvertiser().getUsername()
					.equals(request.getUserPrincipal().getName()))
			{
				response.getWriter().write(
						"Advert with title " + advertToDelete.getTitle()
								+ " is going to be deleted");
				advertRepo.deleteAdvertisement(advertToDelete);
			}
		}
		else if ((p = request.getParameter("sold_id")) != null)
		{
			int id = Integer.parseInt(p);
			
			Advertisement soldAdvert = this.advertRepo.getById(id);
			
			if (soldAdvert != null)
			{
				soldAdvert.setStatus(1); // 0 = unsold, 1 = sold
				this.advertRepo.updateAdvertisement(soldAdvert);
			}
			this.getServletContext().getRequestDispatcher("/advertisements")
					.forward(request, response);
			
		}
		else if ((p = request.getParameter("save_id")) != null)
		{
			Advertisement advertToUpdate = this.advertRepo.getById(Integer
					.parseInt(p));
			
			if (advertToUpdate.getAdvertiser().getUsername()
					.equals(request.getUserPrincipal().getName()))
			{
				
				String title = request.getParameter("Title");
				String description = request.getParameter("Description");
				String price = request.getParameter("Price");
				
				if (advertToUpdate != null)
				{
					advertToUpdate.setTitle(title);
					advertToUpdate.setDescription(description);
					advertToUpdate.setPrice(price);
					
					this.advertRepo.updateAdvertisement(advertToUpdate);
				}
			}
			
			this.getServletContext().getRequestDispatcher("/advertisements")
					.forward(request, response);
		}
		else
		{
			String title = request.getParameter("Title");
			String description = request.getParameter("Description");
			String price = request.getParameter("Price");
			
			// add new Advert
			Advertisement advertToSave = new Advertisement();
			advertToSave.setTitle(title);
			User advertiser = this.userRepo.getByUsername(request
					.getUserPrincipal().getName());
			advertToSave.setAdvertiser(advertiser);
			advertToSave.setPrice(price);
			advertToSave.setDate(new Date().toString().substring(0, 10));
			advertToSave.setDescription(description);
			this.advertRepo.addAdvertisement(advertToSave);
			
			//super.doPost(request, response);
		}
	}
	
}
