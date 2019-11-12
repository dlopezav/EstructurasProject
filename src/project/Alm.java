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
public class Alm {
    private Chain<Concierto> conciertos = new Chain<>();
    private Chain<Persona> personas = new Chain<>();
    private AVLtree personas2 = new AVLtree();

    public Alm( Chain<Concierto> conciertos, Chain<Persona> personas, AVLtree personas2 ) {
        this.conciertos = conciertos;
        this.personas = personas;
        this.personas2 = personas2;
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

    public boolean[] verificarPersona(long cedula, String contrasena){
        Persona persona = personas2.contains(cedula).getPer();
        boolean[] confirmacion = new boolean[2];
        if(persona!= null){
            if(persona.getContrasena().equals(contrasena)){
                confirmacion[0] = true;
            }else{
                confirmacion[0] = false;
            }
            confirmacion[1] = persona.getRol();
        }
        return confirmacion;
    }
    
    public void mostrarZonas(String nombre){
        for(int i=0;i<conciertos.size();i++){
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
        for(int i=0; i<conciertos.size;i++){
            System.out.println(i+". "+conciertos.get(i).getNombre());
        }
    }
    
    public AVLtree getPersonas2(){
        return personas2;
    }
}
