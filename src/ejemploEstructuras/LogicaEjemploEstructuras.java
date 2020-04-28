
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
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import estructuas.StackArraySpot;
import java.lang.reflect.Array;



/**
 *
 * @author andre
 */

public class LogicaEjemploEstructuras {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
       

        Calendar [] fechaLC7=new Calendar[]{calendarGenerator(2020, 2, 2, 7, 0),calendarGenerator(2020,2,4, 7, 0)};
        Calendar [] fechaLC9=new Calendar[]{calendarGenerator(2020, 2, 2, 9, 0),calendarGenerator(2020,2,4, 9, 0)};
        Calendar [] fechaLC11=new Calendar[]{calendarGenerator(2020, 2, 2, 11, 0),calendarGenerator(2020,2,4, 11, 0)};
        Calendar [] fechaLC14=new Calendar[]{calendarGenerator(2020, 2, 2,14, 0),calendarGenerator(2020,2,4, 14, 0)};
        Calendar [] fechaLC16=new Calendar[]{calendarGenerator(2020, 2, 2, 16, 0),calendarGenerator(2020,2,4, 16, 0)};
        Calendar [] fechaMJ7=new Calendar[]{calendarGenerator(2020, 2, 3, 7, 0),calendarGenerator(2020,2,5, 7, 0)};
        Calendar [] fechaMJ9=new Calendar[]{calendarGenerator(2020, 2, 3, 9, 0),calendarGenerator(2020,2,5, 9, 0)};
        Calendar [] fechaMJ11=new Calendar[]{calendarGenerator(2020, 2, 3, 11, 0),calendarGenerator(2020,2,5, 11, 0)};
        Calendar [] fechaMJ14=new Calendar[]{calendarGenerator(2020, 2, 3,14, 0),calendarGenerator(2020,2,5, 14, 0)};
        Calendar [] fechaMJ16=new Calendar[]{calendarGenerator(2020, 2, 3, 16, 0),calendarGenerator(2020,2,5, 16, 0)};


        Grupo[] gruposED= new Grupo[5];
        Grupo grupoED1= new Grupo(1, "Cristian Cordoba",fechaLC7);
        Grupo grupoED2= new Grupo(2, "David Herrera",fechaMJ14);
        Grupo grupoED3= new Grupo(3, "Victor Collazos",fechaLC9);
        Grupo grupoED4= new Grupo(4, "Luis Niño",fechaMJ11);
        Grupo grupoED5= new Grupo(5, "David Herrera",fechaLC14);
        
        gruposED[0]=grupoED1;
        gruposED[1]=grupoED2;
        gruposED[2]=grupoED3;
        gruposED[3]=grupoED4;        
        gruposED[4]=grupoED5; 
        
        Materia estructuras=new Materia("Estructuras", "Materia de datos ", 3, "2016699", 3,"Disciplinar", gruposED);
        
        Grupo[] gruposECD= new Grupo[4];
        Grupo grupoECD1= new Grupo(1, "Ricardo Pastran",fechaLC7);
        Grupo grupoECD2= new Grupo(2, "Nicolas Martinez",fechaLC9);
        Grupo grupoECD3= new Grupo(3, "Hernan Garzon",fechaLC11);
        Grupo grupoECD4= new Grupo(4, "German Fonseca",fechaLC11);
        gruposECD[0]=grupoECD1;
        gruposECD[1]=grupoECD2;
        gruposECD[2]=grupoECD3;
        gruposECD[3]=grupoECD4;
        Materia ecuaciones=new Materia("E. Diferenciales", "Curso de ecuaciones diferenciales ordinarias", 4, "1000007-B", 4,"Fundamentacion", gruposED);
        
        Grupo[] gruposEA= new Grupo[4];
        Grupo grupoEA1= new Grupo(1, "Carlos Perilla",fechaLC9);
        Grupo grupoEA2= new Grupo(2, "Pablo Rodriguez",fechaLC11);
        Grupo grupoEA3= new Grupo(3, "Jesus Quintero",fechaMJ7);
        Grupo grupoEA4= new Grupo(4, "Pablo Rodriguez",fechaMJ11);
        gruposEA[0]=grupoEA1;
        gruposEA[1]=grupoEA2;
        gruposEA[2]=grupoEA3;
        gruposEA[3]=grupoEA4;
        Materia eAnaloga=new Materia("E. Analoga I", "Circuitos analogicos y semiconducción", 4, "2016495", 4,"Disciplinar", gruposEA);
        
