/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.AdminDataBaseHandler;
import data.Estudiante;
import data.Materia;
import data.MateriasDataBaseHandler;
import data.Persona;
import data.UsuariosDataBaseHandler;
import estructuas.HashGeneric;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import gui.GUIGeneracionUsuario;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JAndres
 */
public class GUIInicio extends javax.swing.JFrame {

//    TreeMap<String, Usuario> baseDatosUsuarios;
//    ArrayList<Producto> catalogo;
//    ArrayList<Producto> carrito;
//    private Component jpanel;
//    UsuariosDataBaseHandler controladorBaseUsuariosGeneracion;
//    CatalogoDataBaseHandler controladorBaseCatalogo;
    /**
     * Creates new form GUIInicio
     */
    HashGeneric<String, Persona> usuarios;
    HashGeneric<String, Persona> administradores;
    HashGeneric<Integer, Materia> materias;
    boolean estudiante = true;
    AdminDataBaseHandler adminbase;
    MateriasDataBaseHandler materiasbase;
    UsuariosDataBaseHandler userbase;
    Estudiante estudianteIn;

    public GUIInicio(HashGeneric<String, Persona> usuarios, HashGeneric<String, Persona> administradores, HashGeneric<Integer, Materia> materias, AdminDataBaseHandler adminbase, MateriasDataBaseHandler materiasbase, UsuariosDataBaseHandler userbase) {
        this.usuarios = usuarios;
        this.administradores = administradores;
        this.materias = materias;
        this.adminbase = adminbase;
        this.materiasbase = materiasbase;
        this.userbase = userbase;
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.iniciarSesion.setEnabled(false);
        this.incorrecto.setForeground(Color.white);

        this.setIconImage(new ImageIcon(getClass().getResource("/recursos/iconApp.jpg")).getImage());
        this.setTitle("DollyCalendar");
        ImageIcon icon = new ImageIcon();
        Image image = new ImageIcon(getClass().getResource("/recursos/iconDolly.jpg")).getImage();
        icon.setImage(image);
        Icon iconScale;
        iconScale = new ImageIcon(icon.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH));
        jLabel5.setIcon(iconScale);

        ImageIcon icon2 = new ImageIcon();
        Image image2 = new ImageIcon(getClass().getResource("/recursos/iconApp.jpg")).getImage();
        icon2.setImage(image2);
        Icon iconScale2;
        iconScale2 = new ImageIcon(icon2.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_SMOOTH));
        labelLogo.setIcon(iconScale2);

