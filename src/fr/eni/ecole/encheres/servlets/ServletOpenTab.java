package fr.eni.ecole.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletOpenTab
 */
@WebServlet("/ServletOpenTab")
public class ServletOpenTab extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletOpenTab() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		switch(name) {
			case "accueil":
				this.getServletContext().getNamedDispatcher("ServletAccueil").include(request, response);
				break;
			case "inscription":
				request.getRequestDispatcher("/WEB-INF/creercompte.jsp").include(request, response);
				break;
			case "connexion":
				request.getRequestDispatcher("/WEB-INF/connexion.jsp").include(request, response);
				break;
			case "enchere":
				request.getRequestDispatcher("/WEB-INF/enchere.jsp").include(request, response);
				break;
			case "profil":
				request.getRequestDispatcher("/WEB-INF/profil.jsp").include(request, response);
				break;
			case "nouvellevente":
				this.getServletContext().getNamedDispatcher("pagenouvellevente").include(request, response);
				break;	
			case "deconnexion":
				request.getSession().removeAttribute("utilisateur");
				request.getRequestDispatcher("/ServletAccueil").include(request, response);
				break;
		}
	}

}
