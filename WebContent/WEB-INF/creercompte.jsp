<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/menu"></jsp:include>
<c:if test="${!empty errorMessage }">
	<span class="alert alert-danger">${errorMessage }</span>
</c:if>
<form action="ServletInscription" method="post">
	<h3>
		<p class="text-center">Profil</p>
	</h3>
	<div class="d-flex">
		<div class="col-6">
			<div class="form-group">
				<label for="pseudo">Pseudo:</label> <input type="pseudo"
					class="form-control" name="pseudo">
			</div>
			<div class="form-group">
				<label for="prenom">Prénom:</label> <input type="prenom"
					class="form-control" name="prenom">
			</div>
			<div class="form-group">
				<label for="telephone">Telephone:</label> <input type="telephone"
					class="form-control" name="telephone">
			</div>
			<div class="form-group">
				<label for="codepostal">Code postal:</label> <input
					type="codepostal" class="form-control" name="codepostal">
			</div>
			<div class="form-group">
				<label for="mdp">Mot de passe:</label> <input type="mdp"
					class="form-control" name="mdp">
			</div>
			<button type="submit" class="btn btn-primary">Envoyer</button>
		</div>
		<div class="col-6">
			<div class="form-group">
				<label for="nom">Nom:</label> <input type="nom" class="form-control"
					name="nom">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" name="email">
			</div>
			<div class="form-group">
				<label for="rue">Rue:</label> <input type="rue" class="form-control"
					name="rue">
			</div>
			<div class="form-group">
				<label for="ville">Ville:</label> <input type="ville"
					class="form-control" name="ville">
			</div>
			<div class="form-group">
				<label for="mdp2">Confirmation:</label> <input type="mdp2"
					class="form-control" name="mdp2">
			</div>
			<a href="?page=accueil" class="btn btn-primary">Annuler</a>
		</div>
	</div>
</form>