//        Graphics graphic=iniciarSesion.getGraphics();
//        graphic.setColor(Color.BLACK);
////        graphic.fillRect(0,0,iniciarSesion.getWidth(),iniciarSesion.getHeight());
////        iniciarSesion.paintComponent(graphic);
////        iniciarSesion.paintComponents(graphic);
////        iniciarSesion.paint(graphic);
//        iniciarSesion.paintAll(graphic);
    }

    public GUIInicio(HashGeneric<String, Persona> usuarios, HashGeneric<String, Persona> administradores, HashGeneric<Integer, Materia> materias, AdminDataBaseHandler adminbase, MateriasDataBaseHandler materiasbase, UsuariosDataBaseHandler userbase, Estudiante estudiante) {
        this.usuarios = usuarios;
        this.administradores = administradores;
        this.materias = materias;
        this.adminbase = adminbase;
        this.materiasbase = materiasbase;
        this.userbase = userbase;
        this.estudianteIn = estudiante;
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.iniciarSesion.setEnabled(false);
        this.incorrecto.setForeground(Color.white);

        this.setIconImage(new ImageIcon(getClass().getResource("/recursos/iconApp.jpg")).getImage());
        this.setTitle("DollyCalendar");
        ImageIcon icon = new ImageIcon();
        Image image = new ImageIcon(getClass().getResource("/recursos/iconDolly.jpg")).getImage();
        icon.setImage(image);
        Icon iconScale;
        iconScale = new ImageIcon(icon.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH));
        jLabel5.setIcon(iconScale);

        ImageIcon icon2 = new ImageIcon();
        Image image2 = new ImageIcon(getClass().getResource("/recursos/iconApp.jpg")).getImage();
        icon2.setImage(image2);
        Icon iconScale2;
        iconScale2 = new ImageIcon(icon2.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_SMOOTH));
        labelLogo.setIcon(iconScale2);

    }

    public GUIInicio() {
    }

    private void seleccionarUsuario(boolean verdad) {

        if (verdad) {
            this.iniciarSesion.setEnabled(true);
        } else {
            this.iniciarSesion.setEnabled(false);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        crearUsuario = new javax.swing.JButton();
        inputUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        iniciarSesion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputContraseña = new javax.swing.JPasswordField();
        contraseña = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        salirPrograma = new javax.swing.JButton();
        valorIncorrecto = new javax.swing.JLabel();
        jBEstudiante = new javax.swing.JRadioButton();
        jBAdmin = new javax.swing.JRadioButton();
        incorrecto = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        labelLogo = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        crearUsuario.setBackground(new java.awt.Color(20, 34, 255));
        crearUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        crearUsuario.setForeground(new java.awt.Color(255, 255, 255));
        crearUsuario.setText("Crear estudiante");
        crearUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        crearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearUsuarioActionPerformed(evt);
            }
        });

        inputUsuario.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        inputUsuario.setToolTipText("");
        inputUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inputUsuario.setName(""); // NOI18N
        inputUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputUsuarioActionPerformed(evt);
            }
        });
        inputUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputUsuarioKeyTyped(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Rockwell", 2, 60)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("UNcalendar");
        jLabel1.setToolTipText("");
        jLabel1.setOpaque(true);

        iniciarSesion.setBackground(new java.awt.Color(20, 34, 255));
        iniciarSesion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        iniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        iniciarSesion.setText("Iniciar sesión");
        iniciarSesion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        iniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarSesionActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Bienvenido a DollyCalendar, una opción fácil y rápida de organizar sus actividades.");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel3.setBackground(Color.WHITE);
        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Por favor seleccione si va a ingresar como estudiante o como administrador");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        inputContraseña.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        inputContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputContraseñaActionPerformed(evt);
            }
        });
        inputContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputContraseñaKeyTyped(evt);
            }
        });

        contraseña.setBackground(new java.awt.Color(255, 51, 51));
        contraseña.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        contraseña.setText("Contraseña:");

        usuario.setBackground(new java.awt.Color(255, 51, 51));
        usuario.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        usuario.setText("Usuario:");

        salirPrograma.setBackground(new java.awt.Color(20, 34, 255));
        salirPrograma.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        salirPrograma.setForeground(new java.awt.Color(255, 255, 255));
        salirPrograma.setText("Salir");
        salirPrograma.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        salirPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirProgramaActionPerformed(evt);
            }
        });

        jBEstudiante.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup.add(jBEstudiante);
        jBEstudiante.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jBEstudiante.setText("Estudiante");
        jBEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEstudianteActionPerformed(evt);
            }
        });

        jBAdmin.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup.add(jBAdmin);
        jBAdmin.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jBAdmin.setText("Administrador");
        jBAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdminActionPerformed(evt);
            }
        });

        incorrecto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        incorrecto.setForeground(new java.awt.Color(255, 0, 51));
        incorrecto.setText("Usuario o contraseña incorrecta*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(valorIncorrecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(432, 432, 432))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salirPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(iniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166)
                        .addComponent(crearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53))
                                    .addComponent(inputUsuario)
                                    .addComponent(inputContraseña)))
                            .addComponent(incorrecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(106, 106, 106)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jBEstudiante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBAdmin)))
                .addGap(83, 83, 83))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salirPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBAdmin)
                    .addComponent(jBEstudiante))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(incorrecto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(125, 125, 125))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(inputUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usuario))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(inputContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addComponent(valorIncorrecto, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        inputUsuario.getAccessibleContext().setAccessibleName("");
        jLabel2.getAccessibleContext().setAccessibleName("Bienvenido al portal de ventas online TriTrago,\npor favor iniciesesión para continuar o cree un uevo usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAdminActionPerformed
        // TODO add your handling code here:
        seleccionarUsuario(true);
        estudiante = false;
    }//GEN-LAST:event_jBAdminActionPerformed

    private void jBEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEstudianteActionPerformed
        // TODO add your handling code here:
        seleccionarUsuario(true);
        estudiante = true;

    }//GEN-LAST:event_jBEstudianteActionPerformed

    private void salirProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirProgramaActionPerformed

        int respuesta = JOptionPane.showConfirmDialog(jPanel1, "Esta seguro que desea salir?",
                "confirmacion", JOptionPane.YES_NO_OPTION);
        if (respuesta == 0) {
//            try {
//                userbase.ModificarDBC(estudianteIn);
//                userbase.InsertarDBC(estudianteIn);
                System.exit(0);
//            } catch (IOException ex) {
//                Logger.getLogger(GUIBuscador.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }//GEN-LAST:event_salirProgramaActionPerformed

    private void inputContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputContraseñaActionPerformed

    private void iniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarSesionActionPerformed

        this.incorrecto.setForeground(Color.red);

        if (estudiante && inputContraseña.getText().equals(usuarios.get(inputUsuario.getText()).getContraseña())) {

            GUIBuscador inicioEst = new GUIBuscador(usuarios, administradores, materias, adminbase, materiasbase, userbase, (Estudiante) usuarios.get(inputUsuario.getText()));
            inicioEst.setVisible(true);
            this.dispose();
        } else if (!estudiante && inputContraseña.getText().equals(administradores.get(inputUsuario.getText()).getContraseña())) {
            GUIInicioAdmin inicioAdmin = new GUIInicioAdmin(usuarios, administradores, materias, adminbase, materiasbase, userbase);
            inicioAdmin.setVisible(true);
            this.dispose();

        }


    }//GEN-LAST:event_iniciarSesionActionPerformed

    private void inputUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputUsuarioKeyTyped
        // TODO add your handling code here:
        char tecla;
        tecla = evt.getKeyChar();
        if (!Character.isLetter(tecla) && !Character.isDigit(tecla)) {
            evt.consume();
        }
    }//GEN-LAST:event_inputUsuarioKeyTyped

    private void inputUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputUsuarioActionPerformed

    private void crearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearUsuarioActionPerformed
        GUIGeneracionUsuario generarUs = new GUIGeneracionUsuario(usuarios, administradores, materias, adminbase, materiasbase, userbase);
        generarUs.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_crearUsuarioActionPerformed

    private void inputContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputContraseñaKeyTyped
        // TODO add your handling code here:
        char tecla;
        tecla = evt.getKeyChar();
        if (!Character.isLetter(tecla) && !Character.isDigit(tecla)) {
            evt.consume();
        }
    }//GEN-LAST:event_inputContraseñaKeyTyped

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
            java.util.logging.Logger.getLogger(GUIInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUIInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel contraseña;
    private javax.swing.JButton crearUsuario;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel incorrecto;
    private javax.swing.JButton iniciarSesion;
    private javax.swing.JPasswordField inputContraseña;
    private javax.swing.JTextField inputUsuario;
    private javax.swing.JRadioButton jBAdmin;
    private javax.swing.JRadioButton jBEstudiante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JButton salirPrograma;
    private javax.swing.JLabel usuario;
    private javax.swing.JLabel valorIncorrecto;
    // End of variables declaration//GEN-END:variables

}
