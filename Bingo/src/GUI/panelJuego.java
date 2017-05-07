package GUI;

import Clases.Ficha;
import Clases.FuncionesExtras;
import Clases.Jugador;
import Ventana.VentanaJuego;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class panelJuego extends javax.swing.JPanel implements Runnable{

    ArrayList<Ficha> fichasJugadas;

    Tabla tablaCompleta;
    
    public static Thread hilo;
            
    private boolean ganador;
    public static boolean juegoActivo;
    
    public panelJuego() {
        
        ganador = false;
        juegoActivo = true;
        
        
        tablaCompleta = new Tabla(15);
        fichasJugadas = new ArrayList<>();
        
        initComponents();
        cargarJuego();
        
        hilo = new Thread(this);
        hilo.start();
    }
    
    //Funcion que añade elementos dinamicamente a la interfaz
    private void cargarJuego(){
        
        contenedorTablaCompleta.setViewportView(tablaCompleta);
        tipoDeJuegoImg.setIcon(VentanaJuego.tipoDeJuego.getImagenTipoDeJuego());
        tipoDeJuegoName.setText(VentanaJuego.tipoDeJuego.getNombreDeJuego());
        
        for (int i = 0; i < VentanaJuego.marcoJugadores.size(); i++) {
            contenedorTablas.add(VentanaJuego.marcoJugadores.get(i));
        }
        
        cargarTabla();
    }
    
    //Funcion que carga las tablas de los jugadores
    private void cargarTabla(){
        
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tabla.setModel(modeloTabla);
        
        modeloTabla.addColumn("Jugador");
        modeloTabla.addColumn("Puntos");
        
        String jugador[] = new String[2];
        
        for (int i = 0; i < VentanaJuego.marcoJugadores.size(); i++) {
            
           jugador[0] = VentanaJuego.marcoJugadores.get(i).getJugador().getUsuario();
           jugador[1] = String.valueOf(VentanaJuego.marcoJugadores.get(i).getJugador().getPuntos())
                   ;
            modeloTabla.addRow(jugador);
        }
    }
    
    @Override
    public void run(){
        
        //Generamos las 75 balotas
        for (int i = 0; i < 75; i++) {
            
            Ficha ficha = new Ficha(FuncionesExtras.crearNumeroAleatorio(75));
            
            //Si hay un ganador paramos el cliclo
            if(ganador) break;
            
            //Si la ficha jugada esta repetida no podemos generar otra hasta que sea diferente del resto
            if(salioEsteNumero(ficha)){
                i--;
            }else{
                
                //Preguntamos si la ficha tiene un dicho especial y lo tiene lo mostramos
                if(ficha.tieneDicho()){
                    JLabelDichos.setText(ficha.getDicho());
                    JLabelDichos.setForeground(ficha.getColor());
                }else{
                    JLabelDichos.setText("");
                }
                
                //Actualizamos el panel donde se muestran las ficha juagdas
                mostarFichaJugada(ficha);
                //Actualizamos y marcamos la tabla completa del bingo
                marcarTablaCompleta(ficha);
                //Actualizamos y marcamos las tablas de los juagdores
                marcarTablaJugador(ficha);
                
                //Añadimos la ficha jugada al arryList
                fichasJugadas.add(ficha);
                //Generamos una pausa
                FuncionesExtras.pausar(2000);
            }
        }
    }
    
    private void mostarFichaJugada(Ficha ficha){
       
        labelFicha.setForeground(ficha.getColor());
        labelFicha.setText(String.valueOf(ficha.getNumero()));
        labelFicha.setIcon(ficha.getImagenFich());
    }
    
    //Funcion que marca las tablas de los jugadores
    private void marcarTablaJugador(Ficha ficha){
        
        //Recorremos todos los jugadorees
        for (MarcoJugador marcoJugador : VentanaJuego.marcoJugadores) {
            
            Jugador jugador = (Jugador) marcoJugador.getJugador();
            
            //Recorremos todas las tablas de los jugadores
            for (int j = 0; j < jugador.getTablas().size(); j++) {
                
                //Marcamos la tabla del jugador
                jugador.getTablas().get(j).marcarTabla(ficha.getNumero());
                
                //Preguntamos si esa tabla es la ganadora
                if (VentanaJuego.tipoDeJuego.verificarTablaGanadora(jugador.getTablas().get(j))) {
                    
                    JOptionPane.showMessageDialog(null, "Ha ganado el jugador "+jugador.getUsuario(), "Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
                    jugador.setPuntos(20);
                    marcoJugador.actualizarPuntos();
                    marcoJugador.setBorder(new javax.swing.border.LineBorder(ficha.getColor(), 2, true));
                    cargarTabla();
                    ganador = true;
                }
            }
        }
    }
    
    //Funcion que marca la tabla de bingo completa
    private void marcarTablaCompleta(Ficha ficha){
        
        tablaCompleta.marcarTabla(ficha.getNumero());
    }
    
    public boolean salioEsteNumero(Ficha ficha){
        
        for (Ficha fichasJugada : fichasJugadas) 
            if (fichasJugada.getNumero() == ficha.getNumero()) return true;
        
        return false;
    }
    
    public static  void pausarJuego(){
        hilo.suspend();
    }
    
    public static void resumenJuego(){
        hilo.resume();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedorTablaCompleta = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        contenedorTablas = new javax.swing.JPanel();
        paneltipoDeJuego = new javax.swing.JPanel();
        tipoDeJuegoImg = new javax.swing.JLabel();
        tipoDeJuegoName = new javax.swing.JLabel();
        panelBalotaActual = new javax.swing.JPanel();
        labelFicha = new javax.swing.JLabel();
        JLabelDichos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        contenedorTablaCompleta.setBackground(new java.awt.Color(255, 255, 255));
        contenedorTablaCompleta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 225, 225), 1, true));
        contenedorTablaCompleta.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jScrollPane2.setBorder(null);

        contenedorTablas.setLayout(new java.awt.GridLayout(1, 4, 2, 2));
        jScrollPane2.setViewportView(contenedorTablas);

        paneltipoDeJuego.setBackground(new java.awt.Color(255, 255, 255));
        paneltipoDeJuego.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 225, 225), 1, true));

        tipoDeJuegoImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipoDeJuegoImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/x_tipo_juego.png"))); // NOI18N
        tipoDeJuegoImg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tipoDeJuegoName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tipoDeJuegoName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout paneltipoDeJuegoLayout = new javax.swing.GroupLayout(paneltipoDeJuego);
        paneltipoDeJuego.setLayout(paneltipoDeJuegoLayout);
        paneltipoDeJuegoLayout.setHorizontalGroup(
            paneltipoDeJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltipoDeJuegoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneltipoDeJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tipoDeJuegoImg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(tipoDeJuegoName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        paneltipoDeJuegoLayout.setVerticalGroup(
            paneltipoDeJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltipoDeJuegoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tipoDeJuegoImg, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipoDeJuegoName, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBalotaActual.setBackground(new java.awt.Color(255, 255, 255));
        panelBalotaActual.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 225, 225), 1, true));

        labelFicha.setBackground(new java.awt.Color(255, 0, 0));
        labelFicha.setFont(new java.awt.Font("Tahoma", 1, 45)); // NOI18N
        labelFicha.setForeground(new java.awt.Color(255, 0, 0));
        labelFicha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFicha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/marco_balota_b.png"))); // NOI18N
        labelFicha.setText("24");
        labelFicha.setToolTipText("");
        labelFicha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        JLabelDichos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JLabelDichos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelBalotaActualLayout = new javax.swing.GroupLayout(panelBalotaActual);
        panelBalotaActual.setLayout(panelBalotaActualLayout);
        panelBalotaActualLayout.setHorizontalGroup(
            panelBalotaActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBalotaActualLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBalotaActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelFicha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLabelDichos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBalotaActualLayout.setVerticalGroup(
            panelBalotaActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBalotaActualLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelFicha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLabelDichos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        tabla.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setRowHeight(30);
        tabla.setRowMargin(2);
        tabla.setShowHorizontalLines(false);
        tabla.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelBalotaActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(paneltipoDeJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contenedorTablaCompleta, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(contenedorTablaCompleta, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paneltipoDeJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelBalotaActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelDichos;
    private javax.swing.JScrollPane contenedorTablaCompleta;
    private javax.swing.JPanel contenedorTablas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelFicha;
    private javax.swing.JPanel panelBalotaActual;
    private javax.swing.JPanel paneltipoDeJuego;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel tipoDeJuegoImg;
    private javax.swing.JLabel tipoDeJuegoName;
    // End of variables declaration//GEN-END:variables
}
