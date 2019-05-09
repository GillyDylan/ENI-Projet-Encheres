package fr.eni.ecole.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.encheres.bll.BLLException;
import fr.eni.ecole.encheres.bll.BLLManager;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;

public class ServletAdministration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAdministration() {
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
		if(request.getParameter("type") != null) {
			String type = request.getParameter("type");
			int idUtilisateur = 0;
			response.setCharacterEncoding("UTF-8");
			switch (type){
			case "rendreInactif" :
				idUtilisateur = Integer.parseInt(request.getParameter("idUtilisateur"));
				try {
					Utilisateur utilisateurInactif = BLLManager.getBLL(new Utilisateur()).get(idUtilisateur);
					utilisateurInactif.setActif(false);
					BLLManager.getBLL(new Utilisateur()).set(utilisateurInactif);
					response.getWriter().write(utilisateurInactif.getPseudonymeUtilisateur() + " est devenu inactif.");
				} catch (Exception e) {
					response.getWriter().write(e.getMessage());
				}
				break;
			case "SupprimerUtilisateur" :
				idUtilisateur = Integer.parseInt(request.getParameter("idUtilisateur"));
				try {
					Utilisateur utilisateurRemove = BLLManager.getBLL(new Utilisateur()).get(idUtilisateur);
					BLLManager.getBLL(new Utilisateur()).delete(utilisateurRemove);
					response.getWriter().write(utilisateurRemove.getPseudonymeUtilisateur() + " est devenu un compte supprimé.");
				} catch (Exception e) {
					response.getWriter().write(e.getMessage());
				}
			}

		}
	}

}
