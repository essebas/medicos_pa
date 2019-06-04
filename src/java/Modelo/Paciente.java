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
public class Paciente extends Usuario{
    private String tipo;
    private double peso;
    private double altura;  

    public Paciente() {
    }

    public Paciente(String tipo, double peso, double altura, int cedula, String nombre, String apellido, Date fecha_nacimiento, String direccion, Long telefono, String correo, char sexo, String url_foto, String clave) {
        super(cedula, nombre, apellido, fecha_nacimiento, direccion, telefono, correo, sexo, url_foto, clave);
        this.tipo = tipo;
        this.peso = peso;
        this.altura = altura;
    }   

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
        
}
