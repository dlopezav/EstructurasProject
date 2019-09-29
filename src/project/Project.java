/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Hamed, Diego, David
 */
public class Project implements Serializable{
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
                menu_admin(usuario, contra);
            }else{
                for(int i=0; i<alma.getPersonas().size;i++){
                    if((alma.getPersonas().get(i).getCorreo().equals(usuario)) && (alma.getPersonas().get(i).getContrasena().equals(contra))){
                            menu_persona(personas.get(i));
                    }
                }
            }
        }else{
            
            System.out.println("\n ¡¡el ususario o la contrasena no coinciden o no existen!! \n");
            menu_inicial();
        }
    };
    
    public static void menu_admin(String usuario, String contra){
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
                    crear_concierto(usuario, contra);
                    break;
                    
                case 2:
                    modificar_precios();
                    break;
                    
                case 3:
                    alma.mostrar_Conciertos();
                    System.out.println("Ingrese el concierto a eliminar: ");
                    String conElm = scan.nextLine();
                    conElm = scan.nextLine();
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
    
    public static void crear_concierto(String usuario, String contra){
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
            System.out.println("\n \n Ingrese el numero de cupos por esta zona( " + cod[i] +" )");
            cupos = scan.nextInt();
            System.out.println("Ingrese el precio para la zona: ( " + cod[i] +" )");
            precio = scan.nextInt();
            System.out.println("Esta zona ( " + cod[i] +" ) sera VIP? (si/no)");
            
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
        
        System.out.println("\n Ingrese cuantas artistas va a tener el concierto: ");
        int numArt = scan.nextInt();
        for (int i = 0; i < numArt; i++) {
            artistas.add(crear_artista());
        }
        con = new Concierto(fecha, nombre, artistas, null, zonas, hora);
        alma.getConciertos().add(0, con);
        menu_admin(usuario, contra);
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
    public static void menu_comprar(Persona persona){
        Scanner scan = new Scanner(System.in);
        System.out.println("------BIENVENIDO AL MENU DE COMPRAR-------");
        
        alma.mostrar_Conciertos();
        System.out.println("Escriba el nombre del concierto: ");
        
        String opcCon = scan.nextLine();
        int bandera=0;
        boolean corte = true;
        if(alma.getConciertos().size()==0){
            System.out.println("\n No hay conciertos disponibles!! \n");
            menu_persona(persona);
        }else{
            for(int i = 0; i<alma.getConciertos().size() && corte; i++){
                if(alma.getConciertos().get(i).getNombre().equals(opcCon)){
                    bandera = i;
                    corte = false;
                }
            }
            if(corte){
                System.out.println("El concierto seleccionado no existe!");
                menu_persona(persona);
            }else{
                menu_zona(bandera, persona);
                
                menu_persona(persona);
            }
        }
    }
    
    public static Zona menu_zona(int bandera, Persona usuario){
        Scanner scan = new Scanner(System.in);
        
        alma.mostrarZonas(alma.getConciertos().get(bandera).getNombre());
        int opcZon = 0;
        int numeroDeBoletas;
        boolean corte2=true;
        ArrayList<Boleta> bolCom= new ArrayList();
        do{
            System.out.println("Seleccione la zona: ");
            opcZon = scan.nextInt();
            if(alma.getConciertos().get(bandera).size()>=opcZon/100){
                if(opcZon== alma.getConciertos().get(bandera).getZonas().get(opcZon-100).getNumero()){
                    do{
                        System.out.println("Ingrese el numero de Boletas que desea comprar:");
                        numeroDeBoletas = scan.nextInt();
                        
                        System.out.println("\n El costo es:"+ alma.getConciertos().get(bandera).getZonas().get(opcZon-100).getPrecio()*numeroDeBoletas);
                        
                        System.out.println("\nDesea confirmar la compra? (si/no)");
                        String confir = scan.next();
                        
                        if(confir.equals("si")){
                            if(numeroDeBoletas<=alma.getConciertos().get(bandera).getZonas().get(opcZon-100).getCupos()){
                                corte2=false; 
                                alma.getConciertos().get(bandera).getZonas().get(opcZon-100).setCupos(alma.getConciertos().get(bandera).getZonas().get(opcZon-100).getCupos()-numeroDeBoletas);
                                for (int i = 0; i < alma.getPersonas().size(); i++) {
                                    if(alma.getPersonas().get(i).getCorreo().equals(usuario.getCorreo())){
                                        for (int j = 0; j < numeroDeBoletas; j++) {
                                            bolCom.add(alma.getConciertos().get(bandera).getZonas().get(opcZon-100).getBoletas().get(i));
                                        }
                                        alma.getPersonas().get(i).setBoleta(bolCom);
                                        System.out.println(alma.getPersonas().get(i).getBoleta().get(0).getNombreConcierto() + "\n" +
                                                alma.getPersonas().get(i).getBoleta().get(0).getZona());
                                        if(alma.getPersonas().get(i).getBoleta().size()==numeroDeBoletas){
                                            System.out.println("\nCompra realizada satisfactoriamente!\n");
                                        }
                                    }
                                }
                            }else{
                                System.out.println("\n \n No hay suficientes boletas, seleccione un numero menor de boletas \n \n");
                            }
                        }else{
                            System.out.println("\n");
                        }
                        
                    }while(corte2);
                }else{
                    System.out.println("Opción invalida! \n");
                }
            }else{
                System.out.println("Opción invalida! \n");
            }
        }while(opcZon != alma.getConciertos().get(bandera).getZonas().get(opcZon-100).getNumero());
        menu_inicial();
        return null;
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
        
        alma.getPersonas().add(0,per);
        
        System.out.println("\n Usuario creado satisfactoriamente! \n");
        
        menu_inicial();
    };
    
    public static void menu_persona(Persona persona){
        Scanner scan = new Scanner(System.in);

        System.out.println("------BIENVENIDO A SU PERFIL-------");
        System.out.println("1. Comprar");
        System.out.println("2. Ver información de boletas compradas");
        System.out.println("3. Ver información personal");
        System.out.println("4. Salir");
        Scanner menu = new Scanner(System.in);
        int opc =menu.nextInt();
        switch (opc){
            case 1:
                menu_comprar(persona);
            break;
            case 2: 
                for(Boleta e: persona.getBoleta()){
                    System.out.println("Boleta para la zona: "+e.getZona());
                    e.getNombreConcierto();
                }
                menu_persona(persona);
            break;
            case 3:
                System.out.println("Usuario:");
                System.out.println(persona.getCorreo());
                System.out.println("EPS:");
                System.out.println(persona.getEPS());
                System.out.println("Genero:");
                System.out.println(persona.getGenero());
                System.out.println("Cedula:");
                System.out.println(persona.getCedula());
                System.out.println("Fecha de nacimiento:");
                System.out.println(persona.getFechaNacimiento());
                menu_persona(persona);
            break; 
            case 4:
                menu_inicial();
            break; 
            default:
                System.out.println("\n Opción invalida!!\n");
                menu_persona(persona);
                break;
        }
        
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
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
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
        File conci= new File("Memoria/conciertos.txt");
        File perso = new File("Memoria/personas.txt");
        
        if(conci.exists()&&perso.exists()){
            ObjectInputStream recibir = new ObjectInputStream(new FileInputStream(new File("Memoria/conciertos.txt")));
            ObjectInputStream recibir2 = new ObjectInputStream(new FileInputStream(new File("Memoria/personas.txt")));
            alma.setConciertos((Chain<Concierto>) recibir.readObject());
            alma.setPersonas((Chain<Persona>) recibir2.readObject());
            recibir2.close();
            recibir.close();
            
        }
        
        menu_inicial();
        Guardar(alma.getPersonas(),alma.getConciertos());
      
    }
    private static void Guardar(Chain<Persona> per,Chain<Concierto> conc) throws IOException {
        ObjectOutputStream escribir= new ObjectOutputStream(new FileOutputStream(new File("Memoria/conciertos.txt")));
            escribir.writeObject(conc);
            escribir.close();
        ObjectOutputStream escribir2= new ObjectOutputStream(new FileOutputStream(new File("Memoria/personas.txt")));
            escribir2.writeObject(per);
            escribir2.close();
    }
}
