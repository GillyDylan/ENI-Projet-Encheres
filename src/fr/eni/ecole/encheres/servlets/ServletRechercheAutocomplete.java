package fr.eni.ecole.encheres.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fr.eni.ecole.encheres.bll.BLLManager;
import fr.eni.ecole.encheres.bo.Article;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.dal.DALException;

public class ServletRechercheAutocomplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRechercheAutocomplete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Article> articles = null;
		try {
			articles = BLLManager.getBLL(new Article()).getList();
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		List<String> articlesNom = new ArrayList<String>();
		String term = request.getParameter("term");
		
		for (Article article : articles) {
			if(article.getNomArticle().toLowerCase().contains(term.toLowerCase())) {
				articlesNom.add(article.getNomArticle());
			}
		}	
		
		String articlesJsonString = this.gson.toJson(articlesNom);
		System.out.println(articlesJsonString);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(articlesJsonString);
        out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
