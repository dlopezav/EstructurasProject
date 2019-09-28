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
 * @author Hamed, Diego, David
 */
public class Persona {
    private String NombreCompleto;
    private String correo;
    private String contrasena; 
    private int cedula;   
    private int celular;
    private ArrayList<Boleta> boleta;        
    private String fechaNacimiento;
    private String genero;
    private String EPS;
    private Boolean rol;

    public Persona(String NombreCompleto, String correo, String contrasena, int cedula, int celular, String fechaNacimiento, String genero, String EPS, Boolean rol) {
        this.NombreCompleto = NombreCompleto;
        this.correo = correo;
        this.contrasena = contrasena;
        this.cedula = cedula;
        this.celular = celular;
        this.boleta = new ArrayList();
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.EPS = EPS;
        this.rol = rol;
    }
    

    public Boolean getRol() {
        return rol;
    }
    public void setRol(Boolean rol) {
        this.rol = rol;
    }
    public void asignarBoletas(ArrayList<Boleta> boleta){
        this.boleta = boleta;
    };
    public String getNombreCompleto() {
        return NombreCompleto;
    }
    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public int getCedula() {
        return cedula;
    }
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    public int getCelular() {
        return celular;
    }
    public void setCelular(int celular) {
        this.celular = celular;
    }
    public ArrayList<Boleta> getBoleta() {
        return boleta;
    }
    public void setBoleta(ArrayList<Boleta> boleta) {
        this.boleta = boleta;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getEPS() {
        return EPS;
    }
    public void setEPS(String EPS) {
        this.EPS = EPS;
    }
    
    public boolean verificarPersona(String correo, String contrasena){
        return true;
    }
    
    
            
};
