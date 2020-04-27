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
    private String usuario;
    private String contraseña;
    private LinkedListGeneric<Casilla> casillas;
    private String pregrado;

    public Usuario(String usuario, String contraseña, LinkedListGeneric<Casilla> casillas, String pregrado) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.casillas = casillas;
        this.pregrado = pregrado;
    }

    public Usuario(String usuario, String contraseña, LinkedListGeneric<Casilla> casillas, String pregrado, int codigo, String nombre, String apellido, String correo) {
        super(codigo, nombre, apellido, correo);
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.casillas = casillas;
        this.pregrado = pregrado;
    }

    public Usuario(int codigo, String nombre, String apellido, String correo) {
        super(codigo, nombre, apellido, correo);
    }
    
    public Usuario() {
    }
    
    


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public String getContraseña() {
        return contraseña;
    }


    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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
        return super.toString()+"Rol: Estudiante"+"\n"+ "Usuario: "+usuario+" Pregrado: "+pregrado+"\n"+"\n"; 
    }
    public String toStringAdmin(){
         return super.toString()+"Rol: Estudiante"+"\n"+ "Usuario: "+usuario+" Pregrado: "+pregrado+"\n"+"Seccion Admin: Contraseña de Usuario"+contraseña+"\n"+"\n";
    }

    
    
}
