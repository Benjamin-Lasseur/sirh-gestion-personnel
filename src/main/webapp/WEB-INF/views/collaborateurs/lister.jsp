<%@page import="dev.sgp.service.DepartementService"%>
<%@page import="dev.sgp.util.Constantes"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="dev.sgp.entite.Departement"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %> 
<!doctype html>
<html lang="en">
<head>
<title>Lister les collaborateurs</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<script>
	function chercher() {
		document.forms[0].action = "<c:url value="/collaborateurs/lister"/>";
		document.forms[0].method = "POST";
		document.forms[0].submit();
	}
</script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value="/css/lister.css"/>" />

</head>
<body class="container-fluid">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<img
					src="https://assets.chooseyourboss.com/companies/logos/000/004/322/square/Logo_DTA.jpg?1457453234"
					alt="logo" height="42" width="42"> <a
					class="nav-item nav-link active"
					href="<c:url value="/collaborateurs/lister"/>">Collaborateurs<span
					class="sr-only">(current)</span></a> <a class="nav-item nav-link"
					href="<c:url value="/statistique"/>">Statistique</a>
				<a class="nav-item nav-link"
					href="<c:url value="/activites"/>">Activités</a>
			</div>
		</div>
	</nav>
	<div class="row col-3 offset-9">
		<a href="<c:url value="/collaborateurs/nouveau"/>" /><button
				type="button" class="btn btn-primary">Ajouter un
				collaborateur</button></a>
	</div>
	<div class="row offset-1">
		<h1>Les collaborateurs</h1>
	</div>
	<form>
		<div class="form-group row offset-1">
			<label class="col-form-label col-3">Rechercher un nom ou un
				prénom qui commence par :</label>
			<div class="col-2">
				<c:set var="chercher" value="${requestScope.cherchernom}"></c:set>
				<input type="text" class="form-control" id="nom" name="cherchernom"
					<c:if test="${chercher!=null}">value=<c:out value="${chercher}"/></c:if>>
			</div>
			<div>
				<button type="button" class="btn btn-primary" name="departement"
					onclick="chercher()">Rechercher</button>
			</div>
			<div class="form-check offset-1">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox" name="afficherDesactiver"
					<c:if test="${requestScope.afficherDesactiver!=null}">checked</c:if>>
					Voir les collaborateurs désactivés
				</label>
			</div>
		</div>
		<div class="form-group row offset-1">
			<label class="col-form-label col-3">Filtrer par département :</label>
			<div class="col-2">
				<select class="form-control" id="exampleFormControlSelect1"
					name="departement">
					<option
						<c:if test="${requestScope.departement==null}">selected</c:if>>Tous</option>
					
					<c:forEach items="${requestScope.departements}" var="dep" >
						<option
							<c:if test="${requestScope.departement!= null && requestScope.departement==dep.nom}">selected</c:if>>${dep.nom}</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</form>
	<c:set var="listCollab" value="${requestScope.collaborateurs}"></c:set>
	<c:set var="compteur" value="0"></c:set>
	<c:forEach var="col" items="${listCollab}">
		<c:if test="${compteur==0}">
			<div class="card-deck padding-top">
		</c:if>
		<div class="card col-4">
			<div class="media">
				<img class="mr-3 col-4" style="padding-left: 0px"
					src="${col.photo}" alt="Photo Collaborateur">
				<div class="media-body">
					<h5 class="mt-0">
						${col.nom}
						${col.prenom}</h5>
					<div class="row col-12 no-padding no-margin">
						<label class="col-5 no-padding no-margin">Fonction</label><label>
							${col.fonction}</label>
					</div>
					<div class="row col-12 no-padding no-margin">
						<label class="col-5 no-padding no-margin">Département</label><label>
							${col.departement.nom}</label>
					</div>
					<div class="row col-12 no-padding no-margin">
						<label class="col-5 no-padding">Email</label><label> ${col.email}</label>
					</div>
					<div class="row col-12 no-padding no-margin">
						<label class="col-5 no-padding no-margin">Téléphone</label><label>${col.telephone}</label>
					</div>
					<div class="row col-12 no-padding no-margin">
						<a
							href="<%=request.getContextPath()%>/collaborateurs/edit?matricule=${col.matricule}"
							class="col-12"><button type="button" name="button"
								class="btn btn-primary text-right">Editer</button></a>
					</div>
				</div>
			</div>
		</div>
		<c:choose>
			<c:when test="${compteur==2}">
				</div>
				<c:set var="compteur" value="0"></c:set>
			</c:when>
			<c:otherwise>
				<c:set var="compteur" value="${compteur+1}"></c:set>
			</c:otherwise>
		</c:choose>


	</c:forEach>
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
