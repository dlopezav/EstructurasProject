/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Hamed
 */
public class Concierto {
    private Date fecha;
    private String nombre;
    private ArrayList<Artista> artistas;
    private ArrayList<Persona> asistentes;
    private ArrayList<Zona> zonas;
    private String hora;

    
    
    
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(ArrayList<Artista> artistas) {
        this.artistas = artistas;
    }

    public ArrayList<Persona> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(ArrayList<Persona> asistentes) {
        this.asistentes = asistentes;
    }

    public ArrayList<Zona> getZonas() {
        return zonas;
    }

    public void setZonas(ArrayList<Zona> zonas) {
        this.zonas = zonas;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
}
