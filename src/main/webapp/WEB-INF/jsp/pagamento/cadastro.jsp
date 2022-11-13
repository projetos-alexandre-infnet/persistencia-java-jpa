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
   <c:set var="ativaBotao" value="" />
   <c:import url="/WEB-INF/jsp/menu.jsp"/>
     <div class="container mt-3">
		  <h2>Cadastramento de Pagamento</h2>
		  <form action="/pagamento/incluir" method="post">
		    <div class="mb-3 mt-3">	
		      <label for="numeroCartao">Número do Cartão</label>
		      <input class="form-control" placeholder="Número do Cartão:" name="numeroCartao">
		    </div>
		    
		    <div class="mb-3 mt-3">	
		      <label for="bandeira">Bandeira</label>
		      <input class="form-control" placeholder="bandeira:" name="bandeira">
		    </div>
		    
		    <div class="mb-3">
		      <label for="valor">Valor</label>
		      <input class="form-control" placeholder="valor:" name="valor">
		    </div>

		  <div class="mb-3">
			  <c:if test="${not empty clientes}">
			  <label for="cliente">Cliente</label>
			  <select class="form-control" id="sel1">
				  <c:forEach var="clientesList" items="${clientes}">
				  <option value="${clientesList.id}">${clientesList.nome}</option>
				  </c:forEach>
			  </select>
			  </c:if>
			  <c:if test="${empty clientes}">
				  <label>Não existem clientes cadastrados!</label>
				  <c:set var="ativaBotao" value="disabled" />
			  </c:if>
		  </div>
		  <div class="mb-3">
		  <c:if test="${not empty contas}">
			  <label for="contas">Contas</label>
			  <c:forEach var="contasList" items="${contas}">
			  <div class="checkbox">
				  <label><input type="checkbox" value="${contasList.id}">${contasList.descricao}</label>
			  </div>
			  </c:forEach>
		  </c:if>
		  <c:if test="${empty contas}">
			  <label>Não existem contas cadastradas!</label>
			  <c:set var="ativaBotao" value="disabled" />
		  </c:if>
		  </div>
		    
		    <button ${ativaBotao} type="submit" class="btn btn-primary">Cadastrar</button>
		  </form>
	 </div>
   </body>
</html>