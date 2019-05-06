package fr.eni.ecole.encheres.servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.encheres.bll.BLLException;
import fr.eni.ecole.encheres.bll.BLLManager;
import fr.eni.ecole.encheres.bo.Article;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAO;
import fr.eni.ecole.encheres.dal.DAOFactory;

public class ServletEncherir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEncherir() {
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
		int valeurEnchere = Integer.valueOf(request.getParameter("nouvelleEnchere"));
		Article article = (Article) request.getSession().getAttribute("article"); 
		Date date = new Date();
		Utilisateur utilisateur = (Utilisateur)request.getSession().getAttribute("utilisateur");
		article.setUtilisateurAchetant(utilisateur);
		Enchere nouvelleEnchere = new Enchere(utilisateur, article, date, valeurEnchere);
		response.setContentType("text/plain");
		try {
			DAOFactory.getDAO(new Enchere()).insert(nouvelleEnchere);
			DAOFactory.getDAO(new Article()).update(article);
			response.getWriter().write("Enchère acceptée.");
		} catch (DALException e) {
			response.getWriter().write("Erreur : " + e.getMessage());
		}
	}

}
