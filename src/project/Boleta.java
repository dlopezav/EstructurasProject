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
    private int Zona;
    private int nombreConcierto;

    public Boleta(int Zona, int nombreConcierto) {
        this.Zona = Zona;
        this.nombreConcierto = nombreConcierto;
    }

    public int getZona() {
        return Zona;
    }

    public void setZona(int Zona) {
        this.Zona = Zona;
    }

    public int getNombreConcierto() {
        return nombreConcierto;
    }

    public void setNombreConcierto(int nombreConcierto) {
        this.nombreConcierto = nombreConcierto;
    }

    

    
    
}
