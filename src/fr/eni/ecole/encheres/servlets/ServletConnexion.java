package fr.eni.ecole.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		String login = request.getParameter("login").trim();
		String mdp = request.getParameter("mdp").trim();
		Utilisateur utilisateur = null;
		request.setCharacterEncoding("UTF-8");		
		response.setContentType("text/html; charset=UTF-8");
		try {
			if(((UtilisateurBLL) BLLManager.getBLL(new Utilisateur())).checkMotDePasse(login, mdp)) {
				utilisateur = (Utilisateur) BLLManager.getBLL(new Utilisateur()).get(login);
				if(request.getParameter("remember").equals("true")) {
					String cookieName = "login";
					Cookie[] cookies = request.getCookies();
					if (cookies != null) 
					{
						for(int i=0; i<cookies.length; i++) 
						{
							Cookie cookie = cookies[i];
							if (!cookieName.equals(cookie.getName())) 
							{
								try {
									utilisateur = BLLManager.getBLL(new Utilisateur()).get(login);
								} catch (DALException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								if(utilisateur != null) {
									mdp = utilisateur.getMotDePasseUtilisateur();
									Cookie cookiePseudo = new Cookie("login", login);
									cookiePseudo.setMaxAge(7*24*60*60);
									response.addCookie(cookiePseudo);
									Cookie cookieMdp = new Cookie("mdp", mdp);
									cookieMdp.setMaxAge(7*24*60*60);
									response.addCookie(cookieMdp);
								}
							}
						}
					}
				}
				request.getSession().setAttribute("utilisateur", utilisateur);
				request.getRequestDispatcher("/ServletAccueil").include(request, response);
			}else {
				request.setAttribute("erreurConnexion", "Erreur de connexion.");
				request.getRequestDispatcher("/WEB-INF/connexion.jsp").include(request, response);			
			}
		} catch (Exception e) {
			request.setAttribute("erreurConnexion", "Erreur de connexion");
			request.getRequestDispatcher("/WEB-INF/connexion.jsp").include(request, response);			
		}
	}
}
