<%@ page language="java" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Ajout d'un collaborateur</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/nouveau.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
	integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
	integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/nouveau.js"></script>
<script>
  function valider(){
	  document.forms[0].action="<%=request.getContextPath()%>/collaborateurs/nouveau";
		document.forms[0].method = "POST";
		document.forms[0].submit();
	}
</script>

</head>
<body class="container-fluid">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<img
					src="https://assets.chooseyourboss.com/companies/logos/000/004/322/square/Logo_DTA.jpg?1457453234"
					alt="logo" height="42" width="42"> <a
					class="nav-item nav-link active"
					href="<%=request.getContextPath()%>/collaborateurs/lister">Collaborateurs<span
					class="sr-only">(current)</span></a> <a class="nav-item nav-link"
					href="<%=request.getContextPath()%>/statistique">Statistique</a> <a
					class="nav-item nav-link"
					href="<%=request.getContextPath()%>/activites">Activités</a>
			</div>
		</div>
	</nav>
	<div class="row offset-1">
		<h1>Nouveau Collaborateur</h1>
	</div>
	<form class="offset-2" method="POST"
		action="<%=request.getContextPath()%>/collaborateurs/nouveau">
		<div class="form-group row">
			<label for="nom" class="col-3 col-form-label">Nom</label>
			<div class="col-6">
				<input type="text" class="form-control" id="nom" name="nom" />
				<div class="invalid-feedback">Veuillez rentrer un nom.</div>
			</div>
		</div>
		<div class="form-group row">
			<label for="prenom" class="col-3 col-form-label">Prénom</label>
			<div class="col-6">
				<input type="text" class="form-control" id="prenom" name="prenom" />
				<div class="invalid-feedback">Veuillez rentrer un prenom.</div>
			</div>
		</div>
		<div class="form-group row">
			<label for="anniversaire" class="col-3 col-form-label">Date
				de naissance</label>
			<div class="col-6">
				<input type="date" class="form-control" id="anniversaire"
					name="anniversaire" />
				<div class="invalid-feedback">Veuillez entrer une date.</div>
			</div>
		</div>
		<div class="form-group row">
			<label for="adresse" class="col-3 col-form-label">Adresse</label>
			<div class="col-6">
				<textarea class="form-control" id="adresse" rows="3" name="adresse"></textarea>
				<div class="invalid-feedback">Veuillez renseigner une adresse.
				</div>
			</div>
		</div>
		<div class="form-group row">
			<label for="numsecu" class="col-3 col-form-label">Numéro de
				sécurité sociale</label>
			<div class="col-6">
				<input type="text" class="form-control" id="numsecu" name="numsecu" />
				<div class="invalid-feedback">Veuillez entrer les 13 chiffres
					composant votre numÃ©ro de sÃ©curitÃ© social.</div>
			</div>
		</div>
		<div class="form-group row">
			<input id="bouttonCreer" type="button"
				class="btn btn-primary col-1 offset-8" value="Créer"></input>
		</div>
		<!-- Modal -->
		<div id="myModal" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content container">
					<div class="modal-header">
						<h4 class="modal-title">CrÃ©ation d'un collaborateur</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<label>Vous Ãªtes sur le point de crÃ©er un collaborateur</label>
						</div>
						<div class="row">
							<label class="col-6">Nom</label><label id="labelnom"></label>
						</div>
						<div class="row">
							<label class="col-6">Prenom</label><label id="labelprenom"></label>
						</div>
						<div class="row">
							<label class="col-6">Date de naissance</label><label
								id="labelannivesaire"></label>
						</div>
						<div class="row">
							<label class="col-6">Adresse</label><label id="labeladresse"></label>
						</div>
						<div class="row">
							<label class="col-6">Numéro de sécurité social</label><label
								id="labelnumsecu"></label>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							onclick="valider()">Créer</button>
					</div>
				</div>

			</div>
		</div>
	</form>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->

</body>
</html>
