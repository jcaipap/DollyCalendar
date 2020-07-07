/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.AdminDataBaseHandler;
import data.Casilla;
import data.Estudiante;
import data.Grupo;
import data.Materia;
import data.MateriasDataBaseHandler;
import data.Persona;
import data.UsuariosDataBaseHandler;
import estructuas.DynamicArray;
import estructuas.HashGeneric;
import estructuas.PriorityQueue;
import java.awt.Color;
import java.awt.Component;
import static java.awt.Component.CENTER_ALIGNMENT;
import static java.awt.Component.TOP_ALIGNMENT;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author andre
 */
public class GUIVerMaterias extends javax.swing.JFrame {

    /**
     * Creates new form GUIVerMaterias
     */
    public boolean editar = false;
    public HashGeneric<String, Persona> usuarios;
    public HashGeneric<Integer, Materia> materias;
    public HashGeneric<String, Persona> administradores;
    AdminDataBaseHandler adminbase;
    MateriasDataBaseHandler materiasbase;
    UsuariosDataBaseHandler userbase;
    boolean arregloBooleano[];
    DynamicArray arrayMaterias;

    public GUIVerMaterias(HashGeneric<String, Persona> usuarios, HashGeneric<String, Persona> administradores, HashGeneric<Integer, Materia> materias, AdminDataBaseHandler adminbase, MateriasDataBaseHandler materiasbase, UsuariosDataBaseHandler userbase) {
        this.materias = materias;
        this.usuarios = usuarios;
        this.administradores = administradores;
        this.adminbase = adminbase;
        this.materiasbase = materiasbase;
        this.userbase = userbase;
        this.arregloBooleano = new boolean[materias.size()];
        this.arrayMaterias = materias.getHashArray();
        for (int i = 0; i < arregloBooleano.length; i++) {
            arregloBooleano[i] = false;
        }

        initComponents();
        getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.setIconImage(new ImageIcon(getClass().getResource("/recursos/iconApp.jpg")).getImage());
        this.setTitle("DollyCalendar");
        ImageIcon icon = new ImageIcon();
        Image image = new ImageIcon(getClass().getResource("/recursos/iconDolly.jpg")).getImage();
        icon.setImage(image);

        ImageIcon icon2 = new ImageIcon();
        Image image2 = new ImageIcon(getClass().getResource("/recursos/iconApp.jpg")).getImage();
        icon2.setImage(image2);
        Icon iconScale2;
        iconScale2 = new ImageIcon(icon2.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_SMOOTH));
        labelLogo.setIcon(iconScale2);

        Graphics graphic = VolverAInicio.getGraphics();
        graphic.setColor(new Color(20, 34, 255));
        VolverAInicio.paint(graphic);

        addRowtoJTable();

