/*
 * To change            @Override
            public void paintBorder(Component cmpnt, Graphics grphcs, int i, int i1, int i2, int i3) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Insets getBorderInsets(Component cmpnt) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean isBorderOpaque() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.Estudiante;
import data.Materia;
import data.Persona;
import estructuas.DynamicArray;
import estructuas.HashGeneric;
import estructuas.HashNode;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;




/**
 *
 * @author andre
 */
public class GUIVerUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form GUIVerUsuarios
     */
    public boolean editar = false;
    public HashGeneric<String,Persona> usuarios;
    public HashGeneric<String,Persona> usuariosIniciales;
    public HashGeneric<String,Persona> administradores;
    public HashGeneric<String,Materia> materias;
    

    
    Estudiante est1 = new Estudiante("USUARIO", "contraseña", 1000, "nombre", "apellido", "pregrado");
    

    public GUIVerUsuarios(HashGeneric<String,Persona> usuarios,HashGeneric<String,Persona> usuarios2,HashGeneric<String,Persona> administradores,HashGeneric<String,Materia> materias) {
        this.usuariosIniciales=usuarios;
        this.materias=materias;

        this.usuarios=usuarios2;
        this.administradores=administradores;
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.setIconImage(new ImageIcon(getClass().getResource("/recursos/iconApp.jpg")).getImage());
        this.setTitle("DollyCalendar");
        ImageIcon icon= new ImageIcon();
        Image image= new ImageIcon(getClass().getResource("/recursos/iconDolly.jpg")).getImage();
        icon.setImage(image);

        ImageIcon icon2= new ImageIcon();
        Image image2= new ImageIcon(getClass().getResource("/recursos/iconApp.jpg")).getImage();
        icon2.setImage(image2);
        Icon iconScale2;
        iconScale2 = new ImageIcon(icon2.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_SMOOTH));
        labelLogo.setIcon(iconScale2);
        
        Graphics graphic=VolverAInicio.getGraphics();
        graphic.setColor(new Color(20,34,255));
        VolverAInicio.paint(graphic);
        
        
        addRowtoJTable();

        
        jLUsuariosCreados.setText("Usuarios creados: "+String.valueOf(usuarios.size()));

    }
    
    public GUIVerUsuarios() {
        
    }
    
    

    public void addRowtoJTable(){
        String[] columnas = new String[]{
            "Eliminar", "N#", "Nombre", "Apellido", "Usuario", "Código", "Pregrado", "Correo", "Clave"
        };
        
        jTTablaUsuarios.setBackground(Color.WHITE);
        jTTablaUsuarios.getParent().setBackground(Color.WHITE);
        
        DynamicArray arrayEstudiantes=new DynamicArray();
        arrayEstudiantes=this.usuarios.getHashArray();
        
        
        final Class[] tiposColumnas = new Class[]{
            JButton.class,
            int.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.Integer.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class
        };
        
        Estudiante es;
            JButton boton = new JButton("Eliminar");
            boton.setSize(jTTablaUsuarios.getWidth()*1/16, jTTablaUsuarios.getParent().getHeight()/10);
        Object[][] datos = new Object[arrayEstudiantes.size()][9];
        for (int i = 0; i < arrayEstudiantes.size(); i++) {
            es = (Estudiante) arrayEstudiantes.getitem(i);
            datos[i][0] = boton;
            datos[i][1] = i+1;
            datos[i][2] = es.getNombre();
            datos[i][3] = es.getApellido();
            datos[i][4] = es.getUsuario();
            datos[i][5] = es.getCodigo();
            datos[i][6] = es.getPregrado();
            datos[i][7] = es.getCorreo();
            datos[i][8] = es.getContraseña();
        }
        
        jTTablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                columnas) {
            Class[] tipos = tiposColumnas;

            @Override
            public Class getColumnClass(int columnIndex) {
                return tipos[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return !(this.getColumnClass(column).equals(JButton.class));
            }
            

        });
        

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        jTTablaUsuarios.setDefaultRenderer(String.class, centerRenderer);
        
        
        for(int x=0;x<jTTablaUsuarios.getColumnCount();x++){
            if(x!=0){
            jTTablaUsuarios.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
            }
        }
        
        jTTablaUsuarios.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
               jtable.setAlignmentY(TOP_ALIGNMENT);
               return (Component) o;
               
            }
            
           
        });

        
        jTTablaUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                editar=true;
                
                int fila = jTTablaUsuarios.rowAtPoint(e.getPoint());
                int columna = jTTablaUsuarios.columnAtPoint(e.getPoint());
                if (jTTablaUsuarios.getModel().getColumnClass(columna).equals(JButton.class)) {
                    

                    usuarios.remove(String.valueOf(jTTablaUsuarios.getValueAt(fila,4)));


                DefaultTableModel model=new DefaultTableModel();
                    model=(DefaultTableModel)jTTablaUsuarios.getModel();
                    model.removeRow(jTTablaUsuarios.getSelectedRow());

                }
                jLUsuariosCreados.setText("Usuarios creados: "+String.valueOf(usuarios.size()));
            }
        });
        
        
        jTTablaUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            jTTablaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(jTTablaUsuarios.getWidth()*10/100);
            jTTablaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(jTTablaUsuarios.getWidth()*5/100);
            jTTablaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(jTTablaUsuarios.getWidth()*10/100);
            jTTablaUsuarios.getColumnModel().getColumn(3).setPreferredWidth(jTTablaUsuarios.getWidth()*10/100);
            jTTablaUsuarios.getColumnModel().getColumn(4).setPreferredWidth(jTTablaUsuarios.getWidth()*10/100);
            jTTablaUsuarios.getColumnModel().getColumn(5).setPreferredWidth(jTTablaUsuarios.getWidth()*10/100);
            jTTablaUsuarios.getColumnModel().getColumn(6).setPreferredWidth(jTTablaUsuarios.getWidth()*15/100);
            jTTablaUsuarios.getColumnModel().getColumn(7).setPreferredWidth(jTTablaUsuarios.getWidth()*21/100);
            jTTablaUsuarios.getColumnModel().getColumn(8).setPreferredWidth(jTTablaUsuarios.getWidth()*11/100);
