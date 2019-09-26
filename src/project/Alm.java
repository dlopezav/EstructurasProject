/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class Alm {
    private Chain<Concierto> conciertos = new Chain<>();
    private Chain<Persona> personas = new Chain<>();

    public Alm( Chain<Concierto> conciertos, Chain<Persona> personas ) {
        this.conciertos = conciertos;
        this.personas = personas;
    }

    public Chain<Concierto> getConciertos() {
        return conciertos;
    }

    public void setConciertos(Chain<Concierto> conciertos) {
        this.conciertos = conciertos;
    }

    public Chain<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Chain<Persona> personas) {
        this.personas = personas;
    }

    public Boolean[] verificarPersona(String correo, String contrasena){
        Boolean[] confirmacion = new Boolean[2];
        for(int i=0; i<personas.size;i++){
            if(correo == personas.get(i).getCorreo() && personas.get(i).getContrasena() == contrasena ){
                confirmacion[0]=true; 
            }
            confirmacion[1]=personas.get(i).getRol();
        }
        return confirmacion;
    }
    public String mostrarZonas(int nombre){
        for(int i=0;i<conciertos.size;i++){
            if(conciertos.get(i).getNombre().equals(nombre)){
                for(int j=0; j<conciertos.get(i).getZonas().size();j++){
                    System.out.println("Zona "+conciertos.get(i).getZonas().get(j).getNumero() +": "+conciertos.get(i).getZonas().get(j).getCupos());
                }
            }
        }
        return null;
    }
    
    public void comprar(ArrayList<Boleta> boleta){
        
    }
    
    
    
}