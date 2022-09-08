package Batallas;

/**
 * AvisaGanador
 * Clase para imprimir en pantalla el nombre del ganador y enviarlo al observador
 * @author Giovanny Cruz
 * @author Dulce Mora
 * @author Marcos Noriega
 * @version 1.0
 * @see Noticia
 */ 

public class AvisaGanador implements Noticia {
    
    @Override
    /**
     * Metodo que notifica si hay ganador y quien ha sido
     * @param personaje Personaje que peleara en los enfrentamientos
     */
    public void avisa(Personaje personaje) {
        // TODO Auto-generated method stub
        String text = "!!!!!EL GANADOR HA SIDO " + personaje.getNombre().toUpperCase() + "!!!!!";
        for (Observador observador : personaje.seguidores) {
            observador.escribir("");
            observador.escribir(text);
        }
    }
}
