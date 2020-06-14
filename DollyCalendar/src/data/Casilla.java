/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import estructuas.LinkedListGeneric;
import estructuas.NodeGeneric;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author JAndres
 */
public class Casilla implements Comparable<Casilla> {
    private String titulo;
    private String descripcion;
    private int importancia;
    private Calendar fechaInicio;
    private Calendar fechaFinalizacion;


    public Casilla() {
    }

    
    public Casilla(String titulo, String descripcion, int importancia, Calendar fechaInicio) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.importancia = importancia;
        this.fechaInicio = fechaInicio;
        Calendar fechaFinal=fechaInicio;
        fechaFinal.set(Calendar.HOUR_OF_DAY, fechaInicio.get(Calendar.HOUR_OF_DAY)+2);
        this.fechaFinalizacion=fechaFinal;
    }

    public Casilla(String titulo, String descripcion, int importancia, Calendar fechaInicio, Calendar fechaFinalizacion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.importancia = importancia;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Casilla(String titulo, String descripcion, int importancia) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.importancia = importancia;
    }
    

    
    public String getTitulo() {
        return titulo;
    }

    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
    public String getDescripcion() {
        return descripcion;
    }

    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    public int getImportancia() {
        return importancia;
    }

    public void setImportancia(int importancia) {
        this.importancia = importancia;
    }
    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Calendar getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Calendar fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
    @Override
    public int compareTo(Casilla casilla){
        int result=fechaInicio.compareTo(casilla.getFechaInicio());
        return result;
    }
    @Override
    public boolean equals(Object casilla) {
        if(!(casilla instanceof Casilla)){
            return false;
        }
        Casilla otherStudentObject
                = (Casilla) casilla;
        return (fechaInicio == otherStudentObject.fechaInicio);
    }

    @Override
    public String toString() {
        return "Recordatorio: "+ titulo +"\n"+ "Descripcion: " + descripcion + "    Grado de importancia: " + importancia +"\n Horario: "+ "Inicio: " + fechaInicio.getTime() + "-- Finalizacion: " + fechaFinalizacion.getTime()+"\n";
    }

    public String toStringMateria() {
        return "Materia: "+ titulo +"\n"+ "Descripcion: " + descripcion + "\n";
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.fechaInicio);
        return hash;
    }
    
    public int compareToName(Casilla casilla) {
        int result = titulo.compareTo(casilla.getTitulo());
        return result;
    }

    public boolean equalsName(Object casilla) {
        if (!(casilla instanceof Casilla)) {
            return false;
        }
        Casilla otherStudentObject
                = (Casilla) casilla;
        return (titulo.equals(otherStudentObject.titulo));
    }
    
    
   
}