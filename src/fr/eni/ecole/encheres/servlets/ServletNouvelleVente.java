package fr.eni.ecole.encheres.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.encheres.bo.Article;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;

/**
 * Servlet implementation class ServletNouvelleVente
 */
@WebServlet("/ServletNouvelleVente")
public class ServletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletNouvelleVente() {
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
		Article newArticle = new Article();
		newArticle.setNomArticle(request.getParameter("article"));
		newArticle.setDescriptionArticle(request.getParameter("description"));
		newArticle.setCategorie(new Categorie("Test"));
		newArticle.setPrixInitialArticle(Integer.valueOf(request.getParameter("prix")));
		newArticle.setDateDebutEncheresArticle(Date.valueOf(request.getParameter("debutenchere")));
		newArticle.setDateFinEncheresArticle(Date.valueOf(request.getParameter("finenchere")));
		Utilisateur vendeur = (Utilisateur) request.getSession().getAttribute("utilisateur");
		newArticle.setUtilisateurVendant(vendeur);
		
		try {
			System.out.println(newArticle.getCategorie().getLibelleCategorie());
			System.out.println(newArticle.getCategorie().getIdCategorie());
			DAOFactory.getDAO(new Categorie()).insert(newArticle.getCategorie());
			DAOFactory.getDAO(new Article()).insert(newArticle);
			this.getServletContext().getNamedDispatcher("index").forward(request, response);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
