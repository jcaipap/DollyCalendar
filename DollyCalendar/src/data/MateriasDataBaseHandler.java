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
public class MateriasDataBaseHandler {
    public String db="materiasdolly";
    public String url="jdbc:mysql://den1.mysql2.gear.host/materiasdolly?useTimezone=true&serverTimezone=UTC";
    public String userDb="materiasdolly";
    public String passwordDb="Up5rKs8!ap?S";
    
    Connection cnU;
    Statement stU;  
    PreparedStatement pstU;

    public MateriasDataBaseHandler() {
    }

    

    
    public HashGeneric<Integer,Materia> LeerDBC() throws IOException{
        HashGeneric<Integer,Materia> listaMaterias=new HashGeneric<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cnU=DriverManager.getConnection(url, userDb, passwordDb);
            stU=cnU.createStatement();
            ResultSet rsU=stU.executeQuery("select * from materias");
            while (rsU.next()){
                Blob blob=rsU.getBlob("materias");
                int codigo=rsU.getInt("codigo");
                ObjectInputStream ois = new ObjectInputStream(blob.getBinaryStream());
                Materia materia=(Materia) ois.readObject();
                materia.setCodigo(codigo);
                listaMaterias.add(codigo, materia);

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
        return listaMaterias;
    }
    public void InsertarDBC (String titulo, String descripcion, int importancia, int codigo, int creditos, String tipologia,Grupo[] grupos) throws IOException{
        try{            
            Class.forName("com.mysql.jdbc.Driver");
            cnU=DriverManager.getConnection(url,userDb,passwordDb);
            pstU=cnU.prepareStatement("INSERT INTO materias(codigo,materias)VALUES(?,?)");
            Materia materia = new Materia(titulo, descripcion, importancia, codigo, creditos, tipologia, grupos);
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(byteArray);
            oos.writeObject(materia);
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
    public void InsertarDBC (Materia materia) throws IOException{
        try{            
            Class.forName("com.mysql.jdbc.Driver");
            cnU=DriverManager.getConnection(url,userDb,passwordDb);
            pstU=cnU.prepareStatement("INSERT INTO materias(codigo,materias)VALUES(?,?)");
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(byteArray);
            oos.writeObject(materia);
            int codigo=materia.getCodigo();
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
    
    public void ModificarDBC (Materia materia, String titulo, String descripcion, int importancia, int code, int creditos, String tipologia,Grupo[] grupos) throws IOException{
        try{            
            Class.forName("com.mysql.jdbc.Driver");
            cnU=DriverManager.getConnection(url,userDb,passwordDb);
            int codigo=materia.getCodigo();
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(byteArray);
            oos.writeObject(materia);
            pstU=cnU.prepareStatement("DELETE FROM materias WHERE codigo="+codigo);
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
    public void ModificarDBC (Materia materia) throws IOException{
        try{            
            Class.forName("com.mysql.jdbc.Driver");
            cnU=DriverManager.getConnection(url,userDb,passwordDb);
            int codigo=materia.getCodigo();
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(byteArray);
            oos.writeObject(materia);
            pstU=cnU.prepareStatement("DELETE FROM materias WHERE codigo="+codigo);
            //"UPDATE users SET idusers='"+byteArray.toByteArray()+"' WHERE codigo="+codigo 
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
