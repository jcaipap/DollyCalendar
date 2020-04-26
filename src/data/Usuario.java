/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author JAndres
 */
public class Usuario extends Persona{
    private String usuario;
    private String contraseña;
    private ArrayList<Casilla> casilla;
    private String pregado;

    public Usuario(String usuario, String contraseña, ArrayList<Casilla> casilla, String pregado) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.casilla = casilla;
        this.pregado = pregado;
    }

    public Usuario(String usuario, String contraseña, ArrayList<Casilla> casilla, String pregado, int codigo, String nombre, String apellido, String correo) {
        super(codigo, nombre, apellido, correo);
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.casilla = casilla;
        this.pregado = pregado;
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

    public ArrayList<Casilla> getCasilla() {
        return casilla;
    }


    public void setCasilla(ArrayList<Casilla> casilla) {
        this.casilla = casilla;
    }

    public String getPregado() {
        return pregado;
    }

    public void setPregado(String pregado) {
        this.pregado = pregado;
    }
    
}
