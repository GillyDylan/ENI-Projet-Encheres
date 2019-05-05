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
	console.log($( '#formNouvelleVente' ).serializeArray());
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
			console.log('Ajout de données ok');
			$('#content').html(resultText);
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