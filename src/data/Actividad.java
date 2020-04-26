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

    public Actividad(String titulo, String descripcion, int importancia, Calendar fecha) {
        super(titulo, descripcion, importancia,fecha);
    }

    public Actividad(String[] comentarios, String titulo, String descripcion, int importancia, Calendar fecha) {
        super(titulo, descripcion, importancia,fecha);
        this.comentarios = comentarios;
    }

    
    
    public String[] getComentarios() {
        return comentarios;
    }

    
    public void setComentarios(String[] comentarios) {
        this.comentarios = comentarios;
    }

    
}
