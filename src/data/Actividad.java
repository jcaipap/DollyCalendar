/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

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

    public Actividad(String[] comentarios, String titulo, String descripcion, int importancia, Calendar fechaInicio, Calendar fechaFinalizacion) {
        super(titulo, descripcion, importancia,fechaInicio,fechaFinalizacion);
        this.comentarios = comentarios;
    }

    
    
    public String[] getComentarios() {
        return comentarios;
    }

    
    public void setComentarios(String[] comentarios) {
        this.comentarios = comentarios;
    }

    
}
