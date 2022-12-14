package Batallas;

/**
 * Batallas
 * Clase para el manejo de las batallas
 * @author Giovanny Cruz
 * @author Dulce Mora
 * @author Marcos Noriega
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

/**
 * Enfrentamiento
 */
public class Enfrentamiento {

    //public Pantalla pantalla;

    Personaje korbi = new Personaje("Korbi", 0);
    Personaje meganman = new Personaje("Meganman",1);
    Personaje dittuu = new Personaje("Dittuu", 2);
    Personaje[] personajes = {korbi, meganman, dittuu};

    
    Poder poder_d_1 = new Poder("Amienemigos", 0, 0, 2);
    Poder poder_d_2 = new Poder("Inflaso", 0, 1, 3);
    Poder poder_d_3 = new Poder("Amimir", 0, 2, 4);

    Poder poder_k_1 = new Poder("BoomBoom", 1, 3, 2);
    Poder poder_k_2 = new Poder("PorLaTangente", 1, 4, 3);
    Poder poder_k_3 = new Poder("HechoLaMocha", 1, 5, 4);

    Poder poder_m_1 = new Poder("Farsante", 2, 6, 2);
    Poder poder_m_2 = new Poder("Bostezo", 2, 7, 3);
    Poder poder_m_3 = new Poder("Chamuscado", 2, 8, 4);

    Poder[] poderes = {poder_d_1, poder_d_2, poder_d_3, poder_k_1, poder_k_2, poder_k_3, poder_m_1, poder_m_2, poder_m_3};

    Observador observador1 = new Observador(0, "Julieta", korbi);
    Observador observador2 = new Observador(1, "Paola", meganman);
    Observador observador3 = new Observador(2, "Marcos", dittuu);
    Observador observador4 = new Observador(3, "Giovanny", meganman);
    
    Observador[] observadores = {observador1, observador2, observador3, observador4};

    ImageIcon korbi_img = new ImageIcon("src/imagenes/korbi.png");
    ImageIcon megan_img = new ImageIcon("src/imagenes/megan.png");
    ImageIcon dittu_img = new ImageIcon("src/imagenes/dittu.png");

    Pantalla pantalla = new Pantalla();

    int ronda_actual = 0;

    /**
     * Metodo para iniciar las funciones basicas del programa, bienvenida y asignar el personaje que seguirá el observador
     */

    public Enfrentamiento(){
        bienvenida();
        asignarSeguidores();
    }

    /**
     * Asigna el personaje elegido por el observador a este
     */

    public void asignarSeguidores(){
        for (Observador observador : observadores) {
            observador.getPersonaje_a_seguir().agregarSeguidor(observador);
        }
    }

    /**
     * Inicializa los elementos básicos para que el programa funcione
     */

    public void bienvenida(){
        pantalla.setBounds(0,0,800,800);
        pantalla.setVisible(true);
        pantalla.setResizable(false);
        pantalla.setLocationRelativeTo(null);
    }

    /**
     * Metodo que mantiene el control de las rondas (salud de los personajes, poderes, mostrar en pantalla lo debido a cada ronda)
     */

    public void ronda(){
        
        actualizarSalud();
        pantalla.ronda.setText("Ronda numero: "+ ronda_actual);
        /**for (Poder poder : poderes) {
            System.out.println(poder.getNombre());
        }*/

        System.out.println("La salud de " + korbi.getNombre() + " es : " + korbi.getPuntos_salud());
        System.out.println("La salud de " + meganman.getNombre() + " es : " + meganman.getPuntos_salud());
        System.out.println("La salud de " + dittuu.getNombre() + " es : " + dittuu.getPuntos_salud());


        Random rd = new Random();
        int poder_ronda = rd.nextInt(8);
        System.out.println("Poder " + poder_ronda);
        Poder poder = poderes[poder_ronda];
        
        System.out.println("El poder de la ronda es: " + poder.getNombre());
        pantalla.poder_ronda.setText(poder.getNombre());
        actualizar_ataque(poder);

        actualizar_img(korbi_img, megan_img);
        ataca(korbi, meganman, poder);
        //noticias_ataque(korbi, meganman);        
        dormir();
       

        actualizar_img(megan_img, dittu_img);
        actualizarSalud();
        ataca(meganman, dittuu, poder);
        //noticias_ataque(meganman, dittuu);
        dormir();

        actualizar_img(dittu_img, korbi_img);
        actualizarSalud();
        ataca(dittuu, korbi, poder);
        //noticias_ataque(dittuu, korbi);

        dormir();

        actualizarSalud();
        System.out.println("La salud de " + korbi.getNombre() + " es : " + korbi.getPuntos_salud());
        System.out.println("La salud de " + meganman.getNombre() + " es : " + meganman.getPuntos_salud());
        System.out.println("La salud de " + dittuu.getNombre() + " es : " + dittuu.getPuntos_salud());

        restaurarPoder();
    }

    /**
     * Actualiza las imagenes siguiendo qué personaje ataca a cuál
     * @param a Imagen del personaje aatacante
     * @param b Imagen del personaje atacado
     */

