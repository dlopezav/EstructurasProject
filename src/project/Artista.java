/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Hamed, Diego, David
 */
public class Artista {
    private String generoMusical;
    private String nombre;
    private int integrantes;

  
    public Artista(String generoMusical, String nombre, int integrantes) {
        this.generoMusical = generoMusical;
        this.nombre = nombre;
        this.integrantes = integrantes;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(int integrantes) {
        this.integrantes = integrantes;
    }
    
    
    
    
}
