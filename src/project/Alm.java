/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class Alm implements Serializable{
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

    public boolean[] verificarPersona(String correo, String contrasena){
        boolean[] confirmacion = new boolean[2];
        for(int i=0; i<personas.size;i++){
            if((personas.get(i).getCorreo().equals(correo)) && (personas.get(i).getContrasena().equals(contrasena))){
                confirmacion[0]=true;
                confirmacion[1]=personas.get(i).getRol();
            }
        }
        return confirmacion;
    }
    
    public void mostrarZonas(String nombre){
        for(int i=0;i<conciertos.size;i++){
            if(conciertos.get(i).getNombre().equals(nombre)){
                for(int j=0; j<conciertos.get(i).getZonas().size();j++){
                    System.out.println("Zona "+conciertos.get(i).getZonas().get(j).getNumero() +", cupos: "+conciertos.get(i).getZonas().get(j).getCupos()+", precio: "+conciertos.get(i).getZonas().get(j).getPrecio() );
                }
            }
        }
    }
    
    public void comprar(ArrayList<Boleta> boleta){
        
    }
    
    public boolean disponible(Zona zone, int cuposQ){
        if(zone.getCupos() < cuposQ){
            return false;
        }else{
            return true;
        }
    }
    
    public void reservar(ArrayList<Boleta> boleta){
        
    }
    
    public void mostrar_Conciertos(){
        for(int i = 0; i<conciertos.size(); i++){
            System.out.println(i+". "+conciertos.get(i).getNombre());
        }
    }
}
