/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import estructuas.LinkedListGeneric;
import java.util.Calendar;
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
    private Calendar fecha;

    public Casilla() {
    }

    
    public Casilla(String titulo, String descripcion, int importancia, Calendar fecha) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.importancia = importancia;
        this.fecha = fecha;
    }

    public Casilla(String recordatorio, String recordatorio_de_prueba, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }
    @Override
    public int compareTo(Casilla casilla){
        int result=fecha.compareTo(casilla.getFecha());
        return result;
    }
    @Override
    public boolean equals(Object casilla) {
        if(!(casilla instanceof Casilla)){
            return false;
        }
        Casilla otherStudentObject
                = (Casilla) casilla;
        return (fecha == otherStudentObject.fecha);
    }

    @Override
    public String toString() {
        return "Casilla{" + "titulo=" + titulo + ", descripcion=" + descripcion + ", importancia=" + importancia + ", fecha=" + fecha.getTime() + '}';
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.fecha);
        return hash;
    }
    
   
}
