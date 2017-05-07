package GUI;

import Clases.FuncionesExtras;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Tabla extends javax.swing.JPanel {
    
    private final JLabel filaB[];
    private final JLabel filaI[];
    private final JLabel filaN[];
    private final JLabel filaG[];
    private final JLabel filaO[];
    
    private final int cantidad;
    
    public Tabla(int can) {
        
        initComponents();
        
        cantidad = can;
        
        filaB = new JLabel[cantidad];
        filaI = new JLabel[cantidad];
        filaN = new JLabel[cantidad];
        filaG = new JLabel[cantidad];
        filaO = new JLabel[cantidad];
        
        configurarTabla();
    }
    
    //Funcion para configurar la tabla
    private void configurarTabla(){
        
        //Se escoge el tipo de layout dependiendo el tipo de tabla
        if(cantidad == 5) panel_numeros.setLayout(new GridLayout(5, 5, 1, 1));
        else if(cantidad == 15) panel_numeros.setLayout(new GridLayout(15, 5, 1, 1));
        
        rellenarTabla("B");
        rellenarTabla("I");
        rellenarTabla("N");
        rellenarTabla("G");
        rellenarTabla("O");
        generarTabla();
    }
    
    //Funcion que dibuja las tablas
    private void rellenarTabla(String letra){
        
        //Recorremos las dimensiones
        for (int i = 0; i < filaB.length; i++) {
            JLabel boton_numero_aleatorio = new JLabel();
            boton_numero_aleatorio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            boton_numero_aleatorio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            boton_numero_aleatorio.setMaximumSize(new java.awt.Dimension(40, 40));
            boton_numero_aleatorio.setMinimumSize(new java.awt.Dimension(40, 40));
            boton_numero_aleatorio.setPreferredSize(new java.awt.Dimension(40, 40));
            
            int numero_aleatorio = FuncionesExtras.crearNumeroAleatorio(15);
            
            /* Evaluamos el tipo de letra para determinar a q arreglo corresponde
            *  para asignar una cantidad adiccional
            *
            */
            switch (letra) {
                case "B":
                    numero_aleatorio +=0;
                    
                    if(!this.verificarNumeroRepetido(filaB, numero_aleatorio)){
                        
                        if(cantidad == 15){
                            boton_numero_aleatorio.setText(String.valueOf(i+1));
                            filaB[i] = boton_numero_aleatorio;
                        }else{
                            boton_numero_aleatorio.setText(String.valueOf(numero_aleatorio));
                            filaB[i] = boton_numero_aleatorio;
                        }
                    }else{ i--; }
                    
                    break;
                case "I":
                    numero_aleatorio +=15;
                    
                    if(!this.verificarNumeroRepetido(filaI, numero_aleatorio)){
                        
                        if(cantidad == 15){
                            boton_numero_aleatorio.setText(String.valueOf(i+1+15));
                            filaI[i] = boton_numero_aleatorio;
                        }else{
                            boton_numero_aleatorio.setText(String.valueOf(numero_aleatorio));
                            filaI[i] = boton_numero_aleatorio;
                        }
                        
                    }else{ i--; }
                    
                    break;
                case "N":
                    numero_aleatorio +=30;
                    
                    if(!this.verificarNumeroRepetido(filaN, numero_aleatorio)){
                        
                        if(cantidad == 15){
                            boton_numero_aleatorio.setText(String.valueOf(i+1+30));
                            filaN[i] = boton_numero_aleatorio;
                        }else{
                            boton_numero_aleatorio.setText(String.valueOf(numero_aleatorio));
                            filaN[i] = boton_numero_aleatorio;
                        }
                        
                    }else{ i--; }
                    
                    break;
                case "G":
                    numero_aleatorio +=45;
                    
                    if(!this.verificarNumeroRepetido(filaG, numero_aleatorio)){
                        
                        if(cantidad == 15){
                            boton_numero_aleatorio.setText(String.valueOf(i+1+45));
                            filaG[i] = boton_numero_aleatorio;
                        }else{
                            boton_numero_aleatorio.setText(String.valueOf(numero_aleatorio));
                            filaG[i] = boton_numero_aleatorio;
                        }
                        
                    }else{ i--; }
                    
                    break;
                case "O":
                    numero_aleatorio +=60;
                    
                    if(!this.verificarNumeroRepetido(filaO, numero_aleatorio)){
                        
                         if(cantidad == 15){
                            boton_numero_aleatorio.setText(String.valueOf(i+1+60));
                            filaO[i] = boton_numero_aleatorio;
                        }else{
                            boton_numero_aleatorio.setText(String.valueOf(numero_aleatorio));
                            filaO[i] = boton_numero_aleatorio;
                        }
                         
                    }else{ i--; }

                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    
    //Funcion que pinta los numeros de la tabla
    private void generarTabla(){
        
        for (int i = 0; i < filaB.length; i++) {
            panel_numeros.add(filaB[i]);
            panel_numeros.add(filaI[i]);
            panel_numeros.add(filaN[i]);
            panel_numeros.add(filaG[i]);
            panel_numeros.add(filaO[i]);
        }
        
        if(cantidad == 5){
            JLabel celdaCentro = (JLabel) panel_numeros.getComponent(12);
            celdaCentro.setText("X");
            celdaCentro.setIcon(null);
        }
    }
    
    //Verifica si un numero esta repetido en la tabla
    private boolean verificarNumeroRepetido(JLabel[] arreglo, int numero){
        
        try {
            for (JLabel boton : arreglo) {
                int numero_boton = Integer.parseInt(boton.getText());
                if(numero == numero_boton) return true;
            }
        } catch (Exception e) {
        }
        
        return false;
    }
    
    //Funcion que marca una numero de la tabla si salio
    public void marcarTabla(int numero){
        
        for (int i = 0; i < getPanel_numeros().getComponentCount(); i++) {
            
            JLabel numeroLabel = (JLabel) getPanel_numeros().getComponent(i);
            
            if(FuncionesExtras.validarNumero(numeroLabel.getText()) && Integer.parseInt(numeroLabel.getText()) == numero){
                numeroLabel.setIcon(getFichaMarcada());
                numeroLabel.setName("marcado");
            }
        }
    }
    
    //Funcion que devuele un icono con el marco para marcar la celda
    private ImageIcon getFichaMarcada(){
        return new ImageIcon(getClass().getResource("/Imagenes/marcoNumeroTabla.png"));
    }
    
    //Funcion que reseta la tabla
    public void resetarTabla(){
        
        for (int i = 0; i < getPanel_numeros().getComponentCount(); i++) {
            
            JLabel numeroLabel = (JLabel) getPanel_numeros().getComponent(i);
            numeroLabel.setIcon(null);
            numeroLabel.setName("");
        }
    }
    
    //Funcion que devuelve el panel con los numeros de la tabla
    public JPanel getPanel_numeros() {
        return panel_numeros;
    }
    
    public JPanel getTabla(){
        return this;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_letras = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panel_numeros = new javax.swing.JPanel();

        setBackground(new java.awt.Color(239, 232, 162));
        setMaximumSize(new java.awt.Dimension(230, 255));
        setMinimumSize(new java.awt.Dimension(230, 255));

        panel_letras.setBackground(new java.awt.Color(239, 232, 162));
        panel_letras.setLayout(new java.awt.GridLayout(1, 5, 1, 1));

        jLabel1.setBackground(new java.awt.Color(255, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/resplandor.png"))); // NOI18N
        jLabel1.setText("B");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(246, 245, 245), 1, true));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel1.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(40, 40));
        panel_letras.add(jLabel1);

        jLabel2.setBackground(new java.awt.Color(0, 0, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/resplandor.png"))); // NOI18N
        jLabel2.setText("I");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(246, 245, 245), 1, true));
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel2.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new java.awt.Dimension(40, 40));
        panel_letras.add(jLabel2);

        jLabel3.setBackground(new java.awt.Color(204, 0, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/resplandor.png"))); // NOI18N
        jLabel3.setText("N");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(246, 245, 245), 1, true));
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel3.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel3.setOpaque(true);
        jLabel3.setPreferredSize(new java.awt.Dimension(40, 40));
        panel_letras.add(jLabel3);

        jLabel4.setBackground(new java.awt.Color(232, 232, 4));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/resplandor.png"))); // NOI18N
        jLabel4.setText("G");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(246, 245, 245), 1, true));
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel4.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel4.setOpaque(true);
        jLabel4.setPreferredSize(new java.awt.Dimension(40, 40));
        panel_letras.add(jLabel4);

        jLabel5.setBackground(new java.awt.Color(0, 204, 51));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/resplandor.png"))); // NOI18N
        jLabel5.setText("O");
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(246, 245, 245), 1, true));
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel5.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel5.setOpaque(true);
        jLabel5.setPreferredSize(new java.awt.Dimension(40, 40));
        panel_letras.add(jLabel5);

        panel_numeros.setBackground(new java.awt.Color(239, 232, 162));
        panel_numeros.setPreferredSize(new java.awt.Dimension(0, 210));

        javax.swing.GroupLayout panel_numerosLayout = new javax.swing.GroupLayout(panel_numeros);
        panel_numeros.setLayout(panel_numerosLayout);
        panel_numerosLayout.setHorizontalGroup(
            panel_numerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel_numerosLayout.setVerticalGroup(
            panel_numerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_numeros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
            .addComponent(panel_letras, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_letras, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_numeros, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panel_letras;
    private javax.swing.JPanel panel_numeros;
    // End of variables declaration//GEN-END:variables
}
