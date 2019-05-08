<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java"
	import="java.util.*,java.lang.*, java.time.LocalDate, 
	fr.eni.ecole.encheres.bo.Article, fr.eni.ecole.encheres.bo.Categorie , 
	fr.eni.ecole.encheres.bo.Utilisateur, fr.eni.ecole.encheres.bo.Enchere"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/menu"></jsp:include>
<div class="row">
	<div class="col">
		<h2>
			<p class="text-center">Enchérir</p>
		</h2>
	</div>
</div>
<c:if test="${articleDetails != null }">
	<div class="row">
		<div class="col-8">
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
						<td>${enchereMax.getUtilisateur().getNomUtilisateur() == null ? 'Pas d acheteur en cours' : 
								enchereMax.getUtilisateur().getNomUtilisateur()}
							<c:if test="${!empty enchereMax.getUtilisateur() }">
								<span>pour la somme de ${enchereMax.getMontantEnchere() }
									points.</span>
							</c:if>
						</td>
					</tr>
					<td>Mise à prix</td>
					<td>${articleDetails.getPrixInitialArticle()} points</td>
					</tr>
					<tr>
						<td>Fin de l'enchere</td>
						<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
						<fmt:formatDate var="date"
							value="${articleDetails.getDateFinEncheresArticle()}"
							pattern="dd MMM YYYY" />
						<fmt:formatDate var="time"
							value="${articleDetails.getDateFinEncheresArticle()}"
							pattern="HH:mm" />
						<td>${date} à ${time}</td>
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
						<form>
							<tr>
								<td>Ma proposition</td>
								<c:set scope="session" var="article" value="${ articleDetails }"></c:set>
								<td><input type="number"
									value="${enchereMax == null ? articleDetails.getPrixInitialArticle() : enchereMax.getMontantEnchere()+1}"
									min="${enchereMax.getMontantEnchere()+1}"
									id="nouvelleEnchere" /></td>
							</tr>
							<tr>
								<td colspan="2"><c:if
										test="${!articleDetails.getUtilisateurVendant().equals(utilisateur)}">
										<button type="button" class="btn btn-primary"
											data-toggle="modal" data-target="#modalValidationEnchere">Enchérir</button>
									</c:if> <c:if
										test="${articleDetails.getUtilisateurVendant().equals(utilisateur)}">
										<button type="button" class="btn btn-primary"
											data-toggle="modal" data-target="#modalSuppressionEnchere">Supprimer
											cette vente</button>
									</c:if></td>
							</tr>
						</form>

						<div class="modal fade" id="modalValidationEnchere" tabindex="-1"
							role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="modalLabel">Nouvelle enchère</h5>
										<button type="button" class="close" data-dismiss="modal"
											onclick="getDetails(${articleDetails.getIdArticle()})" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body" id="modalMessage">Etes-vous sûr
										de valider cette enchère?</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											id="butAnnuler" id="butAnnulerEnchere" data-dismiss="modal">Annuler</button>
										<button type="button" class="btn btn-primary"
											id="butSauvegarder" id="butSauvegarderEnchere"
											onclick="encherir()">Sauvegarder</button>
									</div>
								</div>
							</div>
						</div>
						<div class="modal fade" id="modalSuppressionEnchere" tabindex="-1"
							role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="modalLabel">Supprimer enchère</h5>
										<button type="button" class="close" data-dismiss="modal"
											onclick="retourAccueil()" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body" id="modalMessage">Etes-vous sûr
										de vouloir supprimer cette enchère?</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											id="butAnnuler" data-dismiss="modal">Annuler</button>
										<button type="button" class="btn btn-primary"
											id="butSauvegarder" onclick="supprimerEnchere()">Supprimer</button>
									</div>
								</div>
							</div>
						</div>
					</c:if>
				</tbody>
			</table>
		</div>
		<div class="col-4">
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Acheteur</th>
						<th scope="col">Enchère</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="enchere" items="${listEncheres}">
						<tr>
							<td>${ enchere.getUtilisateur().getNomUtilisateur() }</td>
							<td>${ enchere.getMontantEnchere() }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</c:if>