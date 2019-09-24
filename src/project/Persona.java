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
public class Persona {
    private String NombreCompleto;
    private String correo;
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
    
    
            
};
