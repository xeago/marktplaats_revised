package nl.zuyd.marktplaats_revised.web;

import nl.zuyd.marktplaats_revised.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Init;
import javax.ejb.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.persistence.annotations.Convert;
import org.kohsuke.rngom.parse.host.Base;

/**
 * Servlet implementation class AdvertisementServlet
 */
@WebServlet("/AdvertisementServlet")
public class AdvertisementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	Context context;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdvertisementServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Advertisement> l = context.getAdvertisements();

		// check for query params
		String s;
		if ((s = request.getParameter("id")) != null) {
			Advertisement a = null;
			for (Advertisement advertisement : l) {
				if (advertisement.getId() == Integer.parseInt(s))
					a = advertisement;
			}
			request.setAttribute("Advertisement", a);
			if (a.getAdvertiser().getId()==1)
			{
				this.getServletContext()
						.getRequestDispatcher("/EditAdvertisement.jsp")
						.forward(request, response);
			}
			else {
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
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Advertisement> l = context.getAdvertisements();
		String p;
		if ((p=request.getParameter("delete_id"))!=null)
		{
			//del
			response.getWriter().write(p);
		}
		else if ((p=request.getParameter("sold_id"))!=null)
		{
			response.getWriter().write(p);
		}
		else if ((p=request.getParameter("save_id"))!=null)
		{
			response.getWriter().write(p);
		}
		else {
			super.doPost(request, response);
		}
	}
}
