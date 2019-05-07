package fr.eni.ecole.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.encheres.bll.BLLManager;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;

/**
 * Servlet implementation class ServletSouvenir
 */
@WebServlet("/ServletSouvenir")
public class ServletSouvenir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSouvenir() {
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
		String cookieName = "login";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) 
		{
			for(int i=0; i<cookies.length; i++) 
			{
				Cookie cookie = cookies[i];
				if (!cookieName.equals(cookie.getName())) 
				{
					String login = request.getParameter("login").trim();
					Utilisateur utilisateur = null;
					try {
						utilisateur = BLLManager.getBLL(new Utilisateur()).get(login);
					} catch (DALException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(utilisateur != null) {
						String mdp = utilisateur.getMotDePasseUtilisateur();
						Cookie cookiePseudo = new Cookie("login", login);
						response.addCookie(cookiePseudo);
						Cookie cookieMdp = new Cookie("mdp", mdp);
						response.addCookie(cookieMdp);
					}
				}
			}
		}
	}

}
