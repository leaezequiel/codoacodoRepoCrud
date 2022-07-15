<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar camisetas </title>
        <script src="https://kit.fontawesome.com/423937a26e.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <%-- no se porque no anda esta parte... aca se rompe pero bueno.. es trabajo honesto jaja --%>
        <form action="${pageContext.request.contextPath}/servletControlador?accion=modificar&idCamiseta=${libro.idCamiseta}" method="POST" class="was-validated"">
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavEdicion.jsp"/>
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Camiseta</h4>
                                    
                                </div>                                
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre" >Liga</label>
                                        <input type="text" class="form-control" name="nombre" required="" value="${libro.nombre}">                        
                                    </div>

                                    <div class="form-group"> 
                                        <label for="autor">Equipo</label>
                                        <input type="text" class="form-control" name="autor" value="${libro.autor}">                         
                                    </div>

                                    <div class="form-group">
                                        <label for="cantPaginas"> Numero</label>
                                        <input type="number" class="form-control" name="cantPaginas" required="" ${libro.cantPaginas}>                        
                                    </div>

                                    <div class="form-group">
                                        <label for="precio">Precio</label>
                                        <input type="currency" class="form-control" name="precio" required="" ${libro.precio}>                       
                                    </div>

                                    <div class="form-group">
                                        <label for="copias">Cantidad</label>
                                        <input type="number" class="form-control" name="copias" required="" ${libro.copias}>                  
                                    </div>

                                    
                                </div>
                                    
                                </div>
                                
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>
        
        <jsp:include page="/WEB-INF/paginas/comunes/piepagina.jsp"/>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </body>
</html>
