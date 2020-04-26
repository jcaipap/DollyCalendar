<<<<<<< OURS
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploEstructuras;

import data.Casilla;
import data.Grupo;
import data.Materia;
import data.Usuario;
import java.util.Scanner;
import estructuas.ListArrayGeneric;
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
        pruebasCasillasComplejas(10);

        
        
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
        HashMap <String,Grupo> testerGroups=new HashMap<>();
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
    static void pruebasCasillasSencillas(int testerNum){
        long startTime=System.nanoTime();
        ArrayList<Casilla> testerSpot=new ArrayList<>();
        HashMap <String,Grupo> testerGroups=new HashMap<>();
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
        LinkedListGeneric<Casilla> casillas= new LinkedListGeneric<>();
        Casilla casilla1= new Casilla("pvto","Materia pa el que lo lea", 2, calendarGenerator(2020,2,12,5,0),calendarGenerator(2020,2,12,7,0));
        Casilla casilla2= new Casilla("no pvto","Materia pa el que lo lea", 2, calendarGenerator(2020,1,13,6,0),calendarGenerator(2020,1,13,8,0));
        Casilla casilla3= new Casilla("casi pvto","Materia pa el que lo lea", 2, calendarGenerator(2020,2,12,6,0),calendarGenerator(2020,2,12,8,0));
        Casilla casilla4= new Casilla("unpvto","Materia pa el que lo lea", 2, calendarGenerator(2020,2,13,5,0), calendarGenerator(2020,2,13,7,0));
        casillas.insert(casilla4);
        casillas.insert(casilla3);
        casillas.insert(casilla2);
        casillas.insert(casilla1);
        casillas.delete(casilla4);
        modifySpot(casilla2,casillas);
        System.out.println(casillas.size());
        casillas.printRecursive();
    }
   static void pruebasCasillasComplejas(int testerNum){
        long startTime=System.nanoTime();
        LinkedListGeneric<Casilla> casillas= new LinkedListGeneric<>();
        System.out.println("Prueba con "+testerNum+" datos para casillas");
        for (int i=0;i<testerNum;i++){
            Casilla testerRec= new Casilla("Casilla de prueba", "Prueba de tiempos", 2, calendarGenerator(2020,2,12,5,0),calendarGenerator(2020,2,12,7,0));
        }
        long create=System.nanoTime()-startTime;
        System.out.println("Tiempo de creación de casillas: "+create);
        Casilla testerModif= new Casilla("Materia","Prueba", 3,calendarGenerator(2020,2,12,5,0),calendarGenerator(2020,2,12,7,0));
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
        System.out.println("Tiempo de eliminar casillas: "+modif);   
   } 
    public static void modifySpot(Casilla spot, LinkedListGeneric<Casilla> casillas){
        casillas.delete(spot);
        Casilla modified=spot;
        Scanner  scanner = new Scanner(System.in);
        System.out.println("Para modificar: Nombre, pulse 1");
        System.out.println("Descripción, pulse 2");
        int s=scanner.nextInt();
        switch(s){
            case(1):
                System.out.println("ingrese el nuevo nombre");
                modified.setTitulo(scanner.next());
                break;
            case(2):
                System.out.println("ingrese la nueva descripcion");
                String desc=scanner.next();
                modified.setDescripcion(desc);
                break;
            default:break;
        }
        casillas.insert(modified);
        
    }
    
    
    static Calendar calendarGenerator(int año, int mes, int dia, int hora, int minuto){
        Calendar fecha = new GregorianCalendar(año, mes, dia, hora, minuto);
        return fecha;
    }
    
    
}
=======
<<<<<<< OURS
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploEstructuras;

