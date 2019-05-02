package fr.eni.ecole.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;

/**
 * Servlet implementation class ServletSupprimerProfil
 */
@WebServlet("/ServletSupprimerProfil")
public class ServletSupprimerProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSupprimerProfil() {
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
		Utilisateur utilisateurToDelete = ((Utilisateur)request.getSession().getAttribute("utilisateur"));
		try {
			DAOFactory.getDAO(new Utilisateur()).delete(utilisateurToDelete.getIdUtilisateur());
			request.getSession().removeAttribute("utilisateur");
			this.getServletContext().getNamedDispatcher("index").forward(request, response);				
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
}
