package presentacion;

/**
 *
 * Clase que extiende de Java swing dialog para representar graficamente un dialogo sobre la autentificacion biometrica
 * 
 * @author Alejandro Gómez Vega 247313
 * @author Jesus Francisco Tapia Maldonado 245136
 * @author Jose Luis Madero Lopez 244903
 * @author Adriana Guitiérrez Robles 235633
 * @author Diego Alcantar Acosta 247122
 */
public class DlgAutenticacionBiometrica extends javax.swing.JDialog {

    public DlgAutenticacionBiometrica(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
