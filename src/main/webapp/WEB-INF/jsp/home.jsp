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
   <title>AppPagamentos</title>
</head>
<html>
   <body>
      <c:import url="/WEB-INF/jsp/menu.jsp"/>

      <div class="container mt-3">
         <h2>${projeto.nome}</h2>
         <p>${projeto.descricaoProjeto}</p>

         <c:forEach var="c" items="${projeto.classes}">
         <h3>Classe: ${c.nome}</h3>
         <table class="table table-striped">
            <thead>
               <tr>
                  <th>Atributo</th>
                  <th>Tipo</th>
                  <th>Descrição</th>
               </tr>
            </thead>
            <tbody>
              <c:forEach var="a" items="${c.atributos}">
                   <tr>
                      <td>${a.nome}</td>
                      <td>${a.tipo}</td>
                      <td>${a.descricaoAtributo}</td>
                   </tr>
              </c:forEach>
            </tbody>
        </table>
       </c:forEach>
      </div>
   </body>
</html>