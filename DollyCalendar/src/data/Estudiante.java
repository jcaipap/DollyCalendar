/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import estructuas.LinkedListGeneric;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author JAndres
 */
public class Estudiante extends Persona {
    private LinkedListGeneric<Casilla> casillas;
    private String pregrado;

    public Estudiante() {
    }

    public Estudiante(String usuario, String contraseña, int codigo, String nombre, String apellido, String pregrado) {
        super(usuario, contraseña, codigo, nombre, apellido);
        this.pregrado = pregrado;
    }

    public Estudiante(String usuario, String contraseña, int codigo, String nombre, String apellido,LinkedListGeneric<Casilla> casillas, String pregrado) {
        super(usuario, contraseña, codigo, nombre, apellido);
        this.casillas = casillas;
        this.pregrado = pregrado;
    }
    
    
    public LinkedListGeneric<Casilla> getCasillas() {
        return casillas;
    }

    public void setCasillas(LinkedListGeneric<Casilla> casillas) {
        this.casillas = casillas;
    }

    public String getPregrado() {
        return pregrado;
    }

    public void setPregado(String pregrado) {
        this.pregrado = pregrado;
    }

    @Override
    public String toString() {
        return super.toString()+"Rol: Estudiante"+"de Pregrado: "+pregrado+"\n"+"\n"; 
    }

    @Override
    public String toStringAdmin() {
        return super.toStringAdmin()+"Pregrado: "+pregrado+"\nContraseña de usuario: "+super.getContraseña(); 
    }
    
    @Override
    public boolean equalsUser(Object persona) {
        return super.equalsUser(persona);
    }
}
