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
		  <h3>Cadastramento de Clientes</h3>
		  <form action="/cliente/incluir" method="post">
			  <div class="mb-3 mt-3">
				  <label>Nome:</label>
				  <input type="text" class="form-control" placeholder="Entre com o seu nome" name="nome">
			  </div>
		    
		    <div class="mb-3 mt-3">	
		      <label for="email">Email:</label>
		      <input type="email" class="form-control" placeholder="Entre com seu email" name="email">
		    </div>
		    
		    <div class="mb-3">
		      <label for="cpfOuCnpj">CPFouCNPJ:</label>
		      <input class="form-control" placeholder="Entre com seu CPF ou CNPJ" name="cpfOuCnpj">
		    </div>
		    
		    <button type="submit" class="btn btn-primary">Cadastrar</button>
		  </form>
	 </div>
   </body>
</html>