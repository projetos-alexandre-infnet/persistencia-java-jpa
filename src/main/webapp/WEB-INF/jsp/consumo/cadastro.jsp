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
</head>
<html>
   <body>
      <c:import url="/WEB-INF/jsp/menu.jsp"/>
     <div class="container mt-3">
		  <h3>Cadastramento de Consumo</h3>
		 <table class="table table-striped">
		  <form action="/consumo/incluir" method="post">
		    <div class="mb-3 mt-3">	
		      <label for="nome">Item:</label>
		      <input class="form-control" placeholder="Item:" name="item">
		    </div>
		    
		    <div class="mb-3 mt-3">	
		      <label for="quantidadeDeItens">quantidade de Itens:</label>
		      <input class="form-control" placeholder="Quantidade de Itens:" name="quantidadeDeItens">
		    </div>
		    
		    <div class="mb-3">
		      <label for="individualOuGrupo">Individual ou Grupo:</label>
		      <input class="form-control" placeholder="O consumo é individual ou em grupo?" name="individualOuGrupo">
		    </div>
		    
		    <button type="submit" class="btn btn-primary">Cadastrar</button>
		  </form>
	  </table>
	 </div>
   </body>
</html>