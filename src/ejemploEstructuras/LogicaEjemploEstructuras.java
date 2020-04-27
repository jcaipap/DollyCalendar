
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploEstructuras;

import data.Actividad;
import data.Casilla;
import data.Grupo;
import data.Materia;
import data.Persona;
import data.Usuario;
import java.util.Scanner;
import estructuas.QueueArrayGeneric;
import estructuas.StackArrayGeneric;
import estructuas.LinkedListGeneric;
import estructuas.ListArrayGeneric;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;


/**
 *
 * @author andre
 */

public class LogicaEjemploEstructuras {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
       
        //Pruebas de E.Time
        //si tomas un usuario y le pulsas .toStringAdmin(), saldrá impreso el 
        //estudiante y una seccion que dice Admin y tiene la contra
        
        Scanner scanner = new Scanner(System.in);
        
        Persona admin1 = new Persona("a1", "c1", 1, "nombre1", "apellido1", "correo1");
        Persona admin2 = new Persona("a2", "c2", 2, "nombre1", "apellido1", "correo1");
        Persona admin3 = new Persona("a3", "c3", 3, "nombre1", "apellido1", "correo1");
        Usuario est1 = new Usuario("u1", "c1", 1, "nombre", "apellido", "apellido", "as");
        Usuario est2 = new Usuario("u2", "c2", 2, "nombre", "apellido", "apellido", "as");
        Usuario est3 = new Usuario("u3", "c3", 3, "nombre", "apellido", "apellido", "as");
        
        ListArrayGeneric<Persona> admins = new ListArrayGeneric<>(3);
        ListArrayGeneric<Persona> estudiantes = new ListArrayGeneric<>(3);
        admins.insert(admin1);
        admins.insert(admin2);
        admins.insert(admin3);
        estudiantes.insert(est1);
        estudiantes.insert(est2);
        estudiantes.insert(est3);
        

        LinkedListGeneric<Casilla> casillas= new LinkedListGeneric<>();
        
        boolean continuar = true;
        String usuario;
        String contraseña;
        
        //inicio del programa, continue es para salirse o continuar, se cambia con la funcion seguir();
 