    private void actualizar_img(ImageIcon a, ImageIcon b){
        pantalla.atacante.setIcon(a);
        pantalla.atacado.setIcon(b);
    }

    /** 
     * Muestra en pantalla la salud de cada personaje respecto a la ronda en la que se encuentran
    */

    private void actualizarSalud(){
        String salud_korbi = String.valueOf(korbi.getPuntos_salud());
        String salud_meganman = String.valueOf(meganman.getPuntos_salud());
        String salud_dittuu = String.valueOf(dittuu.getPuntos_salud());

        pantalla.sactual_p1.setText(salud_korbi);
        pantalla.sactual_p2.setText(salud_meganman);
        pantalla.sactual_p3.setText(salud_dittuu);

    }

    /** 
     * Metodo que permite dormir un hilo por una cantidad de 1000 milisegundos
    */

    private void dormir(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Metodo que controla los ataques entre personajes, asi como el daño del ataque
     * @param atacante El personaje que suelta el ataque
     * @param atacado El personaje que recibe el golpe del atacante
     * @param poder Tipo de poder que se ejecuta, para calcular su daño
    */
    
    public void ataca(Personaje atacante, Personaje atacado, Poder poder){
        if(poder.getPersonaje() != atacante.getId()){
            AtaqueNormal ataque = new AtaqueNormal();
            ataque.atacando(atacante, atacado);
        }else{
            if(poder.getAumento()== 2){
                AtaqueEspecial ataque = new AtaqueEspecial();
                ataque.atacando(atacante, atacado);
            }
            if(poder.getAumento()==3){
                AtaqueSuper ataque = new AtaqueSuper();
                ataque.atacando(atacante, atacado);
            }
            if(poder.getAumento()==4){
                AtaqueMagnifico ataque = new AtaqueMagnifico();
                ataque.atacando(atacante, atacado);
            }
        }
    }

    /**
     * Actualiza los poderes que podrían tener los personajes en cada ronda
     * @param poder
     */


    public void actualizar_ataque(Poder poder){
        if(poder.getPersonaje() == personajes[0].getId()){
            String nuevo_poder = String.valueOf(100*poder.getAumento());
            pantalla.ataque_p1_ac.setText(nuevo_poder);
        }
        if(poder.getPersonaje() == personajes[1].getId()){
            String nuevo_poder = String.valueOf(100*poder.getAumento());
            pantalla.ataque_p2_ac.setText(nuevo_poder);
        }
        if(poder.getPersonaje() == personajes[2].getId()){
            String nuevo_poder = String.valueOf(100*poder.getAumento());
            pantalla.ataque_p3_ac.setText(nuevo_poder);
        }
    }

    /** 
     * Restaura el daño de cada ataque a 100 despues de usar un daño mayor
    */

    public void restaurarPoder(){
        pantalla.ataque_p1_ac.setText("100");
        pantalla.ataque_p2_ac.setText("100");
        pantalla.ataque_p3_ac.setText("100");
    }
    


    /*public void noticias_ataque(Personaje atacante, Personaje atacado){
        for (Observador observador : observadores) {
            if(observador.getPersonaje_a_seguir().getId() == atacante.getId()){
                observador.update_ataque(atacado);
            }
        }
        
        for (Observador observador : observadores) {
            if(observador.getPersonaje_a_seguir().getId() == atacado.getId()){
                observador.update_amenaza(atacante);
            }
        }

    }*/


    
    /**
     * Metodo que verifica si algun personaje fue derrotado para sacar un ganador
     * @return True si un personaje fue derrotado, false en caso contrario
     */

    public boolean hay_ganador(){
        for (Personaje personaje : personajes) {
            if(personaje.getPuntos_salud()<= 0){
                return true;
            }
        }
        return false;
    }

    /** 
     * Metodo que verifica y actualiza la pantalla con imagen y nombre del personaje ganador
    */
    
    public void ganador(){
        Personaje ganador = personajes[0];
        if(ganador.getPuntos_salud()< personajes[1].getPuntos_salud()){
            ganador = personajes[1];
        }
        if(ganador.getPuntos_salud() < personajes[2].getPuntos_salud()){
            ganador = personajes[2];
        }

        pantalla.atacante.setVisible(false);
        pantalla.atacado.setVisible(false);
        pantalla.versus.setVisible(false);
        
        if(ganador == korbi){
            pantalla.ganador.setIcon(korbi_img);
        }
        if(ganador == meganman){
            pantalla.ganador.setIcon(megan_img);
        }
        if(ganador == dittuu){
            pantalla.ganador.setIcon(dittu_img);
        }
        pantalla.poder.setText("!!!!!EL GANADOR ES " + ganador.getNombre().toUpperCase() + "!!!!!");
        pantalla.poder_ronda.setVisible(false);
        pantalla.ganador.setVisible(true);

        AvisaGanador noticia = new AvisaGanador();
        noticia.avisa(ganador);

        for (Personaje personaje : personajes) {
            if(personaje.getId() != ganador.getId()){
                AvisaPerdedor noticia_perdedor = new AvisaPerdedor();
                noticia_perdedor.avisa(personaje);
            }
        }
    }
}
