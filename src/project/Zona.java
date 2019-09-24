/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;

/**
 *
 * @author Hamed
 */
public class Zona {
    private int cupos;
    private int numero;
    private int precio;
    private ArrayList<Boleta> boletas;

    public Zona(int cupos, int numero, int precio, ArrayList<Boleta> boletas) {
        this.cupos = cupos;
        this.numero = numero;
        this.precio = precio;
        this.boletas = boletas;
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
    
    
}
