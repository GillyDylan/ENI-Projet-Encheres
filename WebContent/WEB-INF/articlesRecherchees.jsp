<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java"
	import="java.util.*,java.lang.*, 
	java.time.LocalDate, 
	fr.eni.ecole.encheres.bo.Article, 
	fr.eni.ecole.encheres.bo.Categorie, 
	fr.eni.ecole.encheres.bo.Utilisateur"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<c:if test="${articlesRecherchees.size() > 0}">
	<div class="row d-flex justify-content-center m-2">
		<button type="button" class="btn btn-primary btn-sm"
			onclick="precedentListeArticles()"><<</button>
		<span class="btn btn-primary"> ${rechercheDebut + 1} - ${ (rechercheDebut + 3) > articlesRecherchees.size() ? articlesRecherchees.size() : rechercheDebut + 3 }</span>
		<button type="button" class="btn btn-primary btn-sm"
			onclick="suivantListeArticles()">>></button>
	</div>
	<div class="row d-flex">
		<c:forEach var="article" items="${articlesRecherchees}"
			begin="${rechercheDebut}" end="${rechercheDebut + 2}">
			<div class="col-12 col-lg-4">
				<div class="card" style="width: 18rem;">
				<c:if test="${!empty article.getImageArticle()}">
					<img src="data:image/jpg;base64,${article.getImageArticle() }" class="card-img-top"/>
				</c:if>
				<c:if test="${empty article.getImageArticle()}">
					<img src="" class="card-img-top"/>
				</c:if>
					<div class="card-body">
						<h4 class="card-title">${article.getNomArticle()}</h4>
						<p class="card-text">Prix : ${article.getPrixInitialArticle() }
							points</p>
						<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
						<fmt:formatDate var="date"
								value="${article.getDateFinEncheresArticle()}"
								pattern="dd MMM YYYY" />
							<fmt:formatDate var="time"
								value="${article.getDateFinEncheresArticle()}" pattern="HH:mm" />
							<p class="card-text">Fin de l'enchere : ${date} à ${time}</p>
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
</c:if>
<c:if test="${articlesRecherchees.size() <= 0}">
	<div class="alert alert-primary m-2" role="alert">La recherche n'a
		retournée aucun résultat.</div>

</c:if>