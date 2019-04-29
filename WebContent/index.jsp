<%@page import="lombok.EqualsAndHashCode.Include"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ENI-Encheres</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


</head>
<body>
	<div class="container">
		<jsp:include page="/menu"></jsp:include>
		<c:choose>
			<c:when test="${param.page== 'connexion'}">
				<jsp:include page="/connexion"></jsp:include>
			</c:when>
			<c:when test="${param.page== 'accueil'}}">
				<jsp:include page="/accueil"></jsp:include>
			</c:when>
			<c:when test="${param.page== 'creercompte'}">
				<jsp:include page="/creercompte"></jsp:include>
			</c:when>
			<c:otherwise>
				<jsp:include page="/accueil"></jsp:include>
			</c:otherwise>
		</c:choose>
	</div>	
</body>
</html>