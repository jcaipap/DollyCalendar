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
import estructuas.PriorityQueue;
import static gui.Calendario.frmMain;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import logica.Metodos;

/**
 *
 * @author andre
 */
public class GUIBuscador extends javax.swing.JFrame {

    /**
     * Creates new form GUIBuscador
     */
    HashGeneric<String, Persona> usuarios;
    HashGeneric<String, Persona> administradores;
    HashGeneric<Integer, Materia> materias;
    AdminDataBaseHandler adminbase;
    MateriasDataBaseHandler materiasbase;
    UsuariosDataBaseHandler userbase;
    static JLabel lblMonth, lblYear;
    static JButton btnPrev, btnNext;
    static JTable tblCalendar;
    static JComboBox cmbYear;
    static DefaultTableModel mtblCalendar; //Table model
    static JScrollPane stblCalendar; //The scrollpane
    static JPanel pnlCalendar;
    static JLabel fechaSelec;
    static int realYear, realMonth, realDay, currentYear, currentMonth;
    static GregorianCalendar fecha2;
    static GregorianCalendar fechaActual;
    static int filtro = 1;
    Casilla casillas[];
    Estudiante estudiante;
    PriorityQueue<Casilla> f;

    public GUIBuscador(HashGeneric<String, Persona> usuarios, HashGeneric<String, Persona> administradores, HashGeneric<Integer, Materia> materias, AdminDataBaseHandler adminbase, MateriasDataBaseHandler materiasbase, UsuariosDataBaseHandler userbase, Estudiante estudiante) {
        this.usuarios = usuarios;
        this.administradores = administradores;
        this.materias = materias;
        this.adminbase = adminbase;
        this.materiasbase = materiasbase;
        this.userbase = userbase;
        this.estudiante = estudiante;
        this.f = estudiante.getCasillas();
        fecha2 = new GregorianCalendar();
        fechaActual = new GregorianCalendar();
        this.casillas = Metodos.imprimirOrden(estudiante.getCasillas());
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
        JPCalendar.add(crearCalendario(JPCalendar));
        String stringFechaActual;
        stringFechaActual = String.format("%tD\n", this.fechaActual);
        String horaActual;
        horaActual = String.format("%tr\n", this.fechaActual);

        jLFecha.setText(stringFechaActual);

        jLFecha1.setText(horaActual + " " + stringFechaActual);
        Graphics graphic = VolverAInicio.getGraphics();
        graphic.setColor(new Color(20, 34, 255));
        VolverAInicio.paint(graphic);
        jLabel3.setText("Bienvenido " + estudiante.getUsuario() + ", aquí puede ver todas sus clases y actividades programadas");
        crearCatalogo(casillas, filtro);
        panelAct.validate();
        panelAct.repaint();

    }

    public GUIBuscador() {
    }

    private void crearCatalogo(Casilla[] casillas, int k) {

        panelAct.removeAll();
        panelAct.setLayout(new BoxLayout(panelAct, BoxLayout.Y_AXIS));

        switch (k) {

            case 1:

                for (int i = 0; i < casillas.length; i++) {

                    if (fecha2.get(Calendar.DAY_OF_YEAR) == casillas[i].getFechaInicio().get(Calendar.DAY_OF_YEAR)) {

                        panelAct.add(crearProducto(casillas[i], panelAct));
                    }
                }

                break;

            case 2:

                for (int i = 0; i < casillas.length; i++) {

                    if (fecha2.get(Calendar.WEEK_OF_YEAR) == casillas[i].getFechaInicio().get(Calendar.WEEK_OF_YEAR)) {

                        panelAct.add(crearProducto(casillas[i], panelAct));
                    }
                }

                break;

            case 3:

                for (int i = 0; i < casillas.length; i++) {

                    if (fecha2.get(Calendar.DAY_OF_YEAR) <= casillas[i].getFechaInicio().get(Calendar.DAY_OF_YEAR)) {

                        panelAct.add(crearProducto(casillas[i], panelAct));
                    }
                }

                break;

            default:
                break;

        }

        panelAct.validate();
        panelAct.repaint();
        jScrollPane2.repaint();
        jScrollPane2.validate();
    }

