/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Date;

/**
 *
 * @author Hamed, Diego, David
 */
public class Boleta {
    private Date fecha;
    private String nombreConcierto;

    public Boleta( Date fecha, String nombreConcierto) {
        this.fecha = fecha;
        this.nombreConcierto = nombreConcierto;
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

    
    
}
