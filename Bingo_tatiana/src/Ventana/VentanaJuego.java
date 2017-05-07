package Ventana;

import Clases.TipoJuego;
import GUI.DialogAcerca;
import GUI.MarcoJugador;
import GUI.panelJuego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JMenuItem;


public class VentanaJuego extends javax.swing.JFrame{
    
    
    public static ArrayList<MarcoJugador> marcoJugadores;
    public static TipoJuego tipoDeJuego;
    
    public VentanaJuego(ArrayList<MarcoJugador> Mjugadores, TipoJuego tDeJuego) {
        
        marcoJugadores = Mjugadores;
        tipoDeJuego = tDeJuego;
        
        initComponents();
        cargarMenu();
               
        jScrollContenedor.setViewportView(new panelJuego());
        
        this.setExtendedState(VentanaJuego.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
    }
    
    private void cargarMenu(){
        
        for (String tipoDeJuegosDisponible : tipoDeJuego.getTipoDeJuegosDisponibles()) {
            JMenuItem itemMenu = new JMenuItem();
            itemMenu.setText(tipoDeJuegosDisponible);
            itemMenu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    clickEcogerOtroJuego(e);
                }
            });
            jmEscogerJuego.add(itemMenu);
        }
    }
    
    private void clickEcogerOtroJuego(ActionEvent evt){
        JMenuItem item = (JMenuItem) evt.getSource();
        tipoDeJuego.setNombreDeJuego(item.getText());
        
        resetearMarcoJugadores();
        jScrollContenedor.setViewportView(new panelJuego());
    }
    
    private void resetearMarcoJugadores(){
        for (MarcoJugador marcoJugador : marcoJugadores) {
            marcoJugador.resetearMarco();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollContenedor = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuJuego = new javax.swing.JMenu();
        jMenuPausarJuego = new javax.swing.JMenuItem();
        jMnuResumenJuego = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmEscogerJuego = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollContenedor.setBorder(null);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(null);

        MenuJuego.setText("Juego");

        jMenuPausarJuego.setText("Pausar juego");
        jMenuPausarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPausarJuegoActionPerformed(evt);
            }
        });
        MenuJuego.add(jMenuPausarJuego);

        jMnuResumenJuego.setText("Resumen del juego");
        jMnuResumenJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuResumenJuegoActionPerformed(evt);
            }
        });
        MenuJuego.add(jMnuResumenJuego);
        MenuJuego.add(jSeparator2);

        jMenuItem1.setText("Jugar de nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MenuJuego.add(jMenuItem1);

        jmEscogerJuego.setText("Escojer otro  juego");
        MenuJuego.add(jmEscogerJuego);
        MenuJuego.add(jSeparator1);

        jMenuItem7.setText("Salir ");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        MenuJuego.add(jMenuItem7);

        jMenuBar1.add(MenuJuego);

        jMenu2.setText("Ayuda");

        jMenuItem2.setText("Acerca");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 1215, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuPausarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPausarJuegoActionPerformed
        // TODO add your handling code here:
        panelJuego.juegoActivo = false;
        jMenuPausarJuego.setEnabled(false);
        jMnuResumenJuego.setEnabled(true);
        panelJuego.pausarJuego();
    }//GEN-LAST:event_jMenuPausarJuegoActionPerformed

    private void jMnuResumenJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuResumenJuegoActionPerformed
        // TODO add your handling code here:
        panelJuego.juegoActivo = true;
        jMenuPausarJuego.setEnabled(true);
        jMnuResumenJuego.setEnabled(false);
        panelJuego.resumenJuego();
    }//GEN-LAST:event_jMnuResumenJuegoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        resetearMarcoJugadores();
        jScrollContenedor.setViewportView(new panelJuego());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        DialogAcerca dialogAcerca = new DialogAcerca(this, true);
        dialogAcerca.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuJuego;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuPausarJuego;
    private javax.swing.JMenuItem jMnuResumenJuego;
    public static javax.swing.JScrollPane jScrollContenedor;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu jmEscogerJuego;
    // End of variables declaration//GEN-END:variables
}
