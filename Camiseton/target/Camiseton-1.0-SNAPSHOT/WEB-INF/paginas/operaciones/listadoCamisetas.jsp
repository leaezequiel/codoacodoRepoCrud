<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="es_AR"/> <!-- DATOS POR REGION  -->
<fmt:formatNumber value="${libro.precio}" type="currency"/>
    
<section id="libros" >
    <div clas="container">
        <div class="row">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Camisetas</h4>
                    </div>   
                    <table class="table table-striped table-dark">
                        <thead class="thead-dark">
                            <tr>
                                <th>Nombre</th>
                                <th>Equipo</th>
                                <th>Liga</th> 
                                <th>Numero</th
                                <th>Precio</th>
                                <th>Precio</th>
                                <th>Cantidad</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="libro" items="${libros}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${libro.nombre}</td>
                                    <td>${libro.autor}</td> 
                                    <td>${libro.cantPaginas}</td>
                                    <td><fmt:formatNumber value="${libro.precio}" type="currency"/></td>
                                    <td>${libro.copias}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servletControlador?accion=editar&idCamiseta=${libro.idCamiseta}" class="btn btn-secondary">
                                            <i class="fas fa angle-double-right"></i>
                                            Editar   
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div> 
            <div class="col-md-4">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Cantidad total de Camisetas</h3>
                        <h4 class="display-4">${cantidadCamisetas}</h4>
                    </div>
                </div>
                    
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Precio Total de Camisetas</h3>    
                        <h4 class="display-4"><fmt:formatNumber value="${precioTotal}" type="currency"/></h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/paginas/operaciones/agregarCamiseta.jsp"/>                    