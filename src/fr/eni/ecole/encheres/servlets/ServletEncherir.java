package fr.eni.ecole.encheres.servlets;

import java.io.IOException;
import java.util.Calendar;
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
import fr.eni.ecole.encheres.dal.DAOFactory;

/**
 * Servlet implementation class ServletEncherir
 */
@WebServlet("/ServletEncherir")
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
		int valeurEnchere = Integer.valueOf(request.getParameter("nouvelleenchere"));
		Article article = (Article) request.getSession().getAttribute("article"); 
		Date date = new Date();
		Utilisateur utilisateur = (Utilisateur)request.getSession().getAttribute("utilisateur");		
		
		Enchere nouvelleEnchere = new Enchere(utilisateur, article, date, valeurEnchere);
		
		try {
			//test si l'article n'est pas deja en base enchere
			//List<Enchere> modifierEncheres = DAOFactory.getDAO(new Enchere()).selectById(utilisateur.getIdUtilisateur(), article.getIdArticle());				
			//BLLManager.getBLL(new Enchere()).get(utilisateur.getIdUtilisateur(), article.getIdArticle());
			//si le test est null on insert
			//if(modifierEncheres.size() == 0) {
			DAOFactory.getDAO(new Enchere()).insert(nouvelleEnchere);
			//}
			//sinon on met à jour
//			else {
//				modifierEncheres.get(0).setMontantEnchere(valeurEnchere);
//				modifierEncheres.get(0).setDateEnchere(date);
//				DAOFactory.getDAO(new Enchere()).update(modifierEncheres.get(0));
//			}
			//this.getServletContext().getNamedDispatcher("index").forward(request, response);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
