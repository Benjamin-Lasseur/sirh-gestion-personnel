<%@page import="java.util.List"%>
<%@page import="dev.sgp.collab.Collaborateur"%>
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

</head>
<body class="container-fluid">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<img
					src="https://assets.chooseyourboss.com/companies/logos/000/004/322/square/Logo_DTA.jpg?1457453234"
					alt="logo" height="42" width="42"> <a
					class="nav-item nav-link active" href="lister.html">Collaborateurs<span
					class="sr-only">(current)</span></a> <a class="nav-item nav-link"
					href="../statistique.html">Statistique</a> <a
					class="nav-item nav-link" href="../activites.html">Activités</a>
			</div>
		</div>
	</nav>
	<div class="row col-3 offset-9">
		<a href="nouveau.html"><button type="button"
				class="btn btn-primary">Ajouter un collaborateur</button></a>
	</div>
	<div class="row offset-1">
		<h1>Les collaborateurs</h1>
	</div>
	<form action="">
		<div class="form-group row offset-1">
			<label class="col-form-label col-3">Rechercher un nom ou un
				prénom qui commence par :</label>
			<div class="col-2">
				<input type="text" class="form-control" id="nom" />
			</div>
			<div>
				<button type="button" class="btn btn-primary">Rechercher</button>
			</div>
			<div class="form-check offset-1">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox"> Voir les
					collaborateurs désactivés
				</label>
			</div>
		</div>
		<div class="form-group row offset-1">
			<label class="col-form-label col-3">Filtrer par département :</label>
			<div class="col-2">
				<select class="form-control" id="exampleFormControlSelect1">
					<option>Tous</option>
					<option>Comptabilité</option>
					<option>Ressources humaines</option>
					<option>Informatique</option>
				</select>
			</div>
		</div>
	</form>
	<div class="card-deck">
		<%List<Collaborateur> listCollab = (List<Collaborateur>)request.getAttribute("listCol");
for (Collaborateur col : listCollab){
%>
		<div class="card col-3">
			<img class="card-img-top"
				src="http://www.worldofbuzz.com/wp-content/uploads/2015/04/noprofilemale.gif"
				alt="Photo collaborateur">
			<div class="card-block">
				<h4 class="card-title">
					<%=col.getNom()%>
					<%=col.getPrenom()%>
				</h4>
				<div class="row">
					<label class="card-text col-5">Fonction</label><label> <%=col.getFonction()%>
					</label>
				</div>
				<div class="row">
					<label class="card-text col-5">Département</label><label> <%=col.getDepartement()%>
					</label>
				</div>
				<div class="row">
					<label class="card-text col-5">Email</label><label> <%=col.getEmail()%>
					</label>
				</div>
				<div class="row">
					<label class="card-text col-5">Téléphone</label><label><%=col.getTelephone()%></label>
				</div>
				<div class="row">
					<a href="edit.html" class="offset-9"><button type="button"
							name="button" class="btn btn-primary">Editer</button></a>
				</div>
			</div>
		</div>
		<%} %>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
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
</body>
</html>
