package fr.eni.ecole.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.encheres.bll.BLLManager;
import fr.eni.ecole.encheres.bll.UtilisateurBLL;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConnexion() {
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
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");
		Utilisateur utilisateur = null;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		try {
			if(((UtilisateurBLL) BLLManager.getBLL(new Utilisateur())).checkMotDePasse(login, mdp)) {
				utilisateur = (Utilisateur) BLLManager.getBLL(new Utilisateur()).get(login);
				request.getSession().setAttribute("utilisateur", utilisateur);
				request.getRequestDispatcher("/ServletAccueil").include(request, response);
			}else {
				request.setAttribute("erreurConnexion", "Erreur de connexion.");
				request.getRequestDispatcher("/WEB-INF/connexion.jsp").include(request, response);			
			}
		} catch (DALException e) {
			request.setAttribute("erreurConnexion", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/connexion.jsp").include(request, response);			
		}
	}

}
