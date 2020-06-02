/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Arrays;
import java.util.Calendar;

/**
 *
 * @author JAndres
 */
public class Grupo implements Comparable<Grupo> {
    private int numeroGrupo;
    private String profesor;
    private Calendar[] horario;

    public Grupo(int numeroGrupo, String profesor, Calendar[] horario) {
        this.numeroGrupo = numeroGrupo;
        this.profesor = profesor;
        this.horario = horario;
    }

    public Grupo(int numeroGrupo, String profesor) {
        this.numeroGrupo = numeroGrupo;
        this.profesor = profesor;
    }
    

    public Grupo() {
    }

    
    public int getNumeroGrupo() {
        return numeroGrupo;
    }

    
    public void setNumeroGrupo(int numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }

    
    public String getProfesor() {
        return profesor;
    }

    
    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    
    public Calendar[] getHorario() {
        return horario;
    }

    
    public void setHorario(Calendar[] horario) {
        this.horario = horario;
    }
    public String impresionFecha(Calendar calendar){
        String[] strDays = new String[]{"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
        String fecha=strDays[calendar.get(Calendar.DAY_OF_WEEK)-1];
        int horaInicio=calendar.get(Calendar.HOUR_OF_DAY);
        int horaFinal=calendar.get(Calendar.HOUR_OF_DAY)+2;
        return "Dia: "+ fecha+"||Hora inicio: "+String.valueOf(horaInicio)+":00 ||Hora finalizacion : "+String.valueOf(horaFinal)+":00 \n";
    }

    @Override
    public String toString() {
        Calendar [] fechas=horario;
        String f=impresionFecha(fechas[0]);
        String e=impresionFecha(fechas[1]);    
        return "\n" + "Numero: " + numeroGrupo + " || Docente: " + profesor + "\nHorarios:\n"+f+e+"\n";
    }
    
    @Override
    public int compareTo(Grupo grupo) {
        int result;
        if(numeroGrupo<grupo.getNumeroGrupo()){
            result=-1;
        } else if(numeroGrupo>grupo.getNumeroGrupo()){
            result=1;
        } else{
            result=0;
        }
        return result;
    }
}
