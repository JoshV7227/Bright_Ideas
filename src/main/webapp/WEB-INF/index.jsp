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
<link rel="stylesheet" type="text/css" href="/css/loginStyle.css"/>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia&effect=neon|outline|emboss|shadow-multiple">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Anybody:ital,wght@0,100..900;1,100..900&family=Sixtyfour&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>| BRIGHT IDEAS |</title>
</head>
<body>
	<div class="container mt-5">
	<h1 class="display-1 font-effect-neon">BRIGHT IDEAS!</h1>
	<h2>* light bulb ! *</h2>

		  <div class="form-control mt-5 pb-3" id="loginBox" >
		  <div class="registerContainer">
		  <div class="row">
		  	<p class="text-danger">
			<c:out value="${notLoggedIn}"></c:out>
		  		<div class="col" style="text-align: center">
		  			<h3>REGISTER</h3>
		  		</div>
		  </div>
  			<form:form action="/register" method="POST" modelAttribute="user">
			    <div class="errors">
		  		<form:errors path="*" style="color:red"></form:errors>
			    
			    </div>	
			    <div class="row mt-3">
				      <div class="col">
				        	<form:label path="name"  class="form-control label"> NAME:</form:label>
				      </div>
				      <div class="col">
				        	<form:input path="name"   type="text" class="form-control" placeholder="Enter User name"></form:input>
				      </div>
			    </div>
			    <div class="row">
				      <div class="col">
				        	<form:label path="alias"  class="form-control label"> ALIAS:</form:label>
				      </div>
				      <div class="col">
				        	<form:input  path="alias" type="text" class="form-control" placeholder="Enter Alias"></form:input>
				      </div>
			    </div>
			    
			    
			    
			    <div class="row">
				      <div class="col">
				        	<form:label path="email"  class="form-control label"> EMAIL:</form:label>
				      </div>
				      <div class="col">
				        	<form:input  path="email" type="email" class="form-control" placeholder="Enter email"></form:input>
				      </div>
			    </div>
			     <div class="row">
				      <div class="col">
				        	<form:label path="password"  class="form-control label"> PASSWORD:</form:label>
				      </div>
				      <div class="col">
				        	<form:input path="password" type="password" class="form-control" placeholder="Enter password"></form:input>
				      </div>
			    </div>
			    <div class="row">
				      <div class="col">
				        	<form:label path="confirm" class="form-control label"> CONFIRM PASSWORD:</form:label>
				      </div>
				      <div class="col">
				        	<form:input path="confirm"  type="password" class="form-control" placeholder="Confirm password"></form:input>
				      </div>
			    </div>
			    	<button class="btn btn-dark mt-2 daButton" id="sButton">SUBMIT</button>
			    	
			     
  			</form:form>
  			</div>
		
		<div class="form-control mt-1" id="loginContainer" >
			<div class="row">
		  		<div class="col" style="text-align: center">
		  			<h3 id="loginH">LOG IN</h3>
		  		</div>
		  </div>
			    <form:form action="/login" method="POST" modelAttribute="loginUser">
			    <div class="row mt-3">
				      <div class="col">
				        	<form:label path="email" class="form-control label"> EMAIL:</form:label>
				      </div>
				      <div class="col">
				        	<form:input path="email"  type="email" class="form-control" placeholder="Enter email"></form:input>
				        	<form:errors path="email" style="color:red"></form:errors>
				      </div>
			    </div>
			    <div class="row">
				      <div class="col">
				        	<form:label path="password"  class="form-control label"> PASSWORD:</form:label>
				      </div>
				      <div class="col">
				        	<form:input path="password"  type="password" class="form-control" placeholder="Enter passowrd"></form:input>
				        	<form:errors path="password" style="color:red"></form:errors>
				      </div>

			    	<button class="btn btn-dark mt-2 mb-5" id="lButton">LOGIN</button>

			    </div>
			   
		</form:form> 
  		
  		</div>
  		
  
		

	</div>
	
	
	</div>

</body>
</html>