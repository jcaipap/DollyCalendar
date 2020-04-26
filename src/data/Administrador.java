/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author JAndres
 */
public class Administrador extends Persona {
    private String usuario;
    private String contraseña;

    public Administrador(String usuario, String contraseña, int codigo, String nombre, String apellido, String correo) {
        super(codigo, nombre, apellido, correo);
        this.usuario = usuario;
        this.contraseña = contraseña;
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
    
    
}