import data.Casilla;
import data.Grupo;
import data.Materia;
import data.Usuario;
import java.util.Scanner;
import estructuas.ListArrayGeneric;
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
        pruebaLinkedList();
        pruebaLinkedList();
        pruebaLinkedList();
       
        
        
    }
    
    static void pruebasUsuariosStack(int testerNum){
        
        long startTime=System.nanoTime();
        ArrayList<Casilla> testerSpot=new ArrayList<>();
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
        ArrayList<Casilla> testerSpot=new ArrayList<>();
        HashMap <String,Grupo> testerGroups=new HashMap<>();
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
    static void pruebasCasillasSencillas(int testerNum){
        long startTime=System.nanoTime();
        ArrayList<Casilla> testerSpot=new ArrayList<>();
        HashMap <String,Grupo> testerGroups=new HashMap<>();
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
        LinkedListGeneric<Casilla> casillas= new LinkedListGeneric<>();
        Casilla casilla1= new Casilla("pvto","Materia pa el que lo lea", 2, calendarGenerator(2020,2,12,5,0));
        Casilla casilla2= new Casilla("no pvto","Materia pa el que lo lea", 2, calendarGenerator(2020,1,13,6,0));
        Casilla casilla3= new Casilla("casi pvto","Materia pa el que lo lea", 2, calendarGenerator(2020,2,12,6,0));
        Casilla casilla4= new Casilla("unpvto","Materia pa el que lo lea", 2, calendarGenerator(2020,2,13,5,0));
        casillas.insert(casilla4);
        casillas.insert(casilla3);
        casillas.insert(casilla2);
        casillas.insert(casilla1);
        casillas.delete(casilla4);
        modifySpot(casilla2,casillas);
        casillas.printRecursive();
    }
   static void pruebasCasillasComplejas(int testerNum){
        long startTime=System.nanoTime();
        LinkedListGeneric<Casilla> casillas= new LinkedListGeneric<>();
        System.out.println("Prueba con "+testerNum+" datos para casillas");
        for (int i=0;i<testerNum;i++){
            Casilla testerRec= new Casilla("Casilla de prueba", "Prueba de tiempos", 2, calendarGenerator(2020,2,12,5,0));
        }
        long create=System.nanoTime()-startTime;
        System.out.println("Tiempo de creación de casillas: "+create);
        Casilla testerModif= new Casilla("Materia","Prueba", 3,calendarGenerator(2020,2,12,5,0));
        for (int j=0;j<testerNum;j++){
            testerModif.setDescripcion("Cambio en descripción");
            testerModif.setTitulo("Recordatorio");
            testerModif.setImportancia(4);
            testerModif.setFecha(calendarGenerator(2020,3,14,4,0));
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
        System.out.println("Tiempo de eliminar casillas: "+modif);   
   } 
    public static void modifySpot(Casilla spot, LinkedListGeneric<Casilla> casillas){
        casillas.delete(spot);
        Casilla modified=spot;
        Scanner  scanner = new Scanner(System.in);
        System.out.println("Para modificar: Nombre, pulse 1");
        System.out.println("Descripción, pulse 2");
        int s=scanner.nextInt();
        switch(s){
            case(1):
                System.out.println("ingrese el nuevo nombre");
                modified.setTitulo(scanner.next());
                break;
            case(2):
                System.out.println("ingrese la nueva descripcion");
                String desc=scanner.next();
                modified.setDescripcion(desc);
                break;
            default:break;
        }
        casillas.insert(modified);
        
    }
    
    
    static Calendar calendarGenerator(int año, int mes, int dia, int hora, int minuto){
        Calendar fecha = new GregorianCalendar(año, mes, dia, hora, minuto);
        return fecha;
    }
    
    
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploEstructuras;

import data.Casilla;
import data.Grupo;
import data.Materia;
import data.Usuario;
import java.util.Scanner;
import estructuas.ListArrayGeneric;
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
        pruebasCasillasComplejas(10);
        
        
        
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
        HashMap <String,Grupo> testerGroups=new HashMap<>();
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
    static void pruebasCasillasSencillas(int testerNum){
        long startTime=System.nanoTime();
        ArrayList<Casilla> testerSpot=new ArrayList<>();
        HashMap <String,Grupo> testerGroups=new HashMap<>();
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
        LinkedListGeneric<Casilla> casillas= new LinkedListGeneric<>();
        Casilla casilla1= new Casilla("pvto","Materia pa el que lo lea", 2, calendarGenerator(2020,2,12,5,0),calendarGenerator(2020,2,12,7,0));
        Casilla casilla2= new Casilla("no pvto","Materia pa el que lo lea", 2, calendarGenerator(2020,1,13,6,0),calendarGenerator(2020,1,13,8,0));
        Casilla casilla3= new Casilla("casi pvto","Materia pa el que lo lea", 2, calendarGenerator(2020,2,12,6,0),calendarGenerator(2020,2,12,8,0));
        Casilla casilla4= new Casilla("unpvto","Materia pa el que lo lea", 2, calendarGenerator(2020,2,13,5,0), calendarGenerator(2020,2,13,7,0));
        casillas.insert(casilla4);
        casillas.insert(casilla3);
        casillas.insert(casilla2);
        casillas.insert(casilla1);
        casillas.delete(casilla4);
        modifySpot(casilla2,casillas);
        System.out.println(casillas.size());
        casillas.printRecursive();
    }
   static void pruebasCasillasComplejas(int testerNum){
        long startTime=System.nanoTime();
        LinkedListGeneric<Casilla> casillas= new LinkedListGeneric<>();
        System.out.println("Prueba con "+testerNum+" datos para casillas");
        for (int i=0;i<testerNum;i++){
            Casilla testerRec= new Casilla("Casilla de prueba", "Prueba de tiempos", 2, calendarGenerator(2020,2,12,5,0),calendarGenerator(2020,2,12,7,0));
        }
        long create=System.nanoTime()-startTime;
        System.out.println("Tiempo de creación de casillas: "+create);
        Casilla testerModif= new Casilla("Materia","Prueba", 3,calendarGenerator(2020,2,12,5,0),calendarGenerator(2020,2,12,7,0));
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
        System.out.println("Tiempo de eliminar casillas: "+modif);   
   } 
    public static void modifySpot(Casilla spot, LinkedListGeneric<Casilla> casillas){
        casillas.delete(spot);
        Casilla modified=spot;
        Scanner  scanner = new Scanner(System.in);
        System.out.println("Para modificar: Nombre, pulse 1");
        System.out.println("Descripción, pulse 2");
        int s=scanner.nextInt();
        switch(s){
            case(1):
                System.out.println("ingrese el nuevo nombre");
                modified.setTitulo(scanner.next());
                break;
            case(2):
                System.out.println("ingrese la nueva descripcion");
                String desc=scanner.next();
                modified.setDescripcion(desc);
                break;
            default:break;
        }
        casillas.insert(modified);
        
    }
    
    
    static Calendar calendarGenerator(int año, int mes, int dia, int hora, int minuto){
        Calendar fecha = new GregorianCalendar(año, mes, dia, hora, minuto);
        return fecha;
    }
    
    
>>>>>>> THEIRS
}
>>>>>>> THEIRS
