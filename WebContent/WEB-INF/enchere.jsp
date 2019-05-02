<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java"
	import="java.util.*,java.lang.*, java.time.LocalDate, fr.eni.ecole.encheres.bo.Article, fr.eni.ecole.encheres.bo.Categorie , fr.eni.ecole.encheres.bo.Utilisateur"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row">
	<div class="col">
		<h2>
			<p class="text-center">Enchérir</p>
		</h2>
	</div>
</div>
<c:if test="${articleDetails != null }">
	<div class="row">
		<div class="col">
			<table class="table table-borderless">
				<thead>
					<tr colspan="3">
						<th>${articleDetails.getNomArticle()}</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Description</td>
						<td>${articleDetails.getDescriptionArticle()}</td>
					</tr>
					<tr>
						<td>Categorie</td>
						<td>${articleDetails.getCategorie().getLibelleCategorie()}</td>
					</tr>
					<tr>
						<td>Meilleur offre</td>
						<td>${articleDetails.getUtilisateurAchetant() == null ? 'Pas d\'acheteur en cours' : articleDetails.getPrixVenteArticle() + ' points ' + pararticleDetails.getUtilisateurAchetant().getNomUtilisateur()}</td>
					</tr>
					<tr>
						<td>Mis à prix</td>
						<td>${articleDetails.getPrixInitialArticle()} points</td>
					</tr>
					<tr>
						<td>Fin de l'enchere</td>
						<td>${articleDetails.getDateFinEncheresArticle()}</td>
					</tr>
					<tr>
						<td>Retrait</td>
						<td>${articleDetails.getUtilisateurVendant().getRueUtilisateur()}
							${articleDetails.getUtilisateurVendant().getVilleUtilisateur()}
							${articleDetails.getUtilisateurVendant().getCodePostalUtilisateur()}
						</td>
					</tr>
					<tr>
						<td>Vendeur</td>
						<td>
							${articleDetails.getUtilisateurVendant().getPrenomUtilisateur()}
							${articleDetails.getUtilisateurVendant().getNomUtilisateur()}</td>
					</tr>
					<c:if test="${!empty utilisateur }">
						<form action="ServletEncherir" method="post">
							<tr>
								<td>Ma proposition</td>
								<c:set scope="session" var="article" value="${ articleDetails }"></c:set>
								<td><input type="number" name="nouvelleenchere" /></td>
							</tr>
							<tr>
								<td colspan="2">
									<button type="submit" class="btn btn-primary">Enchérir</button>
								</td>
							</tr>
						</form>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
</c:if>