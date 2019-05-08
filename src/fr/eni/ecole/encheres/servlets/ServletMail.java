package fr.eni.ecole.encheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

import fr.eni.ecole.encheres.bll.BLL;
import fr.eni.ecole.encheres.bll.BLLException;
import fr.eni.ecole.encheres.bll.BLLManager;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;

import java.util.*;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.*;
import javax.mail.internet.*;

public class ServletMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletMail() {
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
		String pseudo = null;
		String mdp = null;
		pseudo = request.getParameter("pseudo");
		Utilisateur adressemailrecherchee = null;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		final String username = "eni.encheres@gmail.com";
		final String password = "aawchjfvfybgdgzt";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getInstance(prop,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			try {
				adressemailrecherchee = BLLManager.getBLL(new Utilisateur()).get(pseudo);
				mdp = decrypt(adressemailrecherchee.getMotDePasseUtilisateur());
				
			} catch (Exception e1) {
				response.getWriter().write("Pseudonyme inconnu.");
				return;
			}
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from@gmail.com"));
			message.setRecipients(
					Message.RecipientType.TO,
					InternetAddress.parse(adressemailrecherchee.geteMailUtilisateur())
					);
			message.setSubject("Mot de passe oublié.");
			message.setText("Bonjour " + adressemailrecherchee.getPrenomUtilisateur() + ","
					+ "\n\n Voici votre mot de passe " + mdp + "."
					+ "\n\n Ne le perd plus, abruti!");

			Transport.send(message);

			System.out.println("Done");
			response.getWriter().write("Mail envoyé.");	

		} catch (MessagingException e) {
			response.getWriter().write("Erreur interne - Mail non envoyé.");	
		}
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
