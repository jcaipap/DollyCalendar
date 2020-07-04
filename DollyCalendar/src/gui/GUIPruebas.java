/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.Actividad;
import data.Casilla;
import data.Estudiante;
import data.Persona;
import estructuas.HashGeneric;
import estructuas.HashNode;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.table.TableCellRenderer;
import logica.Metodos;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author andre
 */
public class GUIPruebas extends javax.swing.JFrame {

    /**
     * Creates new form GUIPruebas
     */
    

    Casilla casillas[] = new Casilla[5];
    

    public GUIPruebas() {
        initComponents();
//        addRowtoJTable();
        
    casillas[0]= new Actividad("Recordatorio Parcial Dinámica", "Estudiar teoría de cuerpo rígido", 5, Metodos.calendarGenerator(2020, 5, 4, 14, 0), Metodos.calendarGenerator(2020, 5, 4, 16, 0));
    casillas[1]= new Actividad("Recordatorio Parcial Dinámica", "Estudiar teoría de cuerpo rígido", 5, Metodos.calendarGenerator(2020, 5, 4, 14, 0), Metodos.calendarGenerator(2020, 5, 4, 16, 0));
    casillas[2]= new Actividad("Recordatorio Parcial Dinámica", "Estudiar teoría de cuerpo rígido", 5, Metodos.calendarGenerator(2020, 5, 4, 14, 0), Metodos.calendarGenerator(2020, 5, 4, 16, 0));
    casillas[3]= new Actividad("Recordatorio Parcial Dinámica", "Estudiar teoría de cuerpo rígido", 5, Metodos.calendarGenerator(2020, 5, 4, 14, 0), Metodos.calendarGenerator(2020, 5, 4, 16, 0));
    casillas[4]= new Actividad("Recordatorio Parcial Dinámica", "Estudiar teoría de cuerpo rígido", 5, Metodos.calendarGenerator(2020, 5, 4, 14, 0), Metodos.calendarGenerator(2020, 5, 4, 16, 0));


//        graphic.fillRect(0,0,iniciarSesion.getWidth(),iniciarSesion.getHeight());
//        iniciarSesion.paintComponent(graphic);
//        iniciarSesion.paintComponents(graphic);
        

//        panel1.add(crearProducto(activ1, panel1));

//        panel1.add(crearProducto(casillas[0], panel1));
        crearCatalogo(casillas);

    }

    private void crearCatalogo(Casilla[] casillas) {

        panel1.removeAll();

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        
        for(int i =0;i<casillas.length;i++){
            
            panel1.add(crearProducto(casillas[i], panel1));
        }
     
        panel1.validate();
        panel1.repaint();
    }
    
    
    public final JPanel crearProducto(Casilla casilla, JPanel panel) {
        

        JPanel panelProducto = new JPanel();
        Dimension dimensioProducto = new Dimension(panel.getWidth(), 120);
        Dimension dimensioAncho = new Dimension(panel.getWidth(), 10);
        panelProducto.setLayout(new BoxLayout(panelProducto, BoxLayout.Y_AXIS));
//        panelProducto.setSize(dimensioProducto);
        JPanel ancho = new JPanel();
        ancho.setSize(dimensioAncho);
        panelProducto.setSize(panel.getWidth(), 120);
        panelProducto.setPreferredSize(dimensioProducto);
//        panelProducto.setMinimumSize(dimensioProducto);
        panelProducto.setForeground(Color.black);
        JLabel cabecera = new JLabel("  ");
        
        
        JLabel nombre = new JLabel(casilla.getTitulo());
        JLabel fechaI = new JLabel("Fecha inicio: "+Metodos.impresionFecha(casilla.getFechaInicio()));
        JLabel fechaF = new JLabel("Fecha final: "+Metodos.impresionFecha(casilla.getFechaFinalizacion()));
        JLabel imp = new JLabel("Importancia: "+casilla.getImportancia());
        JLabel desc = new JLabel("Descripción: "+casilla.getDescripcion());

        nombre.setFont(new Font(nombre.getFont().getName(), BOLD, 20));
        
//        JLabel imagen = new JLabel();
//        JLabel lugar = new JLabel(producto.getPuntoVenta());
//        icon.setImage(image);
//        iconScale = new ImageIcon(icon.getImage().getScaledInstance(panel.getWidth()/7, panel.getWidth()/7, Image.SCALE_FAST));
//        imagen.setIcon(iconScale);
//
        cabecera.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        nombre.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        fechaI.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        fechaF.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        imp.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        desc.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        panelProducto.add(ancho);
        panelProducto.add(cabecera);
        panelProducto.add(nombre);
        panelProducto.add(fechaI);
        panelProducto.add(fechaF);
        panelProducto.add(imp);
        panelProducto.add(desc);
        

//        panelProducto.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                GUIProductoEspecifico mostrarProducto = new GUIProductoEspecifico(producto, catalogo, carrito,baseDatosUsuarios,controladorBaseUsuariosGeneracion,controladorBaseCatalogo);
//                mostrarProducto.setVisible(rootPaneCheckingEnabled);
//                dispose();
//            }
//        });
//
//        panelProducto.setBackground(Color.WHITE);
        panelProducto.setBorder(BorderFactory.createLineBorder(Color.black));

        return panelProducto;

    }
    

//    public void addRowtoJTable(){
//        String[] columnas = new String[]{
//            "Seleccionar", "Número", "Nombre", "Apellido", "Usuario", "Código", "Pregrado", "Correo", "Contraseña"
//        };
//        
//
//        
//        
//        final Class[] tiposColumnas = new Class[]{
//            JButton.class,
//            int.class,
//            java.lang.String.class,
//            java.lang.String.class,
//            java.lang.String.class,
//            java.lang.Integer.class,
//            java.lang.String.class,
//            java.lang.String.class,
//            java.lang.String.class
//        };
//        
//        
//        Estudiante es;
//         es = new Estudiante("usuario", "contraseña", 1, "nombre", "apellido", "pregrado");
//        Object[][] datos = new Object[4][9];
//        for (int i = 0; i < 4; i++) {
//            //es = (Estudiante) arrayEstudiantes[i].getValue();
//            datos[i][0] = new JButton("Eliminar");
//            datos[i][1] = i;
//            datos[i][2] = es.getNombre();
//            datos[i][3] = es.getApellido();
//            datos[i][4] = es.getUsuario();
//            datos[i][5] = es.getCodigo();
//            datos[i][6] = es.getPregrado();
//            datos[i][7] = es.getCorreo();
//            datos[i][8] = es.getContraseña();
//        }
//        
//        jTTablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
//                datos,
//                columnas) {
//            Class[] tipos = tiposColumnas;
//
//            @Override
//            public Class getColumnClass(int columnIndex) {
//                return tipos[columnIndex];
//            }
//
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return !(this.getColumnClass(column).equals(JButton.class));
//            }
//        });
//        
//        
//        
//        jTTablaUsuarios.setDefaultRenderer(JButton.class, new TableCellRenderer() {
//            @Override
//            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
//               return (Component) o;
//            }
//            
//            
//        });
//        
//    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel1.setMinimumSize(new java.awt.Dimension(590, 618));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GUIPruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIPruebas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel1;
    // End of variables declaration//GEN-END:variables
}
