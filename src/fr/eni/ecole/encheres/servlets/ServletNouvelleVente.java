package fr.eni.ecole.encheres.servlets;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import fr.eni.ecole.encheres.bll.BLLException;
import fr.eni.ecole.encheres.bll.BLLManager;
import fr.eni.ecole.encheres.bo.Article;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;

/**
 * Servlet implementation class ServletNouvelleVente
 */
@MultipartConfig
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		Article newArticle = new Article();

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		List<Categorie> categories = null;
		try {
			categories = BLLManager.getBLL(new Categorie()).getList();
		} catch (DALException e) {
			e.printStackTrace();
		}
		for (Categorie categorie : categories) {
			if(categorie.getIdCategorie() == Integer.parseInt(request.getParameter("selectCategorieVente").trim())) {
				newArticle.setCategorie(categorie);
			}
		}
		newArticle.setNomArticle(request.getParameter("article"));
		newArticle.setDescriptionArticle(request.getParameter("description"));
		newArticle.setPrixInitialArticle(Integer.valueOf(request.getParameter("prix")));
		LocalDateTime ldtDebut = LocalDateTime.parse(request.getParameter("debutencheredate") + "T" + request.getParameter("debutencheretime"));
		newArticle.setDateDebutEncheresArticle(Date.from(ldtDebut.atZone(ZoneId.systemDefault()).toInstant()));
		LocalDateTime ldtFin = LocalDateTime.parse(request.getParameter("finencheredate") + "T" + request.getParameter("finencheretime"));
		newArticle.setDateFinEncheresArticle(Date.from(ldtFin.atZone(ZoneId.systemDefault()).toInstant()));
		Utilisateur vendeur = (Utilisateur) request.getSession().getAttribute("utilisateur");
		newArticle.setUtilisateurVendant(vendeur);
		//photo
		Part filePart = request.getPart("photo");
		InputStream fileContent = filePart.getInputStream();
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int nRead;
		byte[] data = new byte[16384];
		while((nRead = fileContent.read(data, 0, data.length)) != -1) {
			buffer.write(data,0,nRead);
		}
		buffer.flush();
		newArticle.setImageArticle(buffer.toByteArray());

		try {
			BLLManager.getBLL(new Article()).set(newArticle);
			response.getWriter().write("Produit ajouté à la liste des enchères.");
		} catch (DALException | BLLException e) {
			response.getWriter().write(e.getMessage());
		}
	}
}
