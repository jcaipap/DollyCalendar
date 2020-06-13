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
import estructuas.HashGeneric;
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




/**
 *
 * @author andre
 */
public class GUIVerCursos extends javax.swing.JFrame {

    /**
     * Creates new form GUIVerUsuarios
     */
    HashGeneric<String,Persona> usuarios;
    HashGeneric<String,Persona> administradores;
    
    public GUIVerCursos(HashGeneric<String,Persona> usuarios,HashGeneric<String,Persona> administradores) {
        this.usuarios=usuarios;
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

    }

    public GUIVerCursos() {
    }
    
    
    
    
    
    
    public void addRowtoJTable(ArrayList<Materia> materias){
        String[] columnas = new String[]{
            "Seleccionar", "Número", "Nombre", "Apellido", "Usuario", "Código", "Pregrado", "Correo", "Contraseña"
        };
        final Class[] tiposColumnas = new Class[]{
            int.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.Integer.class,
            java.lang.String.class,
            int.class,
            java.lang.String.class,
            JButton.class
        };
        Object[][] datos = new Object[50][9];

        for (int i = 0; i < materias.size(); i++) {
            Materia mat = materias.get(i);
            datos[i][0] = new JRadioButton(" ");
            datos[i][1] = i+1;
            datos[i][2] = mat.getTitulo();
            datos[i][3] = mat.getCodigo();
            datos[i][4] = mat.getTipologia();
            datos[i][5] = mat.getCreditos();
            datos[i][6] = mat.getDescripcion();

        }
        jTTablaCursos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTTablaCursos.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        
//        jTable1.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int fila = jTable1.rowAtPoint(e.getPoint());
//                int columna = jTable1.columnAtPoint(e.getPoint());
//                if (jTable1.getModel().getColumnClass(columna).equals(JButton.class)) {
//                    ArrayList<Producto> eliminar=productosComprar(carrito);
//                    String nombreBorrar=String.valueOf(jTable1.getValueAt(jTable1.rowAtPoint(e.getPoint()),3));
//                    String cBorrar=String.valueOf(jTable1.getValueAt(jTable1.rowAtPoint(e.getPoint()),6));
//                    int cantidadBorrar=Integer.parseInt(cBorrar);
//                    carrito=CarritoCompras.eliminarProducto(carrito, nombreBorrar,cantidadBorrar);
//                    DefaultTableModel model=new DefaultTableModel();
//                    model=(DefaultTableModel)jTable1.getModel();
//                    model.removeRow(jTable1.getSelectedRow());
//                    int valor=valorCuenta(carrito);
//                    lblValorCuenta.setText(String.valueOf(valor));
//
//                }
//            }
//        });
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
        jPanel1 = new javax.swing.JPanel();
        jSPTablaUsuarios = new javax.swing.JScrollPane();
        jTTablaCursos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLUsuariosCreados = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        JBGuardarYVolver = new javax.swing.JButton();

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
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DollyCalendar");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(VolverAInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(VolverAInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSPTablaUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        jSPTablaUsuarios.setForeground(new java.awt.Color(255, 255, 255));

        jTTablaCursos.setBackground(new java.awt.Color(255, 255, 255));
        jTTablaCursos.setForeground(new java.awt.Color(255, 255, 255));
        jTTablaCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seleccionar", "Número", "Nombre", "Código", "Tipologia", "Créditos", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTTablaCursos.getTableHeader().setReorderingAllowed(false);
        jSPTablaUsuarios.setViewportView(jTTablaCursos);
        if (jTTablaCursos.getColumnModel().getColumnCount() > 0) {
            jTTablaCursos.getColumnModel().getColumn(0).setResizable(false);
            jTTablaCursos.getColumnModel().getColumn(1).setResizable(false);
            jTTablaCursos.getColumnModel().getColumn(2).setResizable(false);
            jTTablaCursos.getColumnModel().getColumn(3).setResizable(false);
            jTTablaCursos.getColumnModel().getColumn(4).setResizable(false);
            jTTablaCursos.getColumnModel().getColumn(5).setResizable(false);
            jTTablaCursos.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSPTablaUsuarios)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSPTablaUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLUsuariosCreados.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLUsuariosCreados.setForeground(new java.awt.Color(0, 0, 0));
        jLUsuariosCreados.setText("Cursos creados:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverAInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverAInicioActionPerformed
        // TODO add your handling code here:

        int respuesta = JOptionPane.showConfirmDialog(panelTitulo, "Esta seguro que desea volver al modo administrador?",
            "confirmacion", JOptionPane.YES_NO_OPTION);
        if(respuesta==0){  
                GUIInicioAdmin inicioAdmin = new GUIInicioAdmin(usuarios,administradores);
                inicioAdmin.setVisible(true);
                this.dispose();
        }

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
        int respuesta = JOptionPane.showConfirmDialog(panelTitulo, "Esta seguro que desea volver al modo administrador?",
            "confirmacion", JOptionPane.YES_NO_OPTION);
        if(respuesta==0){  
                GUIInicioAdmin inicioAdmin = new GUIInicioAdmin(usuarios,administradores);
                inicioAdmin.setVisible(true);
                this.dispose();
        }
    }//GEN-LAST:event_JBGuardarYVolverActionPerformed

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
            java.util.logging.Logger.getLogger(GUIVerCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIVerCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIVerCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIVerCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIVerCursos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBGuardarYVolver;
    private javax.swing.JButton VolverAInicio;
    private javax.swing.JLabel jLUsuariosCreados;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jSPTablaUsuarios;
    private javax.swing.JTable jTTablaCursos;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
