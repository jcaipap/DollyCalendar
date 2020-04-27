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
public class Usuario extends Persona {
    private LinkedListGeneric<Casilla> casillas;
    private String pregrado;

    public Usuario() {
    }

    public Usuario(String usuario, String contraseña, int codigo, String nombre, String apellido, String correo, String pregrado) {
        super(usuario, contraseña, codigo, nombre, apellido, correo);
        this.pregrado = pregrado;
    }
    public Usuario(String usuario, String contraseña, int codigo, String nombre, String apellido, String correo,LinkedListGeneric<Casilla> casillas) {
        super(usuario, contraseña, codigo, nombre, apellido, correo);
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
    
    
}
