/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Date;

/**
 *
 * @author Hp
 */
public class BoletaVIP extends Boleta {
    
    private int numSilla;
    private Boolean estadoReserva;
    private Boolean estado;

    public BoletaVIP(int numSilla, Date fecha, String nombreConcierto, Boolean estado) {
        super(fecha, nombreConcierto);
        this.numSilla = numSilla;
    }
    public int getNumSilla() {
        return numSilla;
    }
    public void setNumSilla(int numSilla) {
        this.numSilla = numSilla;
    }

    public Boolean getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(Boolean estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    
   
   
    
}
