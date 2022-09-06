package Enfrentamientos;

import javax.swing.*;

public class Juego{
    
    static Pantalla pantalla = new Pantalla();
    
    public static void bienvenida(){
        pantalla.setBounds(0,0,800,800);
        pantalla.setVisible(true);
        pantalla.setResizable(false);
        pantalla.setLocationRelativeTo(null);
    }


    public static void main(String[] args) {
        bienvenida();
        Enfrentamiento combate = new Enfrentamiento();
        combate.pantalla = pantalla;
        for (int i = 0; i < 5; i++) {
            combate.ronda_actual++;
            combate.ronda();

        }
        
    }

}