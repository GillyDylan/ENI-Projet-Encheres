<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java"
	import="java.util.*,java.lang.*, java.time.LocalDate, fr.eni.ecole.encheres.bo.Article, fr.eni.ecole.encheres.bo.Utilisateur"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row">
	<div class="col">
		<h2>
			<p class="text-center">Liste des enchères</p>
		</h2>
	</div>
</div>
<div class="row">
	<div class="col-6">
		<div class="form-group">
			<label for="filtre">Filtre: </label> <input type="text"
				class="form-control" id="filtre"
				placeholder="Le nom de l'article contient">
		</div>
		<div class="form-group">
			<label for="selectCategorie">Catégories</label> <select
				id="selectCategorie" class="form-control">
				<option value="">Informatique</option>
				<option value="">Ameublement</option>
				<option value="">Vetement</option>
				<option value="">Sport & Loisir</option>
			</select>
		</div>
		<c:if test="${ utilisateur != null }">
			<div class="form-check form-check-inline">
				<input type="radio" class="form-check-input" id="chkboxAchats"
					name="chkboxAchats"> <label class="form-check-label"
					for="chkboxAchats">Achats</label>
			</div>
			<div class="form-check form-check-inline">
				<input type="radio" class="form-check-input" id="chkboxVentes"
					name="chkboxVentes"> <label class="form-check-label"
					for="chkboxVentes">Ventes</label>
			</div>
		</c:if>
	</div>
	<div class="col-6 text-center d-flex align-items-center justify-content-center ">
		<input type="button" value="Rechercher" class="btn btn-primary btn-lg" />
	</div>
</div>
<div class="row">
	<c:forEach var="article" items="${articles}">
		<div class="col-6 d-flex p-5">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">${article.getNomArticle()}</h4>
					<p class="card-text">Prix : ${article.getPrixInitialArticle() }
						points</p>
					<p class="card-text">Fin de l'enchere :
						${article.getDateDebutEncheresArticle() }</p>
					<p class="card-text">Vendeur :</p>
					<p class="card-text">${article.getUtilisateurVendant().getPrenomUtilisateur()}
						${article.getUtilisateurVendant().getNomUtilisateur()}</p>
					<a href="#" class="btn btn-primary">Détails</a>
				</div>
			</div>
		</div>
	</c:forEach>
</div>