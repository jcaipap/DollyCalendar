
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploEstructuras;

import com.sun.org.apache.xalan.internal.lib.NodeInfo;
import data.Actividad;
import data.Casilla;
import data.Grupo;
import data.Materia;
import data.Persona;
import data.Estudiante;
import estructuas.DynamicArray;
import java.util.Scanner;
import estructuas.QueueArrayGeneric;
import estructuas.HashGeneric;
import estructuas.HashNode;
import estructuas.StackArrayGeneric;
import estructuas.LinkedListGeneric;
import estructuas.ListArrayGeneric;
import estructuas.NodeGeneric;
import estructuas.PriorityQueue;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import estructuas.StackArraySpot;
import gui.Calendario;
import gui.GUIBuscador;
import gui.GUIGeneracionUsuario;
import gui.GUIInicio;
import gui.GUIInicioAdmin;
import gui.GUIPruebas;
import gui.GUIVerUsuarios;
import static java.awt.Color.black;
import java.lang.reflect.Array;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author andre
 */
public class LogicaEjemploEstructuras {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {



        
        
        Calendar[] fechaLC7 = new Calendar[]{calendarGenerator(2020, 2, 2, 7, 0), calendarGenerator(2020, 2, 4, 7, 0)};
        Calendar[] fechaLC9 = new Calendar[]{calendarGenerator(2020, 2, 2, 9, 0), calendarGenerator(2020, 2, 4, 9, 0)};
        Calendar[] fechaLC11 = new Calendar[]{calendarGenerator(2020, 2, 2, 11, 0), calendarGenerator(2020, 2, 4, 11, 0)};
        Calendar[] fechaLC14 = new Calendar[]{calendarGenerator(2020, 2, 2, 14, 0), calendarGenerator(2020, 2, 4, 14, 0)};
        Calendar[] fechaLC16 = new Calendar[]{calendarGenerator(2020, 2, 2, 16, 0), calendarGenerator(2020, 2, 4, 16, 0)};
        Calendar[] fechaMJ7 = new Calendar[]{calendarGenerator(2020, 2, 3, 7, 0), calendarGenerator(2020, 2, 5, 7, 0)};
        Calendar[] fechaMJ9 = new Calendar[]{calendarGenerator(2020, 2, 3, 9, 0), calendarGenerator(2020, 2, 5, 9, 0)};
        Calendar[] fechaMJ11 = new Calendar[]{calendarGenerator(2020, 2, 3, 11, 0), calendarGenerator(2020, 2, 5, 11, 0)};
        Calendar[] fechaMJ14 = new Calendar[]{calendarGenerator(2020, 2, 3, 14, 0), calendarGenerator(2020, 2, 5, 14, 0)};
        Calendar[] fechaMJ16 = new Calendar[]{calendarGenerator(2020, 2, 3, 16, 0), calendarGenerator(2020, 2, 5, 16, 0)};
        Grupo[] gruposED=new Grupo[10];
        
        
//        
//        
//        PriorityQueue<Grupo> gruposED2=new PriorityQueue<>(true);
//        HashGeneric<Integer,Grupo> gruposxd=new HashGeneric<>();
        
        
        
//        Grupo grupoED2 = new Grupo(2, "David Herrera", fechaMJ14);
//        Grupo grupoED1 = new Grupo(1, "Cristian Cordoba", fechaLC7);
//        Grupo grupoED3 = new Grupo(3, "Victor Collazos", fechaLC9);
//        Grupo grupoED4 = new Grupo(4, "Luis Niño", fechaMJ11);
//        Grupo grupoED5 = new Grupo(5, "David Herrera", fechaLC14);
//        gruposxd.add(grupoED2.getNumeroGrupo(), grupoED2);
//        gruposxd.add(grupoED1.getNumeroGrupo(), grupoED1);
//        gruposxd.add(grupoED3.getNumeroGrupo(), grupoED3);
//        gruposxd.add(grupoED4.getNumeroGrupo(), grupoED4);
//        gruposxd.add(grupoED5.getNumeroGrupo(), grupoED5);
//        
//        
////        System.out.println(gruposxd);
////        gruposxd.remove(2);
////        System.out.println(gruposxd);
////        HashNode[] f=gruposxd.getHashArray();
////        System.out.println(Arrays.toString(f));
//        
////        gruposED2.add(grupoED2);
////        gruposED2.add(grupoED1);
////        gruposED2.add(grupoED3);
////        gruposED2.add(grupoED4);
////        gruposED2.add(grupoED5);
////        System.out.println(gruposED2);
////        gruposED2.remove(grupoED2);
////        System.out.println(gruposED2);
////        Comparable[] f= new Comparable[gruposED2.length()+1];
////        f=(Comparable[]) gruposED2.getHeap();
////        System.out.println(Arrays.toString(f));
//        
//        
//        
//
//        gruposED[0] = grupoED1;
//        gruposED[1] = grupoED2;
//        gruposED[2] = grupoED3;
//        gruposED[3] = grupoED4;
//        gruposED[4] = grupoED5;
//
//        Materia estructuras = new Materia("Estructuras de datos", "Curso de programación de estructuras de datos.", 3, "2016699", 3, "Disciplinar", gruposED);

        Grupo[] gruposECD = new Grupo[4];
        Grupo grupoECD1 = new Grupo(1, "Ricardo Pastran", fechaLC7);
        Grupo grupoECD2 = new Grupo(2, "Nicolas Martinez", fechaLC9);
        Grupo grupoECD3 = new Grupo(3, "Hernan Garzon", fechaLC16);
        Grupo grupoECD4 = new Grupo(4, "German Fonseca", fechaLC11);
        gruposECD[0] = grupoECD1;
        gruposECD[1] = grupoECD2;
        gruposECD[2] = grupoECD3;
        gruposECD[3] = grupoECD4;
        Materia ecuaciones = new Materia("Ecuaciones diferenciales", "Curso de ecuaciones diferenciales ordinarias.", 4, "1000007-B", 4, "Fundamentacion", gruposECD);

        Grupo[] gruposEA = new Grupo[4];
        Grupo grupoEA1 = new Grupo(1, "Carlos Perilla", fechaLC9);
        Grupo grupoEA2 = new Grupo(2, "Pablo Rodriguez", fechaLC11);
        Grupo grupoEA3 = new Grupo(3, "Jesus Quintero", fechaMJ7);
        Grupo grupoEA4 = new Grupo(4, "Pablo Rodriguez", fechaMJ11);
        gruposEA[0] = grupoEA1;
        gruposEA[1] = grupoEA2;
        gruposEA[2] = grupoEA3;
        gruposEA[3] = grupoEA4;
        Materia eAnaloga = new Materia("Electrónica análoga I", "Teoría de circuitos analogicos y de semiconducción.", 4, "2016495", 4, "Disciplinar", gruposEA);

        Grupo[] gruposfEyM = new Grupo[4];
        Grupo grupofEyM1 = new Grupo(1, "Dario Rodriguez", fechaMJ7);
        Grupo grupofEyM2 = new Grupo(2, "Walter Pulido", fechaMJ9);
        Grupo grupofEyM3 = new Grupo(3, "Santiago Cortes", fechaMJ11);
        Grupo grupofEyM4 = new Grupo(4, "Hector Castro", fechaMJ14);
        gruposfEyM[0] = grupofEyM1;
        gruposfEyM[1] = grupofEyM2;
        gruposfEyM[2] = grupofEyM3;
        gruposfEyM[3] = grupofEyM4;
        Materia fEyM = new Materia("Fundamentos de Electricidad y Magnetismo", "Introduccion a las fuerzas electromagneticas.", 4, "1000017-B", 4, "Fundamentación", gruposfEyM);