    public final JPanel crearProducto(Casilla casilla, JPanel panel) {

        JPanel panelProducto = new JPanel();
        Dimension dimensioProducto = new Dimension(panel.getWidth(), panel.getWidth() / 5);
        Dimension dimensioAncho = new Dimension(panel.getWidth(), 1);
        panelProducto.setLayout(new BoxLayout(panelProducto, BoxLayout.Y_AXIS));
        panelProducto.setSize(dimensioProducto);
        panelProducto.setMinimumSize(dimensioProducto);
        panelProducto.setMaximumSize(new Dimension(panel.getWidth() + 20, panel.getWidth() / 5));
        panelProducto.setForeground(Color.black);
        JLabel cabecera = new JLabel(" ");
        JPanel ancho = new JPanel();
        ancho.setSize(dimensioAncho);
        ancho.setMaximumSize(new Dimension(panel.getWidth(), 10));

        JLabel nombre = new JLabel(casilla.getTitulo());
        JLabel fechaI = new JLabel("Fecha inicio: " + Metodos.impresionFecha(casilla.getFechaInicio()));
        JLabel fechaF = new JLabel("Fecha final: " + Metodos.impresionFecha(casilla.getFechaFinalizacion()));
        JLabel imp = new JLabel("Importancia: " + casilla.getImportancia());
        JLabel desc = new JLabel("Descripción: " + casilla.getDescripcion());
        JLabel esp = new JLabel(" ");

        nombre.setFont(new Font(nombre.getFont().getName(), BOLD, 20));
        fechaI.setFont(new Font(nombre.getFont().getName(), BOLD, 15));
        fechaF.setFont(new Font(nombre.getFont().getName(), BOLD, 15));
        imp.setFont(new Font(nombre.getFont().getName(), BOLD, 12));
        desc.setFont(new Font(nombre.getFont().getName(), BOLD, 12));
        ancho.setBackground(Color.white);

        panelProducto.add(ancho);
        cabecera.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        nombre.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        fechaI.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        fechaF.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        imp.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        desc.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        esp.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        panelProducto.add(nombre);
        panelProducto.add(fechaI);
        panelProducto.add(fechaF);
        panelProducto.add(esp);
        panelProducto.add(imp);
        panelProducto.add(esp);
        panelProducto.add(desc);

        panelProducto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (casilla instanceof Actividad) {

                    GUIVerActividad mostrarProducto = new GUIVerActividad(casilla, usuarios, administradores, materias, adminbase, materiasbase, userbase, estudiante);
                    mostrarProducto.setVisible(rootPaneCheckingEnabled);
                    dispose();
                }

            }
        });
