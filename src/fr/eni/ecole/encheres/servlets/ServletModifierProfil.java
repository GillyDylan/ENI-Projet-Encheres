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
			Utilisateur modUtilisateur = new Utilisateur();
			modUtilisateur.setIdUtilisateur(1);
			modUtilisateur.setPseudonymeUtilisateur(request.getParameter("pseudo"));
			modUtilisateur.setPrenomUtilisateur(request.getParameter("prenom"));
			modUtilisateur.setNomUtilisateur(request.getParameter("nom"));
			modUtilisateur.setEMailUtilisateur(request.getParameter("email"));
			modUtilisateur.setTelephoneUtilisateur(Integer.valueOf(request.getParameter("telephone")));
			modUtilisateur.setMotDePasseUtilisateur(request.getParameter("mdp"));
			modUtilisateur.setRueUtilisateur(request.getParameter("rue"));
			modUtilisateur.setVilleUtilisateur(request.getParameter("ville"));
			modUtilisateur.setCodePostalUtilisateur(Integer.valueOf(request.getParameter("codepostal")));
			try {
				DAOFactory.getDAO(new Utilisateur()).update(modUtilisateur);
				request.getSession().setAttribute("utilisateur", modUtilisateur); 
				this.getServletContext().getNamedDispatcher("index?page=profil").forward(request, response);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
