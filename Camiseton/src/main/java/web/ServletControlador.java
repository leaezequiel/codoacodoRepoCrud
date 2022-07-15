package web;
import data.camisetasDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Biblioteca;

@WebServlet("/servletControlador")//mapea y le dice que vaya si o si aca
public class ServletControlador extends HttpServlet{
    
    @Override 
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String accion = req.getParameter("accion");
        if(accion!=null){
            switch(accion){
                case "eliminar":
                    eliminarCamiseta(req,res);
                    break;
                case "editar":
                    editarCamiseta(req,res);
                    break;
                default:
                    accionDefault(req,res);
                    break;                   
            }
            
        }else{
            accionDefault(req,res);
        }
    }
    
    @Override 
    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        String queryParam = req.getParameter("accion");
        if (queryParam!=null){
            switch(queryParam){
                case "insertar":
                    insertarCamiseta(req,res);
                    break;
                case "modificar":
                    modificarCamiseta(req,res);
                    break;
                default:
                    accionDefault(req,res);
                    break;
                    
                
            }
        }
    }
    
    private void eliminarCamiseta(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        int idCamiseta = Integer.parseInt(req.getParameter("idCamiseta"));
        
        
        int registrosMod = new camisetasDAO().deleteLibro(idCamiseta);
        
        
        accionDefault(req,res);
    }
    
    
    private void accionDefault(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        List<Biblioteca> camiseta = new camisetasDAO().findAll();
        //aca imprime libros en mi caso camisetas.
        camiseta.forEach(System.out::println);
        HttpSession sesion = req.getSession();
        sesion.setAttribute("libros", camiseta);
        sesion.setAttribute("cantidadCamisetas",calcularCopias(camiseta));
        sesion.setAttribute("precioTotal",calcularPrecio(camiseta));
        //req.getRequestDispatcher("libros.jsp").forward(req, res);
        res.sendRedirect("libros.jsp");
    }
    
    private void editarCamiseta(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        int idCamiseta = Integer.parseInt(req.getParameter("idCamiseta"));
        Biblioteca camiseta = new camisetasDAO().findById(idCamiseta);
        req.setAttribute("libro",camiseta);
        String jspEditar = "/WEB-INF/paginas/operaciones/editar.jsp";
        req.getRequestDispatcher(jspEditar).forward(req,res);
    }
    
    private void modificarCamiseta(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        String nombre = req.getParameter("nombre");
        String autor = req.getParameter("autor");
        int cantPaginas = Integer.parseInt(req.getParameter("cantPaginas"));
        double precio = Double.parseDouble(req.getParameter("precio"));
        int copias = Integer.parseInt(req.getParameter("copias"));
        
        int idCamiseta = Integer.parseInt(req.getParameter("idCamiseta"));
        
        Biblioteca lib = new Biblioteca (idCamiseta,nombre,autor,cantPaginas,precio,copias) ;
        
        //EL UPDATE ME TIRA ERROR NO SE PORQUE!
        //int regMod = new camisetasDAO.update(lib); 
        
        accionDefault(req,res);
        
    }
    
    private void insertarCamiseta(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        String nombre = req.getParameter("nombre");
        String autor = req.getParameter("autor");
        int cantPaginas = Integer.parseInt(req.getParameter("cantPaginas"));
        double precio = Double.parseDouble(req.getParameter("precio"));
        int copias = Integer.parseInt(req.getParameter("copias"));
    
        Biblioteca camiseta = new Biblioteca( nombre,  autor,  cantPaginas,  precio);
        int registrosMod = new camisetasDAO().insert(camiseta);
        accionDefault(req,res);
        
        
    }
    
    private int calcularCopias(List<Biblioteca> lib){
        int cant=0;
        for (int i = 0; i < lib.size(); i++) {
            cant += lib.get(i).getCopias();
        }
        return cant;        
    }
    
    private double calcularPrecio(List<Biblioteca> lib){
        double precio = 0;
        for (int i = 0; i < lib.size(); i++) {
            precio += (lib.get(i).getPrecio() * lib.get(i).getCopias());
        }
        return  precio;
    }
    
}
