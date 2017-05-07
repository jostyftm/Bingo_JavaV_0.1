
package Clases;

import GUI.Tabla;
import java.util.ArrayList;


public class Jugador {
    
    private String usuario;
    private int numero_de_tablas;
    private int puntos;
    
    private final ArrayList<Tabla> tablas;
        
    public Jugador(String usu){
        
        this.usuario = usu;
        this.numero_de_tablas = 1;
        this.puntos = 0;
        
        this.tablas = new ArrayList<>();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos += puntos;
    }

    public ArrayList<Tabla> getTablas() {
        return tablas;
    }
    
    //Funcion que genera tablas dependiendo el nuemro de tablas asignados
    private void setTablas() {
        
        for (int i = 0; i < this.numero_de_tablas; i++) {
            this.tablas.add(new Tabla(5));
        }
    }

    public int getNumero_de_tablas() {
        return numero_de_tablas;
    }

    public void setNumero_de_tablas(int numero_de_tablas) {
        this.numero_de_tablas = numero_de_tablas;
        
        this.setTablas();
    }
}
