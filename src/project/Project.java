

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
            System.out.println("2. Modificar precios");
            System.out.println("3. Elminar concierto");
            System.out.println("4. Salir");
           
             System.out.println("\n Seleccione su opción: ");
            int opc = scan.nextInt();
            switch(opc){
                case 1:
                    crear_concierto();
                    break;
                    
                case 2:
                    modificar_precios();
                    break;
                    
                case 3:
                    System.out.println("Ingrese el concierto a eliminar: ");
                    String conElm = scan.nextLine();
                    eliminar_concierto(conElm);
                    break;

                case 4:
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
        Concierto con;
        ArrayList<Artista> artistas = new ArrayList();
        ArrayList<Zona> zonas = new ArrayList();
        System.out.println("Ingrese el nombre del concierto: ");
        String nombre = scan.nextLine();
        System.out.println("Ingrese la fecha del concierto formato DD/MM/AAAA: ");
        String fecha = scan.nextLine();
        System.out.println("Ingrese la hora del concierto: ");
        String hora = scan.nextLine();
        System.out.println("Ingrese cuantas zonas va a tener el concierto: ");
        int numZon = scan.nextInt();
        int[] cod = new int[numZon];
        for (int i = 0; i < numZon; i++) {
            cod[i]=100+i;
        }
        Zona auxZona;
        int cupos;
        int numero;
        int precio;
        boolean VIP;
        ArrayList<Boleta> boletas;
        Boleta bol;
        for (int i = 0; i < numZon; i++) {
            boletas = new ArrayList();
            System.out.println("Ingrese el numero de cupos por esta zona( " + cod[i] +" )");
            cupos = scan.nextInt();
            System.out.println("Ingrese el precio para la zona: ( " + cod[i] +" )");
            precio = scan.nextInt();
            System.out.println("Esta zona ( " + cod[i] +" ) sera VIP? (si/no)");
            scan.next();
            String res = scan.next();
            if(res.equals("si")){
                VIP=true;
            }else{
                VIP=false;
            }
            for (int j = 0; j < cupos; j++) {
                bol = new Boleta(cod[i], nombre);
                boletas.add(bol);
            }
            auxZona = new Zona(cupos, cod[i], precio, nombre, VIP);
            zonas.add(auxZona);
        }
        
        System.out.println("Ingrese cuantas artistas va a tener el concierto: ");
        int numArt = scan.nextInt();
        for (int i = 0; i < 10; i++) {
            artistas.add(crear_artista());
        }
        con = new Concierto(fecha, nombre, artistas, null, zonas, hora);
        menu_admin();
    };
    
    public static Artista crear_artista(){
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
        
        return art;
    };
    
    public static void modificar_precios(){
        Scanner scan = new Scanner(System.in);
        System.out.println("------BIENVENIDO AL MENU DE MODIFICAR PRECIOS-------");
        
        alma.mostrar_Conciertos();
        System.out.println("Escriba el nombre del concierto: ");
        
        String opcCon = scan.nextLine();
        System.out.println("Escriba el porcentaje de cambio en los precios del concierto: ");
        int prc = scan.nextInt();
        for(int i = 0; i<alma.getConciertos().size(); i++){
            if(alma.getConciertos().get(i).getNombre().equals(opcCon)){
                alma.getConciertos().get(i).cambiarPrecio(prc);
            }
        }
        
    };

    public static void eliminar_concierto(String nombre){
        for(int i=0;i<conciertos.size;i++){
            if(conciertos.get(i).getNombre().equals(nombre)){
                conciertos.remove(i);
            }
        }
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
