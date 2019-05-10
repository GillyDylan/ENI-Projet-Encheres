<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav
	class="navbar navbar-expand-lg navbar-dark bg-primary navbar-expand-md">
	<img src="img/osselait.png" style="height: 100px;" /> <a
		class="navbar-brand" href="#"> Enchères et en Os </a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto ">
			<li class="nav-item"><a class="nav-link" href="#"
				onclick="openTab(this)" name="accueil">Accueil <span
					class="sr-only">(current)</span></a></li>
			<c:if test="${ utilisateur == null }">
				<li class="nav-item"><a class="nav-link" href="#"
					onclick="openTab(this)" name="inscription">S'inscrire</a></li>
				<li class="nav-item"><a class="nav-link" href="#"
					onclick="openTab(this)" name="connexion">Se connecter</a></li>
			</c:if>
			<c:if test="${ utilisateur != null }">
				<li class="nav-item"><a class="nav-link"
					onclick="openTab(this)" href="#" name="nouvellevente">Vendre un
						produit</a></li>
				<li class="nav-item"><a class="nav-link"
					onclick="openTab(this)" href="#" name="profil">Profil</a></li>
				<li class="nav-item"><a class="nav-link"
					onclick="openTab(this)" href="#" name="deconnexion">Deconnexion</a>
				</li>
			</c:if>
			<c:if test="${ utilisateur.isAdministrateur() == true }">
				<li class="nav-item"><a class="nav-link"
					onclick="openTab(this)" href="#" name="administration">Administration</a>
				</li>
			</c:if>
		</ul>
	</div>
</nav>