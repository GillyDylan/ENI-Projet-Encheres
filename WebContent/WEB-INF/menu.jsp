<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class="nav">
	<li class="nav-item"><a class="nav-link" href="?page=accueil">Accueil</a></li>
	<c:if test="${ utilisateur == null }">
		<li class="nav-item"><a class="nav-link" href="index?page=creercompte">S'inscrire</a></li>
		<li class="nav-item"><a class="nav-link" href="index?page=connexion">Se connecter</a></li>
	</c:if>
	<c:if test="${ utilisateur != null }">
		<li class="nav-item"><a class="nav-link" href="#">Enchere</a></li>
		<li class="nav-item"><a class="nav-link" href="#">Vendre un produit</a></li>
		<li class="nav-item"><a class="nav-link" href="#">Profil</a></li>
		<li class="nav-item"><a class="nav-link" href="ServletDeconnexion">Deconnexion</a></li>
	</c:if>
</ul>