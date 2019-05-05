<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		<jsp:include page="/menu"></jsp:include>
<form name="formulaireProfil" action="ServletModifierProfil" method="post">
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
					class="form-control" name="prenom" id="prenom"
					value="<c:out value="${utilisateur.getPrenomUtilisateur()} "></c:out>"
					readonly>
			</div>
			<div class="form-group">
				<label for="telephone">Telephone:</label> <input type="telephone"
					class="form-control" name="telephone" id="telephone"
					value="<c:out value="${utilisateur.getTelephoneUtilisateur()} "></c:out>"
					readonly>
			</div>
			<div class="form-group">
				<label for="codepostal">Code postal:</label> <input
					type="codepostal" class="form-control" name="codepostal" id="codepostal"
					value="<c:out value="${utilisateur.getCodePostalUtilisateur()} "></c:out>"
					readonly>
			</div>
			<div class="form-group d-none">
				<label for="mdp">Mot de passe:</label> <input type="password"
					class="form-control" name="mdp" id="mdp"
					value="<c:out value="${utilisateur.getMotDePasseUtilisateur()} "></c:out>"
					readonly>
			</div>
			<input type="button" class="btn btn-primary" value="Modifier"
				onclick="debloquerProfil()" id="buttonModifier" />
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalSupprimerProfil" 
			name="supprimer">Supprimer</button>
			<button type="button" class="btn btn-primary" onclick="openTab(this)" name="accueil">Retour</button>
		</div>
		<div class="col-6">
			<div class="form-group">
				<label for="nom">Nom:</label> <input type="nom" class="form-control"
					name="nom" id="nom"
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
					name="rue" id="rue"
					value="<c:out value="${utilisateur.getRueUtilisateur()} "></c:out>"
					readonly>
			</div>
			<div class="form-group">
				<label for="ville">Ville:</label> <input type="ville"
					class="form-control" name="ville" id="ville"
					value="<c:out value="${utilisateur.getVilleUtilisateur()} "></c:out>"
					readonly>
			</div>
			<div class="form-group d-none">
				<label for="mdp2">Confirmation:</label> <input type="password"
					class="form-control" name="mdp2"
					value="<c:out value="${utilisateur.getMotDePasseUtilisateur()} "></c:out>"
					readonly>
			</div>
		</div>
	</div>
</form>

<div class="modal fade" id="modalVerif" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="modalLabel">Validation</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body"  id="modalMessage">
        Confirmez-vous ces changements?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
        <button type="button" class="btn btn-primary" onclick="sauvegarderProfil()">Sauvegarder</button>
      </div>
    </div>
  </div>
</div>

<script>
	function debloquerProfil(){
		$("input").removeAttr("readonly");
		$("div").removeClass("d-none");
		
		var boutonValider = document.createElement("button");
		boutonValider.type = "button";
		boutonValider.value = "modifier";
		boutonValider.name = "modifier";
		boutonValider.setAttribute("data-toggle","modal");
		boutonValider.setAttribute("data-target"," #modalVerif");
		boutonValider.className = "btn btn-primary";
		boutonValider.innerText = "Enregistrer";
		$("#buttonModifier").replaceWith(boutonValider);
	}
	
	function sauvegarderProfil(){
		$.ajax({
			url : 'ServletModifierProfil',
			method : 'POST',
			data : {
				prenom : $('#prenom').val(),
				nom : $('#nom').val(),
				telephone : $('#telephone').val(),
				mdp : $('#mdp').val(),
				rue : $('#rue').val(),
				ville : $('#ville').val(),
				codepostal : $('#codepostal').val(),
			},
			success : function(resultText) {
				$('#modalMessage').html(resultText);
			},
			error : function(jqXHR, exception) {
				console.log('Error occured!!');
			}
		});
	}
</script>