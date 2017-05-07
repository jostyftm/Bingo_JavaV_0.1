package Clases;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionesExtras {
    
    //Funcion que genera un numero al azar
    public static int crearNumeroAleatorio(int limite){
        return (int) (Math.random() * (0 + limite)) + 1;
    }
    
    //Funcion que verifica si un numero se encuentra en unarreglo
    public static boolean verificarNumeroEnElArreglo(int[] arreglo, int numero){
        
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i] == numero) return true;
        }
        
        return false;
    }
    
    //Funcion que valida datos numericos
    public static boolean validarNumero(String numero){
        
        try{
            
            Integer.parseInt(numero);
            
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    //Funcion que asigna una pausa
    public static void pausar(int millisegundos){
        
        try {
            Thread.sleep(millisegundos);
        } catch (InterruptedException ex) {
            Logger.getLogger(FuncionesExtras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
