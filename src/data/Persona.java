/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Objects;

/**
 *
 * @author JAndres
 */
public abstract class Persona implements Comparable<Persona> {

    private int codigo;
    private String nombre;
    private String apellido;
    private String correo;

    public Persona() {
    }

    public Persona(int codigo, String nombre, String apellido, String correo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }
    

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    @Override
    public int compareTo(Persona persona) {
        int result=0;
        if(codigo<persona.getCodigo()){
            result=-1;
        } else if(codigo>persona.getCodigo()){
            result=1;
        }
        return result;
    }

    @Override
    public boolean equals(Object persona) {
        if(!(persona instanceof Persona)){
            return false;
        }
        Persona otherPersona
                = (Persona) persona;
        return (codigo == otherPersona.codigo);
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.codigo;
        hash = 61 * hash + Objects.hashCode(this.nombre);
        hash = 61 * hash + Objects.hashCode(this.apellido);
        hash = 61 * hash + Objects.hashCode(this.correo);
        return hash;
    }
}
