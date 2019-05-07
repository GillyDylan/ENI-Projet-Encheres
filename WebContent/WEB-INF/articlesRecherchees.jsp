<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java"
	import="java.util.*,java.lang.*, 
	java.time.LocalDate, 
	fr.eni.ecole.encheres.bo.Article, 
	fr.eni.ecole.encheres.bo.Categorie, 
	fr.eni.ecole.encheres.bo.Utilisateur"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<div class="row d-flex">
	<c:forEach var="article" items="${rechercheDetaille}">
		<div class="col-12 col-lg-4">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">${article.getNomArticle()}</h4>
					<p class="card-text">Prix : ${article.getPrixInitialArticle() }
						points</p>
					<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
					<fmt:formatDate var="date"
						value="${article.getDateFinEncheresArticle()}"
						pattern="dd MMM YYYY" />
					<p class="card-text">Fin de l'enchere : ${date }</p>
					<p class="card-text">Vendeur :</p>
					<p class="card-text">${article.getUtilisateurVendant().getPrenomUtilisateur()}
						${article.getUtilisateurVendant().getNomUtilisateur()}</p>
					<input type="button"
						onclick="getDetails(${article.getIdArticle()})"
						class="btn btn-primary" value="Détails" />
				</div>
			</div>
		</div>
	</c:forEach>
</div>