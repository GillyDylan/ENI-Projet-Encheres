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
 * Servlet implementation class ServletModifier
 */
@WebServlet("/ServletModifierProfil")
public class ServletModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifierProfil() {
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
		if(request.getParameter("modifier").equals("modifier")){
			((Utilisateur)request.getSession().getAttribute("utilisateur")).setPrenomUtilisateur(request.getParameter("prenom").trim());
			((Utilisateur)request.getSession().getAttribute("utilisateur")).setNomUtilisateur(request.getParameter("nom").trim());
			((Utilisateur)request.getSession().getAttribute("utilisateur")).setTelephoneUtilisateur(request.getParameter("telephone").trim());
			((Utilisateur)request.getSession().getAttribute("utilisateur")).setMotDePasseUtilisateur(request.getParameter("mdp").trim());
			((Utilisateur)request.getSession().getAttribute("utilisateur")).setRueUtilisateur(request.getParameter("rue").trim());
			((Utilisateur)request.getSession().getAttribute("utilisateur")).setVilleUtilisateur(request.getParameter("ville").trim());
			((Utilisateur)request.getSession().getAttribute("utilisateur")).setCodePostalUtilisateur(Integer.valueOf(request.getParameter("codepostal").trim()));
			try {
				DAOFactory.getDAO(new Utilisateur()).update((Utilisateur)request.getSession().getAttribute("utilisateur"));
				this.getServletContext().getNamedDispatcher("index").forward(request, response);
			} catch (DALException e) {
				request.setAttribute("erreurModification", e.getMessage());
				this.getServletContext().getNamedDispatcher("index?page=profil").forward(request, response);
			}
		}else {
			this.getServletContext().getNamedDispatcher("index").forward(request, response);
		}
	}

}
