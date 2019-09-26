/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.util.*;
/**
 *
 * @author Hamed, Diego, David
 */
public class Project {
    
    public static void menu_ingreso(){
        System.out.println("------BIENVENIDO AL MENU DE INGRESO-------");
    };
            
    public static void menu_registro(){
        System.out.println("------BIENVENIDO AL MENU DE REGISTRO-------");
    };
    
    public static void menu_inicial(){
        System.out.println("------BIENVENIDO AL MENU INICIAL-------");
        System.out.println("1. Ingresar");
        System.out.println("2. Registrarse");
        System.out.println("3. Salir");
        
        System.out.println("\n Ingrese la opción deseada:");
        Scanner scan = new Scanner(System.in);
        int opc =scan.nextInt();
        switch (opc){
            case 1:
                System.out.println("\n \n");
                menu_ingreso();
            break;
            case 2: 
                System.out.println("\n \n");
                menu_registro();
            break;
            case 3:
                System.out.println("\n \n");
                System.out.println("GRACIAS POR SU VISITA!");
            break; 
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*Random rdn = new Random();
        int[] h= new int[6];
        for(int i = 0; i<6; i++){
            h[i]=(int)(rdn.nextDouble()*26 + 97);
        }
        for(int i = 0; i<6; i++){
            System.out.println((char)h[i]);
        }
        System.out.println("fin");
        */
        
        menu_inicial();
      
    }
    
}
