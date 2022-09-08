package Batallas;

/**
 * NotiAtaqueSuper
 * Clase que notifica cuando un personaje lanza un ataque super a otro personaje, lanzando texto en pantalla
 * @author Giovanny Cruz
 * @author Dulce Mora
 * @author Marcos Noriega
 * @version 1.0
 * @see NotiAtaque
 */

public class NotiAtaqueSuper implements NotiAtaque{

    

    @Override
    /**
     *Metodo que indica que personaje esta atacando a cual con un poder super
     **/
    public void noti_ataque(Personaje atacante, Personaje atacado) {
        // TODO Auto-generated method stub
        String texto = atacante.getNombre() +" ataca a " + atacado.getNombre() + " con un poder SUPER";  
        for (Observador observador : atacante.seguidores) {
            observador.escribir("");
            observador.escribir(texto);
        }
        texto = "!!OH NO!! " + atacante.getNombre() + " ha atacado a tu heróe con un poder SUPER" ; 
        for (Observador observador : atacado.seguidores) {
            observador.escribir("");
            observador.escribir(texto);
            observador.salud();
        }
    }
}
