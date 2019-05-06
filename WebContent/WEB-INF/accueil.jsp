<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java"
	import="java.util.*,java.lang.*, java.time.LocalDate, fr.eni.ecole.encheres.bo.Article, fr.eni.ecole.encheres.bo.Categorie, fr.eni.ecole.encheres.bo.Utilisateur"%>
<%@ page contentType="text/html; charset=UTF-8"%>
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
					class="form-control ui-widget" id="filtre"
					placeholder="Le nom de l'article contient">
			</div>
			<div class="form-group">
				<label for="selectCategorie">Catégories</label> <select
					name="selectCategorie" id="selectCategorieAccueil" class="form-control">
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
						<input type="radio" class="form-check-input" name="chkboxEnchere"
							value="achat" checked onchange="filtrerRecherche()"> <label
							class="form-check-label" for="chkboxEnchere">Achats</label>
						<div class="form-check d-flex flex-column">
							<input type="checkbox" class="form-check-input"
								id="chkEncheresOuvertes"> <label
								class="form-check-label" for="chkEncheresOuvertes">Enchères
								ouvertes</label> <input type="checkbox" class="form-check-input"
								id="chkEncheresEnCours"> <label class="form-check-label"
								for="chkEncheresEnCours">Mes enchères en cours</label> <input
								type="checkbox" class="form-check-input"
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
							<input type="checkbox" class="form-check-input"
								id="chkVentesEnCours"> <label class="form-check-label"
								for="chkVentesEnCours">Ventes en cours</label> <input
								type="checkbox" class="form-check-input"
								id="chkVentesNonDebutees"> <label
								class="form-check-label" for="chkVentesNonDebutees">Mes
								ventes non débutées</label> <input type="checkbox"
								class="form-check-input" id="chkVentesTerminees"> <label
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
				class="btn btn-primary btn-lg" onclick="filtrerRecherche()" />
		</div>
	</div>
</form>
<c:set var="articles" scope="session" value="${articles}" />
<c:set var="totalCount" scope="session" value="${articles.size()}" />
<c:set var="perPage" scope="session" value="3" />
<c:set var="pageStart" value="${param.start}" />
<c:if test="${empty pageStart or pageStart < 0}">
	<c:set var="pageStart" value="0" />
</c:if>
<c:if test="${totalCount < pageStart}">
	<c:set var="pageStart" value="${pageStart - 3}" />
</c:if>
<c:if test="${articles.size() > 0}">
	<div class="row d-flex justify-content-center m-2">
		<a href="?start=${pageStart - 3}" class="btn btn-primary btn-sm" onclick="test()"><<</a>
		<span class="btn btn-primary">${pageStart + 1}- ${pageStart + 3}
		</span> <a href="?start=${pageStart + 3}" class="btn btn-primary btn-sm" onclick="pageSuivante()">>></a>
	</div>
	<div class="row d-flex">
		<c:forEach var="article" items="${articles}" begin="${pageStart}"
			end="${pageStart + perPage - 1}">
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
</c:if>

<script>
	$(document).ready(function() {
		remplirSelectCategorieAccueil();
	});
	
	$( function() {
	    $( "#filtre" ).autocomplete({
	      source: 'autocomplete'
	    });
	  } );
</script>