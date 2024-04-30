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
<link rel="stylesheet" type="text/css" href="/css/likesStyle.css"/>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia&effect=neon|outline|emboss|shadow-multiple">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Anybody:ital,wght@0,100..900;1,100..900&family=Sixtyfour&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<title>| LIKE STATUS  |</title>
</head>
<body>
	<div id="header" class="container mt-3">
	<a class="headerLinks" href="/home">Bright Ideas</a>
	<a class="headerLinks" href="/logout">Logout</a>
	
	</div>
	
	
	<div class="container m-5">
	
	<h1><a class="font-effect-shadow-multiple" id="userName" href="/userPage/${ideaInfo.getUser().getId()}">${ideaInfo.getUser().getAlias()}</a> says:</h1>
	
			<c:choose>
				
					<c:when test="${ideaInfo.getUser().getId() == userId}">
				
				
					<form:form action="/updateIdea/${ideaInfo.getId()}" method="POST" modelAttribute="updateIdea">
					<form:errors path="idea" style="color: red"></form:errors>
					<form:input type="hidden" path="user" value="${userId}"></form:input>
					<form:textarea rows="5" id="inputBox" path="idea" class="form-control" type="text" placeholder="${ideaInfo.getIdea()}" ></form:textarea>
					<input type="hidden" name="_method" value="PUT"></input>
					
					<button id="ideaButton"> Update Idea! <i  id="bulb" class="material-icons">lightbulb</i></button>
					</form:form>
					
					</c:when>
						<c:otherwise>	
				
				 	 		<textarea id="printedIdea" >${ideaInfo.getIdea()}</textarea>
				 	 
				 		 </c:otherwise>
				 	
			</c:choose>	 	
				 	 
	</div>
	
	<div id="likersDiv" class="container">
		<h2> People who have liked this post: </h2>
	  <table class="table table-dark table-striped table-bordered">
		    <thead>
			      <tr>
			        <th>ALIAS</th>
			        <th>NAME</th>
			      </tr>
		    </thead>
		    <tbody>
		    
		      <c:forEach var="user" items="${uniqueLikers}">
			      <tr>
			      
			        <td id="aliasRow" ><a id="likersLink" href="/userPage/${user.getId()}">${user.getAlias()}</a></td>
			        <td>${user.getName()}</td>
			      </tr>
		      </c:forEach>
		      
		    </tbody>
  	</table>
	
	
	
	</div>


</body>
</html>