//
//        panelProducto.setBackground(Color.WHITE);
        panelProducto.setBorder(BorderFactory.createLineBorder(Color.black));
        panelProducto.setBackground(Color.white);

        return panelProducto;

    }

    public static void cambiarFechaActual() {
        fechaSelec.setText(String.valueOf(fecha2.getTime()));
    }

    public static JPanel crearCalendario(JPanel sup) {
//        Look and feel
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (ClassNotFoundException e) {
//        } catch (InstantiationException e) {
//        } catch (IllegalAccessException e) {
//        } catch (UnsupportedLookAndFeelException e) {
//        }

        lblMonth = new JLabel("January");
        lblYear = new JLabel("Cambiar año:");
        cmbYear = new JComboBox();
        btnPrev = new JButton("<<");
        btnNext = new JButton(">>");
        mtblCalendar = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        tblCalendar = new JTable(mtblCalendar);
        stblCalendar = new JScrollPane(tblCalendar);
        pnlCalendar = new JPanel(null);
        pnlCalendar.setSize(sup.getSize());
        pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendario"));

        //Register action listeners
        btnPrev.addActionListener(new btnPrev_Action());
        btnNext.addActionListener(new btnNext_Action());
        cmbYear.addActionListener(new cmbYear_Action());

        //Add controls to pane
        pnlCalendar.add(lblMonth);
        pnlCalendar.add(lblYear);
        pnlCalendar.add(cmbYear);
        pnlCalendar.add(btnPrev);
        pnlCalendar.add(btnNext);
        pnlCalendar.add(stblCalendar);

        //Set bounds
        pnlCalendar.setBounds(0, 0, 320, 335);
        lblMonth.setBounds(160 - lblMonth.getPreferredSize().width / 2, 25, 100, 25);
        lblYear.setBounds(10, 305, 80, 20);
        cmbYear.setBounds(230, 305, 80, 20);
        btnPrev.setBounds(10, 25, 50, 25);
        btnNext.setBounds(260, 25, 50, 25);
        stblCalendar.setBounds(10, 50, 300, 250);

        //Make frame visible
//		frmMain.setResizable(false);
//		frmMain.setVisible(true);
        //Get real month/year
        GregorianCalendar cal = new GregorianCalendar(); //Create calendar
        realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
        realMonth = cal.get(GregorianCalendar.MONTH); //Get month
        realYear = cal.get(GregorianCalendar.YEAR); //Get year
        currentMonth = realMonth; //Match month and year
        currentYear = realYear;

        //Add headers
        String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
        for (int i = 0; i < 7; i++) {
            mtblCalendar.addColumn(headers[i]);
        }

        tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background

        //No resize/reorder
        tblCalendar.getTableHeader().setResizingAllowed(false);
        tblCalendar.getTableHeader().setReorderingAllowed(false);

        //Single cell selection
        tblCalendar.setColumnSelectionAllowed(true);
        tblCalendar.setRowSelectionAllowed(true);
        tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Set row/column count
        tblCalendar.setRowHeight(38);
        mtblCalendar.setColumnCount(7);
        mtblCalendar.setRowCount(6);

        //Populate table
        for (int i = realYear - 50; i <= realYear + 50; i++) {
            cmbYear.addItem(String.valueOf(i));
        }

        //Refresh calendar
        refreshCalendar(realMonth, realYear); //Refresh calendar
        pnlCalendar.setBackground(Color.WHITE);
        return pnlCalendar;
    }

    public static void refreshCalendar(int month, int year) {
        //Variables

        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int nod, som; //Number Of Days, Start Of Month

        //Allow/disallow buttons
        btnPrev.setEnabled(true);
        btnNext.setEnabled(true);
        if (month == 0 && year <= realYear - 10) {
            btnPrev.setEnabled(false);
        } //Too early
        if (month == 11 && year >= realYear + 100) {
            btnNext.setEnabled(false);
        } //Too late
        lblMonth.setText(months[month]); //Refresh the month label (at the top)
        lblMonth.setBounds(160 - lblMonth.getPreferredSize().width / 2, 25, 180, 25); //Re-align label with calendar
        cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box

        //Clear table
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                mtblCalendar.setValueAt(null, i, j);
            }
        }

        //Get first day of month and number of days
        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        som = cal.get(GregorianCalendar.DAY_OF_WEEK);

        //Draw calendar
        for (int i = 1; i <= nod; i++) {
            int row = new Integer((i + som - 2) / 7);
            int column = (i + som - 2) % 7;
            mtblCalendar.setValueAt(i, row, column);

        }

        //Apply renderers
        tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());

    }

    static class tblCalendarRenderer extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            if (column == 0 || column == 6) { //Week-end
                setBackground(new Color(255, 220, 220));
                setForeground(new Color(0, 0, 0));

            } else { //Week
                setBackground(new Color(255, 255, 255));
                setForeground(new Color(0, 0, 0));

            }
            if (value != null) {
                if (Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear) { //Today
                    setBackground(new Color(20, 34, 255));
                    setForeground(new Color(255, 255, 255));
                    fecha2.set(currentYear, currentMonth, Integer.parseInt(value.toString()));
                }
            }
            if (selected == true) {
                setBackground(new Color(60, 163, 255));
                setForeground(new Color(255, 255, 255));
                table.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (value != null) {
                            fecha2.set(currentYear, currentMonth, Integer.parseInt(value.toString()));
                        }

                    }
                });
            }
            setBorder(null);
            return this;
        }

    }

    static class btnPrev_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (currentMonth == 0) { //Back one year
                currentMonth = 11;
                currentYear -= 1;
            } else { //Back one month
                currentMonth -= 1;
            }
            refreshCalendar(currentMonth, currentYear);
        }
    }

    static class btnNext_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (currentMonth == 11) { //Foward one year
                currentMonth = 0;
                currentYear += 1;
            } else { //Foward one month
                currentMonth += 1;
            }
            refreshCalendar(currentMonth, currentYear);
        }
    }

    static class cmbYear_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (cmbYear.getSelectedItem() != null) {
                String b = cmbYear.getSelectedItem().toString();
                currentYear = Integer.parseInt(b);
                refreshCalendar(currentMonth, currentYear);
            }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        VolverAInicio = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLFecha = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLFecha1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        verHorario = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        JPCalendar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelAct = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel2.setFont(new java.awt.Font("Rockwell", 2, 60)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("UNcalendar");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(VolverAInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150)
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addGap(99, 99, 99)
                .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VolverAInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLFecha.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jLFecha.setText("Fecha");
        jLFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLFechaMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jLabel1.setText("Fecha seleccionada:");

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Dia");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jRadioButton2.setText("Semana");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jRadioButton3.setText("Completo");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jLabel4.setText("Filtrar por:");

        jLFecha1.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jLFecha1.setText("Fecha");
        jLFecha1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLFecha1MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jLabel5.setText("Fecha actual:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 208, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(jLFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton3)
                .addGap(32, 32, 32)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setBackground(new java.awt.Color(20, 34, 255));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Nueva actividad");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(20, 34, 255));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        verHorario.setBackground(new java.awt.Color(20, 34, 255));
        verHorario.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        verHorario.setForeground(new java.awt.Color(255, 255, 255));
        verHorario.setText("Ver horario");
        verHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verHorarioActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(verHorario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(verHorario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        JPCalendar.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout JPCalendarLayout = new javax.swing.GroupLayout(JPCalendar);
        JPCalendar.setLayout(JPCalendarLayout);
        JPCalendarLayout.setHorizontalGroup(
            JPCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        JPCalendarLayout.setVerticalGroup(
            JPCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        panelAct.setBackground(new java.awt.Color(255, 255, 255));
        panelAct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelAct.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelActLayout = new javax.swing.GroupLayout(panelAct);
        panelAct.setLayout(panelActLayout);
        panelActLayout.setHorizontalGroup(
            panelActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 787, Short.MAX_VALUE)
        );
        panelActLayout.setVerticalGroup(
            panelActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(panelAct);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JPCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JPCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverAInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverAInicioActionPerformed
        // TODO add your handling code here:

        JPCalendar.invalidate();
        this.f = this.estudiante.getCasillas();
        GUIInicio inicio = new GUIInicio(usuarios, administradores, materias, adminbase, materiasbase, userbase, estudiante);
        inicio.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_VolverAInicioActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(panelTitulo, "Esta seguro que desea salir?",
                "confirmacion", JOptionPane.YES_NO_OPTION);
        if (respuesta == 0) {
            try {
                userbase.ModificarDBC(estudiante);
                userbase.InsertarDBC(estudiante);
                System.exit(0);
            } catch (IOException ex) {
                Logger.getLogger(GUIBuscador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_salirActionPerformed

    private void jLFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLFechaMouseClicked
        // TODO add your handling code here:
        jLFecha.setText(String.valueOf(fecha2.getTime()));
    }//GEN-LAST:event_jLFechaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String selecF;
        selecF = String.format("%tD\n", fecha2);
        jLFecha.setText(selecF);

        fechaActual = new GregorianCalendar();
        String stringFechaActual;
        stringFechaActual = String.format("%tD\n", fechaActual);
        String horaActual;
        horaActual = String.format("%tr\n", fechaActual);

        jLFecha1.setText(horaActual + " " + stringFechaActual);

        crearCatalogo(casillas, filtro);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        GUICrearActividad nuevaAct = new GUICrearActividad(usuarios, administradores, materias, adminbase, materiasbase, userbase, estudiante);
        nuevaAct.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void verHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verHorarioActionPerformed
        // TODO add your handling code here:

        GUIVerHorario verHor = new GUIVerHorario(usuarios, administradores, materias, adminbase, materiasbase, userbase, estudiante);
        verHor.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_verHorarioActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        filtro = 1;
        crearCatalogo(casillas, filtro);
        panelAct.validate();
        panelAct.repaint();

        fechaActual = new GregorianCalendar();
        String stringFechaActual;
        stringFechaActual = String.format("%tD\n", fechaActual);
        String horaActual;
        horaActual = String.format("%tr\n", fechaActual);

        jLFecha1.setText(horaActual + " " + stringFechaActual);


    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        filtro = 2;
        crearCatalogo(casillas, filtro);
        panelAct.validate();
        panelAct.repaint();

        fechaActual = new GregorianCalendar();
        String stringFechaActual;
        stringFechaActual = String.format("%tD\n", fechaActual);
        String horaActual;
        horaActual = String.format("%tr\n", fechaActual);

        jLFecha1.setText(horaActual + " " + stringFechaActual);


    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        filtro = 3;
        crearCatalogo(casillas, filtro);

        panelAct.validate();
        panelAct.repaint();

        fechaActual = new GregorianCalendar();
        String stringFechaActual;
        stringFechaActual = String.format("%tD\n", fechaActual);
        String horaActual;
        horaActual = String.format("%tr\n", fechaActual);

        jLFecha1.setText(horaActual + " " + stringFechaActual);

    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jLFecha1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLFecha1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLFecha1MouseClicked

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
            java.util.logging.Logger.getLogger(GUIBuscador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIBuscador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIBuscador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIBuscador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIBuscador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPCalendar;
    private javax.swing.JButton VolverAInicio;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLFecha;
    private javax.swing.JLabel jLFecha1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JPanel panelAct;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JButton salir;
    private javax.swing.JButton verHorario;
    // End of variables declaration//GEN-END:variables
}
