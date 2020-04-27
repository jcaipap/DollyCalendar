
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploEstructuras;

import data.Actividad;
import data.Administrador;
import data.Casilla;
import data.Grupo;
import data.Materia;
import data.Persona;
import data.Usuario;
import java.util.Scanner;
import estructuas.QueueArrayGeneric;
import estructuas.StackArrayGeneric;
import estructuas.LinkedListGeneric;
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
        
    }
    
    static void pruebasUsuariosStack(int testerNum){
        
        long startTime=System.nanoTime();
        LinkedListGeneric<Casilla> testerSpot= new LinkedListGeneric<>();
        HashMap <String,Grupo> testerGroups=new HashMap<>();
        System.out.println("Prueba con "+testerNum+" datos en StackArray");
        StackArrayGeneric <Usuario> testerStack=new StackArrayGeneric <>(testerNum);
        for(int i=0;i<testerNum;i++){
            Usuario testerUser= new Usuario("jcaipap", "f", testerSpot, "Mecatronica", 10100,"Julian", "Caipa", "jcaipap");
            testerStack.push(testerUser);
        }
        long create=System.nanoTime()-startTime;
        System.out.println("Tiempo de creación de usuarios y almacenamiento: "+create);
        for (int j=0;j<testerNum;j++){
            testerStack.pop();
        }
        long elim=System.nanoTime()-startTime;
        System.out.println("Tiempo de eliminación de usuarios: "+ elim);
        Usuario modificableUser= new Usuario("aholguinr", "h", testerSpot,"Mecatronica",100049,"Andres ", "Holguin", "aholguinr");
        for(int k=0;k<testerNum;k++){
            modificableUser.setNombre("Andrew");
            modificableUser.setApellido("Restrepo");
            modificableUser.setContraseña("config");
        }
        long endTime=System.nanoTime()-startTime;
        System.out.println("Tiempo de actualización de usuarios: "+endTime);
    }
    static void pruebasUsuariosQueue(int testerNum){
        long startTime=System.nanoTime();
        LinkedListGeneric<Casilla> testerSpot= new LinkedListGeneric<>();
        System.out.println("Prueba con "+testerNum+" datos en QueueArray");
        QueueArrayGeneric <Usuario> testerQueue=new QueueArrayGeneric <> (testerNum);
        for(int i=0;i<testerNum;i++){
            Usuario testerUser= new Usuario("jcaipap", "f", testerSpot, "Mecatronica", 10100,"Julian", "Caipa", "jcaipap");
            testerQueue.enqueue(testerUser);
        }
        long create=System.nanoTime()-startTime;
        System.out.println("Tiempo de creación de usuarios y almacenamiento: "+create);
        for (int j=0;j<testerNum;j++){
            testerQueue.dequeue();
        }
        long elim=System.nanoTime()-startTime;
        System.out.println("Tiempo de eliminación de usuarios: "+ elim);
        Usuario modificableUser= new Usuario("aholguinr", "h", testerSpot,"Mecatronica",100049,"Andres ", "Holguin", "aholguinr");
        for(int k=0;k<testerNum;k++){
            modificableUser.setNombre("Andrew");
            modificableUser.setApellido("Restrepo");
            modificableUser.setContraseña("config");
        }
        long endTime=System.nanoTime()-startTime;
        System.out.println("Tiempo de actualización de usuarios: "+endTime);
    }
    static void pruebasUsuariosLinkedlist(int testerNum){
        long startTime=System.nanoTime();
        LinkedListGeneric<Casilla> testerSpot= new LinkedListGeneric<>();
        System.out.println("Prueba con "+testerNum+" datos en LinkedList");
        LinkedListGeneric <Persona> testerList=new LinkedListGeneric <> ();
        Usuario testerUser= new Usuario("jcaipap", "f", testerSpot, "Mecatronica", 10100,"Julian", "Caipa", "jcaipap");
        for(int i=0;i<testerNum;i++){
            testerList.insert(testerUser);
        }
        long create=System.nanoTime()-startTime;
        System.out.println("Tiempo de creación de usuarios y almacenamiento: "+create);
        for (int j=0;j<testerNum;j++){
            testerList.delete(testerUser);
        }
        long elim=System.nanoTime()-startTime;
        System.out.println("Tiempo de eliminación de usuarios: "+ elim);
        Usuario modificableUser= new Usuario("aholguinr", "h", testerSpot,"Mecatronica",100049,"Andres ", "Holguin", "aholguinr");
        for(int k=0;k<testerNum;k++){
            modificableUser.setNombre("Andrew");
            modificableUser.setApellido("Restrepo");
            modificableUser.setContraseña("config");
        }
        long endTime=System.nanoTime()-startTime;
        System.out.println("Tiempo de actualización de usuarios: "+endTime);
    }
    static void pruebasCasillasSencillas(int testerNum){
        long startTime=System.nanoTime();
        ArrayList<Casilla> testerSpot=new ArrayList<>();
        System.out.println("Prueba con "+testerNum+" datos para casillas");
        for (int i=0;i<testerNum;i++){
            Casilla testerRec= new Casilla("Recordatorio", "Recordatorio de prueba", 2);
        }
        long create=System.nanoTime()-startTime;
        System.out.println("Tiempo de creación de casillas: "+create);
        Casilla testerModif= new Casilla("Materia","Prueba", 3);
        for (int j=0;j<testerNum;j++){
            testerModif.setDescripcion("Cambio en descripción");
            testerModif.setTitulo("Recordatorio");
            testerModif.setImportancia(4);
        }
        long modif=System.nanoTime()-startTime;
        System.out.println("Tiempo de actualización de casillas: "+modif);
        
    }
    static void pruebaLinkedList(){
        LinkedListGeneric<Persona> testerLinkedlist= new LinkedListGeneric<>();
        LinkedListGeneric<Casilla> casillas= new LinkedListGeneric<>();
        Persona andres= new Usuario("aholguinr","contra",casillas,"meca",2, "Andres","Holguin", "aholguinr");
        Persona admin=new Administrador("admin", "admi", 5, "admin", "administrador","adiminmail");
        Persona admin2=new Administrador("admin", "admi", 6, "admin", "administrador","adiminmail");
        testerLinkedlist.insert(admin);
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
        /*Casilla testerModif= new Casilla("Materia","Prueba", 3,calendarGenerator(2020,2,12,5,0),calendarGenerator(2020,2,12,7,0));
        for (int j=0;j<testerNum;j++){
            testerModif.setDescripcion("Cambio en descripción");
            testerModif.setTitulo("Recordatorio");
            testerModif.setImportancia(4);
            testerModif.setFechaInicio(calendarGenerator(2020,3,14,4,0));
            testerModif.setFechaFinalizacion(calendarGenerator(2020,3,14,6,0));
        }
        long modif=System.nanoTime()-startTime;
        System.out.println("Tiempo de actualización de casillas: "+modif);
        for(int k=0;k<testerNum;k++){
            casillas.insert(testerModif);
        }
        long add=System.nanoTime()-startTime;
        System.out.println("Tiempo de añadir casillas: "+modif);
        for(int k=0;k<testerNum;k++){
            casillas.delete(testerModif);
        }
        long remove=System.nanoTime()-startTime;
        System.out.println("Tiempo de eliminar casillas: "+modif);   */
   } 
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
    
}