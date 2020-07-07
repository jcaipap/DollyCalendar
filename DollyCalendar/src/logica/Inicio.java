
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import com.sun.org.apache.xalan.internal.lib.NodeInfo;
import data.Actividad;
import data.AdminDataBaseHandler;
import data.Casilla;
import data.Grupo;
import data.Materia;
import data.Persona;
import data.Estudiante;
import data.MateriasDataBaseHandler;
import data.UsuariosDataBaseHandler;
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
import gui.GUIAñadirGrupo;
import gui.GUIBuscador;
import gui.GUIGeneracionUsuario;
import gui.GUIInicio;
import gui.GUIInicioAdmin;
import gui.GUIPruebas;
import gui.GUIVerMaterias;
import gui.GUIVerUsuarios;
import static java.awt.Color.black;
import java.io.IOException;
import java.lang.reflect.Array;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author andre
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException {



        
        Calendar[] fechaLC7 = new Calendar[]{Metodos.calendarGenerator(2020, 2, 2, 7, 0), Metodos.calendarGenerator(2020, 2, 4, 7, 0)};
        Calendar[] fechaLC9 = new Calendar[]{Metodos.calendarGenerator(2020, 2, 2, 9, 0), Metodos.calendarGenerator(2020, 2, 4, 9, 0)};
        Calendar[] fechaLC11 = new Calendar[]{Metodos.calendarGenerator(2020, 2, 2, 11, 0), Metodos.calendarGenerator(2020, 2, 4, 11, 0)};
        Calendar[] fechaLC14 = new Calendar[]{Metodos.calendarGenerator(2020, 2, 2, 14, 0), Metodos.calendarGenerator(2020, 2, 4, 14, 0)};
        Calendar[] fechaLC16 = new Calendar[]{Metodos.calendarGenerator(2020, 2, 2, 16, 0), Metodos.calendarGenerator(2020, 2, 4, 16, 0)};
        Calendar[] fechaMJ7 = new Calendar[]{Metodos.calendarGenerator(2020, 2, 3, 7, 0), Metodos.calendarGenerator(2020, 2, 5, 7, 0)};
        Calendar[] fechaMJ9 = new Calendar[]{Metodos.calendarGenerator(2020, 2, 3, 9, 0), Metodos.calendarGenerator(2020, 2, 5, 9, 0)};
        Calendar[] fechaMJ11 = new Calendar[]{Metodos.calendarGenerator(2020, 2, 3, 11, 0), Metodos.calendarGenerator(2020, 2, 5, 11, 0)};
        Calendar[] fechaMJ14 = new Calendar[]{Metodos.calendarGenerator(2020, 2, 3, 14, 0), Metodos.calendarGenerator(2020, 2, 5, 14, 0)};
        Calendar[] fechaMJ16 = new Calendar[]{Metodos.calendarGenerator(2020, 2, 3, 16, 0), Metodos.calendarGenerator(2020, 2, 5, 16, 0)};
        Calendar[] fechaLCV = new Calendar[]{Metodos.calendarGenerator(2020, 2, 2, 16, 0), Metodos.calendarGenerator(2020, 2, 4, 9, 0), Metodos.calendarGenerator(2020, 2, 6, 9, 0)};
        Grupo[] gruposED=new Grupo[5];
        

//        PriorityQueue<Grupo> gruposED2=new PriorityQueue<>(true);
//        HashGeneric<Integer,Grupo> gruposxd=new HashGeneric<>();


        Grupo grupoED2 = new Grupo(2, "David Herrera", fechaMJ14);
        Grupo grupoED1 = new Grupo(1, "Cristian Cordoba", fechaLC7);
        Grupo grupoED3 = new Grupo(3, "Victor Collazos", fechaLC9);
        Grupo grupoED4 = new Grupo(4, "Luis Niño", fechaMJ11);
        Grupo grupoED5 = new Grupo(5, "David Herrera", fechaLC14);
       
        gruposED[0] = grupoED1;
        gruposED[1] = grupoED2;
        gruposED[2] = grupoED3;
        gruposED[3] = grupoED4;
        gruposED[4] = grupoED5;

        Materia estructuras = new Materia("Estructuras de datos", "Curso de programación de estructuras de datos.", 3, 2016699, 3, "Disciplinar", gruposED);

        Grupo[] gruposAlgebra = new Grupo[5];
        Grupo grupoAlgebra1 = new Grupo(1, "Zulima Ortiz", fechaLC14);
        Grupo grupoAlgebra2 = new Grupo(2, "Jaime Robayo", fechaLC9);
        Grupo grupoAlgebra3 = new Grupo(3, "Gustavo Nieto", fechaMJ16);
        Grupo grupoAlgebra4 = new Grupo(4, "Leonor Campos", fechaMJ11);
        Grupo grupoAlgebra5 = new Grupo(5, "Miguel Rippe", fechaLC11);
        gruposAlgebra[0] = grupoAlgebra1;
        gruposAlgebra[1] = grupoAlgebra2;
        gruposAlgebra[2] = grupoAlgebra3;
        gruposAlgebra[3] = grupoAlgebra4;
        gruposAlgebra[4] = grupoAlgebra5;
        Materia algebra = new Materia("Algebra lineal", "Curso de Algebra lineal, sistemas matriciales y valores y vectores propios.", 4, 1000003, 4, "Fundamentacion", gruposAlgebra);
        Grupo[] gruposCalculoD = new Grupo[5];
        Grupo grupoCalculoD1 = new Grupo(1, "Oscar Parra", fechaMJ16);
        Grupo grupoCalculoD2 = new Grupo(2, "Carlos Giraldo", fechaLC9);
        Grupo grupoCalculoD3 = new Grupo(3, "Efrain Pardo", fechaMJ16);
        Grupo grupoCalculoD4 = new Grupo(4, "Gabriel Padilla", fechaLC16);
        Grupo grupoCalculoD5 = new Grupo(5, "Luis Quicazan", fechaMJ7);
        gruposCalculoD[0] = grupoCalculoD1;
        gruposCalculoD[1] = grupoCalculoD2;
        gruposCalculoD[2] = grupoCalculoD3;
        gruposCalculoD[3] = grupoCalculoD4;
        gruposCalculoD[4] = grupoCalculoD5;
        Materia calculoD = new Materia("Calculo diferencial", "Curso de calculo diferencial y aplicaciones basicas de optimizacion.", 4, 1000004, 4, "Fundamentacion", gruposCalculoD);
        Grupo[] gruposCalculoV= new Grupo[4];
        Grupo grupoCalculoV1 = new Grupo(1, "Mauricio Lopez", fechaLC7);
        Grupo grupoCalculoV2 = new Grupo(2, "Jason Hernandez", fechaLC9);
        Grupo grupoCalculoV3 = new Grupo(3, "Edixon Rojas", fechaLC16);
        Grupo grupoCalculoV4 = new Grupo(4, "Felix Soriano", fechaLC11);
        gruposCalculoV[0] = grupoCalculoV1;
        gruposCalculoV[1] = grupoCalculoV2;
        gruposCalculoV[2] = grupoCalculoV3;
        gruposCalculoV[3] = grupoCalculoV4;
        Materia calculoV = new Materia("Calculo en varias variables", "Curso de calculo en multiples variables.", 4, 1000006, 4, "Fundamentacion", gruposCalculoV);
        Grupo[] gruposCalculoI = new Grupo[4];
        Grupo grupoCalculoI1 = new Grupo(1, "Jeanneth Galeano", fechaMJ9);
        Grupo grupoCalculoI2 = new Grupo(2, "Alexandre Sinitsyne", fechaLC9);
        Grupo grupoCalculoI3 = new Grupo(3, "Arcenio Pecha", fechaMJ16);
        Grupo grupoCalculoI4 = new Grupo(4, "Victor Tapia", fechaLC11);
        gruposCalculoI[0] = grupoCalculoI1;
        gruposCalculoI[1] = grupoCalculoI2;
        gruposCalculoI[2] = grupoCalculoI3;
        gruposCalculoI[3] = grupoCalculoI4;
        Materia calculoI = new Materia("Calculo Integral", "Calculo integral, aplicaciones, y series.", 4, 1000005, 4, "Fundamentacion", gruposCalculoI);
        Grupo[] gruposVariableC = new Grupo[3];
        Grupo grupoVariableC1 = new Grupo(1, "Agustin Moreno", fechaLC9);
        Grupo grupoVariableC2 = new Grupo(2, "German Fonseca", fechaMJ9);
        Grupo grupoVariableC3 = new Grupo(3, "Ivan Castro", fechaMJ11);
        gruposVariableC[0] = grupoVariableC1;
        gruposVariableC[1] = grupoVariableC2;
        gruposVariableC[2] = grupoVariableC3;
        Materia variableC = new Materia("Variable Compleja", "Estudio de sistemas en variable compleja y planos reales e imaginarios.", 4, 2015159, 4, "Fundamentacion", gruposVariableC);
        Grupo[] gruposECD = new Grupo[4];
        Grupo grupoECD1 = new Grupo(1, "Ricardo Pastran", fechaLC7);
        Grupo grupoECD2 = new Grupo(2, "Nicolas Martinez", fechaLC9);
        Grupo grupoECD3 = new Grupo(3, "Hernan Garzon", fechaLC16);
        Grupo grupoECD4 = new Grupo(4, "German Fonseca", fechaLC11);
        gruposECD[0] = grupoECD1;
        gruposECD[1] = grupoECD2;
        gruposECD[2] = grupoECD3;
        gruposECD[3] = grupoECD4;
        Materia ecuaciones = new Materia("Ecuaciones diferenciales", "Curso de ecuaciones diferenciales ordinarias.", 4, 1000007, 4, "Fundamentacion", gruposECD);

        Grupo[] gruposEA = new Grupo[4];
        Grupo grupoEA1 = new Grupo(1, "Carlos Perilla", fechaLC9);
        Grupo grupoEA2 = new Grupo(2, "Pablo Rodriguez", fechaLC11);
        Grupo grupoEA3 = new Grupo(3, "Jesus Quintero", fechaMJ7);
        Grupo grupoEA4 = new Grupo(4, "Pablo Rodriguez", fechaMJ11);
        gruposEA[0] = grupoEA1;
        gruposEA[1] = grupoEA2;
        gruposEA[2] = grupoEA3;
        gruposEA[3] = grupoEA4;
        Materia analoga = new Materia("Electrónica análoga I", "Teoría de circuitos analogicos y de semiconducción.", 4, 2016495, 4, "Disciplinar", gruposEA);

        Grupo[] gruposfEyM = new Grupo[4];
        Grupo grupofEyM1 = new Grupo(1, "Dario Rodriguez", fechaMJ7);
        Grupo grupofEyM2 = new Grupo(2, "Walter Pulido", fechaMJ9);
        Grupo grupofEyM3 = new Grupo(3, "Santiago Cortes", fechaMJ11);
        Grupo grupofEyM4 = new Grupo(4, "Hector Castro", fechaLCV);
        gruposfEyM[0] = grupofEyM1;
        gruposfEyM[1] = grupofEyM2;
        gruposfEyM[2] = grupofEyM3;
        gruposfEyM[3] = grupofEyM4;
        Materia fEyM = new Materia("Fundamentos de Electricidad y Magnetismo", "Introduccion a las fuerzas electromagneticas.", 4, 1000017, 4, "Fundamentación", gruposfEyM);

        Grupo[] gruposPQ = new Grupo[2];
        Grupo grupoPQ1 = new Grupo(1, "Josue Clavijo", fechaMJ14);
        Grupo grupoPQ4 = new Grupo(2, "Edgar Delgado", fechaLC14);
        gruposPQ[0] = grupoPQ1;
        gruposPQ[1] = grupoPQ4;
        Materia PQ = new Materia("Principios de química", "Introducción a la química básica.", 3, 1000024, 3, "Fundamentación", gruposPQ);

        Grupo[] gruposDin = new Grupo[4];
        Grupo grupoDin1 = new Grupo(1, "Carlos Camacho", fechaMJ11);
        Grupo grupoDin2 = new Grupo(2, "Nelson Arzola", fechaMJ9);
        Grupo grupoDin3 = new Grupo(3, "Jaime Guerrero", fechaMJ14);
        Grupo grupoDin4 = new Grupo(4, "Jaime Guerrero", fechaMJ16);
        gruposDin[0] = grupoDin1;
        gruposDin[1] = grupoDin2;
        gruposDin[2] = grupoDin3;
        gruposDin[3] = grupoDin4;
        Materia dina = new Materia("Principios de Dinamica", "Sistemas dinámicos de partículas y cuerpo rígido.", 3, 2017271, 3, "Disciplinar", gruposDin);

        Grupo[] gruposDIC = new Grupo[1];
        Grupo grupoDIC1 = new Grupo(1, "Antonio Mejia", fechaMJ11);
        gruposDIC[0] = grupoDIC1;
        Materia dic = new Materia("Desarrollo de la ingeniería en Colombia ", "Breve introducción a la historia del desarrollo tecnológico en Colombia.", 3, 20259767, 3, "Libre Elección", gruposDIC);

        PriorityQueue<Casilla> casillas = new PriorityQueue<>(true);

        
        HashGeneric<Integer,Materia> materias=new HashGeneric<>();
//        materias.add(estructuras.getCodigo(), estructuras);
//        materias.add(ecuaciones.getCodigo(), ecuaciones);
//        materias.add(analoga.getCodigo(), analoga);
//        materias.add(fEyM.getCodigo(), fEyM);
//        materias.add(PQ.getCodigo(), PQ);
//        materias.add(dina.getCodigo(), dina);
//        materias.add(dic.getCodigo(), dic);
        
         
        Persona admin1 = new Persona("admin1", "clave1", 1, "nombre1", "apellido1");
        Persona admin2 = new Persona("admin2", "claveAdmin", 2, "nombre2", "apellido2");
        Persona admin3 = new Persona("admin13", "claveAdmin2", 3, "nombre3", "apellido3");
        Persona admin4 = new Persona("admin4", "claveAdmin2", 4, "nombre3", "apellido3");
        Persona admin5 = new Persona("admin5", "claveAdmin2", 5, "nombre3", "apellido3");
        Estudiante est1 = new Estudiante("usuario1", "clave1", 1, "nombre1", "apellido1", casillas, "Ing1");
        Estudiante est2 = new Estudiante("dfcantors", "contraseña", 1072717690, "Daniel", "Cantor", casillas, "Ingeniería Mecatrónica");
        Estudiante est3 = new Estudiante("usuarioextra", "contraseña", 1072717699, "Daniel", "Cantor", casillas, "Ingeniería Mecatrónica");
        Estudiante julian = new Estudiante("jcaipap", "password", 1010042710, "Julian", "Caipa", casillas, "Ingeniería Mecatrónica");
        Estudiante david = new Estudiante("dherreraal", "password", 101123710, "David", "Herrera", casillas, "Ingeniería Mecatrónica");
        Estudiante cadena= new Estudiante("jcadenaa", "password", 1010036710, "Julian", "Cadena", casillas, "Ingeniería Mecatrónica");
        Estudiante fabiang= new Estudiante("fsgalindope", "password", 1010692710, "Fabian", "Galindo", casillas, "Ingeniería Mecatrónica");
        Estudiante juliana= new Estudiante("jsandovalr", "password", 1013052710, "Juliana", "Sandoval", casillas, "Ingeniería Mecatrónica");
        Estudiante guillermo= new Estudiante("gualvarezc", "password",1010042777 , "Guillermo", "Alvarez", casillas, "Ingeniería Mecanica");
        Estudiante tequila= new Estudiante("jscuervos", "password", 1014232320, "Jose", "Cuervo", casillas, "Ingeniería de procesos para licores");
        Estudiante perico= new Estudiante("peescobarg", "password", 123456789, "Pablo", "Escobar", casillas, "Ingeniería química");

        PriorityQueue<Casilla> casillasAndres = new PriorityQueue<>(true);
        Actividad activ1 = new Actividad("Recordatorio Parcial Dinámica", "Estudiar teoría de cuerpo rígido", 5, Metodos.calendarGenerator(2020, 6, 5, 14, 0), Metodos.calendarGenerator(2020, 6, 5, 16, 0));
        Actividad activ2= new Actividad("Recordatorio Parcial Estructuras", "Estudiar arboles", 5, Metodos.calendarGenerator(2020, 6, 7, 14, 0), Metodos.calendarGenerator(2020, 6, 7, 16, 0));
        Actividad activ3 = new Actividad("Recordatorio Parcial Electro", "Estudiar leyes de Maxwell", 5, Metodos.calendarGenerator(2020, 6, 8, 14, 0), Metodos.calendarGenerator(2020, 6, 8, 16, 0));
        casillasAndres.add(activ1);
        casillasAndres.add(activ2);
        casillasAndres.add(activ3);
        
        
        Estudiante andres = new Estudiante("aholguinr", "clave", 1000794275, "Andres", "Holguin", casillasAndres, "Ingeniería Mecatrónica");
//        Metodos.seleccionarGrupo(andres, estructuras, 5);
//        Metodos.seleccionarGrupo(andres, dic, 1);
//        Metodos.seleccionarGrupo(andres, PQ, 1);
//        
        

        HashGeneric<String,Persona> administradores=new HashGeneric<>();
        HashGeneric<String,Persona> usuarios=new HashGeneric<>();
//        administradores.add(admin1.getUsuario(), admin1);
//        administradores.add(admin2.getUsuario(), admin2);
//        administradores.add(admin3.getUsuario(), admin3);
//        administradores.add(admin4.getUsuario(), admin4);
//        administradores.add(admin5.getUsuario(), admin5);        
        usuarios.add(david.getUsuario(), david);
        usuarios.add(est1.getUsuario(), est1);
        usuarios.add(est2.getUsuario(), est2);
        usuarios.add(est3.getUsuario(), est3);
        usuarios.add(julian.getUsuario(), julian);
        usuarios.add(juliana.getUsuario(), juliana);
        usuarios.add(cadena.getUsuario(), cadena);
        usuarios.add(andres.getUsuario(), andres);
        usuarios.add(fabiang.getUsuario(), fabiang);
        usuarios.add(guillermo.getUsuario(), guillermo);
        usuarios.add(tequila.getUsuario(), tequila);


        UsuariosDataBaseHandler userdatabase=new UsuariosDataBaseHandler();
        AdminDataBaseHandler admindatabase=new AdminDataBaseHandler();
        MateriasDataBaseHandler materiasbase=new MateriasDataBaseHandler();
        HashGeneric<Integer,Materia> materias1=materiasbase.LeerDBC();
        HashGeneric<String,Persona> usuarios1=userdatabase.LeerDBC();
        HashGeneric<String,Persona> administradores1=admindatabase.LeerDBC();
        Estudiante p=(Estudiante)usuarios1.get(andres.getUsuario());
//        userdatabase.InsertarDBC(david);
//        userdatabase.InsertarDBC(est1);
//        userdatabase.InsertarDBC(est2);
//        userdatabase.InsertarDBC(est3);
//        userdatabase.InsertarDBC(julian);
//        userdatabase.InsertarDBC(juliana);
//        userdatabase.InsertarDBC(cadena);
//        userdatabase.InsertarDBC(andres);
//        userdatabase.InsertarDBC(fabiang);
//        userdatabase.InsertarDBC(guillermo);
//        userdatabase.InsertarDBC(tequila);
//        System.out.println(p.getCasillas());
//        Materia[] materiasxd=Metodos.extraerMateria(p.getCasillas());
//        for(Materia mats: materiasxd){
//            System.out.println(mats);
//        }
//        materiasbase.InsertarDBC(estructuras);
//        materiasbase.InsertarDBC(ecuaciones);
//        materiasbase.InsertarDBC(analoga);
//        materiasbase.InsertarDBC(fEyM);
//        materiasbase.InsertarDBC(PQ);
//        materiasbase.InsertarDBC(dina);
//        materiasbase.InsertarDBC(dic);


        
        GUIInicio inicio = new GUIInicio(usuarios1, administradores1,materias1,admindatabase,materiasbase,userdatabase);
        inicio.setVisible(true);


//            GUIPruebas pruebas = new GUIPruebas();
//            pruebas.setVisible(true);
//            
            
           
//        GUIVerUsuarios usu = new GUIVerUsuarios(usuarios, usuarios,administradores,materias);
//        usu.setVisible(true);
//        
//        GUIVerMaterias mat = new GUIVerMaterias(usuarios, administradores, materias1,admindatabase,materiasbase,userdatabase);
//        mat.setVisible(true);
        
//        GUIBuscador busc = new GUIBuscador(usuarios, administradores,materias, admindatabase, materiasbase, userdatabase);
//        busc.setVisible(true);
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
    

}
