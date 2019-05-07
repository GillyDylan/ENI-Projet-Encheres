package fr.eni.ecole.encheres.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.encheres.bll.ArticleBLL;
import fr.eni.ecole.encheres.bll.BLLManager;
import fr.eni.ecole.encheres.bo.Article;
import fr.eni.ecole.encheres.bo.ArticleRecherche;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;

public class ServletRechercheDetaillee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRechercheDetaillee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String filtre = request.getParameter("strRecherche");

		List<Categorie> categories = null;
		try {
			categories = BLLManager.getBLL(new Categorie()).getList();
		} catch (DALException e) {
			e.printStackTrace();
		}

		Categorie categorieRecherchee = null;

		for (Categorie categorie : categories) {
			if(categorie.getIdCategorie() == Integer.parseInt(request.getParameter("categorie").trim())) {
				categorieRecherchee = categorie;
			}
		}
		boolean isAchat = false;
		if(request.getParameter("isAchat").trim().equals("true")) {
			isAchat = true;
		}
		boolean isParam1 = false;
		if(
			(request.getParameter("venteNonDebutees") != null 
			&& request.getParameter("venteNonDebutees").trim().equals("true")) 
			|| (request.getParameter("encheresOuvertes") != null 
			&& request.getParameter("encheresOuvertes").trim().equals("true"))
		) 
		{
			isParam1 = true;
		}
		boolean isParam2 = false;
		if(
			(request.getParameter("venteEnCours") !=null 
			&& request.getParameter("venteEnCours").trim().equals("true"))
			|| (request.getParameter("encheresEnCours") != null
			&& request.getParameter("encheresEnCours").trim().equals("true")) 
		) 
		{
			isParam2 = true;
		}
		boolean isParam3 = false;
		if(
			(request.getParameter("ventesTerminees") != null
			&& request.getParameter("ventesTerminees").trim().equals("true")) 
			|| ( request.getParameter("encheresRemportees") != null
			&& request.getParameter("encheresRemportees").trim().equals("true"))
		) 
		{
			isParam3 = true;
		}		
		
		Utilisateur utilisateur = null;
		
		if(request.getSession().getAttribute("utilisateur") != null) {
			utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
		}

		ArticleRecherche articleRecherchee = 
				new ArticleRecherche(filtre, categorieRecherchee, isAchat, isParam1, isParam2, isParam3);

		List<Article> articlesRecherchees = null;
		response.setCharacterEncoding("UTF-8");
		try {
			articlesRecherchees = ((ArticleBLL) BLLManager.getBLL(new Article())).getList(articleRecherchee, utilisateur);
			request.setAttribute("rechercheDetaille", articlesRecherchees);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/articlesRecherchees.jsp");  
			rd.include(request, response);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Article article : articlesRecherchees) {
			System.out.println(article.getNomArticle());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
