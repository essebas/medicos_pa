/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author zebas
 */
public class Medico extends Usuario{
    private String especialidad;

    public Medico() {
    }

    public Medico(String especialidad, int cedula, String nombre, String apellido, Date fecha_nacimiento, String direccion, Long telefono, String correo, char sexo, String url_foto, String clave) {
        super(cedula, nombre, apellido, fecha_nacimiento, direccion, telefono, correo, sexo, url_foto, clave);
        this.especialidad = especialidad;
    }    

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
}
