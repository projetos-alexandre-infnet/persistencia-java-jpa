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
         <h3>Lista de Consumo</h3>
         <h4><a href="/consumo">Incluir</a></h4>
         <table class="table table-striped">
            <thead>
               <tr>
               	  <th>Id</th>
                  <th>Item</th>
                  <th>Quantidade de Itens</th>
                  <th>Individual ou Grupo</th>
                  <th></th>
               </tr>
            </thead>
            <tbody>
            <c:forEach var="c" items="${listagem}">
               <tr>
                  <td>${c.id}</td>
                  <td>${c.item}</td>
                  <td>${c.quantidadeDeItens}</td>
                  <td>${c.individualOuGrupo}</td>
                  <td><a href="/consumo/${c.id}/excluir">excluir</a></td>
               </tr>
             </c:forEach>
            </tbody>
         </table>
      </div>
   </body>
</html>