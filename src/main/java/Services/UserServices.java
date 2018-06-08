package Services;

import Classes.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserServices {

    public List<User> listaEstudiantes() {
        List<User> lista = new ArrayList<>();
        Connection con = null; //objeto conexion.
        try {

            String query = "select * from users";
            con = DatabaseService.getInstancia().getConexion(); //referencia a la conexion.
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            ResultSet rs = prepareStatement.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setNombre(rs.getString("nombre"));
                user.setPassword(rs.getString("password"));
                user.setAdministrator(rs.getBoolean("administrator"));
                user.setAuthor(rs.getBoolean("author"));

                lista.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lista;
    }

    /**
     *
     * @param matricula
     * @return
     */
    /*
    public User getEstudiante(int matricula) {
        User user = null;
        Connection con = null;
        try {
            //utilizando los comodines (?)...
            String query = "select * from estudiante where matricula = ?";
            con = DatabaseService.getInstancia().getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.
            prepareStatement.setInt(1, matricula);
            //Ejecuto...
            ResultSet rs = prepareStatement.executeQuery();
            while(rs.next()){
                user = new User();
                user.setMatricula(rs.getInt("matricula"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setCarrera(rs.getString("carrera"));
                user.setTelefono(rs.getString("telefono"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return est;
    }

    public boolean crearEstudiante(User user){
        boolean ok =false;

        Connection con = null;
        try {

            String query = "insert into estudiante(matricula, nombre, apellido, telefono, carrera) values(?,?,?,?,?)";
            con = DatabaseService.getInstancia().getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.
            prepareStatement.setInt(1, user.getMatricula());
            prepareStatement.setString(2, user.getNombre());
            prepareStatement.setString(3, user.getApellido());
            prepareStatement.setString(4, user.getTelefono());
            prepareStatement.setString(5, user.getCarrera());
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;

        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return ok;
    }

    public boolean actualizarEstudiante(User user){
        boolean ok =false;

        Connection con = null;
        try {

            String query = "update estudiante set nombre=?, apellido=?, carrera=?, telefono=? where matricula = ?";
            con = DatabaseService.getInstancia().getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.
            prepareStatement.setString(1, user.getNombre());
            prepareStatement.setString(2, user.getApellido());
            prepareStatement.setString(4, user.getTelefono());
            prepareStatement.setString(3, user.getCarrera());
            //Indica el where...
            prepareStatement.setInt(5, user.getMatricula());
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;

        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return ok;
    }

    public boolean borrarEstudiante(int matricula){
        boolean ok =false;

        Connection con = null;
        try {

            String query = "delete from estudiante where matricula = ?";
            con = DatabaseService.getInstancia().getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);

            //Indica el where...
            prepareStatement.setInt(1, matricula);
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;

        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return ok;
    } */

}
