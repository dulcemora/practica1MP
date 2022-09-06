package Enfrentamientos;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

/**
 * Enfrentamiento
 */
public class Enfrentamiento {

    public Pantalla pantalla;

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

    ImageIcon korbi_img = new ImageIcon("imagenes/korbi.png");
    ImageIcon megan_img = new ImageIcon("imagenes/megan.png");
    ImageIcon dittu_img = new ImageIcon("imagenes/dittu.png");

    int ronda_actual = 0;

    public Enfrentamiento(){
        
    }


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
        System.out.println("POder" + poder_ronda);
        Poder poder = poderes[poder_ronda];
        
        System.out.println("El poder de la ronda es: " + poder.getNombre());
        pantalla.poder_ronda.setText(poder.getNombre());

        actualizar_img(korbi_img, megan_img);
        ataque(korbi, meganman, poder);
        noticias_ataque(korbi, meganman);        
        dormir();

       

        actualizar_img(megan_img, dittu_img);
        actualizarSalud();
        ataque(meganman, dittuu, poder);
        noticias_ataque(meganman, dittuu);
        dormir();

        actualizar_img(dittu_img, korbi_img);
        actualizarSalud();
        ataque(dittuu, korbi, poder);
        noticias_ataque(dittuu, korbi);

        dormir();

        actualizarSalud();
        System.out.println("La salud de " + korbi.getNombre() + " es : " + korbi.getPuntos_salud());
        System.out.println("La salud de " + meganman.getNombre() + " es : " + meganman.getPuntos_salud());
        System.out.println("La salud de " + dittuu.getNombre() + " es : " + dittuu.getPuntos_salud());
    }

    private void actualizar_img(ImageIcon a, ImageIcon b){
        pantalla.atacante.setIcon(a);
        pantalla.atacado.setIcon(b);
    }

    private void actualizarSalud(){
        String salud_korbi = String.valueOf(korbi.getPuntos_salud());
        String salud_meganman = String.valueOf(meganman.getPuntos_salud());
        String salud_dittuu = String.valueOf(dittuu.getPuntos_salud());

        pantalla.sactual_p1.setText(salud_korbi);
        pantalla.sactual_p2.setText(salud_meganman);
        pantalla.sactual_p3.setText(salud_dittuu);

    }

    private void dormir(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    
    public void ataque(Personaje atacante, Personaje atacado, Poder poder){
        int atacante_poder = atacante.getPoder_inicial();
        //int atacado_poder = atacado.getPoder_inicial();

        if(poder.getPersonaje() == atacante.getId()){
            atacante_poder = atacante_poder * poder.getAumento();
        }
  
        atacado.salud_disminuye(atacante_poder);
        
        System.out.println(atacante.getNombre()+ " golpeo a "+ atacado.getNombre() );
        System.out.println();
    }
    
    public void wachadores(Observador[] wachadores){
        observadores = wachadores;
    }

    public void noticias_ataque(Personaje atacante, Personaje atacado){
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

    }


    public boolean hay_ganador(){
        for (Personaje personaje : personajes) {
            if(personaje.getPuntos_salud()<= 0){
                return true;
            }
        }
        return false;
    }
    
    public void ganador(){
        Personaje ganador = personajes[0];
        if(personajes[0].getPuntos_salud()< personajes[1].getPuntos_salud()){
            ganador = personajes[1];
        }
        if(personajes[1].getPuntos_salud()< personajes[2].getPuntos_salud()){
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

        pantalla.ganador.setVisible(true);

    }
}