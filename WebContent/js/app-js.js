function openTab(el) {
	var name = el.name;
	$.ajax({
		url : 'ServletOpenTab',
		contentType: "application/x-www-form-urlencoded;charset=utf-8",
		method : 'POST',
		data : {
			name : name
		},
		success : function(resultText) {
			$('#content').html(resultText);
		},
		error : function(jqXHR, exception) {
			console.log('Error occured!!');
		}
	});
}

function connexion() {
	$.ajax({
		url : 'ServletConnexion',
		method : 'POST',
		data : {
			login : $('#login').val(),
			mdp : $('#mdp').val()
		},
		success : function(resultText) {
			$('#content').html(resultText);
		},
		error : function(jqXHR, exception) {
			console.log('Error occured!!');
		}
	});
}

function ajouterNouvelleVente(){
	$.ajax({
		url : 'nouvellevente',
		method : 'POST',
		data : {
			article : $('#article').val(),
			description : $('#description').val(),
			selectCategorie : $('#selectCategorieVente').val(),
			prix : $('#prix').val(),
			debutenchere : $('#debutenchere').val(),
			finenchere : $('#finenchere').val()
		},
		success : function(resultText) {
			$('#modalMessage').html(resultText);
			$('#butAnnuler').toggle(false);
			$('#butSauvegarder').toggle(false);
		},
		error : function(jqXHR, exception) {
			console.log('Error occured!!');
		}
	});
}

function retourAccueil(){
	$.ajax({
		url : 'ServletOpenTab',
		contentType: "application/x-www-form-urlencoded;charset=utf-8",
		method : 'POST',
		data : {
			name : "accueil"
		},
		success : function(resultText) {
			$('#content').html(resultText);
			$('#butAnnuler').toggle(true);
			$('#butSauvegarder').toggle(true);
		},
		error : function(jqXHR, exception) {
			console.log('Error occured!!');
		}
	});
	
}

function getDetails(id){
	$.ajax({
		url : 'details',
		method : 'GET',
		data : {
			articleId : id
		},
		success : function(resultText) {
			$('#content').html(resultText);
		},
		error : function(jqXHR, exception) {
			console.log('Error occured!!');
		}
	});
}

function encherir(){
	$.ajax({
		url : 'encherir',
		method : 'POST',
		data : {
			nouvelleEnchere : $('#nouvelleEnchere').val()
		},
		success : function(resultText) {
			$('#modalMessage').html(resultText);
			$('#butAnnuler').toggle(false);
			$('#butSauvegarder').toggle(false);
		},
		error : function(jqXHR, exception) {
			console.log('Error occured!!');
		}
	});
}

function sinscrire(){
	$.ajax({
		url : 'inscription',
		method : 'POST',
		data : {
			pseudo : $("input[name='pseudo']").val(),
			prenom : $("input[name='prenom']").val(),
			telephone : $("input[name='telephone']").val(),
			codepostal : $("input[name='codepostal']").val(),
			mdp : $("input[name='mdp']").val(),
			nom : $("input[name='nom']").val(),
			ville : $("input[name='ville']").val(),
			rue : $("input[name='rue']").val(),
			email : $("input[name='email']").val()
		},
		success : function(resultText) {
			$('#content').html(resultText);
		},
		error : function(jqXHR) {
			//$('#errorInscription').toggle(true);
			$('#errorInscription').html(jqXHR.responseText);
		}
	});
}

function modifierProfil(){
	$.ajax({
		url : 'modifierProfil',
		method : 'POST',
		data : {
			prenom : $("input[name='prenom']").val(),
			telephone : $("input[name='telephone']").val(),
			codepostal : $("input[name='codepostal']").val(),
			mdp : $("input[name='mdp']").val(),
			nom : $("input[name='nom']").val(),
			ville : $("input[name='ville']").val(),
			rue : $("input[name='rue']").val(),
		},
		success : function(resultText) {
			$('#modalMessage').html(resultText);
			$('#butAnnuler').toggle(false);
			$('#butSauvegarder').toggle(false);
		},
		error : function(jqXHR, exception) {
			
		}
	});
}

function supprimerProfil(){
	$.ajax({
		url : 'supprimerProfil',
		method : 'POST',
		success : function(resultText) {
		},
		error : function(jqXHR, exception) {
			console.log('Error occured!!');
		}
	});
}

function supprimerEnchere(){
	$.ajax({
		url : 'supprimerEnchere',
		method : 'POST',
		success : function(resultText) {
			$('#modalMessage').html(resultText);
			$('#butAnnuler').toggle(false);
			$('#butSauvegarder').toggle(false);
		},
		error : function(jqXHR, exception) {
			console.log('Error occured!!');
		}
	});
}

function filtrerRecherche(){
	if($("input[name='chkboxEnchere']:checked").val() == "achat"){
		$('#chkEncheresOuvertes').prop( "disabled", false );
		$('#chkEncheresEnCours').prop( "disabled", false );
		$('#chkEncheresRemportees').prop( "disabled", false );
		$('#chkVentesEnCours').prop( "disabled", true );
		$('#chkVentesNonDebutees').prop( "disabled", true );
		$('#chkVentesTerminees').prop( "disabled", true );
		$('#chkVentesEnCours').prop( "checked", false );
		$('#chkVentesNonDebutees').prop( "checked", false );
		$('#chkVentesTerminees').prop( "checked", false );
	}else{
		$('#chkEncheresOuvertes').prop( "disabled", true );
		$('#chkEncheresEnCours').prop( "disabled", true );
		$('#chkEncheresRemportees').prop( "disabled", true );
		$('#chkEncheresOuvertes').prop( "checked", false );
		$('#chkEncheresEnCours').prop( "checked", false );
		$('#chkEncheresRemportees').prop( "checked", false );
		$('#chkVentesEnCours').prop( "disabled", false );
		$('#chkVentesNonDebutees').prop( "disabled", false );
		$('#chkVentesTerminees').prop( "disabled", false );
	}
}

$(document).ready(function() {
	filtrerRecherche();
});

function remplirSelectCategorieVente(){
	$.ajax({
		url : 'ServletSelectCategorie',
		method : 'GET',
		success : function(resultText) {
			var selectVente = $('#selectCategorieVente');
			options = selectVente.prop('options');
			$('option', selectVente).remove();
			$.each(resultText, function(val, text) {
				options[options.length] = new Option(text.libelleCategorie, text.idCategorie);
			});
		},
		error : function(jqXHR, exception) {
			console.log('Error occured!!');
		}
	});
}


function remplirSelectCategorieAccueil(){
	$.ajax({
		url : 'ServletSelectCategorie',
		method : 'GET',
		success : function(resultText) {
			var selectAccueil = $('#selectCategorieAccueil');
			options = selectAccueil.prop('options');
			$('option', selectAccueil).remove();
			$('#selectCategorieAccueil').append(new Option('Toutes les catégories', 0, true, true));
			$.each(resultText, function(val, text) {
				options[options.length] = new Option(text.libelleCategorie, text.idCategorie);
			});
		},
		error : function(jqXHR, exception) {
			console.log('Error occured!!');
		}
	});
}

function sesouvenir(){
	$.ajax({
		url : 'sesouvenir',
		method : 'POST',
		data : {
			login : $('#login').val(),
			mdp : $('#mdp').val()
		},
		success : function(resultText) {
			console.log("cookies crées");
		},
		error : function(jqXHR, exception) {
			console.log('Error occured!!');
		}
	});
}