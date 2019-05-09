<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="/menu"></jsp:include>
<nav>
	<div class="nav nav-tabs" id="nav-tab" role="tablist">
		<a class="nav-item nav-link active" id="nav-home-tab"
			data-toggle="tab" href="#nav-article" role="tab"
			aria-controls="nav-home" aria-selected="true">Article</a> <a
			class="nav-item nav-link" id="nav-utilisateur-tab" data-toggle="tab"
			href="#nav-utilisateur" role="tab" aria-controls="nav-profile"
			aria-selected="false">Utilisateur</a> <a class="nav-item nav-link"
			id="nav-contact-tab" data-toggle="tab" href="#nav-categorie"
			role="tab" aria-controls="nav-contact" aria-selected="false">Categorie</a>
	</div>
</nav>

<div class="tab-content" id="nav-tabContent">
	<div class="tab-pane fade show active" id="nav-article" role="tabpanel"
		aria-labelledby="nav-home-tab">...</div>
	<div class="tab-pane fade" id="nav-utilisateur" role="tabpanel"
		aria-labelledby="nav-utilisateur-tab">
		<div class="form-group row m-2">
			<label for="selectAdministrationUtilisateur"
				class="col-sm-3 col-form-label">Gestion des utilisateurs :</label>
			<div class="col-sm-5">
				<select id="selectAdministrationUtilisateur" class="form-control">
				</select>
			</div>
			<div class="col-sm-4">
				<button type="button" class="btn btn-primary" name="rendreInactif"
					onclick="administration(this)">Rendre inactif</button>
				<button type="button" class="btn btn-primary"
					name="SupprimerUtilisateur" onclick="administration(this)">Supprimer
					utilisateur</button>
			</div>
		</div>
		<div class="alert alert-danger" role="alert"
			id="messageAdministrationUtilisateur" hidden="true"></div>
	</div>
	<div class="tab-pane fade m-3" id="nav-categorie" role="tabpanel"
		aria-labelledby="nav-contact-tab">
		<div class="row">
			<div class="col">
				<span>Ajouter une catégorie : </span>
			</div>
			<div class="col">
				<input type="text" name="nouvelleCategorie"
					placeholder="Insérer le nom de la catégorie" />
			</div>
			<div class="col">
				<button type="button" class="btn" name="ajouterCategorie"
					onclick="administration(this)">Ajouter</button>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<span>Supprimer une catégorie : </span>
			</div>
			<div class="col">
				<input type="text" placeholder="Insérer le nom de la catégorie" />
			</div>
			<div class="col">
				<button type="button" class="btn">Supprimer</button>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<span>Modifier une catégorie : </span>
			</div>
			<div class="col">
				<input type="text" placeholder="Insérer le nom de la catégorie" />
			</div>
			<div class="col">
				<button type="button" class="btn">Modifier</button>
			</div>
		</div>
	</div>
</div>
<script>
		$(document).ready(function() {
			selectAdministrationUtilisateur();
		});
	</script>