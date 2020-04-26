/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Calendar;
import java.util.HashMap;

/**
 *
 * @author JAndres
 */
public class Materia extends Casilla{
    private String codigo;
    private int creditos;
    private String tipologia;
    private int numeroGrupo;
    private String profesor;
    private HashMap <String,Grupo> grupos;

    public Materia(String codigo, int creditos, String tipologia, int numeroGrupo, String profesor, HashMap<String, Grupo> grupos, String titulo, String descripcion, int importancia, Calendar fecha) {
        super(titulo, descripcion, importancia, fecha);
        super.setImportancia(creditos);
        this.codigo = codigo;
        this.creditos = creditos;
        this.tipologia = tipologia;
        this.numeroGrupo = numeroGrupo;
        this.profesor = profesor;
        this.grupos = grupos;
    }

    public Materia(String codigo, int creditos, String tipologia, int numeroGrupo, String profesor, String titulo, String descripcion, int importancia, Calendar fecha) {
        super(titulo, descripcion, importancia, fecha);
        this.codigo = codigo;
        this.creditos = creditos;
        this.tipologia = tipologia;
        this.numeroGrupo = numeroGrupo;
        this.profesor = profesor;
    }

    public Materia(String codigo, int creditos, String tipologia, HashMap<String, Grupo> grupos, String titulo, String descripcion, int importancia, Calendar fecha) {
        super(titulo, descripcion, importancia, fecha);
        this.codigo = codigo;
        this.creditos = creditos;
        this.tipologia = tipologia;
        this.grupos = grupos;
    }
    
    public String getCodigo() {
        return codigo;
    }

    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    public int getCreditos() {
        return creditos;
    }

    
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    
    public String getTipologia() {
        return tipologia;
    }

    
    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
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


    
    public HashMap <String,Grupo> getGrupos() {
        return grupos;
    }

    
    public void setGrupos(HashMap <String,Grupo> grupos) {
        this.grupos = grupos;
    }
   
    
            
    
}
