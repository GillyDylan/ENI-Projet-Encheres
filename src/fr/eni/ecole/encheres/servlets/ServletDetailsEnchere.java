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

/**
 * Servlet implementation class ServletDetailsEnchere
 */
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
		
//		try {
//			int idArticle = Integer.parseInt(request.getParameter("articleId"));
//			List<Enchere> encheres = DAOFactory.getDAO(new Enchere()).selectById(idArticle);
//			Collections.sort(encheres, new Comparator<Enchere>() {
//				@Override
//				public int compare(Enchere ench1, Enchere ench2) {
//					return ench1.getDateEnchere().compareTo(ench2.getDateEnchere());
//				}
//			});
//			System.out.println(encheres.get(0).getDateEnchere());
//			
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
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