        Grupo[] gruposfEyM= new Grupo[4];
        Grupo grupofEyM1= new Grupo(1, "Dario Rodriguez",fechaMJ7);
        Grupo grupofEyM2= new Grupo(2, "Walter Pulido",fechaMJ9);
        Grupo grupofEyM3= new Grupo(3, "Santiago Cortes",fechaMJ11);
        Grupo grupofEyM4= new Grupo(4, "Hector Castro",fechaMJ14);
        gruposfEyM[0]=grupofEyM1;
        gruposfEyM[1]=grupofEyM2;
        gruposfEyM[2]=grupofEyM3;
        gruposfEyM[3]=grupofEyM4;
        Materia fEyM=new Materia("Fundamentos de Electricidad y Magnetismo", "Introduccion a las fuerzas electromagneticas",4, "1000017-B",4,"Fundamentación", gruposfEyM);
       
        Grupo[] gruposPQ= new Grupo[2];
        Grupo grupoPQ1= new Grupo(1, "Josue Clavijo");
        Grupo grupoPQ4= new Grupo(2, "Edgar Delgado",fechaLC14);
        gruposPQ[0]= grupoPQ1;
        gruposPQ[1]= grupoPQ4;
        Materia PQ=new Materia("Principios de química", "Introducción a la química básica",3, "1000024-B",3,"Fundamentación", gruposPQ);

        Grupo[] gruposDin= new Grupo[4];
        Grupo grupoDin1= new Grupo(1, "Carlos Camacho",fechaMJ11);
        Grupo grupoDin2= new Grupo(2, "Nelson Arzola",fechaMJ9);
        Grupo grupoDin3= new Grupo(3, "Jaime Guerrero",fechaMJ14);
        Grupo grupoDin4= new Grupo(4, "Jaime Guerrero",fechaMJ16);
        gruposDin[0]=grupoDin1;
        gruposDin[1]=grupoDin2;
        gruposDin[2]=grupoDin3;
        gruposDin[3]=grupoDin4;
        Materia dina=new Materia("Principios de Dinamica", "Sistemas de partículas y cuerpo rígido", 3, "2017271", 3,"Disciplinar", gruposDin);

        Grupo[] gruposDIC= new Grupo[1];
        Grupo grupoDIC1= new Grupo(1, "Antonio Mejia",fechaMJ11);
        gruposDIC[0]=grupoDIC1;
        Materia dic=new Materia("Desarrollo de la ingeniería en Colombia ", "Avances e ingeniería colombiana historicamente", 3, "2025976", 3,"Libre Elección", gruposDIC);
        
