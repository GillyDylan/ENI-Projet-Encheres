<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java"
	import="java.util.*,java.lang.*, java.time.LocalDate, fr.eni.ecole.encheres.bo.Article, fr.eni.ecole.encheres.bo.Categorie, fr.eni.ecole.encheres.bo.Utilisateur"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/menu"></jsp:include>
<div class="row">
	<div class="col">
		<h2>
			<p class="text-center">Nouvelle vente</p>
		</h2>
	</div>
</div>
<form id="formNouvelleVente" enctype="multipart/form-data">
	<div class="form-group row">
		<label for="article" class="col-sm-2 col-form-label">Article:</label>
		<input type="text" class="form-control col-sm-10" id="article"
			placeholder="Nom de l'article" name="article" required>
	</div>
	<div class="form-group row">
		<label for="description" class="col-sm-2 col-form-label">Description:</label>
		<input type="text" class="form-control col-sm-10" id="description"
			placeholder="Description du produit" name="description" required>
	</div>
	<div class="form-group row">
		<label for="selectCategorieVente" class="col-sm-2 col-form-label">Catégories</label>
		<select name="selectCategorieVente" class="form-control col-sm-10"
			id="selectCategorieVente">
			<c:if test="${!empty categories}">
				<c:forEach var="categorie" items="${categories}">
					<option value="${ categorie.getIdCategorie()  }">${ categorie.getLibelleCategorie() }</option>
				</c:forEach>
			</c:if>
		</select>
	</div>
	<div class="form-group row">
		<label for="photo" class="col-sm-2 col-form-label">Photo de
			l'article:</label> <input type="file"
			class="form-control-file border col-sm-10" id="photo" name="photo">
	</div>
	<div class="form-group row">
		<label for="prix" class="col-sm-2 col-form-label">Mise à prix:</label>
		<input type="number" class="form-control col-sm-10" id="prix"
			placeholder="Prix de départ" name="prix" value="0" required>
	</div>
	<div class="form-group row">
		<jsp:useBean id="now" class="java.util.Date" />
		<fmt:formatDate var="datedeb" value="${now}" pattern="yyyy-MM-dd" />
		<fmt:formatDate var="timedeb" value="${now}" pattern="HH:mm" />
		<label for="debutenchere" class="col-sm-2 col-form-label">Début
			de l'enchère:</label> <input type="date" class="form-control col-sm-5"
			id="debutencheredate" name="debutencheredate" value="${datedeb}"
			min="${datedeb}" required>
			<input type="time" class="form-control col-sm-5"
			id="debutencheretime" name="debutencheretime" value="${timedeb}"
			min="${timedeb}" required>
	</div>
	<div class="form-group row">
		<jsp:setProperty name="now" property="time" value="${now.time + (24*60*60*1000)}"/>
		<fmt:formatDate var="datedfin" value="${now}" pattern="yyyy-MM-dd" />
		<fmt:formatDate var="timefin" value="${now}" pattern="HH:mm" />
		<label for="finenchere" class="col-sm-2 col-form-label">Fin de
			l'enchère:</label> <input type="date" class="form-control col-sm-5"
			id="finencheredate" name="finencheredate" value="${datedfin}" min="${datedfin}" required>
			<input type="time" class="form-control col-sm-5"
			id="finencheretime" name="finencheretime"value="${timefin}" min="${timefin}" required>
	</div>
	<fieldset class="form-group">
		<legend>Retrait</legend>
		<div class="form-group row">
			<label for="rue" class="col-sm-2 col-form-label">Rue:</label> <input
				type="text" class="form-control col-sm-10" id="rue" name="rue"
				value="<c:out value="${ utilisateur.getRueUtilisateur() }"></c:out>"
				readonly>
		</div>
		<div class="form-group row">
			<label for="ville" class="col-sm-2 col-form-label">Ville:</label> <input
				type="text" class="form-control col-sm-10" id="ville" name="ville"
				value="<c:out value="${ utilisateur.getVilleUtilisateur() }"></c:out>"
				readonly>
		</div>
		<div class="form-group row">
			<label for="cp" class="col-sm-2 col-form-label">Code postal:</label>
			<input type="text" class="form-control col-sm-10" id="cp" name="cp"
				value="<c:out value="${ utilisateur.getCodePostalUtilisateur() }"></c:out>"
				readonly>
		</div>
	</fieldset>
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#modalValidationVente">Enregistrer</button>
	<button type="button" class="btn btn-primary" onclick="openTab(this)"
		name="accueil">Retour</button>
</form>

<div class="modal fade" id="modalValidationVente" tabindex="-1"
	role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="modalLabel">Nouvelle vente</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close" onclick="reloadModal()">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body" id="modalMessage">Etes-vous sûr de
				valider cette vente?</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" id="butAnnuler"
					data-dismiss="modal">Annuler</button>
				<button type="button" class="btn btn-primary" id="butSauvegarder"
					onclick="ajouterNouvelleVente()">Sauvegarder</button>
			</div>
		</div>
	</div>
</div>

<script>
	$(document).ready(function() {
		remplirSelectCategorieVente();
	});
</script>