//            jTTablaUsuarios.getColumnModel().getColumn(9).setPreferredWidth(jTTablaUsuarios.getWidth()/9);
          
            jTTablaUsuarios.setAlignmentY(CENTER_ALIGNMENT);
            jTTablaUsuarios.setAlignmentX(CENTER_ALIGNMENT);
            
            jTTablaUsuarios.setRowHeight(jTTablaUsuarios.getParent().getHeight()/10);

    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitulo = new javax.swing.JPanel();
        VolverAInicio = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLUsuariosCreados = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        JBGuardarYVolver = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTTablaUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        panelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        panelTitulo.setForeground(new java.awt.Color(255, 255, 255));

        VolverAInicio.setBackground(new java.awt.Color(20, 34, 255));
        VolverAInicio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        VolverAInicio.setForeground(new java.awt.Color(255, 255, 255));
        VolverAInicio.setText("Volver a opciones");
        VolverAInicio.setToolTipText("");
        VolverAInicio.setActionCommand("Volver a \\n opciones");
        VolverAInicio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        VolverAInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverAInicioActionPerformed(evt);
            }
        });

        salir.setBackground(new java.awt.Color(20, 34, 255));
        salir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        salir.setForeground(new java.awt.Color(255, 255, 255));
        salir.setText("Salir");
        salir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Rockwell", 2, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DollyCalendar");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(VolverAInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelTituloLayout.createSequentialGroup()
                        .addGroup(panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(VolverAInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(17, 17, 17)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLUsuariosCreados.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLUsuariosCreados.setText("Usuarios creados:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLUsuariosCreados)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLUsuariosCreados)
                .addGap(15, 15, 15))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        JBGuardarYVolver.setBackground(new java.awt.Color(20, 34, 255));
        JBGuardarYVolver.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        JBGuardarYVolver.setForeground(new java.awt.Color(255, 255, 255));
        JBGuardarYVolver.setText("Guardar y volver");
        JBGuardarYVolver.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JBGuardarYVolver.setBorderPainted(false);
        JBGuardarYVolver.setMaximumSize(new java.awt.Dimension(180, 40));
        JBGuardarYVolver.setMinimumSize(new java.awt.Dimension(180, 40));
        JBGuardarYVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBGuardarYVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBGuardarYVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JBGuardarYVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTTablaUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        jTTablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTTablaUsuarios);
        if (jTTablaUsuarios.getColumnModel().getColumnCount() > 0) {
            jTTablaUsuarios.getColumnModel().getColumn(0).setResizable(false);
            jTTablaUsuarios.getColumnModel().getColumn(1).setResizable(false);
            jTTablaUsuarios.getColumnModel().getColumn(2).setResizable(false);
            jTTablaUsuarios.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverAInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverAInicioActionPerformed
        // TODO add your handling code here:


                GUIInicioAdmin inicioAdmin = new GUIInicioAdmin(usuariosIniciales,administradores,materias);
                inicioAdmin.setVisible(true);
                this.dispose();


    }//GEN-LAST:event_VolverAInicioActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(panelTitulo, "Esta seguro que desea salir?",
            "confirmacion", JOptionPane.YES_NO_OPTION);
        if(respuesta==0){
            System.exit(0);
        }
    }//GEN-LAST:event_salirActionPerformed

    private void JBGuardarYVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGuardarYVolverActionPerformed
        // TODO add your handling code here:
        
        HashGeneric<String,Persona> us;
        int respuesta = JOptionPane.showConfirmDialog(panelTitulo, "Desea guardar cambios y volver?",
            "confirmacion", JOptionPane.YES_NO_OPTION);
        if(respuesta==0){ 
            
            
            if(editar){
                
                GUIInicioAdmin inicioAdmin = new GUIInicioAdmin(usuariosEditados(),administradores,materias);
                inicioAdmin.setVisible(true);
                this.dispose();
                
            }else{
                
                
                GUIInicioAdmin inicioAdmin = new GUIInicioAdmin(usuarios,administradores,materias);
                inicioAdmin.setVisible(true);
                this.dispose();
                
            }
            

                
        }
    }//GEN-LAST:event_JBGuardarYVolverActionPerformed

       public HashGeneric<String,Persona> usuariosEditados(){
            HashGeneric<String,Persona> estudiantes=new HashGeneric<>();
            Estudiante estudiante;
            Estudiante estudianteViejo;
            
            
//                        datos[i][2] = es.getNombre();
//            datos[i][3] = es.getApellido();
//            datos[i][4] = es.getUsuario();
//            datos[i][5] = es.getCodigo();
//            datos[i][6] = es.getPregrado();
//            datos[i][7] = es.getCorreo();
//            datos[i][8] = es.getContraseña();
            
           for(int i=0;i<jTTablaUsuarios.getRowCount();i++){
               estudianteViejo=(Estudiante) usuarios.get(String.valueOf(jTTablaUsuarios.getValueAt(i,4)));
               estudiante = new Estudiante(String.valueOf(jTTablaUsuarios.getValueAt(i,4)),
                       String.valueOf(jTTablaUsuarios.getValueAt(i,8)), 
                       Integer.parseInt(String.valueOf(jTTablaUsuarios.getValueAt(i,5))),
                       String.valueOf(jTTablaUsuarios.getValueAt(i,2)), 
                       String.valueOf(jTTablaUsuarios.getValueAt(i,3)), 
                       estudianteViejo.getCasillas(), String.valueOf(jTTablaUsuarios.getValueAt(i,6)));
               estudiantes.add(String.valueOf(jTTablaUsuarios.getValueAt(i,4)), estudiante);
               
           }
           return estudiantes;
        }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIVerUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIVerUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIVerUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIVerUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIVerUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBGuardarYVolver;
    private javax.swing.JButton VolverAInicio;
    private javax.swing.JLabel jLUsuariosCreados;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTTablaUsuarios;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
