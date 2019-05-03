<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/menu"></jsp:include>
<form>
	<div class="form-group">
		<label for="login">Identifiant</label> <input type="login"
			class="form-control" id="login">
		<c:if test="${!empty erreurConnexion}">
			<c:out value="${erreurConnexion}"></c:out>
		</c:if>
	</div>
	<div class="form-group">
		<label for="mdp">Mot de passe:</label> <input type="password"
			class="form-control" id="mdp">
	</div>
	<div class="form-group form-check">
		<label class="form-check-label"> <input
			class="form-check-input" type="checkbox"> Se souvenir de moi
		</label>
	</div>
	<input type="button" class="btn btn-primary" onclick="connexion()" value="Se connecter" />
</form>