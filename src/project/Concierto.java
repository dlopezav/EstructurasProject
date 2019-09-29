/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Hamed, Diego, David
 */
public class Concierto implements Serializable{
    private String fecha;
    private String nombre;
    private ArrayList<Artista> artistas;
    private ArrayList<Persona> asistentes;
    private ArrayList<Zona> zonas;
    private String hora;

    public Concierto(String fecha, String nombre, ArrayList<Artista> artistas, ArrayList<Persona> asistentes, ArrayList<Zona> zonas, String hora) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.artistas = artistas;
        this.asistentes = asistentes;
        this.zonas = zonas;
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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
    public void cambiarPrecio(int prc){
        prc = prc/10;
        if(prc>0){
        for(Zona e: this.zonas){
            e.setPrecio(e.getPrecio()+(prc*(e.getPrecio())));
        }
        }else{
            for(Zona e: this.zonas){
            e.setPrecio(e.getPrecio()-(prc*(e.getPrecio())));
        }
        }
    }
}
