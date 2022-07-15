<div class="modal fade" id="agregarCamisetaModal" tabindex="-1" aria-labelledby="agregarCamisetaModal" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Camiseta</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/servletControlador?accion=insertar" method="POST" class="was-validated">  
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre" >Liga</label><!-- lo segundo es lo que se muestra en front, lo primero es lo que va al back -->
                        <input type="text" class="form-control" name="nombre" required>                        
                    </div>
                    
                    <div class="form-group"> 
                        <label for="autor">Equipo</label>
                        <input type="text" class="form-control" name="autor" >                         
                    </div>
                    
                    <div class="form-group">
                        <label for="cantPaginas"> Numero</label>
                        <input type="number" class="form-control" name="cantPaginas" required="">                        
                    </div>
                    
                    <div class="form-group">
                        <label for="precio">Precio</label>
                        <input type="currency" class="form-control" name="precio" required="">                       
                    </div>
                    
                    <div class="form-group">
                        <label for="copias">Cantidad</label>
                        <input type="number" class="form-control" name="copias" required="">                  
                    </div>
                    
                </div>
                
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">
                        Guardar
                    </button>
                </div>
            </form>
        </div>        
    </div>
</div>