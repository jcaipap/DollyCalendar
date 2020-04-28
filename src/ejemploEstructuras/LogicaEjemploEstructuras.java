
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
import java.util.Arrays;
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
        Calendar [] fechas=new Calendar[]{calendarGenerator(2020, 7, 1, 15, 0),calendarGenerator(2020,7,1, 17, 0)};
        Calendar calendar=calendarGenerator(2020, 7, 1, 15, 0);
        Calendar calendar2=fechas[0];
        System.out.println(calendar.getTime());
        System.out.println(calendar2.getTime());
        int diaAño=calendar.get(Calendar.DAY_OF_YEAR);
        //Calendar[] calendar2=generadorCalendar(fechas[0]);        
        for(int i=0;i<16;i++){
            calendar.set(Calendar.DAY_OF_YEAR,diaAño+7*i);
            //System.out.println(calendar.getTime());
            System.out.println(calendar.getTime());
        }
        Grupo grupoED1= new Grupo(1, "Cristian Cordoba",fechas);
        Grupo grupoED2= new Grupo(2, "David Herrera",fechas);
        System.out.println(grupoED1);
        Grupo[] gruposED= new Grupo[2];
        gruposED[0]=grupoED1;
        gruposED[1]=grupoED2;
        Materia estructuras=new Materia("Estructuras", "Materia de datos ", 3, "2016699", 3,"Disciplinar", gruposED);
        System.out.println(estructuras.toStringMateria());
        LinkedListGeneric<Casilla> casillasAndres= new LinkedListGeneric<>();
        Actividad activ1=new Actividad("Recordatorio Parcial","Parcial F", 4,calendarGenerator(2020, 5, 4, 14, 0),calendarGenerator(2020, 5, 4, 16, 0));
        casillasAndres.insert(activ1);
        Usuario andres=new Usuario("jandresh", "contra", 10100,"Andres", "Holguin","jandresh", casillasAndres,"Mecatronica");
        seleccionarGrupo(andres, estructuras, 1);
        casillasAndres.printRecursive();
        /*
        Scanner scanner = new Scanner(System.in);
        
        Persona admin1 = new Persona("a1", "c1", 1, "nombre1", "apellido1", "correo1");
        Persona admin2 = new Persona("a2", "c2", 2, "nombre1", "apellido1", "correo1");
        Persona admin3 = new Persona("a3", "c3", 3, "nombre1", "apellido1", "correo1");
        Usuario est1 = new Usuario("u1", "c1", 1, "nombre", "apellido", "apellido", "as");
        Usuario est2 = new Usuario("u2", "c2", 2, "nombre", "apellido", "apellido", "as");
        Usuario est3 = new Usuario("u3", "c3", 3, "nombre", "apellido", "apellido", "as");
        Grupo[] gruposED= new Grupo[10];
        Grupo grupoED1= new Grupo(1, "Cristian Cordoba");
        Grupo grupoED2= new Grupo(2, "David Herrera");
        Grupo grupoED3= new Grupo(3, "Victor Collazos");
        Grupo grupoED4= new Grupo(4, "Luis Niño");
        gruposED[0]=grupoED1;
        gruposED[1]=grupoED2;
        gruposED[2]=grupoED3;
        gruposED[3]=grupoED4;        
        Materia estructuras=new Materia("Estructuras", "Materia de datos ", 3, "2016699", 3,"Disciplinar", gruposED);
        
        Grupo[] gruposECD= new Grupo[10];
        Grupo grupoECD1= new Grupo(1, "Ricardo Pastran");
        Grupo grupoECD2= new Grupo(2, "Nicolas Martinez");
        Grupo grupoECD3= new Grupo(3, "Hernan Garzon");
        Grupo grupoECD4= new Grupo(4, "German Fonseca");
        gruposECD[0]=grupoECD1;
        gruposECD[1]=grupoECD2;
        gruposECD[2]=grupoECD3;
        gruposECD[3]=grupoECD4;
        Materia ecuaciones=new Materia("E. Diferenciales", "Curso de ecuaciones diferenciales ordinarias", 4, "1000007-B", 4,"Fundamentacion", gruposED);
        
        Grupo[] gruposEA= new Grupo[10];
        Grupo grupoEA1= new Grupo(1, "Carlos Perilla");
        Grupo grupoEA2= new Grupo(2, "Pablo Rodriguez");
        Grupo grupoEA3= new Grupo(3, "Jesus Quintero");
        Grupo grupoEA4= new Grupo(4, "Pablo Rodriguez");
        gruposEA[0]=grupoEA1;
        gruposEA[1]=grupoEA2;
        gruposEA[2]=grupoEA3;
        gruposEA[3]=grupoEA4;
        Materia eAnaloga=new Materia("E. Analoga I", "Circuitos analogicos y semiconducción", 4, "2016495", 4,"Disciplinar", gruposEA);
        
        Grupo[] gruposfEyM= new Grupo[10];
        Grupo grupofEyM1= new Grupo(1, "Dario Rodriguez");
        Grupo grupofEyM2= new Grupo(2, "Walter Pulido");
        Grupo grupofEyM3= new Grupo(3, "Santiago Cortes");
        Grupo grupofEyM4= new Grupo(4, "Hector Castro");
        gruposfEyM[0]=grupofEyM1;
        gruposfEyM[1]=grupofEyM2;
        gruposfEyM[2]=grupofEyM3;
        gruposfEyM[3]=grupofEyM4;
        Materia fEyM=new Materia("Fundamentos de Electricidad y Magnetismo", "Introduccion a las fuerzas electromagneticas",4, "1000017-B",4,"Fundamentación", gruposfEyM);
        
        Grupo[] gruposPQ= new Grupo[10];
        Grupo grupoPQ1= new Grupo(1, "Dario Rodriguez");
        Grupo grupoPQ2= new Grupo(2, "Walter Pulido");
        Grupo grupoPQ3= new Grupo(3, "Santiago Cortes");
        Grupo grupoPQ4= new Grupo(4, "Hector Castro");
        gruposPQ[0]= grupoPQ1;
        gruposPQ[1]= grupoPQ2;
        gruposPQ[2]= grupoPQ3;
        gruposPQ[3]= grupoPQ4;
        Materia PQ=new Materia("Principios de química", "Introducción a la química básica",3, "1000024-B",3,"Fundamentación", gruposPQ);
        
        Grupo[] gruposDin= new Grupo[10];
        Grupo grupoDin1= new Grupo(1, "Carlos Camacho");
        Grupo grupoDin2= new Grupo(2, "Nelson Arzola");
        Grupo grupoDin3= new Grupo(3, "Jaime Guerrero");
        Grupo grupoDin4= new Grupo(4, "Jaime Guerrero");
        gruposDin[0]=grupoDin1;
        gruposDin[1]=grupoDin2;
        gruposDin[2]=grupoDin3;
        gruposDin[3]=grupoDin4;
        Materia dina=new Materia("Principios de Dinamica", "Sistemas de partículas y cuerpo rígido", 3, "2017271", 3,"Disciplinar", gruposDin);
        
        Grupo[] gruposDIC= new Grupo[10];
        Grupo grupoDIC1= new Grupo(1, "Antonio Mejia");
        gruposDIC[0]=grupoDIC1;
        Materia dic=new Materia("Desarrollo de la ingeniería en Colombia ", "Avances e ingeniería colombiana historicamente", 3, "2025976", 3,"Libre Elección", gruposDIC);
        
        QueueArrayGeneric<Casilla> baseMaterias= new QueueArrayGeneric<>();        
        ListArrayGeneric<Persona> admins = new ListArrayGeneric<>(3);
        ListArrayGeneric<Persona> estudiantes = new ListArrayGeneric<>(3);
        baseMaterias.enqueue(estructuras);
        baseMaterias.enqueue(ecuaciones);
        baseMaterias.enqueue(fEyM);
        baseMaterias.enqueue(eAnaloga);
        baseMaterias.enqueue(dina);
        baseMaterias.enqueue(PQ);
        baseMaterias.enqueue(dic);
        admins.insert(admin1);
        admins.insert(admin2);
        admins.insert(admin3);
        estudiantes.insert(est1);
        estudiantes.insert(est2);
        estudiantes.insert(est3);
        
        LinkedListGeneric<Casilla> casillas= new LinkedListGeneric<>();
        LinkedListGeneric<Casilla> casillasAndres= new LinkedListGeneric<>();
        Actividad activ1=new Actividad("Recordatorio Parcial","Parcial F", 4,calendarGenerator(2020, 5, 4, 14, 0),calendarGenerator(2020, 5, 4, 16, 0));
        casillasAndres.insert(activ1);
        Usuario andres=new Usuario("jandresh", "contra", 10100,"Andres", "Holguin","jandresh", casillasAndres,"Mecatronica");
        
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

        }*/
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
    static Calendar[] generadorCalendar(Calendar calendar){
        int diaAño=calendar.get(Calendar.DAY_OF_YEAR);
        Calendar[] fechasSemestrales=new Calendar[16];
        for(int i=0;i<16;i++){
            calendar.set(Calendar.DAY_OF_YEAR,diaAño+7*i);
            fechasSemestrales[i]=calendar;
        }
        return fechasSemestrales;
    }
    static void seleccionarGrupo(Usuario user, Materia materia,int numeroGrupo){
        Grupo[] grupos=materia.getGrupos();
        Grupo grupoSelect=grupos[numeroGrupo-1];
        Calendar[] horario=grupoSelect.getHorario();
        LinkedListGeneric<Casilla> mat=user.getCasillas();
        for(Calendar calendar:horario){
            Calendar[] semestre=generadorCalendar(calendar);
            for(int i=0;i<semestre.length;i++){
                Calendar fechaInicio=semestre[i];
                Calendar fechaFinalizacion=fechaInicio;
                fechaFinalizacion.set(Calendar.HOUR_OF_DAY, fechaInicio.get(Calendar.HOUR_OF_DAY)+2);
                Materia agregar=new Materia(materia.getTitulo(),materia.getDescripcion(),
                materia.getImportancia(),fechaInicio,fechaFinalizacion, materia.getCodigo(),materia.getCreditos(),
                materia.getTipologia(), numeroGrupo, grupoSelect.getProfesor());
                mat.insert(agregar);
            }
        }
        user.setCasillas(mat);
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