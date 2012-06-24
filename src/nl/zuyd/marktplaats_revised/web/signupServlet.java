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
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import nl.zuyd.marktplaats_revised.entities.User;



/**
 * Servlet implementation class RegistratieServlet
 */
@WebServlet("/signupServlet")
public class signupServlet extends HttpServlet {
	
	@PersistenceContext
	private EntityManager em;
	
	@Resource 
	private UserTransaction utx; 
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	}
	
	
	public void RegistrateUser(HttpServletRequest request)
	{
		 User user = new User();
		 user.setEmail(request.getParameter("u_email"));
		 user.setPassword(request.getParameter("u_email"));
		 user.setUsername(request.getParameter("u_username"));
		 user.setWoonplaats(request.getParameter("u_home"));
		 
		 this.em.persist(user);
		 this.em.flush();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			System.out.print("TESWT");
			this.utx.begin();
			RegistrateUser(request);
		}
		catch (Exception ex) {
			response.getWriter().write(ex.getMessage().toString());
		}
		finally {
			try {
				this.utx.commit();
			} catch (SecurityException | IllegalStateException
					| RollbackException | HeuristicMixedException
					| HeuristicRollbackException | SystemException e) {
				e.printStackTrace();
			}
		}
		
		 this.getServletContext()
		 	.getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
