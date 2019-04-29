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
 * Servlet implementation class ServletInscription
 */
@WebServlet("/ServletInscription")
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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur newUtilisateur = new Utilisateur();
		newUtilisateur.setPseudonymeUtilisateur(request.getParameter("pseudo"));
		newUtilisateur.setPrenomUtilisateur(request.getParameter("prenom"));
		newUtilisateur.setNomUtilisateur(request.getParameter("nom"));
		newUtilisateur.setEMailUtilisateur(request.getParameter("email"));
		newUtilisateur.setTelephoneUtilisateur(Integer.valueOf(request.getParameter("telephone")));
		newUtilisateur.setMotDePasseUtilisateur(request.getParameter("mdp"));
		newUtilisateur.setRueUtilisateur(request.getParameter("rue"));
		newUtilisateur.setVilleUtilisateur(request.getParameter("ville"));
		newUtilisateur.setCodePostalUtilisateur(Integer.valueOf(request.getParameter("codepostal")));
		try {
			DAOFactory.getDAO(new Utilisateur()).insert(newUtilisateur);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