        StackArraySpot baseMaterias= new StackArraySpot(7);        
        ListArrayGeneric<Persona> admins = new ListArrayGeneric<>(3);
        ListArrayGeneric<Persona> estudiantes = new ListArrayGeneric<>(3);
        baseMaterias.push(estructuras);
        baseMaterias.push(ecuaciones);
        baseMaterias.push(fEyM);
        baseMaterias.push(eAnaloga);
        baseMaterias.push(dina);
        baseMaterias.push(PQ);
        baseMaterias.push(dic);
        Persona admin1 = new Persona("a1", "c1", 1, "nombre1", "apellido1", "correo1");
        Persona admin2 = new Persona("a2", "c2", 2, "nombre1", "apellido1", "correo1");
        Persona admin3 = new Persona("a3", "c3", 3, "nombre1", "apellido1", "correo1");
        Usuario est1 = new Usuario("u1", "c1", 1, "nombre", "apellido", "apellido", "as");
        Usuario est2 = new Usuario("u2", "c2", 2, "nombre", "apellido", "apellido", "as");
        Usuario est3 = new Usuario("u3", "c3", 3, "nombre", "apellido", "apellido", "as");



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
        Scanner scanner = new Scanner(System.in);
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
                        System.out.println("Usuario o contraseña incorrectos\n");
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
                        System.out.println("Usuario o contraseña incorrectos\n");
                        continuar=seguir();
                        break;
                    }
                    limpiarConsola();
                    System.out.println("Administrador validado correctamente\n");
                    opcionesAdmin(estudiantes, baseMaterias);

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
        int diaAño=calendar.get(Calendar.DAY_OF_YEAR)-7;
        Calendar[] fechasSemestrales=new Calendar[16];
        
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

        c1.set(Calendar.DAY_OF_YEAR,diaAño+7);
        c1.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c1.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c1.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
        
        c2.set(Calendar.DAY_OF_YEAR,diaAño+14);
        c2.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c2.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c2.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
        
        c3.set(Calendar.DAY_OF_YEAR,diaAño+21);
        c3.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c3.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c3.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
        
        c4.set(Calendar.DAY_OF_YEAR,diaAño+28);
        c4.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c4.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c4.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
        
        c5.set(Calendar.DAY_OF_YEAR,diaAño+35);
        c5.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c5.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c5.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
        
        c6.set(Calendar.DAY_OF_YEAR,diaAño+42);
        c6.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c6.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c6.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
        
        c7.set(Calendar.DAY_OF_YEAR,diaAño+49);
        c7.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c7.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c7.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
        
        c8.set(Calendar.DAY_OF_YEAR,diaAño+56);
        c8.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c8.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c8.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
        
        c9.set(Calendar.DAY_OF_YEAR,diaAño+63);
        c9.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c9.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c9.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
        
        c10.set(Calendar.DAY_OF_YEAR,diaAño+70);
        c10.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c10.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c10.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
        
        c11.set(Calendar.DAY_OF_YEAR,diaAño+77);
        c11.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c11.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c11.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
        
        c12.set(Calendar.DAY_OF_YEAR,diaAño+84);
        c12.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c12.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c12.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
        
        c13.set(Calendar.DAY_OF_YEAR,diaAño+91);
        c13.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c13.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c13.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
        
        c14.set(Calendar.DAY_OF_YEAR,diaAño+98);
        c14.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c14.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c14.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
        
        c15.set(Calendar.DAY_OF_YEAR,diaAño+105);
        c15.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c15.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c15.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
        
        c16.set(Calendar.DAY_OF_YEAR,diaAño+112);
        c16.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        c16.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        c16.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
        
        fechasSemestrales[0]=c1;
        fechasSemestrales[1]=c2;
        fechasSemestrales[2]=c3;
        fechasSemestrales[3]=c4;
        fechasSemestrales[4]=c5;
        fechasSemestrales[5]=c6;
        fechasSemestrales[6]=c7;
        fechasSemestrales[7]=c8;
        fechasSemestrales[8]=c9;
        fechasSemestrales[9]=c10;
        fechasSemestrales[10]=c11;
        fechasSemestrales[11]=c12;
        fechasSemestrales[12]=c13;
        fechasSemestrales[13]=c14;
        fechasSemestrales[14]=c15;
        fechasSemestrales[15]=c16;
        
       
        
        
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
                
                GregorianCalendar fechaFinalizacion=new GregorianCalendar(fechaInicio.get(Calendar.YEAR),
                        fechaInicio.get(Calendar.MONTH),fechaInicio.get(Calendar.DAY_OF_MONTH),
                        fechaInicio.get(Calendar.HOUR_OF_DAY)+2,fechaInicio.get(Calendar.MINUTE),
                        fechaInicio.get(Calendar.SECOND));

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

    static void opcionesAdmin(ListArrayGeneric estudiantes, StackArraySpot materias) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione que opciones desea realizar:\n1. Ver estudiantes\n2. Ver cursos\n3. Salir");

        switch (scanner.nextInt()) {

            case 1:
                limpiarConsola();
                System.out.println("Usted ha seleccionado ver usuarios, a continuación se muestra la lista de los estudiantes existentes:\n\n");
                int numeroEst =1;
                Usuario us1 = new Usuario();
                for (int i = 0; i < estudiantes.size(); i++) {
                    us1 = (Usuario) estudiantes.getItemInPosition(i);
                    System.out.println(numeroEst+": " +us1.toStringAdmin() + "\n");
                    numeroEst++;
                }
                System.out.println("\n\n\n\n");
                break;

            case 2:
                int numeromat=1;
                limpiarConsola();
                System.out.println("Usted ha seleccionado ver cursos, a continuación se muestra la lista de los cursos existentes:");
                Materia m1 = new Materia();
                for (int i = 0; i < materias.getLenght(); i++) {
                    m1 = (Materia) materias.getItemInPosition(i);
                    System.out.println(numeromat+": " +m1.toStringNoGroups() + "\n");
                    numeromat++;
                }
                System.out.println("\n\n\n");
                System.out.println("Seleccione cual de las siguientes opciones desea realizar ahora:\n1.Editar materias\n2. Ver grupos\n");
                
                switch(scanner.nextInt()){
                    
                    case 1:
                        
                        materias= cambiarMateria (materias);
                        
                        break;
                        
                    case 2:
                        
                        materias=cambioGrupo(materias);
                        break;
                        
                    default:
                        limpiarConsola();
                        System.out.println("Opción invalida");
                        
                        break;
                    
                    
                }
                
                
                
                
                break;

            case 3:

                break;

            default:
                    
                break;

        }

    }

    static void opcionesEst() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione que opciones desea realizar:\n1. Ver estudiantes\n2. Ver cursos\n3. Salir");

        switch (scanner.nextInt()) {

            
        }
        
    }
        
    static StackArraySpot cambiarMateria (StackArraySpot materias){
        Scanner scanner = new Scanner (System.in);
        Scanner  scannerStr = new Scanner(System.in); 
        scannerStr.useDelimiter("\n");
        
        
        System.out.println("\n\n Usted ha seleccionado editar materias, seleccione el número de la materia a editar:");
        int numeroMateria=scanner.nextInt();
        limpiarConsola();
        if(numeroMateria<=materias.getLenght()&&numeroMateria>0){
            Materia matCambio = (Materia) materias.getItemInPosition(numeroMateria-1);
            System.out.println("Mostrando la información de la materia: "+numeroMateria+".\n"+matCambio.toStringNoGroups()+"\n\n\n");
            System.out.println("Seleccione el parametro a editar:\n1. Titulo\n2. Descripcion\n3. Código \n4. Tipologia \n5. Creditos\n\n\n");
            
            switch(scanner.nextInt()){
            
                case 1:
                    System.out.println("Ingrese el nuevo título:\n");
                    matCambio.setTitulo(scannerStr.next());
                    System.out.println("\n\nCambio realizado correctamente\n");
                    break;
                case 2:
                    System.out.println("Ingrese la nueva descripción:\n");
                    matCambio.setDescripcion(scannerStr.next());
                    System.out.println("\n\nCambio realizado correctamente\n");
                    break;
                case 3:
                    System.out.println("Ingrese el nuevo código:\n");
                    matCambio.setCodigo(scannerStr.next());
                    System.out.println("\n\nCambio realizado correctamente\n");
                    break;
                case 4:
                    System.out.println("Ingrese la nueva tipologia:\n");
                    matCambio.setTipologia(scannerStr.next());
                    System.out.println("\n\nCambio realizado correctamente\n");
                    break;
                case 5:
                    System.out.println("Ingrese la nueva cantidad de creditos:\n");
                    matCambio.setCreditos(scanner.nextInt());
                    System.out.println("\n\nCambio realizado correctamente\n");
                    break;
                    
                default:
                    break;
        }
            
            materias.pushAt(matCambio, numeroMateria-1);
            
        }else{
            System.out.println("El número seleccionado no se encuentra en la lista.");
        }

        return materias;
    }
    
    static StackArraySpot cambioGrupo(StackArraySpot materias){
        Scanner scanner = new Scanner (System.in);
        Scanner  scannerStr = new Scanner(System.in); 
        scannerStr.useDelimiter("\n");        
        System.out.println("\n Usted ha seleccionado ver grupos, seleccione el número de la materia de la cuál desea ver los grupos: \n");
        int numeroMateria=scanner.nextInt();
        if(numeroMateria<=materias.getLenght()&&numeroMateria>0){
            Materia matCambio = (Materia) materias.getItemInPosition(numeroMateria-1);
            System.out.println("Mostrando la información de la materia: "+".\n"+matCambio.toStringMateria()+"\n\n");
            System.out.println("Seleccione el numero de grupo que desea editar: \n");
            int numeroGrupo=scanner.nextInt();
            Grupo [] grupos=matCambio.getGrupos();
             if(numeroGrupo<=grupos.length&&numeroGrupo>0){
                 Grupo grupoEdit=grupos[numeroGrupo-1];
                 System.out.println("Seleccione el parametro a editar:\n1. Profesor\n2. Numero de grupo\n");
                 switch (scanner.nextInt()) {

                     case 1:
                         System.out.println("\nIngrese el nuevo Profesor:");
                         grupoEdit.setProfesor(scannerStr.next());
                         Array.set(grupos, numeroGrupo-1, grupoEdit);
                         System.out.println("\n\nCambio realizado correctamente\n");
                         break;
                     case 2:
                         System.out.println("\nIngrese el nuevo numero de grupo:");
                         int numeroNuevo=scanner.nextInt();
                         if(numeroNuevo>0){   
                             for (Grupo grupoN : grupos) {
                                 if (numeroNuevo == grupoN.getNumeroGrupo()) {
                                     System.out.println("El numero ingresado ya ha sido asignado a un grupo");
                                     System.out.println("\n\nCambio realizado incorrectamente\n");
                                     break;
                                 }
                             }
                             grupoEdit.setNumeroGrupo(scanner.nextInt());
                             Array.set(grupos, numeroGrupo - 1, grupoEdit);
                             Arrays.sort(grupos);
                             System.out.println("\n\nCambio realizado correctamente\n");
                         }
                         break;
                     default:
                         break;
                 }
             }
            matCambio.setGrupos(grupos);
            for(Grupo grupito: grupos){
                System.out.println(grupito);
            }
            materias.pushAt(matCambio, numeroMateria-1);
            
        }else{
            System.out.println("El número seleccionado no se encuentra en la lista, no se realizó la edición.");
        }

        return materias;
        
    }
    }
