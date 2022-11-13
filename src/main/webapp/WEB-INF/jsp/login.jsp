<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet">
	<title>AppPagamento</title>
</head>
<html>
   <body>
      <c:import url="/WEB-INF/jsp/menu.jsp"/>
      
         <div class="container mt-3">
		  <h2>Autenticação</h2>
		  <form action="/login" method="post">
		    <div class="mb-3 mt-3">	
		      <label for="email">Email:</label>
		      <input type="email" class="form-control" placeholder="Enter email" name="email">
		    </div>
		    
		    <div class="mb-3">
		      <label for="pwd">Password:</label>
		      <input type="password" class="form-control" placeholder="Enter password" name="senha">
		    </div>
		    
		    <button type="submit" class="btn btn-primary">Entrar</button>
		  </form>
		</div>
   </body>
</html>