        Grupo[] gruposPQ = new Grupo[2];
        Grupo grupoPQ1 = new Grupo(1, "Josue Clavijo", fechaMJ14);
        Grupo grupoPQ4 = new Grupo(2, "Edgar Delgado", fechaLC14);
        gruposPQ[0] = grupoPQ1;
        gruposPQ[1] = grupoPQ4;
        Materia PQ = new Materia("Principios de química", "Introducción a la química básica.", 3, "1000024-B", 3, "Fundamentación", gruposPQ);

        Grupo[] gruposDin = new Grupo[4];
        Grupo grupoDin1 = new Grupo(1, "Carlos Camacho", fechaMJ11);
        Grupo grupoDin2 = new Grupo(2, "Nelson Arzola", fechaMJ9);
        Grupo grupoDin3 = new Grupo(3, "Jaime Guerrero", fechaMJ14);
        Grupo grupoDin4 = new Grupo(4, "Jaime Guerrero", fechaMJ16);
        gruposDin[0] = grupoDin1;
        gruposDin[1] = grupoDin2;
        gruposDin[2] = grupoDin3;
        gruposDin[3] = grupoDin4;
        Materia dina = new Materia("Principios de Dinamica", "Sistemas dinámicos de partículas y cuerpo rígido.", 3, "2017271", 3, "Disciplinar", gruposDin);

        Grupo[] gruposDIC = new Grupo[1];
        Grupo grupoDIC1 = new Grupo(1, "Antonio Mejia", fechaMJ11);
        gruposDIC[0] = grupoDIC1;
        Materia dic = new Materia("Desarrollo de la ingeniería en Colombia ", "Breve introducción a la historia del desarrollo tecnológico en Colombia.", 3, "2025976", 3, "Libre Elección", gruposDIC);

        LinkedListGeneric<Casilla> casillas = new LinkedListGeneric<>();
        StackArraySpot baseMaterias = new StackArraySpot(7);
        ListArrayGeneric<Persona> admins = new ListArrayGeneric<>(3);
        ListArrayGeneric<Persona> estudiantes = new ListArrayGeneric<>(10);

//        baseMaterias.push(estructuras);
        baseMaterias.push(fEyM);
        baseMaterias.push(ecuaciones);
        baseMaterias.push(eAnaloga);
        baseMaterias.push(dina);
        baseMaterias.push(PQ);
        baseMaterias.push(dic);

        Persona admin1 = new Persona("admin1", "clave1", 1, "nombre1", "apellido1");
        Persona admin2 = new Persona("admin2", "claveAdmin", 2, "nombre2", "apellido2");
        Persona admin3 = new Persona("admin13", "claveAdmin2", 3, "nombre3", "apellido3");
        Persona admin4 = new Persona("admin4", "claveAdmin2", 3, "nombre3", "apellido3");
        Persona admin5 = new Persona("admin5", "claveAdmin2", 3, "nombre3", "apellido3");
        Estudiante est1 = new Estudiante("usuario1", "clave1", 1, "nombre1", "apellido1", casillas, "Ing1");
        Estudiante est2 = new Estudiante("dfcantors", "contraseña", 1072717690, "Daniel", "Cantor", casillas, "Ingeniería Mecatrónica");
        Estudiante julian = new Estudiante("jcaipap", "password", 1010042710, "Julian", "Caipa", casillas, "Ingeniería Mecatrónica");

        LinkedListGeneric<Casilla> casillasAndres = new LinkedListGeneric<>();
        Actividad activ1 = new Actividad("Recordatorio Parcial Dinámica", "Estudiar teoría de cuerpo rígido", 5, calendarGenerator(2020, 5, 4, 14, 0), calendarGenerator(2020, 5, 4, 16, 0));
        casillasAndres.insert(activ1);
        Estudiante andres = new Estudiante("aholguinr", "clave", 1000794275, "Andres", "Holguin", casillasAndres, "Ingeniería Mecatrónica");
        HashGeneric<String,Persona> administradores=new HashGeneric<>();
        HashGeneric<String,Persona> usuarios=new HashGeneric<>();
        administradores.add(admin1.getUsuario(), admin1);
        administradores.add(admin2.getUsuario(), admin2);
        administradores.add(admin3.getUsuario(), admin3);
        administradores.add(admin4.getUsuario(), admin4);
        administradores.add(admin5.getUsuario(), admin5);
        usuarios.add(est1.getUsuario(), est1);
        usuarios.add(est2.getUsuario(), est2);
        usuarios.add(julian.getUsuario(), julian);
        usuarios.add(andres.getUsuario(), andres);

        
        
//        GUIInicio inic = new GUIInicio(usuarios, administradores);
//        inic.setVisible(true);
        
        GUIVerUsuarios ver = new GUIVerUsuarios(usuarios, administradores);
        ver.setVisible(true);
        
//        GUIPruebas p = new GUIPruebas();
//        p.setVisible(true);
        
//
//        boolean continuar = true;
//        String usuario;
//        String contraseña;
//
//        //inicio del programa, continue es para salirse o continuar, se cambia con la funcion seguir();
//        Scanner scanner = new Scanner(System.in);
//        Scanner scannerStr = new Scanner(System.in);
//        scannerStr.useDelimiter("\n");
//        while (continuar) {
//            limpiarConsola();
//            System.out.println("Bienvenido a DollyCalendar, por favor seleccione entre las siguientes opciones:\n\n");
//            System.out.println("1. Estudiante\n2. Administrador\n3. Crear nuevo estudiante\n4. Salir");
//            int inicio = scanner.nextInt();
//            switch (inicio) {
//
//                case 1:
//                    System.out.println("Usted ha ingresado como estudiante, por favor ingrese los siguientes datos personales:\n");
//                    System.out.println("Ingrese su usuario:");
//                    usuario = scanner.next();
//                    System.out.println("\nIngrese su contraseña:");
//                    contraseña = scanner.next();
//                    Estudiante estudiante = new Estudiante();
//                    if (!autenticar(usuario, contraseña, estudiantes)) {
//                        limpiarConsola();
//                        System.out.println("Usuario o contraseña incorrectos.\n");
//                        continuar = seguir();
//                        break;
//                    }
//
//                    limpiarConsola();
//                    System.out.println("Estudiante validado correctamente.\n");
//                    estudiante = getUsuario(usuario, estudiantes);
//                    opcionesEst(estudiante, baseMaterias);
//                    continuar = seguir();
//
//                    break;
//
//                case 2:
//                    System.out.println("Usted ha ingresado como administrador, por favor ingrese los siguientes datos personales:\n");
//                    System.out.println("Ingrese su usuario:");
//                    usuario = scanner.next();
//                    System.out.println("\nIngrese su contraseña:");
//                    contraseña = scanner.next();
//
//                    if (!autenticar(usuario, contraseña, admins)) {
//                        limpiarConsola();
//                        System.out.println("Usuario o contraseña incorrectos.\n");
//                        continuar = seguir();
//                        break;
//                    }
//                    limpiarConsola();
//                    System.out.println("Administrador validado correctamente.\n");
//                    opcionesAdmin(estudiantes, baseMaterias);
//
//                    continuar = seguir();
//                    break;
//
//                case 3:
//
//                    estudiantes = crearUsuario(estudiantes);
//                    continuar = seguir();
//
//                    break;
//
//                case 4:
//
//                    continuar = false;
//                    limpiarConsola();
//                    System.out.println("Usted ha salido con éxito.");
//                    break;
//
//                default:
//
//                    continuar = false;
//                    limpiarConsola();
//                    System.out.println("Opción invalida");
//                    continuar = seguir();
//                    break;
//
//            }
//        }
    }
    
    
    
