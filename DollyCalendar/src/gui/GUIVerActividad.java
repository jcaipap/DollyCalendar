/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.Actividad;
import data.AdminDataBaseHandler;
import data.Casilla;
import data.Estudiante;
import data.Materia;
import data.MateriasDataBaseHandler;
import data.Persona;
import data.UsuariosDataBaseHandler;
import estructuas.HashGeneric;
import static gui.GUIBuscador.crearCalendario;
import static gui.GUIBuscador.fecha2;
import java.awt.Image;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import logica.Metodos;

/**
 *
 * @author andre
 */
public class GUIVerActividad extends javax.swing.JFrame {

    /**
     * Creates new form GUIVerActividad
     */
    
    HashGeneric<String, Persona> usuarios;
    HashGeneric<String, Persona> administradores;
    HashGeneric<Integer, Materia> materias;
    AdminDataBaseHandler adminbase;
    MateriasDataBaseHandler materiasbase;
    UsuariosDataBaseHandler userbase;
    Casilla casilla;
    Estudiante estudiante;
    Actividad actividadNueva;
    
    
    public GUIVerActividad(Casilla casilla, HashGeneric<String, Persona> usuarios, HashGeneric<String, Persona> administradores,HashGeneric<Integer, Materia> materias,AdminDataBaseHandler adminbase,MateriasDataBaseHandler materiasbase,UsuariosDataBaseHandler userbase, Estudiante estudiante) {
        initComponents();
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
        this.casilla=casilla;
        TituloText.setText(casilla.getTitulo());
        ImpText.setText(String.valueOf(casilla.getImportancia()));
        descText.setText(casilla.getDescripcion());
        this.usuarios=usuarios;
        this.administradores=administradores;
        this.materias=materias;
        this.adminbase=adminbase;
        this.materiasbase=materiasbase;
        this.userbase=userbase;
        this.estudiante=estudiante;
        
        
        
        jComboBoxHora.setSelectedIndex(casilla.getFechaInicio().getTime().getHours()-1);
        jComboBoxMinuto.setSelectedItem(casilla.getFechaInicio().getTime().getMinutes());
        
        jComboBoxAño.setModel(( new DefaultComboBoxModel(
                new String[] { String.valueOf(casilla.getFechaInicio().getTime().getYear()-2+1900), String.valueOf(casilla.getFechaInicio().getTime().getYear()-1+1900), String.valueOf(casilla.getFechaInicio().getTime().getYear()+1900), String.valueOf(casilla.getFechaInicio().getTime().getYear()+1+1900),String.valueOf(casilla.getFechaInicio().getTime().getYear()+2+1900) })
              ));
        jComboBoxAño.setSelectedItem(String.valueOf(casilla.getFechaInicio().getTime().getYear()+1900));
        jComboBoxMes.setModel(( new DefaultComboBoxModel(
                new String[] { "Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"})
              ));
        
        jComboBoxMes.setSelectedIndex(casilla.getFechaInicio().getTime().getMonth());
        jComboBoxDia.setModel(( new DefaultComboBoxModel(
                new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"})
              ));
        jComboBoxDia.setSelectedIndex(casilla.getFechaInicio().getTime().getDate()-1);
        jComboBoxHora.setSelectedItem(casilla.getFechaInicio().getTime().getHours());
        jComboBoxMinuto.setSelectedItem(String.valueOf(casilla.getFechaInicio().getTime().getMinutes()));
        
       
        jComboBoxAño2.setModel(( new DefaultComboBoxModel(
                new String[] { String.valueOf(casilla.getFechaFinalizacion().getTime().getYear()-2+1900), String.valueOf(casilla.getFechaFinalizacion().getTime().getYear()-1+1900), String.valueOf(casilla.getFechaFinalizacion().getTime().getYear()+1900), String.valueOf(casilla.getFechaFinalizacion().getTime().getYear()+1+1900),String.valueOf(casilla.getFechaFinalizacion().getTime().getYear()+2+1900) })
              ));
        jComboBoxAño2.setSelectedItem(String.valueOf(casilla.getFechaFinalizacion().getTime().getYear()+1900));
        jComboBoxMes2.setModel(( new DefaultComboBoxModel(
                new String[] { "Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"})
              ));
        

        jComboBoxMes2.setSelectedIndex(casilla.getFechaFinalizacion().getTime().getMonth());
        
        
        jComboBoxDia2.setModel(( new DefaultComboBoxModel(
                new String[] {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"})
              ));
        
        
        
        
        jComboBoxDia2.setSelectedIndex(casilla.getFechaFinalizacion().getTime().getDate()-1);
        jComboBoxHora2.setSelectedIndex(casilla.getFechaFinalizacion().getTime().getHours()-1);
        jComboBoxMinuto2.setSelectedItem(String.valueOf(casilla.getFechaFinalizacion().getTime().getMinutes()));
        jLabel18.setVisible(false);
    }

    
    
    
    public GUIVerActividad() {
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
        panelTitulo = new javax.swing.JPanel();
        VolverAInicio = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        salir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        TituloText = new javax.swing.JTextField();
        ImpText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JBGuardarYVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        descText = new javax.swing.JTextArea();
        jComboBoxHora = new javax.swing.JComboBox<>();
        jComboBoxMinuto = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxAño = new javax.swing.JComboBox<>();
        jComboBoxDia = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxMes = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jComboBoxAño2 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxMes2 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxDia2 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxHora2 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxMinuto2 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel2.setFont(new java.awt.Font("Rockwell", 2, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DollyCalendar");

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

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(VolverAInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addComponent(VolverAInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TituloText.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        TituloText.setText("jTextField1");
        TituloText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TituloTextActionPerformed(evt);
            }
        });
        TituloText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TituloTextKeyTyped(evt);
            }
        });

        ImpText.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        ImpText.setText("jTextField2");
        ImpText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImpTextActionPerformed(evt);
            }
        });
        ImpText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ImpTextKeyTyped(evt);
            }
        });

        jLabel5.setText("Aquí puede editar su actividad");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Título:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Importancia (1-5):");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Descripción:");

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

        descText.setColumns(20);
        descText.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        descText.setRows(5);
        descText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                descTextMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(descText);

        jComboBoxHora.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jComboBoxHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxHoraActionPerformed(evt);
            }
        });

        jComboBoxMinuto.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxMinuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "15", "30", "45" }));
        jComboBoxMinuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMinutoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Fecha de finalización:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Fecha de inicio:");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Mes");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Dia");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Hora");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Minuto");

        jComboBoxAño.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jComboBoxAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAñoActionPerformed(evt);
            }
        });

        jComboBoxDia.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jComboBoxDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDiaActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Año");

        jComboBoxMes.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jComboBoxMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMesActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("Año");

        jComboBoxAño2.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxAño2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jComboBoxAño2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAño2ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("Mes");

        jComboBoxMes2.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxMes2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jComboBoxMes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMes2ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("Dia");

        jComboBoxDia2.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxDia2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jComboBoxDia2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDia2ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("Hora");

        jComboBoxHora2.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxHora2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jComboBoxHora2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxHora2ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("Minuto");

        jComboBoxMinuto2.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxMinuto2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "15", "30", "45" }));
        jComboBoxMinuto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMinuto2ActionPerformed(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setForeground(new java.awt.Color(255, 0, 51));
        jLabel18.setText("Hay un error en la creación de la actividad*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(47, 47, 47))
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addComponent(ImpText)
                                    .addComponent(TituloText)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxAño2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxMes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxDia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxHora2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxMinuto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(235, 235, 235)
                                        .addComponent(JBGuardarYVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(30, 30, 30))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TituloText)
                    .addComponent(jLabel6))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ImpText))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel11)
                                    .addComponent(jComboBoxAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxHora2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxMinuto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel15)
                        .addComponent(jLabel16)
                        .addComponent(jLabel17)
                        .addComponent(jComboBoxAño2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxDia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxMes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBGuardarYVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(498, 498, 498)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ImpTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImpTextActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_ImpTextActionPerformed

    private void JBGuardarYVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGuardarYVolverActionPerformed
        // TODO add your handling code here:

        Calendar fechaI = Metodos.calendarGenerator(Integer.parseInt(String.valueOf(jComboBoxAño.getSelectedItem())), Integer.parseInt(String.valueOf(jComboBoxMes.getSelectedIndex())), Integer.parseInt(String.valueOf(jComboBoxDia.getSelectedItem())), Integer.parseInt(String.valueOf(jComboBoxHora.getSelectedItem())), Integer.parseInt(String.valueOf(jComboBoxMinuto.getSelectedItem())));
        Calendar fechaF = Metodos.calendarGenerator(Integer.parseInt(String.valueOf(jComboBoxAño2.getSelectedItem())), Integer.parseInt(String.valueOf(jComboBoxMes2.getSelectedIndex())), Integer.parseInt(String.valueOf(jComboBoxDia2.getSelectedItem())), Integer.parseInt(String.valueOf(jComboBoxHora2.getSelectedItem())), Integer.parseInt(String.valueOf(jComboBoxMinuto2.getSelectedItem())));
        
        if(fechaF.compareTo(fechaI)==1){
            
        Casilla actividadNueva=new Casilla(TituloText.getText(), descText.getText(), Integer.parseInt(ImpText.getText()), fechaI,fechaF);

        estudiante.getCasillas().remove(casilla);
        estudiante.getCasillas().add(actividadNueva);
            GUIBuscador busc = new GUIBuscador(usuarios, administradores, materias, adminbase, materiasbase, userbase, estudiante);
            busc.setVisible(true);
            this.dispose();
        }else{
            jLabel18.setVisible(true);
        }

        
    }//GEN-LAST:event_JBGuardarYVolverActionPerformed

    private void TituloTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TituloTextKeyTyped
        // TODO add your handling code here:
        
        char tecla;
        tecla=evt.getKeyChar();
        if(!Character.isLetterOrDigit(tecla)&&tecla!=' '){
            evt.consume();
        }
        
        
    }//GEN-LAST:event_TituloTextKeyTyped

    private void ImpTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ImpTextKeyTyped
        // TODO add your handling code here:
        char tecla;
        tecla=evt.getKeyChar();
