/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author zebas
 */
public class Consultorio {
    private int id_consultorio;
    private int numero_consultorio;
    private Medico medico;

    public Consultorio() {
    }

    public Consultorio(int id_consultorio, int numero_consultorio, Medico medico) {
        this.id_consultorio = id_consultorio;
        this.numero_consultorio = numero_consultorio;
        this.medico = medico;
    }

    public int getId_consultorio() {
        return id_consultorio;
    }

    public void setId_consultorio(int id_consultorio) {
        this.id_consultorio = id_consultorio;
    }

    public int getNumero_consultorio() {
        return numero_consultorio;
    }

    public void setNumero_consultorio(int numero_consultorio) {
        this.numero_consultorio = numero_consultorio;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    
    
}
