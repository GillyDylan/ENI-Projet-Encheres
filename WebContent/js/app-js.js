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

function remplirSelectCategorie(){
	$.ajax({
		url : 'ServletSelectCategorie',
		method : 'GET',
		success : function(resultText) {
			var select = $('#selectCategorie'),
			options = select.prop('options');
			$('option', select).remove();
			$.each(resultText, function(val, text) {
				options[options.length] = new Option(text.libelleCategorie, text.idCategorie);
			});
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
			selectCategorie : $('#selectCategorie').val(),
			prix : $('#prix').val(),
			debutenchere : $('#debutenchere').val(),
			finenchere : $('#finenchere').val()
		},
		success : function(resultText) {
			$('#modalMessage').html(resultText);
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
			$('#butAnnulerEnchere').prop("hidden", "true");
			$('#butSauvegarderEnchere').prop('hidden', 'true');	
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
			ville : $("input[name='ville']").val()
		},
		success : function(resultText) {
			$('#content').html(resultText);
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

function filtrerRecherche(){
	console.log($('#selectCategorie').val())
	console.log($('#chkEncheresOuvertes').prop('checked'))
	console.log($('#chkEncheresEnCours').prop('checked'))
	console.log($('#chkEncheresRemportees').prop('checked'))
	console.log($('#chkVentesEnCours').prop('checked'))
	console.log($('#chkVentesNonDebutees').prop('checked'))
	console.log($('#chkVentesTerminees').prop('checked'))
}