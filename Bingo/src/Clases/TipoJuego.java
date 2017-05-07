package Clases;

import GUI.Tabla;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TipoJuego {
    
    //Tipos de juegos
    private static final int[] LETRA_X = {0,4,6,8,16,18,20,24};
    private static final int[] LETRA_O = {0,1,2,3,4,5,9,10,14,15,19,20,21,22,23,24};
    private static final int[] LETRA_U = {0,4,5,9,10,14,15,19,20,21,22,23,24};
    private static final int[] LETRA_L = {0,5,10,15,20,21,22,23,24};
    private static final int[] LETRA_T = {0,1,2,3,4,7,17,22};
    private static final int[] SIGNO_MAS = {2,7,10,11,13,14,17,22};
    private static final int[] TABLA_LLENA = {0,1,2,3,4,5,6,7,8,9,10,11,13,14,15,16,17,18,19,20,21,22,23,24};
    
    public final String tipoDeJuegosDisponibles[] = {"Letra x", "Letra o", "Letra u", "Letra t", "Tabla llena", "Signo +"};
            
    private int[] juegoACtivo;
    private String tipoDeJuego;
    private String nombreDeJuego;
    private File carpeta;
    
    
    public TipoJuego(){
    
    }

    public int[] getJuegoACtivo() {
        return juegoACtivo;
    }

    public void setJuegoACtivo(int[] juegoACtivo) {
        this.juegoACtivo = juegoACtivo;
    }

    public String getTipoDeJuego() {
        return tipoDeJuego;
    }
    
    //Funcion que asigna el tipo de juego
    private void setTipoDeJuego(String tipoDeJuego) {
        this.tipoDeJuego = tipoDeJuego;
        
        switch (tipoDeJuego) {
            case "x":
                setJuegoACtivo(LETRA_X);
                break;
            case "o":
                setJuegoACtivo(LETRA_O);
                break;
            case "u":
                setJuegoACtivo(LETRA_U);
                break;
            case "l":
                setJuegoACtivo(LETRA_L);
                break;
            case "t":
                setJuegoACtivo(LETRA_T);
                break;
            case "+":
                setJuegoACtivo(SIGNO_MAS);
                break;
            case "llena":
                setJuegoACtivo(TABLA_LLENA);
                break;
            default:
                throw new AssertionError();
        }
    }

    public String getNombreDeJuego() {
        return nombreDeJuego;
    }

    public void setNombreDeJuego(String nombreDeJuego) {
        this.nombreDeJuego = nombreDeJuego;
        
        setTipoDeJuego(nombreDeJuego.split(" ")[1]);
    }

    public File getCarpeta() {
        return carpeta;
    }
    
    public void setCarpeta(File carpeta) {
        this.carpeta = carpeta;
    }

    public String[] getTipoDeJuegosDisponibles() {
        return tipoDeJuegosDisponibles;
    }
    
    public ImageIcon getImagenTipoDeJuego(){
        return new ImageIcon(getClass().getResource("/Imagenes/"+getTipoDeJuego()+"_tipo_juego.png"));
    }
    
    //Funcion que verifica si una tabla es ganadora
    public boolean verificarTablaGanadora(Tabla panelNumeros){
        
        try {
            int coincidencia=0;
        
            JPanel tabladeNumeros = panelNumeros.getPanel_numeros();
            
            for (int i = 0; i < tabladeNumeros.getComponentCount(); i++) {
                JLabel numeroCelda = (JLabel) tabladeNumeros.getComponent(juegoACtivo[i]);
                
                if(numeroCelda.getName().equals("marcado")) coincidencia++;
                
                if(coincidencia == juegoACtivo.length) return true;
            }
            
        } catch (Exception e) {
        }
        
        return false;
    }
}
