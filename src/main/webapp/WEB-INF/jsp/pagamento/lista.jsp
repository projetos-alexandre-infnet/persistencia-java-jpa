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
         <h3>Cadastramento de Pagamentos</h3>

         <h4><a href="/pagamento">Novo</a></h4>
         <table class="table table-striped">
            <thead>
               <tr>
                  <th>id</th>
                  <th>numeroCartao</th>
                  <th>bandeira</th>
                  <th>valor</th>
                  <th>cliente</th>
                  <th>data</th>
                  <th>contas</th>
                  <th></th>
               </tr>
            </thead>
            <tbody>
               <c:forEach var="p" items="${listagem}">
               <tr>
                  <td>${p.id}</td>
                  <td>${p.numeroCartao}</td>
                  <td>${p.bandeira}</td>
                  <td>${p.valor}</td>
                  <td>${p.cliente.nome}</td>
                  <td>${p.data}</td>
                  <td>${p.contas.size()}</td>
                  <td><a href="/pagamento/${p.id}/excluir">excluir</a></td>
               </tr>
             </c:forEach>
               </tr>
            </tbody>
         </table>
      </div>
   </body>
</html>