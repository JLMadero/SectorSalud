/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import fachada.Fachada;
import fachada.IFachada;
import fachada.MensajeRecibidoDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Profesional;
import solicitudes.ApiClient;

/**
 *
 * @author jl4ma
 */
public class FrmAgregarRadiografia extends javax.swing.JFrame {

    ExpedienteBean expediente;
    IFachada fachada;
    Profesional profesionalSesion;
    String nombre;
    String idPaciente;
    private List<MensajeRecibidoDTO> mensajes;

    /**
     * Creates new form FrmAgregarAlergias
     */
    public FrmAgregarRadiografia(ExpedienteBean expediente, Profesional pro, List<MensajeRecibidoDTO> mensajes, String nombre, String idPaciente) {
        initComponents();
        this.expediente = expediente;
        this.fachada = new Fachada();
        this.profesionalSesion = pro;
        this.mensajes = mensajes;
        this.nombre = nombre;
        this.idPaciente = idPaciente;
    }

    public File seleccionarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona una imagen");

        // Agrega el filtro de imágenes
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Imágenes", "jpg", "jpeg", "png", "gif", "bmp"
        );
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        } else {
            return null;
        }
    }
    
    public String convertirArchivoAString(File archivo) throws IOException {
    FileInputStream fis = new FileInputStream(archivo);
    byte[] bytes = fis.readAllBytes();
    fis.close();

    // Convierte a Base64 para que sea representable como texto
    return Base64.getEncoder().encodeToString(bytes);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Radiografia");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Subir Radiografia:");

        jButton1.setText("Subir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jButton2)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FrmVerExpediente frmVerExpediente = new FrmVerExpediente(expediente, nombre, idPaciente, profesionalSesion, mensajes);
        frmVerExpediente.setLocationRelativeTo(null);
        frmVerExpediente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        File foto = seleccionarArchivo();
        try {
            ApiClient api = new ApiClient();
            String radiografia = this.convertirArchivoAString(foto);
            if(!radiografia.isBlank()){
                boolean respuesta = api.agregarContenidoAExpediente(idPaciente, "radiografias", radiografia);
            if (respuesta) {
                JOptionPane.showMessageDialog(this,
                        "Radiografia agregada con exito",
                        "Volviendo al expediente...",
                        JOptionPane.INFORMATION_MESSAGE);
                expediente.getRadiografias().add(radiografia);
                FrmVerExpediente frmVerExpediente = new FrmVerExpediente(expediente, nombre, idPaciente, profesionalSesion, mensajes);
                frmVerExpediente.setLocationRelativeTo(null);
                frmVerExpediente.setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this,
                        "Algo salio mal",
                        "Intentelo de nuevo",
                        JOptionPane.WARNING_MESSAGE);
            }
            }else{
                JOptionPane.showMessageDialog(this,
                        "Algo salio mal",
                        "Intentelo de nuevo",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (IOException ex) {
            Logger.getLogger(FrmAgregarRadiografia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
