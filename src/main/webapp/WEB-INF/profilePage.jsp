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
<link rel="stylesheet" type="text/css" href="/css/profileStyle.css"/>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia&effect=neon|outline|emboss|shadow-multiple">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Anybody:ital,wght@0,100..900;1,100..900&family=Sixtyfour&display=swap" rel="stylesheet">
<title>| USER PROFILE |</title>
</head>
<body>
	<div id="header" class="container mt-3">
		<a class="headerLinks" href="/home">Bright Ideas</a>
		<a class="headerLinks" href="/logout">Logout</a>
		
	</div>

	<div class="container m-5">
	<p class="card-title font-effect-shadow-multiple" id="pTag"> USER PROFILE: </p>
	<div class="card">
		  <div class="card-body">
		    <h1 class="card-title font-effect-shadow-multiple"><span id="userName">${userInfo.getName()}</span></h1>
		    <h4 class="card-text">Alias: <span class="userInfo"> ${userInfo.getAlias()}</span></h4>
		    <h4  class="card-text">Email: <span class="userInfo"> ${userInfo.getEmail()}</span></h4>

		  </div>
	</div>
	
		<div class="container-md" style="boder-top: solid 5px black">
		
		<p style="border-top: solid 5px black; margin: 30px"></p>
			
			<h2> Total number of Posts: ${numIdeas}</h2>
			
			<h2> Total number of Likes: ${numLikes}</h2>
			
			
		
		</div>
		
	
	</div>

</body>
</html>