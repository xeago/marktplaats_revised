package nl.zuyd.marktplaats_revised.web;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import nl.zuyd.marktplaats_revised.entities.Advertisement;
import nl.zuyd.marktplaats_revised.entities.User;
import nl.zuyd.marktplaats_revised.repositories.IUserRepository;

/**
 * Servlet implementation class AddAdvertisement
 */
@WebServlet("/AddAdvertisement")
public class AddAdvertisement extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@PersistenceContext
	private EntityManager em;
	
	@Resource 
	private UserTransaction utx; 
	
	@EJB
	IUserRepository userRepo;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdvertisement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
			this.utx.begin();
			AddAdvertisement(request);
			this.utx.commit();
		}
		catch (Exception ex) {
			response.getWriter().write(ex.getMessage().toString());
		}

			
		 this.getServletContext()
		 	.getRequestDispatcher("/ListAdvertisements.jsp").forward(request, response);

	}
	
	public void AddAdvertisement(HttpServletRequest request)
	{
		//EntityManager em = this.emf.createEntityManager();
		
		
		
		 Advertisement add = new Advertisement();
		 
		 add.setPrice(request.getParameter("Price"));
		 
		 //get sysdate
		 Date sysDate = new Date();
		 String dateString = sysDate.toString().substring(0, 20); 
		 
		 add.setDate(dateString);
		 add.setDescription(request.getParameter("Description"));
		 add.setTitle(request.getParameter("Title"));
		 add.setStatus(0);
		 
		 //get user logged in
		 String userName = request.getUserPrincipal().getName();
		 User u =  userRepo.getByUsername(userName);
		 add.setAdvertiser(u);
		 //add.setAdvertiser(new User());
		 
		 this.em.persist(add);
		 this.em.flush();
	}

}
