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
		try {
			int idArticle = Integer.parseInt(request.getParameter("id"));
			List<Enchere> encheres = DAOFactory.getDAO(new Enchere()).selectById(idArticle);
			Collections.sort(encheres, new Comparator<Enchere>() {
				@Override
				public int compare(Enchere ench1, Enchere ench2) {
					return ench1.getDateEnchere().compareTo(ench2.getDateEnchere());
				}
			});
			System.out.println(encheres.get(0).getDateEnchere());
			
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			DAOFactory.getDAO(new Enchere()).insert(nouvelleEnchere);
			this.getServletContext().getRequestDispatcher("/index?page=details&id="+article.getIdArticle()).forward(request, response);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
