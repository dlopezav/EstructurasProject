/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Hamed, Diego, David
 */
public class Boleta {
    private int Zona;
    private String nombreConcierto;

    public Boleta(int Zona, String nombreConcierto) {
        this.Zona = Zona;
        this.nombreConcierto = nombreConcierto;
    }

    public int getZona() {
        return Zona;
    }

    public void setZona(int Zona) {
        this.Zona = Zona;
    }

    public String getNombreConcierto() {
        return nombreConcierto;
    }

    public void setNombreConcierto(String nombreConcierto) {
        this.nombreConcierto = nombreConcierto;
    }

    

    
    
}
