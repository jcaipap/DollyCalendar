/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import estructuas.DynamicArray;
import estructuas.HashGeneric;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JAndres
 */
public class AdminDataBaseHandler {
    public String db="admindolly";
    public String url="jdbc:mysql://den1.mysql6.gear.host/admindolly?useTimezone=true&serverTimezone=UTC";
    public String userDb="admindolly";
    public String passwordDb="Bg6F2UG9_Dl-";
    
    Connection cnU;
    Statement stU;  
    PreparedStatement pstU;

    public AdminDataBaseHandler() {
    }


    
    public HashGeneric<String,Persona> LeerDBC() throws IOException{
        HashGeneric<String,Persona> listaUsuarios=new HashGeneric<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cnU=DriverManager.getConnection(url, userDb, passwordDb);
            stU=cnU.createStatement();
            ResultSet rsU=stU.executeQuery("select * from admin");
            while (rsU.next()){
                Blob blob=rsU.getBlob("admin");
                int codigo=rsU.getInt("codigo");
                ObjectInputStream ois = new ObjectInputStream(blob.getBinaryStream());
                Persona persona=(Persona) ois.readObject();
                persona.setCodigo(codigo);
                listaUsuarios.add(persona.getUsuario(),persona);
            }
            rsU.close();
            stU.close();
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch(SQLException ex){
            Logger.getLogger(UsuariosDataBaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }finally{            
            try{
                cnU.close();
            }catch(SQLException exc){
            
            }
        }
        return listaUsuarios;
    }
    public void InsertarDBC (String usuario, String contraseña, int codigo, String nombre, String apellido) throws IOException{
        try{            
            Class.forName("com.mysql.jdbc.Driver");
            cnU=DriverManager.getConnection(url,userDb,passwordDb);
            pstU=cnU.prepareStatement("INSERT INTO admin(codigo,admin)VALUES(?,?)");
            Persona persona=new Persona(usuario, contraseña, codigo, nombre, apellido);
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(byteArray);
            oos.writeObject(persona);
            pstU.setInt(1, codigo);
            pstU.setBytes(2, byteArray.toByteArray());
            pstU.executeUpdate();
            pstU.close();
        }catch (SQLException e){
            Logger.getLogger(UsuariosDataBaseHandler.class.getName()).log(Level.SEVERE, null,e);
        } catch (ClassNotFoundException ex){
            ex.printStackTrace();
        } finally{
            try{
                cnU.close();
            }catch(SQLException exc){
                
            }
        }
        
    }
    public void InsertarDBC (Persona persona) throws IOException{
        try{            
            Class.forName("com.mysql.jdbc.Driver");
            cnU=DriverManager.getConnection(url,userDb,passwordDb);
            pstU=cnU.prepareStatement("INSERT INTO admin(codigo,admin)VALUES(?,?)");
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(byteArray);
            oos.writeObject(persona);
            int codigo=persona.getCodigo();
            pstU.setInt(1, codigo);
            pstU.setBytes(2, byteArray.toByteArray());
            pstU.executeUpdate();
            pstU.close();
        }catch (SQLException e){
            Logger.getLogger(UsuariosDataBaseHandler.class.getName()).log(Level.SEVERE, null,e);
        } catch (ClassNotFoundException ex){
            ex.printStackTrace();
        } finally{
            try{
                cnU.close();
            }catch(SQLException exc){
                
            }
        }
        
    }
    
    public void ModificarDBC (Persona persona) throws IOException{
        try{            
            Class.forName("com.mysql.jdbc.Driver");
            cnU=DriverManager.getConnection(url,userDb,passwordDb);
            int codigo=persona.getCodigo();
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(byteArray);
            oos.writeObject(persona);
            pstU=cnU.prepareStatement("UPDATE admin SET admin='"+byteArray.toByteArray()+"' WHERE codigo="+codigo );
            pstU.executeUpdate();
            pstU.close();
        }catch (SQLException e){
            Logger.getLogger(UsuariosDataBaseHandler.class.getName()).log(Level.SEVERE, null,e);
        } catch (ClassNotFoundException ex){
            ex.printStackTrace();
        } finally{
            try{
                cnU.close();
            }catch(SQLException exc){
                
            }
        }
        
    }
}
