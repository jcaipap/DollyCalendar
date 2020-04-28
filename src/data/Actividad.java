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
public class Actividad extends Casilla {
    private String [] comentarios;

    public Actividad(String titulo, String descripcion, int importancia, Calendar fechaInicio, Calendar fechaFinalizacion) {
        super(titulo, descripcion, importancia,fechaInicio,fechaFinalizacion);
    }

    public Actividad( String titulo, String descripcion, int importancia, Calendar fechaInicio, Calendar fechaFinalizacion,String[] comentarios) {
        super(titulo, descripcion, importancia,fechaInicio,fechaFinalizacion);
        this.comentarios = comentarios;
    }

    
    
    public String[] getComentarios() {
        return comentarios;
    }

    
    public void setComentarios(String[] comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return super.toString()+" Comentarios Adicionales: "+Arrays.toString(comentarios)+"\n";
    }

    @Override
    public boolean equals(Object casilla) {
        return super.equals(casilla);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Arrays.deepHashCode(this.comentarios);
        return hash;
    }

    @Override
    public int compareTo(Casilla casilla) {
        return super.compareTo(casilla); 
    }

}