        while(continuar){
            limpiarConsola();
            System.out.println("Bienvenido a DollyCalendar, por favor seleccione entre las siguientes opciones:\n\n");
            System.out.println("1. Estudiante\n2. Administrador\n3. Salir");
            int inicio = scanner.nextInt();
            switch(inicio){
                
                case 1:
                    System.out.println("Usted ha ingresado como estudiante, por favor ingrese los siguientes datos personales");
                    System.out.println("Ingrese su usuario:");
                    usuario = scanner.next();
                    System.out.println("Ingrese su contraseña:");
                    contraseña = scanner.next();
                    
                    if(!autenticar(usuario, contraseña, estudiantes)){
                        limpiarConsola();
                        System.out.println("Usuario o contraseña incorrectos, volviendo a pantalla inicial\n");
                        continuar=seguir();
                        break;
                    }
                    limpiarConsola();
                    System.out.println("Estudiante validado correctamente");
                    
                    continuar=seguir();
                    
                    break;
                    
                case 2:
                    System.out.println("Usted ha ingresado como administrador, por favor ingrese los siguientes datos personales");
                    System.out.println("Ingrese su usuario:");
                    usuario = scanner.next();
                    System.out.println("Ingrese su contraseña:");
                    contraseña = scanner.next();
                    
                    if(!autenticar(usuario, contraseña, admins)){
                        limpiarConsola();
                        System.out.println("Usuario o contraseña incorrectos, volviendo a pantalla inicial\n");
                        continuar=seguir();
                        break;
                    }
                    limpiarConsola();
                    System.out.println("Administrador validado correctamente\n");
                    opcionesAdmin(estudiantes, casillas);

                    continuar=seguir();
                    
                    break;
                    
                case 3:
                    continuar=false;
                    limpiarConsola();
                    System.out.println("Usted ha salido con éxito.");
                    break;
                    
                default:
                    continuar=false;
                    limpiarConsola();
                    System.out.println("Opción invalida");
                    continuar=seguir();
                    break;
                
            }

        }
    }
    
    
    /*
    static void pruebaLinkedList(){
        LinkedListGeneric<Persona> testerLinkedlist= new LinkedListGeneric<>();
        LinkedListGeneric<Casilla> casillas= new LinkedListGeneric<>();
        Persona andres= new Usuario("aholguinr","contra",casillas,"meca",2, "Andres","Holguin", "aholguinr");
        testerLinkedlist.insert(new Usuario("aholguinr","contra",casillas,"meca",2, "Andres","Holguin", "aholguinr"));
        testerLinkedlist.insert(andres);
        testerLinkedlist.printRecursive();
        String[] coments= new String[2];
        coments[0]="A";
        coments[1]="B";
        Actividad actividad1= new Actividad(coments,"Parcial", "Parcial1", 4, calendarGenerator(2020,5,13,5,0), calendarGenerator(2020,5,13,7,0));
        Materia materia1=new Materia("15b", 4,"Disciplinar", 5, "David", "Estructuras", "clase ED", 4,calendarGenerator(2020,2,12,6,0),calendarGenerator(2020,2,12,8,0));
        casillas.insert(actividad1);
        casillas.insert(materia1);
        modifySpot(actividad1,casillas);
        System.out.println(casillas.size());
        casillas.printRecursive();
    }
    static void pruebasCasillasComplejas(int testerNum){
        long startTime=System.nanoTime();
        LinkedListGeneric<Casilla> casillas= new LinkedListGeneric<>();
        StackArrayGeneric<Casilla> stackCasillas=new StackArrayGeneric<>(testerNum);
        QueueArrayGeneric<Casilla> queueCasillas=new QueueArrayGeneric<>(testerNum);
        System.out.println("Prueba con "+testerNum+" datos para casillas");
        for (int i=0;i<testerNum;i++){
            Casilla testerRec= new Casilla("Casilla de prueba", "Prueba de tiempos", 2, calendarGenerator(2020,2,12,5,0),calendarGenerator(2020,2,12,7,0));
            stackCasillas.push(testerRec);
        }
        long create=System.nanoTime()-startTime;
        System.out.println("Tiempo de creación de casillas: "+create);
   } */
    static void modifySpot(Casilla spot, LinkedListGeneric<Casilla> casillas){
        casillas.delete(spot);
        Casilla modified=spot;
        Scanner  scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
            System.out.println("Para modificar, pulse:" + "\n" + "Nombre: 1" + "  Descripción: 2 " + "   Importancia: 3");
        int s = scanner.nextInt();
        switch (s) {
            case (1):
                System.out.println("ingrese el nuevo nombre");
                modified.setTitulo(scanner.next());
                break;
            case (2):
                System.out.println("ingrese la nueva descripcion");
                modified.setDescripcion(scanner.next());
                break;
            case (3):
                System.out.println("ingrese el nuevo grado de importancia");
                int value=scanner.nextInt();
                while(value>5){
                    System.out.println("El grado de importancia es mayor a 5, intente de nuevo");
                    value=scanner.nextInt();
                }
                modified.setImportancia(value);
            default:
                break;
        }
        casillas.insert(modified);


    }
    static Calendar calendarGenerator(int año, int mes, int dia, int hora, int minuto){
        Calendar fecha = new GregorianCalendar(año, mes, dia, hora, minuto);
        return fecha;
    }
    static void limpiarConsola(){
        for(int i=0;i<75;i++){
            System.out.println("");
        }
    }
    
    static boolean autenticar(String usuario, String contraseña, ListArrayGeneric usuarios) {

        Persona p = new Persona();
        for (int i = 0; i < usuarios.size(); i++) {
            p = (Persona) usuarios.getItemInPosition(i);
            if (usuario.equals(p.getUsuario()) && contraseña.equals(p.getContraseña())) {
                return true;
            }
        }
        return false;
    }

    static boolean seguir() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la opción que desee realizar:\n1. Salir del programa\n2. Continuar y volver a inicio");
        if (scanner.nextInt() == 1) {
            return false;
        }
        return true;
    }

    static void opcionesAdmin(ListArrayGeneric estudiantes, LinkedListGeneric<Casilla> casillas) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione que opciones desea realizar:\n1. Ver estudiantes\n2. Ver cursos\n3. Salir");

        switch (scanner.nextInt()) {

            case 1:
                limpiarConsola();
                System.out.println("Usted ha seleccionado ver usuarios, a continuación se muestra la lista de los estudiantes existentes:");

                Usuario us1 = new Usuario();
                for (int i = 0; i < estudiantes.size(); i++) {
                    us1 = (Usuario) estudiantes.getItemInPosition(i);
                    System.out.println(us1.toString() + "\n");
                }

                break;

            case 2:
                limpiarConsola();
                System.out.println("Usted ha seleccionado ver cursos, a continuación se muestra la lista de los cursos existentes:");

                break;

            case 3:

                break;

            default:

                break;

        }

    }

    static void opcionesEst() {

    }
}