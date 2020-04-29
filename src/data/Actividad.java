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

    public Actividad() {
    }

    
    
        
    public Actividad(String titulo, String descripcion, int importancia, Calendar fechaInicio, Calendar fechaFinalizacion) {
        super(titulo, descripcion, importancia,fechaInicio,fechaFinalizacion);
    }


    
    
    
    

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object casilla) {
        return super.equals(casilla);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public int compareTo(Casilla casilla) {
        return super.compareTo(casilla); 
    }

    @Override
    public boolean equalsName(Object casilla) {
        return super.equalsName(casilla); 
    }

    @Override
    public int compareToName(Casilla casilla) {
        return super.compareToName(casilla); 
    }
    
    
}
