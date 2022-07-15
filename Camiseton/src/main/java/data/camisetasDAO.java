package data;

import static data.Conexion.*;
import java.sql.*;
import java.util.*;
import model.Biblioteca;

public class camisetasDAO {
    private static final String SQL_CREATE="INSERT INTO camisetas(nombre, autor, cantPaginas, precio, copias) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_READ="SELECT * FROM camisetas";
    private static final String SQL_READ_BY_ID="SELECT * from camisetas WHERE idCamiseta=?";
    private static final String SQL_UPDATE_PRECIO="=UPDATE camisetas SET precio = ? WHERE idCamiseta = ? ";
    private static final String SQL_UPDATE_COPIAS="UPDATE camisetas SET copias = ? WHERE idCamiseta = ?";
    private static final String SQL_UPDATE="UPDATE camisetas SET nombre = ? , autor = ?, cantPaginas = ?, precio = ?, copias = ? WHERE idCamiseta = ?";
    private static final String SQL_DELETE="DELETE FROM camisetas WHERE idCamiseta = ?";

    public List<Biblioteca> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Biblioteca camiseta;
        List<Biblioteca> camisetas = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idCamiseta = rs.getInt(1);
                String nombre = rs.getString(2);
                String autor = rs.getString(3);
                int cantPaginas = rs.getInt(4);
                double precio = rs.getDouble(5);
                int copias = rs.getInt(6);
                

                camiseta = new Biblioteca(idCamiseta, nombre, autor, cantPaginas,precio, copias);

                camisetas.add(camiseta);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return camisetas;
    }
    
    public Biblioteca findById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Biblioteca camiseta = null;
        

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ_BY_ID);
            rs = stmt.executeQuery();
            stmt.setInt(1, id);
            
            while (rs.next()) {
                int idCamiseta = rs.getInt(1);
                String nombre = rs.getString(2);
                String autor = rs.getString(3);
                int cantPaginas = rs.getInt(4);
                double precio = rs.getDouble(5);
                int copias = rs.getInt(6);
                

                camiseta = new Biblioteca(idCamiseta, nombre, autor, cantPaginas,precio, copias);

                
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return camiseta;
    }
    
    
    
    public void insert(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Biblioteca camiseta;
        List<Biblioteca> camisetas = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idCamiseta = rs.getInt(1);
                String nombre = rs.getString(2);
                String autor = rs.getString(3);
                int cantPaginas = rs.getInt(4);
                double precio = rs.getDouble(5);
                int copias = rs.getInt(6);
                

                camiseta = new Biblioteca(idCamiseta, nombre, autor, cantPaginas,precio, copias);

                camisetas.add(camiseta);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        
    }
    
    
    public int insert(Biblioteca camiseta){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_CREATE);
            stmt.setString(1, camiseta.getNombre());
            stmt.setString(2, camiseta.getAutor());
            stmt.setInt(3, camiseta.getCantPaginas());
            stmt.setDouble(4, camiseta.getPrecio());
            stmt.setInt(5, camiseta.getCopias());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int updatePrecio(Biblioteca libro){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_PRECIO);
            stmt.setDouble(1, libro.getPrecio());
            stmt.setInt(2, libro.getIdCamiseta());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int update(Biblioteca libro){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1,libro.getNombre());
            stmt.setString(2,libro.getAutor());
            stmt.setInt(3, libro.getCantPaginas());
            stmt.setDouble(4, libro.getPrecio());
            stmt.setInt(5, libro.getCopias());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int updateCopias(Biblioteca libro){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_COPIAS);
            stmt.setInt(1, libro.getCopias());
            stmt.setInt(2, libro.getIdCamiseta());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int deleteLibro(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
