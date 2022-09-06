package Batallas;

import java.awt.*;
import javax.swing.*;
import javax.xml.validation.Validator;

public class Juego{
    
    //static Pantalla pantalla = new Pantalla();
    
    



    public static void main(String[] args) {
        Enfrentamiento combate = new Enfrentamiento();

        while(!combate.hay_ganador()){
            combate.ronda_actual++;
            combate.ronda();
        }
        combate.ganador();
    }

}