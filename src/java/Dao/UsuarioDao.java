/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Medico;
import Modelo.Paciente;
import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author zebas
 */
public class UsuarioDao implements IUsuarioDao{
    
    private String tipo_usuario;
    private Usuario user;

    public UsuarioDao(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
        if(tipo_usuario.equals(Constantes.TYPE_USER1)){
            this.user = new Medico();
        }else if(tipo_usuario.equals(Constantes.TYPE_USER2)){
            this.user = new Paciente();
        }
    }

    public UsuarioDao() {
    }        
    
    @Override
    public List<Usuario> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertar(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String actualizar(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminar(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario validarIngreso(int documeno, String clave) {
        Usuario session_user = null;
        try {
            //SELECT u.*, m.especialidad FROM usuario u INNER JOIN medico m ON u.cedula = m.cedula WHERE u.cedula = 1233894585 and u.clave = '123'
            String query = "SELECT u.*, m.especialidad FROM usuario u INNER JOIN medico m ON u.cedula = m.cedula WHERE u.cedula = ? and u.clave = ?";
            PreparedStatement st = Conexion.Conexion.getConexion().prepareStatement(query);
            st.setInt(1, documeno);
            st.setString(2, clave);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                session_user = new Medico();
                session_user.setCedula(rs.getInt(Constantes.USER_COLUMN1));
                session_user.setNombre(rs.getNString(Constantes.USER_COLUMN2));
                session_user.setApellido(rs.getString(Constantes.USER_COLUMN3));
                session_user.setFecha_nacimiento(new Date(rs.getString(Constantes.USER_COLUMN4)));
                session_user.setDireccion(rs.getString(Constantes.USER_COLUMN5));
                session_user.setTelefono(rs.getLong(Constantes.USER_COLUMN6));
                session_user.setCorreo(rs.getString(Constantes.USER_COLUMN7));
                session_user.setSexo(rs.getString(Constantes.USER_COLUMN8).charAt(0));
                session_user.setUrl_foto(rs.getString(Constantes.USER_COLUMN9));                
            }
            Conexion.Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Excepcion: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Excepcion: " + e.getMessage());
        }
        return session_user;
    }
    
}
