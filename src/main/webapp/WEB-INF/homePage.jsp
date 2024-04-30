<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
    <%@ page isErrorPage="true"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>	
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/homeStyle.css"/>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia&effect=neon|outline|emboss|shadow-multiple">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Anybody:ital,wght@0,100..900;1,100..900&family=Sixtyfour&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<title>| BRIGHT IDEAS MAIN  |</title>
</head>
<body>
	<div class="container">
		<a id="logoutLink" href="/logout">LOGOUT</a>
	
		<div id="header" class="container m-5">
		<h1 class="font-effect-neon">Hi <c:out value="${userName}"></c:out>!</h1>
		</div>
		
			<div id="inputIdea" class="container m-3">
				
				<form:form action="/newIdea" method="POST" modelAttribute="thisIdea">
				<form:errors path="*" style="color: red"></form:errors>
				<form:input type="hidden" path="user" value="${userId}"></form:input>
				<form:input id="ideaBox" path="idea" class="form-control" type="text" placeholder="Enter something witty here...."></form:input>
				<button id="ideaButton">Idea! <i  id="bulb" class="material-icons">lightbulb</i></button>
				</form:form>
			</div>
			
			<c:forEach var="theIdea" items="${sortedIdeas}">
			<div class="container m-4 postedIdea">
			
	 		<p id="userSays"><a id="nameLink" href="/userPage/${theIdea.getUser().getId()}">${theIdea.getUser().getAlias()}</a> says:</p>
			
			<p id="printedIdea"> ${theIdea.getIdea()}</p>
			
			
		<div class="actionButtons">
		
			<p><a id="likeThis" href="/likeButton/${userId}/${theIdea.getId()}"><span id="thumb" class="material-symbols-outlined">thumb_up</span></a>
			<a href="/likesPage/${theIdea.getId()}">${theIdea.getUsers().size()} People</a> like this.</p>
			
			<c:if test="${userId == theIdea.getUser().getId()}">
			<a id="updateButton" href="/likesPage/${theIdea.getId()}">* UPDATE IDEA *</a></p>
			</c:if>
			
			
			
			<c:if test="${theIdea.getUser().getId() == userId }">
			
				<form action="/burnIdea/${theIdea.getId()}" method="POST">
				<input type="hidden" name="_method" value="delete">
				<button id="xbutton" type="submit" class="btn btn-danger">X</button>
				</form>
			
			
			</c:if>
			
		
		</div>
			
			
			
			</div>
			</c:forEach>
	</div>
	
</body>
</html>