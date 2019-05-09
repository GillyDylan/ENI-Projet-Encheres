package fr.eni.ecole.encheres.servlets;

import java.io.IOException;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

import fr.eni.ecole.encheres.bll.ArticleBLL;
import fr.eni.ecole.encheres.bll.BLL;
import fr.eni.ecole.encheres.bll.BLLManager;
import fr.eni.ecole.encheres.bll.UtilisateurBLL;
import fr.eni.ecole.encheres.bo.Article;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;

public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAccueil() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Se souvenir de moi
		//recupere les cookies
		Cookie[] cookies = request.getCookies();
		String login = null;
		String mdp = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("login")) {
					login = cookie.getValue();				
				}
				if (cookie.getName().equals("mdp")) {
					//decrypt le mdp
					mdp = decrypt(cookie.getValue());				
				}
			}
		}
		try {
			if(login != null && mdp !=null) {
				//test si le decryptage est ok
				if(((UtilisateurBLL) BLLManager.getBLL(new Utilisateur())).checkMotDePasse(login, mdp)) {
					//on cree l'utilisateur
					Utilisateur utilisateur = BLLManager.getBLL(new Utilisateur()).get(login);
					//on l'ajoute en session
					request.getSession().setAttribute("utilisateur", utilisateur);
				}
			}
		} catch (DALException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		List<Article> articles = null;
		List<Categorie> categories = null;
		try {	
			articles = ((ArticleBLL) BLLManager.getBLL(new Article())).getList();
			categories = DAOFactory.getDAO(new Categorie()).selectAll();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(articles.size() > 0) {
			request.getSession().setAttribute("articlesRecherchees", articles);
		}
		request.setAttribute("categories", categories);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/articlesRecherchees.jsp");  
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private final String key = "SmogogoEstTropBo";
	private final String vector = "CestPaNegociable";

	private String decrypt(String password){
		try {
			IvParameterSpec iv = new IvParameterSpec(this.vector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(this.key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] original = cipher.doFinal(Base64.decodeBase64(password));

			return new String(original);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
