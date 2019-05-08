<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="/menu"></jsp:include>
<h3>Envoyez mon mot de passe par email:</h3>
<form>
	<div class="form-group">
		<label for="adressemail">Pseudonyme : </label> <input
			class="form-control" type="text" id="pseudopourmdp"
			placeholder="Saississez votre adresse pseudonyme." />
	</div>
	<button type="button" onclick="envoieMailMDP()" class="btn btn-primary">Envoyer</button>
</form>
<div class="alert alert-dismissible fade show"
	role="alert" id="messageMDP">
</div>