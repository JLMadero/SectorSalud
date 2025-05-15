package presentacion;

import javax.swing.table.DefaultTableModel;
import model.Profesional;
import org.json.JSONArray;
import org.json.JSONObject;
import solicitudes.ApiClient;

/**
 *
 * Clase que extiende de Java swing para representar graficamente los expedientes de pacientes
 * 
 * @author Alejandro Gómez Vega 247313
 * @author Jesus Francisco Tapia Maldonado 245136
 * @author Jose Luis Madero Lopez 244903
 * @author Adriana Guitiérrez Robles 235633
 * @author Diego Alcantar Acosta 247122
 */
public class FrmExpedientes extends javax.swing.JFrame {

    Profesional profesionalSesion;
    ApiClient apiClient;

    public FrmExpedientes(Profesional profesionalSesion) {
        initComponents();
        this.profesionalSesion = profesionalSesion;
        lblNombreDoctor.setText("Dr. " + profesionalSesion.getNombre());
        lblCedulaDoctor.setText("Cédula: " + profesionalSesion.getCedula());
        apiClient = new ApiClient();
        llenarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblNombreDoctor = new javax.swing.JLabel();
        lblCedulaDoctor = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();
        btnAgendaCitas = new javax.swing.JButton();
        btnExpedientes = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        btnNotificaciones = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        panelRound1 = new presentacion.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtBuscarExpediente = new presentacion.CampoTextoR(20, "Buscar por nombre o ID...");
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaExpedientes = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Secretaría de Salud - Expedientes");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(157, 36, 73));

        lblNombreDoctor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombreDoctor.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreDoctor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreDoctor.setText("Dr. Juan Pérez");

        lblCedulaDoctor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCedulaDoctor.setForeground(new java.awt.Color(255, 255, 255));
        lblCedulaDoctor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedulaDoctor.setText("Cédula: 12345678");

        btnInicio.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnInicio.setText("Inicio");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnAgendaCitas.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAgendaCitas.setText("Agenda de Citas");
        btnAgendaCitas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgendaCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendaCitasActionPerformed(evt);
            }
        });

        btnExpedientes.setBackground(new java.awt.Color(157, 36, 73));
        btnExpedientes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnExpedientes.setForeground(new java.awt.Color(255, 255, 255));
        btnExpedientes.setText("Expedientes");
        btnExpedientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnNotificaciones.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnNotificaciones.setText("Notificaciones");
        btnNotificaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNotificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotificacionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNombreDoctor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblCedulaDoctor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgendaCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExpedientes, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNotificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblNombreDoctor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCedulaDoctor)
                .addGap(32, 32, 32)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgendaCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExpedientes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNotificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 550));

        jPanel2.setBackground(new java.awt.Color(241, 241, 241));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(10);
        panelRound1.setRoundBottomRight(10);
        panelRound1.setRoundTopLeft(10);
        panelRound1.setRoundTopRight(10);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Expedientes Clínicos");

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        txtBuscarExpediente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton1.setBackground(new java.awt.Color(241, 241, 241));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tablaExpedientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablaExpedientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaExpedientes);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscarExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 650, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgendaCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendaCitasActionPerformed
        FrmAgendaCitas frmAgendaCitas = new FrmAgendaCitas(profesionalSesion);
        frmAgendaCitas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgendaCitasActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        FrmPrincipal frmPrincipal = new FrmPrincipal(profesionalSesion);
        frmPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnNotificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotificacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNotificacionesActionPerformed

    private void llenarTabla() {
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Paciente ID", "Alergias", "Notas adicionales"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        try {
            String jsonResponse = apiClient.getExpedientes();
            JSONArray expedientesArray = new JSONArray(jsonResponse);

            for (int i = 0; i < expedientesArray.length(); i++) {
                JSONObject expediente = expedientesArray.getJSONObject(i);

                String id = expediente.getString("id");
                String pacienteId = expediente.getString("pacienteId");

                JSONArray alergiasArray = expediente.getJSONArray("alergias");
                StringBuilder alergiasStr = new StringBuilder();
                for (int j = 0; j < alergiasArray.length(); j++) {
                    alergiasStr.append(alergiasArray.getString(j));
                    if (j < alergiasArray.length() - 1) {
                        alergiasStr.append(", ");
                    }
                }

                String notas = expediente.optString("notasAdicionales", "");

                modelo.addRow(new Object[]{id, pacienteId, alergiasStr.toString(), notas});
            }

        } catch (Exception e) {
            System.err.println("Error al cargar expedientes: " + e.getMessage());
        }

        tablaExpedientes.setModel(modelo);
        tablaExpedientes.setRowHeight(30);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendaCitas;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnExpedientes;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnNotificaciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCedulaDoctor;
    private javax.swing.JLabel lblNombreDoctor;
    private presentacion.PanelRound panelRound1;
    private javax.swing.JTable tablaExpedientes;
    private javax.swing.JTextField txtBuscarExpediente;
    // End of variables declaration//GEN-END:variables
}
