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
    private Date fechaNacimiento;
    private String genero;
    private String EPS;

    public Persona(String NombreCompleto, String correo, int cedula, int celular, Date fechaNacimiento, String genero, String EPS) {
        this.NombreCompleto = NombreCompleto;
        this.correo = correo;
        this.cedula = cedula;
        this.celular = celular;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.EPS = EPS;
        this.boleta = new ArrayList<>();
    };
    
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
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
    
    
            
};
