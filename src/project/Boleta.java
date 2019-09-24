/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Date;

/**
 *
 * @author Hamed
 */
public class Boleta {
    private int numSilla;
    private int Seccion;
    private Date fecha;
    private String nombreConcierto;
    private Boolean estado;

    public Boleta(int numSilla, int Seccion, Date fecha, String nombreConcierto, Boolean estado) {
        this.numSilla = numSilla;
        this.Seccion = Seccion;
        this.fecha = fecha;
        this.nombreConcierto = nombreConcierto;
        this.estado = estado;
    }

    public int getNumSilla() {
        return numSilla;
    }

    public void setNumSilla(int numSilla) {
        this.numSilla = numSilla;
    }

    public int getSeccion() {
        return Seccion;
    }

    public void setSeccion(int Seccion) {
        this.Seccion = Seccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreConcierto() {
        return nombreConcierto;
    }

    public void setNombreConcierto(String nombreConcierto) {
        this.nombreConcierto = nombreConcierto;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
    
    
    
    
}
