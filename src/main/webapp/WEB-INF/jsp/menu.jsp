<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <nav class="navbar navbar-expand-sm bg-light navbar-light">
         <div class="container-fluid">
          <c:if test="${not empty user}">
            <ul class="navbar-nav">
               <li class="nav-item">
                  <a class="nav-link active" href="#">Home</a>
               </li>
               <li class="nav-item">
                  <a class="nav-link" href="/cliente/lista">Cliente</a>
               </li>
               <li class="nav-item">
                  <a class="nav-link" href="/consumo/lista">Consumo</a>
               </li>
               <li class="nav-item">
                  <a class="nav-link" href="/conta/lista">Conta</a>
               </li>
               <li class="nav-item">
                  <a class="nav-link" href="/extra/lista">Extra</a>
               </li>
               <li class="nav-item">
                  <a class="nav-link" href="/pagamento/lista">Pagamento</a>
               </li>
               <li class="nav-item">
                  <a class="nav-link" href="/tributo/lista">Tributo</a>
               </li>
            </ul>
           </c:if>
            
            <ul class="navbar-nav">
            <c:if test="${empty user}">
               <li class="nav-item">
                  <a class="nav-link" href="/usuario">Signup</a>
               </li>
               <li class="nav-item">
                  <a class="nav-link" href="/login">Login</a>
               </li>
             </c:if>
               <c:if test="${not empty user}">
	               <li class="nav-item">
	                  <a class="nav-link" href="/logout">Logout, ${user.nome}</a>
	               </li>
               </c:if>
            </ul>
            
         </div>
      </nav>