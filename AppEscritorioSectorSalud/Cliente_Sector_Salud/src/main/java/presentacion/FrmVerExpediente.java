package presentacion;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class FrmVerExpediente extends JFrame {
    private String expedienteJson;
    private String nombrePaciente;
    
    private JTabbedPane tabbedPane;
    private JPanel panelInfoGeneral;
    private JPanel panelDiagnosticos;
    private JPanel panelVacunas;
    private JPanel panelRadiografias;
    private JPanel panelAlergias;
    
    public FrmVerExpediente(String expedienteJson, String nombrePaciente) {
        this.expedienteJson = expedienteJson;
        this.nombrePaciente = nombrePaciente;
        
        initComponents();
        cargarDatosExpediente();
        
        setTitle("Expediente Médico - " + nombrePaciente);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    
    private void cargarDatosExpediente() {
        try {
            System.out.println("Contenido de expedienteJson:\n" + expedienteJson);
            JSONObject jsonExpediente = new JSONObject(expedienteJson);
            
            // Cargar información general
            agregarCampoInfoGeneral("ID Paciente", jsonExpediente.optString("pacienteId", "N/A"));
            agregarCampoInfoGeneral("Nombre", jsonExpediente.optString("nombre", "N/A"));
            agregarCampoInfoGeneral("Diagnóstico General", jsonExpediente.optString("diagnostico", "N/A"));
            
            // Si hay más información en el expediente, puedes agregarla aquí
            
            // Nota: Como no conocemos la estructura exacta del JSON que devuelve la API,
            // estamos usando los campos que vimos en la clase Expediente (pacienteId, nombre, diagnostico)
            // Las demás pestañas se quedarán con el mensaje "No hay datos disponibles" hasta que
            // tengamos la estructura exacta del JSON
            agregarMensajeSinDatos(panelDiagnosticos);
            agregarMensajeSinDatos(panelVacunas);
            agregarMensajeSinDatos(panelRadiografias);
            agregarMensajeSinDatos(panelAlergias);
            
        } catch (JSONException e) {
            JOptionPane.showMessageDialog(this, 
                    "Error al procesar el expediente: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void cargarSeccion(JSONObject jsonExpediente, String seccion, JPanel panel) {
        JSONArray items = jsonExpediente.optJSONArray(seccion);
        if (items != null && items.length() > 0) {
            for (int i = 0; i < items.length(); i++) {
                JSONObject item = items.optJSONObject(i);
                if (item != null) {
                    JPanel panelItem = crearPanelItem(item);
                    panel.add(panelItem);
                    panel.add(Box.createVerticalStrut(10));
                }
            }
        } else {
            agregarMensajeSinDatos(panel);
        }
    }
    
    private JPanel crearPanelItem(JSONObject item) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
        
        // Fecha
        String fecha = item.optString("fecha", "Fecha no especificada");
        JLabel lblFecha = new JLabel("Fecha: " + fecha);
        lblFecha.setFont(new Font("Arial", Font.BOLD, 12));
        
        // Descripción
        String descripcion = item.optString("descripcion", "");
        JTextArea txtDescripcion = new JTextArea(descripcion);
        txtDescripcion.setEditable(false);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setBackground(panel.getBackground());
        JScrollPane scrollDescripcion = new JScrollPane(txtDescripcion);
        scrollDescripcion.setBorder(BorderFactory.createEmptyBorder());
        
        // Médico
        String medico = item.optString("medico", "No especificado");
        JLabel lblMedico = new JLabel("Médico: " + medico);
        
        panel.add(lblFecha);
        panel.add(Box.createVerticalStrut(5));
        panel.add(scrollDescripcion);
        panel.add(Box.createVerticalStrut(5));
        panel.add(lblMedico);
        
        return panel;
    }
    
    private void agregarCampoInfoGeneral(String etiqueta, String valor) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        JLabel lblEtiqueta = new JLabel(etiqueta + ": ");
        lblEtiqueta.setFont(new Font("Arial", Font.BOLD, 12));
        
        JLabel lblValor = new JLabel(valor);
        
        panel.add(lblEtiqueta);
        panel.add(Box.createHorizontalStrut(10));
        panel.add(lblValor);
        panel.add(Box.createHorizontalGlue());
        
        panelInfoGeneral.add(panel);
    }
    
    private void agregarMensajeSinDatos(JPanel panel) {
        JLabel lblNoData = new JLabel("No hay datos disponibles");
        lblNoData.setForeground(Color.GRAY);
        lblNoData.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel.add(Box.createVerticalGlue());
        panel.add(lblNoData);
        panel.add(Box.createVerticalGlue());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
