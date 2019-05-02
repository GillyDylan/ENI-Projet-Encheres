<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col">
		<h2>
			<p class="text-center">Nouvelle vente</p>
		</h2>
	</div>
</div>
<form action="ServletNouvelleVente" method="post">
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
		<label for="selectCategorie" class="col-sm-2 col-form-label">Cat�gories</label> 
			<select name="selectCategorie" class="form-control col-sm-10">
				<c:if test="${!empty categories}">
					<c:forEach var="categorie" items="${categories}">
						<option value="${ categorie.getIdCategorie()  }">${ categorie.getLibelleCategorie() }</option>
					</c:forEach>
				</c:if>
			</select>
	</div>
	<div class="form-group row">
		<label for="photo" class="col-sm-2 col-form-label">Photo de
			l'article:</label> <input type="file" class="form-control col-sm-10"
			id="photo" name="photo">
	</div>
	<div class="form-group row">
		<label for="prix" class="col-sm-2 col-form-label">Mise � prix:</label>
		<input type="text" class="form-control col-sm-10" id="prix"
			placeholder="Prix de d�part" name="prix" required>
	</div>
	<div class="form-group row">
		<label for="debutenchere" class="col-sm-2 col-form-label">D�but
			de l'ench�re:</label> <input type="date" class="form-control col-sm-10"
			id="debutenchere" name="debutenchere" required>
	</div>
	<div class="form-group row">
		<label for="finenchere" class="col-sm-2 col-form-label">Fin de
			l'ench�re:</label> <input type="date" class="form-control col-sm-10"
			id="finenchere" name="finenchere" required>
	</div>
	<fieldset class="form-group">
		<legend>Retrait</legend>
		<div class="form-group row">
			<label for="rue" class="col-sm-2 col-form-label">Rue:</label> <input
				type="text" class="form-control col-sm-10" id="rue" name="rue"
				value="<c:out value="${ utilisateur.getRueUtilisateur() }"></c:out>" readonly>
		</div>
		<div class="form-group row">
			<label for="ville" class="col-sm-2 col-form-label">Ville:</label> <input
				type="text" class="form-control col-sm-10" id="ville" name="ville"
				value="<c:out value="${ utilisateur.getVilleUtilisateur() }"></c:out>" readonly>
		</div>
		<div class="form-group row">
			<label for="cp" class="col-sm-2 col-form-label">Code postal:</label>
			<input type="text" class="form-control col-sm-10" id="cp" name="cp" 
			value="<c:out value="${ utilisateur.getCodePostalUtilisateur() }"></c:out>" readonly>
		</div>
	</fieldset>
	<button type="submit" class="btn btn-primary">Enregistrer</button>
</form>