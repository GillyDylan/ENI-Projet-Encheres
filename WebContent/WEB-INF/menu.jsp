<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class="nav">
	<li class="nav-item">
		<button type="button" class="btn nav-link" onclick="openTab(this)" name="accueil">Accueil</button>
	</li>
	<c:if test="${ utilisateur == null }">
		<li class="nav-item">
			<button type="button" class="btn nav-link" onclick="openTab(this)" name="inscription">S'inscrire</button>
		</li>
		<li class="nav-item">
			<button type="button" class="btn nav-link"  onclick="openTab(this)" name="connexion">Se connecter</button>
		</li>
	</c:if>
	<c:if test="${ utilisateur != null }">
		<li class="nav-item">
			<button type="button" class="btn nav-link" onclick="openTab(this)" name="nouvellevente">Vendre un produit</button>
		</li>
		<li class="nav-item">
			<button type="button" class="btn nav-link" onclick="openTab(this)" name="profil">Profil</button>
		</li>
		<li class="nav-item">
			<button type="button" class="btn nav-link" onclick="openTab(this)" name="deconnexion">Deconnexion</button>
		</li>
	</c:if>
	<c:if test="${ utilisateur.isAdministrateur() == true }">
		<li class="nav-item">
			<button type="button" class="btn nav-link" onclick="openTab(this)" name="administration">Administration</button>
		</li>
	</c:if>
</ul> 