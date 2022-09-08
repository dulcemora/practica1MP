package Batallas;

/**
 * Ataque
 * Interface para manejar los ataques entre los personajes
 * @author Giovanny Cruz
 * @author Dulce Mora
 * @author Marcos Noriega
 * @version 1.0
 */ 

public interface Ataque {

    /** 
     * Metodo que maneja qué personaje ataca a qué personaje
     * @param atacante Personaje que lanza el ataque a atacado
     * @param atacado Personaje que recibe el ataque del atacante
     */
    public void atacando(Personaje atacante, Personaje atacado);
}
