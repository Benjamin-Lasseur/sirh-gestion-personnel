<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="dev.sgp.entite.Departement"%>
<%@page import="dev.sgp.util.Constantes"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %> 
<c:set var="col" value="${requestScope.collaborateur}"></c:set>
<!doctype html>
<html lang="en">
<head>
<title>Modification d'un collaborateur</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<script>
	function validerEdit(){
		 document.forms[0].action="<c:url value="/collaborateurs/edit"/>";
			document.forms[0].method = "POST";
			document.forms[0].submit();
	}
	</script>

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
<link rel="stylesheet" href="../css/edit.css">

</head>

<body class="container-fluid">
	<div class="row">
		<nav class="navbar navbar-expand-lg navbar-light bg-ligh col-12t">
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
	</div>
	<div class="row">
		<div class="col-4">
			<img src="${col.photo}" alt="Photo du collaborateur"
				class="col-10 offset-1" id="imgphoto">
		</div>
		<form class="col-7">
			<div class="row">
				<div class="col-7">
					<h1>${col.nom}
						-
						${col.prenom}
						-
						${col.matricule}
						<input type=hidden name="matricule" value="${col.matricule}"/></h1>
				</div>
				<div class="offset-col-1">
					<label id="desactiverlabel" for="desactiverbox"><input
						id="desactiverbox" type="checkbox" name="desactiver" <c:if test="${col.actif==false}">checked</c:if>>Désactiver</label>
				</div>
			</div>
			<div class="row">
				<div id="accordion" role="tablist" class="col-12">
					<div class="card">
						<div class="card-header" role="tab" id="headingOne">
							<h5 class="mb-0">
								<a data-toggle="collapse" href="#collapseOne"
									aria-expanded="true" aria-controls="collapseOne"> Identité
								</a>
							</h5>
						</div>
						<div id="collapseOne" class="collapse show" role="tabpanel"
							aria-labelledby="headingOne" data-parent="#accordion">
							<div class="card-body">
								<div class="row">
									<label class="card-text col-6">Civilité</label> <select
										class="form-control col-6" id="exampleFormControlSelect1">
										<option>Mr</option>
										<option>Mme</option>
									</select>
								</div>
								<div class="row">
									<label class="card-text col-6">Nom</label><label class="col-6">${col.nom}</label>
								</div>
								<div class="row">
									<label class="card-text col-6">Prénom</label><label
										class="col-6">${col.prenom}</label>
								</div>
								<div class="row">
									<label class="card-text col-6">Date de naissance</label><label class="col-6">${col.dateDeNaissance}</label>
								</div>
								<div class="row">
									<label class="card-text col-6">Adresse</label><input
										name ="adresse" type="text" class="col-6" value="${col.adresse}" />
								</div>
								<div class="row">
									<label class="card-text col-6">Numéro de sécurité
										sociale</label><label class="col-6"
										>${col.numSecu}</label>
								</div>
								<div class="row">
									<label class="card-text col-6">Téléphone</label><input
										name ="telephone" type="text" class="col-6" value="${col.telephone}" />
								</div>
								<div class="row">
									<label class="card-text col-6">Email</label><input type="text"
										class="col-6" value="${col.email}" />
								</div>
							</div>
						</div>
					</div>
					<div class="card">
						<div class="card-header" role="tab" id="headingTwo">
							<h5 class="mb-0">
								<a class="collapsed" data-toggle="collapse" href="#collapseTwo"
									aria-expanded="false" aria-controls="collapseTwo"> Poste </a>
							</h5>
						</div>
						<div id="collapseTwo" class="collapse" role="tabpanel"
							aria-labelledby="headingTwo" data-parent="#accordion">
							<div class="card-body">
								<div class="row">
									<label class="card-text col-6">Département</label><select name="departement"
										class="form-control col-6" id="exampleFormControlSelect1">
										<c:forEach var="dep" items="${requestScope.departements}">
										<option <c:if test="${col.departement==dep}">selected</c:if>>${dep.nom}</option>
										
										</c:forEach>
								
									</select>
								</div>
								<div class="row">
									<label class="card-text col-6">Nom</label><input type="text"
										class="col-6" name ="fonction" value="${col.fonction}" />
								</div>
							</div>
						</div>
					</div>
					<div class="card">
						<div class="card-header" role="tab" id="headingThree">
							<h5 class="mb-0">
								<a class="collapsed" data-toggle="collapse"
									href="#collapseThree" aria-expanded="false"
									aria-controls="collapseThree"> Coordonnées banquaires </a>
							</h5>
						</div>
						<div id="collapseThree" class="collapse" role="tabpanel"
							aria-labelledby="headingThree" data-parent="#accordion">
							<div class="card-body">
								<div class="row">
									<label class="card-text col-6">IBAN</label><input type="text"
									name="iban"	class="col-6" value="${col.iban}" />
								</div>
								<div class="row">
									<label class="card-text col-6">BIC</label><input type="text"
										name="bic" class="col-6" value="${col.bic}" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<input type="button" value="Sauvegarder" id="sauvegarder" class="btn btn-primary offset-10" onclick="validerEdit()">
			</div>
		</form>
	</div>


</body>

</html>
