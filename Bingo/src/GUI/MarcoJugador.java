package GUI;

import Clases.Jugador;


public class MarcoJugador extends javax.swing.JPanel {
    
    Jugador jugador;
    
    public MarcoJugador(Jugador j) {
        
        initComponents();
        jugador = j;
        
        jLabelJugador.setText(jugador.getUsuario());
        jLabelPuntos.setText(String.valueOf(jugador.getPuntos()));
        
        cargarTablas();
    }
    
    //Funcion que cargas las tablas 
    private void cargarTablas(){
        for (int i = 0; i < jugador.getTablas().size(); i++) {
            panelContenedorTabla.add(jugador.getTablas().get(i));
        }
    }
    
    public void actualizarPuntos(){
        jLabelPuntos.setText(String.valueOf(getJugador().getPuntos()));
    }
    
    public Jugador getJugador() {
        return jugador;
    }
    
    //Funcion setea los valores por default del jugador (incluyendos sus tablas)
    public void resetearMarco(){
        this.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 225, 225), 1, true));
        
        Jugador j = getJugador();
        for (Tabla tabla: j.getTablas()) {
            tabla.resetarTabla();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelJugador = new javax.swing.JLabel();
        jLabelPuntos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelContenedorTabla = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 225, 225), 1, true));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nombre :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Puntos  :");

        jLabelJugador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelJugador.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelJugador.setText("jLabel3");

        jLabelPuntos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPuntos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPuntos.setText("20");

        jScrollPane1.setBorder(null);

        panelContenedorTabla.setBackground(new java.awt.Color(255, 255, 255));
        panelContenedorTabla.setLayout(new java.awt.GridLayout(1, 2, 2, 2));
        jScrollPane1.setViewportView(panelContenedorTabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPuntos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelJugador, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabelJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelPuntos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelJugador;
    private javax.swing.JLabel jLabelPuntos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelContenedorTabla;
    // End of variables declaration//GEN-END:variables
}
