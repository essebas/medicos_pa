/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author zebas
 */
public interface IUsuarioDao {
    public List<Usuario> listar();
    public String insertar(Usuario user);
    public String actualizar(Usuario user);
    public String eliminar(Usuario user);
    
    public Usuario validarIngreso(int documeno, String clave);
}