        jLUsuariosCreados.setText("Materias creadas: " + String.valueOf(materias.size()));
    }

    public GUIVerMaterias() {
    }

    public void addRowtoJTable() {
        String[] columnas = new String[]{
            "Eliminar", "Ver grupos", "N#", "Titulo", "Codigo", "Tipologia", "Creditos", "#Grupos", "Descripcion"
        };

        jTTablaMaterias.setBackground(Color.WHITE);
        jTTablaMaterias.getParent().setBackground(Color.WHITE);

        final Class[] tiposColumnas = new Class[]{
            JButton.class,
            JButton.class,
            java.lang.Integer.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.Integer.class,
            java.lang.Integer.class,
            java.lang.String.class,};

        Materia mat;
        Object[][] datos = new Object[arrayMaterias.size()][9];
        for (int i = 0; i < arrayMaterias.size(); i++) {
            mat = (Materia) arrayMaterias.getitem(i);
            datos[i][0] = new JButton("Eliminar");
            datos[i][1] = new JButton("Ver");
            datos[i][2] = i + 1;
            datos[i][3] = mat.getTitulo();
            datos[i][4] = mat.getCodigo();
            datos[i][5] = mat.getTipologia();
            datos[i][6] = mat.getCreditos();
            datos[i][7] = mat.getGrupos().length;
            datos[i][8] = mat.getDescripcion();

        }

        jTTablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                columnas) {
            Class[] tipos = tiposColumnas;

            @Override
            public Class getColumnClass(int columnIndex) {
                return tipos[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }

        });

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTTablaMaterias.setDefaultRenderer(String.class, centerRenderer);

        for (int x = 0; x < jTTablaMaterias.getColumnCount(); x++) {
            if (x != 0 && x != 1) {
                jTTablaMaterias.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
            }
        }

        jTTablaMaterias.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                jtable.setAlignmentY(TOP_ALIGNMENT);
                return (Component) o;

            }

        });

        jTTablaMaterias.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                editar = true;

                int fila = jTTablaMaterias.rowAtPoint(e.getPoint());
                int columna = jTTablaMaterias.columnAtPoint(e.getPoint());
                if (jTTablaMaterias.getModel().getColumnClass(columna).equals(JButton.class) && columna == 0) {
//                    try {
//                        materiasbase.ModificarDBC(materias.get(Integer.parseInt(String.valueOf(jTTablaMaterias.getValueAt(fila, 4)))));
//                    } catch (IOException ex) {
//                        Logger.getLogger(GUIVerMaterias.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                    materias.remove(Integer.parseInt(String.valueOf(jTTablaMaterias.getValueAt(fila, 4))));

                    DefaultTableModel model = new DefaultTableModel();
                    model = (DefaultTableModel) jTTablaMaterias.getModel();
                    model.removeRow(jTTablaMaterias.getSelectedRow());

                } else if (jTTablaMaterias.getModel().getColumnClass(columna).equals(JButton.class) && columna == 1) {

                    verGrupo((Materia) arrayMaterias.getitem(fila));

                } else {

                    arregloBooleano[fila] = true;

                }

                jLUsuariosCreados.setText("Materias creadas: " + String.valueOf(materias.size()));
            }
        });

        jTTablaMaterias.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTTablaMaterias.getColumnModel().getColumn(0).setPreferredWidth(jTTablaMaterias.getWidth() * 10 / 100);
        jTTablaMaterias.getColumnModel().getColumn(1).setPreferredWidth(jTTablaMaterias.getWidth() * 7 / 100);
        jTTablaMaterias.getColumnModel().getColumn(2).setPreferredWidth(jTTablaMaterias.getWidth() * 5 / 100);
        jTTablaMaterias.getColumnModel().getColumn(3).setPreferredWidth(jTTablaMaterias.getWidth() * 27 / 100);
        jTTablaMaterias.getColumnModel().getColumn(4).setPreferredWidth(jTTablaMaterias.getWidth() * 8 / 100);
        jTTablaMaterias.getColumnModel().getColumn(5).setPreferredWidth(jTTablaMaterias.getWidth() * 12 / 100);
        jTTablaMaterias.getColumnModel().getColumn(6).setPreferredWidth(jTTablaMaterias.getWidth() * 6 / 100);
        jTTablaMaterias.getColumnModel().getColumn(7).setPreferredWidth(jTTablaMaterias.getWidth() * 6 / 100);
        jTTablaMaterias.getColumnModel().getColumn(8).setPreferredWidth(jTTablaMaterias.getWidth() * 40 / 100);

        jTTablaMaterias.setAlignmentY(CENTER_ALIGNMENT);
        jTTablaMaterias.setAlignmentX(CENTER_ALIGNMENT);

        jTTablaMaterias.setRowHeight(jTTablaMaterias.getParent().getHeight() / 10);

    }

    public void verGrupo(Materia materia) {
        GUIVerGrupos verGrupos = new GUIVerGrupos(usuarios, administradores, materias, materia, adminbase, materiasbase, userbase);
        verGrupos.setVisible(true);
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLUsuariosCreados = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        JBGuardarYVolver = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTTablaMaterias = new javax.swing.JTable();
        panelTitulo = new javax.swing.JPanel();
        VolverAInicio = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLUsuariosCreados.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLUsuariosCreados.setText("Materias creadas:");

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

        jTTablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTTablaMaterias);

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
        jLabel2.setText("UNcalendar");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(VolverAInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
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
                .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBGuardarYVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGuardarYVolverActionPerformed
for (int i = 0; i < arregloBooleano.length; i++) {
            System.out.println(arregloBooleano[i]);
            if (arregloBooleano[i]) {
                Materia mat = (Materia) arrayMaterias.getitem(i);
                Grupo grupos[] = mat.getGrupos();
//                try {
//                    materiasbase.ModificarDBC(mat);
//                } catch (IOException ex) {
//                    Logger.getLogger(GUIVerMaterias.class.getName()).log(Level.SEVERE, null, ex);
//                }

                materias.remove(mat.getCodigo());

                String titulo = String.valueOf(jTTablaMaterias.getModel().getValueAt(i, 3));
                int codigo = Integer.parseInt(String.valueOf(jTTablaMaterias.getModel().getValueAt(i, 4)));
                String tipologia = String.valueOf(jTTablaMaterias.getModel().getValueAt(i, 5));
                int creditos = Integer.parseInt(String.valueOf(jTTablaMaterias.getModel().getValueAt(i, 6)));
                String descripcion = String.valueOf(jTTablaMaterias.getModel().getValueAt(i, 8));

//                try {
//                    materiasbase.InsertarDBC(new Materia(titulo, descripcion, creditos, codigo, creditos, tipologia, grupos));
//                } catch (IOException ex) {
//                    Logger.getLogger(GUIVerMaterias.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                    

                materias.add(codigo, new Materia(titulo, descripcion, creditos, codigo, creditos, tipologia, grupos));

            }
        }

        GUIInicioAdmin inicioAdmin = new GUIInicioAdmin(usuarios, administradores, materias, adminbase, materiasbase, userbase);
        inicioAdmin.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_JBGuardarYVolverActionPerformed

    public HashGeneric<Integer, Materia> materiasEditadas() throws IOException {
        HashGeneric<Integer, Materia> materiasNuevas = new HashGeneric<>();
        Materia materia;
        Materia materiaVieja;

        for (int i = 0; i < jTTablaMaterias.getRowCount(); i++) {

            materiaVieja = materias.getValue(Integer.parseInt(String.valueOf(jTTablaMaterias.getValueAt(i, 4))));
            materia = new Materia(String.valueOf(jTTablaMaterias.getValueAt(i, 3)),
                    String.valueOf(jTTablaMaterias.getValueAt(i, 8)),
                    Integer.parseInt(String.valueOf(jTTablaMaterias.getValueAt(i, 6))),
                    Integer.parseInt(String.valueOf(jTTablaMaterias.getValueAt(i, 4))),
                    Integer.parseInt(String.valueOf(jTTablaMaterias.getValueAt(i, 6))),
                    String.valueOf(jTTablaMaterias.getValueAt(i, 5)),
                    materiaVieja.getGrupos());
            materiasNuevas.add(Integer.parseInt(String.valueOf(materiaVieja.getCodigo())), materia);
        }

        return materiasNuevas;
    }


    private void VolverAInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverAInicioActionPerformed
        // TODO add your handling code here:

        GUIInicioAdmin inicioAdmin = new GUIInicioAdmin(usuarios, administradores, materias, adminbase, materiasbase, userbase);
        inicioAdmin.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_VolverAInicioActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(panelTitulo, "Esta seguro que desea salir?",
                "confirmacion", JOptionPane.YES_NO_OPTION);
        if (respuesta == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_salirActionPerformed

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
            java.util.logging.Logger.getLogger(GUIVerMaterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIVerMaterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIVerMaterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIVerMaterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIVerMaterias().setVisible(true);
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
    private javax.swing.JTable jTTablaMaterias;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
