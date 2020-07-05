    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author JAndres
 */
public class Materia extends Casilla implements Serializable{
    private int codigo;
    private int creditos;
    private String tipologia;
    private int numeroGrupo;
    private String profesor;
    private Grupo[] grupos;
    private static int num =1;
    public Materia() {
    }

   
    
    public Materia(String titulo, String descripcion, int importancia, Calendar fechaInicio, Calendar fechaFinalizacion,int codigo, int creditos, String tipologia, int numeroGrupo, String profesor, Grupo[]  grupos) {
        super(titulo, descripcion, importancia, fechaInicio, fechaFinalizacion);
        this.codigo = codigo;
        this.creditos = creditos;
        this.tipologia = tipologia;
        this.numeroGrupo = numeroGrupo;
        this.profesor = profesor;
        this.grupos = grupos;
    }

    public Materia(String titulo, String descripcion, int importancia, Calendar fechaInicio, Calendar fechaFinalizacion, int codigo, int creditos, String tipologia, int numeroGrupo, String profesor) {
        super(titulo, descripcion, importancia, fechaInicio, fechaFinalizacion);
        this.codigo = codigo;
        this.creditos = creditos;
        this.tipologia = tipologia;
        this.numeroGrupo = numeroGrupo;
        this.profesor = profesor;
    }

    

    public Materia( String titulo, String descripcion, int importancia, int codigo, int creditos, String tipologia,Grupo[] grupos) {
        super(titulo, descripcion, importancia);
        this.codigo = codigo;
        this.creditos = creditos;
        this.tipologia = tipologia;
        this.grupos = grupos;
    }

    public Materia(String titulo, String descripcion, int importancia, int codigo, int creditos, String tipologia, int numeroGrupo, String profesor) {
        super(titulo, descripcion, importancia);
        this.codigo = codigo;
        this.creditos = creditos;
        this.tipologia = tipologia;
        this.numeroGrupo = numeroGrupo;
        this.profesor = profesor;
    }
    
    
    
    
    public int getCodigo() {
        return codigo;
    }

    
    public void setCodigo(int codigo) {
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


    
    public Grupo[] getGrupos() {
        return grupos;
    }

    
    public void setGrupos(Grupo[] grupos) {
        this.grupos = grupos;
    }

    @Override
    public boolean equals(Object casilla) {
        return super.equals(casilla); 
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.codigo);
        hash = 53 * hash + this.creditos;
        hash = 53 * hash + Objects.hashCode(this.tipologia);
        hash = 53 * hash + this.numeroGrupo;
        hash = 53 * hash + Objects.hashCode(this.profesor);
        hash = 53 * hash + Objects.hashCode(this.grupos);
        return hash;
    }

    @Override
    public int compareTo(Casilla casilla) {
        return super.compareTo(casilla);
    }

    @Override
    public String toString() {
        return super.toString()+"Codigo: "+codigo+"|| Tipologia: "+tipologia+"|| Creditos: "+creditos+"\n"; 
         
    }

    @Override
    public String toStringMateria() {
        return super.toStringMateria()+"Codigo: "+codigo+"|| Tipologia: "+tipologia+"|| Creditos "+creditos+"\n"+" Grupos: "+gruposImpresion(grupos); 
    }
    
    
    public String toStringNoGroups() {
        return super.toStringMateria()+"Codigo: "+codigo+"|| Tipologia: "+tipologia+"|| Creditos "+creditos+"\n"; 
    }
    public String toStringMateriaHora() {
        return String.valueOf(num++)+". "+super.getTitulo()+" || "+super.getDescripcion()+"\n"+"Parametros Materia: "+"\n"+"Codigo: "+codigo+"|| Tipologia: "+tipologia+"|| Creditos "+creditos+"\n"+"Docente: "+profesor+" || Numero de grupo: "+numeroGrupo+"\n";
    }
    public String gruposImpresion(Grupo[] grupos){
        String f="";
        for(Grupo grupo: grupos){
            f=f.concat(grupo.toString());
        }
        return f;
    }
   
    @Override
    public boolean equalsName(Object casilla) {
        return super.equalsName(casilla); 
    }

    @Override
    public int compareToName(Casilla casilla) {
        return super.compareToName(casilla); 
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        Materia.num = num;
    }
            
    
}
