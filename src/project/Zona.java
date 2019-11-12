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
 * @author Hamed
 */
public class Zona {
    private int cupos;
    private int numero;
    private int precio;
    private String NombreConcierto;
    private boolean VIP;
    private ArrayList<Boleta> boletas;

    public Zona(int cupos, int numero, int precio, String nombre, boolean VIP) {
        this.cupos = cupos;
        this.numero = numero;
        this.precio = precio;
        this.NombreConcierto = nombre;
        this.boletas = new ArrayList<>();
        this.VIP = VIP;
        if(!VIP){
            for(int i=0; i<cupos; i++){
               boletas.add(new Boleta(numero, nombre));
            }
        }else{
            for(int i=0; i<cupos; i++){
               boletas.add(new BoletaVIP(i, true, true, numero, nombre));
            }
        }
        
    }
    public int getCupos() {
        return cupos;
    }
    public void setCupos(int cupos) {
        this.cupos = cupos;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
        
    }
    public ArrayList<Boleta> getBoletas() {
        return boletas;
    }
    public void setBoletas(ArrayList<Boleta> boletas) {
        this.boletas = boletas;
    }
    
    public void comprar(ArrayList<Boleta> boletas){
        this.cupos=this.cupos-boletas.size();
    }
   
    
}
