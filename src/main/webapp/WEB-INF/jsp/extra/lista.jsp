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
         <h4>Classe: Extra</h4>
         <h4><a href="/extra">Novo</a></h4>
         <table class="table table-striped">
            <thead>
               <tr>
                  <th>id</th>
                  <th>número de parcelas</th>
                  <th>pagamento em lote</th>
                  <th>pagamento único</th>
                  <th></th>
               </tr>
            </thead>
            <tbody>
               <c:forEach var="e" items="${listagem}">
               <tr>
                  <td>${e.id}</td>
                  <td>${e.numeroDeParcelas}</td>
                  <td>${e.pagamentoLote}</td>
                  <td>${e.pagamentoUnico}</td>
                  <td><a href="/extra/${e.id}/excluir">excluir</a></td>
               </tr>
             </c:forEach>
            </tbody>
         </table>
      </div>
   </body>
</html>