//        Character.isDigit(tecla)
        if(ImpText.getText().toCharArray().length!=0){
            evt.consume();
        } else if(!Character.isDigit(tecla)){
            evt.consume();
        }else if(Integer.parseInt(String.valueOf(tecla))>5||Integer.parseInt(String.valueOf(tecla))<1){
            evt.consume();
        }
        
    }//GEN-LAST:event_ImpTextKeyTyped

    private void jComboBoxHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxHoraActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxHoraActionPerformed

    private void jComboBoxMinutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMinutoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxMinutoActionPerformed

    private void jComboBoxAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAñoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxAñoActionPerformed

    private void jComboBoxDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDiaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxDiaActionPerformed

    private void jComboBoxMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMesActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxMesActionPerformed

    private void jComboBoxAño2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAño2ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxAño2ActionPerformed

    private void jComboBoxMes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMes2ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxMes2ActionPerformed

    private void jComboBoxDia2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDia2ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxDia2ActionPerformed

    private void jComboBoxHora2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxHora2ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxHora2ActionPerformed

    private void jComboBoxMinuto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMinuto2ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxMinuto2ActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(panelTitulo, "Esta seguro que desea salir?",
            "confirmacion", JOptionPane.YES_NO_OPTION);
        if (respuesta == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_salirActionPerformed

    private void VolverAInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverAInicioActionPerformed
        // TODO add your handling code here:

        GUIBuscador busc = new GUIBuscador(usuarios, administradores, materias, adminbase, materiasbase, userbase,estudiante);
        busc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VolverAInicioActionPerformed

    private void TituloTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TituloTextActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_TituloTextActionPerformed

    private void descTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descTextMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_descTextMouseClicked

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
            java.util.logging.Logger.getLogger(GUIVerActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIVerActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIVerActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIVerActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIVerActividad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ImpText;
    private javax.swing.JButton JBGuardarYVolver;
    private javax.swing.JTextField TituloText;
    private javax.swing.JButton VolverAInicio;
    private javax.swing.JTextArea descText;
    private javax.swing.JComboBox<String> jComboBoxAño;
    private javax.swing.JComboBox<String> jComboBoxAño2;
    private javax.swing.JComboBox<String> jComboBoxDia;
    private javax.swing.JComboBox<String> jComboBoxDia2;
    private javax.swing.JComboBox<String> jComboBoxHora;
    private javax.swing.JComboBox<String> jComboBoxHora2;
    private javax.swing.JComboBox<String> jComboBoxMes;
    private javax.swing.JComboBox<String> jComboBoxMes2;
    private javax.swing.JComboBox<String> jComboBoxMinuto;
    private javax.swing.JComboBox<String> jComboBoxMinuto2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
