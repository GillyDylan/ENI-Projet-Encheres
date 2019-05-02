<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java"
	import="java.util.*,java.lang.*, java.time.LocalDate, fr.eni.ecole.encheres.bo.Article, fr.eni.ecole.encheres.bo.Utilisateur"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row">
	<div class="col">
		<h2>
			<p class="text-center">Enchérir</p>
		</h2>
	</div>
</div>
test
<c:if test="${articleDetails != null }">
	<div class="row">
		<div class="col">
			<table class="table table-borderless">
				<thead>
					<tr colspan="3">
						<th>PC Gamer pour travailler</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Description</td>
						<td>Lorem Ipsum</td>
					</tr>
					<tr>
						<td>Categorie</td>
						<td>Informatique</td>
					</tr>
					<tr>
						<td>Meilleur offre</td>
						<td>210 points par Bob</td>
					</tr>
					<tr>
						<td>Mis à prix</td>
						<td>195 points</td>
					</tr>
					<tr>
						<td>Fin de l'enchere</td>
						<td>09/10/2018</td>
					</tr>
					<tr>
						<td>Retrait</td>
						<td>10 allée des Allouettes - 44800 Saint Herblain</td>
					</tr>
					<tr>
						<td>Vendeur</td>
						<td>jojo44</td>
					</tr>
					<tr>
						<td>Ma proposition</td>
						<td><select>
								<option>100</option>
								<option>200</option>
						</select></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</c:if>