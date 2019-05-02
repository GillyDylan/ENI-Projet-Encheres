<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="ServletModifierProfil" method="post">
	<h3>
		<p class="text-center">Mon Profil</p>
	</h3>
	<div class="d-flex">
		<div class="col-6">
			<div class="form-group">
				<label for="pseudo">Pseudo:</label> <span class="form-control"
					readonly> <c:out
						value="${utilisateur.getPseudonymeUtilisateur()} "></c:out>
				</span>
			</div>
			<div class="form-group">
				<label for="prenom">Prénom:</label> <input type="prenom"
					class="form-control" name="prenom"
					value="<c:out value="${utilisateur.getPrenomUtilisateur()} "></c:out>"
					readonly>
			</div>
			<div class="form-group">
				<label for="telephone">Telephone:</label> <input type="telephone"
					class="form-control" name="telephone"
					value="<c:out value="${utilisateur.getTelephoneUtilisateur()} "></c:out>"
					readonly>
			</div>
			<div class="form-group">
				<label for="codepostal">Code postal:</label> <input
					type="codepostal" class="form-control" name="codepostal"
					value="<c:out value="${utilisateur.getCodePostalUtilisateur()} "></c:out>"
					readonly>
			</div>
			<div class="form-group d-none">
				<label for="mdp">Mot de passe:</label> <input type="password"
					class="form-control" name="mdp"
					value="<c:out value="${utilisateur.getMotDePasseUtilisateur()} "></c:out>"
					readonly>
			</div>
			<input type="button" class="btn btn-primary" value="Modifier"
				onclick="debloquerProfil()" id="buttonModifier" />
		</div>
		<div class="col-6">
			<div class="form-group">
				<label for="nom">Nom:</label> <input type="nom" class="form-control"
					name="nom"
					value="<c:out value="${utilisateur.getNomUtilisateur()} "></c:out>"
					readonly>
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <span class="form-control"
					readonly> <c:out
						value="${utilisateur.geteMailUtilisateur()} "></c:out>
				</span>
			</div>
			<div class="form-group">
				<label for="rue">Rue:</label> <input type="rue" class="form-control"
					name="rue"
					value="<c:out value="${utilisateur.getRueUtilisateur()} "></c:out>"
					readonly>
			</div>
			<div class="form-group">
				<label for="ville">Ville:</label> <input type="ville"
					class="form-control" name="ville"
					value="<c:out value="${utilisateur.getVilleUtilisateur()} "></c:out>"
					readonly>
			</div>
			<div class="form-group d-none">
				<label for="mdp2">Confirmation:</label> <input type="password"
					class="form-control" name="mdp2"
					value="<c:out value="${utilisateur.getMotDePasseUtilisateur()} "></c:out>"
					readonly>
			</div>
			<a href="?page=accueil" class="btn btn-primary" id="a_annuler">Annuler</a>
		</div>
	</div>
</form>

<form action="ServletSupprimerProfil" method="post">
	<button type="submit" class="btn btn-primary" name="supprimer">Supprimer</button>
</form>


<script>
	function debloquerProfil(){
		$("input").removeAttr("readonly");
		$("div").removeClass("d-none");
		
		var buttonSubmit = document.createElement("button");
		buttonSubmit.type = "submit";
		buttonSubmit.value = "modifier";
		buttonSubmit.name = "modifier";
		buttonSubmit.className = "btn btn-primary";
		buttonSubmit.innerText = "Enregistrer";
		$("#buttonModifier").replaceWith(buttonSubmit);
	}
</script>