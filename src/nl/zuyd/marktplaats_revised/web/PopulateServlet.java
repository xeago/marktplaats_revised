package nl.zuyd.marktplaats_revised.web;

import java.io.IOException;

import javax.annotation.Resource;
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



/**
 * Servlet implementation class PopulateServlet
 */
@WebServlet("/PopulateDB")
public class PopulateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	@PersistenceContext
	private EntityManager em;
	
	@Resource 
	private UserTransaction utx; 
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.utx.begin();
			this.PopulateDb(); // populate the DB with some random stuff
			this.utx.commit();
		}
		catch (Exception ex) {
			response.getWriter().write(ex.getMessage().toString());
		}
	}

	public void PopulateDb()
	{
		 //EntityManager em = this.emf.createEntityManager();
		 User user = new User();
		 user.setEmail("rickvanbodegraven@gmail.com");
		 user.setPassword("rick");
		 user.setUsername("rickje2");
		 
		 this.em.persist(user);
		 //this.em.flush();
		 
		 Advertisement advert = new Advertisement();
		 advert.setAdvertiser(user);
		 advert.setDate("20-06-2012");
		 advert.setDescription("Schitterende managed advert");
		 advert.setTitle("Titeltje");
		 advert.setPrice("GRATIES");
		 
		 this.em.persist(advert);
		 this.em.flush();
	}
}
