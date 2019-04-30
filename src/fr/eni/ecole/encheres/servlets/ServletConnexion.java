package fr.eni.ecole.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.encheres.bll.BLLManager;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");
		Utilisateur utilisateur = null;
		
		try {
			utilisateur = (Utilisateur) BLLManager.getBLL(new Utilisateur()).get(login);
			if(utilisateur.getPseudonymeUtilisateur().equals(login) && utilisateur.getMotDePasseUtilisateur().equals(mdp)) {
				request.getSession().setAttribute("utilisateur", utilisateur);
				this.getServletContext().getNamedDispatcher("index").forward(request, response);
			}else {
				request.setAttribute("erreurConnexion", "Erreur de connexion.");
				this.getServletContext().getRequestDispatcher("/index?page=connexion").forward(request, response);			
			}
		} catch (DALException e) {
			request.setAttribute("erreurConnexion", e.getMessage());
		}
	}

}
