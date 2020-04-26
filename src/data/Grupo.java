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
public class Grupo {
    private int numeroGrupo;
    private String profesor;
    private Calendar[] horario;

    public Grupo(int numeroGrupo, String profesor, Calendar[] horario) {
        this.numeroGrupo = numeroGrupo;
        this.profesor = profesor;
        this.horario = horario;
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
    
}
