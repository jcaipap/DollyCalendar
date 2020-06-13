
package gui;


import data.Persona;
import estructuas.HashGeneric;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class GUIGeneracionUsuario extends javax.swing.JFrame {
    
    
    
    HashGeneric<String,Persona> usuarios;
    HashGeneric<String,Persona> administradores;
        
  
    public GUIGeneracionUsuario(HashGeneric<String,Persona> usuarios,HashGeneric<String,Persona> administradores) {
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

    public GUIGeneracionUsuario() {
    }


    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(120, 0), new java.awt.Dimension(120, 0), new java.awt.Dimension(120, 32767));
        label1 = new java.awt.Label();
        idExistente = new javax.swing.JLabel();
        usuarioExistente = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        inputNombre = new javax.swing.JTextField();
        inputCorreo = new javax.swing.JTextField();
        inputApellido = new javax.swing.JTextField();
        inputUsuario = new javax.swing.JTextField();
        nombre = new javax.swing.JLabel();
        apellido = new javax.swing.JLabel();
        contraseña = new javax.swing.JLabel();
        reingresarContraseña = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        crearUsuario = new javax.swing.JButton();
        inputId = new javax.swing.JTextField();
        id = new javax.swing.JLabel();
        inputNuevaContraseña = new javax.swing.JPasswordField();
        inputReingresoNuevaContraseña = new javax.swing.JPasswordField();
        edad = new javax.swing.JLabel();
        inputEdad = new javax.swing.JTextField();
        terminosCondiciones = new javax.swing.JLabel();
        correo = new javax.swing.JLabel();
        panelTitulo = new javax.swing.JPanel();
        VolverAInicio = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();

        jLabel4.setText("Apellido");

        jLabel6.setText("Contraseña");

        label1.setText("label1");

        usuarioExistente.setText(" ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        inputNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNombreActionPerformed(evt);
            }
        });
        inputNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputNombreKeyTyped(evt);
            }
        });

        inputCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCorreoActionPerformed(evt);
            }
        });
        inputCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputCorreoKeyTyped(evt);
            }
        });

        inputApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputApellidoActionPerformed(evt);
            }
        });
        inputApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputApellidoKeyTyped(evt);
            }
        });

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

        nombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nombre.setForeground(new java.awt.Color(0, 0, 0));
        nombre.setText("Nombre");

        apellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        apellido.setForeground(new java.awt.Color(0, 0, 0));
        apellido.setText("Apellido");

        contraseña.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        contraseña.setForeground(new java.awt.Color(0, 0, 0));
        contraseña.setText("Contraseña");

        reingresarContraseña.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        reingresarContraseña.setForeground(new java.awt.Color(0, 0, 0));
        reingresarContraseña.setText("Reingresar contraseña");

        usuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usuario.setForeground(new java.awt.Color(0, 0, 0));
        usuario.setText("Usuario");

        crearUsuario.setBackground(new java.awt.Color(20, 34, 255));
        crearUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        crearUsuario.setForeground(new java.awt.Color(255, 255, 255));
        crearUsuario.setText("Crear Usuario");
        crearUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        crearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearUsuarioActionPerformed(evt);
            }
        });

        inputId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputIdActionPerformed(evt);
            }
        });
        inputId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputIdKeyTyped(evt);
            }
        });

        id.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        id.setForeground(new java.awt.Color(0, 0, 0));
        id.setText("ID");

        inputNuevaContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNuevaContraseñaActionPerformed(evt);
            }
        });

        edad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        edad.setForeground(new java.awt.Color(0, 0, 0));
        edad.setText("Edad");

        inputEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEdadActionPerformed(evt);
            }
        });
        inputEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputEdadKeyTyped(evt);
            }
        });

        terminosCondiciones.setForeground(new java.awt.Color(0, 0, 0));
        terminosCondiciones.setText("Al seleccionar Crear Usuario usted acepta nuestros terminos y condiciones de uso.");

        correo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        correo.setForeground(new java.awt.Color(0, 0, 0));
        correo.setText("Correo electrónico");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(apellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(usuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(97, 97, 97))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(contraseña, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputReingresoNuevaContraseña, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputNuevaContraseña, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputEdad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(correo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reingresarContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(terminosCondiciones))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(crearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(inputCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(inputEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputNuevaContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reingresarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputReingresoNuevaContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(crearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(terminosCondiciones)
                .addGap(18, 18, 18))
        );

        nombre.getAccessibleContext().setAccessibleName("");
        apellido.getAccessibleContext().setAccessibleName("");
        contraseña.getAccessibleContext().setAccessibleName("");
        reingresarContraseña.getAccessibleContext().setAccessibleName("");
        usuario.getAccessibleContext().setAccessibleName("");
        id.getAccessibleContext().setAccessibleName("");
        edad.getAccessibleContext().setAccessibleName("");
        correo.getAccessibleContext().setAccessibleName("");

        panelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        panelTitulo.setForeground(new java.awt.Color(255, 255, 255));

        VolverAInicio.setBackground(new java.awt.Color(20, 34, 255));
        VolverAInicio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        VolverAInicio.setForeground(new java.awt.Color(255, 255, 255));
        VolverAInicio.setText("Volver a inicio");
        VolverAInicio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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
                .addGap(15, 15, 15)
                .addComponent(VolverAInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addGap(45, 45, 45)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VolverAInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverAInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverAInicioActionPerformed
        // TODO add your handling code here:
        
        int respuesta = JOptionPane.showConfirmDialog(panelTitulo, "Esta seguro que desea volver al inicio?",
        "confirmacion", JOptionPane.YES_NO_OPTION);
        if(respuesta==0){       
            GUIInicio inicio = new GUIInicio(usuarios,administradores);
            inicio.setVisible(true);
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

    private void inputEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputEdadKeyTyped
        // TODO add your handling code here:
        char tecla;
        tecla=evt.getKeyChar();
        if(!Character.isDigit(tecla)){
            evt.consume();
        }
    }//GEN-LAST:event_inputEdadKeyTyped

    private void inputEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEdadActionPerformed

    private void inputNuevaContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNuevaContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNuevaContraseñaActionPerformed

    private void inputIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputIdKeyTyped
        // TODO add your handling code here:
        char tecla;
        tecla=evt.getKeyChar();
        if(!Character.isDigit(tecla)){
            evt.consume();
        }
    }//GEN-LAST:event_inputIdKeyTyped

    private void inputIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputIdActionPerformed

    private void crearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearUsuarioActionPerformed


//        
//        if(!(GeneracionUsuario.validarDatosIngresados(inputNombre.getText(),
//            inputApellido.getText(), inputCorreo.getText(),
//            inputUsuario.getText(), inputNuevaContraseña.getText(),
//            inputReingresoNuevaContraseña.getText(),inputEdad.getText(),
//            inputId.getText(),baseDatosUsuarios))){  
//                JOptionPane.showMessageDialog(rootPane, "Error creando el usuario",
//                        "error", JOptionPane.ERROR_MESSAGE);
//                if (!ControlErrores.comprobacionNumerica(inputEdad.getText())){
//                edad.setForeground(Color.RED);
//                edad.setText("Edad*");
//            } if (!ControlErrores.comprobacionNumerica(inputId.getText())){
//                id.setForeground(Color.RED);
//                id.setText("ID*");
//            } if (!(inputNuevaContraseña.getText().equals(inputReingresoNuevaContraseña.getText()))){
//                contraseña.setForeground(Color.RED);
//                reingresarContraseña.setForeground(Color.RED);
//                contraseña.setText(contraseña.getText()+"*");
//                reingresarContraseña.setText(reingresarContraseña.getText()+"*");
//            } if ("".equals(inputNombre.getText())){
//                nombre.setForeground(Color.RED);
//                nombre.setText("Nombre*");
//            } if ("".equals(inputApellido.getText())){
//                apellido.setForeground(Color.RED);
//                apellido.setText("Apellido*");
//            } if ("".equals(inputCorreo.getText())){
//                correo.setForeground(Color.RED);
//                correo.setText("Correo*");
//            } if ("".equals(inputUsuario.getText())){
//                usuario.setForeground(Color.RED);
//                usuario.setText("Usuario*");
//            } if ("".equals(inputNuevaContraseña.getText())){
//                contraseña.setForeground(Color.RED);
//                contraseña.setText("Contraseña*");
//            } if ("".equals(inputReingresoNuevaContraseña.getText())){
//                reingresarContraseña.setForeground(Color.RED);
//                reingresarContraseña.setText("Reingresar contraseña*");
//
//            }
//        }
        
        
        
        
        
        
        GUIInicio inicio = new GUIInicio(usuarios,administradores);
        inicio.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_crearUsuarioActionPerformed

    private void inputUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputUsuarioKeyTyped
        // TODO add your handling code here:
        char tecla;
        tecla=evt.getKeyChar();
        if(!Character.isLetterOrDigit(tecla)){
            evt.consume();
        }
    }//GEN-LAST:event_inputUsuarioKeyTyped

    private void inputUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputUsuarioActionPerformed

    private void inputApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputApellidoKeyTyped
        // TODO add your handling code here:

        char tecla;
        tecla=evt.getKeyChar();
        if(!Character.isLetter(tecla)){
            evt.consume();
        }
    }//GEN-LAST:event_inputApellidoKeyTyped

    private void inputApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputApellidoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_inputApellidoActionPerformed

    private void inputCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputCorreoKeyTyped
        // TODO add your handling code here:
        char tecla;
        tecla=evt.getKeyChar();
        if(!Character.isLetterOrDigit(tecla)&&tecla!='@'&&tecla!='.'){
            evt.consume();
        }
        
    }//GEN-LAST:event_inputCorreoKeyTyped

    private void inputCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCorreoActionPerformed

    private void inputNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNombreKeyTyped
        // TODO add your handling code here:
        char tecla;
        tecla=evt.getKeyChar();
        if((!Character.isLetter(tecla))){
            evt.consume();
        } else {
        }
    }//GEN-LAST:event_inputNombreKeyTyped

    private void inputNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNombreActionPerformed

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
            java.util.logging.Logger.getLogger(GUIGeneracionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIGeneracionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIGeneracionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIGeneracionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUIGeneracionUsuario().setVisible(true);
                

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton VolverAInicio;
    private javax.swing.JLabel apellido;
    private javax.swing.JLabel contraseña;
    private javax.swing.JLabel correo;
    private javax.swing.JButton crearUsuario;
    private javax.swing.JLabel edad;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel id;
    private javax.swing.JLabel idExistente;
    private javax.swing.JTextField inputApellido;
    private javax.swing.JTextField inputCorreo;
    private javax.swing.JTextField inputEdad;
    private javax.swing.JTextField inputId;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JPasswordField inputNuevaContraseña;
    private javax.swing.JPasswordField inputReingresoNuevaContraseña;
    private javax.swing.JTextField inputUsuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label label1;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel nombre;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JLabel reingresarContraseña;
    private javax.swing.JButton salir;
    private javax.swing.JLabel terminosCondiciones;
    private javax.swing.JLabel usuario;
    private javax.swing.JLabel usuarioExistente;
    // End of variables declaration//GEN-END:variables
}
