package Enfrentamientos;

import java.util.ArrayList;
import java.util.Random;

/**
 * Enfrentamiento
 */
public class Enfrentamiento {



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


    public void ronda(){

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
        
        ataque(korbi, meganman, poder);
        noticias_ataque(korbi, meganman);
        ataque(meganman, dittuu, poder);
        noticias_ataque(meganman, dittuu);
        ataque(dittuu, korbi, poder);
        noticias_ataque(dittuu, korbi);
        
        System.out.println("La salud de " + korbi.getNombre() + " es : " + korbi.getPuntos_salud());
        System.out.println("La salud de " + meganman.getNombre() + " es : " + meganman.getPuntos_salud());
        System.out.println("La salud de " + dittuu.getNombre() + " es : " + dittuu.getPuntos_salud());
    }
    
    public void ataque(Personaje atacante, Personaje atacado, Poder poder){
        int atacante_poder = atacante.getPoder_inicial();
        //int atacado_poder = atacado.getPoder_inicial();

        if(poder.getPersonaje() == atacante.getId()){
            atacante_poder = atacante_poder * poder.getAumento();
        }
        /**if(poder.personaje == atacado.getId()){
            atacado_poder = atacado_poder * poder.aumento;
        }*/
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


    
    
}