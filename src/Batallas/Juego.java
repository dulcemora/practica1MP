package Batallas;

/**
 * Juego
 * Clase que inicializa un juego para que haya un enfrentamiento, termina cuando haya un ganador
 * @author Giovanny Cruz
 * @author Dulce Mora
 * @author Marcos Noriega
 * @version 1.0
 */ 

import java.awt.*;
import javax.swing.*;
import javax.xml.validation.Validator;

public class Juego{
    
    //static Pantalla pantalla = new Pantalla();
    
    


    /**
     * Metodo main donde se ejecuta la simulacion del programa
     */
    public static void main(String[] args) {
        Enfrentamiento combate = new Enfrentamiento();

        while(!combate.hay_ganador()){
            combate.ronda_actual++;
            combate.ronda();
        }
        combate.ganador();
    }

}
