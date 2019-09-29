

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
    static Alm alma;
    static Persona Admin;
    static Chain<Concierto> conciertos = new Chain<>();
    static Chain<Persona> personas = new Chain<>();
    
    static{
        alma = new Alm(conciertos, personas);
        Admin =  new Persona("Admin", "admin@admin.com", "1234", 10254621, 32145655, "20/05/1990", "M", "Famisanar", true);
        alma.getPersonas().add(0, Admin);
    }
    
    public static void menu_ingreso(){
        Scanner scan = new Scanner(System.in);
        System.out.println("------BIENVENIDO AL MENU DE INGRESO-------");
        System.out.println("Ingrese su correo: ");
        String usuario=scan.next();
        System.out.println("Ingrese su contrasena: ");
        String contra=scan.next();
        boolean[] dates = new boolean[2];
        dates = alma.verificarPersona(usuario, contra);
        if(dates[0]){
            if(dates[1]){
                menu_admin();
            }else{
                menu_comprar();
            }
        }else{
            
            System.out.println("\n ¡¡el ususario o la contrasena no coinciden!! \n");
            menu_ingreso();
        }
    };
    
    public static void menu_admin(){
        Scanner scan = new Scanner(System.in);
        boolean ban = true;
        do{
            System.out.println("-------BIENVENIDO AL MENU DE ADMINISTRADOR-------");
            System.out.println("1. Crear concierto");
            System.out.println("2. Crear Artista");
            System.out.println("3. Modificar precios");
            System.out.println("4. Eliminar concierto");
            System.out.println("5. Eliminar artistas");
            System.out.println("6. Salir");
           
             System.out.println("\n Seleccione su opción: ");
            int opc = scan.nextInt();
            switch(opc){
                case 1:
                    crear_concierto();
                    break;
                    
                case 2:
                    crear_artista();
                    break;
                    
                case 3:
                    modificar_precios();
                    break;
                    
                case 4:
                    eliminar_concierto();
                    break;
                    
                case 5:
                    eliminar_artista();
                    break;
                    
                case 6:
                    menu_inicial();
                    ban= false;
                    break;

                default:
                        System.out.println("Opcion invalida!");
                    break;
            }
        }while(ban);
    }
    
    public static void crear_concierto(){
        Scanner scan = new Scanner(System.in);
        String fecha;
        String nombre;
        ArrayList<Artista> artistas;
        ArrayList<Zona> zonas;
        String hora;
        System.out.println("Ingrese el nombre del concierto");
    };
    
    public static void crear_artista(){
        Scanner scan = new Scanner(System.in);
        String genero;
        String nombre;
        int cantidad;
        System.out.println("Ingrese el genero del Artista:");
        genero = scan.next();
        System.out.println("Ingrese el nombre del Artista:");
        nombre = scan.next();
        System.out.println("Ingrese el numero de integrantes del Artista:");
        cantidad = scan.nextInt();
        Artista art = new Artista(genero, nombre,cantidad);
        
    };
    
    public static void modificar_precios(){
        
    };
    
    public static void eliminar_concierto(String nombre){
        for(int i=0;i<conciertos.size;i++){
            if(conciertos.get(i).getNombre().equals(nombre)){
                conciertos.remove(i);
            }
        }
    };
    
    public static void eliminar_artista(){
        
    };

    /* NO TEMINADO!!! */
    public static void menu_comprar(){
        Scanner scan = new Scanner(System.in);
        System.out.println("------BIENVENIDO AL MENU DE COMPRAR-------");
        
        alma.mostrar_Conciertos();
        System.out.println("Escriba el nombre del concierto: ");
        
        String opcCon = scan.nextLine();
        int bandera=0;
        boolean corte = true;
        
        for(int i = 0; i<alma.getConciertos().size() && corte; i++){
            if(alma.getConciertos().get(i).getNombre().equals(opcCon)){
                bandera = i;
                corte = false;
            }
        }
        if(corte){
            System.out.println("El concierto seleccionado no existe!");
            menu_comprar();
        }else{
            alma.mostrarZonas(alma.getConciertos().get(bandera).getNombre());
        }
        int opcZon = 0;
        int numeroDeBoletas;
        boolean corte2=true;
        do{
            System.out.println("Seleccione la zona: ");
            opcZon = scan.nextInt();
        
            if(opcZon== alma.getConciertos().get(bandera).getZonas().get(opcZon).getNumero()){
                do{
                    System.out.println("Ingrese el numero de Boletas que desea comprar:");
                    numeroDeBoletas = scan.nextInt();
                    if(numeroDeBoletas<=alma.getConciertos().get(bandera).getZonas().get(opcZon).getCupos()){
                       corte2=false; 
                    }else{
                        System.out.println("No hay suficientes boletas, seleccione un numero menor de boletas");
                    }
                }while(corte2);
            }else{
                System.out.println("Opción invalida! \n");
            }
        }while(opcZon != alma.getConciertos().get(bandera).getZonas().get(opcZon).getNumero());
    }
    
    
    public static void menu_registro(){
        Scanner scan = new Scanner(System.in);

        System.out.println("------BIENVENIDO AL MENU DE REGISTRO-------");
        System.out.println("Ingrese su Nombre Completo: ");
        String NombreCompleto = scan.next();
        System.out.println("Ingrese su Correo: ");
        String correo = scan.next();
        System.out.println("Ingrese su Contrasena: ");
        String contrasena = scan.next();
        System.out.println("Ingrese su Cedula: ");
        long cedula = scan.nextLong();
        System.out.println("Ingrese su Celular: ");
        long celular = scan.nextLong();
        System.out.println("Ingrese su fecha de nacimiento: ");
        System.out.println("Ingrese el dia: ");
        String dia = scan.next();
        System.out.println("Ingrese el mes: ");
        String mes = scan.next();
        System.out.println("Ingrese el annio: ");
        String annio = scan.next();
        String fechaNacimiento = (dia + "/" + mes + "/" + annio);
        System.out.println("Ingrese su genero (F/M/O): ");
        String genero = scan.next();
        System.out.println("Ingrese el nombre de su EPS o sisben: ");
        String EPS = scan.next();
        
        Persona per = new Persona(NombreCompleto, correo, contrasena, cedula, celular, fechaNacimiento, genero, EPS, false);
        
        alma.getPersonas().add(alma.getPersonas().size()-1,per);
        
        menu_inicial();
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
            
            default:
                System.out.println("\n Opción invalida!!\n");
                menu_inicial();
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