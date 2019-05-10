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
		String newRecherche = null;
		if(request.getParameter("newRecherche")!= null) {
			newRecherche = request.getParameter("newRecherche");
			if(newRecherche.equals("newRecherche")) {
				request.getSession().setAttribute("rechercheDebut", 0);
			}
		}	
		
		String action = request.getParameter("action");
		List<Article> articlesRecherchees = null;
		response.setCharacterEncoding("UTF-8");
		if(action.equals("charger")) {
			
			String filtre = request.getParameter("strRecherche");
			if(filtre.equals("all")) {
				filtre = null;
			}

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

			try {
				articlesRecherchees = ((ArticleBLL) BLLManager.getBLL(new Article())).getList(articleRecherchee, utilisateur);
				request.getSession().setAttribute("articlesRecherchees", articlesRecherchees);
				//si on a pas encore tourné les pages
				if(request.getSession().getAttribute("rechercheDebut") == null) {
					//on commence à 0
					request.getSession().setAttribute("rechercheDebut", 0);
				}
				RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/articlesRecherchees.jsp");  
				rd.include(request, response);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(action.equals("suivant")){
			if(request.getSession().getAttribute("rechercheDebut") != null ) {
				//on recupere le debut de la recherche et la liste des articles
				int debutPagination = (int) request.getSession().getAttribute("rechercheDebut");
				//on ajoute 3 par page
				int finPagination = ((List<Article>)request.getSession().getAttribute("articlesRecherchees")).size();
				if(debutPagination + 3 < finPagination) {
					request.getSession().setAttribute("rechercheDebut", debutPagination + 3);
				}
				//reload la page
				RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/articlesRecherchees.jsp");  
				rd.include(request, response);
			}
		}else if(action.equals("precedent")) {
			if(request.getSession().getAttribute("rechercheDebut") != null) {
				//on recupere le debut de la recherche et la liste des articles
				int debutPagination = (int) request.getSession().getAttribute("rechercheDebut");
				//on ajoute 3 par page
				if(debutPagination>=3) {
					request.getSession().setAttribute("rechercheDebut", debutPagination - 3);
				}
				//reload la page
				RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/articlesRecherchees.jsp");  
				rd.include(request, response);
			}
		}else {
			List<Article> articles = null;
			try {
				articles = ((ArticleBLL) BLLManager.getBLL(new Article())).getList();
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(articles.size() > 0) {
				request.getSession().setAttribute("articlesRecherchees", articles);
			}
			
			if(request.getSession().getAttribute("rechercheDebut") == null) {
				//on commence à 0
				request.getSession().setAttribute("rechercheDebut", 0);
			}
			
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/articlesRecherchees.jsp");  
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
