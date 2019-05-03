<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class="nav">
	<li class="nav-item">
		<a class="nav-link" href="#" onclick="openTab(this)" name="accueil">Accueil</a>
	</li>
	<c:if test="${ utilisateur == null }">
		<li class="nav-item">
			<a class="nav-link" href="#" onclick="openTab(this)" name="inscription">S'inscrire</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="#" onclick="openTab(this)" name="connexion">Se connecter</a>
		</li>
	</c:if>
	<c:if test="${ utilisateur != null }">
		<li class="nav-item">
			<a class="nav-link" href="#" onclick="openTab(this)" name="nouvellevente">Vendre un produit</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="#" onclick="openTab(this)" name="profil">Profil</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="#" onclick="openTab(this)" name="deconnexion">Deconnexion</a>
		</li>
	</c:if>
</ul> 