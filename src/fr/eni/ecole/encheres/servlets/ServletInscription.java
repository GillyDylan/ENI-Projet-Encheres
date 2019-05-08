package fr.eni.ecole.encheres.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.encheres.bll.BLLException;
import fr.eni.ecole.encheres.bll.BLLManager;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;

public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletInscription() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		try {
			Utilisateur newUtilisateur = new Utilisateur();
			newUtilisateur.setPseudonymeUtilisateur(request.getParameter("pseudo"));
			newUtilisateur.setPrenomUtilisateur(request.getParameter("prenom"));
			newUtilisateur.setNomUtilisateur(request.getParameter("nom"));
			newUtilisateur.seteMailUtilisateur(request.getParameter("email"));
			newUtilisateur.setTelephoneUtilisateur(request.getParameter("telephone"));
			newUtilisateur.setMotDePasseUtilisateur(request.getParameter("mdp"));
			newUtilisateur.setRueUtilisateur(request.getParameter("rue"));
			newUtilisateur.setVilleUtilisateur(request.getParameter("ville"));
			if(request.getParameter("codepostal").trim() != null || !request.getParameter("codepostal").trim().equals("")) {
				newUtilisateur.setCodePostalUtilisateur(Integer.valueOf(request.getParameter("codepostal")));
			}else {
				newUtilisateur.setCodePostalUtilisateur(0);
			}
			BLLManager.getBLL(new Utilisateur()).set(newUtilisateur);
			request.getSession().setAttribute("utilisateur", newUtilisateur); 
			this.getServletContext().getNamedDispatcher("index").forward(request, response);
		} catch (DALException | BLLException e) {
			PrintWriter out = response.getWriter();
			response.setStatus(400);
			out.print(e.getMessage());
			out.flush();
		}	
	}

}
