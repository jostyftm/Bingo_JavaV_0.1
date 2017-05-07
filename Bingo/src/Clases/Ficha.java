package Clases;

import java.awt.Color;
import javax.swing.ImageIcon;


public class Ficha {
    
    private String letra;
    
    //Dichos que tiene cada ficha
    private final String[] dichos = {
        "22_paticos", "33_edad de cristo", "14_caturenlo", "1_pipi", "15_quincieañera",
        "28_venus", "75_mayor domo", "10_pelado", "18_cedula"
    };
    
    private String dicho;
    private boolean tieneDicho;
    
    private int numero;
    private Color color;
    
    public Ficha(int num){
        
        numero = num;
        tieneDicho = false;
        dicho = "";
        elegirLetra();
    }
    
    //Funcion que elige el tipo de letra y un color dependiendo el numero
    private void elegirLetra(){
    
        if(numero > 0 && numero <= 15 ){
            letra = "b";
            color = new Color(255,0,0);
        }else if(numero > 15 && numero <= 30){
            letra = "i";
            color = new Color(0,0,255);
        }else if(numero > 30 && numero <= 45){
            letra = "n";
             color = new Color(204,0,204);
        }else if(numero > 45 && numero <= 60){
            letra = "g";
            color = new Color(232,232,4);
        }else if(numero > 60 && numero <= 75){
            letra = "o";
            color = new Color(0,204,51);
        }
        
        //Obtenemos el dichos dependiendo el numero generado
        configurarDicho();
    }

    public String getLetra() {
        return letra;
    }

    public int getNumero() {
        return numero;
    }

    public Color getColor() {
        return color;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    //Funcion que devuelve el marco cuando se marca un numero
    public ImageIcon getImagenFich(){
        return new ImageIcon(getClass().getResource("/Imagenes/marco_balota_"+getLetra()+".png"));
    }
    
    public boolean tieneDicho(){
        return tieneDicho;
    }
    
    public String getDicho(){
        return dicho;
    }
    
    // Funcion que determina el dicho
    private void configurarDicho(){
        
        for (int i = 0; i < dichos.length; i++) {
            int numero_dicho = Integer.parseInt( dichos[i].split("_")[0] );
            
            if(numero == numero_dicho){
                
                tieneDicho = true;
                dicho = dichos[i].split("_")[1];
            }
        }
    }
}