    //Funciones Generales
    
    static void limpiarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }
    
    static boolean seguir() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la opción que desee realizar:\n1. Continuar y volver a inicio\n2. Salir del programa");
        if (scanner.nextInt() == 2) {
            return false;
        }
        return true;
    }

    static boolean seguirEstudiante() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\nSeleccione la opción que desee realizar:\n1. Volver \n2. Salir");
        if (scanner.nextInt() == 1) {
            return true;
        }
        return false;
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
    
    static ListArrayGeneric crearUsuario(ListArrayGeneric estudiantes) {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);
        scannerStr.useDelimiter("\n");
        Estudiante nuevoEst = new Estudiante();

        System.out.println("\n\nUsted ha seleccionado crear un nuevo estudiante, ingrese los siguientes parámetros:\n");
        System.out.println("\nIngrese el nuevo código:\n");
        nuevoEst.setCodigo(scanner.nextInt());
        System.out.println("\nIngrese el nuevo nombre:\n");
        nuevoEst.setNombre(scannerStr.next());
        System.out.println("\nIngrese el nuevo apellido:\n");
        nuevoEst.setApellido(scannerStr.next());
        System.out.println("\nIngrese el nuevo usuario:\n");
        nuevoEst.setUsuario(scanner.next());
        System.out.println("\nIngrese la nueva contraseña:\n");
        nuevoEst.setContraseña(scanner.next());
        System.out.println("\nIngrese el nuevo pregrado:\n");
        nuevoEst.setPregado(scannerStr.next());

        Persona personaC = new Persona();
        for (int i = 0; i < estudiantes.size(); i++) {
            personaC = (Persona) estudiantes.getItemInPosition(i);
            if (nuevoEst.getCodigo() == personaC.getCodigo() || (personaC.getUsuario().equals((String) nuevoEst.getUsuario()))) {
                limpiarConsola();
                System.out.println("\n\nError al crear usuario, usuario o codigo preexistente.\n");
                return estudiantes;
            }
        }
        limpiarConsola();
        estudiantes.insert(nuevoEst);
        System.out.println("\n\nUsuario creado exitosamente.\n");
        return estudiantes;

    }

    static Calendar calendarGenerator(int año, int mes, int dia, int hora, int minuto) {
        Calendar fecha = new GregorianCalendar(año, mes, dia, hora, minuto);
        return fecha;
    }

    static Calendar[] generadorCalendar(Calendar calendar) {
        int diaAño = calendar.get(Calendar.DAY_OF_YEAR) - 7;
        Calendar[] fechasSemestrales = new Calendar[16];

        GregorianCalendar c1 = new GregorianCalendar();
        GregorianCalendar c2 = new GregorianCalendar();
        GregorianCalendar c3 = new GregorianCalendar();
        GregorianCalendar c4 = new GregorianCalendar();
        GregorianCalendar c5 = new GregorianCalendar();
        GregorianCalendar c6 = new GregorianCalendar();
        GregorianCalendar c7 = new GregorianCalendar();
        GregorianCalendar c8 = new GregorianCalendar();
        GregorianCalendar c9 = new GregorianCalendar();
        GregorianCalendar c10 = new GregorianCalendar();
        GregorianCalendar c11 = new GregorianCalendar();
        GregorianCalendar c12 = new GregorianCalendar();
        GregorianCalendar c13 = new GregorianCalendar();
        GregorianCalendar c14 = new GregorianCalendar();
        GregorianCalendar c15 = new GregorianCalendar();
        GregorianCalendar c16 = new GregorianCalendar();

        c1.set(Calendar.DAY_OF_YEAR, diaAño + 7);
        c1.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c1.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c1.set(Calendar.SECOND, calendar.get(Calendar.SECOND));

        c2.set(Calendar.DAY_OF_YEAR, diaAño + 14);
        c2.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c2.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c2.set(Calendar.SECOND, calendar.get(Calendar.SECOND));

        c3.set(Calendar.DAY_OF_YEAR, diaAño + 21);
        c3.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c3.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c3.set(Calendar.SECOND, calendar.get(Calendar.SECOND));

        c4.set(Calendar.DAY_OF_YEAR, diaAño + 28);
        c4.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c4.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c4.set(Calendar.SECOND, calendar.get(Calendar.SECOND));

        c5.set(Calendar.DAY_OF_YEAR, diaAño + 35);
        c5.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c5.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c5.set(Calendar.SECOND, calendar.get(Calendar.SECOND));

        c6.set(Calendar.DAY_OF_YEAR, diaAño + 42);
        c6.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c6.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c6.set(Calendar.SECOND, calendar.get(Calendar.SECOND));

        c7.set(Calendar.DAY_OF_YEAR, diaAño + 49);
        c7.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c7.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c7.set(Calendar.SECOND, calendar.get(Calendar.SECOND));

        c8.set(Calendar.DAY_OF_YEAR, diaAño + 56);
        c8.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c8.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c8.set(Calendar.SECOND, calendar.get(Calendar.SECOND));

        c9.set(Calendar.DAY_OF_YEAR, diaAño + 63);
        c9.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c9.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c9.set(Calendar.SECOND, calendar.get(Calendar.SECOND));

        c10.set(Calendar.DAY_OF_YEAR, diaAño + 70);
        c10.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c10.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c10.set(Calendar.SECOND, calendar.get(Calendar.SECOND));

        c11.set(Calendar.DAY_OF_YEAR, diaAño + 77);
        c11.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c11.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c11.set(Calendar.SECOND, calendar.get(Calendar.SECOND));

        c12.set(Calendar.DAY_OF_YEAR, diaAño + 84);
        c12.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c12.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c12.set(Calendar.SECOND, calendar.get(Calendar.SECOND));

        c13.set(Calendar.DAY_OF_YEAR, diaAño + 91);
        c13.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c13.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c13.set(Calendar.SECOND, calendar.get(Calendar.SECOND));

        c14.set(Calendar.DAY_OF_YEAR, diaAño + 98);
        c14.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c14.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c14.set(Calendar.SECOND, calendar.get(Calendar.SECOND));

        c15.set(Calendar.DAY_OF_YEAR, diaAño + 105);
        c15.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c15.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c15.set(Calendar.SECOND, calendar.get(Calendar.SECOND));

        c16.set(Calendar.DAY_OF_YEAR, diaAño + 112);
        c16.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c16.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c16.set(Calendar.SECOND, calendar.get(Calendar.SECOND));

        fechasSemestrales[0] = c1;
        fechasSemestrales[1] = c2;
        fechasSemestrales[2] = c3;
        fechasSemestrales[3] = c4;
        fechasSemestrales[4] = c5;
        fechasSemestrales[5] = c6;
        fechasSemestrales[6] = c7;
        fechasSemestrales[7] = c8;
        fechasSemestrales[8] = c9;
        fechasSemestrales[9] = c10;
        fechasSemestrales[10] = c11;
        fechasSemestrales[11] = c12;
        fechasSemestrales[12] = c13;
        fechasSemestrales[13] = c14;
        fechasSemestrales[14] = c15;
        fechasSemestrales[15] = c16;

        return fechasSemestrales;
    }

    

    //Funciones Admin
    
    static void seleccionarGrupo(Estudiante user, Materia materia, int numeroGrupo) {
        Grupo[] grupos = materia.getGrupos();
        Grupo grupoSelect = grupos[numeroGrupo - 1];
        Calendar[] horario = grupoSelect.getHorario();
        LinkedListGeneric<Casilla> mat = user.getCasillas();
        for (Calendar calendar : horario) {
            Calendar[] semestre = generadorCalendar(calendar);
            for (int i = 0; i < semestre.length; i++) {
                Calendar fechaInicio = semestre[i];

                GregorianCalendar fechaFinalizacion = new GregorianCalendar(fechaInicio.get(Calendar.YEAR),
                        fechaInicio.get(Calendar.MONTH), fechaInicio.get(Calendar.DAY_OF_MONTH),
                        fechaInicio.get(Calendar.HOUR_OF_DAY) + 2, fechaInicio.get(Calendar.MINUTE),
                        fechaInicio.get(Calendar.SECOND));

                Materia agregar = new Materia(materia.getTitulo(), materia.getDescripcion(),
                        materia.getImportancia(), fechaInicio, fechaFinalizacion, materia.getCodigo(), materia.getCreditos(),
                        materia.getTipologia(), numeroGrupo, grupoSelect.getProfesor());
                mat.insert(agregar);
            }
        }
        user.setCasillas(mat);
        System.out.println("\n\nMateria añadida correctamente.\n\n");
    }

    static StackArraySpot cambiarMateria(StackArraySpot materias) {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);
        scannerStr.useDelimiter("\n");

        System.out.println("\n\n Usted ha seleccionado editar materias, seleccione el número de la materia a editar:");
        int numeroMateria = scanner.nextInt();
        limpiarConsola();
        if (numeroMateria <= materias.getLenght() && numeroMateria > 0) {
            Materia matCambio = (Materia) materias.getItemInPosition(numeroMateria - 1);
            System.out.println("Mostrando la información de la materia: " + numeroMateria + ".\n" + matCambio.toStringNoGroups() + "\n\n\n");
            System.out.println("Seleccione el número del parametro a editar:\n1. Titulo\n2. Descripcion\n3. Código \n4. Tipologia \n5. Creditos\n\n\n");

            switch (scanner.nextInt()) {

                case 1:
                    System.out.println("\n\nIngrese el nuevo título:\n");
                    matCambio.setTitulo(scannerStr.next());
                    System.out.println("\n\nCambio realizado correctamente\n");
                    break;
                case 2:
                    System.out.println("\n\nIngrese la nueva descripción:\n");
                    matCambio.setDescripcion(scannerStr.next());
                    System.out.println("\n\nCambio realizado correctamente\n");
                    break;
                case 3:
                    System.out.println("\n\nIngrese el nuevo código:\n");
                    matCambio.setCodigo(scannerStr.next());
                    System.out.println("\n\nCambio realizado correctamente\n");
                    break;
                case 4:
                    System.out.println("\n\nIngrese la nueva tipologia:\n");
                    matCambio.setTipologia(scannerStr.next());
                    System.out.println("\n\nCambio realizado correctamente\n");
                    break;
                case 5:
                    System.out.println("\n\nIngrese la nueva cantidad de creditos:\n");
                    matCambio.setCreditos(scanner.nextInt());
                    System.out.println("\n\nCambio realizado correctamente\n");
                    break;

                default:
                    break;
            }

            materias.pushAt(matCambio, numeroMateria - 1);

        } else {
            System.out.println("\n\nEl número seleccionado no se encuentra en la lista.");
        }

        return materias;
    }

    static StackArraySpot cambioGrupo(StackArraySpot materias) {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);
        scannerStr.useDelimiter("\n");
        System.out.println("\n Usted ha seleccionado ver grupos, seleccione el número de la materia de la cuál desea ver los grupos: \n");
        int numeroMateria = scanner.nextInt();
        if (numeroMateria <= materias.getLenght() && numeroMateria > 0) {
            Materia matCambio = (Materia) materias.getItemInPosition(numeroMateria - 1);
            System.out.println("\nMostrando la información de la materia: " +numeroMateria +"\n\n" + matCambio.toStringMateria() + "\n\n");
            System.out.println("\n\nSeleccione qué opción desea realizar:\n1. Editar grupos\n2. Volver");

            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Seleccione el numero de grupo que desea editar: \n");
                    int numeroGrupo = scanner.nextInt();
                    Grupo[] grupos = matCambio.getGrupos();
                    if (numeroGrupo <= grupos.length && numeroGrupo > 0) {
                        Grupo grupoEdit = grupos[numeroGrupo - 1];
                        System.out.println("Seleccione el parametro a editar:\n1. Profesor\n2. Numero de grupo\n");
                        switch (scanner.nextInt()) {

                            case 1:
                                System.out.println("\nIngrese el nuevo Profesor:");
                                grupoEdit.setProfesor(scannerStr.next());
                                Array.set(grupos, numeroGrupo - 1, grupoEdit);
                                System.out.println("\n\nCambio realizado correctamente\n");
                                break;

                            case 2:

                                boolean exit = false;
                                System.out.println("\nIngrese el nuevo numero de grupo:");
                                int numeroNuevo = scanner.nextInt();
                                if (numeroNuevo > 0) {
                                    for (Grupo grupoN : grupos) {
                                        if (numeroNuevo == grupoN.getNumeroGrupo()) {
                                            System.out.println("El numero ingresado ya ha sido asignado a un grupo");
                                            System.out.println("\n\nCambio realizado incorrectamente\n");
                                            exit = true;
                                            break;
                                        }
                                    }
                                    if (exit) {
                                        break;
                                    } else {
                                        grupoEdit.setNumeroGrupo(numeroNuevo);
                                        Array.set(grupos, numeroGrupo - 1, grupoEdit);
                                        Arrays.sort(grupos);
                                        System.out.println("\n\nCambio realizado correctamente\n");
                                    }
                                }
                                break;
                            default:
                                break;
                        }
                        matCambio.setGrupos(grupos);
                        limpiarConsola();
                        System.out.println("\n\nEl cambio se ha realizado correctamente.\n\n");

                        materias.pushAt(matCambio, numeroMateria - 1);
                    } else {
                        System.out.println("El número seleccionado no se encuentra en la lista, no se realizó la edición.");
                    }

                    break;

                case 2:

                    limpiarConsola();
                    break;

                default:
                    limpiarConsola();
                    System.out.println("Opción invalida");
                    break;
            }

        }

        return materias;

    }

    static ListArrayGeneric cambioEstudiantes(ListArrayGeneric estudiantes) {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);
        scannerStr.useDelimiter("\n");
        System.out.println("\n\n Usted ha seleccionado editar estudiantes, seleccione el número del estudiante a editar:");
        int numeroEst = scanner.nextInt();
        limpiarConsola();
        if (numeroEst <= estudiantes.size() && numeroEst > 0) {
            Estudiante estCambio = (Estudiante) estudiantes.getItemInPosition(numeroEst - 1);
            System.out.println("Mostrando la información del estudiante: " + numeroEst + ".\n" + estCambio.toStringAdmin() + "\n\n\n");
            System.out.println("Seleccione el número del parametro a editar:\n1. Codigo\n2. Nombre\n3. Apellido \n4. Usuario \n5. Contraseña\n\n\n");

            switch (scanner.nextInt()) {

                case 1:

                    System.out.println("\n\nIngrese el nuevo código:\n");
                    estCambio.setCodigo(scanner.nextInt());
                    System.out.println("\n\nCambio realizado correctamente\n");
                    break;

                case 2:

                    System.out.println("\n\nIngrese el nuevo nombre:\n");
                    estCambio.setNombre(scannerStr.next());
                    System.out.println("\n\nCambio realizado correctamente\n");
                    break;

                case 3:

                    System.out.println("\n\nIngrese el nuevo apellido:\n");
                    estCambio.setApellido(scannerStr.next());
                    System.out.println("\n\nCambio realizado correctamente\n");
                    break;

                case 4:

                    System.out.println("\n\nIngrese el nuevo usuario:\n");
                    estCambio.setUsuario(scannerStr.next());
                    System.out.println("\n\nCambio realizado correctamente\n");
                    break;

                case 5:

                    System.out.println("\n\nIngrese la nueva contraseña:\n");
                    estCambio.setContraseña(scannerStr.next());
                    System.out.println("\n\nCambio realizado correctamente\n");
                    break;

                case 6:
                    System.out.println("\n\nIngrese el nuevo pregrado:\n");
                    estCambio.setPregado(scannerStr.next());
                    System.out.println("\n\nCambio realizado correctamente\n");
                    break;

                default:
                    break;
            }
            estudiantes.pushAt(estCambio, numeroEst - 1);
        } else {
            System.out.println("\n\nEl número seleccionado no se encuentra en la lista.\n\n");
            return estudiantes;
        }



        return estudiantes;
    }

    
    //Funciones Estudiante
    
    static LinkedListGeneric<Casilla> añadirActividad(LinkedListGeneric<Casilla> casillas) {

        boolean continuar = false;
        Calendar fechaInicioAct = new GregorianCalendar();
        Calendar fechaFinAct = new GregorianCalendar();

        Calendar dateTime = Calendar.getInstance();
        Scanner scanner = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);
        scannerStr.useDelimiter("\n");

        Actividad nuevaActividad = new Actividad();

        System.out.println("Usted ha seleccionado crear una nueva actividad, por favor ingrese los siguientes parámetros:\n\n");
        System.out.println("Ingrese el título\n");
        nuevaActividad.setTitulo(scannerStr.next());

        System.out.println("\nIngrese la descripcion\n");
        nuevaActividad.setDescripcion(scannerStr.next());

        System.out.println("\nIngrese el grado de importancia (1-5)\n");

        nuevaActividad.setImportancia(scanner.nextInt());

        System.out.print("\nRecuerde que solo se pueden crear actividades a partir de hoy:  \n");
        System.out.printf("%tF\n", dateTime);

        while (!continuar) {
            System.out.println("\nIngrese la fecha de inicio\nNumero del mes");
            int mes = scanner.nextInt() - 1;

            System.out.println("\nDia");
            int dia = scanner.nextInt();

            System.out.println("\nHora de inicio en formato HH:MM");
            String horaString = scanner.next();
            int hora;
            int minuto;
            char[] horaCharArray = horaString.toCharArray();
            if (horaCharArray.length == 4) {
                hora = Integer.parseInt((String.valueOf(horaString.charAt(0))));
                minuto = Integer.parseInt(horaString.substring(2));
            } else {
                String time = String.valueOf(horaString.charAt(0)).concat(String.valueOf(horaString.charAt(1)));
                hora = Integer.parseInt(time);
                minuto = Integer.parseInt(horaString.substring(3));
            }

            System.out.println("\nHora de finalización en formato HH:MM");
            String horaStringF = scanner.next();
            int horaF;
            int minutoF;
            char[] horaCharArrayF = horaStringF.toCharArray();
            if (horaCharArrayF.length == 4) {
                horaF = Integer.parseInt((String.valueOf(horaStringF.charAt(0))));
                minutoF = Integer.parseInt(horaStringF.substring(2));
            } else {
                String timeF = String.valueOf(horaStringF.charAt(0)).concat(String.valueOf(horaStringF.charAt(1)));
                horaF = Integer.parseInt(timeF);
                minutoF = Integer.parseInt(horaStringF.substring(3));
            }

            fechaInicioAct = new GregorianCalendar(2020, mes, dia, hora, minuto, 0);
            fechaFinAct = new GregorianCalendar(2020, mes, dia, horaF, minutoF, 0);

            if (dateTime.get(Calendar.DAY_OF_YEAR) > fechaInicioAct.get(Calendar.DAY_OF_YEAR)) {
                System.out.println("La fecha de creación ya pasó\nPor favor, vuelva a ingresar la fecha de la actividad");
                continuar = false;
            } else {
                continuar = true;
            }

        }

        nuevaActividad.setFechaInicio(fechaInicioAct);
        nuevaActividad.setFechaFinalizacion(fechaFinAct);
        casillas.insert(nuevaActividad);
        System.out.println("\nActividad creada correctamente.\n");

        return casillas;
    }

    static Estudiante getUsuario(String usuario, ListArrayGeneric estudiantes) {

        Persona estVar = new Persona();

        for (int i = 0; i < estudiantes.size(); i++) {
            estVar = (Persona) estudiantes.getItemInPosition(i);
            if (usuario.equals((String) estVar.getUsuario())) {
                return (Estudiante) estVar;
            }

        }

        return null;
    }

    static void agregarGrupoEst(Materia materia) {
        Grupo[] grupos = materia.getGrupos();

        for (Grupo grupo : grupos) {

            System.out.println(grupo);

        }
    }

    static void mostrarMateriasEst(LinkedListGeneric<Casilla> casillas) {

        NodeGeneric<Casilla> nodoN = new NodeGeneric<>();
        nodoN = casillas.getHead();
        NodeGeneric<Casilla> nodoIterador = new NodeGeneric<>();
        nodoIterador = null;
        Materia mat = new Materia();
        Casilla casillaIteradora = new Casilla();
        LinkedListGeneric<Casilla> mostrarMat = new LinkedListGeneric<Casilla>();
        Calendar fechamin = new GregorianCalendar(2020, 2, 2, 0, 0, 0);
        Calendar fechamax = new GregorianCalendar(2020, 2, 4, 0, 0, 0);
        while (nodoN != null) {
            casillaIteradora = nodoN.getData();

            if (casillaIteradora instanceof Materia && casillaIteradora.getFechaInicio().compareTo(fechamin) > 0 && casillaIteradora.getFechaInicio().compareTo(fechamax) < 0) {
                mostrarMat.insert(casillaIteradora);
                mat = (Materia) casillaIteradora;
                System.out.println(mat.toStringMateriaHora());
            }

            nodoIterador = nodoN;
            nodoN = nodoN.getNext();

        }

    }

    static String extraerMateria(LinkedListGeneric<Casilla> casillas) {

        NodeGeneric<Casilla> nodoN = new NodeGeneric<>();
        Scanner scan = new Scanner(System.in);
        nodoN = casillas.getHead();
        int numeroTotalMaterias;
        NodeGeneric<Casilla> nodoIterador = new NodeGeneric<>();
        nodoIterador = null;
        Materia mat = new Materia();
        Casilla casillaIteradora = new Casilla();
        LinkedListGeneric<Casilla> mostrarMat = new LinkedListGeneric<Casilla>();
        Calendar fechamin = new GregorianCalendar(2020, 2, 2, 0, 0, 0);
        Calendar fechamax = new GregorianCalendar(2020, 2, 4, 0, 0, 0);

        System.out.println("A continuación se muestra las materias que tiene inscritas:\n\n");

        while (nodoN != null) {
            casillaIteradora = nodoN.getData();

            if (casillaIteradora instanceof Materia && casillaIteradora.getFechaInicio().compareTo(fechamin) > 0 && casillaIteradora.getFechaInicio().compareTo(fechamax) < 0) {
                mostrarMat.insert(casillaIteradora);
                mat = (Materia) casillaIteradora;
                System.out.println(mat.toStringMateriaHora());

            }
            nodoIterador = nodoN;
            nodoN = nodoN.getNext();

        }

        numeroTotalMaterias = Materia.getNum();
        Materia.setNum(1);

        if (mostrarMat.isEmpty()) {
            limpiarConsola();
            System.out.println("Usted no tiene materias inscritas, cancelando la operación.\n\n");
            return " ";
        }

        System.out.println("\nSeleccione el número de la materia que desee retirar.\n\n");

        int numeroMateria = scan.nextInt();

        if (numeroMateria > 0 && numeroMateria <= numeroTotalMaterias) {
            int i = 1;
            nodoN = casillas.getHead();
            nodoIterador = null;

            while (i <= numeroMateria) {

                casillaIteradora = nodoN.getData();
                nodoIterador = nodoN;
                nodoN = nodoN.getNext();
                i++;
            }
            return casillaIteradora.getTitulo();

        } else {
            System.out.println("Opción invalida, cancelando la operación");

            return " ";
        }

    }
    
    static LinkedListGeneric<Casilla> eliminarMateria(LinkedListGeneric<Casilla> casillas, String titulo) {
        if (titulo.equals(" ")) {
            return casillas;
        }

        NodeGeneric<Casilla> nodoN = new NodeGeneric<>();
        nodoN = casillas.getHead();
        NodeGeneric<Casilla> nodoIterador = new NodeGeneric<>();
        nodoIterador = null;
        Casilla casillaIteradora = new Casilla();
        LinkedListGeneric<Casilla> mostrarMat = new LinkedListGeneric<Casilla>();
        while (nodoN != null) {
            casillaIteradora = nodoN.getData();

            if (casillaIteradora instanceof Materia && titulo.equals((String) casillaIteradora.getTitulo())) {
                nodoIterador = nodoN;
                nodoN = nodoN.getNext();
                continue;
            }

            mostrarMat.insert(casillaIteradora);
            nodoIterador = nodoN;
            nodoN = nodoN.getNext();

        }

        limpiarConsola();
        System.out.println("Se ha removido con éxito la materia seleccionada\n\n");

        return mostrarMat;
    }
    
    static String extraerActividad(LinkedListGeneric<Casilla> casillas) {

        NodeGeneric<Casilla> nodoN = new NodeGeneric<>();
        Scanner scan = new Scanner(System.in);
        nodoN = casillas.getHead();
        int numeroTotalActividades;
        NodeGeneric<Casilla> nodoIterador = new NodeGeneric<>();
        nodoIterador = null;
        Actividad act = new Actividad();
        Casilla casillaIteradora = new Casilla();
        LinkedListGeneric<Casilla> mostrarAct = new LinkedListGeneric<Casilla>();

        System.out.println("A continuación se muestra las actividades que tiene programadas:\n\n");

        while (nodoN != null) {
            casillaIteradora = nodoN.getData();

            if (casillaIteradora instanceof Actividad) {
                mostrarAct.insert(casillaIteradora);
                act = (Actividad) casillaIteradora;
                System.out.println(Actividad.getNum() + ". " + act.toString());
                Actividad.setNum(Actividad.getNum() + 1);
            }
            nodoIterador = nodoN;
            nodoN = nodoN.getNext();

        }

        numeroTotalActividades = Actividad.getNum();
        Actividad.setNum(1);

        if (mostrarAct.isEmpty()) {
            limpiarConsola();
            System.out.println("Usted no tiene actividades creadas, cancelando la operación.\n\n");
            return " ";
        }

        System.out.println("\nSeleccione el número de la actividad que desee retirar.\n\n");

        int numeroRet = scan.nextInt();

        if (numeroRet > 0 && numeroRet <= numeroTotalActividades) {
            int i = 1;
            nodoN = casillas.getHead();
            nodoIterador = null;

            while (i <= numeroRet) {

                casillaIteradora = nodoN.getData();
                nodoIterador = nodoN;
                nodoN = nodoN.getNext();
                i++;
            }
            return casillaIteradora.getTitulo();

        } else {
            System.out.println("Opción invalida, cancelando la operación");

            return " ";
        }
    }
    
    static String extraerActividadEditar(LinkedListGeneric<Casilla> casillas) {

        NodeGeneric<Casilla> nodoN = new NodeGeneric<>();
        Scanner scan = new Scanner(System.in);
        nodoN = casillas.getHead();
        int numeroTotalActividades;
        NodeGeneric<Casilla> nodoIterador = new NodeGeneric<>();
        nodoIterador = null;
        Actividad act = new Actividad();
        Casilla casillaIteradora = new Casilla();
        LinkedListGeneric<Casilla> mostrarAct = new LinkedListGeneric<Casilla>();

        System.out.println("\n\n\nA continuación se muestra las actividades que tiene programadas:\n\n");

        while (nodoN != null) {
            casillaIteradora = nodoN.getData();

            if (casillaIteradora instanceof Actividad) {
                mostrarAct.insert(casillaIteradora);
                act = (Actividad) casillaIteradora;
                System.out.println(Actividad.getNum() + ". " + act.toString());
                Actividad.setNum(Actividad.getNum() + 1);
            }
            nodoIterador = nodoN;
            nodoN = nodoN.getNext();

        }

        numeroTotalActividades = Actividad.getNum();
        Actividad.setNum(1);

        if (mostrarAct.isEmpty()) {
            limpiarConsola();
            System.out.println("Usted no tiene actividades creadas, cancelando la operación.\n\n");
            return " ";
        }

        System.out.println("\nSeleccione el número de la actividad que desee editar.\n");

        int numeroRet = scan.nextInt();

        if (numeroRet > 0 && numeroRet <= numeroTotalActividades) {
            int i = 1;
            nodoN = casillas.getHead();
            nodoIterador = null;

            while (i <= numeroRet) {

                casillaIteradora = nodoN.getData();
                nodoIterador = nodoN;
                nodoN = nodoN.getNext();
                i++;
            }
            
            return casillaIteradora.getTitulo();

        } else {
            System.out.println("Opción invalida, cancelando la operación");

            return " ";
        }
    }
    
    static LinkedListGeneric<Casilla> eliminarActividad(LinkedListGeneric<Casilla> casillas, String titulo) {
        if (titulo.equals(" ")) {
            return casillas;
        }

        NodeGeneric<Casilla> nodoN = new NodeGeneric<>();
        nodoN = casillas.getHead();
        NodeGeneric<Casilla> nodoIterador = new NodeGeneric<>();
        nodoIterador = null;
        Casilla casillaIteradora = new Casilla();
        LinkedListGeneric<Casilla> mostrarAct = new LinkedListGeneric<Casilla>();
        while (nodoN != null) {
            casillaIteradora = nodoN.getData();

            if (casillaIteradora instanceof Actividad && titulo.equals((String) casillaIteradora.getTitulo())) {
                nodoIterador = nodoN;
                nodoN = nodoN.getNext();
                continue;
            }

            mostrarAct.insert(casillaIteradora);
            nodoIterador = nodoN;
            nodoN = nodoN.getNext();

        }

        limpiarConsola();
        System.out.println("Se ha removido con éxito la actividad seleccionada\n\n");
        return mostrarAct;
    }
    
    static Casilla actividadEditar(LinkedListGeneric<Casilla> casillas, String titulo) {
        
        NodeGeneric<Casilla> nodoN = new NodeGeneric<>();
        nodoN = casillas.getHead();
        NodeGeneric<Casilla> nodoIterador = new NodeGeneric<>();
        nodoIterador = null;
        Casilla casillaIteradora = new Casilla();
        while (nodoN != null) {
            casillaIteradora = nodoN.getData();

            if (casillaIteradora instanceof Actividad && titulo.equals((String) casillaIteradora.getTitulo())) {
                return casillaIteradora;
            }
            nodoIterador = nodoN;
            nodoN = nodoN.getNext();
        }
        return null;
    }
 
    static LinkedListGeneric<Casilla> modificarActividad(Casilla spot, LinkedListGeneric<Casilla> casillas) {
        LinkedListGeneric<Casilla> newCasillas=eliminarActividad(casillas, spot.getTitulo());
        Actividad modified =(Actividad)spot;
        boolean continuar=false;
        boolean modificacion=false;
        Calendar fechaInicioAct = new GregorianCalendar();
        Calendar fechaFinAct = new GregorianCalendar();
        Calendar dateTime = Calendar.getInstance();
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        System.out.println("Seleccione el número de la opcion a editar\n1. Nombre\n2. Descripción\n3. Importancia\n4. Fecha de la actividad\n");
        int s = scanner.nextInt();
        while (!modificacion){
            switch (s) {
                case (1):

                    System.out.println("\n\nIngrese el nuevo nombre");
                    modified.setTitulo(scanner.next());
                    modificacion=true;
                    break;

                case (2):

                    System.out.println("\n\nIngrese la nueva descripcion");
                    modified.setDescripcion(scanner.next());
                    modificacion=true;
                    break;

                case (3):

                    System.out.println("\n\nIngrese el nuevo grado de importancia");
                    int value = scanner.nextInt();
                    while (value > 5) {
                        System.out.println("El grado de importancia es mayor a 5, intente de nuevo");
                        value = scanner.nextInt();
                    }
                    modified.setImportancia(value);
                    modificacion=true;
                    break;
                case (4):
                    System.out.print("\nRecuerde que solo se pueden crear actividades a partir de hoy:  \n");
                    System.out.printf("%tF\n", dateTime);

                    while (!continuar) {
                        System.out.println("\nIngrese la fecha de inicio\nNumero del mes");
                        int mes = scanner.nextInt() - 1;

                        System.out.println("\nDia");
                        int dia = scanner.nextInt();

                        System.out.println("\nHora de inicio en formato HH:MM");
                        String horaString = scanner.next();
                        int hora;
                        int minuto;
                        char[] horaCharArray = horaString.toCharArray();
                        if (horaCharArray.length == 4) {
                            hora = Integer.parseInt((String.valueOf(horaString.charAt(0))));
                            minuto = Integer.parseInt(horaString.substring(2));
                        } else {
                            String time = String.valueOf(horaString.charAt(0)).concat(String.valueOf(horaString.charAt(1)));
                            hora = Integer.parseInt(time);
                            minuto = Integer.parseInt(horaString.substring(3));
                        }

                        System.out.println("\nHora de finalización en formato HH:MM");
                        String horaStringF = scanner.next();
                        int horaF;
                        int minutoF;
                        char[] horaCharArrayF = horaStringF.toCharArray();
                        if (horaCharArrayF.length == 4) {
                            horaF = Integer.parseInt((String.valueOf(horaStringF.charAt(0))));
                            minutoF = Integer.parseInt(horaStringF.substring(2));
                        } else {
                            String timeF = String.valueOf(horaStringF.charAt(0)).concat(String.valueOf(horaStringF.charAt(1)));
                            horaF = Integer.parseInt(timeF);
                            minutoF = Integer.parseInt(horaStringF.substring(3));
                        }

                        fechaInicioAct = new GregorianCalendar(2020, mes, dia, hora, minuto, 0);
                        fechaFinAct = new GregorianCalendar(2020, mes, dia, horaF, minutoF, 0);

                        if (dateTime.get(Calendar.DAY_OF_YEAR) > fechaInicioAct.get(Calendar.DAY_OF_YEAR)) {
                            System.out.println("La fecha de creación ya pasó\nPor favor, vuelva a ingresar la fecha de la actividad");
                            continuar = false;
                        } else {
                            continuar = true;
                        }

                    }
                    modified.setFechaInicio(fechaInicioAct);
                    modified.setFechaFinalizacion(fechaFinAct);
                    modificacion=true;
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo");
                    limpiarConsola();
                    modificacion=true;
                    break;

            }
        }
        System.out.println("\n\nActividad Modificada con éxito\n\n");
        newCasillas.insert(modified);
        return newCasillas;
    }

    
    //Operaciones principales del programa
    
    static void opcionesAdmin(ListArrayGeneric estudiantes, StackArraySpot materias) {
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;
        while (continuar) {

            System.out.println("Seleccione cuál de las siguientes opciones desea realizar:\n1. Ver estudiantes\n2. Ver cursos\n3. Salir del modo administrador.");

            switch (scanner.nextInt()) {

                case 1:
                    limpiarConsola();
                    System.out.println("Usted ha seleccionado ver estudiantes, a continuación se muestra la lista de los estudiantes existentes:\n\n");
                    int numeroEst = 1;
                    Estudiante us1 = new Estudiante();
                    for (int i = 0; i < estudiantes.size(); i++) {
                        us1 = (Estudiante) estudiantes.getItemInPosition(i);
                        System.out.println(numeroEst + ": " + us1.toStringAdmin() + "\n");
                        numeroEst++;
                    }

                    System.out.println("\n\n\n\nSeleccione cuál de las siguientes opciones desea realizar:\n1. Editar estudiantes\n2. Volver \n3. Salir del modo administrador");
                    int select=scanner.nextInt();
                    if ( select== 1) {
                        estudiantes = cambioEstudiantes(estudiantes);
                    }else if(select==2){
                        limpiarConsola();
                        continue;
                        
                    }else if(select==3){
                        limpiarConsola();
                        continuar=false;
                        continue;
                        
                    }else {
                        limpiarConsola();
                        System.out.println("Opción invalida.");
                        continuar=false;
                        
                    }
                    continuar=seguirEstudiante();
                    limpiarConsola();
                    break;

                case 2:
                    int numeromat = 1;
                    limpiarConsola();
                    System.out.println("Usted ha seleccionado ver cursos, a continuación se muestra la lista de los cursos existentes:\n");
                    Materia m1 = new Materia();
                    for (int i = 0; i < materias.getLenght(); i++) {
                        m1 = (Materia) materias.getItemInPosition(i);
                        System.out.println(numeromat + ": " + m1.toStringNoGroups() + "\n");
                        numeromat++;
                    }
                    System.out.println("\n\n\nSeleccione cuál de las siguientes opciones desea realizar ahora:\n1. Editar materias\n2. Ver grupos\n3. Volver\n4. Salir del modo administrador");

                    switch (scanner.nextInt()) {

                        case 1:

                            materias = cambiarMateria(materias);

                            break;

                        case 2:

                            materias = cambioGrupo(materias);
                            break;

                        case 3:
                            limpiarConsola();
                            continue;
                        
                        case 4:
                            limpiarConsola();
                            continuar=false;
                            break;

                        default:
                            limpiarConsola();
                            System.out.println("Opción invalida");

                            break;

                    }
                    
                    System.out.println("\n\n\n\n");
                    continuar = seguirEstudiante();
                    limpiarConsola();
                    break;

                case 3:
                    limpiarConsola();
                    continuar=false;
                        
                    break;

                default:
                    System.out.println("Opción invalida\n\n");
                    continuar = seguirEstudiante();
                    limpiarConsola();
                    break;

            }
        }
    }

    static void opcionesEst(Estudiante estudiante, StackArraySpot materias) {

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n\nSeleccione cuál de las siguientes opciones desea realizar:\n\n1. Ver todas las actividades programadas\n2. Configurar actividades\n3. Ver horario académico\n4. Editar horario academico\n5. Salir del modo estudiante\n");

            switch (scanner.nextInt()) {

                case 1:
                    limpiarConsola();
                    System.out.println("\n\nA continuación se muestran todas las actividades programadas\n\n");
                    estudiante.getCasillas().printRecursive();
                    System.out.println("\n\n\n\n");
                    continuar = seguirEstudiante();
                    limpiarConsola();
                    break;

                case 2:
                    limpiarConsola();
                    System.out.println("Usted seleccionó editar actividades, seleccione la opción a realizar:\n\n1. Crear actividad\n2. Eliminar actividad\n3. Editar actividad\n4. Volver\n5. Salir del modo estudiante\n");

                    switch (scanner.nextInt()) {

                        case 1:

                            boolean continuar2 = true;
                            while (continuar2) {
                                limpiarConsola();

                                estudiante.setCasillas(añadirActividad(estudiante.getCasillas()));

                                System.out.println("\nSeleccione qué opcion desea realizar:\n\n1. Crear otra actividad\n2. Volver\n3. Salir del modo estudiante");
                                
                                int cond = scanner.nextInt();
                                
                                if ( cond== 1) {
                                    continuar2 = true;
                                }else if (cond==2){
                                    continuar2 = false;
                                    
                                }else if(cond==3){
                                    continuar = false;
                                    continuar2 = false;
                                }
                            }

                            break;

                        case 2:
                            
                            boolean continuar4 = true;
                            while (continuar4) {
                                limpiarConsola();
                                String titulo = extraerActividad(estudiante.getCasillas());
                                estudiante.setCasillas(eliminarActividad(estudiante.getCasillas(), titulo));
                                
                                System.out.println("\nSeleccione qué opcion desea realizar:\n\n1. Eliminar otra actividad\n2. Volver\n3. Salir del modo estudiante");
                                
                                int cond = scanner.nextInt();
                                
                                if ( cond== 1) {
                                    continuar4 = true;
                                }else if (cond==2){
                                    continuar4 = false;
                                    
                                }else if(cond==3){
                                    continuar = false;
                                    continuar4 = false;
                                }
                            }
                            
                            limpiarConsola();
                            continue;

                        case 3:
                            estudiante.setCasillas(modificarActividad(actividadEditar(estudiante.getCasillas(), extraerActividadEditar(estudiante.getCasillas())), estudiante.getCasillas()));                            
                            limpiarConsola();
                            break;
                            
                            
                        case 4:
                            limpiarConsola();
                            continue;

                            
                        case 5:
                            limpiarConsola();
                            continuar=false;
                            continue;
                            
                        default:
                            limpiarConsola();
                            System.out.println("Opción inválida, cancelando operación.");

                            break;

                    }

                    continuar = seguirEstudiante();
                    limpiarConsola();
                    break;

                case 3:
                    limpiarConsola();
                    System.out.println("\nA continuación se muestra su horario académico actual:\n\n");
                    mostrarMateriasEst(estudiante.getCasillas());
                    Materia.setNum(1);
                    System.out.println("\n\n\n\n");
                    continuar = seguirEstudiante();
                    limpiarConsola();
                    break;

                case 4:
                    Scanner scanner3 = new Scanner(System.in);
                    int numeromat = 1;
                    limpiarConsola();

                    System.out.println("Usted ha seleccionado editar su horario académico\nSeleccione cual de las siguientes opciones desea realizar:\n1. Agregar cursos\n2. Eliminar cursos\n3. Volver");
                    Materia m1 = new Materia();

                    switch (scanner3.nextInt()) {

                        case 1:

                            boolean continuar3 = true;
                            while (continuar3) {
                                limpiarConsola();
                                System.out.println("Usted ha seleccionado agregar cursos, a continuación se muestran todas las materias en el sistema.\n\n");
                                for (int i = 0; i < materias.getLenght(); i++) {
                                    m1 = (Materia) materias.getItemInPosition(i);
                                    System.out.println(numeromat + ": " + m1.toStringNoGroups() + "\n");
                                    numeromat++;
                                }
                                System.out.println("\n\nSeleccione una materia para elegir sus grupos.");
                                int numeroGrupo = scanner3.nextInt();

                                if (numeroGrupo <= 0 || numeroGrupo > materias.getLenght()) {
                                    limpiarConsola();
                                    System.out.println("Opción invalida, cancelando la operación.\n\n");
                                    break;
                                }

                                m1 = (Materia) materias.getItemInPosition(numeroGrupo - 1);
                                System.out.println("\nGrupos de la materia seleccionada: \n");
                                agregarGrupoEst(m1);
                                System.out.println("\n\nSeleccione el número del grupo para añadir.");
                                int numeroGrupoF = scanner3.nextInt();
                                if (numeroGrupoF <= 0 || numeroGrupoF > m1.getGrupos().length) {
                                    limpiarConsola();
                                    System.out.println("Opción invalida, cancelando la operación.\n\n");
                                    break;
                                }

                                seleccionarGrupo(estudiante, m1, numeroGrupoF);

                                System.out.println("\nSeleccione la opcion a realizar:\n\n1. Agregar otro curso. \n2. Volver.");
                                if (!(scanner.nextInt() == 1)) {
                                    limpiarConsola();
                                    continuar3 = false;
                                }
                                numeromat = 1;
                            }

                            continue;

                        case 2:
                            boolean continuar4 = true;
                            while (continuar4) {
                                limpiarConsola();
                                String titulo = extraerMateria(estudiante.getCasillas());
                                estudiante.setCasillas(eliminarMateria(estudiante.getCasillas(), titulo));
                                System.out.println("\nSeleccione qué opcion desea realizar:\n\n1. Eliminar otra materia\n2. Volver");
                                if (scanner.nextInt() != 1) {
                                    continuar4 = false;
                                }

                            }
                            limpiarConsola();
                            continue;
                            
                        case 3:
                            limpiarConsola();
                            continue;
                        
                        default:
                            limpiarConsola();
                            System.out.println("\n\nOpción inválida, cancelando operación.\n\n");
                            break;

                    }

                    System.out.println("\n\n\n\n");
                    continuar = seguirEstudiante();
                    limpiarConsola();
                    break;

                case 5:
                    limpiarConsola();
                    continuar = false;
                    break;

                default:
                    limpiarConsola();
                    System.out.println("\n\nOpción inválida.\n\n");
                    continuar = false;
                    break;
            }
        }
    }

}
