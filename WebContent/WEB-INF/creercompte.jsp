<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/menu"></jsp:include>
<form>
	<h3>
		<p class="text-center">Profil</p>
	</h3>
	<div class="d-flex">
		<div class="col-6">
			<div class="form-group">
				<label for="pseudo">Pseudo:</label> <input type="text"
					class="form-control" name="pseudo">
			</div>
			<div class="form-group">
				<label for="prenom">Prénom:</label> <input type="text"
					class="form-control" name="prenom">
			</div>
			<div class="form-group">
				<label for="telephone">Telephone:</label> <input type="text"
					class="form-control" name="telephone">
			</div>
			<div class="form-group">
				<label for="codepostal">Code postal:</label> <input type="text"
					class="form-control" name="codepostal">
			</div>
			<div class="form-group">
				<label for="mdp">Mot de passe:</label> <input type="password"
					class="form-control" name="mdp">
			</div>
			<button type="button" class="btn btn-primary" onclick="sinscrire()">Envoyer</button>
			<button type="button" class="btn btn-primary" onclick="openTab(this)"
				name="accueil">Accueil</button>
		</div>
		<div class="col-6">
			<div class="form-group">
				<label for="nom">Nom:</label> <input type="text"
					class="form-control" name="nom">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="text"
					class="form-control" name="email">
			</div>
			<div class="form-group">
				<label for="rue">Rue:</label> <input type="text"
					class="form-control" name="rue">
			</div>
			<div class="form-group">
				<label for="ville">Ville:</label> <input type="text"
					class="form-control" name="ville">
			</div>
			<div class="form-group">
				<label for="mdp2">Confirmation:</label> <input type="password"
					class="form-control" name="mdp2">
			</div>
		</div>
	</div>
</form>
<div class="alert alert-danger" role="alert" id="errorInscription"></div>