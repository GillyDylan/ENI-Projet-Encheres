package fr.eni.ecole.encheres.servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.encheres.bll.BLLManager;
import fr.eni.ecole.encheres.bo.Article;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;
import fr.eni.ecole.encheres.dal.hibernate.EnchereDAOHibernate;

public class ServletDetailsEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletDetailsEnchere() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Article articleDetail = new Article();
		try {
			articleDetail = BLLManager.getBLL(new Article()).get(Integer.valueOf(request.getParameter("articleId")));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			int idArticle = Integer.parseInt(request.getParameter("articleId"));
			System.out.println(idArticle);
			List<Enchere> encheres = new EnchereDAOHibernate().selectByOneId(idArticle);
			if(encheres != null && !encheres.isEmpty()) {
				request.setAttribute("enchereDetails", encheres.get(0));
			}


		} catch (DALException e) {
			e.printStackTrace();
		}
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setAttribute("articleDetails", articleDetail);
		request.getRequestDispatcher("/enchere").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
