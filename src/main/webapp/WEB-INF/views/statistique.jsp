<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!doctype html>
<html lang="en">
<head>
<title>Statistique</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
					class="nav-item nav-link"
					href="<%=request.getContextPath()%>/collaborateurs/lister">Collaborateurs<span
					class="sr-only"></span></a> <a class="nav-item nav-link active"
					href="<%=request.getContextPath()%>/statistique">Statistique</a> <a
					class="nav-item nav-link"
					href="<%=request.getContextPath()%>/activites">Activités</a>
			</div>
		</div>
	</nav>
	<div class="row col-3 offset-9">
		<a href="<c:url value="/collaborateurs/nouveau"/>" />
		<button type="button" class="btn btn-primary">Ajouter un
			collaborateur</button>
		</a>
	</div>
	<div class="row col-8 offset-1">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Chemin</th>
					<th scope="col">Nombre de visites</th>
					<th scope="col">Min (ms)</th>
					<th scope="col">Max (ms)</th>
					<th scope="col">Moyen (ms)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="mapVisite" items="${requestScope.visitesWeb}">
					<tr>
						<th scope="row">${mapVisite.chemin}</th>
						<td>${mapVisite.nbConnections}</td>
						<td>${mapVisite.tempsExecutionMoyen}</td>
						<td>${mapVisite.tempsExecutionMax}</td>
						<td>${mapVisite.tempsExecutionMin}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>
