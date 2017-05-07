package GUI;

import Clases.FuncionesExtras;
import Clases.Jugador;
import Clases.TipoJuego;
import Ventana.VentanaJuego;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class panelConfigurarJuego extends javax.swing.JPanel {

    TipoJuego tipoDeJuego;
    private final ArrayList<MarcoJugador> jugadores;
    
    public panelConfigurarJuego() {
        initComponents();
        numero_jugadorestxt.requestFocus();
        
        tipoDeJuego = new TipoJuego();
        jugadores = new ArrayList<>();
        
        selectTipoDeJuego.add("- Seleccione el tipo de juego -");
        for (String tipoDeJuegosDisponible : tipoDeJuego.getTipoDeJuegosDisponibles()) {
            selectTipoDeJuego.add(tipoDeJuegosDisponible);
        }
    }
    
    //Funcion que valida si el formulario se diligencio correctamente
    public boolean validarFormulario(){
        
        if(numero_jugadorestxt.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese el número de jugadores", "Error", JOptionPane.ERROR_MESSAGE);
            numero_jugadorestxt.setBorder(new LineBorder(Color.red));
            numero_jugadorestxt.requestFocus();
            
            return false;
        }else{
            numero_jugadorestxt.setBorder(new LineBorder(null));
        }
        
        if(!FuncionesExtras.validarNumero(numero_jugadorestxt.getText())){
            JOptionPane.showMessageDialog(null, "Este campo debe ser numerico", "Error", JOptionPane.ERROR_MESSAGE);
            numero_jugadorestxt.setBorder(new LineBorder(Color.red));
            numero_jugadorestxt.requestFocus();
            
            return false;
        }else{
            numero_jugadorestxt.setBorder(new LineBorder(null));
        }
        
        if(selectTipoDeJuego.getSelectedIndex() == 0){
             JOptionPane.showMessageDialog(null, "Seleccione el tipo de juego", "Error", JOptionPane.ERROR_MESSAGE);
            selectTipoDeJuego.requestFocus();
            
            return false;
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        numero_jugadorestxt = new javax.swing.JTextField();
        selectTipoDeJuego = new java.awt.Choice();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Número de jugadores");

        numero_jugadorestxt.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        numero_jugadorestxt.setMargin(new java.awt.Insets(2, 8, 2, 2));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tipo de juego");

        jButton1.setBackground(new java.awt.Color(114, 114, 228));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Continuar");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(93, 93, 223), 1, true));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(155, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(selectTipoDeJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(numero_jugadorestxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(135, 135, 135))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(193, 193, 193)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(154, 154, 154))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numero_jugadorestxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(selectTipoDeJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if(validarFormulario()){
            for (int i = 0; i < Integer.parseInt(numero_jugadorestxt.getText()); i++) {
                String nombreJugador = JOptionPane.showInputDialog("Ingrese el nombre del juagdor "+(i+1));
                
                if(!nombreJugador.equals("")){
                    Jugador jugador = new Jugador(nombreJugador);
                    jugador.setNumero_de_tablas(1);

                    jugadores.add(new MarcoJugador(jugador));
                }else{
                    i--;
                }
            }
            tipoDeJuego.setNombreDeJuego(selectTipoDeJuego.getSelectedItem());
            
            VentanaJuego vj = new VentanaJuego(jugadores, tipoDeJuego);
            vj.setVisible(true);
            
           ((JFrame) (this.getParent()).getParent().getParent().getParent().getParent().getParent()).dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField numero_jugadorestxt;
    private java.awt.Choice selectTipoDeJuego;
    // End of variables declaration//GEN-END:variables
}
