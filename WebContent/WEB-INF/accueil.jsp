<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java"
	import="java.util.*,java.lang.*, java.time.LocalDate, java.awt.image.BufferedImage,
	java.io.ByteArrayOutputStream, javax.imageio.ImageIO,
	fr.eni.ecole.encheres.bo.Article, fr.eni.ecole.encheres.bo.Categorie, fr.eni.ecole.encheres.bo.Utilisateur"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="javax.imageio.ImageIO"%>
<jsp:include page="/menu"></jsp:include>
<div class="row">
	<div class="col">
		<h2>
			<p class="text-center">Liste des enchères</p>
		</h2>
	</div>
</div>
<form id="formFiltreRecherche">
	<div class="row">
		<div class="col-6">
			<div class="form-group">
				<label for="filtre">Filtre: </label> <input type="text"
					class="form-control ui-widget" id="strRecherche"
					placeholder="Le nom de l'article contient">
			</div>
			<div class="form-group">
				<label for="selectCategorie">Catégories</label> <select
					name="selectCategorie" id="selectCategorieAccueil"
					class="form-control">
					<c:if test="${!empty categories}">
						<c:forEach var="categorie" items="${categories}">
							<option value="${ categorie.getIdCategorie()  }">${ categorie.getLibelleCategorie() }</option>
						</c:forEach>
					</c:if>
				</select>
			</div>
			<c:if test="${ utilisateur != null }">
				<div class="d-flex">
					<div class="form-check form-check-inline d-flex flex-column">
						<input type="radio" class="form-check-inline" name="chkboxEnchere"
							value="achat" checked onchange="filtrerRecherche()"> <label
							class="form-check-label" for="chkboxEnchere">Achats</label>
						<div class="form-check d-flex flex-column">
							<input type="checkbox" class="form-check-inline"
								id="chkEncheresOuvertes"> <label
								class="form-check-label" for="chkEncheresOuvertes">Enchères
								ouvertes</label> <input type="checkbox" class="form-check-inline"
								id="chkEncheresEnCours"> <label class="form-check-label"
								for="chkEncheresEnCours">Mes enchères en cours</label> <input
								type="checkbox" class="form-check-inline"
								id="chkEncheresRemportees"> <label
								class="form-check-label" for="chkEncheresRemportees">Mes
								enchères remportées</label>
						</div>
					</div>
					<div class="form-check form-check-inline d-flex flex-column">
						<input type="radio" class="form-check-input" name="chkboxEnchere"
							value="vente" onchange="filtrerRecherche()"> <label
							class="form-check-label" for="chkboxEnchere">Ventes</label>
						<div class="form-check d-flex flex-column">
							<input type="checkbox" class="form-check-inline"
								id="chkVentesEnCours"> <label class="form-check-label"
								for="chkVentesEnCours">Ventes en cours</label> <input
								type="checkbox" class="form-check-inline"
								id="chkVentesNonDebutees"> <label
								class="form-check-label" for="chkVentesNonDebutees">Mes
								ventes non débutées</label> <input type="checkbox"
								class="form-check-inline" id="chkVentesTerminees"> <label
								class="form-check-label" for="chkVentesTerminees">Mes
								ventes terminées</label>
						</div>
					</div>
				</div>
			</c:if>
		</div>
		<div
			class="col-6 text-center d-flex align-items-center justify-content-center ">
			<input type="button" value="Rechercher"
				class="btn btn-primary btn-lg" onclick="rechercheDetaillee()" />
		</div>
	</div>
</form>

<div id="recherche" class="mt-5">
	<c:if test="${articles.size() > 0}">
		<c:if test="${articles.size() > 3}">
			<div class="row d-flex justify-content-center m-2">
				<button type="button" class="btn btn-primary btn-sm"
					onclick="precedentListeArticles()"><<</button>
				<span class="btn btn-primary"> ${rechercheDebutAccueil + 1} -
					${ (rechercheDebutAccueil + 3) > articlesRecherchees.size() ? articlesRecherchees.size() : rechercheDebutAccueil + 3 }</span>
				<button type="button" class="btn btn-primary btn-sm"
					onclick="suivantListeArticles()">>></button>
			</div>
		</c:if>
		<div class="row d-flex">
			<c:forEach var="article" items="${articles}"
				begin="${rechercheDebutAccueil}" end="${rechercheDebutAccueil + 2}">
				<div class="col-12 col-lg-4">
					<div class="card" style="width: 18rem;">
						<c:if test="${article.getImageArticle()}">
							<img src="data:image/jpg;base64,${article.getImageArticle() }"
								class="card-img-top" />
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
	<c:if test="${articles.size() <= 0}">
		<div class="alert alert-primary m-2" role="alert">La recherche
			n'a retournée aucun résultat.</div>
	</c:if>
</div>

<script>
	$(document).ready(function() {
		remplirSelectCategorieAccueil();
	});
	
	$( function() {
	    $( "#strRecherche" ).autocomplete({
	      source: 'autocomplete'
	    });
	  } );
</script>