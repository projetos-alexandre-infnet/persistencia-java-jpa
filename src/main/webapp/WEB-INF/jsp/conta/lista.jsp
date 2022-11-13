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
         <h4>Contas</h4>
         <table class="table table-striped">
            <thead>
               <tr>
                  <th>id</th>
                  <th>descrição</th>
                  <th>conta ativa</th>
                  <th></th>
               </tr>
            </thead>
            <tbody>
               <c:forEach var="c" items="${listagem}">
               <tr>
                  <td>${c.id}</td>
                  <td>${c.descricao}</td>
                  <td>${c.contaAtiva}</td>
                  <td><a href="/conta/${c.id}/excluir">excluir</a> </td>
               </tr>
             </c:forEach>
            </tbody>
         </table>
      </div>
   </body>
</html>