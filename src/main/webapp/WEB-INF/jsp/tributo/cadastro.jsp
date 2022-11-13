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
		  <h3>Cadastramento de Tributo</h3>
		 <table class="table table-striped">
		  <form action="/tributo/incluir" method="post">
		    <div class="mb-3 mt-3">	
		      <label for="icms">ICMS:</label>
		      <input class="form-control" placeholder="ICMS" name="ICMS">
		    </div>
		    
		    <div class="mb-3 mt-3">	
		      <label for="iof">IOF</label>
		      <input class="form-control" placeholder="IOF" name="IOF">
		    </div>
		    
		    <div class="mb-3">
		      <label for="iss">ISS</label>
		      <input class="form-control" placeholder="ISS" name="ISS">
		    </div>
		    
		    <button type="submit" class="btn btn-primary">Cadastrar</button>
		  </form>
	  </table>
	 </div>
   </body>
</html>